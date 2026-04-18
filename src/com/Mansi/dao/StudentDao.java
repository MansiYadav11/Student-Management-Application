package com.Mansi.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Mansi.db.DBConnection;
import com.Mansi.model.Student;

public class StudentDao implements StudentDaoInterface {

    @Override
    public boolean insertStudent(Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();

            String query = "INSERT INTO student_details(rollnum, sname, clgname, city, percentage) VALUES(?,?,?,?,?)";
            PreparedStatement pst = con.prepareStatement(query);

            pst.setInt(1, s.getRollNum());
            pst.setString(2, s.getName());
            pst.setString(3, s.getClgName());
            pst.setString(4, s.getCity());
            pst.setDouble(5, s.getPercentage());

            int rows = pst.executeUpdate();
            if (rows > 0) flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean delete(int roll) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();

            String query = "DELETE FROM student_details WHERE rollnum=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, roll);

            pst.executeUpdate();
            flag = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean update(int roll, String update, int ch, Student s) {
        boolean flag = false;
        try {
            Connection con = DBConnection.createConnection();

            if (ch == 1) {
                String query = "UPDATE student_details SET sname=? WHERE rollnum=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, update);
                pst.setInt(2, roll);
                pst.executeUpdate();
                flag = true;
            } else if (ch == 2) {
                String query = "UPDATE student_details SET clgname=? WHERE rollnum=?";
                PreparedStatement pst = con.prepareStatement(query);
                pst.setString(1, update);
                pst.setInt(2, roll);
                pst.executeUpdate();
                flag = true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public void showAllStudent() {
        try {
            Connection con = DBConnection.createConnection();

            String query = "SELECT * FROM student_details";
            PreparedStatement pst = con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                System.out.println("RollNumber: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("College: " + rs.getString(3));
                System.out.println("City: " + rs.getString(4));
                System.out.println("Percentage: " + rs.getDouble(5));
                System.out.println("----------------------------");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean showStudentById(int roll) {
        boolean found = false;
        try {
            Connection con = DBConnection.createConnection();

            String query = "SELECT * FROM student_details WHERE rollnum=?";
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, roll);

            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                found = true;
                System.out.println("RollNumber: " + rs.getInt(1));
                System.out.println("Name: " + rs.getString(2));
                System.out.println("College: " + rs.getString(3));
                System.out.println("City: " + rs.getString(4));
                System.out.println("Percentage: " + rs.getDouble(5));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return found;
    }
}
