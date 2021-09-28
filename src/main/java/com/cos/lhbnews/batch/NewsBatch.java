package com.cos.lhbnews.batch;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cos.lhbnews.domain.News;
import com.cos.lhbnews.domain.NewsRepository;
import com.cos.lhbnews.util.NaverCraw;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class NewsBatch {
	
	private final NewsRepository newsRepository;
	private final NaverCraw naverCraw;

	@Scheduled(fixedDelay = 1000*60*1)
	public void newsCrawAndSave() {
	
		List<News> newsList = naverCraw.collect5();
		
		newsRepository.saveAll(newsList); // blukCollect 기법 saveAll로 한번에 한다.
		
	}
}