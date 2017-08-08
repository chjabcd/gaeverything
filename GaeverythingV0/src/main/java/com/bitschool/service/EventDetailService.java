package com.bitschool.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.dao.EventDetailDAO;
import com.bitschool.dto.ActUserDTO;
import com.bitschool.dto.BlogDTO;
import com.bitschool.dto.BoardDTO;
import com.bitschool.dto.EventCommentDTO;
import com.bitschool.dto.EventPhotoDTO;
import com.bitschool.dto.EventDTO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.utils.ActUserManager;

@Service
public class EventDetailService {

	@Inject
	private EventDetailDAO dao;
	
	public EventDTO selectOne(int seq){
		EventDTO dto = null;
		try {
			dto = dao.selectOne(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public boolean commentAdd(EventCommentDTO dto){
		boolean flag = false;
		try {
			flag = dao.commentAdd(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean photoAdd(EventPhotoDTO dto) {
		boolean flag = false;
		try {
			flag = dao.photoAdd(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	// ���� ���� �����ֱ�
	public int photoCnt(int eventNo){
		int PCnt = 0;
		try {
			PCnt = dao.photoCnt(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return PCnt;
	}
		
	
	public List<EventCommentDTO> commentList(int eventNo){
		List<EventCommentDTO> dto = null;
		try {
			dto = dao.commentList(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}
	
	public boolean updatePhoto(MemberDTO member){
		boolean flag = false;
		try {
			flag = dao.updatePhoto(member);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	public List<EventPhotoDTO> selectPhoto(int eventNo) {
		List<EventPhotoDTO> list = null;
		try {
			list = dao.selectPhoto(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public boolean commentEdit(EventCommentDTO dto){
		boolean flag = false;
		try {
			flag = dao.commentEdit(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}

	public boolean commentDelete(EventCommentDTO dto){
		boolean flag = false;
		try {
			flag = dao.commentDelete(dto);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return flag;
	}
	/* �Խ��ǰ���
	public int countReviews(int eventNo){
		int count = 0;
		try {
			count = dao.countReviews(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	public List<Double> getRatings(int eventNo){
		List<Double> ratings = null;
		try {
			ratings = dao.getRatings(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ratings;
	}*/	
	
	public List<Double> getReplyRatings(int eventNo){
		List<Double> ratings = null;
		try {
			ratings = dao.getReplyRatings(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ratings;
	}
	
	public double getAverageRatings(List<Double> ratings1, List<Double> ratings2){
		double average = 0;
		double sum1 = 0;
		double sum2 = 0;
		for(int i=0;i<ratings1.size();i++){
			sum1 = sum1 + ratings1.get(i);
		}
		for(int i=0;i<ratings2.size();i++){
			sum2 = sum2 + ratings2.get(i);
		}		
		average = (sum1+sum2)/(ratings1.size()+ratings2.size());
		return average;
	}
	
	public int countReplies(int eventNo){
		int count = 0;
		try {
			count = dao.countReplies(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
	
	/*public List<BoardDTO> getReviews(int eventNo){
		List<BoardDTO> dto = null;
		try {
			dto = dao.getReviews(eventNo);
			int countCmt = 0;
			for(int i=0;i<dto.size();i++){
				countCmt = bdao.countCmt(dto.get(i).getBoardNo());
				dto.get(i).setNumOfCmt(countCmt);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dto;
	}
	

	public List<BlogDTO> getBlogReviews(int eventNo){
		List<BlogDTO> dto = null;
		try {
			dto = dao.getBlogReviews(eventNo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}

	public EventDTO getEventActUserResult(ActUserManager manager, EventDTO dto) {
		// TODO Auto-generated method stub
		int countReview = this.countReviews(dto.getEventNo());	
		
		double averageRatings = this.getAverageRatings(this.getRatings(dto.getEventNo()),this.getReplyRatings(dto.getEventNo()));
		averageRatings=(Double.isNaN(averageRatings))?0:averageRatings;
		String temp = String.format("%.2f", averageRatings);
		
		int countRatings = this.getRatings(dto.getEventNo()).size()+this.getReplyRatings(dto.getEventNo()).size();
		int countReplies = this.countReplies(dto.getEventNo());
		int countLike = manager.getLikeStatusCount(new ActUserDTO(ActUserManager.SHOP, dto.getEventNo()));
		
		dto.setActUserResult(countReview, temp, countRatings, countReplies, countLike);
		
		return dto;
	}

	public List<EventDTO> getEventActUserResults(ActUserManager manager, List<EventDTO> list) {
		for(int i=0;i<list.size();i++){
			this.getEventActUserResult(manager, list.get(i));
		}
		return list;
	}*/
		
	public List<EventPhotoDTO> photoList(int seq){
		List<EventPhotoDTO> dto = null;
		try {
			dto = dao.photoList(seq);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return dto;
	}



	
	

}
