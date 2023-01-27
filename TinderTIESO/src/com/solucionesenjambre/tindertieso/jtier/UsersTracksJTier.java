/*
 * This source file was generated to Arke Soluciones by AKSGen software
 * 
 * For more information please visit http://www.arkesol.mx
 */
package com.solucionesenjambre.tindertieso.jtier;

import java.io.InputStream;
import java.sql.Connection;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.FormParam;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import com.solucionesenjambre.tindertieso.aks.dto.UsersTracks;

import mx.arkesol.communication.ProcessDataResult;
import mx.arkesol.userstructure.aks.dto.UsersTokens;
import mx.arkesol.userstructure.jtier.UsersTokensJTier;
import mx.arkesol.util.JSONUtils;

/**
 * This automatically generated class represents the middle tier for database object <pre>UsersTracks DAO</pre>.
 * 
 * <p>It extends a base class {@link UsersTracksTier} and all modifications must be done in this class</p>
 * @author AKSGen
 * @author Rafael Gallardo
 * 
 * @version 0.0.1, 2023-01-24
 *
 */
@Path("/UsersTracks")
public class UsersTracksJTier extends com.solucionesenjambre.tindertieso.aks.tier.UsersTracksTier {
	private UsersTokensJTier usersTier = null;

	/**
	 * Class constructor
	 */
	public UsersTracksJTier() {
		usersTier = new UsersTokensJTier();
	}

	/**
	 * Class constructor
	 * @param conn database connection provided by the class instantiation
	 * @see com.solucionesenjambre.tindertieso.aks.tier.UsersTracksTier#UsersTracksTier(Connection)
	 */
	public UsersTracksJTier(Connection conn) {
		super(conn);
		
		usersTier = new UsersTokensJTier(conn);
	}
	
	/**
	 * List elements from the table <pre>users_tracks</pre>
	 * @param paramsString list of elements that be added to the where clause. Each element must be sepparated by a comma
	 * @return array list of <pre>UsersTracks</pre> matching search criteria. If there is no rows that matchs criteria, returning list is empty
	 * @see com.solucionesenjambre.tindertieso.aks.tier.UsersTracksTier#browsePDR(String, Object[])
	 */
	@GET
	@Path("/browse")
	@Produces(MediaType.APPLICATION_JSON)
	public String wsBrowsePDR(@QueryParam("params") final String csvParamsString, @HeaderParam("authorization") final String authorization)
	{
		UsersTokens user = usersTier.getByTokenFromAutho(authorization);
		
		if (user != null)
		{
			pdr = browsePDR(csvParamsString);
		}
		else
		{
			pdr.setError(authenticationError());
		}
		
		return JSONUtils.parseToJson(pdr);
	}
	
	/*
	 * Si se necesita modificar el browse, hacer una copia del metodo:
	 * public List<UsersTracks> browse(final String[] params)
	 * y modificar segun sea necesario
	 */
	
	/**
	 * Returns a row by its value in the PK
	 * @param keyId primary key value of table row
	 * @return object representig the found row. Returns {@code null} if {@code keyId} does not mach with any record
	 * @see com.solucionesenjambre.tindertieso.aks.tier.UsersTracksTier#getPDR(int)
	 */
	@GET
	@Path("/{keyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public String wsGetPDR(@PathParam("userId") final int userId, 
			@PathParam("trackId") final String trackId, @HeaderParam("authorization") final String authorization)
	{
		UsersTokens user = usersTier.getByTokenFromAutho(authorization);
		
		if (user != null)
		{
			UsersTracks obj = new UsersTracks();
			obj.setUserId(userId);
		obj.setTrackId(trackId);
			
			pdr = getPDR(obj);
		}
		else
		{
			pdr.setError(authenticationError());
		}
		
		return JSONUtils.parseToJson(pdr);
	}
	
	/**
	 * Saves a new object or updates an existing one based on primary key value.
	 * 
	 * <p>If operation is successfull, returned {@code ProcessDataResult} object will have a two elements array. First
	 * element must be the saved or updated object, the second one could be the catalog view object or null</p>

	 * <p>This method will receive as parameters all table fields in same order as table list them</p>
	 * 
	 * @param userId
	 * @param trackId
	 * @return {@code ProcessDataResult} object with the result of the operation in JSON format
	 * @see com.solucionesenjambre.tindertieso.aks.tier.UsersTracksTier#savePDR(UsersTracks)
	 */
	@POST
	@Path("/saveF")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.APPLICATION_JSON)
	public String wsSavePDR(
			@FormParam("userId") final int userId,
			@FormParam("trackId") final String trackId, 
			@HeaderParam("authorization") final String authorization)
	{
		UsersTracks obj = new UsersTracks();
		
		obj.setUserId(userId);
		obj.setTrackId(trackId);
		
		//savePDRExtended evaluates autho
		pdr = savePDRExtended(obj, authorization);
		
		return JSONUtils.parseToJson(pdr);
	}
	
	/**
	 * Saves a new object or updates an existing one based on primary key value.
	 * 
	 * <p>If operation is successfull, returned {@code ProcessDataResult} object will have a two elements array. First
	 * element must be the saved or updated object, the second one could be the catalog view object or null</p>

	 * @param incomingData stream of the object in JSON format
	 * @return {@code ProcessDataResult} object with the result of the operation in JSON format
	 * @see UsersTracksJTier#savePDRTable(String)
	 */
	@POST
	@Path("/saveO")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String wsSavePDR(InputStream incomingData, @HeaderParam("authorization") final String authorization)
	{
		String input = JSONUtils.parseToString(incomingData);
		UsersTracks obj = JSONUtils.stringToObject(input, UsersTracks.class);
		
		//savePDRExtended evaluates autho
		pdr = savePDRExtended(obj, authorization);
	
		return JSONUtils.parseToJson(pdr);
	}
	
	/**
	 * Save or update an object and prepares return to get the row if was called from a catalog
	 * @param UsersTracks obj to be saved or updated
	 * @param authorization string
	 * @return ProcessDataResult with the saved or updated object or the Error if something was wrong
	 * @see UsersTracksTier#savePDR(UsersTracks)
	 */
	private ProcessDataResult savePDRExtended(UsersTracks obj, String authorization)
	{
		UsersTokens user = usersTier.getByTokenFromAutho(authorization);
		
		if (user != null)
		{
			UsersTracks objSaved = save(obj);
			
			if (objSaved != null)
			{
				//reajustar para regreso de 'obj' y 'gridRowObj'
				Object[] results = {null, null};
				
				results[0] = objSaved;
				
				//Obtener el valor del grid en caso necesario
				//VwB-view name-JTier tier = new VwB-view name-JTier();
				//VwB-dto name- gridRowObj = tier.get(obj.get PK);
				
				//results[1] = gridRowObj;
				
				pdr.setResult(results);
			}
			else
			{
				pdr.setResult(null);
			}
		}
		else
		{
			pdr.setError(authenticationError());
		}
		
		return pdr;
	}
	
	/**
	 * Delete a row in database given a value for the primary key.
	 * 
	 * <p>This method do not handle database's referential integrity of tables. If error ocurrs, pdr</p>
	 * @param keyId primary key value of the row to be deleted
	 * @return {@code ProcessDataResult} object with the result of the operation in JSON format
	 * @see UsersTracksTier#deletePDR(int)
	 */
	@GET
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public String wsDeletePDR(@QueryParam("userId") final int userId, 
			@QueryParam("trackId") final String trackId, @HeaderParam("authorization") final String authorization)
	{
		UsersTokens user = usersTier.getByTokenFromAutho(authorization);
		
		if (user != null)
		{
			UsersTracks obj = new UsersTracks();
			obj.setUserId(userId);
		obj.setTrackId(trackId);
			
			pdr = deletePDR(obj);
		}
		else
		{
			pdr.setError(authenticationError());
		}
		
		return JSONUtils.parseToJson(pdr);
	}
}
