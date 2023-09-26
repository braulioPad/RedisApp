package com.controller;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.AlbumEntity;
import com.model.ResponseModel;
import com.service.IAlbumService;

@RestController
@RequestMapping(path = "v1/album")
public class AlbumController {
	
	@Autowired
	private IAlbumService service;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAll(){
		Set<AlbumEntity> result = this.service.getAll();
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success");
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save(@RequestBody AlbumEntity album) {
		AlbumEntity result = this.service.save(album);
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success");
		return ResponseEntity.ok().body(response);
	}
	
}
