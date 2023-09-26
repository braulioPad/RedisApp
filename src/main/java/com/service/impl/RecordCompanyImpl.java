package com.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.RecordCompanyEntity;
import com.repo.RecordCompanyRepository;
import com.service.IRecordCompanyService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class RecordCompanyImpl implements IRecordCompanyService {
	
	@Autowired
	private RecordCompanyRepository repository;

	@Override
	public Set<RecordCompanyEntity> getAll() {
		Set<RecordCompanyEntity> response = new HashSet<>();
		this.repository.findAll().forEach(response::add);
		return response;
	}

	@Override
	public RecordCompanyEntity save(RecordCompanyEntity entity) {
		return this.repository.save(entity);
	}

}
