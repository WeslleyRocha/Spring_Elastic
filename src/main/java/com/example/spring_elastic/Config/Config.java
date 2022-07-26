package com.example.spring_elastic.Config;


import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;


@Configuration//Drizer ao Spring que esta classe é de configuração.
@EnableElasticsearchRepositories(basePackages = "com.example.spring_elastic.Repository")//verifique o pacote fornecido em busca de repositórios Spring Data.
public class Config {

	@Bean//método retorna um objeto a ser registrado como um Bean
	public RestHighLevelClient client()//configuração da conexão com a API Elasticsearch Rest.
	 {
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
