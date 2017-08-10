package com.bitschool.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.dao.BoardDAO;
import com.bitschool.dao.MyPageDAO;
import com.bitschool.dto.BoardDTO;
import com.bitschool.dto.CommentDTO;
import com.bitschool.dto.DetailCommentDTO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.dto.MyPageDTO;

@Service
public class MyPageService {
	
	@Inject
	private MyPageDAO mdao;
	
	@Inject
	private BoardDAO bdao;
	
	// ���� ���侴 �� ����(�ʵ������� ��� �Ǵ� ����Խ����� ��) �������� (�ߺ�X) 
	public int countLocReviews(String nickname){
		int count = 0;
		try {
			count = mdao.countLocReviews(nickname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	//�ϸ�ũ�� ��������
	public int getTotalLike(int boardno){
		int like = 0;
		try {
			like = bdao.getTotalLike(boardno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return like;
	}
	
	// ���� �� ���(�Խ��Ǹ���)�� ���� ���� ��������
	public String selectBoardTitle(int groupno){
		String title = null;
		try {
			title = mdao.selectBoardTitle(groupno);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}
	
	// ���� �� ���(�Խ��Ǹ���) ��ƺ��� 
	public List<CommentDTO> selectMyBoardComments(String nickname){
		List<CommentDTO> list = null;
		try {
			list = mdao.selectMyBoardComments(nickname);
			for(int i=0;i<list.size();i++){
				String title = this.selectBoardTitle(list.get(i).getGroupNo());
				list.get(i).setTitle(title);
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	
	// ��ȣ�� �������ֱ� ���� 
	public String selectShopName(int locationSeq){
		String address = null;
		try {
			address = mdao.selectShopName(locationSeq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return address;
	}
	
	// ���� �� ���(�ʵ�����) ��ƺ��� 
	public List<DetailCommentDTO> selectMyDetailComments(String nickname){
		List<DetailCommentDTO> list = null;
		try {
			list = mdao.selectMyDetailComments(nickname);
			for(int i=0;i<list.size();i++){
				list.get(i).setAddress(this.selectShopName(list.get(i).getLocationSeq()));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}	
	
	// ���� �� ���� ��ƺ��� 
	public List<BoardDTO> selectMyReviews(String nickname){
		List<BoardDTO> list = null;
		try {
			list = mdao.selectMyReviews(nickname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	//photo ������ memberDTO�� photo�� �ٲ��
	public boolean updateMemData(MyPageDTO dto) {
		// TODO Auto-generated method stub
		boolean flag = false;
		try {
			flag = mdao.modifyMemData(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	
	//ȸ������ ����(photo�� �������� ���� ��)
	public boolean updateData2(MyPageDTO member){
		System.out.println("MyPageService-updateData2�� ���Դ�");
		boolean flag = false;
		try {
			flag = mdao.modifyData2(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}
	
	//ȸ������ ����
	public boolean updateData(MyPageDTO member) {
		// TODO Auto-generated method stub
		System.out.println("MyPageService-updateData�� ���Դ�");
		boolean flag = false;
		try {
			flag = mdao.modifyData(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}
	
	//ȸ������ �ҷ�����
	public MyPageDTO readData(MemberDTO member){
		MyPageDTO mypage = null;
		try {
			mypage = mdao.selectData(member);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mypage;
	}


}
