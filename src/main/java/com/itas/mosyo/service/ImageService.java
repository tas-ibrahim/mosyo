package com.itas.mosyo.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.StorageClient;
import com.itas.mosyo.util.AppUtil;
import com.itas.mosyo.util.StringUtil;


@Service
public class ImageService {

	@Value("${bucket.name}")
	private String BUCKET_NAME;
	
	@Value("${image.server}")
	private String IMAGE_SERVER;
	
	@EventListener
	public void init(ApplicationReadyEvent event){
		
		initializeFirebase();
		
	}
	

	private void initializeFirebase(){
		
		try{
	
			ClassPathResource serviceAccount = new ClassPathResource("mosyo-firebase-conf.json");

			FirebaseOptions options = new FirebaseOptions.Builder()
				.setCredentials(GoogleCredentials.fromStream(serviceAccount.getInputStream()))
			    .setStorageBucket(BUCKET_NAME)
			    .build();
			
			FirebaseApp.initializeApp(options);
			
		}
		catch(Exception ex){
			
			ex.printStackTrace();
			
		}
		
	}
	
	public String uploadToFirebase(MultipartFile imageFile){
		
		if(imageFile == null)
			return null;
		
		try{
			
			    Bucket bucket = StorageClient.getInstance().bucket();
			    
			    String name = UUID.randomUUID().toString() + AppUtil.getFileExtension(imageFile.getOriginalFilename());
			    
			    bucket.create(name, imageFile.getBytes(), imageFile.getContentType());
			    
			    return name;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
			return null;
			
		}
		
	}
	
	public boolean deleteImageFromFirebase(String name){
		
		if(StringUtil.isNothing(name)){
			return false;
		}
		
		try{
			
			Bucket bucket = StorageClient.getInstance().bucket();
			
			Blob blob = bucket.get(name);
			
			if(blob != null)
				return blob.delete();
			
			
			return false;
			
		}
		catch(Exception ex){
			ex.printStackTrace();
			
			return false;
			
		}
		
	}
	
	
}
