// Java program to demonstrate SQL Injection in JDBC
import java.sql.*;
import java.io.*;
class SQLInjectionExample {
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
        Statement stmt = con.createStatement();

        // Step - 4 execute the query
        String query = "select balance from bankbalance where username='"+uname+"' and password='"+pwd+"'";
        ResultSet res = stmt.executeQuery(query);
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