package com.example.webproject.testdb;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet(name = "TestDb", value = "/TestDb")
public class TestDb extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String user = "root";
        String pass = "admin";
        String url = "jdbc:mysql://localhost:3306";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection myCon = null;

        try{

            PrintWriter out = response.getWriter();
            out.println("Connecting to " + url);
            Class.forName(driver);
            myCon = DriverManager.getConnection(url, user, pass);
            out.println("Connection succeed ");
            myCon.close();
        } catch (Exception e) {
            System.out.println(e);
            try {
                myCon.close();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

}
