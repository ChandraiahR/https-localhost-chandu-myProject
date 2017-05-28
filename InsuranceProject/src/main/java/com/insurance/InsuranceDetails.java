package com.insurance;

public class InsuranceDetails {
	 private String policyType;
	 private String modeofPolicy;
	 private String polocyNumber;
	 private String datOfPolocyStarted;
	 private String custName;
	 private String assureAmmount;
	 private String payDate;
	 private float fineAmount;
	
	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public String getModeofPolicy() {
		return modeofPolicy;
	}

	public void setModeofPolicy(String modeofPolicy) {
		this.modeofPolicy = modeofPolicy;
	}

	public String getPolocyNumber() {
		return polocyNumber;
	}

	public void setPolocyNumber(String polocyNumber) {
		this.polocyNumber = polocyNumber;
	}

	public String getDatOfPolocyStarted() {
		return datOfPolocyStarted;
	}

	public void setDatOfPolocyStarted(String datOfPolocyStarted) {
		this.datOfPolocyStarted = datOfPolocyStarted;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getAssureAmmount() {
		return assureAmmount;
	}

	public void setAssureAmmount(String assureAmmount) {
		this.assureAmmount = assureAmmount;
	}

	public String getPayDate() {
		return payDate;
	}

	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}

	public float getFineAmount() {
		return fineAmount;
	}

	public void setFineAmount(float fineAmount) {
		this.fineAmount = fineAmount;
	}

	@Override
	public String toString() {
		return "   {  "+modeofPolicy+" / "+polocyNumber+" , "+datOfPolocyStarted+" , "+custName+" , "+assureAmmount+" , "+payDate+" , "+fineAmount+ "  }   ";
	}
	
	
	
	 
	 
}
