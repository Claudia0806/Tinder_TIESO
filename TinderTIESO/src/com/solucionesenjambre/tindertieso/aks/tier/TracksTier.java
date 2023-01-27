/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */
package com.solucionesenjambre.tindertieso.aks.tier;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import mx.arkesol.communication.ProcessDataResult;
import mx.arkesol.error.Errors;
import mx.arkesol.log.log4j.AksLogger;
import mx.arkesol.util.GeneralUtils;

import com.solucionesenjambre.tindertieso.aks.dao.TracksDao;
import com.solucionesenjambre.tindertieso.aks.dto.Tracks;
import com.solucionesenjambre.tindertieso.aks.exception.TracksDaoException;

/**
 * This automatically generated class represents the middle tier for database object <pre>Tracks DAO</pre> and must not been modified.
 * 
 * <p>For modifications, check {@link TracksJTier} that it is also an automatically generated class</p>
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public abstract class TracksTier extends TierMethods
{
	protected Connection userConn;
	protected ProcessDataResult pdr	= null;
	protected Errors error 			= null;
	
	protected Logger logger = AksLogger.getLoggerWeb(TracksTier.class);
	
	protected TracksDao dao = null;
	
	/** 
	 * Number of PK in table
	 */
	protected static int pk_number_of_columns = 1;
	
	/**
	 * Class constructor
	 */
	public TracksTier()
	{		
		dao 	= new TracksDao();
		pdr 	= new ProcessDataResult();
		error	= new Errors();
	}
	
	/**
	 * Class constructor
	 * @param conn database connection provided by the class instantiation
	 */
	public TracksTier(Connection conn)
	{
		this.userConn	= conn;
		
		dao 			= new TracksDao(conn);
		pdr 			= new ProcessDataResult();
		error			= new Errors();
	}
	
	/**
	 * Wrapping {@link #browse(String)} method to return generic <pre>ProcessDataResult</pre> class
	 * 
	 * @param csvParamsString list of query parameters in csv format
	 * @return {@code ProcessDataResult} object with the result of the operation
	 * @see #browse(String)
	 */
	public ProcessDataResult browsePDR(final String csvParamsString)
	{
		List<Tracks> results = browse(csvParamsString);
		
		pdr.setResult(results);
		
		return pdr;
	}
	
	/**
	 * Wrapping {@link #browse(String[])} method to return generic <pre>ProcessDataResult</pre> class
	 * 
	 * @param params string array of query parameters
	 * @return {@code ProcessDataResult} object with the result of the operation
	 * @see #browse(String[])
	 */
	public ProcessDataResult browsePDR(final String[] params)
	{
		List<Tracks> results = browse(params);
		
		pdr.setResult(results);
		
		return pdr;
	}
	
	/**
	 * Simpliest browse function that executes with default search parameters defined in {@link #browse(String, Object[])}
	 * This function converts a csv parameters list to an array for {@link #browse(String[])}
	 * 
	 * @param csvParamsString list of parameters in a csv string
	 * @return array list of <pre>tracks</pre>
	 * @see #browse(String[])
	 */
	public List<Tracks> browse(final String csvParamsString)
	{
		String params[] = GeneralUtils.csvToArray(csvParamsString);
		
		return browse(params);
	}
	
	/**
	 * Simpliest browse function that executes with default search parameters defined in {@link #browse(String, Object[])}
	 * 
	 * @param params string array of parameters
	 * @return array list of <pre>tracks</pre>
	 */
	public List<Tracks> browse(final String[] params)
	{
		String sql = null;
		ArrayList<Object> sqlParams = null;
		if (params != null)
		{
			sqlParams = new ArrayList<Object>();
			
			//like filter
			params[0] = GeneralUtils.addLikeFormat(params[0]);
			
			sql = queryBrowseColumns();
			
			GeneralUtils.addSqlParams(sqlParams, params[0], queryBrowseColumnsCount());
		}
		
		return browse(sql, sqlParams == null ? null : sqlParams.toArray()); 
	}
	
	public List<Tracks> browse()
	{
		String[] empty = null;
		return browse(empty); 
	}
	
	/**
	 * List elements from the table <pre>tracks</pre>
	 * 
	 * @param whereClause list of conditions to be applied to <pre>SELECT * FROM table</pre>. 
	 * 						If the text is null, method will return all rows in <pre>tracks</pre> table  
	 * @param sqlParams array of parameters to be added to <pre>whereClause</pre> 
	 * @return array list of <pre>tracks</pre> matching search criteria. If there is no rows that matchs criteria, returning list is empty
	 */
	public List<Tracks> browse(final String whereClause, final Object[] sqlParams)
	{
		List<Tracks> results = new ArrayList<Tracks>();
		
		try
		{
			if (whereClause == null)
			{
				results = dao.findAll();
			}
			else 
			{
				results = dao.findByDynamicWhere(whereClause, sqlParams);
			}
		}
		catch (TracksDaoException e)
		{
			logger.error(e.getMessage());
			
			error.setCode(Errors.Codes.DB_DAO.getCode());
			error.setWindowTitle(Errors.Codes.DB_DAO.getWindowTitle());
			error.setMessage(Errors.Codes.DB_DAO.getMessage());
			
			error.setExceptionMessage(e.getMessage());
			
			pdr.setError(error);
			
			if (logger.isDebugEnabled())
				e.printStackTrace();
			
			return null;
		}
		
		return results;
	}
	
	/**
	 * List elements from the table <pre>tracks</pre>
	 * 
	 * @param sql full query to be executed in DB. 
	 * 						If the text is null, method will return all rows in <pre>tracks</pre> table  
	 * @param sqlParams array of parameters to be added to <pre>sql</pre> 
	 * @return array list of <pre>tracks</pre> matching search criteria. If there is no rows that matchs criteria, returning list is empty
	 */
	public List<Tracks> findByDynamicSelect(final String sql, final Object[] sqlParams)
	{
		List<Tracks> results = new ArrayList<Tracks>();
		
		try
		{
			if (sql == null)
			{
				results = dao.findAll();
			}
			else 
			{
				results = dao.findByDynamicSelect(sql, sqlParams);
			}
		}
		catch (TracksDaoException e)
		{
			logger.error(e.getMessage());
			
			error.setCode(Errors.Codes.DB_DAO.getCode());
			error.setWindowTitle(Errors.Codes.DB_DAO.getWindowTitle());
			error.setMessage(Errors.Codes.DB_DAO.getMessage());
			
			error.setExceptionMessage(e.getMessage());
			
			pdr.setError(error);
			
			if (logger.isDebugEnabled())
				e.printStackTrace();
			
			return null;
		}
		
		return results;
	}
	
	/**
	 * List elements from the table <pre>tracks</pre>
	 * 
	 * @param sql where clause to be executed in DB. 
	 * 						If the text is null, method will return all rows in <pre>tracks</pre> table  
	 * @param sqlParams array of parameters to be added to <pre>sql</pre> 
	 * @return array list of <pre>tracks</pre> matching search criteria. If there is no rows that matchs criteria, returning list is empty
	 */
	public List<Tracks> findByDynamicWhere(final String sql, final Object[] sqlParams)
	{
		List<Tracks> results = new ArrayList<Tracks>();
		
		try
		{
			if (sql == null)
			{
				results = dao.findAll();
			}
			else 
			{
				results = dao.findByDynamicWhere(sql, sqlParams);
			}
		}
		catch (TracksDaoException e)
		{
			logger.error(e.getMessage());
			
			error.setCode(Errors.Codes.DB_DAO.getCode());
			error.setWindowTitle(Errors.Codes.DB_DAO.getWindowTitle());
			error.setMessage(Errors.Codes.DB_DAO.getMessage());
			
			error.setExceptionMessage(e.getMessage());
			
			pdr.setError(error);
			
			if (logger.isDebugEnabled())
				e.printStackTrace();
			
			return null;
		}
		
		return results;
	}
	
	/**
	 * Returns a row by its value in the PK
	 * @param pk primary key value of table row
	 * @return object representig the found row. Returns {@code null} if {@code keyId} does not mach with any record
	 */
	public Tracks get(Tracks pk)
	{
		Tracks results = null;
		
		try
		{
			results = dao.findByPrimaryKey(pk);
		}
		catch (TracksDaoException e)
		{
			logger.error(e.getMessage());
			
			error.setCode(Errors.Codes.DB_DAO.getCode());
			error.setWindowTitle(Errors.Codes.DB_DAO.getWindowTitle());
			error.setMessage(Errors.Codes.DB_DAO.getMessage());
			
			error.setExceptionMessage(e.getMessage());
			
			pdr.setError(error);
			
			if (logger.isDebugEnabled())
				e.printStackTrace();
			
			return null;
		}
		
		return results;
	}
	
	/**
	 * Wrapping {@link #get(Tracks)} method to return generic <pre>ProcessDataResult</pre> class
	 * @param pk
	 * @return {@code ProcessDataResult} object with the result of the operation
	 * @see #get(Tracks)
	 */
	public ProcessDataResult getPDR(Tracks pk)
	{
		Tracks results = get(pk);
		
		pdr.setResult(results);
		
		return pdr;
	}
	
	/**
	 * Saves a new object or updates an existing one based on primary key value
	 * 
	 * @param obj object to be sabed
	 * @return object saved or updated or null if there is an error
	 */
	public Tracks save(Tracks obj)
	{
		try
		{
			Tracks pk = null;
			boolean isNew = false;
			
			//if available, omits the get DB query
			if (pk_number_of_columns == 1)
			{
				isNew = isNew(obj.getTrackId());
				pk = new Tracks();
				pk.setTrackId(obj.getTrackId());
			}
			else
			{
				pk = get(obj);
				isNew = pk == null;
			}
			
			if (isNew)
			{
				dao.insert(obj);
			}
			else
			{
				dao.update(pk, obj);
			}
		}
		catch (TracksDaoException e)
		{
			logger.error(e.getMessage());
			
			if (Errors.isExceptionDuplicatedEntry(e.getMessage()))
			{
				error.setCode(Errors.Codes.DB_DUPLICATE_ENTRY.getCode());
				error.setWindowTitle(Errors.Codes.DB_DUPLICATE_ENTRY.getWindowTitle());
				error.setMessage(Errors.Codes.DB_DUPLICATE_ENTRY.getMessage());
				error.setExceptionMessage(e.getMessage());

				error.extendsDuplicatedEntryMessage();
			}
			else
			{
				error.setCode(Errors.Codes.NOT_DEFINED .getCode());
				error.setWindowTitle(Errors.Codes.NOT_DEFINED.getWindowTitle());
				error.setMessage(Errors.Codes.DB_NO_ADD.getMessage());
			}
			
			pdr.setError(error);
			
			if (logger.isDebugEnabled())
				e.printStackTrace();
			
			return null;
		}
		
		return obj;
	}
	
	/**
	 * Wrapping {@link #save(Tracks)} method to return generic <pre>ProcessDataResult</pre> class
	 * @param obj
	 * @return {@code ProcessDataResult} object with the result of the operation
	 * @see	#save(Tracks)
	 */
	public ProcessDataResult savePDR(Tracks obj)
	{
		Tracks objSaved = save(obj);
		
		if (objSaved != null)
		{
			pdr.setResult(objSaved);
		}
		else
		{
			pdr.setResult(null);
		}
		
		return pdr;
	}
	
	/**
	 * Delete a row in database given a value for the primary key.
	 * 
	 * <p>This method do not handle database's referential integrity of tables.</p>
	 * @param pk primary key value of the row to be deleted
	 * @return true if successfull, false if not
	 */
	public boolean delete(Tracks pk)
	{
		try
		{
			dao.delete(pk);
		}
		catch (TracksDaoException e)
		{
			logger.error(e.getMessage());

			error.setExceptionMessage(e.getMessage());
			
			if (Errors.isExceptionReferentialIntegrity(e.getMessage()))
			{
				error.setCode(Errors.Codes.DB_REFERENTIAL_INTEGRITY.getCode());
				error.setWindowTitle(Errors.Codes.DB_REFERENTIAL_INTEGRITY.getWindowTitle());
				error.setMessage(Errors.Codes.DB_REFERENTIAL_INTEGRITY.getMessage());
			}
			else
			{
				error.setCode(Errors.Codes.NOT_DEFINED .getCode());
				error.setWindowTitle(Errors.Codes.NOT_DEFINED.getWindowTitle());
				error.setMessage(Errors.Codes.DB_NO_DELETE.getMessage());
			}
			
			pdr.setError(error);
			
			if (logger.isDebugEnabled())
				e.printStackTrace();
			
			return false;
		}
		
		return true;
	}
	
	/**
	 * Wrapping {@link #delete(Tracks)} method to return generic <pre>ProcessDataResult</pre> class
	 * @param pk
	 * @return {@code ProcessDataResult} object with the result of the operation
	 * @see #delete(Tracks)
	 */
	public ProcessDataResult deletePDR(Tracks pk)
	{
		boolean results = delete(pk);
		
		pdr.setResult(results ? results : null);
		
		return pdr;
	}
	
	/**
	 * @return the pdr
	 */
	public ProcessDataResult getPdr()
	{
		return pdr;
	}
	
	/**
	 * @return the error
	 */
	public Errors getError()
	{
		return error;
	}
	
	/**
	 * List of String type elements of table for a SELECT * FROM table WHERE string_types_fields LIKE first parameter
	 */
	public String queryBrowseColumns()
	{
		return "(track_id LIKE ?)";
	}
	
	/**
	 * Number of String type elements of table for {@link #queryBrowseColumns()}
	 */
	public int queryBrowseColumnsCount()
	{
		return 1;
	}
}