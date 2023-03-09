package com.example.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.service.ExcelSheetService;

@RestController
public class ExcelSheetController
{

	@Autowired
	ExcelSheetService service;

		@PostMapping("/upload")
		public  ResponseEntity<byte[]> uploadData(@RequestParam("file") MultipartFile file) throws IOException
		{
			    HttpHeaders headers = new HttpHeaders();
		        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		        headers.setContentDispositionFormData("attachment", "Employee.xlsx");
		        byte[] bytes = service.uploadFile(file);
		        
		        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
			
		} 
}
