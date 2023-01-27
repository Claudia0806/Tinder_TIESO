package com.solucionesenjambre.tindertieso.ws;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Paths;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.solucionesenjambre.tindertieso.aks.dto.Users;
import com.solucionesenjambre.tindertieso.jtier.UsersJTier;

import mx.arkesol.file.FileUtils;

/**
 * Servlet implementation class UserCreation
 */
@WebServlet("/UserCreation")
@MultipartConfig
public class UserCreation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	//Variable used for debugging in console
	final boolean DEBUG = false;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCreation() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//We receive the parameters from the form
		String fullname			= request.getParameter("fullname") == null ? "": request.getParameter("fullname");
		String email			= request.getParameter("email") == null ? "": request.getParameter("email");
		Part filePart			= request.getPart("imagen"); // Retrieves <input type="file" name="file">
	    String fileName			= Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	    InputStream fileContent	= filePart.getInputStream();
	    
	    
	    if (DEBUG)
	    	System.out.println("Carga de datos");
	    
	    HttpSession session = request.getSession();
	    
	    try 
	    {
	    	//We get the first part of the path were we will store our image
			String savePath = FileUtils.getWebAppPath() + "/profiles/";
			//This converts our InputStream into an Image object
			Image image = ImageIO.read(fileContent);
			
			UsersJTier tier	= new UsersJTier();
			Users obj 		= new Users();
			
			//Setting the object first with an image dummy to get the id to store the actual image
			obj.setFullname(fullname);
			obj.setEmail(email);
			obj.setImage("x");
			
			tier.save(obj);
			
		    if (DEBUG)
		    	System.out.println("First insert");
			
		    //If the object insertion is valid we will proceed to image insertion
			if (obj != null)
			{
				//We set a session attribute to use it later for data storing
				int userID = obj.getUserId();
				session.setAttribute("id", userID);
				
				//This is the process to save an image from an input stream
				String filePath = savePath + String.valueOf(userID) + ".jpg";
				BufferedImage im = (BufferedImage) image;
				ImageIO.write(im, "jpg", new File (filePath));

				//We update the user with the true image in the db
				obj.setImage(filePath);
				tier.save(obj);
				
				//If insertion is valid then we redirect the user to the spotify part
				if (obj != null)
					response.sendRedirect("SpotifyAPI.jsp");
				else
				{
					response.sendRedirect("./Error.html");
					System.out.println(tier.getError().getMessage());
				}	
			}
			else
			{
				response.sendRedirect("./Error.html");
				System.out.println(tier.getError().getMessage());
			}
	    }
	    finally {}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
