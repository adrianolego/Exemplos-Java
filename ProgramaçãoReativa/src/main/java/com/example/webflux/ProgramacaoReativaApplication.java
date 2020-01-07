package com.example.webflux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProgramacaoReativaApplication {

	/*
	* Aplicação usada para testar funcionamento do webflux do spring para programação reativa
	* ele depende do mongoBD (ReativeMongoDB e servidor Netty (será baixado com a dependência do Spring Reactive Web))
	* Banco do mongo esta disponível no site https://cloud.mongodb.com/user?nds=true#/atlas/login
	*
	* A classe Router faz o mapeamento ne forma funcional dos métodos que serão chamados na classe handler
	* A classe Handler disponibiliza os EndPoints
	*
	* No Controller existe um end point getPlaylistByEvents que retorna os dados do banco de acordo com o tempo
	* parametrizado em segundos na variável 'interval'
	*
	* Uma vez chamado esse end point ele vai retornando os dados dentro desse tempo podendo ser
	* feita outras chamadas ao mesmo tempo que ele não bloqueia a continuidade das outras em andamento
	*
	* Programação assincrona não bloqueante que permite que outra requisição seja atendida mesmo que a anterior não
	* tenha finalizado ainda
	* */

	public static void main(String[] args) {
		SpringApplication.run(ProgramacaoReativaApplication.class, args);
	}

}
