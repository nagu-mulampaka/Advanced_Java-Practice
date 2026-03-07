import java.sql.*;
import java.io.*;
class JDBCDynamicQueriesExample {
    public static void main(String args[])
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "nagumca123";

        try {
        
        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(i);

        System.out.print("Please Enter Your Id Here: ");
        String id = b.readLine();

        System.out.print("Please Enter Your Name Here: ");
        String name = b.readLine();

        System.out.print("Please Enter Your Course Here: ");
        String course = b.readLine();

        // Step - 1 Register the Driver Manager
        Class.forName(driver);

        // Step - 2 Get the Connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Step - 3 Create statement Object
        Statement stmt = con.createStatement();

        // Step - 4 execute the query
        String query = "insert into studentdetails values("+id+",'"+name+"','"+course+"')";
        stmt.executeUpdate(query);
        System.out.println("Data Inserted Successfully...");

        // Step - 5 Close the Connection
        con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}