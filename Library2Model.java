/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;




import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Book;



public class Library2Model {

    private Connection con;
    
    private String user = "lurker";
    private String pwd = "321";
    private String database = "library";
    
    private ArrayList<Book> booklist;
    private Book book;
    private String server = "jdbc:mysql://localhost:3306/" + database +
        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    
    
    
    public Library2Model() {
        Connection con = null;
        booklist = new ArrayList<Book>();
       
    }
    
    public Connection getCon(){
        return this.con;
    }
    
    public String getUsername(){
        return this.user;
    }
    
    public String getPassword(){
        return this.pwd;
    }
    
    public String getDatabase(){
        return this.database;
    }
    
    public String getServer(){
        return this.server;
    }
    
    public ArrayList<Book> getBooks(){
        
        return this.booklist;
    }
    
    public void testBooks(){
        
        
        for(Book book : booklist){
            System.out.println(book);
            
        }
    }
    
    public void tryToConnect(String username, String password) throws Exception{
        /*if (args.length != 2) {
            System.out.println("Usage: java JDBCTest <user> <password>");
            System.exit(0);
        }*/

        //String user = args[0]; // user name
        //String pwd = args[1]; // password 
        this.user = username;
        this.pwd = password;
        System.out.println(user + ", *********");
        this.database = "library"; // the name of the specific database 
        this.server
                = "jdbc:mysql://localhost:3306/" + database
                + "?UseClientEnc=UTF8";
        //actually this but ok lol
        server = "jdbc:mysql://localhost:3306/" + database +
        "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

        Connection con = null;
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(server, user, pwd);
            System.out.println("Connected!");
            

            //executeQuery(con, "SELECT * FROM Book");
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
            }
        }
    }
    
    public void tryToCloseConnection(){
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection Terminanted!");
                }
            } catch (SQLException e) {
            }
    }

    // WRONG!!!!!!!!!
   /* public void executeQuery1(String pass, String uname,
            String db,String query) throws SQLException {
        
        
         try {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(server, uname, pass);
            System.out.println("Connected!");
        
            try (Statement stmt = con.createStatement()) {
                // Execute the SQL statement
                ResultSet rs = stmt.executeQuery(query);

                // Get the attribute names
                ResultSetMetaData metaData = rs.getMetaData();
                int ccount = metaData.getColumnCount();
                
              
                for (int c = 1; c <= ccount; c++) {
                    System.out.print(metaData.getColumnName(c) + "\t");
                    
                }
                System.out.println();
                this.booklist.clear();
                // Get the attribute values
                while (rs.next()) {
                    // NB! This is an example, -not- the preferred way to retrieve data.
                    // You should use methods that return a specific data type, like
                    // rs.getInt(), rs.getString() or such.
                    // It's also advisable to store each tuple (row) in an object of
                    // custom type (e.g. Employee).
                    ArrayList<String> tmpBookList = new ArrayList<String>();
                    ArrayList<Author> tmpAuthorList = new ArrayList<Author>();
                    for (int c = 1; c <= ccount; c++) {
                        tmpBookList.add(rs.getString(c));
                        
                        
                        System.out.print(rs.getObject(c) + "\t");
                       
                    }
                    
                    Book.Genre bookGenre = Book.Genre.valueOf(tmpBookList.get(1));
                    tmpAuthorList.add(new Author(rs.getString(5)));
                    //System.out.print("fag" + tmpAuthorList.toString());
                    
                    try{
                        book = new Book(tmpBookList.get(0),bookGenre,tmpBookList.get(2),
                        tmpBookList.get(3),tmpAuthorList);
                        
                        if(book == null){
                            throw new Exception("Book was dead");
                        }
                        this.booklist.add(book);
                        book = null;
                    }catch(IllegalArgumentException ile){
                        System.out.println(ile.getMessage());
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                }   
                stmt.close();
            }    
            
            
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
            }
        }
    }*/
    
    public void executeQuery2(String query) throws SQLException {
        
        
         try {
            
            //Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(server, this.user, this.pwd);
            System.out.println("Connected!");
        
            try (Statement stmt = con.createStatement()) {
                // Execute the SQL statement
                ResultSet rs = stmt.executeQuery(query);

                // Get the attribute names
                ResultSetMetaData metaData = rs.getMetaData();
                int ccount = metaData.getColumnCount();
                
              
                for (int c = 1; c <= ccount; c++) {
                    System.out.print(metaData.getColumnName(c) + "\t");
                    
                }
                System.out.println();
                this.booklist.clear();
                // Get the attribute values
                while (rs.next()) {
                    // NB! This is an example, -not- the preferred way to retrieve data.
                    // You should use methods that return a specific data type, like
                    // rs.getInt(), rs.getString() or such.
                    // It's also advisable to store each tuple (row) in an object of
                    // custom type (e.g. Employee).
                    ArrayList<String> tmpBookList = new ArrayList<String>();
                    ArrayList<Author> tmpAuthorList = new ArrayList<Author>();
                    for (int c = 1; c <= ccount; c++) {
                        tmpBookList.add(rs.getString(c));
                        
                        
                        System.out.print(rs.getObject(c) + "\t");
                       
                    }
                        
                    Book.Genre bookGenre = Book.Genre.valueOf(tmpBookList.get(1));
                    tmpAuthorList.add(new Author(rs.getString(5)));
                    //System.out.print("fag" + tmpAuthorList.toString());
                    //System.out.print(bookGenre);
                    
                    try{
                        book = new Book(tmpBookList.get(0),bookGenre,tmpBookList.get(2),
                        tmpBookList.get(3),tmpAuthorList);
                        
                        if(book == null){
                            throw new Exception("Book was dead");
                        }
                        this.booklist.add(book);
                        book = null;
                    }catch(IllegalArgumentException ile){
                        System.out.println(ile.getMessage());
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }

                    System.out.println();
                }   
                stmt.close();
            }    
            
            
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection closed.");
                }
            } catch (SQLException e) {
            }
        }
    } 
  
        
      
    
}