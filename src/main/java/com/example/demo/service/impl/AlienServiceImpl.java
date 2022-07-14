package com.example.demo.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Alien;
import com.example.demo.repository.AlienRepo;
import com.example.demo.service.AlienService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AlienServiceImpl implements AlienService {

	@Autowired
	AlienRepo repo;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Override
	public Alien getAlienById(int id) {
		Optional<Alien> alien = repo.findById(id);
		return alien.isPresent()?alien.get():null;
	}

	@Override
	public String getAlienAll() {
		List<Alien> result = new ArrayList<>();
		List<Alien> listAlien = (List<Alien>) repo.findAll();
		listAlien.stream().sorted(Comparator.comparing(Alien::getParentid));
		
		listAlien.stream().forEach(n -> {
			Alien e = (Alien) n;
			if(e.getParentid() == 0)
				result.add(e);
			else {
				try {
					result.stream().filter(p->((Alien)p).getId() == e.getParentid()).findAny().get().addChild(e);
				} catch(NoSuchElementException ex) {
					result.stream().forEach(j-> {
						Optional o = j.getChild().stream().filter(k->((Alien)k).getId() == e.getParentid()).findAny();
						if(o.isPresent())
							((Alien) o.get()).addChild(e);
					});
				}
			}
		});
		
		try {
			return mapper.writeValueAsString(result);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
