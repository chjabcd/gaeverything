package com.bitschool.service;

import java.sql.SQLException;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.dao.MyPageDAO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.dto.MyPageDTO;

@Service
public class MyPageService {
	
	@Inject
	private MyPageDAO mdao;
	
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
