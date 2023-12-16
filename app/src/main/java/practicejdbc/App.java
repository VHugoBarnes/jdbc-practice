package practicejdbc;

import java.sql.*;

public class App {
  public static void main(String[] args) {
    Connection myConn = null;
    PreparedStatement myStatement = null;

    try {
      myConn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/project", "root", "");

      String sql = ("INSERT INTO employees (name) VALUES(?)");
      myStatement = myConn.prepareStatement(sql);
      myStatement.setString(1, "Keko");

      int rowsAffected = myStatement.executeUpdate();

      if(rowsAffected > 0) {
        System.out.println("A employee has been created");
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("Something went wrong");
    }
  }
}
