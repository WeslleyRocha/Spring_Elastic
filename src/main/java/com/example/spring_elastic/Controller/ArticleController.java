package com.example.spring_elastic.Controller;

import org.springframework.data.domain.Page;
import com.example.spring_elastic.Model.Article;
import com.example.spring_elastic.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {

	@Autowired
	private ArticleService service;

	@PostMapping
	public ResponseEntity<Article> save(@RequestBody Article article){
		return ResponseEntity.ok(service.save(article));// SALVAR
	}

	@PutMapping("/{id}")
	public ResponseEntity<Article> update(@RequestBody Article article){
		return ResponseEntity.ok(service.update(article));// PUT Update
	}

	@GetMapping("/{id}")
	public ResponseEntity<Article> findById(@PathVariable int id){
		return ResponseEntity.ok(service.findById(id)); // Metodo findById
	}

	@GetMapping
	public ResponseEntity<List<Article>> findAll(){
		return ResponseEntity.ok(service.findAll()); // Metodo findAll "GET ALL"
	}

	@GetMapping("/title/{title}")
	public Page<Article> getPageByTitle(@PathVariable String title, Pageable pg){
		return service.getPageByTitle(title, pg); //criando metodo buscar por pagina getPageByTitle
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteByid(@PathVariable int id) {
		return ResponseEntity.ok(service.deleteById(id));// Metodo 1 de deletar, retornando uma String "Removido com Sucesso"
	}

	@DeleteMapping("/v/{id}")
	public ResponseEntity<Void> deleteVoidByid(@PathVariable int id) {
		service.deleteById(id);
		return ResponseEntity.noContent().build(); //Metodo 2 de deletar, retornando o status cod. "noContente"
	}
}
