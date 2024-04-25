package com.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.EmployeeDao;
import com.model.Employee;

@WebServlet(value="/req3")
public class ThirdServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
		if(req.getParameter("b1").equalsIgnoreCase("add"))
		{
			Employee e1 = new Employee();
			e1.setEname(req.getParameter("ename"));
			e1.setEdesignation(req.getParameter("edesignation"));
			e1.setEsalary(Double.parseDouble(req.getParameter("esalary")));
			int check = new EmployeeDao().insertEmployee(e1);
			if(check>0)
				try {
					req.getRequestDispatcher("first.jsp").forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else
				try {
					resp.sendRedirect("error.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		if(req.getParameter("b1").equalsIgnoreCase("update"))
		{
			Employee e1 = new Employee();
			e1.setEid(Integer.parseInt(req.getParameter("eid")));
			e1.setEname(req.getParameter("ename"));
			e1.setEdesignation(req.getParameter("edesignation"));
			e1.setEsalary(Double.parseDouble(req.getParameter("esalary")));
			new EmployeeDao().updateEmployee(e1);
			try {
				resp.sendRedirect("display.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(req.getParameter("b1").equalsIgnoreCase("display"))
		{
			int eid = Integer.parseInt(req.getParameter("eid"));
			Employee e1 = new EmployeeDao().findByEid(eid);
			if(e1==null)
				try {
					resp.sendRedirect("display.jsp");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			else {
				req.setAttribute("employee", e1);
				try {
					req.getRequestDispatcher("second.jsp").forward(req, resp);
				} catch (ServletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		if(req.getParameter("b1").equalsIgnoreCase("delete"))
		{
			int eid = Integer.parseInt(req.getParameter("eid"));
			new EmployeeDao().deleteEmployeeByEid(eid);
			try {
				resp.sendRedirect("delete.jsp");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
