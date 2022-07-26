package com.example.spring_elastic.Service;

import com.example.spring_elastic.Model.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IArticleService {

	Article save (Article article); // metódo de salvar (import do ElasticsearchRepository)

	Article findById(int id); // retorno apos salvar

	List<Article> findAll();

	String deleteById(int id); //Um retnoro diferente para o delete

	Article update(Article article);//metodo de update

	Page<Article> getPageByTitle(String title, Pageable pg);//Metodo de fazer a paginacao

}
