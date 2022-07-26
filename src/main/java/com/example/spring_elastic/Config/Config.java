package com.example.spring_elastic.Config;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

@Configuration
@EnableElasticsearchRepositories(basePackages = "com.example.spring_elastic.Repository")
public class Config {

	@Bean
	public RestHighLevelClient client(){
		ClientConfiguration clientConfiguration = ClientConfiguration.builder()
				.connectedTo("localhost:9200")
				//.withBasicAuth("elastic","SENHA AQUI") usuario e senha do servidor "elastic"
				.withConnectTimeout(10000) // tempo limite para conexão com servidor
				.withSocketTimeout(10000)// tempo de resposta após a solicitação
				.build();
		return RestClients.create(clientConfiguration).rest();
	}

	@Bean
	public ElasticsearchOperations elasticsearchTemplate(){
		return new ElasticsearchRestTemplate(client());
	}
}
