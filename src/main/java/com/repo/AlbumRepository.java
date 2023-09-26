package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.entity.AlbumEntity;

public interface  AlbumRepository extends CrudRepository<AlbumEntity, Long>{

}