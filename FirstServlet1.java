package com.nt.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;


public class FirstServlet1 extends HttpServlet {
	
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//General seting 
		PrintWriter pw=null;
		pw=res.getWriter();
		res.setContentType("text/html");
		//get values submit by the form 1
		String s1=req.getParameter("name");
		String s2=req.getParameter("fname");
		//create cookies to store by the form data 
			Cookie ck1=new Cookie("name", s1);
			Cookie ck2=new Cookie("fname", s2);
			//seting values cookies 
			res.addCookie(ck1);
			res.addCookie(ck2);
			//now we need to generate the second from dynamically form here 
			pw.println("<form action='surl' method ='post'>");
			pw.println("Income for the year <input type='text' name='income'><br>");
			pw.println("Tax<input type='text' name='tax'>");
			pw.println("<br><br><RB><RB><input type='submit' values='submit'>");
			pw.println("</form>");
			//close stream here 
			pw.close();

	}//end of the method 	
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//end of the method 

}//end of the class
