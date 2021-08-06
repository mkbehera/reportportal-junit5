package org.marelli.reportportal;

public class BankLoanService {

	public float calcSimpleInterstAmount(float pAmt, float rate, float time) {
		//System.out.println("BankLoanService.calcSimpleInterstAmount(-,-,-)");
		if(pAmt<=0 || rate<=0 || time<=0)
			throw new IllegalArgumentException();
		/*
		 * try { Thread.sleep(10000); } catch(Exception e) { e.printStackTrace(); }
		 */
		return pAmt*rate*time/100.0f;
	}
}
