// program to demonstrate Retrive Data from the Database using JDBC
import java.sql.*;
class JDBCRetriveDataExample {
    public static void main(String args[])
    {
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "nagumca123";

        try {
        // Step - 1 Register the Driver Manager
        Class.forName(driver);

        // Step - 2 Get the Connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Step - 3 Create statement Object
        Statement stmt = con.createStatement();

        // Step - 4 execute the query
        ResultSet results = stmt.executeQuery("select * from studentdetails");
        while(results.next())
        {
            System.out.print(results.getInt(1)+"\t"+results.getString(2));
            System.out.println();
        }

        // Step - 5 Close the Connection
        con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}