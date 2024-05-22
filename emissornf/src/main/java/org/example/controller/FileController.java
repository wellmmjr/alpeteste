package org.example.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.common.net.HttpHeaders;

import org.example.data.dto.v1.model.UploadFileResponseDTO;
import org.example.services.FileStorageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Files Upload Endpoints", description = "Provides upload files services", 
tags= {"FilesStream Endpoints", "Files Stream"})
@RestController
@RequestMapping("/api/files/v1")
public class FileController {
	
	private static final Logger logger = LoggerFactory.getLogger(FileController.class);
	
	@Autowired
	private FileStorageService fileStorageService;

	@ApiOperation(value="Uploads file sent by POST Request")
	@PostMapping(value="/uploadFile", produces = {"application/json", "application/xml", "application/x-yaml"})
	public UploadFileResponseDTO uploadFile(@RequestParam("file" ) MultipartFile file){
		
		String fileName = this.fileStorageService.storeFile(file);
		
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				.path("/api/files/v1/downloadFile/")
				.path(fileName)
				.toUriString();
		
		return new UploadFileResponseDTO(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}
	
	
	@ApiOperation(value="Uploads Multiple files once sent by POST Request")
	@PostMapping(value="/uploadMultipleFiles", produces = {"application/json", "application/xml", "application/x-yaml"})
	public List<UploadFileResponseDTO> uploadMultipleFile(@RequestParam("files" ) MultipartFile[] files){
		
		return Arrays.asList(files)
				.stream()
				.map(file -> uploadFile(file))
				.collect(Collectors.toList());
	}
	
	@ApiOperation(value="Downloads the requested file")
	@GetMapping("/downloadFile/{fileName:.+}")
	public ResponseEntity<Resource> dowloadFile(@PathVariable String fileName, HttpServletRequest request) {
		
		Resource resource = fileStorageService.loadFileAsResource(fileName);
		
		String contentType = null;
		
		try {
			contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());
		} catch (Exception e) {
			logger.info("Could not determinate file type");
		}
		
		if (contentType == null) {
			
			contentType = "application/octet-stream";
			
		}
		
		return ResponseEntity.ok()
				.contentType(MediaType.parseMediaType(contentType))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+resource.getFilename()+"\"")
				.body(resource);
		
	}

}
