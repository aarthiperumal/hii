package com.wipro.bus.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.service.Administrator;

@WebServlet("/MainServlet")
public class MainServlet extends HttpServlet {
	public String addSchedule(HttpServletRequest request) {
		ScheduleBean scheduleBean=new ScheduleBean();
		String source=request.getParameter("source");
		String dest=request.getParameter("destination");
		String start=request.getParameter("startTime");
		String arrival=request.getParameter("arrivalTime");
		
		scheduleBean.setSource(source);
		scheduleBean.setSource(dest);
		scheduleBean.setSource(start);
		scheduleBean.setSource(arrival);
		
		Administrator admin=new Administrator();
		return admin.addSchedule(scheduleBean);
		
	}
	public ArrayList<ScheduleBean> viewSchedule(HttpServletRequest request){
		Administrator admin=new Administrator();
		String source=request.getParameter("source");
		String dest=request.getParameter("destination");
		return admin.viewSchedule(source, dest);
		
		
	}
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throwsServletException, IOException{
		String operation=request.getParameter("operation");
		String result="";
		if(operation.Equals("newSchedule")) { 
			result=addSchedule(request);
			if(result.contentEquals("SUCCESS")) {
				response.sendRedirect("success.jsp");
			}else {
				response.sendRedirct("error.html");
			}
		}
	if(operation.equals("viewSchedule")) {
		ArrayList<ScheduleBean> list=viewSchedule(request);
		RequestDispatcher rd=request.getRequestDispatcher("displaySchedule");
		if(list==null) {
			request.setAttribute("msg","No matching schedules exists! Please try again");
		}
		else {
			request.setAttribute("schedule",list);
		}
		rd.forward(request,response);
	}
		}
				

	}


	 
	 