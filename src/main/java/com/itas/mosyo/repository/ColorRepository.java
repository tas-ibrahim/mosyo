package com.itas.mosyo.repository;

import com.itas.mosyo.model.Color;

public interface ColorRepository extends BaseRepository<Color>{

	public Color findById(long id);
	
}
