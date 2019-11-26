package com.model;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.users.*;
import com.model.dao.GaleriaDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.jdo.PersistenceManager;
import javax.jdo.PersistenceManagerFactory;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package com.model:
//            PMF, Gallery

public class Upload extends HttpServlet
{

    private BlobstoreService blobstoreService;

    public Upload()
    {
        blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException
    {
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        RequestDispatcher dispatcher = null;
        if(user.getEmail().equalsIgnoreCase("raultribaldos@gmail.com") || user.getEmail().equalsIgnoreCase("gracialafamilia@gmail.com") ||
        		user.getEmail().equalsIgnoreCase("jcanadillas@gmail.com"))
        {
            String authURL = userService.createLogoutURL("/");
            String uploadURL = blobstoreService.createUploadUrl("/post");
            req.setAttribute("uploadURL", uploadURL);
            req.setAttribute("authURL", authURL);
            req.setAttribute("user", user);
            String gallery = req.getParameter("galeria");
            if(gallery != null && (gallery.equals("obraNueva") || gallery.equals("decoracion") || gallery.equals("oficinas") || gallery.equals("reformas")))
            {
                try
                {
                    cargaGallery(req, resp, gallery);
                    if(gallery.equals("obraNueva"))
                    {
                        dispatcher = req.getRequestDispatcher("WEB-INF/templates/obraNueva.jsp");
                    } else
                    if(gallery.equals("oficinas"))
                    {
                        dispatcher = req.getRequestDispatcher("WEB-INF/templates/office.jsp");
                    } else
                    if(gallery.equals("reformas"))
                    {
                        dispatcher = req.getRequestDispatcher("WEB-INF/templates/ref.jsp");
                    } else
                    {
                        dispatcher = req.getRequestDispatcher("WEB-INF/templates/deco.jsp");
                    }
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
            } else
            {
                GaleriaDAO galleryDao = new GaleriaDAO();
                PersistenceManager pm = PMF.get().getPersistenceManager();
                List galerias = new ArrayList();
                Gallery principal = null;
                try
                {
                    principal = GaleriaDAO.getGalleryByName(pm, "principal");
                }
                catch(Exception e1)
                {
                    e1.printStackTrace();
                }
                req.setAttribute("principal", principal);
                dispatcher = req.getRequestDispatcher("WEB-INF/templates/admin.jsp");
            }
        } else
        {
            dispatcher = req.getRequestDispatcher("/index.jsp");
        }
        dispatcher.forward(req, resp);
    }

    public void cargaGallery(HttpServletRequest req, HttpServletResponse resp, String galeria)
        throws Exception
    {
        GaleriaDAO galleryDao = new GaleriaDAO();
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Gallery gallery = null;
        gallery = GaleriaDAO.getGalleryByName(pm, galeria);
        req.setAttribute("galeria", gallery);
    }
}
