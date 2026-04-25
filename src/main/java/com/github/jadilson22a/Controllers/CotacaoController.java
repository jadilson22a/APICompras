package com.github.jadilson22a.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.jadilson22a.Dtos.CotacaoMinDTO;
import com.github.jadilson22a.Services.CotacaoService;

@RestController
@RequestMapping("/cotacao")
public class CotacaoController {

	@Autowired
	private CotacaoService service;
	
	@PostMapping
	public ResponseEntity<Object> criar(@RequestBody CotacaoMinDTO dto){
		try {
			service.criar(dto);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping
	public ResponseEntity<Object> deletar(String id){
		try {
			service.deletar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.UNPROCESSABLE_CONTENT);
		}
	}
}
