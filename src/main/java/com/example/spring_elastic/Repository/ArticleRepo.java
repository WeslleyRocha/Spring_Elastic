package com.example.spring_elastic.Repository;

import com.example.spring_elastic.Model.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ArticleRepo extends ElasticsearchRepository<Article, Integer> {
}
