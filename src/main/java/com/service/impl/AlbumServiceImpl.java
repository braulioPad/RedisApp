package com.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.AlbumEntity;
import com.repo.AlbumRepository;
import com.service.IAlbumService;

import jakarta.transaction.Transactional;


@Service
@Transactional
public class AlbumServiceImpl implements IAlbumService {

	@Autowired
	private AlbumRepository repository;

	@Override
	public Set<AlbumEntity> getAll() {
		Set<AlbumEntity> response = new HashSet<>();
		this.repository.findAll().forEach(response::add);
		return response;
	}

	@Override
	public AlbumEntity save(AlbumEntity entity) {
		if(entity.getName().equalsIgnoreCase("Exception")) {
			throw new IllegalArgumentException("Te name of album cant be  " + entity.getName());
		}
		return this.repository.save(entity);
	}
}
