package com.aadhaar.api.dao;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

import com.aadhaar.api.entity.AesAPICustomerAuthDetails;
import com.aadhaar.api.entity.AesApiOperatorDetail;
import com.hibernateresources.HibernateUtility;
import com.util.UtilityP;

public class RemmitanceDao {
	Logger logger = Logger.getLogger(RemmitanceDao.class);
	public String insertAESApiTransaction(long clientId, String apiTranId, String reqId, String vender, String st,
			String mainService, String opName, double amt, String cn,String remarks,String ip,String account,String remmomile,String ifsc) {
		logger.info("executing insertAESApiTransaction method of RemmitanceDao class");
		 Session session = null;
		 Transaction txn = null;
		String status = null;
		CallableStatement cstmt = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			txn = session.beginTransaction();

			cstmt = session.connection().prepareCall("{call AES_API_IMPS_Transaction_Insert(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cstmt.setLong(1, clientId);
			cstmt.setString(2, apiTranId);
			cstmt.setString(3, reqId);
			cstmt.setString(4, vender);
			cstmt.setString(5, st);
			cstmt.setString(6, mainService);
			cstmt.setString(7, opName);
			cstmt.setDouble(8, amt);
			cstmt.setString(9, cn);
			cstmt.setString(10, remarks);
			cstmt.setString(11, ip);
			cstmt.setString(12, account);
			cstmt.setString(13, remmomile);
			cstmt.setString(14, ifsc);
			cstmt.registerOutParameter(15, java.sql.Types.VARCHAR);
			cstmt.execute();
			status = cstmt.getString(15);

			logger.info("RemmitanceDao.insertAESApiTransaction() : " + status);

			txn.commit();

		} catch (Exception e) {
			logger.error(e.getMessage());
			logger.error("error in insertAESApiTransaction method of RemmitanceDao class"+UtilityP.printException(e));
			txn.rollback();
			status=e.getMessage();
			return status;
		} finally {
			if (session != null)
				session.close();

		}
		return status;
	}
	
	public AesApiOperatorDetail validateRequest(long clientId,String operator,String sub_service,String service,String operatorCode,String amount) {
		logger.info("executing validateRequest method of RemmitanceDao class");
		AesApiOperatorDetail aesApiOperatorDetail=null;
		Session session = null;
		 Transaction txn = null;
		String status = null;
		CallableStatement cstmt = null;
		try{

			session = HibernateUtility.getSessionFactory().openSession();
			String hql="{call Request_validation(?,?,?,?,?,'','','','')}";
			cstmt = session.connection().prepareCall(hql);
			cstmt.setLong(1,clientId);
			cstmt.setString(2,sub_service);
			cstmt.setString(3,service);
			cstmt.setString(4,operatorCode);
			cstmt.setDouble(5,Double.parseDouble(amount));
			ResultSet rs=cstmt.executeQuery();
			
			if (rs.next()) {
				aesApiOperatorDetail=new AesApiOperatorDetail();
				aesApiOperatorDetail.setStatus(rs.getString(1));
				aesApiOperatorDetail.setVendor_name(rs.getString(2));
			}
			
		}catch(Exception e){
			e.printStackTrace();
			logger.error("Exception in validateRequest method of RemmitanceDao class ::"+UtilityP.printException(e));
			return null;
		}
		finally {
			if (session != null)
				session.close();

		}
		return aesApiOperatorDetail;
	}
	
	public void  updatePendingStatus(String txnId,String impsno) {
		logger.info("executing updatePendingStatus method of RemmitanceDao class");
		Session session=null;
		Transaction tx=null;
		Query qry=null;
		try {
			session=HibernateUtility.getSessionFactory().openSession();
			tx=session.beginTransaction();
			String sql="update AES_API_CUSTOMER_TRANSACTION_DETAILS set Tran_Status='Pending',Vendor_Transaction_Id='"+impsno+"' where AES_Transaction_Id='"+txnId+"'";
			qry=session.createSQLQuery(sql);
			qry.executeUpdate();
			 tx.commit();
		} catch (Exception e) {
			logger.error("Error in  updatePendingStatus method of RemmitanceDao class" + UtilityP.printException(e));
		}finally {
			if(session!=null)
				session.close();
		}
		
		
	}
	
	public void  updateBankDetails(String account,String ifsc,String remmobile,String txnId) {
		logger.info("executing updateBankDetails method of RemmitanceDao class");
		Session session=null;
		Transaction tx=null;
		Query qry=null;
		try {
			session=HibernateUtility.getSessionFactory().openSession();
			tx=session.beginTransaction();
			String sql="update AES_API_CUSTOMER_TRANSACTION_DETAILS set account_no='"+account+"',ifsc_code='"+ifsc+"',recipient_mobile='"+remmobile+"' where AES_Transaction_Id='"+txnId+"'";
			qry=session.createSQLQuery(sql);
			qry.executeUpdate();
			 tx.commit();
		} catch (Exception e) {
			logger.error("Error in  updateBankDetails method of RemmitanceDao class" + UtilityP.printException(e));
		}finally {
			if(session!=null)
				session.close();
		}
		
		
	}
	
	public String updateTransactionStatus(String reqId, String returnTranId, String txnStatus, String resultCode,
			String vendorTxnId, String InputXML, String ResoponseXML) {
		// String reqId,String returnTranId,String txnStatus,String
		// vendorTxnId,String InputXML,String ResoponseXML String result
		logger.info("executing updateTransactionStatus method of RemmitanceDao class");
		logger.info("RemmitanceService.updateTransactionStatus()  .... : reqId : " + reqId
				+ " : returnTranId : " + returnTranId + " : txnStatus : " + txnStatus);
		Session session = null;
		Transaction txn = null;
		String status = null;
		CallableStatement cstmt = null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			txn = session.beginTransaction();

			cstmt = session.connection().prepareCall("{call AES_API_Transaction_Update(?,?,?,?,?,?,?)}");
			cstmt.setString(1, reqId);
			cstmt.setString(2, returnTranId);
			cstmt.setString(3, txnStatus);
			cstmt.setString(4, vendorTxnId);
			cstmt.setString(5, InputXML);
			cstmt.setString(6, ResoponseXML);
			cstmt.registerOutParameter(7, java.sql.Types.VARCHAR);
			cstmt.execute();
			status = cstmt.getString(7);

			logger.info("RemmitanceService.updateTransactionStatus() : " + status);

			txn.commit();

		} catch (Exception e) {
			logger.error("Error in updateTransactionStatus method of RemmitanceDao class"+UtilityP.printException(e));
			txn.rollback();
			return null;
		} finally {
			if (session != null)
				session.close();

		}
		return status;
	}
	
	
	public long validateClient(String AgentAuthId, String AgentAuthPassword, String ip) {
		long clientId = -1L;
		Session session = null;
		logger.info("executing validateClient method of RemmitanceDao class");
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			Criteria cr = session.createCriteria(AesAPICustomerAuthDetails.class);
			cr.add(Restrictions.eq("customerAuthId", AgentAuthId));
			cr.add(Restrictions.eq("customerAuthPass", AgentAuthPassword));
			Criterion ip1 = Restrictions.eq("ipAddress1", ip);
			Criterion ip2 = Restrictions.eq("ipAddress2", ip);
			LogicalExpression orExp = Restrictions.or(ip1, ip2);
			cr.add(orExp);
			List<AesAPICustomerAuthDetails> results = cr.list();
			if (results != null && results.size() == 1)
				clientId = results.get(0).getAesApiId();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (session != null)
				session.close();
		}

		return clientId;
	}
	
	public HashMap<String,String> transactionStatus(long clientId,String txnId) {
		logger.info("executing transactionStatus method of RemmitanceDao class");
		Session session = null;
		HashMap<String,String> transactionMap=null;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			String sql = "select tranStatus,aesTransactionId,account,ifscCode,vendorTransactionId,accountNoMobileNo from AesAPICustomerTransactionDetails where aesTransactionId='"+txnId+"' and aesApiId="+clientId;
			List<Object[]> list=session.createQuery(sql).list();
			for(Object[] object:list){
				transactionMap=new HashMap<String,String>();
				transactionMap.put("tranStatus",object[0].toString());
				transactionMap.put("txnId",object[1].toString());
				transactionMap.put("account",object[2].toString());
				transactionMap.put("ifsc",object[3].toString());
				transactionMap.put("impsno",object[4].toString());
				transactionMap.put("customerid",object[5].toString());
			}
				
		} catch (Exception e) {
			logger.error("Error in  transactionStatus method of RemmitanceDao class" + UtilityP.printException(e));
			return transactionMap;
		} finally {
			session.close();
		}
		return transactionMap;
	}
	
	public double getAPIBalance(long clientId) {
		logger.info("executing getAPIBalance method of RemmitanceDao class");
		Session session = null;
		double amount=0.00;
		try {
			session = HibernateUtility.getSessionFactory().openSession();
			String sql = "select totalcash,usedCash from AesAPICustomerAmountDetails where  aesApiId="+clientId;
			 List<Object[]> list=session.createQuery(sql).list();
			 if(list!=null && !list.isEmpty()){
				Object[] object= list.get(0);
				amount=Long.parseLong(object[0].toString())-Long.parseLong(object[1].toString());
			 }
				
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("Error in  getAPIBalance method of RemmitanceDao class" + UtilityP.printException(e));
			return amount;
		} finally {
			session.close();
		}
		return amount;
	}
	
}
