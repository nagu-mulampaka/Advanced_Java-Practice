// program to demonstrate JDBC in Java
// classpath: set classpath=%classpath%;mysql-connector-j-8.1.0.jar\;
import java.sql.*;
class JDBCExampleProgram {
    public static void main(String args[]) 
    { 
       String driver = "com.mysql.cj.jdbc.Driver";
       String url = "jdbc:mysql://localhost:3306/school";
       String username = "root";
       String password = "nagumca123";
       
       try {
       //step - 1 : Register the Driver
       Class.forName(driver);

       //step - 2 : get the connection
       Connection con = DriverManager.getConnection(url, username, password);

       //step - 3 : create the statement object
       Statement stmt = con.createStatement();
       
       //step - 4 : execute queries
       stmt.executeUpdate("insert into studentdetails values(10, 'Nagu Mulampaka', 'Java Full Stack Development')");
       stmt.executeUpdate("insert into studentdetails values(11, 'Kotni Prathibha Sai', 'Java Full Stack Development')");
       stmt.executeUpdate("insert into studentdetails values(12, 'Ashok Kumar', 'Java Full Stack Development')");

       //step - 5 : close the connection
       con.close();
       }
       catch(Exception e) {System.out.println(e);}
    }
}