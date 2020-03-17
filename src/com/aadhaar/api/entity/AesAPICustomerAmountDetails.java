package com.aadhaar.api.entity;

import java.sql.Time;
import java.sql.Date;

public class AesAPICustomerAmountDetails {
	
	private long aesApiId;
	private double totalcash;
	private double usedCash;
	private double cuttoff;
	private double avalBal;
	private double lastUpdatedAmount;
	private Date updatedDate;
	private Time updatedTime;
	
	public long getAesApiId() {
		return aesApiId;
	}
	public double getTotalcash() {
		return totalcash;
	}
	public double getUsedCash() {
		return usedCash;
	}
	public double getCuttoff() {
		return cuttoff;
	}
	public double getAvalBal() {
		return avalBal;
	}
	public double getLastUpdatedAmount() {
		return lastUpdatedAmount;
	}
	public Date getUpdatedDate() {
		return updatedDate;
	}
	public Time getUpdatedTime() {
		return updatedTime;
	}
	public void setAesApiId(long aesApiId) {
		this.aesApiId = aesApiId;
	}
	public void setTotalcash(double totalcash) {
		this.totalcash = totalcash;
	}
	public void setUsedCash(double usedCash) {
		this.usedCash = usedCash;
	}
	public void setCuttoff(double cuttoff) {
		this.cuttoff = cuttoff;
	}
	public void setAvalBal(double avalBal) {
		this.avalBal = avalBal;
	}
	public void setLastUpdatedAmount(double lastUpdatedAmount) {
		this.lastUpdatedAmount = lastUpdatedAmount;
	}
	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}
	public void setUpdatedTime(Time updatedTime) {
		this.updatedTime = updatedTime;
	}

	
}
