// Java program to demonstrate prevention of SQL Injection using PreparedStatement in JDBC
import java.sql.*;
import java.io.*;
class SQLinjctionPreparedStatementEx {
    public static void main(String args[])
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/banks";
        String username = "root";
        String password = "nagumca123";

        try {
        
        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(i);

        System.out.print("Please Enter Your username: ");
        String uname = b.readLine();

        System.out.print("Please Enter Your password: ");
        String pwd = b.readLine();


        // Step - 1 Register the Driver Manager
        Class.forName(driver);

        // Step - 2 Get the Connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Step - 3 Create statement Object
        String query = "select balance from bankbalance where username=? and password=?";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setString(1, uname);
        stmt.setString(2, pwd);

        // Step - 4 execute the query
        ResultSet res = stmt.executeQuery();
        System.out.println(query);
        if(res.next()){
            System.out.println("Balance is: "+res.getDouble(1));
        }
        else {
            System.out.println("Invalid Credentials");
        }

        // Step - 5 Close the Connection
        con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}