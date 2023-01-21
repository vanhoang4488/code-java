package helloworld_1;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/other/exampleInfo")
public class Example_doGet extends HttpServlet{
    private static final long serialVersionUID=3;
    
    public Example_doGet() {}
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	ServletOutputStream out= response.getOutputStream();
    	out.println("<style> p{color:blue;} </style>");
        
    	String requestURL= request.getRequestURL().toString();
    	out.println("<p>requestURL: " + requestURL + "</p>");
    	
    	String requestURI= request.getRequestURI().toString();
    	out.println("<p>requestURI: " + requestURI+ "</p>");
    	
    	String contextPath= request.getContextPath();
    	out.println("<p>contextPath: " + contextPath + "</p>");
    	
    	String servletPath= request.getServletPath();
    	out.println("<p>servletPath: " + servletPath + "</p>");
    	
    	String queryString= request.getQueryString();
    	out.println("<p>queryString: " + queryString + "<p>");
    	
    	String param1= request.getParameter("text1");
    	out.println("<p>param1: " + param1 + "</p>");
    	
    	String param2= request.getParameter("text2");
    	out.println("<p>param2: " + param2 + "</p>");
    	
    	out.println("<b>Server infos</b>");
    	String serverName= request.getServerName();
    	out.println("<p>serverName: " + serverName + "</p>");
    	
    	int serverPort= request.getServerPort();
    	out.println("<p>serverPort: " + serverPort + "</p>");
    	
    	out.println("<b>Client infos</b>");
    	String remoteAddr = request.getRemoteAddr();
    	out.println("<p>remoteAddr: " + remoteAddr + "</p>");
    	
    	String remoteHost = request.getRemoteHost();
    	out.println("<p>remoteHost: " + remoteHost + "</p>");
    	
    	String remoteUser = request.getRemoteUser();
    	out.println("<p>remoteUser: " + remoteUser + "</p>");
    	
    	out.println("<b> Header : </b>");
    	Enumeration<String> headers = request.getHeaderNames();
        while (headers.hasMoreElements()) {
             String header = headers.nextElement();
             out.println("<p>" + header + ": " + request.getHeader(header) + "</p>");
        }
    	
    	 out.println("<b>Servlet Context info:</b>");
         ServletContext servletContext = request.getServletContext();
         String realPath = servletContext.getRealPath("");
         out.println("<p>realPath: " + realPath + "</p>");
    }
}
