package com.example.spring_elastic.Controller;

import com.example.spring_elastic.Model.Article;
import com.example.spring_elastic.Service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}