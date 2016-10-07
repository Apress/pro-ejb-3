package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.stateless.DepartmentService;

public class DepartmentServiceServlet extends HttpServlet {

    private final String TITLE = 
        "Chapter 3: Dependency Lookup Example";
    
    private final String DESCRIPTION = 
        "This example demonstrates InitialContext lookup of a dependency. </br>" +
        "Click the 'Audit' button.  This will trigger a servlet client that looks " +
        "up a SLSB dependency that was defined in the web.xml file. That SLSB in turn " +
        "looks up another SLSB using the dependency is defined using the @EJB annotation.";


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);

        
        if (request.getParameter("action") != null) {
            DepartmentService service = null;
            try {
                service = (DepartmentService)
                    new InitialContext().lookup("java:comp/env/ejb/DepartmentService");
            } catch (Exception e) {
                throw new ServletException(e);
            }
            service.performAudit();
            out.println("Audit Performed");
        }
        
        printHtmlFooter(out);
    }
    
    
    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("</hr>");
        out.println("<form action=\"DepartmentServiceServlet\" method=\"POST\">");
        out.println("<input name=\"action\" type=\"submit\" value=\"Audit\"/>");
        out.println("</form>");
        out.println("<hr/>");
    }
    
    
    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
