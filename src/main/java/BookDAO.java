//import java.awt.print.Book;
import org.springframework.beans.factory.annotation.Autowired;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by HasanMert on 14.11.2015.
 */
public class BookDAO {
    private  static Connection c;

    @Cacheable("booksCache")
    public static ArrayList<BookModel> getAllBooks() throws SQLException
    {
        PreparedStatement ps;
        ps = c.prepareCall("SELECT id, name, author, isbn, price FROM books");
        ps.execute();
        ResultSet rs = ps.getResultSet();
        ArrayList<BookModel> books = new ArrayList<BookModel>();
        while (rs.next())
        {
            BookModel b = new BookModel();
            b.setId(rs.getInt(1));
            b.setName(rs.getString(2));
            b.setAuthor(rs.getString(3));
            b.setISBN(rs.getInt(4));
            b.setPrice(rs.getFloat(6));
            books.add(b);
        }
        return books;
    }

    @CacheEvict(value = { "booksCache" }, allEntries = true)
    public static void addNewBook(BookModel b) throws SQLException{

        PreparedStatement preparedStatement = c.prepareStatement("INSERT INTO books(name, author, isbn, price)  VALUES (?,?,?,?)");
        preparedStatement.setString(1, b.getName());
        preparedStatement.setString(2, b.getAuthor());
        preparedStatement.setInt(3, b.getISBN());
        preparedStatement.setFloat(4, b.getPrice());

        preparedStatement.executeUpdate();
    }

    @Autowired
    private SessionFactory sessionFactory;

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


}
