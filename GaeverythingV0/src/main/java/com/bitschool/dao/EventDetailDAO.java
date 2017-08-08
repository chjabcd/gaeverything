package com.bitschool.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.BlogDTO;
import com.bitschool.dto.BoardDTO;
import com.bitschool.dto.EventCommentDTO;
import com.bitschool.dto.EventPhotoDTO;
import com.bitschool.dto.EventDTO;
import com.bitschool.dto.MemberDTO;

@Repository
public class EventDetailDAO {

	@Inject
	private SqlSession session;
	
	private static String namespace = "com.bitschool.event.eventDetail";
	
	//eventNo�� �� ����� DTO �޾ƿ��� 
		public EventDTO selectOne(int seq) throws SQLException{
			// TODO Auto-generated method stub
			EventDTO dto = null;
			dto = session.selectOne(namespace+".selectOne",seq);
			return dto;
		}
		
		// ������������ ��� �ۼ� 
		public boolean commentAdd(EventCommentDTO dto) throws SQLException{
			// TODO Auto-generated method stub
			boolean flag = false;
			int aCnt = session.insert(namespace+".commentAdd",dto);
			if(aCnt>0){
				flag = true;
			}
			return flag;
		}	
		// ������������ ���� ��� 
		public boolean photoAdd(EventPhotoDTO dto) throws SQLException {
			// TODO Auto-generated method stub
			boolean flag = false;
			int aCnt = session.insert(namespace + ".photoAdd", dto);
			if (aCnt > 0) {
				flag = true;
			}
			return flag;
		}

		// ���� �����ֱ�
		public List<EventPhotoDTO> selectPhoto(int eventNo) throws SQLException {
			// TODO Auto-generated method stub
			List<EventPhotoDTO> list = null;
			list = session.selectList(namespace + ".selectPhoto", eventNo);
			return list;
		}
		// ���� ���� �����ֱ�
		public int photoCnt(int eventNo) throws SQLException{
			int PCnt = 0;
			PCnt = session.selectOne(namespace+".photoCnt", eventNo);
			return PCnt;
		}
			

		// ������������ ��� ������ 
		public List<EventCommentDTO> commentList(int locseq) throws SQLException{
			// TODO Auto-generated method stub
			List<EventCommentDTO> dto = null;
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
		public boolean commentEdit(EventCommentDTO dto) throws SQLException{
			boolean flag = false;
			int aCnt = session.update(namespace+".commentEdit",dto);
			if(aCnt>0){
				flag = true;
			}
			return flag;
		}
		
		// ������������ ��� ����  
		public boolean commentDelete(EventCommentDTO dto) throws SQLException{
			boolean flag = false;
			int aCnt = session.update(namespace+".commentDelete",dto);
			if(aCnt>0){
				flag = true;
			}
			return flag;
		}
		
		/*// �Խ��ǿ��� �ۼ��� ���� ���� �������� 
		public int countReviews(int eventNo) throws SQLException{
			int count = 0;
			count = session.selectOne(namespace+".countReviews",eventNo);
			return count;
		}*/
		
		/*// �Խ��ǿ��� �ۼ��� ������ ���� �������� 
		public List<Double> getRatings(int eventNo) throws SQLException{
			List<Double> ratings = null;
			ratings = session.selectList(namespace+".getRatings",eventNo);
			return ratings;
		}*/
		
		// ������������ ��ۿ��� �ۼ��� ���� �������� 
		public List<Double> getReplyRatings(int eventNo) throws SQLException{
			List<Double> ratings = null;
			ratings = session.selectList(namespace+".getReplyRatings",eventNo);
			return ratings;
		}
		
		// ������������ ��� ���� �������� 
		public int countReplies(int eventNo) throws SQLException{
			int count = 0;
			count = session.selectOne(namespace+".countReplies",eventNo);
			return count;
		}
		
		/*// �Խ��ǿ��� �ۼ��� ���� ��������
		public List<BoardDTO> getReviews(int eventNo) throws SQLException{
			List<BoardDTO> dto = null;
			dto = session.selectList(namespace+".getReviews",eventNo);
			return dto;
		}*/
		
		/*// �ش� ����� ��α� ���� �ҷ�����
		public List<BlogDTO> getBlogReviews(int eventNo) throws SQLException{
			List<BlogDTO> dto = null;
			dto = session.selectList(namespace+".getBlogReviews",eventNo);
			return dto;
		}*/

		public List<EventPhotoDTO> photoList(int seq) throws SQLException{
			// TODO Auto-generated method stub
			List<EventPhotoDTO> dto = null;
			dto = session.selectList(namespace+".photoList",seq);
			return dto;
		}


}
