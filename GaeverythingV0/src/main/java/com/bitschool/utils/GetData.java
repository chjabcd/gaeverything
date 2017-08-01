package com.bitschool.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import com.bitschool.dto.Location2DTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GetData {

    public List<Location2DTO> GetDatum(){
    	List<Location2DTO> list = null;
        try {
            String text = URLEncoder.encode("동물병원", "UTF-8");      
            String apiURL = "https://dapi.kakao.com/v2/local/search/keyword.json?query="+text+"&page=2&appkey=ebfbfbd7a5ec71c10c63936dd90beb22&size=15";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            BufferedReader br;  
            br = new BufferedReader(new InputStreamReader(con.getInputStream()));    
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            String data = response.toString();
            String docudata = data.substring(140, data.length()-1);
            System.out.println(docudata);
            HashMap<String, Object> hashdata = new HashMap<String, Object>();
    		ObjectMapper mapper = new ObjectMapper();
    		
    		HashMap<String, String> map = null;
    		try {
    			list = mapper.readValue(docudata, new TypeReference<List<Location2DTO>>(){});
    			Location2DTO ldto = list.get(0);
    			System.out.println("list : "+list);
    			System.out.println("ldto : "+ldto);
    		} catch (JsonParseException e) {
    			e.printStackTrace();
    		} catch (JsonMappingException e) {
    			e.printStackTrace();
    		} catch (IOException e) {
    			e.printStackTrace();
    		}
            
        } catch (Exception e) {
            System.out.println(e);
        } 
        System.out.println();
        return list;
    }        
}