package com.bitschool.service;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.bitschool.dao.MyPageDAO;
import com.bitschool.dao.ReactionDAO;
import com.bitschool.dto.ReactionDTO;


@Service
public class ReactionService {
	
	@Inject
	private ReactionDAO dao;
	
	@Inject
	private MyPageDAO mdao;
	
	public boolean insertReaction(ReactionDTO dto){
		boolean flag = false;
		try {
			flag = dao.insertReaction(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
	
	public List<ReactionDTO> selectReaction(String nickname){
		List<ReactionDTO> list = null;
		try {
			list = dao.selectReaction(nickname);
			for(int i=0;i<list.size();i++){
				list.get(i).setTitle(mdao.selectBoardTitle(list.get(i).getGroupNo()));						
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public String selectNickname(String email){
		String nickname = null;
		try {
			nickname = dao.selectNickname(email);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return nickname;
	}

	public boolean deleteReaction(ReactionDTO dto){
		boolean flag = false;
		try {
			flag = dao.deleteReaction(dto);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public boolean deleteReaction2(int reactionSeq){
		boolean flag = false;
		try {
			flag = dao.deleteReaction2(reactionSeq);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}
}
