/*
 * This is going to be the last Resourcemanager point of any app before
 * reach library functions. So any FS or LS package ResourceManager file
 * must extends this one
 * 
 * For more information please visit http://www.arkesol.mx
 * Author: Rene Gallardo
 */
package app.database;

import java.sql.Connection;

public class ResourceManager extends mx.arkesol.database.ResourceManager
{
    /**
     * Crea una conexión a la Db según los parámetros del archivo de configuraciones
     * 
     * @return la conexión a la DB
     * @throws Exception
     */
    public static synchronized Connection getConnection()
	throws Exception
	{
//    	return getConnectionPoolWeb();
    	return getConnectionWeb();
	}
}
