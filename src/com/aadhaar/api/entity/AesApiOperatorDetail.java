package com.aadhaar.api.entity;

import java.io.Serializable;


/**
 * The persistent class for the AES_API_OPERATOR_DETAILS database table.
 * 
 */
public class AesApiOperatorDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	private int AES_API_Oerator_Id;

	private String AES_API_operator_code;

	private String main_service;

	private String operator_name;

	private String status;

	private String sub_service;

	private String vendor_name;

	public AesApiOperatorDetail() {
	}

	public int getAES_API_Oerator_Id() {
		return this.AES_API_Oerator_Id;
	}

	public void setAES_API_Oerator_Id(int AES_API_Oerator_Id) {
		this.AES_API_Oerator_Id = AES_API_Oerator_Id;
	}

	public String getAES_API_operator_code() {
		return this.AES_API_operator_code;
	}

	public void setAES_API_operator_code(String AES_API_operator_code) {
		this.AES_API_operator_code = AES_API_operator_code;
	}

	public String getMain_service() {
		return this.main_service;
	}

	public void setMain_service(String main_service) {
		this.main_service = main_service;
	}

	public String getOperator_name() {
		return this.operator_name;
	}

	public void setOperator_name(String operator_name) {
		this.operator_name = operator_name;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSub_service() {
		return this.sub_service;
	}

	public void setSub_service(String sub_service) {
		this.sub_service = sub_service;
	}

	public String getVendor_name() {
		return this.vendor_name;
	}

	public void setVendor_name(String vendor_name) {
		this.vendor_name = vendor_name;
	}

}