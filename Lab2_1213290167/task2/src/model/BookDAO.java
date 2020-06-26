package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class BookDAO {
    private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;

    public BookDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }

    protected void connect() throws SQLException {
        if (jdbcConnection == null || jdbcConnection.isClosed()) {
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException e) {
                throw new SQLException(e);
            }
            jdbcConnection = DriverManager.getConnection(
                    jdbcURL, jdbcUsername, jdbcPassword);
        }
    }

    protected void disconnect() throws SQLException {
        if (jdbcConnection != null && !jdbcConnection.isClosed()) {
            jdbcConnection.close();
        }
    }

    public boolean insertBook(PhoneEntry book) throws SQLException {
        String sql = "INSERT INTO PhoneEntry (phonenumber, firstname, lastname) VALUES (?, ?, ?)";
        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getPhone());
        statement.setString(2, book.getFirstname());
        statement.setString(3, book.getLastname());

        boolean rowInserted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowInserted;
    }

    public List<PhoneEntry> listAllBooks() throws SQLException {
        List<PhoneEntry> listBook = new ArrayList<>();

        String sql = "SELECT * FROM PhoneEntry";

        connect();

        Statement statement = jdbcConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            String id = resultSet.getString("phonenumber");
            String title = resultSet.getString("firstname");
            String author = resultSet.getString("lastname");
//            float price = resultSet.getFloat("price");

            PhoneEntry book = new PhoneEntry(id,title,author);
            listBook.add(book);
        }

        resultSet.close();
        statement.close();

        disconnect();

        return listBook;
    }

    public boolean deleteBook(PhoneEntry book) throws SQLException {
        String sql = "DELETE FROM PhoneEntry where phonenumber = ?";

        connect();

        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
        statement.setString(1, book.getPhone());

        boolean rowDeleted = statement.executeUpdate() > 0;
        statement.close();
        disconnect();
        return rowDeleted;
    }

//    public boolean updateBook(PhoneEntry book) throws SQLException {
//        String sql = "UPDATE book SET title = ?, author = ?, price = ?";
//        sql += " WHERE book_id = ?";
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setString(1, book.getFirstname());
//        statement.setString(2, book.getLastname());
////        statement.setFloat(3, book.getPrice());
//        statement.setString(4, book.getPhone());
//
//        boolean rowUpdated = statement.executeUpdate() > 0;
//        statement.close();
//        disconnect();
//        return rowUpdated;
//    }

//    public PhoneEntry getBook(int id) throws SQLException {
//        PhoneEntry book = null;
//        String sql = "SELECT * FROM book WHERE book_id = ?";
//
//        connect();
//
//        PreparedStatement statement = jdbcConnection.prepareStatement(sql);
//        statement.setInt(1, id);
//
//        ResultSet resultSet = statement.executeQuery();
//
//        if (resultSet.next()) {
//            String title = resultSet.getString("firstname");
//            String author = resultSet.getString("lastname");
//            String price = resultSet.getString("phonenumber");
//
//            book = new PhoneEntry();
//        }
//
//        resultSet.close();
//        statement.close();
//
//        return book;
//    }
}
