package com.example.spring_elastic.Service;

import com.example.spring_elastic.Model.Article;
import com.example.spring_elastic.Repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService  implements IArticleService{

	//Implementação do IArticleService

	@Autowired
	private ArticleRepo repo; //Injeção de dependência por atributos.

	@Override
	public Article save(Article article) {
		return repo.save(article); // execulta o save do repositório
	}

	@Override
	public Article findById(int id) {
		return repo.findById(id).get(); // execulta o findById do repo.
	}
}
