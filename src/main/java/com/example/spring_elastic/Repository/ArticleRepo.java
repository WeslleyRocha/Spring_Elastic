package com.example.spring_elastic.Repository;

import com.example.spring_elastic.Model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> {

	@Query("{\"match_all\": {} }") // modo 2 de fazer o findAll, dando match_all
	List<Article> findAllArticles();

	@Query("{\"match\": {\"title\": {\"query\": \"?0\"}}}")// Query para a pagina
	Page<Article> findByTitle(String title, Pageable pg); // montando o findByTitle com paginação
}
