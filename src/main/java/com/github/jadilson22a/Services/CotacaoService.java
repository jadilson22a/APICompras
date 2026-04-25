package com.github.jadilson22a.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jadilson22a.Entities.Cotacao;
import com.github.jadilson22a.Repositories.CotacaoRepository;

@Service
public class CotacaoService {
	
	@Autowired
	private CotacaoRepository repository;
	
	public void criar(Cotacao cotacao) {
		repository.save(cotacao);
	}
	
}
