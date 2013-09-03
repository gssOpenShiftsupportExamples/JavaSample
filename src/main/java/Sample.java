package src.main.java;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Sample extends HttpServlet {
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    out.println("Hello World");
  }
}
