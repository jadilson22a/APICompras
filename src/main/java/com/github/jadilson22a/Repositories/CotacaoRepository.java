package com.github.jadilson22a.Repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.jadilson22a.Entities.Cotacao;

public interface CotacaoRepository extends MongoRepository<Cotacao, String>{
	List<Cotacao> findByRequisicoes(List<Integer> requisicoes);
	List<Cotacao> findByConcluido(boolean concluido);
}
