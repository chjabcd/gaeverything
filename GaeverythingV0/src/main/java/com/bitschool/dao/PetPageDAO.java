package com.bitschool.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.MemberDTO;
import com.bitschool.dto.PetPageDTO;

@Repository
public class PetPageDAO {
	@Inject
	private SqlSession session;
	private static final String namespace = "com.bitschool.bootstrap.PetPageMapper";
	
	//PetPage��  �� insert�ϱ�
	public boolean insertData(PetPageDTO member) throws SQLException{
		boolean flag= false;
		int aCnt = session.insert(namespace+".insertPet", member);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}	
	//PetPage��  �� insert�ϱ�(photo�������)
	public boolean insertData2(PetPageDTO member) throws SQLException{
		boolean flag= false;
		int aCnt = session.insert(namespace+".insertPet2", member);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}	
	
	//��ü �� ���� ��������
	public int countData(MemberDTO mem) throws SQLException{
		int count = 0 ;
		count = session.selectOne(namespace+".countPet",mem);
		return count;
	}
	//��ü ��� ��������
	public List<PetPageDTO> readPets(MemberDTO mem) throws SQLException{
		List<PetPageDTO> list = null;
		list = session.selectList(namespace+".selectPets", mem);
		return list;
	}
	
	// ��ϵ� �� ����
	public boolean deleteData(PetPageDTO pet) throws SQLException{
		boolean flag= false;
		int aCnt = session.delete(namespace+".deletePet", pet);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}	
	
	//PegPage�� �� ���� �����ϱ�(photo�� ����)
	public boolean updateData(PetPageDTO pet) throws SQLException{
		boolean flag = false;
		int aCnt = session.update(namespace+".update",pet);
		if(aCnt>0){
			flag = true;
		}
		return flag;
	}
	
	//PegPage�� �� ���� �����ϱ�(photo�� ����X)
		public boolean updateData2(PetPageDTO pet) throws SQLException{
			boolean flag = false;
			int aCnt = session.update(namespace+".update2",pet);
			if(aCnt>0){
				flag = true;
			}
			return flag;
		}
	

	//�Ѹ��� �ҷ�����
	public PetPageDTO selectPetData(PetPageDTO pet) throws SQLException{
		pet = session.selectOne(namespace+".selectPet",pet);
		return pet;
	}

	
}
