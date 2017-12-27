package com.itas.mosyo.repository;

import com.itas.mosyo.model.Admin;

public interface AdminRepository extends BaseRepository<Admin>{

	public Admin findByUsername(String username);
	
	
}
