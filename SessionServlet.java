import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class SessionServlet extends HttpServlet {
  
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");

        // Create a session or get existing session
        HttpSession session = request.getSession(true);

        // Set session attributes
        session.setAttribute("userId", session.getId()); // using session ID as userId (you may want to use a database-generated ID in real-world scenario)
        session.setAttribute("username", username);

        // Redirect to user_info.jsp
        response.sendRedirect(request.getContextPath() + "/user_info.jsp");
    }
}
