package com.test.pdf;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author mysqltutorial.org
 */
public class DB {

    /**
     * Update resume for a specific candidate
     *
     * @param candidateId
     * @param filename
     */
    public static void writeBlob(int candidateId, String filename) {
        // update sql
		/*
		 * String updateSQL = "UPDATE testPDff " + "SET resume = ? " + "WHERE id=?";
		 */
    	
    	String selectSQL = "SELECT resume FROM testPDff WHERE id=?";
        ResultSet rs = null;


        try{  

        	
        	


        				  
        	String dbURL = "jdbc:sqlserver://LAPTOP-FRQLDCL7\\RUPESHSQL:1433;DatabaseName=TEST;instance=RUPESHSQL;";
        				 String user = "sa"; String pass = "rupesh";
        				 

        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");


        	Connection myConn = DriverManager.getConnection(dbURL, user, pass);  


        	//PreparedStatement pstmt = myConn.prepareStatement(updateSQL);
        	PreparedStatement pstmt = myConn.prepareStatement(selectSQL);
        	
        	pstmt.setInt(1, candidateId);
            rs = pstmt.executeQuery();

            // write binary stream into file
            File file = new File(filename);
            FileOutputStream output = new FileOutputStream(file);

            System.out.println("Writing to file " + file.getAbsolutePath());
            while (rs.next()) {
                InputStream input = rs.getBinaryStream("resume");
                byte[] buffer = new byte[1024];
                while (input.read(buffer) > 0) {
                    output.write(buffer);
                }
            }

        				

        	 
        	  
        	

			/*
			 * // read the file File file = new File(filename); FileInputStream input = new
			 * FileInputStream(file);
			 * 
			 * // set parameters pstmt.setBinaryStream(1, input); pstmt.setInt(2,
			 * candidateId);
			 * 
			 * // store the resume file in database System.out.println("Reading file " +
			 * file.getAbsolutePath()); System.out.println("Store file in the database.");
			 * pstmt.executeUpdate();
			 */
            myConn.close(); 

        }catch(Exception e){ 
    		e.printStackTrace();
    		System.out.println(e);}
        
        finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
    }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        writeBlob(12, "sample1.pdf");

    }

}