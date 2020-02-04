package com.wipro.bus.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.wipro.bus.bean.ScheduleBean;
import com.wipro.bus.util.DBUtil;

public class ScheduleDAO {
	public String createSchedule(ScheduleBean scheduleBean) {
		try {
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement("INSERT INTO SCHDULE_TBL VALUES(?,?,?,?,?)");
			ps.setString(1,scheduleBean.getScheduleId());
			ps.setString(2,scheduleBean.getSource());
		    ps.setString(3,scheduleBean.getDestination());
		    ps.setString(4,scheduleBean.getStartTime());
		    ps.setString(5,scheduleBean.getArrivalTime());
			
					
		}catch(SQLException e) {
			System.out.println(e);
		}
		return "SUCCESS";
	}
	public String generateID(String source, String destination) {
		String src="";
		String des="";
		int id=0;
		try {
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=con.prepareStatement("SELECT SCHEDULE_SEQ.NEXTVAL FROM DUAL");
					ResultSet rs=ps.executeQuery();
			if(rs.next()) {
				id=rs.getInt(1);
			}
	src=source.toUpperCase().substring(0,3);
	des=destination.toUpperCase().substring(0,3);
		}
		catch(SQLException e) {
			System.out.println(e);
		}
		return src+des+id;
		
		
	}
	public ArrayList<ScheduleBean> viewSchedule(String source,String destination){
		ArrayList<ScheduleBean> list=new ArrayList<ScheduleBean>();
		try {
			
			Connection con=DBUtil.getDBConnection();
			PreparedStatement ps=prepareStatement("SELECT * FROM SCHEDULE_TBL WHERE SOURCE=? AND DESTINATION=?");
			ps.setString(1, source);
			ps.setString(2, destination);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				ScheduleBean bean=new ScheduleBean();
				bean.setScheduleId(rs.getString(1));
				bean.setSource(rs.getString(2));
				bean.setDestination(rs.getString(3));
				bean.setStartTime(rs.getString(4));
				bean.setArrivalTime(rs.getString(5));
				list.add(bean);
			}
		
		}catch(SQLException e) {
			System.out.println(e);
		}
		return list;
		}
	}

}
