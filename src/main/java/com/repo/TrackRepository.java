package com.repo;

import org.springframework.data.repository.CrudRepository;

import com.entity.TrackEntity;

public interface TrackRepository extends CrudRepository<TrackEntity, Long>{

}
