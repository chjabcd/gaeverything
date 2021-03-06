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
import com.bitschool.service.LocationDetailService;
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
	
	@Inject
	private LocationDetailService dService;
			
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
	
	@RequestMapping(value = "getSearchLocationData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody HashMap<String, Object> getLocationData(
			@RequestParam(value = "searchWord", defaultValue = "") String searchWord,
			@RequestParam(value = "categories", defaultValue = "HP8") String categories,
			@RequestParam("level") int level,
			@RequestParam("lat") double lat,
			@RequestParam("lon") double lon,
			@RequestParam( value = "page", defaultValue="0") int page,
			HttpSession session){
		
		String[] categories1 = categories.split(",");
		
		MapInfomation info = new MapInfomation(searchWord, categories1[0], level, lat, lon);
		List<LocationDTO> list = service.SearchLocation(info);
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		ActUserManager manager = new ActUserManager(aService);
	
		if(member!=null){
			ActUserDTO aDTO = new ActUserDTO(member.getEmail(), ActUserManager.SHOP);
			list= manager.checkListLocLikeStatus(aDTO, list);
		}
		list = dService.getLocActUserResults(manager, list);
		
		//사용자 평가 반영
		
		HashMap<String, Object> map = pService.makeSerachList(page, 5, list);
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("places", list);
		data.put("pList", map.get("pList"));
		data.put("infoList", map.get("infoList"));
		return data;
	}
	
	@RequestMapping(value = "getSearchShopNameData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody HashMap<String, Object> getSearchShopNameData(
			@RequestParam(value = "searchWord") String searchWord,
			@RequestParam(value = "categories") String categories,
			@RequestParam("level") int level,
			@RequestParam("lat") double lat,
			@RequestParam("lon") double lon,
			HttpSession session){
		String[] temps = categories.split(",");
		MapInfomation info=null;
		//카테고리 분류 코드
		if(temps.length==1){
			info = new MapInfomation(searchWord, temps[0], level, lat, lon);
		}
		
		List<LocationDTO> list = service.SearchCategory(info);

		MemberDTO member = (MemberDTO)session.getAttribute("member");
		ActUserManager manager = new ActUserManager(aService);
		if(member!=null){
			ActUserDTO aDTO = new ActUserDTO(member.getEmail(), ActUserManager.SHOP);
			list= manager.checkListLocLikeStatus(aDTO, list);
		}
		list = dService.getLocActUserResults(manager, list);
		
		HashMap<String, Object> map = pService.makeSerachList(0, 5, list);
		HashMap<String, Object> data = new HashMap<String, Object>();
		data.put("places", list);
		data.put("pList", map.get("pList"));
		data.put("infoList", map.get("infoList"));
		return data;
	}
	
	@RequestMapping(value = "getPagingData", method = {RequestMethod.POST,RequestMethod.GET})
	public @ResponseBody HashMap<String, Object> getPagingData(@RequestParam("data") String locData, @RequestParam("page") int page, HttpSession session){
		HashMap<String, Object> data = new HashMap<String, Object>();
		ObjectMapper mapper = new ObjectMapper();
		List<LocationDTO> list = null;
		HashMap<String, Object> map = null;
		MemberDTO member = (MemberDTO)session.getAttribute("member");
		ActUserManager manager = new ActUserManager(aService);
		try {
			list = mapper.readValue(locData, new TypeReference<List<LocationDTO>>(){});
			if(member!=null){
				ActUserDTO aDTO = new ActUserDTO(member.getEmail(), ActUserManager.SHOP);
				list= manager.checkListLocLikeStatus(aDTO, list);
			}
			list = dService.getLocActUserResults(manager, list);
			map = pService.makeSerachList(page, 5, list);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		data.put("places", list);
		data.put("page", page);
		data.put("pList", map.get("pList"));
		data.put("infoList", map.get("infoList"));
		
		
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
