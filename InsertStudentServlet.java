
import java.beans.Expression;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.lang.model.util.Elements;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/InsertStudentServlet")
public class InsertStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;



	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("name");
        int age = Integer.parseInt(request.getParameter("age"));
        String email = request.getParameter("email");
        String course = request.getParameter("course");
        String gender = request.getParameter("gender");

        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbclearning", "root", "root");

            String query = "INSERT INTO student (name, age, email, course, gender) VALUES (?, ?, ?, ?, ?)";
            stmt = conn.prepareStatement(query);
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, email);
            stmt.setString(4, course);
            stmt.setString(5, gender);
            stmt.executeUpdate();

            response.sendRedirect("index.jsp"); // Redirect back to the form
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

	}
}


A scriptlet is defined with a start ,<%, an end,%>, with code between. 

Expressions

Expressions provide an easy method of sending out dynamic strings to a client. An expression must have a start,<%=, end,%>, and an expression between. An expression element differs in syntax from a scriptlet by an equal sign that must appear immediately after the start. 
Expressions always send a string of text to a client.

Declarations

Code embedded in a declaration can be used to declare new methods and variables.

<%! 
	int pageCount = 0;
	void addCount() 
	{
		pageCount++;
	}
%>
<%@ directive {attribute="value"}* %>
Demonstration of JSP Scripting Elements

Message: Welcome to JSP Scripting Elements!
Visitor Count: 1
Welcome, User!
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Scripting Elements Example</title>
</head>
<body>

    <h2>Demonstration of JSP Scripting Elements</h2>

    <%-- Declaration Block --%>
    <%! 
        int count = 0; // Declaration of an instance variable

        // Method declaration
        public String getMessage() {  
            return "Welcome to JSP Scripting Elements!";
        }
    %>

    <%-- Scriptlet Block --%>
    <%
        count++; // Incrementing the count
        String name = "User"; // Variable inside scriptlet
    %>

    <%-- Expression Block --%>
    <p><strong>Message:</strong> <%= getMessage() %></p> <!-- Expression to display method return value -->
    <p><strong>Visitor Count:</strong> <%= count %></p>  <!-- Expression to display count -->
    <p><strong>Welcome,</strong> <%= name %>!</p>  <!-- Expression to display the variable -->

</body>
</html>



<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>JSP Scripting Elements Example</title>
</head>
<body>

    <h2>Demonstration of JSP Scripting Elements</h2>

    <%-- Declaration Block --%>
    <%! 
        int count = 0; // Declaration of an instance variable
        public String getMessage() {  // Declaration of a method
            return "Welcome to JSP Scripting Elements!";
        }
    %>

    <%-- Scriptlet Block --%>
    <%
        count++; // Incrementing the count
        String name = "User";
    %>

    <%-- Expression Block --%
