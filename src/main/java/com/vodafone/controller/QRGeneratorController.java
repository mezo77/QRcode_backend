package com.vodafone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vodafone.dto.PhoneDTO;
import com.vodafone.service.QRGeneratorService;

@RestController
//@CrossOrigin(origins = "*", allowCredentials = "false", allowedHeaders = "*")
@RequestMapping("/qr-generator")
public class QRGeneratorController {

	@Autowired
	private QRGeneratorService qrGeneratorService;

	@GetMapping(value = "/qr-code")
	public ResponseEntity<?> generateQRCode() throws Exception {
		ResponseEntity<?> responseEntity = null;
		
		PhoneDTO phoneDtoToBeReturned = qrGeneratorService.generateBarCode("qr_code");
		responseEntity = new ResponseEntity<>(phoneDtoToBeReturned, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping(value = "/pdf-417")
	public ResponseEntity<?> generatePDF417Code() throws Exception {
		ResponseEntity<?> responseEntity = null;
		
		PhoneDTO phoneDtoToBeReturned = qrGeneratorService.generateBarCode("pdf_417");
		responseEntity = new ResponseEntity<>(phoneDtoToBeReturned, HttpStatus.OK);
		
		return responseEntity;
	}
	
	@GetMapping(value = "/data-matrix")
	public ResponseEntity<?> generateAztecCode() throws Exception {
		ResponseEntity<?> responseEntity = null;
		
		PhoneDTO phoneDtoToBeReturned = qrGeneratorService.generateBarCode("data_matrix");
		responseEntity = new ResponseEntity<>(phoneDtoToBeReturned, HttpStatus.OK);
		
		return responseEntity;
	}

}
