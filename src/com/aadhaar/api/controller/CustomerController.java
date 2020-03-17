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

@Path("/customer")
public class CustomerController {
	private static Logger log = Logger.getLogger(CustomerController.class);
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/create")
	public JSONObject addCustomer(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing addCustomer method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		log.info("getRemoteAddr ::::::::::::::"+request.getRemoteAddr());
		log.info("getRemoteHost ::::::::::::::"+request.getRemoteHost());
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("mobileNo") && jsObject.has("name") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.addCustomer(jsObject,channelHeader,uri.getPath(),request);
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
	public JSONObject getCustomerDetails(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing getCustomerDetails method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("mobileNo") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getCustomerDetails(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/verify")
	public JSONObject verifyCustomerDetails(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing verifyCustomerDetails method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("mobileNo") && jsObject.has("otp") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.verifyCustomerDetails(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
}
