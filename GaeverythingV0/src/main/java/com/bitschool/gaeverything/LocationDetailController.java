package com.bitschool.gaeverything;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.bitschool.dto.DetailCommentDTO;
import com.bitschool.dto.LocationDTO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.service.LocationDetailService;

@RequestMapping(value = "map/detail")
@Controller
public class LocationDetailController {
	
	@Inject
	LocationDetailService service;
	//������ ������ ����
	@RequestMapping(value = "/viewDetailPage", method = RequestMethod.GET)
	public String viewDetailPage(HttpServletRequest request, @RequestParam(value="locationSeq") int locationSeq,
			Model model){
		String url = "map/map_detailpage";
		LocationDTO dto = new LocationDTO();	
		MemberDTO member = (MemberDTO) request.getSession().getAttribute("member");
		dto = service.selectOne(locationSeq);		
		List<DetailCommentDTO> list = service.commentList(locationSeq);		
		model.addAttribute("commentlist",list);
		model.addAttribute("detail", dto);	
		model.addAttribute("member",member);
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
	

}
