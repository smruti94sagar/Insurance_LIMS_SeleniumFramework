package com.LIMS.genericUtility.enums;

public enum pyamentdeatils {
	/**
	 * 
	 */
	CLIENT("ClientDetails");
	String SheetName;
	/**
	 * 
	 * @param key
	 */
	private pyamentdeatils(String key)
	{
		this.SheetName=key;
	}
	public String getSheetName()
	{
		return SheetName;
	}

}
