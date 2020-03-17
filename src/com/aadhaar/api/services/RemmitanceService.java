package com.aadhaar.api.services;

import java.text.DecimalFormat;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.aadhaar.api.dao.CommonServicesDao;
import com.aadhaar.api.dao.RemmitanceDao;
import com.aadhaar.api.entity.AesAPICustomerLoginDetails;
import com.aadhaar.api.entity.AesApiOperatorDetail;
import com.util.AadhaarshilaProperties;
import com.util.DMRPropertyLoader;
import com.util.RemmitanceApiConsume;
import com.util.UtilityP;

import net.sf.json.JSONObject;

public class RemmitanceService {
	private static Logger log = Logger.getLogger(RemmitanceService.class);

	public JSONObject addCustomer(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing addCustomer method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			String urlproperty = null;
			String mobileno = jsonObject.getString("mobileNo");
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP.hashKey(mobileno.concat(initiatorId));
				jsonObject.put("hashKey", hashkey);
				jsonObject.put("customerId", mobileno);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.addcustomer,
						jsonObject.toString(), channelHeader);

				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				log.info("apiresponse::::::::::::::::" + apiresponse);
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
					if("00".equals(jresponse.getString("errorCode"))){
						try {
							commonServicesDao.saveSenderMaster(jsonObject);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			} else {
				urlproperty = "eko";
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String getcstmr = url + "mobile_number:" + mobileno + "?initiator_id="
						+ AadhaarshilaProperties.initiator_id + "";
				String apiresponse = RemmitanceApiConsume.apiCall(url + getcstmr, jsonObject.toString(), channelHeader);
				log.info("apiresponse:::" + apiresponse);
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}

			}
			log.info("jsonObject::" + jsonObject);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  addCustomer method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	public JSONObject getCustomerDetails(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getCustomerDetails method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			String urlproperty = null;
			String mobileno = jsonObject.getString("mobileNo");
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				log.info("jsonObject::" + jsonObject);
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				jsonObject.put("customerId", mobileno);
				String hashkey = UtilityP.hashKey(mobileno.concat(initiatorId));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.fetchCustomer,
						jsonObject.toString(), channelHeader);

				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			} else {
				urlproperty = "eko";
				urlproperty = "eko";
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String getcstmr = url + "mobile_number:" + mobileno + "?initiator_id="
						+ AadhaarshilaProperties.initiator_id + "";
				String apiresponse = RemmitanceApiConsume.apiCall(url + getcstmr, jsonObject.toString(), channelHeader);
				log.info("apiresponse:::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  getCustomerDetails method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	public JSONObject verifyCustomerDetails(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing verifyCustomerDetails method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String mobileno = jsonObject.getString("mobileNo");
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				jsonObject.put("customerId", mobileno);
				jsonObject.put("customerType", "1");
				String hashkey = UtilityP.hashKey(mobileno.concat(initiatorId)
						.concat(jsonObject.getString("customerType")).concat(jsonObject.getString("otp")));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.verifyCustomer,
						jsonObject.toString(), channelHeader);

				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			} else {
				urlproperty = "eko";
				urlproperty = "eko";
				urlproperty = "eko";
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String verificationurl = url + "verification/otp:540";
				String str = "initiator_id=" + AadhaarshilaProperties.initiator_id + "&id=" + mobileno
						+ "&id_type=mobile_number";
				String apiresponse = RemmitanceApiConsume.apiCall(verificationurl, str, channelHeader);
				log.info("apiresponse:::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  verifyCustomerDetails method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	public JSONObject listOfRecipient(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing listOfRecipient method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("customerId");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP.hashKey(mobileno.concat(initiatorId));
				System.out.println("hashkey:::" + hashkey);
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				System.out.println("url is:::::::::::::::::::" + url);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.fetchAllRecipient,
						jsonObject.toString(), channelHeader);

				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  listOfRecipient method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}

	public JSONObject addRecipient(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing addRecipient method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("mobileNo");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				jsonObject.put("virtualAddress", "Mumbai");
				jsonObject.put("udf1", jsonObject.getString("accountNo"));
				jsonObject.put("udf2", jsonObject.getString("ifsc"));
				String s1 = mobileno + initiatorId + jsonObject.getString("accountNo") + jsonObject.getString("ifsc");
				String hashkey = UtilityP.hashKey(s1);
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.addRecipient,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
					if("00".equals(jresponse.getString("errorCode"))){
						try {
							commonServicesDao.saveBenificiaryMaster(jsonObject,jresponse);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  addRecipient method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}

	public JSONObject getRecipientDetails(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getRecipientDetails method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("customerId");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String key=initiatorId.concat(jsonObject.getString("recipientId"));
				String hashkey = UtilityP.hashKey(key);
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.fetchRecipient,
						jsonObject.toString(), channelHeader);

				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  getRecipientDetails method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	public JSONObject deleteRecipient(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing deleteRecipient method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("customerId");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP
						.hashKey(initiatorId.concat(mobileno).concat(jsonObject.getString("recipientId")));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.deleteRecipient,
						jsonObject.toString(), channelHeader);

				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);

				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  deleteRecipient method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}

	public JSONObject remitTransaction(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing remitTransaction method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			String vendor = "DMR-AREMIT";
			String operator = "DMR-AREMIT";
			String sub_service = "DMR-AREMIT";
			String service = "A-REMIT";
			String amount=jsonObject.getString("amount");
			Double amt=Double.parseDouble(amount);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			amount = decimalFormat.format(amt);
			String mobileno = jsonObject.getString("customerId");
			String customerTransactionId=UtilityP.createMultipleTransactionID(jsonObject.getString("apiId"));
			RemmitanceDao remmitanceDao=new RemmitanceDao();
			AesApiOperatorDetail aesApiOperatorDetail = remmitanceDao.validateRequest(jsonObject.getLong("apiId"), operator,
					sub_service, service, AadhaarshilaProperties.REMITANCE_OPCODE,amount);
			if (aesApiOperatorDetail != null && "Y".equalsIgnoreCase(aesApiOperatorDetail.getStatus())) {
				if (aesApiOperatorDetail != null && aesApiOperatorDetail.getVendor_name().equalsIgnoreCase("APMAHESH")){
					vendor = "APMAHESH";
					String status=remmitanceDao.insertAESApiTransaction(jsonObject.getLong("apiId"),jsonObject.getString("clientRefId"),customerTransactionId,
							vendor,sub_service,service,operator,Double.valueOf(amount),mobileno,"",request.getRemoteAddr(),jsonObject.optString("accountNumber"),jsonObject.optString("ifscCode"),null);
					if(status.equalsIgnoreCase("insufficient_balance")){
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason","You Do Not have Sufficient Balance.");
						commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						return jresponse;
					}else if(status.equalsIgnoreCase("notinserted")){
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason","Transaction Failed Due to Technical Error. Please Try Later.");
						commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						return jresponse;
					}else if(status.equalsIgnoreCase("commisson_error")){
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason","Transaction Failed as Your Commission is Not Set Properly.");
						commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						return jresponse;
					}
					else if(!status.equalsIgnoreCase("inserted")){
						log.info("status::::::"+status);
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason",status.replaceAll("'", ""));
						commonServicesDao.insertApiLogs(jsonObject.toString(),jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						jresponse.put("reason","Transaction Failed due to duplicate transaction Id");
					}
					else if(status.equalsIgnoreCase("inserted")){

						urlproperty = "mobilewareURL";
						String initiatorId = AadhaarshilaProperties.initiatorId;
						String recipientId=jsonObject.getString("recSeqId");
						jsonObject.put("initiatorId", initiatorId);
						jsonObject.put("customerId", mobileno);
						jsonObject.put("channel", "1");
						jsonObject.put("currency", "INR");
						//jsonObject.put("clientRefId",UtilityP.createMultipleTransactionID());
						
						String hashkey = UtilityP.hashKey(initiatorId.concat(mobileno).concat(recipientId).concat(amount));
						jsonObject.put("hashKey", hashkey);
						String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
						String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.remitTransaction,
								jsonObject.toString(), channelHeader);
						log.info("apiresponse::::::::::::::::" + apiresponse);
						commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,jsonObject.getString("clientRefId"));
						if (apiresponse != null) {
							jresponse = JSONObject.fromObject(apiresponse);
							JSONObject dataArray =jresponse.optJSONObject("data");
							if (jresponse.getString("errorCode").equals("00") && jresponse.getString("errorMsg").equalsIgnoreCase("Success")) {
							remmitanceDao.updateTransactionStatus(customerTransactionId, jsonObject.getString("clientRefId"),"Success", jresponse.getString("errorCode"), dataArray.getString("txnId"), jsonObject.toString(), jresponse.toString());
							remmitanceDao.updateBankDetails(dataArray.optString("accountNumber"),dataArray.optString("ifscCode"),null,dataArray.getString("clientRefId"));
							}
							else if (jresponse.getString("errorCode").equals("01")
									&& jresponse.getString("errorMsg").equalsIgnoreCase("PENDING")) {
								String bank_reference_no=dataArray!=null?dataArray.optString("txnId"):null;
								String account_no=dataArray!=null?dataArray.optString("accountNumber"):null;
								String ifsc_code=dataArray!=null?dataArray.optString("ifscCode"):null;
								remmitanceDao.updatePendingStatus(jsonObject.getString("clientRefId"),bank_reference_no);
								remmitanceDao.updateBankDetails(account_no,ifsc_code,null,jsonObject.getString("clientRefId"));
							}
						
							else if (jresponse.getString("errorCode").equals("02")
									&& jresponse.getString("errorMsg").equalsIgnoreCase("Failure")) {
								String bank_reference_no=dataArray!=null?dataArray.optString("txnId"):null;
								String account_no=dataArray!=null?dataArray.optString("accountNumber"):null;
								String ifsc_code=dataArray!=null?dataArray.optString("ifscCode"):null;
								remmitanceDao.updateTransactionStatus(customerTransactionId, jsonObject.getString("clientRefId"),"Failure", jresponse.getString("errorCode"),bank_reference_no, jsonObject.toString(), jresponse.toString());
								remmitanceDao.updateBankDetails(account_no,ifsc_code,null,jsonObject.getString("clientRefId"));
							}
						}
					
					}
				}
				else{
					vendor = "FINO";
					log.info("Vendor is ::::::::::::::"+vendor);
					//String url="https://192.168.121.3:8443/DMRV1.1/transact/IMPS/remit";//live url
					String url="http://192.168.21.28:8080/BankitIMPSNEFT/transact/IMPS/remit";//uat url
					jsonObject.put("recipientId", jsonObject.getString("recSeqId"));
					String apiresponse=RemmitanceApiConsume.finoapiCall(url, jsonObject);
					if (apiresponse != null) {
						jresponse = JSONObject.fromObject(apiresponse);
					}
				}
			}
			else if ("insufficient_balance".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","You Do Not have Sufficient Balance.");
			} else if ("Vendor_Sr_Blk".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Service is not available. Please try later.");
				
			} else if ("Cl_Sr_Blk".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Your service has been deactived. Please contact to Support.");
			} else if ("Vendor_Not_Avail".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Vendor not available.");
			} else {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Service is not available.");
				
			}
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			jresponse.put("errorMsg","Pending");
			jresponse.put("errorCode","01");
			log.info("Error in  remitTransaction method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}
	
	
	public JSONObject accountVerification(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing accountVerification method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			String vendor = "A-REMIT";
			String operator = "Accountinfo";
			String sub_service = "AccountVerification-AREMIT";
			String service = "A-REMIT";
			jsonObject.put("amount","1"); 
			String amount=jsonObject.getString("amount");
			Double amt=Double.parseDouble(amount);
			DecimalFormat decimalFormat = new DecimalFormat("#.00");
			amount = decimalFormat.format(amt);
			String mobileno = jsonObject.getString("customerId");
			String customerTransactionId=UtilityP.createMultipleTransactionID(jsonObject.getString("apiId"));
			RemmitanceDao remmitanceDao=new RemmitanceDao();
			AesApiOperatorDetail aesApiOperatorDetail = remmitanceDao.validateRequest(jsonObject.getLong("apiId"), operator,
					sub_service, service, AadhaarshilaProperties.ACCOUNT_VERIFICATION_OPCODE,amount);
			if (aesApiOperatorDetail != null && "Y".equalsIgnoreCase(aesApiOperatorDetail.getStatus())) {
				if (aesApiOperatorDetail != null && aesApiOperatorDetail.getVendor_name().equalsIgnoreCase("APMAHESH")){
					vendor = "APMAHESH";
					String status=remmitanceDao.insertAESApiTransaction(jsonObject.getLong("apiId"),jsonObject.getString("clientRefId"),customerTransactionId,
							vendor,sub_service,service,operator,Double.valueOf(amount),mobileno,"",request.getRemoteAddr(),jsonObject.getString("udf1"),null,jsonObject.getString("udf2"));
					if(status.equalsIgnoreCase("insufficient_balance")){
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason","You Do Not have Sufficient Balance.");
						commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						return jresponse;
					}else if(status.equalsIgnoreCase("notinserted")){
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason","Transaction Failed Due to Technical Error. Please Try Later.");
						commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						return jresponse;
					}else if(status.equalsIgnoreCase("commisson_error")){
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason","Transaction Failed as Your Commission is Not Set Properly.");
						commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						return jresponse;
					}
					else if(!status.equalsIgnoreCase("inserted")){
						log.info("status::::::"+status);
						jresponse.put("errorMsg","Failure");
						jresponse.put("errorCode","02");
						jresponse.put("reason",status.replaceAll("'", ""));
						commonServicesDao.insertApiLogs(jsonObject.toString(),jresponse.toString(), apiurl,jsonObject.getString("clientRefId"));
						jresponse.put("reason","Transaction Failed due to duplicate transaction Id");
					}
					else if(status.equalsIgnoreCase("inserted")){

						urlproperty = "mobilewareURL";
						String initiatorId = AadhaarshilaProperties.initiatorId;
						jsonObject.put("initiatorId", initiatorId);
						jsonObject.put("customerId", mobileno);
						jsonObject.put("channel", "1");
						jsonObject.put("recipientType", "2");
						jsonObject.put("currency", "INR");
						String hashkey = UtilityP.hashKey(initiatorId.concat(mobileno).concat(jsonObject.getString("udf1")).concat(jsonObject.getString("udf2").toUpperCase()));
						jsonObject.put("hashKey", hashkey);
						String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
						 String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.accountverification,
								jsonObject.toString(), channelHeader);
						log.info("apiresponse::::::::::::::::" + apiresponse);
						commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,jsonObject.getString("clientRefId"));
						if (apiresponse != null) {
							jresponse = JSONObject.fromObject(apiresponse);
							JSONObject dataArray =jresponse.optJSONObject("data");
							if (jresponse.getString("errorCode").equals("00") && jresponse.getString("errorMsg").equalsIgnoreCase("Success")) {
							remmitanceDao.updateTransactionStatus(customerTransactionId, jsonObject.getString("clientRefId"),"Success", jresponse.getString("errorCode"), dataArray.getString("txnId"), jsonObject.toString(), jresponse.toString());
							}
							else if (jresponse.getString("errorCode").equals("01")
									&& jresponse.getString("errorMsg").equalsIgnoreCase("Pending")) {
								String bank_reference_no=dataArray!=null?dataArray.optString("txnId"):null;
								remmitanceDao.updatePendingStatus(jsonObject.getString("clientRefId"),bank_reference_no);
							}
						
							else if (jresponse.getString("errorCode").equals("02")
									&& jresponse.getString("errorMsg").equalsIgnoreCase("Failure")) {
								String bank_reference_no=dataArray!=null?dataArray.optString("txnId"):null;
								remmitanceDao.updateTransactionStatus(customerTransactionId, jsonObject.getString("clientRefId"),"Failure", jresponse.getString("errorCode"),bank_reference_no, jsonObject.toString(), jresponse.toString());
						}
						}
					
					}
				}else{
					vendor = "FINO";
					log.info("Vendor is ::::::::::::::"+vendor);
					String url="https://192.168.121.3:8443/DMRV1.1/transact/IMPS/remit";//live url
					//String url="http://125.63.96.115:9012/DMR/transact/IMPS/accountverification";//uat url
					String apiresponse=RemmitanceApiConsume.finoapiCall(url, jsonObject);
					if (apiresponse != null) {
						jresponse = JSONObject.fromObject(apiresponse);
					}
				}
			}else if ("insufficient_balance".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","You Do Not have Sufficient Balance.");
			} else if ("Vendor_Sr_Blk".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Service is not available. Please try later.");
				
			} else if ("Cl_Sr_Blk".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Your service has been deactived. Please contact to Support.");
			} else if ("Vendor_Not_Avail".equals(aesApiOperatorDetail.getStatus())) {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Vendor not available.");
			} else {
				jresponse.put("errorMsg","Failure");
				jresponse.put("errorCode","02");
				jresponse.put("reason","Service is not available.");
				
			}
				
			
			
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Pending");
			jresponse.put("errorCode","01");
			log.info("Error in  remitTransaction method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}
	

	public JSONObject refundTransaction(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing refundTransaction method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		String status="Success";
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,jsonObject.getString("txnId"));
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("customerId");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String txnId=jsonObject.getString("txnId");
				String otp=jsonObject.getString("otp");
				jsonObject.put("customerId", mobileno);
				String hashkey = UtilityP.hashKey(txnId.concat(otp).concat(mobileno));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.refundTransaction,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,jsonObject.getString("txnId"));
				
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
					RemmitanceDao remmitanceDao=new RemmitanceDao();
					jresponse = JSONObject.fromObject(apiresponse);
					JSONObject dataArray =jresponse.optJSONObject("data");
					if (jresponse.getString("errorCode").equals("00") && jresponse.getString("errorMsg").equalsIgnoreCase("Success")) {
						status=remmitanceDao.updateTransactionStatus(jsonObject.getString("txnId"), jsonObject.getString("txnId"),"Success", jresponse.getString("errorCode"), dataArray.getString("txnId"), jsonObject.toString(), jresponse.toString());
					}
					else if (jresponse.getString("errorCode").equals("01") && jresponse.getString("errorMsg").equalsIgnoreCase("Pending")) {
						status=remmitanceDao.updateTransactionStatus(jsonObject.getString("txnId"), jsonObject.getString("clientRefId"),"Pending", jresponse.getString("errorCode"),dataArray.optString("txnId"), jsonObject.toString(), jresponse.toString());
					}
				
					else if (jresponse.getString("errorCode").equals("02") && jresponse.getString("errorMsg").equalsIgnoreCase("Failure")) {
						status=remmitanceDao.updateTransactionStatus(jsonObject.getString("txnId"), jsonObject.getString("clientRefId"),"Failure", jresponse.getString("errorCode"), dataArray.optString("txnId"), jsonObject.toString(), jresponse.toString());
					}
					}
				else{
					status="Pending";
					jresponse.put("errorMsg",status);
					jresponse.put("errorCode","01");
				}
			} else {
				urlproperty = "eko";
			}
			jresponse.put("errorMsg",status);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			status="Pending";
			log.info("Error in  refundTransaction method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg",status);
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	public JSONObject updateKYC(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing updateKYC method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("mobileNo");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				jsonObject.put("customerId", mobileno);
				jsonObject.put("state", "1");
				String hashkey = UtilityP.hashKey(initiatorId.concat(mobileno));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.updateKYC,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  updateKYC method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	public JSONObject getOtp(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getOtp method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("mobileNo");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				jsonObject.put("customerId", mobileno);
				jsonObject.put("otpType", "1");
				String hashkey = UtilityP.hashKey(mobileno.concat(initiatorId));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.otpGenerate,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  getOtp method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}

	
	public JSONObject getRefundOtp(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getRefundOtp method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String mobileno = jsonObject.getString("customerId");
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				jsonObject.put("otpType", "2");
				String hashkey = UtilityP.hashKey(mobileno.concat(initiatorId));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.otpGenerate,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  getRefundOtp method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
		}

		return jresponse;

	}
	public JSONObject getAPIBalance(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getAPIBalance method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				RemmitanceDao remmitanceDao=new RemmitanceDao();
				double amount = remmitanceDao.getAPIBalance(Long.parseLong(jsonObject.getString("apiId")));
				DecimalFormat decimalFormat=new DecimalFormat("#.00");
				String apiresponse="{\"apibalance\":"+decimalFormat.format(amount)+"}";
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.info("Error in  getAPIBalance method of RemmitanceService class" + UtilityP.printException(e));
			jresponse.put("apibalance","0.00");
		}

		return jresponse;

	}
	
	public JSONObject getBankList(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getBankList method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP.hashKey(initiatorId);
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				log.info("apiurl is::::::::::::::::" + url+AadhaarshilaProperties.fetchbankList);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.fetchbankList,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  getBankList method of RemmitanceService class" + UtilityP.printException(e));
		}
		
		
		

		return jresponse;

	}

	public JSONObject getBankDetails(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing getBankDetails method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			log.info("jresponse::::::::::::::::::::::::::"+jresponse);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP.hashKey(initiatorId);
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.fetchbank,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  getBankDetails method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}
	
	
	public JSONObject searchTransaction(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing searchTransaction method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			log.info("jresponse::::::::::::::::::::::::::"+jresponse);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				RemmitanceDao remmitanceDao=new RemmitanceDao();
				String apiresponse=null;
				HashMap<String,String> transactionMap=remmitanceDao.transactionStatus(Long.parseLong(jsonObject.optString("apiId")), jsonObject.optString("txnId"));
			
				if(transactionMap!=null){
					log.info("transactionMap::" + transactionMap.toString());
					String errorcode="00";
					if(transactionMap.get("tranStatus").equals("Success")){
						errorcode="00";
					}
					else if(transactionMap.get("tranStatus").equals("Pending")){
						errorcode="01";
					}
					else if(transactionMap.get("tranStatus").equals("Failure")){
						errorcode="02";
					}
					else if(transactionMap.get("tranStatus").equals("Refunded")){
						errorcode="02";
					}
					apiresponse ="{\"data\":{\"serviceTax\":\"0\",\"clientRefId\":'"+jsonObject.optString("txnId")+"',\"fee\":\"0\",\"initiatorId\":\"1\",\"accountNumber\":'"+transactionMap.get("account")+"',\"txnStatus\":'"+errorcode+"',\"name\":\"\",\"customerId\":'"+transactionMap.get("customerid")+"',\"ifscCode\":'"+transactionMap.get("ifsc")+"',\"txnId\":'"+transactionMap.get("impsno")+"'},\"errorCode\":'"+errorcode+"',\"Reason\":'"+transactionMap.get("tranStatus")+"',\"errorMsg\":'"+transactionMap.get("tranStatus")+"'}";
				jresponse = JSONObject.fromObject(apiresponse);
				log.info("apiresponse::::::::::"+apiresponse);
				}else{
					apiresponse ="{\"data\":{},\"errorCode\":\"V0022\",\"errorMsg\":\"Client Ref Id and transaction Id does not match with the database:\"}";
					jresponse = JSONObject.fromObject(apiresponse);
				}
				
				//AESTE=AESTRANSACTIONENQUIRY
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"AESTE"+jsonObject.optString("txnId"));
			} else {
				urlproperty = "eko";
			}
			log.info("jresponse::::::::::"+jresponse.toString());

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Pending");
			jresponse.put("errorCode","01");
			log.info("Error in  searchTransaction method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}

	
	public JSONObject transactionHistory(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing transactionHistory method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			log.info("jresponse::::::::::::::::::::::::::"+jresponse);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP.hashKey(jsonObject.getString("customerId").concat(initiatorId.concat(jsonObject.getString("agentCode"))));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.transactionhistory,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  transactionHistory method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}
	
	
	public JSONObject pendingTransactionList(JSONObject jsonObject, String channelHeader, String apiurl,HttpServletRequest request) {
		log.info("executing pendingTransactionList method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			jresponse = checkAPIIdExist(jsonObject,request);
			log.info("jresponse::::::::::::::::::::::::::"+jresponse);
			if (!jresponse.getString("errorCode").equals("00")) {
				commonServicesDao.insertApiLogs(jsonObject.toString(), jresponse.toString(), apiurl,"");
				return jresponse;
			}
			channelHeader = DMRPropertyLoader.getInstance().getPropertyMap().get(channelHeader);
			log.info("jsonObject::" + jsonObject);
			String urlproperty = null;
			if (AadhaarshilaProperties.urlType.equalsIgnoreCase(channelHeader)) {
				urlproperty = "mobilewareURL";
				String initiatorId = AadhaarshilaProperties.initiatorId;
				jsonObject.put("initiatorId", initiatorId);
				String hashkey = UtilityP.hashKey(initiatorId.concat(jsonObject.getString("agentCode")));
				jsonObject.put("hashKey", hashkey);
				String url = DMRPropertyLoader.getInstance().getPropertyMap().get(urlproperty);
				String apiresponse = RemmitanceApiConsume.apiCall(url + AadhaarshilaProperties.pendingtransaction,
						jsonObject.toString(), channelHeader);
				log.info("apiresponse::::::::::::::::" + apiresponse);
				commonServicesDao.insertApiLogs(jsonObject.toString(), apiresponse, apiurl,"");
				if (apiresponse != null) {
					jresponse = JSONObject.fromObject(apiresponse);
				}
			} else {
				urlproperty = "eko";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Failure");
			jresponse.put("errorCode","01");
			log.info("Error in  pendingTransactionList method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}
	
	public JSONObject checkAPIIdExist(JSONObject jsonObject,HttpServletRequest request) {
		log.info("executing checkAPIIdExist method of RemmitanceService class");
		JSONObject jresponse = new JSONObject();
		try {
			log.info("ipaddress is:::::"+request.getRemoteAddr());
			CommonServicesDao commonServicesDao = new CommonServicesDao();
			RemmitanceDao remmitanceDao=new RemmitanceDao();
			if(!jsonObject.has(AadhaarshilaProperties.AgentAuthId)){
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_msg"));
				return jresponse;
			}
			if(!jsonObject.has(AadhaarshilaProperties.AgentAuthPassword)){
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_msg"));
				return jresponse;
			}
			long clientId=remmitanceDao.validateClient(jsonObject.getString(AadhaarshilaProperties.AgentAuthId)
					,jsonObject.getString(AadhaarshilaProperties.AgentAuthPassword),request.getRemoteAddr());
		
			if(clientId!=-1){
			long apiId = jsonObject.getLong("apiId");
			AesAPICustomerLoginDetails aesAPICustomerLoginDetails= commonServicesDao.checkAPIIdExist(apiId);
			String status=commonServicesDao.checkServiceStatus(apiId);
			if (aesAPICustomerLoginDetails==null) {
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiIdExist_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiIdExist_msg"));
			}
			else if(aesAPICustomerLoginDetails.getStatus()==null || !aesAPICustomerLoginDetails.getStatus().equalsIgnoreCase("Active")){
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiIdinactive_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiId_inactive"));
			}
			else if(status.equals("N")){
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiIdoperator_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiId_operator"));
			}
			else {
				jresponse.put("errorCode", "00");
			}
			}else{
				jresponse.put("errorCode", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_code"));
				jresponse.put("errorMsg", DMRPropertyLoader.getInstance().getPropertyMap().get("apiCredential_msg"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			jresponse.put("errorMsg","Pending");
			jresponse.put("errorCode","01");
			log.info("Error in  checkAPIIdExist method of RemmitanceService class" + UtilityP.printException(e));
		}

		return jresponse;

	}
	
	
	
	
	
	
}
