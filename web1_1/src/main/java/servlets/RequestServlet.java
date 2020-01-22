package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


//@WebServlet("/mult")

public class RequestServlet extends HttpServlet {
    //@Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
      //  resp.setContentType("/milt");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pwriter=resp.getWriter();
        String value = req.getParameter("value");
        try{
            Integer.parseInt(value);
            pwriter.println((int)(Math.pow(Integer.parseInt(value),2)));
            pwriter.close();
        }catch (NumberFormatException e){
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
}