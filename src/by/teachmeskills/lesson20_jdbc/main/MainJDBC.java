package by.teachmeskills.lesson20_jdbc.main;

import by.teachmeskills.lesson18_xml_json.stax.entity.Book;
import by.teachmeskills.lesson18_xml_json.stax.util.StAXBookParser;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;

public class MainJDBC {

  public static void main(String[] args) throws SQLException, FileNotFoundException {
    StAXBookParser.parse();
    List<Book> list = StAXBookParser.getList();

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      try(Connection con = getConnection()) {
        System.out.println("Connection successful");

        Statement st1 = con.createStatement();
        //st1.executeUpdate("TRUNCATE TABLE books");
        st1.executeUpdate("DELETE from books where id>0");
        st1.executeUpdate("ALTER TABLE books AUTO_INCREMENT=1");

        String sql = "INSERT INTO books(title,year,genre,author) VALUES(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        for (int i = 0; i < list.size(); i++) {
          //ps.setInt(1,i);
          ps.setString(1, list.get(i).getTitle());
          ps.setInt(2, list.get(i).getYear());
          ps.setString(3, list.get(i).getGenre());
          ps.setString(4, list.get(i).getAuthor());
          ps.executeUpdate();
        }

        Statement st = con.createStatement();
        ResultSet rSelect = st.executeQuery("SELECT * from books");
        while(rSelect.next()) {
          System.out.println(rSelect.getString(2) + " " + rSelect.getString(3) + " " + rSelect.getString(4));
        }
      }
    }
   catch(Exception ex) {
     System.out.println("Connection failed");
     System.out.println(ex);
   }
  }

  public static Connection getConnection() throws SQLException, IOException {
    Properties props = new Properties();
    try(InputStream in = Files.newInputStream(Paths.get("src/by/teachmeskills/lesson20_jdbc/main/database.properties"));) {
      props.load(in);
    }
    String url = props.getProperty("url");
    String username = props.getProperty("username");
    String password = props.getProperty("password");

    return DriverManager.getConnection(url,username,password);
  }

}
