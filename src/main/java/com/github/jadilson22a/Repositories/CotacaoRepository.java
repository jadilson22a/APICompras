package com.github.jadilson22a.Repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.github.jadilson22a.Entities.Cotacao;

public interface CotacaoRepository extends MongoRepository<Cotacao, String>{

}
