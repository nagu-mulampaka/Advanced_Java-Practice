// Java program to demonstrate the use of PreparedStatement in JDBC
import java.sql.*;
import java.io.*;
class PreparedStatementExample {
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
        String query = "insert into studentdetails values(?,?,?)";
        PreparedStatement stmt = con.prepareStatement(query);
        stmt.setInt(1,Integer.parseInt(id));
        stmt.setString(2, name);
        stmt.setString(3, course);

        // Step - 4 execute the query
        stmt.executeUpdate();

        // Step - 5 Close the Connection
        con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}