package com.github.jadilson22a.Dtos;

import java.util.List;

import com.github.jadilson22a.Entities.Orcamento;
import com.github.jadilson22a.Entities.Tipo;

public record CotacaoMaxDTO(
		String id,
		List<Integer> requisicoes, 
		boolean concluido, 
		Tipo tipo, 
		List<Orcamento> orcamentos, 
		Integer pedido) {

}
