

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("form-username");
		String password = request.getParameter("form-password");
		PrintWriter out = response.getWriter();
		
		try {
	    	  boolean value = AdministratorLogin.LoginCheck(username, password);
	    	  if(value)
	    	  {
	    		  RequestDispatcher rs = request.getRequestDispatcher("uploaddetails.jsp");
	        		rs.forward(request, response);
	    	  }
	    	  else
	    	  {
	    		  RequestDispatcher rs = request.getRequestDispatcher("erroradminindex.jsp");
	        		rs.forward(request, response);	    	  }
	        } 
	        catch (Exception e) {
	             e.getMessage();
	             out.println(e);
	        }
	}
	}


