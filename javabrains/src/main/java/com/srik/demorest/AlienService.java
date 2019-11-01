package com.srik.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.srik.demorest.alien.AlienResource;

@Path("/alien")
public class AlienService {
	
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<AlienResource> getAlien(){
		AlienResource a1 =  new AlienResource("Srikanth",37);
		AlienResource a2 = new AlienResource("Shailaja", 36);
		
		return Arrays.asList(a1,a2);
	}
}
