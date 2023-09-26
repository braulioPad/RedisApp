package com.controller;

import java.time.LocalDateTime;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.TrackEntity;
import com.model.ResponseModel;
import com.service.ITrackService;

@RestController
@RequestMapping(path = "v1/track")
public class TrackController {
	
	@Autowired
	private ITrackService service;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAll(){
		Set<TrackEntity> result = this.service.getAll();
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success");
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save(@RequestBody TrackEntity track) {
		TrackEntity result = this.service.save(track);
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success");
		return ResponseEntity.ok().body(response);
	}

	@DeleteMapping(path = "{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
	

}
