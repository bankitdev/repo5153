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
@Path("/transact")
public class TransactionController {
	private static Logger log = Logger.getLogger(TransactionController.class);
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/refund")
	public JSONObject refundTransaction(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing refundTransaction method of TransactionController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("txnId")  && jsObject.has("apiId") && jsObject.has("customerId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.refundTransaction(jsObject,channelHeader,uri.getPath(),request);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/doremit")
	public JSONObject remitTransaction(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing remitTransaction method of TransactionController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("amount") && jsObject.has("customerId") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.remitTransaction(jsObject,channelHeader,uri.getPath(),request);
			log.info("remitTransaction response"+jsonObject);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
		
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/RecipeintEnquiry")
	public JSONObject accountVerification(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing accountVerification method of TransactionController class");
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
			jsonObject=remmitanceService.accountVerification(jsObject,channelHeader,uri.getPath(),request);
			log.info("remitTransaction response"+jsonObject);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
		
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/searchtxn")
	public JSONObject searchTransaction(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing searchTransaction method of TransactionController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("txnId") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.searchTransaction(jsObject,channelHeader,uri.getPath(),request);
			log.info("remitTransaction response"+jsonObject);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
		
	}
	
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/pendingtxnlist")
	public JSONObject pendingTransactionList(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing pendingTransactionList method of TransactionController class");
		log.info("JSONObject ::::::::::::::"+jsObject);
		String channelHeader;
		if(httpHeaders.getRequestHeaders().containsKey("channel")){
		 channelHeader = httpHeaders.getRequestHeader("channel").get(0);
	
		}else{
			channelHeader="channel2";
		}
		log.info("channelHeader"+channelHeader);
		JSONObject jsonObject=new JSONObject();
		if(jsObject.has("agentCode") && jsObject.has("apiId")){
			RemmitanceService remmitanceService=new RemmitanceService();
			jsonObject=remmitanceService.pendingTransactionList(jsObject,channelHeader,uri.getPath(),request);
			log.info("remitTransaction response"+jsonObject);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
		
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/transactionhistory")
	public JSONObject transactionHistory(JSONObject jsObject,@Context HttpHeaders httpHeaders,@Context UriInfo uri,@Context HttpServletRequest request) throws JSONException
	{
		log.info("executing transactionHistory method of TransactionController class");
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
			jsonObject=remmitanceService.transactionHistory(jsObject,channelHeader,uri.getPath(),request);
			log.info("remitTransaction response"+jsonObject);
		}else{
			jsonObject.put("errorMsg",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_msg"));
			jsonObject.put("errorCode",DMRPropertyLoader.getInstance().getPropertyMap().get("json_valid_code"));
		}
		return jsonObject;
		
		
	}
}
