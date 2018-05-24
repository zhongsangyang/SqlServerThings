package adaptive;/*=====================================================================
File: 	 executeStoredProcedure.java
Summary: This Microsoft JDBC Driver for SQL Server sample application
         demonstrates how to retrieve a large OUT parameter from 
         a stored procedure and how to get the adaptive buffering mode.
---------------------------------------------------------------------
This file is part of the Microsoft JDBC Driver for SQL Server Code Samples.
Copyright (C) Microsoft Corporation.  All rights reserved.
 
This source code is intended only as a supplement to Microsoft
Development Tools and/or on-line documentation.  See these other
materials for detailed information regarding Microsoft code samples.
 
THIS CODE AND INFORMATION ARE PROVIDED "AS IS" WITHOUT WARRANTY OF
ANY KIND, EITHER EXPRESSED OR IMPLIED, INCLUDING BUT NOT LIMITED TO
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND/OR FITNESS FOR A
PARTICULAR PURPOSE.
=====================================================================*/

import java.sql.*;
import java.io.*;

import com.microsoft.sqlserver.jdbc.SQLServerCallableStatement;
import jdk.nashorn.internal.codegen.CompilerConstants;

public class executeStoredProcedure {

    public static void main(String[] args) {
        // Create a variable for the connection string.
        String url = "jdbc:sqlserver://127.0.0.1:1433;DatabaseName=testData";
        String connectionUrl =
                "jdbc:sqlserver://localhost:1433;" +
                        "databaseName=AdventureWorks;integratedSecurity=true;";
//        https://www.cnblogs.com/zyf/p/3575185.html integratedSecurity=true的讲解
        connectionUrl = url;

        // Declare the JDBC objects.
        Connection con = null;
        Statement stmt = null;
        ResultSet rs = null;
        String password = "zsy_5217079";
        String user = "sa";

        try {
            // Establish the connection.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//          con = DriverManager.getConnection(connectionUrl);
            con = DriverManager.getConnection(url, user, password);

            CallableStatement c= con.prepareCall("?={call CheckContactCity(?)}");
            c.setString("authorName","xyz");
            System.out.println(c.getInt("filed1"));

    } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
