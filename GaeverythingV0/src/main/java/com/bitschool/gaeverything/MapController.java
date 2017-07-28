package com.bitschool.gaeverything;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitschool.dto.ActUserDTO;
import com.bitschool.dto.LocationDTO;
import com.bitschool.dto.MapInfomation;
import com.bitschool.dto.MemberDTO;
import com.bitschool.service.ActUserService;
import com.bitschool.service.LocationService;
import com.bitschool.service.PageService;
import com.bitschool.utils.ActUserManager;
import com.bitschool.utils.LoginFilter;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RequestMapping(value = "map")
@Controller
public class MapController {
	
	@Inject
	private LocationService service;
	
	@Inject
	private PageService pService;
	
	@Inject
	private ActUserService aService;
			
	@RequestMapping(value = "/searchMapData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody String searchMapData(HttpSession session,
			@RequestParam(value="page") int page,
			@RequestParam(value="query") String query){
		String data = null;
		String url = "https://dapi.kakao.com/v2/local/search/keyword.json?query="+query+
				"&page="+page+
				"&appkey=ebfbfbd7a5ec71c10c63936dd90beb22&size=15";
		
		return url;
	}
	
	@RequestMapping(value = "/viewMapData", method = {RequestMethod.POST,RequestMethod.GET})
	public String viewMapData(HttpSession session, Model model){
		String url = "map/map_data";
		return url;
	}
	
	
	
	
	//지울거임
	@RequestMapping(value = "/viewTest", method = RequestMethod.GET)
	public String viewTest(HttpSession session, Model model){
		String url = "map/test";
		return url;
	}
	
	
	@RequestMapping(value = "/viewMapList", method = RequestMethod.GET)
	public String viewMapList(HttpSession session, Model model){
		String url = "map/map_list";
		boolean isLogin = new LoginFilter().isLogin(session, model);
		return url;
	}
	
	@RequestMapping(value = "getLocationData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody HashMap<String, Object> getLocationData(
			@RequestParam(value = "searchWord", defaultValue = "") String searchWord,
			@RequestParam(value = "categories", defaultValue = "5 449 776") String categories,
			@RequestParam("level") int level,
			@RequestParam("lat") double lat,
			@RequestParam("lon") double lon,
			@RequestParam(value = "option", defaultValue = "0") int option,
			HttpSession session){
		
		MapInfomation info = new MapInfomation(searchWord, categories, level, lat, lon, option);
		List<LocationDTO> list = service.getData(info);
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		//좋아요 상태 유지
		if(member!=null){
			ActUserDTO aDTO = new ActUserDTO(member.getEmail(), ActUserManager.SHOP);
			list= new ActUserManager(aService).checkLikeStatus(list, aDTO);
		}
		
		HashMap<String, Object> map = pService.makeSerachList(0, 5, list);
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("places", list);
		data.put("pList", map.get("pList"));
		data.put("infoList", map.get("infoList"));
		return data;
	}
	
	@RequestMapping(value = "getPagingData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody HashMap<String, Object> getPagingData(@RequestParam("data") String locData, @RequestParam("page") int page){
		HashMap<String, Object> data = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		List<LocationDTO> list = null;
		HashMap<String, Object> map = null;
		try {
			list = mapper.readValue(locData, new TypeReference<List<LocationDTO>>(){});
			map = pService.makeSerachList(page, 5, list);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		data.put("places", list);
		data.put("pList", map.get("pList"));
		data.put("infoList", map.get("infoList"));
		System.out.println(locData+":"+page);
		System.out.println(locData);
		return data;
	}
	
	@RequestMapping(value = "homeSearchResult", method = RequestMethod.POST)
	public String homeSearchResult(@RequestParam(value = "searchWord") String word, @RequestParam(value = "searchOption") String option,
			Model model){
		String url = "map/map_list";
		model.addAttribute("word", word);
		model.addAttribute("option", option);
		return url;
	}
	
	@RequestMapping(value = "viewDetailpage", method = RequestMethod.GET)
	public String viewDetailpage(){
		String url = "map/map_detailpage";
		return url;
	}

}
