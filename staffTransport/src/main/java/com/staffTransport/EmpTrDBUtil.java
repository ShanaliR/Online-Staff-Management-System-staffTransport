package com.staffTransport;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmpTrDBUtil {
	
	private static boolean isSuccess;
	private static Connection con=null;
	private static Statement stmt=null;
	private static ResultSet rs=null;
	
	public static boolean validate(String name,String email){
		 // Validate the existence of a transport record with the given name and email
		try {
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from transport where name='"+name+"' and email='"+email+"'";
			rs=stmt.executeQuery(sql);
				
			if(rs.next()) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
		
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static List<Transport> getTransport(String name){
		// Get a list of transport records associated with a specific name
		ArrayList<Transport> transport=new ArrayList<>();
		
		try {
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from transport where name='"+name+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String nameU=rs.getString(2);
				String email=rs.getString(3);
				String phone=rs.getString(4);
				String address=rs.getString(5);
				String distance=rs.getString(6);
				

				Transport tr= new Transport(id,nameU,email,phone,address,distance);
				transport.add(tr);
			}
			
		}catch(Exception e) {
			
		}
		return transport;
	}
	
	public static boolean insertTrEmp(String name,String email,String phone,String address,String distance) {
		// Insert a new employee transport record into the database
		boolean isSuccess=false;
		
		try {
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="insert into transport values(0,'"+name+"','"+email+"','"+phone+"','"+address+"','"+distance+"')";
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			}else {
				isSuccess=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	public static boolean updateTransport(String id,String name,String email,String phone,String address,String distance) {
		 // Update an existing transport record
		try {
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="update transport set name='"+name+"',email='"+email+"',phone='"+phone+"',address='"+address+"',distance='"+distance+"'"
					+"where id='"+id+"'"; 
			int rs=stmt.executeUpdate(sql);
			
			if(rs>0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public static List<Transport> getTransportDetails(String Id){
		// Get details of a specific transport record by ID
		int convertedID=Integer.parseInt(Id);
		
		ArrayList<Transport> trans=new ArrayList<>();
		
		try {		
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="select * from transport where id='"+convertedID+"'";
			rs=stmt.executeQuery(sql);
			
			while(rs.next()) {
				int id=rs.getInt(1);
				String name=rs.getString(2);
				String email=rs.getString(3);
				String phone=rs.getString(4);
				String address=rs.getString(5);
				String distance=rs.getString(6);
				
				Transport t=new Transport(id,name,email,phone,address,distance);
				trans.add(t);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return trans;		
	}
	
	public static boolean deleteTransport(String id) {
		 // Delete a transport record by ID
		int convId=Integer.parseInt(id);
		
		try {
			con=DBConnect.getConnection();
			stmt=con.createStatement();
			String sql="delete from transport where id='"+convId+"'";
			int r=stmt.executeUpdate(sql);
			
			if(r>0) {
				isSuccess=true;
			}
			else {
				isSuccess=false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return isSuccess;
	}
}

