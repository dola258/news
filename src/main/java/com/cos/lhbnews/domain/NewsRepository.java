package com.cos.lhbnews.domain;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface NewsRepository extends MongoRepository<News, String>{

}
