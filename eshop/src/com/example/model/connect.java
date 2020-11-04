/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import java.sql.*;

/**
 *
 * @author Eleftheria
 */
public class connect {
    private static Connection con;
    
    public static Connection getCon(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/connect","root","portaria");
            
        }catch(ClassNotFoundException | SQLException e){
            e.printStackTrace();
        }
        return con;
    }

    connect(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

