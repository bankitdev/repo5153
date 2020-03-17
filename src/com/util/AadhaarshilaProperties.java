package com.util;

public class AadhaarshilaProperties {
	public static String db_password="admin";
	public static String db_url="jdbc:sqlserver://localhost:1433;databasename=addharshila";
	
	
	public static String AgentAuthId="AgentAuthId";
	public static String AgentAuthPassword="AgentAuthPassword";
	
	
	public static String initiatorId="1";
	public static String initiator_id="9953081523";	
	public static String apiId="10002";	
	public static String addcustomer = "customer/create";
	public static String fetchCustomer = "customer/fetch";
	public static String otpGenerate = "generic/otp";
	public static String verifyCustomer = "customer/verify";
	public static String addRecipient = "recipient/add";
	public static String fetchRecipient = "recipient/fetch";
	public static String fetchAllRecipient = "recipient/fetchAll";
	public static String deleteRecipient = "recipient/delete";
	public static String remitTransaction = "transact/doremit";
	public static String accountverification = "transact/RecipeintEnquiry";
	public static String refundTransaction = "transact/refund";
	public static String updateKYC = "generic/kyc";
	public static String fetchbankList= "generic/banks/fetch";
	public static String fetchbank= "generic/banks/detail";
	public static String searchtransaction= "transact/searchtxn";
	public static String pendingtransaction= "transact/pendingtxnlist";
	public static String transactionhistory= "transact/transactionhistory";
	public static String urlType="Mobileware";
	public static String REMITANCE_OPCODE="1002";
	public static String ACCOUNT_VERIFICATION_OPCODE="1001";
	
}
