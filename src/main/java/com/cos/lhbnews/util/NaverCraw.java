package com.cos.lhbnews.util;

import java.util.ArrayList;	
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cos.lhbnews.domain.News;

@Component
public class NaverCraw {
	
	int aidNum = 1;
	
	public List<News> collect5() {
	
		RestTemplate rt = new RestTemplate();
		List<News> newsList = new ArrayList<>();

		
		for (int i = 1; i < 6; i++) {
			String strnum = String.format("%010d", aidNum);
	
			String url = "https://news.naver.com/main/read.naver?mode=LSD&mid=shm&sid1=102&oid=022&aid=" + strnum;
			
			String html = rt.getForObject(url, String.class);
			
			Document doc = Jsoup.parse(html);

			Element titleElement = doc.selectFirst("#articleTitle"); 
			Element createAtElement = doc.selectFirst(".t11");
		//	Element companyElement = doc.selectFirst(".nclicks img");
			
			
			String title = titleElement.text(); 
			String createAt = createAtElement.text();
		//	String company = companyElement.attr("title");
			
			// 오브젝트로 저장
			News news = News.builder().title(title).createAt(createAt).build();
			
			newsList.add(news);
			
			aidNum++;
		}
		return newsList;
	}
}
