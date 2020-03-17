package com.aadhaar.api.controller;

import javax.servlet.http.HttpServletRequest;

import com.aadhaar.api.dao.CommonServicesDao;
import com.aadhaar.api.dao.RemmitanceDao;
import com.aadhaar.api.services.RemmitanceService;
import com.util.AadhaarshilaProperties;
import com.util.DMRPropertyLoader;

import net.sf.json.JSONObject;

public class Test {

	public static void main(String[] args) {
		RemmitanceDao remmitanceDao=new RemmitanceDao();
		String url = DMRPropertyLoader.getInstance().getPropertyMap().get("mobilewareURL");
		/*String vendor = "DMR-AREMIT";
		String operator = "DMR-AREMIT";
		String sub_service = "DMR-AREMIT";
		String service = "A-REMIT";
		RemmitanceDao remmitanceDao=new RemmitanceDao();
		String a="{\"apiId\":\"10011\",\"AgentAuthId\":\"RNFI SERVICES 085737\",\"AgentAuthPassword\":\"a81pwz5e0j\",\"agentCode\":\"20174032\",\"recSeqId\":\"301567\",\"customerId\":\"8285593182\",\"amount\":\"5\",\"clientRefId\":\"99323149\",\"currency\":\"INR\"}";
		JSONObject jsonObject=JSONObject.fromObject(a);
		String status=remmitanceDao.insertAESApiTransaction(jsonObject.getLong("apiId"),jsonObject.getString("clientRefId"),UtilityP.createMultipleTransactionID(jsonObject.getString("apiId")),
				vendor,sub_service,service,operator,Double.valueOf("5"),"8285593182","","111",jsonObject.optString("accountNumber"),jsonObject.optString("ifscCode"),null);
		System.out.println(status);
		String apiresponse ="{\"data\":{\"serviceTax\":\"0\",\"clientRefId\":\"99323149\",\"fee\":\"0\",\"initiatorId\":\"1\",\"accountNumber\":\"3478166824\",\"txnStatus\":\"01\",\"name\":\"\",\"customerId\":\"8285593182\",\"ifscCode\":\"CBIN0280382\",\"impsRespCode\":\"N00006\",\"impsRespMessage\":\"Not getting response from NPCI\",\"txnId\":\"719617549594\",\"timestamp\":\"15/07/2017 17:46:41\"},\"errorCode\":\"01\",\"Reason\":\"PENDING\",\"errorMsg\":\"PENDING\"}";
		JSONObject	jresponse = JSONObject.fromObject(apiresponse);
		JSONObject dataArray =jresponse.optJSONObject("data");
		if (jresponse.getString("errorCode").equals("00") && jresponse.getString("errorMsg").equalsIgnoreCase("Success")) {
			System.out.println("Success");
			}
			else if (jresponse.getString("errorCode").equals("01")
					&& jresponse.getString("errorMsg").equalsIgnoreCase("PENDING")) {
				System.out.println("pending");
				remmitanceDao.updatePendingStatus(jsonObject.getString("clientRefId"),dataArray.optString("txnId"));
				remmitanceDao.updateBankDetails(dataArray.optString("accountNumber"),dataArray.optString("ifscCode"),null,dataArray.getString("clientRefId"));
			}
		
			else if (jresponse.getString("errorCode").equals("02")
					&& jresponse.getString("errorMsg").equalsIgnoreCase("Failure")) {
				System.out.println("Failure");
			}*/
		/*String apiresponse=null;
		JSONObject jsonObject=new JSONObject();
		jsonObject.put("apiId", "10011");
		jsonObject.put("txnId", "993231491");
		JSONObject	jresponse;
		HashMap<String,String> transactionMap=remmitanceDao.transactionStatus(Long.parseLong(jsonObject.optString("apiId")), jsonObject.optString("txnId"));
	
		if(transactionMap!=null){
			System.out.println(transactionMap.toString());
			String errorcode="00";
			if(transactionMap.get("tranStatus").equals("Success")){
				errorcode="00";
			}
			else if(transactionMap.get("tranStatus").equals("Pending")){
				errorcode="01";
			}
			else if(transactionMap.get("tranStatus").equals("Success")){
				errorcode="02";
			}
		apiresponse ="{\"data\":{\"serviceTax\":\"0\",\"clientRefId\":\'"+jsonObject.optString("txnId")+"',\"fee\":\"0\",\"initiatorId\":\"1\",\"accountNumber\":'"+transactionMap.get("account")+"',\"txnStatus\":'"+errorcode+"',\"name\":\"\",\"customerId\":'"+transactionMap.get("customerid")+"',\"ifscCode\":'"+transactionMap.get("ifsc")+"',\"txnId\":'"+transactionMap.get("impsno")+"'},\"errorCode\":'"+errorcode+"',\"Reason\":'"+transactionMap.get("tranStatus")+"',\"errorMsg\":'"+transactionMap.get("tranStatus")+"'}";
		jresponse = JSONObject.fromObject(apiresponse);
		}else{
			apiresponse ="{\"data\":{},\"errorCode\":\"V0022\",\"errorMsg\":\"Client Ref Id and transaction Id does not match with the database:\"}";
			jresponse = JSONObject.fromObject(apiresponse);
			
		}
		System.out.println(jresponse.toString());*/
		String a="{\"apiId\":\"10011\",\"AgentAuthId\":\"SUSHIL175758\",\"AgentAuthPassword\":\"sz8gfn9bmr\",\"agentCode\":\"20173315\",\"txnId\":\"99353508\",\"initiatorId\":\"1\",\"hashKey\":\"c3ccdee37073bf827313261162f4d6fc\"}";
		JSONObject	jsonObject = JSONObject.fromObject(a);
		RemmitanceService remmitanceService=new RemmitanceService();;
		CommonServicesDao commonServicesDao = new CommonServicesDao();
		HttpServletRequest request = null;
		JSONObject jresponse =remmitanceService.checkAPIIdExist(jsonObject,request);
		System.out.println("jresponse::::::::::::::::::::::::::"+jresponse);
		if (!jresponse.getString("errorCode").equals("00")) {
			commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), "","");
		}
	}
	
	public static JSONObject checkAPIIdExist(JSONObject jsonObject,HttpServletRequest request) {
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			RemmitanceDao remmitanceDao=new RemmitanceDao();
			System.out.println(jsonObject.getString(AadhaarshilaProperties.AgentAuthId));
			long clientId=remmitanceDao.validateClient(jsonObject.getString(AadhaarshilaProperties.AgentAuthId)
					,jsonObject.getString(AadhaarshilaProperties.AgentAuthPassword),"27.251.76.25");
			/*if(clientId!=-1){
			long apiId = jsonObject.getLong("apiId");
			boolean status = commonServicesDao.checkAPIIdExist(apiId);
			if (status == false) {
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiIdExist_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiIdExist_msg"));
			} else {
				jresponse.put("errorCode", "00");
			}
			}else{
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_msg"));
			}*/
		} catch (Exception e) {
			e.printStackTrace();
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}
}
