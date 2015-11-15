import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by HasanMert on 15.11.2015.
 */
public class BookDAOTest extends TestCase {

    @Test
    public void testGetAllBooks() throws Exception {
        ArrayList<BookModel> list = BookDAO.getAllBooks();
    }

    @Test
    public void testAddNewBook() throws Exception {
        BookModel model = new BookModel();
        model.setName("Beşiktaş");
        model.setAuthor("Baba Hakkı");
        model.setISBN(1903);
        model.setPrice((float) 19.03);
        BookDAO.addNewBook(model);
    }
}