/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */
package com.solucionesenjambre.tindertieso.aks.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * This automatically generated class represents the DTO for database object <pre>UsersTracks DAO</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public class UsersTracks implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 20230124000001383L;

	/**
	 * This attribute maps to the column user_id in the users_tracks table/view/sp
	 */
	protected int userId;

	/**
	 * This attribute maps to the column track_id in the users_tracks table/view/sp
	 */
	protected String trackId;

	/**
	 * Method 'UsersTracks'
	 * 
	 */
	public UsersTracks()
	{
	}

	/**
	 * Method 'getUserId()'
	 * 
	 * @return int
	 */
	public int getUserId()
	{
		return userId;
	}

	/**
	 * Method 'setUserId'
	 *
	 * @param userId
	 */
	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	/**
	 * Method 'getTrackId()'
	 * 
	 * @return String
	 */
	public String getTrackId()
	{
		return trackId;
	}

	/**
	 * Method 'setTrackId'
	 *
	 * @param trackId
	 */
	public void setTrackId(String trackId)
	{
		this.trackId = trackId;
	}

	@Override 
	public int hashCode()
	{
		return Objects.hash(userId,
				trackId);
	}

	@Override 
	public boolean equals(Object obj)
	{
		if (this == obj) 
			return true; 
		if (obj == null) 
			return false; 
		if (getClass() != obj.getClass()) 
			return false; 
		UsersTracks other = (UsersTracks) obj; 
		return userId == other.userId
				&& Objects.equals(trackId, other.trackId);
	}

	@Override 
	public String toString()
	{
		return "UsersTracks [userId=" + userId + ","
				+ "trackId=" + trackId + "]";
	}

//-CREATE_PK-
}
