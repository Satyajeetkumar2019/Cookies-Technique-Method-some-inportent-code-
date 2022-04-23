package com.nt.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.PreparedStatement;
import com.sun.corba.se.pept.transport.Connection;
import java.io.PrintWriter;
import java.sql.*;
public class SecondServlet2 extends HttpServlet {
	public  void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	//create variable below 
		PrintWriter pw=null;
		String income=null;
		String tax=null;
		String name=null;
		int result=0;
		//Cookie ck[]=null;
		String fname=null;
		//Genral seting 
		pw=res.getWriter();
		res.setContentType("text/html");
		//Get values submit by the form 2
		income=req.getParameter("income");
		tax=req.getParameter("tax");
		//read form1 req1 data  form cookies
		Cookie ck[]=req.getCookies();
		if(ck!=null) {
			name=ck[0].getValue();
			fname=ck[1].getValue();
		}//end of the if block 
		//Write JDBC code here belpw 
		//create basic variable 
				Connection con=null;
				ResultSet rs=null;
				PreparedStatement ps=null;
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					//establish the connection 
					con=(Connection) DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","saka");
//create PreparedStatement statement object 
					ps= ((java.sql.Connection) con).prepareStatement("insert into tax_tab values(?,?,?,?)");
					ps.setString(1,name);
					ps.setString(2,fname);
					ps.setString(3,income);
					ps.setString(4,tax);
					//excuate the queary below 
					result=ps.executeUpdate();
					if(result==1)
					pw.println("<br>Record has been insert ");
					else
						pw.println("<br>Record has been  not insert ");	
				}catch(Exception e) {
					e.getStackTrace();
				}//end catch block 
//Display data from 2 and form1 data 
				pw.println("Form2 data "+income+"..."+tax);
				pw.println("Form1 data "+name+"..."+fname);
				//close stream 
				pw.close();
			
	}//end of the method 
	public  void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}//end of the method 

}//end of the class
