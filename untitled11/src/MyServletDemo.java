import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;

public class MyServletDemo extends HttpServlet{

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
    {
        res.setContentType("text/html");
        PrintWriter pwriter=res.getWriter();
        String value = req.getParameter("value");
      
        try{
            Integer.parseInt(value);
            pwriter.println((int) (Math.pow(Integer.parseInt(value),2)));
            pwriter.close();
        }catch (NumberFormatException e){
            res.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}