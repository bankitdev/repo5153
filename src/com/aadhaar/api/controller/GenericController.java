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

@Path("/generic")
public class GenericController {
	private static Logger log = Logger.getLogger(GenericController.class);
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/kyc")
	public JSONObject updateKYC(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing updateKYC method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("mobileNo") && jsObject.has("txnId") && jsObject.has("otp") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.updateKYC(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsObject;
		
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/otp")
	public JSONObject getOtp(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		JSONObject jsonObject=new JSONObject();
		log.info("executing getOtp method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		
		if(jsObject.has("mobileNo") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getOtp(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/refundotp")
	public JSONObject getRefundOtp(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		JSONObject jsonObject=new JSONObject();
		log.info("executing getRefundOtp method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		
		if(jsObject.has("customerId") && jsObject.has("apiId")&& jsObject.has("txnId") ){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getRefundOtp(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/banks/fetch")
	public JSONObject getBankList(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		JSONObject jsonObject=new JSONObject();
		log.info("executing getBankList method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		
		if(jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getBankList(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/banks/detail")
	public JSONObject getBankDetails(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		JSONObject jsonObject=new JSONObject();
		log.info("executing getBankDetails method of CustomerController class");
		log.info("eip address is::::"+request.getRemoteAddr());
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		
		if(jsObject.has("apiId") && jsObject.has("bankCode")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getBankDetails(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/balance")
	public JSONObject getAPIBalance(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		JSONObject jsonObject=new JSONObject();
		log.info("executing getAPIBalance method of CustomerController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		
		if(jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.getAPIBalance(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
}
