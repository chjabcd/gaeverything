package com.bitschool.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.dao.PetPageDAO;
import com.bitschool.dto.MemberDTO;
import com.bitschool.dto.MyPageDTO;
import com.bitschool.dto.PetPageDTO;

@Service
public class PetPageService {
	@Inject
	private PetPageDAO pdao;
	
		//PetPage�� �� ����ϱ�(insert) (photo �Է� �ʼ�)
		public boolean insertPetData(PetPageDTO member){
			boolean flag= false;
			try {
				flag = pdao.insertData(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
		
		//PetPage�� �� ����ϱ�(insert) (photo �Է¾��ص� ��� ����)
		public boolean insertPetData2(PetPageDTO member){
			boolean flag= false;
			try {
				flag = pdao.insertData2(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}
		
		//��ü �� ���� ��������
		public int countPetData(MemberDTO mem){
			int count = 0 ;
			try {
				count = pdao.countData(mem);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return count;
		}
		
		//��ü ��� ��������
		public List<PetPageDTO> readPetsData(MemberDTO mem){
			List<PetPageDTO> list = null;
			try {
				list = pdao.readPets(mem);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		
		// ��ϵ� �� ����
		public boolean deletePetData(PetPageDTO pet){
			boolean flag= false;
			try {
				flag = pdao.deleteData(pet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
		}	

		//PetPage�� �� �����ϱ�(photo�� ����)
		public boolean updatePetData(PetPageDTO pet){
			boolean flag = false;
			try {
				flag = pdao.updateData(pet);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
			return flag;
		}
	
	//PetPage �� ����(photo�� �������� ���� ��)
	public boolean updatePetData2(PetPageDTO pet){
		boolean flag = false;
		try {
			flag = pdao.updateData2(pet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return flag;
	}
		
	//�� �Ѹ��� ���� �ҷ�����
	public PetPageDTO readPetData(PetPageDTO pet) {
		try {
			pet = pdao.selectPetData(pet);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return pet;
	}
	

}
