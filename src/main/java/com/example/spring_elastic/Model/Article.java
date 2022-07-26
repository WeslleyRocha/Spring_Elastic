package com.example.spring_elastic.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.List;

@Getter
@Setter
@Document(indexName = "meli_doc") //indica que é um documento e o nome do mesmo http://localhost:9200/meli_doc
public class Article {

	@Id //usando a anotação ID
	private int id;

	//Podemos alterar o nome do campo do banco / FieldType: tipo do valor que o campo vai receber
	@Field(name = "title", type = FieldType.Text)
	private String title;

	//Indica que este campo veio de outra classe, e vai persistir a informacao
	@Field(type = FieldType.Nested, includeInParent = true)
	private List<Author> authors;
}
