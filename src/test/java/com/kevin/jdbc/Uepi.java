package com.kevin.jdbc;

import java.sql.*;

public class Uepi
{
//   static String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=eauatscn11.ea.vanderbilt.edu)(PORT=10922)))(CONNECT_DATA=(SID=MC39INT1)(SERVER=DEDICATED)))";
   // static String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=eauatscn11.ea.vanderbilt.edu)(PORT=10922)))(CONNECT_DATA=(SERVICE_NAME = MC39INT.vumc.vanderbilt)(SERVER=DEDICATED)))";
static String dbURL = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(ADDRESS=(PROTOCOL=TCP)(HOST=eauatscn11.ea.vanderbilt.edu)(PORT=10922)))(CONNECT_DATA=(SERVICE_NAME=MC39INT.vumc.vanderbilt)(SERVER=DEDICATED)))\n";
    static String username = "genservapp";
    static String password = "basket39i!";

    public static void main(String[] inArgs) throws SQLException
    {

        query();

    }

    private static Connection connect() throws SQLException
    {

        String username = "genservapp";
        String password = "basket39i!";
        Connection conn = DriverManager.getConnection(dbURL, username, password);
        System.out.println("CONNECTED");
        return conn;
    }


    private static void query() throws SQLException
    {
        Statement stmt = null;
        Connection conn = null;
        try
        {
            conn = connect();

            String sql = null;
            stmt = conn.createStatement();
            sql = "SELECT * FROM genservadm.epi";
          //  sql = "select * from dual";

            ResultSet rs = stmt.executeQuery(sql);

            //STEP 5: Extract data from result set
            while (rs.next())
            {
                //Retrieve by column name
                String first = rs.getString("FIRST_NAME");
                String last = rs.getString("LAST_NAME");
                System.out.print(", First: " + first);
                System.out.println(", Last: " + last);

            }
            //STEP 6: Clean-up environment
            rs.close();
            stmt.close();
            conn.close();
        }
        catch (
                SQLException se)

        {
            //Handle errors for JDBC
            se.printStackTrace();
        }
        catch (Exception e)

        {
            //Handle errors for Class.forName
            e.printStackTrace();
        }
        finally

        {
            //finally block used to close resources
            try
            {
                if (stmt != null)
                {
                    stmt.close();
                }
            }
            catch (SQLException se2)
            {
            }// nothing we can do
            try
            {
                if (conn != null)
                {
                    conn.close();
                }
            }
            catch (SQLException se)
            {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
    }//end main
}//end FirstExample
