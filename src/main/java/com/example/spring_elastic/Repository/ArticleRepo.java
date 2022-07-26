package com.example.spring_elastic.Repository;

import com.example.spring_elastic.Model.Article;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> {

	@Query("{\"match_all\": {} }") // modo 2 de fazer o findAll
	List<Article> findAllArticles();
}
