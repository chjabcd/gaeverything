package com.bitschool.dao;

import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bitschool.dto.EventDTO;
import com.bitschool.dto.LocationDTO;
import com.bitschool.dto.MapInfomation;

@Repository
public class LocationDAO {

	@Inject
	private SqlSession session;
	
	private final static String namespace = "com.bitschool.bootstrap.LocationMapper";

	public List<LocationDTO> selectAll() throws SQLException{
		// TODO Auto-generated method stub
		List<LocationDTO> list = null;
		list = session.selectList(namespace+".selectAll");
		return list;
	}

	public List<LocationDTO> selectLocation(MapInfomation info) throws SQLException{
		// TODO Auto-generated method stub
		List<LocationDTO> list = null;
		list = session.selectList(namespace+".selectLocation", info);
		return list;
	}


	public LocationDTO selectLocationSeq(int locationSeq) throws SQLException {
		// TODO Auto-generated method stub
		LocationDTO dto = null;
		dto = session.selectOne(namespace+".selectLocationSeq", locationSeq);
		return dto;
	}

	public List<LocationDTO> selectCategory(MapInfomation info) throws SQLException  {
		// TODO Auto-generated method stub
		List<LocationDTO> list = null;
		list = session.selectList(namespace+".selectCategory", info);
		return list;
	}
	

	public List<LocationDTO> selectMapData(String searchWord) throws SQLException {
		// TODO Auto-generated method stub
		List<LocationDTO> list = null;
		list = session.selectList(namespace+".selectMapData", searchWord);
		return list;
	}

	public List<EventDTO> selectEventData(String searchWord) throws SQLException  {
		List<EventDTO> list = null;
		list = session.selectList(namespace+".selectEventData", searchWord);
		return list;
	}
}
