package by.teachmeskills.lesson18_jdbc.main;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class MainJDBC {

  public static void main(String[] args) throws SQLException {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
      try(Connection con = getConnection()) {
        System.out.println("Connection successful");
        String sql = "INSERT INTO books(title,year,genre,author) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, "The Little Prince");
        ps.setString(2, "1943");
        ps.setString(3, "Novella");
        ps.setString(4, "Antoine de Saint-Exupery");

        ps.executeUpdate();

        System.out.println("!!!");
      }
    }
   catch(Exception ex) {
     System.out.println("Connection failed");
     System.out.println(ex);
   }
  }

  public static Connection getConnection() throws SQLException, IOException {
    Properties props = new Properties();
    try(InputStream in = Files.newInputStream(Paths.get("src/by/teachmeskills/lesson18_jdbc/main/database.properties"));) {
      props.load(in);
    }
    String url = props.getProperty("url");
    String username = props.getProperty("username");
    String password = props.getProperty("password");

    return DriverManager.getConnection(url,username,password);
  }

}
