/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */
package com.solucionesenjambre.tindertieso.aks.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * This automatically generated class represents the DTO for database object <pre>Users DAO</pre>.
 * 
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
public class Users implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 20230124000000767L;

	/**
	 * This attribute maps to the column user_id in the users table/view/sp
	 */
	protected int userId;

	/**
	 * This attribute maps to the column fullname in the users table/view/sp
	 */
	protected String fullname;

	/**
	 * This attribute maps to the column email in the users table/view/sp
	 */
	protected String email;

	/**
	 * This attribute maps to the column image in the users table/view/sp
	 */
	protected String image;

	/**
	 * This attribute maps to the column vector in the users table/view/sp
	 */
	protected String vector;

	/**
	 * Method 'Users'
	 * 
	 */
	public Users()
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
	 * Method 'getFullname()'
	 * 
	 * @return String
	 */
	public String getFullname()
	{
		return fullname;
	}

	/**
	 * Method 'setFullname'
	 *
	 * @param fullname
	 */
	public void setFullname(String fullname)
	{
		this.fullname = fullname;
	}

	/**
	 * Method 'getEmail()'
	 * 
	 * @return String
	 */
	public String getEmail()
	{
		return email;
	}

	/**
	 * Method 'setEmail'
	 *
	 * @param email
	 */
	public void setEmail(String email)
	{
		this.email = email;
	}

	/**
	 * Method 'getImage()'
	 * 
	 * @return String
	 */
	public String getImage()
	{
		return image;
	}

	/**
	 * Method 'setImage'
	 *
	 * @param image
	 */
	public void setImage(String image)
	{
		this.image = image;
	}

	/**
	 * Method 'getVector()'
	 * 
	 * @return String
	 */
	public String getVector()
	{
		return vector;
	}

	/**
	 * Method 'setVector'
	 *
	 * @param vector
	 */
	public void setVector(String vector)
	{
		this.vector = vector;
	}

	@Override 
	public int hashCode()
	{
		return Objects.hash(userId,
				fullname,
				email,
				image,
				vector);
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
		Users other = (Users) obj; 
		return userId == other.userId
				&& Objects.equals(fullname, other.fullname)
				&& Objects.equals(email, other.email)
				&& Objects.equals(image, other.image)
				&& Objects.equals(vector, other.vector);
	}

	@Override 
	public String toString()
	{
		return "Users [userId=" + userId + ","
				+ "fullname=" + fullname + ","
				+ "email=" + email + ","
				+ "image=" + image + ","
				+ "vector=" + vector + "]";
	}

//-CREATE_PK-
}
