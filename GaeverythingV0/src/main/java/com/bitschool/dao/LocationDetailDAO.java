package com.bitschool.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.BlogDTO;
import com.bitschool.dto.BoardDTO;
import com.bitschool.dto.DetailCommentDTO;
import com.bitschool.dto.DetailPhotoDTO;
import com.bitschool.dto.LocationDTO;
import com.bitschool.dto.MemberDTO;
@Repository
public class LocationDetailDAO {
	
	@Inject
	private SqlSession session;
	
	private final static String namespace = "com.bitschool.bootstrap.LocationDetailMapper";
	
	
	//locationSeq�� �� ����� DTO �޾ƿ��� 
	public LocationDTO selectOne(int seq) throws SQLException{
		// TODO Auto-generated method stub
		LocationDTO dto = null;
		dto = session.selectOne(namespace+".selectOne",seq);
		return dto;
	}
	
	// ������������ ��� �ۼ� 
	public boolean commentAdd(DetailCommentDTO dto) throws SQLException{
		// TODO Auto-generated method stub
		boolean flag = false;
		int aCnt = session.insert(namespace+".commentAdd",dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}	
	// ������������ ���� ��� 
	public boolean photoAdd(DetailPhotoDTO dto) throws SQLException {
		// TODO Auto-generated method stub
		boolean flag = false;
		int aCnt = session.insert(namespace + ".photoAdd", dto);
		if (aCnt > 0) {
			flag = true;
		}
		return flag;
	}

	// ���� �����ֱ�
	public List<DetailPhotoDTO> selectPhoto(int locationSeq) throws SQLException {
		// TODO Auto-generated method stub
		List<DetailPhotoDTO> list = null;
		list = session.selectList(namespace + ".selectPhoto", locationSeq);
		return list;
	}
	// ���� ���� �����ֱ�
	public int photoCnt(int locationSeq) throws SQLException{
		int PCnt = 0;
		PCnt = session.selectOne(namespace+".photoCnt", locationSeq);
		return PCnt;
	}
		

	// ������������ ��� ������ 
	public List<DetailCommentDTO> commentList(int locseq) throws SQLException{
		// TODO Auto-generated method stub
		List<DetailCommentDTO> dto = null;
		dto = session.selectList(namespace+".commentList",locseq);
		return dto;
	}

	// �������������� ���� ������ ��۸������� ���䵵 ����
	public boolean updatePhoto(MemberDTO member) throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".updatePhoto",member);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	// ������������ ��� ����  
	public boolean commentEdit(DetailCommentDTO dto) throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".commentEdit",dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	// ������������ ��� ����  
	public boolean commentDelete(DetailCommentDTO dto) throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".commentDelete",dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	// �Խ��ǿ��� �ۼ��� ���� ���� �������� 
	public int countReviews(int locationSeq) throws SQLException{
		int count = 0;
		count = session.selectOne(namespace+".countReviews",locationSeq);
		return count;
	}
	
	// �Խ��ǿ��� �ۼ��� ������ ���� �������� 
	public List<Double> getRatings(int locationSeq) throws SQLException{
		List<Double> ratings = null;
		ratings = session.selectList(namespace+".getRatings",locationSeq);
		return ratings;
	}
	
	// ������������ ��ۿ��� �ۼ��� ���� �������� 
	public List<Double> getReplyRatings(int locationSeq) throws SQLException{
		List<Double> ratings = null;
		ratings = session.selectList(namespace+".getReplyRatings",locationSeq);
		return ratings;
	}
	
	// ������������ ��� ���� �������� 
	public int countReplies(int locationSeq) throws SQLException{
		int count = 0;
		count = session.selectOne(namespace+".countReplies",locationSeq);
		return count;
	}
	
	// �Խ��ǿ��� �ۼ��� ���� ��������
	public List<BoardDTO> getReviews(int locationSeq) throws SQLException{
		List<BoardDTO> dto = null;
		dto = session.selectList(namespace+".getReviews",locationSeq);
		return dto;
	}
	
	// �ش� ����� ��α� ���� �ҷ�����
	public List<BlogDTO> getBlogReviews(int locationSeq) throws SQLException{
		List<BlogDTO> dto = null;
		dto = session.selectList(namespace+".getBlogReviews",locationSeq);
		return dto;
	}

}
