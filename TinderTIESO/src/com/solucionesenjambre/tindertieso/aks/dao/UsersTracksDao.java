/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */

package com.solucionesenjambre.tindertieso.aks.dao;

import app.database.ResourceManager;

import com.solucionesenjambre.tindertieso.aks.dto.UsersTracks;
import com.solucionesenjambre.tindertieso.aks.exception.UsersTracksDaoException;
import java.sql.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * This automatically generated class is the DAO for database object <pre>UsersTracks</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public class UsersTracksDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	protected static final Logger logger = Logger.getLogger( UsersTracksDao.class );

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT user_id, track_id FROM users_tracks";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO users_tracks ( user_id, track_id ) VALUES ( ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE users_tracks SET user_id = ?, track_id = ? WHERE user_id = ? AND track_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM users_tracks WHERE user_id = ? AND track_id = ?";

	/**
	 * Index of column user_id
	 */
	protected static final int COLUMN_USER_ID = 1;

	/**
	 * Index of column track_id
	 */
	protected static final int COLUMN_TRACK_ID = 2;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 2;

	/** 
	 * Index of auto-increment column
	 */
	protected static final int AUTO_INCREMENT_COLUMN = -1;
	
	/** 
	 * Number of PK in table
	 */
	protected static int pk_number_of_columns = 2;
	
	/** 
	 * Inserts a new row in the users_tracks table.
	 */
	public UsersTracks insert(UsersTracks dto) throws UsersTracksDaoException
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
			stmt.setInt( index++, dto.getUserId() );
			stmt.setString( index++, dto.getTrackId() );
			
			if (logger.isDebugEnabled()) {
				logger.debug( "Executing " + SQL_INSERT + " with DTO: " + dto );
			}
		
			int rows = stmt.executeUpdate();
			long t2 = System.currentTimeMillis();
			if (logger.isDebugEnabled())
			{
				logger.debug( rows + " rows affected (" + (t2 - t1) + " ms)" );
			}
			

			return dto;
		}
		catch (Exception e)
		{
			logger.error( "Exception: " + e.getMessage(), e );
			throw new UsersTracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Updates a single row in the users_tracks table.
	 */
	//public void update(UsersTracksPk pk, UsersTracks dto) throws UsersTracksDaoException
	public void update(UsersTracks pk, UsersTracks dto) throws UsersTracksDaoException
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
			stmt.setInt( index++, dto.getUserId() );
			stmt.setString( index++, dto.getTrackId() );
			//PKs
			stmt.setInt( index++, pk.getUserId() );
			stmt.setString( index++, pk.getTrackId() );
			
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
			throw new UsersTracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Deletes a single row in the users_tracks table.
	 */
	//public void delete(UsersTracksPk pk) throws UsersTracksDaoException
	public void delete(UsersTracks pk) throws UsersTracksDaoException
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
			stmt.setString( index++, pk.getTrackId() );
			
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
			throw new UsersTracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Returns the rows from the users_tracks table that matches the specified primary-key value.
	 *
	public UsersTracks findByPrimaryKey(UsersTracksPk pk) throws UsersTracksDaoException
	{
		return findByPrimaryKey( pk.getContactId() );
	}
*/

	/** 
	 * Returns all rows from the users_tracks table that match the criteria 'PKs = :pk_values'.
	 */
	public UsersTracks findByPrimaryKey(UsersTracks pk) throws UsersTracksDaoException
	{
		List<UsersTracks> ret = findByDynamicSelect( SQL_SELECT + " WHERE user_id = ? AND track_id = ?", new Object[] {  pk.getUserId(), pk.getTrackId() } );
		return ret.size() == 0 ? null : ret.get(0);
	}

	/** 
	 * Returns all rows from the users_tracks table that match the criteria ''.
	 */
	public List<UsersTracks> findAll() throws UsersTracksDaoException
	{
		if (pk_number_of_columns == NUMBER_OF_COLUMNS)
			return findByDynamicSelect( SQL_SELECT, null );
		else
			return findByDynamicSelect( SQL_SELECT + " ORDER BY user_id, track_id", null );

	}

//-FINDERS_BY_FK-

	/**
	 * Returns all rows from the users_tracks table that match the criteria 'user_id = :userId'.
	 */
	public List<UsersTracks> findWhereUserIdEquals(int userId) throws UsersTracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE user_id = ? ORDER BY user_id", new Object[] {  new Integer (userId) } );
	}

	/**
	 * Returns all rows from the users_tracks table that match the criteria 'track_id = :trackId'.
	 */
	public List<UsersTracks> findWhereTrackIdEquals(String trackId) throws UsersTracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE track_id = ? ORDER BY track_id", new Object[] {  trackId } );
	}

	/**
	 * Method 'UsersTracksDaoImpl'
	 * 
	 */
	public UsersTracksDao()
	{
	}

	/**
	 * Method 'UsersTracksDaoImpl'
	 * 
	 * @param userConn
	 */
	public UsersTracksDao(final java.sql.Connection userConn)
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
	protected UsersTracks fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next())
		{
			UsersTracks dto = new UsersTracks();
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
	protected List<UsersTracks> fetchMultiResults(ResultSet rs) throws SQLException
	{
		List<UsersTracks> resultList = new ArrayList<UsersTracks>();
		while (rs.next())
		{
			UsersTracks dto = new UsersTracks();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		return resultList;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(UsersTracks dto, ResultSet rs) throws SQLException
	{
		dto.setUserId( rs.getInt( COLUMN_USER_ID ) );
		dto.setTrackId( rs.getString( COLUMN_TRACK_ID ) );
	}

	/** 
	 * Returns all rows from the users_tracks table that match the specified arbitrary SQL statement
	 */
	public List<UsersTracks> findByDynamicSelect(String sql, Object[] sqlParams) throws UsersTracksDaoException
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
			throw new UsersTracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Returns all rows from the users_tracks table that match the specified arbitrary SQL statement
	 */
	public List<UsersTracks> findByDynamicWhere(String sql, Object[] sqlParams) throws UsersTracksDaoException
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
			throw new UsersTracksDaoException( "Exception: " + e.getMessage(), e );
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
