package com.github.jadilson22a.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jadilson22a.Dtos.CotacaoMinDTO;
import com.github.jadilson22a.Repositories.CotacaoRepository;

@Service
public class CotacaoService {
	
	@Autowired
	private CotacaoRepository repository;
	
	public void criar(CotacaoMinDTO dto) {
		repository.save(dto.toCotacao());
	}
	
	public void deletar(String id) {
		repository.deleteById(id);
	}
	
}
