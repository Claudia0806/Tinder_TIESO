/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */
package com.solucionesenjambre.tindertieso.aks.tier;

import mx.arkesol.error.Errors;

/**
 * This automatically generated class represents the middle tier generic functions for database objects and must not been modified.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 */
public abstract class TierMethods {

	public TierMethods() {}
	
	protected boolean isNew(String data)
	{
		if (data == null || data.length() == 0)
			return true;
		else
			return false;
	}
	
	protected boolean isNew(int data)
	{
		return data == 0;
	}
	
	protected boolean isNew(long data)
	{
		return data == 0;
	}
	
	protected Errors authenticationError() {
		Errors error = new Errors();
		error.setCode(Errors.Codes.AUTHO.getCode());
		error.setMessage(Errors.Codes.AUTHO.getMessage());
		error.setWindowTitle(Errors.Codes.AUTHO.getWindowTitle());
		
		return error;
	}
}