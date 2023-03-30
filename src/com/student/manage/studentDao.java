package com.student.manage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class studentDao {
	public static boolean insertStudentToDB(Student st) {
		boolean f = false;
		try {
			// jdbc connection..
			Connection con = CP.createC();
			String q = "insert into student(sname,sphone,scity) values(?,?,?)";

			// preparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);

			// set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());

			// execute query
			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean deleteStudent(int userId) {
		boolean f = false;
		try {
			// jdbc connection..
			Connection con = CP.createC();

			// fire Dynamic Query
			String q = "delete from student where sid = ?";

			// preparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);

			// set the values of parameters
			pstmt.setInt(1, userId);

			// execute query
			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean showStudent() {
		boolean f = false;
		try {
			// jdbc connection..
			Connection con = CP.createC();

			// firing Static query
			String q = "select * from student";

			Statement stmt = con.createStatement();

			ResultSet set = stmt.executeQuery(q);

			while (set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);

				System.out.println("ID :" + id);
				System.out.println("Name :" + name);
				System.out.println("Phone :" + phone);
				System.out.println("City :" + city);
				System.out.println("=========================");
			}
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static boolean updateStudent(Student st, int id) {
		boolean f = false;
		try {
			// create connection
			Connection con = CP.createC();

			// Query
			String q = "update student set sname = ? ,sphone = ?,scity = ? where sid = ? ";
			PreparedStatement pstmt = con.prepareStatement(q);

			// set values
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			pstmt.setInt(4, id);

			pstmt.executeUpdate();
			f = true;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return f;
	}

}
