package com.bitschool.gaeverything;


import java.util.List;

import javax.inject.Inject;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitschool.dto.ActUserDTO;
import com.bitschool.dto.BoardDTO;
import com.bitschool.dto.DetailCommentDTO;
import com.bitschool.dto.LocationDTO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.service.ActUserService;
import com.bitschool.service.LocationDetailService;
import com.bitschool.utils.ActUserManager;
import com.bitschool.utils.LoginFilter;

@RequestMapping(value = "map/detail")
@Controller
public class LocationDetailController {
	
	@Inject
	private LocationDetailService service;
	
	@Inject
	private ActUserService aService;
	
	//������ ���䵥����
	@RequestMapping(value = "/getReviewData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody List<DetailCommentDTO> getReviewData(@RequestParam(value="locationSeq") int locationSeq){
		List<DetailCommentDTO> commentlist = service.commentList(locationSeq);	
		return commentlist;
	}
	
	//������ ������ ����
	@RequestMapping(value = "/viewDetailPage", method = RequestMethod.GET)
	public String viewDetailPage(HttpServletRequest request, 
			@RequestParam(value="locationSeq") int locationSeq, 
			HttpSession session,
			Model model){
		
		//�α��� ����
		boolean isLogin = new LoginFilter().isLogin(session, model);
		ActUserManager manager = new ActUserManager(aService);
		String url = "map/map_detailpage";
		LocationDTO dto = new LocationDTO();		
		int countReview = service.countReviews(locationSeq);	
		double averageRatings = service.getAverageRatings(service.getRatings(locationSeq),service.getReplyRatings(locationSeq));
		averageRatings=(Double.isNaN(averageRatings))?0:averageRatings;
		String temp = String.format("%.2f", averageRatings);
		int countRatings = service.getRatings(locationSeq).size()+service.getReplyRatings(locationSeq).size();
		int countReplies = service.countReplies(locationSeq);
		dto = service.selectOne(locationSeq);		
		List<BoardDTO> reviewList = service.getReviews(locationSeq);
		List<DetailCommentDTO> list = service.commentList(locationSeq);
		
		//���ƿ� ���� ����
		if(isLogin){
			MemberDTO member = (MemberDTO)session.getAttribute("member");
			ActUserDTO aDTO = new ActUserDTO(member.getEmail(), ActUserManager.SHOP, locationSeq);
			dto= manager.checkLikeStatus(aDTO, dto);
		}
		
		//������  ������ ���ƿ� ī��Ʈ  
		int likeCount = manager.getLikeStatusCount(new ActUserDTO(ActUserManager.SHOP, locationSeq));
		
		model.addAttribute("commentlist",list);
		model.addAttribute("detail", dto);	
		model.addAttribute("countReview",countReview);
		model.addAttribute("averageRatings",temp);
		model.addAttribute("countRatings",countRatings);
		model.addAttribute("countReplies",countReplies);
		model.addAttribute("reviewList",reviewList);
		model.addAttribute("likeCount", likeCount);
		
		System.out.println("��� ����Ʈ : "+list);
		System.out.println("detail : "+dto);
		return url;
	}
	
	
	//��� ���
	@RequestMapping(value="/addComment",method=RequestMethod.POST)
	public String addComment(HttpSession session,Model model,
			DetailCommentDTO dto){
		String url = null;
		System.out.println("addComment�� ����");
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		dto.setNickname(member.getNickname());
		dto.setPhoto(member.getPhoto());
		System.out.println("dto : "+dto);
		boolean flag = service.commentAdd(dto);
		if(flag){
			url = "redirect:viewDetailPage?locationSeq="+dto.getLocationSeq();
			System.out.println("addComment ����");
			System.out.println("���dto : "+dto);
		}
		return url;
	}
	
	//��� �����ϴ� ������
	@RequestMapping(value="/viewEditComment",method={RequestMethod.GET,RequestMethod.POST})
	public String viewEditComment(HttpSession session,Model model,@RequestParam(value="locationSeq2") int locationSeq){
		String url = null;
		url = "map/map_detailpage2";
		LocationDTO dto = new LocationDTO();	
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		dto = service.selectOne(locationSeq);		
		List<DetailCommentDTO> list = service.commentList(locationSeq);		
		model.addAttribute("commentlist",list);
		model.addAttribute("detail", dto);	
		model.addAttribute("member",member);
		return url;
	}
	
	
	//��� ����	
	@RequestMapping(value="/editComment",method=RequestMethod.POST)
	public String editComment(HttpSession session,Model model,
			DetailCommentDTO dto){
		String url = null;
		System.out.println("editComment�� ����");
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		dto.setNickname(member.getNickname());
		dto.setPhoto(member.getPhoto());
		System.out.println("������ ��� dto : "+dto);
		boolean flag = service.commentEdit(dto);
		if(flag){
			url = "redirect:viewDetailPage?locationSeq="+dto.getLocationSeq();
			System.out.println("editComment ����");
			System.out.println("���dto : "+dto);
		}
		return url;
	}
	
	//��� ����
	@RequestMapping(value="/deleteComment",method=RequestMethod.POST)
	public String deleteComment(HttpSession session,Model model,
			@RequestParam(value="commentSeq") int commentSeq,@RequestParam(value="locationSeq") int locationSeq){
		String url = null;
		System.out.println("deleteComment�� ����");
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		DetailCommentDTO dto = new DetailCommentDTO();
		dto.setNickname(member.getNickname());
		dto.setCommentSeq(commentSeq);
		boolean flag = service.commentDelete(dto);
		if(flag){
			url = "redirect:viewDetailPage?locationSeq="+locationSeq;
			System.out.println("deleteComment ����");
		}
		return url;
	}
	

	

}
