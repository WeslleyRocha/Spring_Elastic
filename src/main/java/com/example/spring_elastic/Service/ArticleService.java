package com.example.spring_elastic.Service;

import com.example.spring_elastic.Model.Article;
import com.example.spring_elastic.Repository.ArticleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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

	@Override
	public List<Article> findAll() {
//		List<Article> list = new ArrayList<>(); //Article é uma lista de Article
//
//		Iterable<Article> resp = repo.findAll();//esta devolvendo um iterable e não uma lista
//
//		resp.forEach(list::add);//Para cada item ele chama o metodo ADD para adicionar a lista
//		return list;

		return  repo.findAllArticles(); // modo 2 de fazer o findAll
	}

	@Override
	public String deleteById(int id) {
		repo.deleteById(id);
		return "Removido com Sucesso!"; //Retorno para o delete "opcional"
	}

	@Override
	public Article update(Article article) {
		return repo.save(article);
	}

	@Override
	public Page<Article> getPageByTitle(String title, Pageable pg) {
		return repo.findByTitle(title, pg); //Retorno do titulo e pg
	}
}
