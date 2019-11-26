/* Copyright (c) 2009 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.model;

import java.io.IOException;
import java.util.*;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;
import com.model.dao.GaleriaDAO;

@SuppressWarnings("serial")
public class Index extends HttpServlet {

  public void doGet(HttpServletRequest req, HttpServletResponse resp) throws
      IOException, ServletException {

    UserService userService = UserServiceFactory.getUserService();
    User user = userService.getCurrentUser();

    String authURL = (user != null) ? userService.createLogoutURL("/") : userService.createLoginURL("/");
   
    //DAO
    GaleriaDAO galleryDao = new GaleriaDAO();

    String stIdGal = req.getParameter("galeria");
   // System.out.println("Galeria solicitada: " + stIdGal);
    
    //Fotos a Mostrar
    List<MediaObject> results = new ArrayList<MediaObject>();
    
    //Colección de Galerias
    PersistenceManager pm = PMF.get().getPersistenceManager();
   /* Query query = pm.newQuery(Gallery.class);
    List<Gallery> galerias = (List<Gallery>) query.execute(user);
    */
    List<Gallery> galerias = new ArrayList<Gallery>();
	try {
		galerias = galleryDao.getGalerias(pm);
	} catch (Exception e1) {
		e1.printStackTrace();
	}
    
    if(stIdGal != null && !stIdGal.isEmpty() && !stIdGal.equals("A")){
    	try {
			Gallery galeria = GaleriaDAO.getGaleria(pm, Long.parseLong(stIdGal));
			results.addAll(galeria.getFotos());
		}  catch (Exception e) {
			e.printStackTrace();
		}
    }else{
    	Gallery galeria=null;
		try {
			galeria = GaleriaDAO.getGalleryByName(pm, "Principal");
			if (galeria.getFotos().size() > 0){
	       		results.addAll(galeria.getFotos());
	       	}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
   
    String[] errors = req.getParameterValues("error");
    if (errors == null) errors = new String[0];

    req.setAttribute("errors", errors);
    req.setAttribute("files", results);
    req.setAttribute("galerias", galerias);
    req.setAttribute("authURL", authURL);
    req.setAttribute("user", user);
    RequestDispatcher dispatcher = null;
    if(stIdGal != null && !stIdGal.isEmpty()) dispatcher =req.getRequestDispatcher("galerias.jsp");
    else dispatcher =req.getRequestDispatcher("index.jsp");
    dispatcher.forward(req, resp);
  }
}
