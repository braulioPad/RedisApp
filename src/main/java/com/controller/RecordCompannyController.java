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

import com.entity.RecordCompanyEntity;
import com.model.ResponseModel;
import com.service.IRecordCompanyService;

@RestController
@RequestMapping(path = "v1/record")
public class RecordCompannyController {
	
	@Autowired
	private IRecordCompanyService service;
	
	@GetMapping
	public ResponseEntity<ResponseModel> getAll(){
		Set<RecordCompanyEntity> result = this.service.getAll();
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success");
		return ResponseEntity.ok().body(response);
	}
	
	@PostMapping
	public ResponseEntity<ResponseModel> save(@RequestBody RecordCompanyEntity record) {
		RecordCompanyEntity result = this.service.save(record);
		ResponseModel response = new ResponseModel(LocalDateTime.now(), result, "Success");
		return ResponseEntity.ok().body(response);
	}

}
