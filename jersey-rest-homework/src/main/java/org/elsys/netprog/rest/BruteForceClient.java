package org.elsys.netprog.rest;

import org.json.JSONObject;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequest;

public class BruteForceClient {
	
	public static void main(String [] args) throws UnirestException
	{
			HttpRequest req = Unirest.get("http://localhost:8080/jersey-rest-homework/server/getHashAndLenght");
			HttpResponse<JsonNode> json = req.asJson();
			JSONObject data = json.getBody().getObject();
			String serverh = data.getString("hash");
			int serverl = data.getInt("len");
			byte[] i = new byte[serverl];			
			for(;;){
				HashingFunktion hashf = new HashingFunktion(i);
			    String programh = hashf.returnHash();
				if(programh.equals(serverh)){
					HttpResponse<String> request2 = Unirest.post("http://localhost:8080/jersey-rest-homework/server/guessHashAndInput/" + hashf.returnInput()).field("test", "test").asString();
//					if(request2.getStatus() != 200){
//						// in case other BruteForceClient guessed it already
//						req = Unirest.get("http://localhost:8080/jersey-rest-homework/server/getHashAndLenght");
//						json = req.asJson();
//						data = json.getBody().getObject();
//						serverh = data.getString("hash");
//						serverl = data.getInt("len");
//						continue;
//					}
					System.out.println("success input: " + hashf.returnInput() + " hash: " + programh);
					break;
				}
			}
	}
}
