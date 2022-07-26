package com.example.spring_elastic.Controller;

import com.example.spring_elastic.Model.Article;
import com.example.spring_elastic.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
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
		return ResponseEntity.ok(service.save(article));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Article> findById(@PathVariable int id){
		return ResponseEntity.ok(service.findById(id));
	}

	@GetMapping
	public ResponseEntity<List<Article>> findAll(){
		return ResponseEntity.ok(service.findAll());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deletebyid(@PathVariable int id) {
		return ResponseEntity.ok(service.deletebyId(id));
	}

	@DeleteMapping("/v/{id}")
	public ResponseEntity<Void> deleteVoidByid(@PathVariable int id) {
		service.deletebyId(id);
		return ResponseEntity.noContent().build();
	}
}
