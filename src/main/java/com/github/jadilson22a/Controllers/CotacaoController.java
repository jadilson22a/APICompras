package com.github.jadilson22a.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jadilson22a.Entities.Cotacao;
import com.github.jadilson22a.Services.CotacaoService;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

	@Autowired
	private CotacaoService service;
	
	@PostMapping
	public ResponseEntity<Object> criar(@RequestBody Cotacao cotacao){
		try {
			service.criar(cotacao);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
