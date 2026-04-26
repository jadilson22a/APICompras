package com.github.jadilson22a.Services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.jadilson22a.Dtos.CotacaoMaxDTO;
import com.github.jadilson22a.Dtos.CotacaoMinDTO;
import com.github.jadilson22a.Entities.Cotacao;
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
	
	public void atualizar(String id, CotacaoMinDTO dto) {
		Cotacao cotacao = repository.findById(id)
		        .orElseThrow(() -> new RuntimeException("Cotação não encontrada"));
		
		cotacao.setId(id);
		cotacao.setRequisicoes(dto.requisicoes());
		cotacao.setTipo(dto.tipo());
		cotacao.setOrcamentos(dto.orcamentos());
		repository.save(cotacao);
	}
	
	public CotacaoMaxDTO findById(String id) {
		Cotacao cotacaoEncontrada = repository.findById(id).orElse(null);
		
		CotacaoMaxDTO dto = new CotacaoMaxDTO(
				cotacaoEncontrada.getId(), 
				cotacaoEncontrada.getRequisicoes(),
				cotacaoEncontrada.isConcluido(), 
				cotacaoEncontrada.getTipo(),
				cotacaoEncontrada.getOrcamentos(),
				cotacaoEncontrada.getPedido());
		
		return dto;
	}
	
	public List<CotacaoMaxDTO> findAll(){
		List<Cotacao> cotacaoEncontrada = repository.findAll();
		
		List<CotacaoMaxDTO> cotacoesDTO = new ArrayList<>();
		
		for (Cotacao cotacao : cotacaoEncontrada) {
			CotacaoMaxDTO dto = new CotacaoMaxDTO(
					cotacao.getId(), 
					cotacao.getRequisicoes(),
					cotacao.isConcluido(), 
					cotacao.getTipo(),
					cotacao.getOrcamentos(),
					cotacao.getPedido());
			
			cotacoesDTO.add(dto);
		}
		
		return cotacoesDTO;
	}
	
	public List<CotacaoMaxDTO> findByRequisicao(List<Integer> requisicoes){
		List<Cotacao> cotacaoEncontrada = repository.findByRequisicoes(requisicoes);
		
		List<CotacaoMaxDTO> cotacoesDTO = new ArrayList<>();
		
		for (Cotacao cotacao : cotacaoEncontrada) {
			CotacaoMaxDTO dto = new CotacaoMaxDTO(
					cotacao.getId(), 
					cotacao.getRequisicoes(),
					cotacao.isConcluido(), 
					cotacao.getTipo(),
					cotacao.getOrcamentos(),
					cotacao.getPedido());
			
			cotacoesDTO.add(dto);
		}
		
		return cotacoesDTO;
	}
	
	public List<CotacaoMaxDTO> findByEstado(boolean concluido){
		List<Cotacao> cotacaoEncontrada = repository.findByConcluido(concluido);
		
		List<CotacaoMaxDTO> cotacoesDTO = new ArrayList<>();
		
		for (Cotacao cotacao : cotacaoEncontrada) {
			CotacaoMaxDTO dto = new CotacaoMaxDTO(
					cotacao.getId(), 
					cotacao.getRequisicoes(),
					cotacao.isConcluido(), 
					cotacao.getTipo(),
					cotacao.getOrcamentos(),
					cotacao.getPedido());
			
			cotacoesDTO.add(dto);
		}
		
		return cotacoesDTO;
	}
	
}
