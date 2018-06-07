package com.tanmay.auth.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.simple.parser.ParseException;

import com.tanmay.auth.dao.DataFactory;

@Path("/auth")
public class LoginService {

	@GET
	@Path("/data")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg() throws FileNotFoundException, IOException, ParseException {
		System.out.println("Request Recieved");
		return Response.status(200).entity(DataFactory.getData1()).header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods", "POST, GET, PUT, UPDATE, OPTIONS").header("Access-Control-Allow-Headers", "Content-Type, Accept, X-Requested-With").build();

	}
}
