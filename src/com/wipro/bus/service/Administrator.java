package com.wipro.bus.service;

import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.dao.ScheduleDAO;

public class Administrator {
	public String addSchedule(ScheduleBean scheduleBean) {
		ScheduleDAO scheduleDAO=new ScheduleDAO();
		if(scheduleBean.getSource().equals(scheduleBean.getDestination())) {
			return "Source and Destination Same";
		}else {
			String sId=scheduleDAO.generateID(scheduleBean.getSource(),scheduleBean.getDestination());
		    scheduleBean.setScheduleId(sId);
			return scheduleDAO.createSchedule(scheduleBean);
	}
	}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
		ScheduleDAO scheduleDAO=new ScheduleDAO();
		  return scheduleDAO.viewSchedule(source, destination);
	}


}
