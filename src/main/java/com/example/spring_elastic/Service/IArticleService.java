package com.example.spring_elastic.Service;

import com.example.spring_elastic.Model.Article;

public interface IArticleService {

	Article save (Article article); // metódo de salvar (import do ElasticsearchRepository)
	Article findById(int id); // retorno apos salvar
}
