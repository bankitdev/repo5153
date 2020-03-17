package com.aadhaar.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.UriInfo;

import org.apache.log4j.Logger;
import org.json.JSONException;

import com.aadhaar.api.services.RemmitanceService;
import com.util.DMRPropertyLoader;

import net.sf.json.JSONObject;

@Path("/recipient")
public class RecipientController {
	private static Logger log = Logger.getLogger(RecipientController.class);
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/add")
	public JSONObject addRecipient(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing addRecipient method of RecipientController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("mobileNo") && jsObject.has("accountNo") && jsObject.has("recipientName") && jsObject.has("ifsc") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.addRecipient(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/fetchAll")
	public JSONObject listOfRecipient(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing listOfRecipient method of RecipientController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("customerId") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.listOfRecipient(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/fetch")
	public JSONObject getRecipientDetails(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing getRecipientDetails method of RecipientController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("customerId") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getRecipientDetails(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/delete")
	public JSONObject deleteRecipient(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		JSONObject jsonObject=new JSONObject();
		log.info("executing deleteRecipient method of RecipientController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		if(jsObject.has("customerId") && jsObject.has("recipientId") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.deleteRecipient(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	
}
