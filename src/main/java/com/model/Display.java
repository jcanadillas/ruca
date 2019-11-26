package com.model;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.users.*;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;
import javax.jdo.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;

// Referenced classes of package com.model:
//            PMF, MediaObject

public class Display extends HttpServlet
{

    public Display()
    {
    }

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
        throws IOException, ServletException
    {
        String blobKeyString = req.getParameter("key");
        if(blobKeyString == null || blobKeyString.equals(""))
        {
            resp.sendRedirect((new StringBuilder("/?error=")).append(URLEncoder.encode("BlobKey not provided", "UTF-8")).toString());
            return;
        }
        BlobKey blobKey = new BlobKey(blobKeyString);
        PersistenceManager pm = PMF.get().getPersistenceManager();
        Query query = pm.newQuery(MediaObject.class, "blob == blobParam");
        query.declareImports("import com.google.appengine.api.blobstore.BlobKey");
        query.declareParameters("BlobKey blobParam");
        List results = (List)query.execute(blobKey);
        if(results.isEmpty())
        {
            resp.sendRedirect((new StringBuilder("/?error=")).append(URLEncoder.encode("BlobKey do`es not exist", "UTF-8")).toString());
            return;
        }
        UserService userService = UserServiceFactory.getUserService();
        User user = userService.getCurrentUser();
        MediaObject result = (MediaObject)results.get(0);
        if(!result.isPublic() && !result.getOwner().equals(user))
        {
            resp.sendRedirect((new StringBuilder("/?error=")).append(URLEncoder.encode("Not authorized to access", "UTF-8")).toString());
            return;
        } else
        {
            String rotation = req.getParameter("rotate");
            String displayURL = (new StringBuilder(String.valueOf(result.getURLPath()))).append("&rotate=").append(rotation).toString();
            String authURL = user == null ? userService.createLoginURL("/") : userService.createLogoutURL("/");
            req.setAttribute("displayURL", displayURL);
            req.setAttribute("authURL", authURL);
            req.setAttribute("user", user);
            req.setAttribute("rotation", rotation);
            req.setAttribute("item", result);
            req.setAttribute("blobkey", blobKeyString);
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/templates/display.jsp");
            dispatcher.forward(req, resp);
            return;
        }
    }
}