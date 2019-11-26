package com.ruca;

import com.google.appengine.api.users.*;
import com.model.Gallery;
import com.model.PMF;
import java.io.IOException;
import java.util.logging.Logger;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

public class AdminServlet extends HttpServlet
{

    public AdminServlet()
    {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
    {
        try
        {
            UserService userService = UserServiceFactory.getUserService();
            User user = userService.getCurrentUser();
            String authURL = userService.createLogoutURL("/");
            req.setAttribute("authURL", authURL);
            req.setAttribute("user", user);
            RequestDispatcher dispatcher = null;
            String galeria = (String)req.getAttribute("galeria");
            if(galeria == null)
            {
                galeria = req.getParameter("galeria");
            }
            String destino = "admin.jsp";
            if(galeria != null && !galeria.trim().isEmpty())
            {
                if(galeria.equals("0"))
                {
                    destino = "galeria.jsp";
                } else
                {
                    PersistenceManager pm = PMF.get().getPersistenceManager();
                    Gallery gallery = new Gallery(galeria);
                    PMF.get().getPersistenceManager().makePersistent(gallery);
                    req.setAttribute("galeria", galeria);
                }
            }
            dispatcher = req.getRequestDispatcher(destino);
            dispatcher.forward(req, resp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void doPost(HttpServletRequest req, HttpServletResponse resp)
        throws IOException
    {
        try
        {
            UserService userService = UserServiceFactory.getUserService();
            User user = userService.getCurrentUser();
            String authURL = userService.createLogoutURL("/");
            req.setAttribute("authURL", authURL);
            req.setAttribute("user", user);
            String galeria = req.getParameter("galeria");
            if(galeria != null && !galeria.trim().isEmpty())
            {
                PersistenceManager pm = PMF.get().getPersistenceManager();
                Gallery gallery = new Gallery(galeria);
                PMF.get().getPersistenceManager().makePersistent(gallery);
                req.setAttribute("galeria", galeria);
            }
            RequestDispatcher dispatcher = req.getRequestDispatcher("panel.jsp");
            dispatcher.forward(req, resp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
