package com.vodafone.service;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.apache.axis.encoding.Base64;
import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.aztec.AztecWriter;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.DataMatrixWriter;
import com.google.zxing.pdf417.PDF417Writer;
import com.google.zxing.qrcode.QRCodeWriter;
import com.vodafone.dto.PhoneDTO;

@Service
public class QRGeneratorService {

	
	
	
	
	public BufferedImage generateCodeImage(String barcodeText, String encoding) throws Exception {
		BitMatrix bitMatrix = null;
		if(encoding.equalsIgnoreCase("qr_code")) {
			QRCodeWriter barcodeWriter = new QRCodeWriter();
			 bitMatrix = barcodeWriter.encode(barcodeText, BarcodeFormat.QR_CODE, 100, 100);
		} else if(encoding.equalsIgnoreCase("pdf_417")) {
			PDF417Writer pdfWritter = new PDF417Writer();
			bitMatrix = pdfWritter.encode(barcodeText, BarcodeFormat.PDF_417, 100, 100);
		}else if(encoding.equalsIgnoreCase("data_matrix")) {
			DataMatrixWriter dataMatrix = new DataMatrixWriter();
			 bitMatrix = dataMatrix.encode(barcodeText, BarcodeFormat.DATA_MATRIX, 100, 100);
		} else {
			throw new Exception("The encoding is not supported by our backend system");
		}

		return MatrixToImageWriter.toBufferedImage(bitMatrix);
	}
	
	public PhoneDTO generateBarCode(String encoding) throws Exception {
		PhoneDTO phoneDto = new PhoneDTO();
		phoneDto.setBrand("Apple_Muataz");
		phoneDto.setModel("iphone xs");
		phoneDto.setMainCamera("12 MP");
		phoneDto.setNetwork("GSM/CDMA/HSPA");
		phoneDto.setOs("ios 12 upgradable to ios 13.3");
		phoneDto.setLaunchDate("2018, September");
		phoneDto.setSelfieCamera("7 MP");
		phoneDto.setMemory("		Card slot: NO\n		Internal: 64GB 4GB RAM, 256GB 4GB RAM, 512GB 4GB RAM");
		phoneDto.setSound("Loudspeaker: yes, with stereo speakers\n3.5mm jack: No");
		phoneDto.setSensors("Face ID, accelerometer, gyro, proximity, compass, barometer");
		phoneDto.setBattery("Non-removable Li-lon 2658 mAh battery (10.13 Wh)");
		BufferedImage barcodeimg = generateCodeImage(phoneDto.toString(), encoding);
		ByteArrayOutputStream bArrayOS = new ByteArrayOutputStream();
		ImageIO.write(barcodeimg, "png", bArrayOS);
		ImageIO.write(barcodeimg, "png", new FileOutputStream(new File("barcode_spec_base64.png")));
		byte[] byteArray = bArrayOS.toByteArray();
		String barcode = Base64.encode(byteArray);
		phoneDto.setBase64Image(barcode);
		
		System.out.println(barcode);
		
		return phoneDto;
	}
	
	
	
}
