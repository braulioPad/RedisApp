package com.service;

import com.common.SimpleService;
import com.entity.TrackEntity;

public interface ITrackService extends SimpleService<TrackEntity>{

	
	public void delete(Long id);
}
