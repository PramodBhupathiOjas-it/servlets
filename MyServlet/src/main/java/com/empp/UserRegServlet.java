package com.empp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.empp.dao.PersonDao;
import com.empp.model.Person;

/**
 * Servlet implementation class UserRegServlet
 */
@WebServlet("/UserRegServlet")
public class UserRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	PersonDao persondao;
    public UserRegServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		persondao=new PersonDao();
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		String ename=request.getParameter("ename");
		String contactno=request.getParameter("contactno");
		String email=request.getParameter("email");
		String genderr=request.getParameter("gender");
		String address=request.getParameter("address");
		Person p=new Person();
		p.setEname(ename);
		p.setContactno(contactno);
		p.setEmail(email);
		p.setGender(genderr);
		p.setAddress(address);
		try {
		if(persondao.addPerson(p)) {
		pw.println("<h1 style=background-color:maroon;"+"color:white;padding:20px;"+"text-align:center;>"+"Your registration suceessfull</h1>");
		}
		else {
		System.out.println("<h1 style=color:red>"+"Try Again</h1>");
		}
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	/**
	* @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	*/
	
}
