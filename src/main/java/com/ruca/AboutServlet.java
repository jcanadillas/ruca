package com.ruca;

import com.google.appengine.api.users.*;
import java.io.PrintStream;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*;

// Referenced classes of package com.ruca:
//            AdminServlet

public class AboutServlet extends HttpServlet
{
   
    public AboutServlet()
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
            String op = req.getParameter("op");
            System.out.println((new StringBuilder("Op:")).append(op).toString());
            RequestDispatcher dispatcher =  req.getRequestDispatcher("reformas.jsp");
            if(op != null && op.equals("reforma"))
            {
                dispatcher = req.getRequestDispatcher("reformando.jsp");
            }
            dispatcher.forward(req, resp);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
