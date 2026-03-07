// Java program demonstrating the use of CallableStatement
import java.sql.*;
import java.io.*;
class CallableStatementExample {
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
        int studentId = Integer.parseInt(b.readLine());

        // Step - 1 Register the Driver Manager
        Class.forName(driver);

        // Step - 2 Get the Connection
        Connection con = DriverManager.getConnection(url, username, password);

        // Step - 3 Create statement Object
        // calling getusername procedure
        CallableStatement stmt = con.prepareCall("{call getusername(?)}");
        stmt.setInt(1, studentId);

        // Step - 4 execute the query
        ResultSet res = stmt.executeQuery();
        if(res.next()) 
        {
            System.out.println("Name of the student with id "+studentId+ " is: "+res.getString(1));
        }
        else {
            System.out.println("sorry Id is not found please try with valid id");
        }

        // calling insert data procedure
        CallableStatement stmt2 = con.prepareCall("{call insertdata()}");
        stmt2.executeUpdate();
        
        // Step - 5 Close the Connection
        con.close();
        }
        catch(Exception e){System.out.println(e);}
    }
}