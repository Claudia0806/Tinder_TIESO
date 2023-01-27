/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */

package com.solucionesenjambre.tindertieso.aks.exception;
/**
 * This automatically generated class is the DAO Exception for database object <pre>DaoException</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
abstract class DaoException extends Exception
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 20230124000001456L;

	protected Throwable throwable;

	/**
	 * Method 'DaoException'
	 * 
	 * @param message
	 */
	public DaoException(String message)
	{
		super(message);
	}

	/**
	 * Method 'DaoException'
	 * 
	 * @param message
	 * @param throwable
	 */
	public DaoException(String message, Throwable throwable)
	{
		super(message);
		this.throwable = throwable;
	}

	/**
	 * Method 'getCause'
	 * 
	 * @return Throwable
	 */
	public Throwable getCause()
	{
		return throwable;
	}
}
