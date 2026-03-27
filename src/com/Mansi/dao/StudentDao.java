package com.Mansi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.Mansi.db.DBConnection;
import com.Mansi.model.Student;

public class StudentDao implements StudentDaoInterface {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            con = DBConnection.createConnection();
            
            // ✅ Add this null check
            if (con == null) {
                System.out.println("❌ Failed to establish database connection!");
                return false;
            }
            
            String query = "INSERT INTO student_details(sname, clgname, city, percentage) VALUES(?,?,?,?)";
            pst = con.prepareStatement(query);
            
            pst.setString(1, s.getName());
            pst.setString(2, s.getClgName());
            pst.setString(3, s.getCity());
            pst.setDouble(4, s.getPercentage());
            
            int rowsAffected = pst.executeUpdate();
            
            if (rowsAffected > 0) {
                flag = true;
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        
        return flag;
    }

    @Override
    public boolean delete(int roll) {
        // TODO Auto-generated method stub
    	boolean flag=false;
    	Connection con = null;
    	try {
con = DBConnection.createConnection();
            
            // ✅ Add this null check
            if (con == null) {
                System.out.println("❌ Failed to establish database connection!");
                
            }
            String query="delete from student_details where rollnum="+roll;
            Statement stmt=con.createStatement();
            PreparedStatement pst = con.prepareStatement(query);
            pst.executeUpdate();
            flag=true;
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
        return flag;
    }

    @Override
    public boolean update(int roll, String update, int ch, Student s) {
    	Connection con = null;
    	boolean flag=false;
    	int choice=ch;
    	try {
    		if(choice==1) {
    			con = DBConnection.createConnection();
    			 String query="update student_details set sname=? where rollnum=?";
    	            Statement stmt=con.createStatement();
    	            PreparedStatement pst = con.prepareStatement(query);
    	            pst.setString(1, update);
    	            pst.setInt(2, roll);
    	            pst.executeUpdate();
    	            flag=true;
    		}
    		else if(choice==2) {
    			con = DBConnection.createConnection();
   			 String query="update student_details set clgname=? where rollnum=?";
   	            Statement stmt=con.createStatement();
   	            PreparedStatement pst = con.prepareStatement(query);
   	            pst.setString(1, update);
   	            pst.setInt(2, roll);
   	            pst.executeUpdate();
   	            flag=true;
   		}
    		
    	}catch(Exception e){
    		e.printStackTrace();
    	}
        // TODO Auto-generated method stub
        return flag;
    }

    @Override
    public void showAllStudent() {
        // TODO Auto-generated method stub
    	 Connection con = null;
    	try {
            con = DBConnection.createConnection();
            
            // ✅ Add this null check
            if (con == null) {
                System.out.println("❌ Failed to establish database connection!");
                
            }
            
            String query="select * from student_details";
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next()) {
            	System.out.println("RollNumber: "+rs.getInt(1)+"\nName: "+rs.getString(2)+"\nCollege: "+rs.getString(3)+"\nCity: "+rs.getString(4)+"\nPercentage: "+rs.getDouble(5));
            	System.out.println("----------------------------");
            }
    	}catch(Exception ex) {
    		ex.printStackTrace();
    	}
    }

    @Override
    public boolean showStudentById(int roll) {
        // TODO Auto-generated method stub
    	 Connection con = null;
     	try {
             con = DBConnection.createConnection();
             
             // ✅ Add this null check
             if (con == null) {
                 System.out.println("❌ Failed to establish database connection!");
                 
             }
             
             String query="select * from student_details where rollnum="+roll;
             Statement stmt=con.createStatement();
             ResultSet rs=stmt.executeQuery(query);
             while(rs.next()) {
             	System.out.println("RollNumber: "+rs.getInt(1)+"\nName: "+rs.getString(2)+"\nCollege: "+rs.getString(3)+"\nCity: "+rs.getString(4)+"\nPercentage: "+rs.getDouble(5));
             	System.out.println("----------------------------");
             }
     	}catch(Exception ex) {
     		ex.printStackTrace();
     	}
     
        return false;
    }
}