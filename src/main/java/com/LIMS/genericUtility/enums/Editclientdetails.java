package com.LIMS.genericUtility.enums;

public enum Editclientdetails {
	/**
	 * 
	 */
	UPDATECLIENT("updateclient");
	String SheetName;
	/**
	 * 
	 * @param key
	 */
	private Editclientdetails(String key)
	{
		this.SheetName=key;
	}
	public String getSheetName()
	{
		return SheetName;
	}

}
