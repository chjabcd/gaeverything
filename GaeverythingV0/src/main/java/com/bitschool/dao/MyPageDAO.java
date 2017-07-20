package com.bitschool.dao;

import java.sql.SQLException;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.MemberDTO;
import com.bitschool.dto.MyPageDTO;

@Repository
public class MyPageDAO {

	@Inject
	private SqlSession session;
	
	private static final String namespace = "com.bitschool.bootstrap.MyPageMapper";
	
	
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
