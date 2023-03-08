package com.LIMS.genericUtility.enums;

public enum ExcellSheet {
	/**
	 * 
	 */
	CLIENT("client"), NOMINEEDETAILS("NomineeDetails");
	
	String SheetName;
	/**
	 * 
	 * @param key
	 */
	private ExcellSheet(String key)
	{
		this.SheetName=key;
	}
	public String getSheetName()
	{
		return SheetName;
	}
	

}
