package com.bitschool.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.BoardDTO;
import com.bitschool.dto.CommentDTO;
import com.bitschool.dto.DetailCommentDTO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.dto.MyPageDTO;

@Repository
public class MyPageDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.bitschool.bootstrap.MyPageMapper";

	
	// ���� �� ���(�Խ��Ǹ���)�� ���� ���� ��������
	public String selectBoardTitle(int groupno) throws SQLException{
		String title = null;
		title = session.selectOne(namespace+".selectBoardTitle",groupno);
		return title;
	}
 	
	// ���� �� ���(�Խ��Ǹ���) ��ƺ��� 
	public List<CommentDTO> selectMyBoardComments(String nickname) throws SQLException{
		List<CommentDTO> list = null;
		list = session.selectList(namespace+".selectMyBoardComments",nickname);
		return list;
	}
	
	// ��ȣ�� �������ֱ� ���� 
	public String selectShopName(int locationSeq) throws SQLException{
		String address = null;
		address = session.selectOne(namespace+".selectShopName",locationSeq);
		return address;
	}
		
	// ���� �� ���(�ʵ�����) ��ƺ��� 
	public List<DetailCommentDTO> selectMyDetailComments(String nickname) throws SQLException{
		List<DetailCommentDTO> list = null;
		list = session.selectList(namespace+".selectMyDetailComments",nickname);
		return list;
	}	
	
	// ���� �� ���� ��ƺ��� 
	public List<BoardDTO> selectMyReviews(String nickname) throws SQLException{
		List<BoardDTO> list = null;
		list = session.selectList(namespace+".selectMyReviews",nickname);
		return list;
	}
	
	public boolean modifyMemData(MyPageDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		boolean flag = false;
		int aCnt = session.update(namespace+".updateMem",dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}	
	
	//ȸ������ �� �Է��� email�� mypage ���̺� �߰�(SignUpService���� ȣ��)
	public boolean insertData(MemberDTO data) throws SQLException{
		boolean flag= false;
		int aCnt = session.insert(namespace+".insert", data);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	//����(photo�� ����X)
	public boolean modifyData2(MyPageDTO member) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("MyPageDAO-modifyData2�� ���Դ�");
		boolean flag = false;
		int aCnt = session.update(namespace+".update2",member);
		if(aCnt>0){
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
	//���� 
	public boolean modifyData(MyPageDTO member) throws SQLException{
		// TODO Auto-generated method stub
		System.out.println("MyPageDAO-modifyData�� ���Դ�");
		boolean flag = false;
		int aCnt = session.update(namespace+".update",member);
		if(aCnt>0){
			flag = true;
		}
		System.out.println(flag);
		return flag;
	}
	
	//�Ѹ� �ҷ�����
	public MyPageDTO selectData(MemberDTO member) throws SQLException{
		MyPageDTO mypage = null;
		mypage = session.selectOne(namespace+".selectOne", member);
		return mypage;
	}




}
