package com.bitschool.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

import com.bitschool.dto.BlogDTO;
import com.bitschool.dto.LocationDTO;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class APIExamSearchBlog {

    public static void main(String[] args) {
        String clientId = "LEq7OLCKz1iWikgbm3jr";//���ø����̼� Ŭ���̾�Ʈ ���̵�";
        String clientSecret = "pNcj27Jve1";//���ø����̼� Ŭ���̾�Ʈ ��ũ����";
        try {
            String text = URLEncoder.encode("�б�������������", "UTF-8");
            String apiURL = "https://openapi.naver.com/v1/search/blog?query="+ text; // json ���
            //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml ���
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection)url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("X-Naver-Client-Id", clientId);
            con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
            int responseCode = con.getResponseCode();
            BufferedReader br;
            if(responseCode==200) { // ���� ȣ��
                br = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"));
            } else {  // ���� �߻�
                br = new BufferedReader(new InputStreamReader(con.getErrorStream(),"UTF-8"));
            }
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }
            br.close();
            System.out.println(response.toString());
            
            
    		List<BlogDTO> list = null;
    		System.out.println(response.toString().substring(99,response.length()-1));
    		
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

