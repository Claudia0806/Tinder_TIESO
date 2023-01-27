/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */

package com.solucionesenjambre.tindertieso.aks.dao;

import app.database.ResourceManager;

import com.solucionesenjambre.tindertieso.aks.dto.Tracks;
import com.solucionesenjambre.tindertieso.aks.exception.TracksDaoException;
import java.sql.Connection;
import org.apache.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

/**
 * This automatically generated class is the DAO for database object <pre>Tracks</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public class TracksDao
{
	/** 
	 * The factory class for this DAO has two versions of the create() method - one that
takes no arguments and one that takes a Connection argument. If the Connection version
is chosen then the connection will be stored in this attribute and will be used by all
calls to this DAO, otherwise a new Connection will be allocated for each operation.
	 */
	protected java.sql.Connection userConn;

	protected static final Logger logger = Logger.getLogger( TracksDao.class );

	/** 
	 * All finder methods in this class use this SELECT constant to build their queries
	 */
	protected final String SQL_SELECT = "SELECT track_id, danceability, energy, song_key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, time_signature FROM tracks";

	/** 
	 * Finder methods will pass this value to the JDBC setMaxRows method
	 */
	protected int maxRows;

	/** 
	 * SQL INSERT statement for this table
	 */
	protected final String SQL_INSERT = "INSERT INTO tracks ( track_id, danceability, energy, song_key, loudness, mode, speechiness, acousticness, instrumentalness, liveness, valence, tempo, time_signature ) VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";

	/** 
	 * SQL UPDATE statement for this table
	 */
	protected final String SQL_UPDATE = "UPDATE tracks SET track_id = ?, danceability = ?, energy = ?, song_key = ?, loudness = ?, mode = ?, speechiness = ?, acousticness = ?, instrumentalness = ?, liveness = ?, valence = ?, tempo = ?, time_signature = ? WHERE track_id = ?";

	/** 
	 * SQL DELETE statement for this table
	 */
	protected final String SQL_DELETE = "DELETE FROM tracks WHERE track_id = ?";

	/**
	 * Index of column track_id
	 */
	protected static final int COLUMN_TRACK_ID = 1;

	/**
	 * Index of column danceability
	 */
	protected static final int COLUMN_DANCEABILITY = 2;

	/**
	 * Index of column energy
	 */
	protected static final int COLUMN_ENERGY = 3;

	/**
	 * Index of column song_key
	 */
	protected static final int COLUMN_SONG_KEY = 4;

	/**
	 * Index of column loudness
	 */
	protected static final int COLUMN_LOUDNESS = 5;

	/**
	 * Index of column mode
	 */
	protected static final int COLUMN_MODE = 6;

	/**
	 * Index of column speechiness
	 */
	protected static final int COLUMN_SPEECHINESS = 7;

	/**
	 * Index of column acousticness
	 */
	protected static final int COLUMN_ACOUSTICNESS = 8;

	/**
	 * Index of column instrumentalness
	 */
	protected static final int COLUMN_INSTRUMENTALNESS = 9;

	/**
	 * Index of column liveness
	 */
	protected static final int COLUMN_LIVENESS = 10;

	/**
	 * Index of column valence
	 */
	protected static final int COLUMN_VALENCE = 11;

	/**
	 * Index of column tempo
	 */
	protected static final int COLUMN_TEMPO = 12;

	/**
	 * Index of column time_signature
	 */
	protected static final int COLUMN_TIME_SIGNATURE = 13;

	/** 
	 * Number of columns
	 */
	protected static final int NUMBER_OF_COLUMNS = 13;

	/** 
	 * Index of auto-increment column
	 */
	protected static final int AUTO_INCREMENT_COLUMN = -1;
	
	/** 
	 * Number of PK in table
	 */
	protected static int pk_number_of_columns = 1;
	
	/** 
	 * Inserts a new row in the tracks table.
	 */
	public Tracks insert(Tracks dto) throws TracksDaoException
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
			stmt.setString( index++, dto.getTrackId() );
			stmt.setInt( index++, dto.getDanceability() );
			stmt.setInt( index++, dto.getEnergy() );
			stmt.setInt( index++, dto.getSongKey() );
			stmt.setInt( index++, dto.getLoudness() );
			stmt.setInt( index++, dto.getMode() );
			stmt.setInt( index++, dto.getSpeechiness() );
			stmt.setInt( index++, dto.getAcousticness() );
			stmt.setInt( index++, dto.getInstrumentalness() );
			stmt.setInt( index++, dto.getLiveness() );
			stmt.setInt( index++, dto.getValence() );
			stmt.setInt( index++, dto.getTempo() );
			stmt.setInt( index++, dto.getTimeSignature() );
			
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
			throw new TracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Updates a single row in the tracks table.
	 */
	//public void update(TracksPk pk, Tracks dto) throws TracksDaoException
	public void update(Tracks pk, Tracks dto) throws TracksDaoException
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
			stmt.setString( index++, dto.getTrackId() );
			stmt.setInt( index++, dto.getDanceability() );
			stmt.setInt( index++, dto.getEnergy() );
			stmt.setInt( index++, dto.getSongKey() );
			stmt.setInt( index++, dto.getLoudness() );
			stmt.setInt( index++, dto.getMode() );
			stmt.setInt( index++, dto.getSpeechiness() );
			stmt.setInt( index++, dto.getAcousticness() );
			stmt.setInt( index++, dto.getInstrumentalness() );
			stmt.setInt( index++, dto.getLiveness() );
			stmt.setInt( index++, dto.getValence() );
			stmt.setInt( index++, dto.getTempo() );
			stmt.setInt( index++, dto.getTimeSignature() );
			//PKs
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
			throw new TracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Deletes a single row in the tracks table.
	 */
	//public void delete(TracksPk pk) throws TracksDaoException
	public void delete(Tracks pk) throws TracksDaoException
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
			throw new TracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Returns the rows from the tracks table that matches the specified primary-key value.
	 *
	public Tracks findByPrimaryKey(TracksPk pk) throws TracksDaoException
	{
		return findByPrimaryKey( pk.getContactId() );
	}
*/

	/** 
	 * Returns all rows from the tracks table that match the criteria 'PKs = :pk_values'.
	 */
	public Tracks findByPrimaryKey(Tracks pk) throws TracksDaoException
	{
		List<Tracks> ret = findByDynamicSelect( SQL_SELECT + " WHERE track_id = ?", new Object[] {  pk.getTrackId() } );
		return ret.size() == 0 ? null : ret.get(0);
	}

	/** 
	 * Returns all rows from the tracks table that match the criteria ''.
	 */
	public List<Tracks> findAll() throws TracksDaoException
	{
		if (pk_number_of_columns == NUMBER_OF_COLUMNS)
			return findByDynamicSelect( SQL_SELECT, null );
		else
			return findByDynamicSelect( SQL_SELECT + " ORDER BY track_id", null );

	}

//-FINDERS_BY_FK-

	/**
	 * Returns all rows from the tracks table that match the criteria 'track_id = :trackId'.
	 */
	public List<Tracks> findWhereTrackIdEquals(String trackId) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE track_id = ? ORDER BY track_id", new Object[] {  trackId } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'danceability = :danceability'.
	 */
	public List<Tracks> findWhereDanceabilityEquals(int danceability) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE danceability = ? ORDER BY danceability", new Object[] {  new Integer (danceability) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'energy = :energy'.
	 */
	public List<Tracks> findWhereEnergyEquals(int energy) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE energy = ? ORDER BY energy", new Object[] {  new Integer (energy) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'song_key = :songKey'.
	 */
	public List<Tracks> findWhereSongKeyEquals(int songKey) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE song_key = ? ORDER BY song_key", new Object[] {  new Integer (songKey) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'loudness = :loudness'.
	 */
	public List<Tracks> findWhereLoudnessEquals(int loudness) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE loudness = ? ORDER BY loudness", new Object[] {  new Integer (loudness) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'mode = :mode'.
	 */
	public List<Tracks> findWhereModeEquals(int mode) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE mode = ? ORDER BY mode", new Object[] {  new Integer (mode) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'speechiness = :speechiness'.
	 */
	public List<Tracks> findWhereSpeechinessEquals(int speechiness) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE speechiness = ? ORDER BY speechiness", new Object[] {  new Integer (speechiness) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'acousticness = :acousticness'.
	 */
	public List<Tracks> findWhereAcousticnessEquals(int acousticness) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE acousticness = ? ORDER BY acousticness", new Object[] {  new Integer (acousticness) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'instrumentalness = :instrumentalness'.
	 */
	public List<Tracks> findWhereInstrumentalnessEquals(int instrumentalness) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE instrumentalness = ? ORDER BY instrumentalness", new Object[] {  new Integer (instrumentalness) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'liveness = :liveness'.
	 */
	public List<Tracks> findWhereLivenessEquals(int liveness) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE liveness = ? ORDER BY liveness", new Object[] {  new Integer (liveness) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'valence = :valence'.
	 */
	public List<Tracks> findWhereValenceEquals(int valence) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE valence = ? ORDER BY valence", new Object[] {  new Integer (valence) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'tempo = :tempo'.
	 */
	public List<Tracks> findWhereTempoEquals(int tempo) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE tempo = ? ORDER BY tempo", new Object[] {  new Integer (tempo) } );
	}

	/**
	 * Returns all rows from the tracks table that match the criteria 'time_signature = :timeSignature'.
	 */
	public List<Tracks> findWhereTimeSignatureEquals(int timeSignature) throws TracksDaoException
	{
		return findByDynamicSelect( SQL_SELECT + " WHERE time_signature = ? ORDER BY time_signature", new Object[] {  new Integer (timeSignature) } );
	}

	/**
	 * Method 'TracksDaoImpl'
	 * 
	 */
	public TracksDao()
	{
	}

	/**
	 * Method 'TracksDaoImpl'
	 * 
	 * @param userConn
	 */
	public TracksDao(final java.sql.Connection userConn)
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
	protected Tracks fetchSingleResult(ResultSet rs) throws SQLException
	{
		if (rs.next())
		{
			Tracks dto = new Tracks();
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
	protected List<Tracks> fetchMultiResults(ResultSet rs) throws SQLException
	{
		List<Tracks> resultList = new ArrayList<Tracks>();
		while (rs.next())
		{
			Tracks dto = new Tracks();
			populateDto( dto, rs);
			resultList.add( dto );
		}
		
		return resultList;
	}

	/** 
	 * Populates a DTO with data from a ResultSet
	 */
	protected void populateDto(Tracks dto, ResultSet rs) throws SQLException
	{
		dto.setTrackId( rs.getString( COLUMN_TRACK_ID ) );
		dto.setDanceability( rs.getInt( COLUMN_DANCEABILITY ) );
		dto.setEnergy( rs.getInt( COLUMN_ENERGY ) );
		dto.setSongKey( rs.getInt( COLUMN_SONG_KEY ) );
		dto.setLoudness( rs.getInt( COLUMN_LOUDNESS ) );
		dto.setMode( rs.getInt( COLUMN_MODE ) );
		dto.setSpeechiness( rs.getInt( COLUMN_SPEECHINESS ) );
		dto.setAcousticness( rs.getInt( COLUMN_ACOUSTICNESS ) );
		dto.setInstrumentalness( rs.getInt( COLUMN_INSTRUMENTALNESS ) );
		dto.setLiveness( rs.getInt( COLUMN_LIVENESS ) );
		dto.setValence( rs.getInt( COLUMN_VALENCE ) );
		dto.setTempo( rs.getInt( COLUMN_TEMPO ) );
		dto.setTimeSignature( rs.getInt( COLUMN_TIME_SIGNATURE ) );
	}

	/** 
	 * Returns all rows from the tracks table that match the specified arbitrary SQL statement
	 */
	public List<Tracks> findByDynamicSelect(String sql, Object[] sqlParams) throws TracksDaoException
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
			throw new TracksDaoException( "Exception: " + e.getMessage(), e );
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
	 * Returns all rows from the tracks table that match the specified arbitrary SQL statement
	 */
	public List<Tracks> findByDynamicWhere(String sql, Object[] sqlParams) throws TracksDaoException
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
			throw new TracksDaoException( "Exception: " + e.getMessage(), e );
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
