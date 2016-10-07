package examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import examples.model.Department;
import examples.model.Project;
import examples.stateless.ProjectService;

public class ProjectServiceServlet extends HttpServlet {

    private final String TITLE = 
        "Chapter 8: Using IDs Containing Relationships Example";
    
    private final String DESCRIPTION = 
        "This example demonstates the basics of using primary keys that include relationships.";

    @EJB ProjectService service;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        printHtmlHeader(out);
        
        // process request
        String action = request.getParameter("action");
        if (action == null) {
            // do nothing if no action requested
        } else if (action.equals("Create")) {
            Project proj = service.createProject(
                    request.getParameter("name"),
                    parseInt(request.getParameter("deptId")));
            out.print("Created" + proj + "<hr>");
        }
        
        out.println("Project: </br>");
        for (Project p : service.findAllProjects()) {
            out.print(p + " " + p.getDepartment() + "<br/>");
        }   
        
        out.println("</br>Departments: </br>");
        for (Department d : service.findAllDepartments()) {
            out.print(d + " " + d.getProjects().size() + "<br/>");
        }
        
        printHtmlFooter(out);
    }
    
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
        
    private int parseInt(String intString) {
        try {
            return Integer.parseInt(intString);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private void printHtmlHeader(PrintWriter out) throws IOException {
        out.println("<body>");
        out.println("<html>");
        out.println("<head><title>" + TITLE + "</title></head>");
        out.println("<center><h1>" + TITLE + "</h1></center>");
        out.println("<p>" + DESCRIPTION + "</p>");
        out.println("<hr/>");
        out.println("<form action=\"ProjectServiceServlet\" method=\"POST\">");
        // form to create and Employee 
        out.println("<h3>Create a Project </h3>");
        out.println("<table><tbody>");
        out.println("<tr><td>Project Name:</td><td><input type=\"text\" name=\"name\"/>(String)</td></tr>");
        out.println("<tr><td>Department Id:</td><td><input type=\"text\" name=\"deptId\"/>(int)</td>" +
                    "<td><input name=\"action\" type=\"submit\" value=\"Create\"/></td></tr>");
        out.println("</tbody></table>");
        out.println("<hr/>");
    }
    
    
    private void printHtmlFooter(PrintWriter out) throws IOException {
        out.println("</html>");
        out.println("</body>");
        out.close();
    }
}
