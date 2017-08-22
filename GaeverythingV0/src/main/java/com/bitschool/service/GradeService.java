package com.bitschool.service;





import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.dao.GradeDAO;
import com.bitschool.dto.GradeDTO;



@Service
public class GradeService {
	
	@Inject
	private GradeDAO dao;
	
	// ȸ�������� �� ȣ���Ѵ�
	public boolean insertNew(GradeDTO dto){
		boolean flag = false;
		try {
			flag = dao.insertNew(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	//grade ���̺� ������ insert
	public boolean insertInfo(GradeDTO dto){
		boolean flag = false;
		try {
			flag = dao.insertInfo(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}
	
	//grade ���̺� ������ �Ѱ� ����
	public boolean deleteInfo(GradeDTO dto){
		boolean flag = false;
		try {
			flag = dao.deleteInfo(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

}
