package com.itas.mosyo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itas.mosyo.model.Color;

public interface ColorRepository extends BaseRepository<Color>{

	public Color findById(Long id);
	
	@Query("select c from Color c where lower(c.name) = lower(:name)")
	public Color findByName(@Param("name") String name);
	
}
