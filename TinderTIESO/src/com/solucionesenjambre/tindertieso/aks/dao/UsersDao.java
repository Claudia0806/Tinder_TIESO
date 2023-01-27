/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */

package com.solucionesenjambre.tindertieso.aks.dao;

import app.database.ResourceManager;

import com.solucionesenjambre.tindertieso.aks.dto.Users;
import com.solucionesenjambre.tindertieso.aks.exception.UsersDaoException;
import java.sql.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * This automatically generated class is the DAO for database object <pre>Users</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public class UsersDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	protected static final Logger logger = Logger.getLogger( UsersDao.class );

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT user_id, fullname, email, image, vector FROM users";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO users ( fullname, email, image, vector ) VALUES ( ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE users SET fullname = ?, email = ?, image = ?, vector = ? WHERE user_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM users WHERE user_id = ?";

	/**
	 * Index of column user_id
	 */
	protected static final int COLUMN_USER_ID = 1;

	/**
	 * Index of column fullname
	 */
	protected static final int COLUMN_FULLNAME = 2;

	/**
	 * Index of column email
	 */
	protected static final int COLUMN_EMAIL = 3;

	/**
	 * Index of column image
	 */
	protected static final int COLUMN_IMAGE = 4;

	/**
	 * Index of column vector
	 */
	protected static final int COLUMN_VECTOR = 5;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 5;

	/** 
	 * Index of auto-increment column
	 */
	protected static final int AUTO_INCREMENT_COLUMN = 1;
	
	/** 
	 * Number of PK in table
	 */
	protected static int pk_number_of_columns = 1;
	
	/** 
	 * Inserts a new row in the users table.
	 */
	public Users insert(Users dto) throws UsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			stmt = conn.prepareStatement( SQL_INSERT, Statement.RETURN_GENERATED_KEYS );
			int index = 1;
			// no bind statement for auto increment column in 'UserId'
			stmt.setString( index++, dto.getFullname() );
			stmt.setString( index++, dto.getEmail() );
			stmt.setString( index++, dto.getImage() );
			stmt.setString( index++, dto.getVector() );
			
			if (logger.isDebugEnabled()) {
				logger.debug( "Executing " + SQL_INSERT + " with DTO: " + dto );
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			if (logger.isDebugEnabled())
			{
				logger.debug( rows + " rows affected (" + (t2 - t1) + " ms)" );
			}
			
			// retrieve values from auto-increment columns
			rs = stmt.getGeneratedKeys();
			if (rs != null && rs.next())
			{
				dto.setUserId( rs.getInt( 1 ) );
			}

			return dto;
		}
		catch (Exception e)
		{
			logger.error( "Exception: " + e.getMessage(), e );
			throw new UsersDaoException( "Exception: " + e.getMessage(), e );
		}
		finally
		{
			ResourceManager.close(stmt);
			if (!isConnSupplied)
			{
				ResourceManager.close(conn);
			}
		}
	}

	/** 
	 * Updates a single row in the users table.
	 */
	//public void update(UsersPk pk, Users dto) throws UsersDaoException
	public void update(Users pk, Users dto) throws UsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try
		{
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			if (logger.isDebugEnabled())
			{
				logger.debug( "Executing " + SQL_UPDATE + " with DTO: " + dto + " and PK: " + pk);
			}
		
			stmt = conn.prepareStatement( SQL_UPDATE );
			int index = 1;
			// no bind statement for auto increment column in 'UserId'
			stmt.setString( index++, dto.getFullname() );
			stmt.setString( index++, dto.getEmail() );
			stmt.setString( index++, dto.getImage() );
			stmt.setString( index++, dto.getVector() );
			//PKs
			stmt.setInt( index++, pk.getUserId() );
			
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			if (logger.isDebugEnabled())
			{
				logger.debug( rows + " rows affected (" + (t2 - t1) + " ms)");
			}
		}
		catch (Exception e)
		{
			logger.error( "Exception: " + e.getMessage(), e );
			throw new UsersDaoException( "Exception: " + e.getMessage(), e );
		}
		finally
		{
			ResourceManager.close(stmt);
			if (!isConnSupplied)
			{
				ResourceManager.close(conn);
			}
		}
	}

	/** 
	 * Deletes a single row in the users table.
	 */
	//public void delete(UsersPk pk) throws UsersDaoException
	public void delete(Users pk) throws UsersDaoException
	{
		long t1 = System.currentTimeMillis();
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try
		{
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			if (logger.isDebugEnabled())
			{
				logger.debug( "Executing " + SQL_DELETE + " with PK: " + pk);
			}
		
			stmt = conn.prepareStatement( SQL_DELETE );
			
			int index = 1;
			//PKs
			stmt.setInt( index++, pk.getUserId() );
			
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			if (logger.isDebugEnabled())
			{
				logger.debug( rows + " rows affected (" + (t2 - t1) + " ms)");
			}
		}
		catch (Exception e)
		{
			logger.error( "Exception: " + e.getMessage(), e );
			throw new UsersDaoException( "Exception: " + e.getMessage(), e );
		}
		finally
		{
			ResourceManager.close(stmt);
			if (!isConnSupplied)
			{
				ResourceManager.close(conn);
			}
		}
	}

	/* 
	 * Returns the rows from the users table that matches the specified primary-key value.
	 *
	public Users findByPrimaryKey(UsersPk pk) throws UsersDaoException
	{
		return findByPrimaryKey( pk.getContactId() );
	}
*/

	/** 
	 * Returns all rows from the users table that match the criteria 'PKs = :pk_values'.
	 */
	public Users findByPrimaryKey(Users pk) throws UsersDaoException
	{
		List<Users> ret = findByDynamicSelect( SQL_SELECT + " WHERE user_id = ?", new Object[] {  pk.getUserId() } );
		return ret.size() == 0 ? null : ret.get(0);
	}

	/** 
	 * Returns all rows from the users table that match the criteria ''.
	 */
	public List<Users> findAll() throws UsersDaoException
	{
		if (pk_number_of_columns == NUMBER_OF_COLUMNS)
			return findByDynamicSelect( SQL_SELECT, null );
		else
			return findByDynamicSelect( SQL_SELECT + " ORDER BY user_id", null );

	}

//-FINDERS_BY_FK-

	/**
	 * Returns all rows from the users table that match the criteria 'user_id = :userId'.
	 */
	public List<Users> findWhereUserIdEquals(int userId) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE user_id = ? ORDER BY user_id", new Object[] {  new Integer (userId) } );
	}

	/**
	 * Returns all rows from the users table that match the criteria 'fullname = :fullname'.
	 */
	public List<Users> findWhereFullnameEquals(String fullname) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE fullname = ? ORDER BY fullname", new Object[] {  fullname } );
	}

	/**
	 * Returns all rows from the users table that match the criteria 'email = :email'.
	 */
	public List<Users> findWhereEmailEquals(String email) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE email = ? ORDER BY email", new Object[] {  email } );
	}

	/**
	 * Returns all rows from the users table that match the criteria 'image = :image'.
	 */
	public List<Users> findWhereImageEquals(String image) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE image = ? ORDER BY image", new Object[] {  image } );
	}

	/**
	 * Returns all rows from the users table that match the criteria 'vector = :vector'.
	 */
	public List<Users> findWhereVectorEquals(String vector) throws UsersDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE vector = ? ORDER BY vector", new Object[] {  vector } );
	}

	/**
	 * Method 'UsersDaoImpl'
	 * 
	 */
	public UsersDao()
	{
	}

	/**
	 * Method 'UsersDaoImpl'
	 * 
	 * @param userConn
	 */
	public UsersDao(final java.sql.Connection userConn)
	{
		this.userConn = userConn;
	}

	/** 
	 * Sets the value of maxRows
	 */
	public void setMaxRows(int maxRows)
	{
		this.maxRows = maxRows;
	}

	/** 
	 * Gets the value of maxRows
	 */
	public int getMaxRows()
	{
		return maxRows;
	}

	/** 
	 * Fetches a single row from the result set
	 */
	protected Users fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next())
		{
			Users dto = new Users();
			populateDto( dto, rs);
			return dto;
		}
		else
		{
			return null;
		}
		
	}

	/** 
	 * Fetches multiple rows from the result set
	 */
	protected List<Users> fetchMultiResults(ResultSet rs) throws SQLException
	{
		List<Users> resultList = new ArrayList<Users>();
		while (rs.next())
		{
			Users dto = new Users();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		return resultList;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Users dto, ResultSet rs) throws SQLException
	{
		dto.setUserId( rs.getInt( COLUMN_USER_ID ) );
		dto.setFullname( rs.getString( COLUMN_FULLNAME ) );
		dto.setEmail( rs.getString( COLUMN_EMAIL ) );
		dto.setImage( rs.getString( COLUMN_IMAGE ) );
		dto.setVector( rs.getString( COLUMN_VECTOR ) );
	}

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public List<Users> findByDynamicSelect(String sql, Object[] sqlParams) throws UsersDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = sql;
		
			if (logger.isDebugEnabled())
			{
				logger.debug( "Executing " + SQL);
			}
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i = 0; sqlParams != null && i < sqlParams.length; i++)
			{
				stmt.setObject( i + 1, sqlParams[i] );
			}
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception e)
		{
			logger.error( "Exception: " + e.getMessage(), e );
			throw new UsersDaoException( "Exception: " + e.getMessage(), e );
		}
		finally
		{
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied)
			{
				ResourceManager.close(conn);
			}
		}
	}

	/** 
	 * Returns all rows from the users table that match the specified arbitrary SQL statement
	 */
	public List<Users> findByDynamicWhere(String sql, Object[] sqlParams) throws UsersDaoException
	{
		// declare variables
		final boolean isConnSupplied = (userConn != null);
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try
		{
			// get the user-specified connection or get a connection from the ResourceManager
			conn = isConnSupplied ? userConn : ResourceManager.getConnection();
		
			// construct the SQL statement
			final String SQL = SQL_SELECT + " WHERE " + sql;
		
			if (logger.isDebugEnabled())
			{
				logger.debug( "Executing " + SQL);
			}
		
			// prepare statement
			stmt = conn.prepareStatement( SQL );
			stmt.setMaxRows( maxRows );
		
			// bind parameters
			for (int i=0; sqlParams!=null && i<sqlParams.length; i++ )
			{
				stmt.setObject( i+1, sqlParams[i] );
			}
		
			rs = stmt.executeQuery();
		
			// fetch the results
			return fetchMultiResults(rs);
		}
		catch (Exception e)
		{
			logger.error( "Exception: " + e.getMessage(), e );
			throw new UsersDaoException( "Exception: " + e.getMessage(), e );
		}
		finally
		{
			ResourceManager.close(rs);
			ResourceManager.close(stmt);
			if (!isConnSupplied)
			{
				ResourceManager.close(conn);
			}
		}
	}
}
