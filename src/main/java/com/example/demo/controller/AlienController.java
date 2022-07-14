package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Annotations.LogMethodParam;
import com.example.demo.service.AlienService;

@RestController
@RequestMapping("/")
public class AlienController {

	@Autowired
	AlienService service;
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@LogMethodParam
	public ResponseEntity getById(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.getAlienById(id));
	}
	
	@GetMapping("/all")
	public ResponseEntity getAll() {
		return ResponseEntity.ok(service.getAlienAll());
	}
}
