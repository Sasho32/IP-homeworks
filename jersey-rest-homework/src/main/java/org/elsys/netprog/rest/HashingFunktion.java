package org.elsys.netprog.rest;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

import javax.xml.bind.DatatypeConverter;

public class HashingFunktion {
	
	private String myHash;
	private byte[] input;
	
	public HashingFunktion(byte[] arr){
		Random random = new Random();
		random.nextBytes(arr);
		input = arr;
		MessageDigest md5;
		try {
			md5 = MessageDigest.getInstance("MD5");
			md5.update(arr);
			byte[] digest = md5.digest();
			myHash = DatatypeConverter.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	   
	}
	
	public String returnHash(){
		return myHash;
	}
	public String returnInput(){
		String encode = Base64.getEncoder().encodeToString(input);
		return encode;
	}
}
