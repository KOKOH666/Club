package ua.newhouses.club.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ua.newhouses.club.manager.MemberManager;

public class MembersServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
		 
		 req.setAttribute("memberList", MemberManager.getAllMembers());
		 req.getRequestDispatcher("pages/allMembers.jsp" ).forward(req, resp); 
		 
    }
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
