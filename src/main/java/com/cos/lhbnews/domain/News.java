package com.cos.lhbnews.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
@Document(collection = "news_naver")
public class News {
	private String title;
//	private String company;
	private String createAt;
}
