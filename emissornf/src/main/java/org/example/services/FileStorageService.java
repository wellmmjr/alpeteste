package org.example.services;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import org.example.config.FileStorageConfig;
import org.example.exception.FileStorageException;
import org.example.exception.MyFileStorageException;

@Service
public class FileStorageService {

	private final Path fileStorageLocation;
	
	@Autowired
	public FileStorageService(FileStorageConfig fileStorageConfig) {
		this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();
		
		try {
			Files.createDirectories(this.fileStorageLocation);
		} catch (Exception e) {
			throw new FileStorageException("Could not create the directory where the uploaded files would be storaged", e);
			
		}
	}
	
	public String storeFile(MultipartFile file) {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		try {
			if (fileName.contains("..")) {
				throw new FileStorageException("File name contains invalid path sequence "+fileName);
			}
			
			Path targetLocation = this.fileStorageLocation.resolve(fileName);
			Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
			
			return fileName;
		} catch (Exception e) {
			throw new FileStorageException("Could not store file "+fileName+" please try again", e);
		}
	}
	
	public Resource loadFileAsResource(String fileName) {
		
		try {
			Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
			
			Resource resource = new UrlResource(filePath.toUri());
			
			if (resource.exists()) {
				return resource;
			}else {
				throw new MyFileStorageException("File not found: "+fileName);
			}
		} catch (Exception e) {
			throw new MyFileStorageException("File not found: "+fileName, e);
		}
		
	}

}
