package com.aadhaar.api.dao;

import java.sql.CallableStatement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.aadhaar.api.entity.APIVendorDetails;
import com.aadhaar.api.entity.AesAPICustomerLoginDetails;
import com.hibernateresources.HibernateUtility;
import com.util.UtilityP;

import net.sf.json.JSONObject;

public class CommonServicesDao {
	private static Logger log = Logger.getLogger(CommonServicesDao.class);
	public static HashMap<String, String> getAPIUrls() {
		log.info("executing getAPIUrls method of CommonServicesDao class");
		HashMap<String, String> urlMap=new HashMap<String, String>();
		ArrayList<APIVendorDetails> list=null;
		Session session=null;
		try {
			session=HibernateUtility.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(APIVendorDetails.class);
			cr.add(Restrictions.eq("status", "Y")); 
			list=(ArrayList<APIVendorDetails>) cr.list();
			for (APIVendorDetails apiVendorDetails : list) {
				urlMap.put(apiVendorDetails.getVendorName(), apiVendorDetails.getUrl());
			}
			
		} catch (Exception e) {
			log.error("Error in  apiCall method of CommonServicesDao class" + UtilityP.printException(e));
		}finally {
			if(session!=null)
				session.close();
		}
		
		
		return urlMap;
	}

	public void  insertApiLogs(String request,String response,String url,String txnId) {
		log.info("executing insertApiLogs method of CommonServicesDao class");
		Session session=null;
		Transaction tx=null;
		Query qry=null;
		try {
			JSONObject jresponse = JSONObject.fromObject(request);
			session=HibernateUtility.getSessionFactory().openSession();
			tx=session.beginTransaction();
			String sql="INSERT INTO AES_API_LOG_DETAILS(API_Id,request,"
					+ "response,date,time,url,txnId) values('"+jresponse.getString("apiId")+"','"+request+"','"+response+"',"
							+ "getdate(),getdate(),'"+url+"','"+txnId+"')";
			qry=session.createSQLQuery(sql);
			qry.executeUpdate();
			tx.commit();
		} catch (Exception e) {
			log.error("Error in  insertApiLogs method of CommonServicesDao class" + UtilityP.printException(e));
		}finally {
			if(session!=null)
				session.close();
		}
		
		
	}
	
	public void  saveSenderMaster(JSONObject jsonObject) {
		log.info("executing insertApiLogs method of CommonServicesDao class");
		Session session=null;
		Transaction tx=null;
		CallableStatement cstmt = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			tx = session.beginTransaction();
			cstmt = session.connection().prepareCall("{call SENDER_MATER_Insert(?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, jsonObject.optString("customerId"));
			cstmt.setString(2, jsonObject.optString("address"));
			cstmt.setString(3, jsonObject.optString("dateOfBirth"));
			cstmt.setString(4, jsonObject.optString("name"));
			cstmt.setString(5, jsonObject.optString("agentCode"));
			cstmt.setString(6, jsonObject.optString("apiId"));
			cstmt.setString(7,"");
			cstmt.registerOutParameter(8, java.sql.Types.VARCHAR);
			cstmt.execute();
			String status = cstmt.getString(8);
			log.info("CommonServicesDao.saveSenderMaster() : " + status);
			tx.commit();
		} catch (Exception e) {
			log.error("Error in  saveSenderMaster method of CommonServicesDao class" + UtilityP.printException(e));
		}finally {
			if(session!=null)
				session.close();
		}
		
		
	}
	
	
	public void  saveBenificiaryMaster(JSONObject jsonObject,JSONObject response) {
		log.info("executing saveBenificiaryMaster method of CommonServicesDao class");
		Session session=null;
		Transaction tx=null;
		CallableStatement cstmt = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			tx = session.beginTransaction();
			cstmt = session.connection().prepareCall("{call BENEFICIARY_MATER_INSERT(?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setString(1, jsonObject.optString("recipientName"));
			cstmt.setString(2, jsonObject.optString("accountNo"));
			cstmt.setString(3, jsonObject.optString("ifsc"));
			cstmt.setString(4, jsonObject.optString("mobileNo"));
			cstmt.setString(5, jsonObject.optString("agentCode"));
			cstmt.setString(6, jsonObject.optString("apiId"));
			cstmt.setString(7, "");
			cstmt.setString(8, jsonObject.optString("customerId"));
			cstmt.setString(9, response.optJSONObject("data").optString("recipientId"));
			cstmt.registerOutParameter(10, java.sql.Types.VARCHAR);
			cstmt.execute();
			String status = cstmt.getString(10);
			log.info("CommonServicesDao.saveBenificiaryMaster() : " + status);
			 tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in  saveBenificiaryMaster method of CommonServicesDao class" + UtilityP.printException(e));
		}finally {
			if(session!=null)
				session.close();
		}
		
		
	}
	
	public AesAPICustomerLoginDetails checkAPIIdExist(long clientId) {
		log.info("executing checkAPIIdExist method of CommonServicesDao class");
		AesAPICustomerLoginDetails aesAPICustomerLoginDetails=null;
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			String sql = "from AesAPICustomerLoginDetails where aesApiId="+clientId;
			List<AesAPICustomerLoginDetails> list= session.createQuery(sql).list();
			if(list!=null && !list.isEmpty())
			aesAPICustomerLoginDetails=list.get(0);
			
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error in  checkAPIIdExist method of CommonServicesDao class" + UtilityP.printException(e));
		} finally {
			session.close();
		}
		return aesAPICustomerLoginDetails;
	}
	
	public String checkServiceStatus(long clientId) {
		log.info("executing checkServiceStatus method of CommonServicesDao class");
		String  status="N";
		Session session = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			String sql = "select status from AES_API_CUSTOMER_OPERATOR_STATUS where AES_API_Id="+clientId+" "
					+ "and Service='A-REMIT'";
			List<Object> list= session.createSQLQuery(sql).list();
			if(list!=null && !list.isEmpty()){
				status=list.get(0)!=null?list.get(0).toString():"N";
			}
			
		} catch (Exception e) {
			status="N";
			log.error("Error in  checkServiceStatus method of CommonServicesDao class" + UtilityP.printException(e));
		} finally {
			if(session!=null)
			session.close();
		}
		return status;
	}
	
}
