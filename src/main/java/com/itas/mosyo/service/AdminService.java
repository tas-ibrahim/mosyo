package com.itas.mosyo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.itas.mosyo.model.Admin;
import com.itas.mosyo.repository.AdminRepository;


@Service
public class AdminService implements UserDetailsService{

	@Autowired
	AdminRepository adminRepository;
	
	public Admin findByUsername (String username){

        return adminRepository.findByUsername(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		Admin user = null;
	    	
    	try {
            user = findByUsername(username);

            return user;
        
    	} 
    	catch (Exception e) {
            throw new RuntimeException(e);
        }
        
        finally{
        	if(user == null)
        		throw new UsernameNotFoundException("");
        }
	
	}
	
}
