package com.empp;

 

import java.io.IOException;
import java.io.PrintWriter;

 

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 

import com.empp.dao.PersonDao;
import com.empp.model.Person;

 

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    PersonDao pd;

 

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {

 

    }

 

    @Override
    public void init(ServletConfig config) throws ServletException {
        pd = new PersonDao();
    }

 

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int num = Integer.parseInt(request.getParameter("no"));
        String ename = request.getParameter("ename");
        String contactno = request.getParameter("contactno");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");

 

        pw.println("<html><head><style type=text/css>");
        pw.println("table { width : 50;border-collapse: collapse; background-color: collapse;border-spacing: 10px}");
        pw.println("table , tr, td {border: 1px solid blue }");
        pw.println("th, td {padding: 20px;}</Style></head><body>");
        pw.println("<form action=UpdateServlet method=POST>");
        pw.println("<h1 style=background-color: maroon;");
        pw.println("color: white; padding: 20px; text-align: center;>");
        pw.println("Welcome to Updation Page</h1>");
        pw.println("<table align=center><tr>");
        pw.println("<input type=hidden name=pid value=" + num + ">");
        pw.println("<td>Enter Name:</td>");
        pw.println("<td><input type=text name=ename value=" + ename + "></td></tr>");
        pw.println("<tr><td>Enter Contact no:</td>");
        pw.println("<td><input type=text name=contactno value=" + contactno + "></td></tr>");
        pw.println("<tr><td>Enter Email:</td>");
        pw.println("<td><input type=text name=email value=" + email + "></td></tr>");
        pw.println("<tr><td>Gender</td><td>");
        if (gender.equals("Male")) {
            pw.println("<input type=radio name=gender value = Male>Male");
            pw.println("<input type=radio name=gender value = off>female</td>");
        } else {
            pw.println("<input type=radio name=gender value = off>Male");
            pw.println("<input type=radio name=gender value = female>female</td>");
        }

 

        pw.println("</tr><tr><td>Address:</td>");
        pw.println("<td><textarea name=address value ="+address+" rows=5 cols=20></textarea></td></tr>");
        pw.println("<tr><td colspan=2 align=center><input type=submit value=click></td></tr>");
        pw.println("</table></form></body></html>");

 

    }

 

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        int num = Integer.parseInt(request.getParameter("pid"));
        String ename = request.getParameter("ename");
        String contactno = request.getParameter("contactno");
        String email = request.getParameter("email");
        String gender = request.getParameter("gender");
        String address = request.getParameter("address");
        
        Person p = new Person();
        p.setPid(num);
        p.setEname(ename);
        p.setContactno(contactno);
        p.setEmail(email);
        p.setGender(gender);
        p.setAddress(address);
        if(pd.updatePerson(p)) {
            pw.println("<h3 style=color:blue>Updated Successfully</h3>");
        }
        else {
            pw.println("<h3 style=color:red>Try Again</h3>");
        }
        
    }

 

}