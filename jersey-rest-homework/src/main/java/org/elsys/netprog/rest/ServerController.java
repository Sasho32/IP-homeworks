package org.elsys.netprog.rest;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.DatatypeConverter;

import org.json.JSONObject;




@Path("/server")
public class ServerController {
	
    static private int l = 1;
    static private byte[] i = new byte[l];
    static private HashingFunktion hashf = new HashingFunktion(i);
    static private String hash = hashf.returnHash();
    
    @GET
    @Path("/getHashAndLenght")
    @Produces(value={MediaType.APPLICATION_JSON})
    public Response getHash(){
    	 JSONObject data = new JSONObject();
    	 data.put("hash", hash);
    	 data.put("len", l);
         return Response.status(200).entity(data.toString()).build();
    }
   
    @POST
    @Path("/guessHashAndInput/{input}")
    @Produces(value={MediaType.APPLICATION_JSON})
    public  Response guess(@PathParam("input") String input) throws Exception{
        if (input.equals(hashf.returnInput()))
        {
        	hashf = new HashingFunktion(i);
            return Response.status(200).build();
        }else
        {
            return Response.status(406).build();
        }
    }
}
