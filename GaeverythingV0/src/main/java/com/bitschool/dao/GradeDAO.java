package com.bitschool.dao;


import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.GradeDTO;

@Repository
public class GradeDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.bitschool.gaverything.GradeMapper";

	// ȸ�������� �� ȣ���Ѵ�
	public boolean insertNew(GradeDTO dto) throws SQLException{
		boolean flag = false;
		int aCnt = session.insert(namespace+".insertNew",dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	//grade ���̺� ������ �Է�
	public boolean insertInfo(GradeDTO dto) throws SQLException{
		boolean flag = false;
		int aCnt = session.insert(namespace+".insertInfo",dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	//grade ���̺� ������ �Ѱ� ����
	public boolean deleteInfo(GradeDTO dto) throws SQLException{
		boolean flag = false;
		int aCnt = session.delete(namespace+".deleteInfo", dto);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	//point �հ輳��(total)
	public boolean updateTotal(String nickname) throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".updateTotal",nickname);
		if(aCnt>0){
			flag = true;
		}
		return flag; 
	}
	
	//gradename ���
	public boolean updateGrade1() throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".updateGrade1");
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	public boolean updateGrade2() throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".updateGrade2");
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	public boolean updateGrade3() throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".updateGrade3");
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	public boolean updateGrade4() throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".updateGrade4");
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	
}
