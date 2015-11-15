import java.sql.SQLException;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class BookController {

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/list")
    public ModelAndView getBooks(){
        ModelAndView mav = new ModelAndView("books");
        HttpSession session = null;
        try {
            ArrayList<BookModel> list = BookDAO.getAllBooks();
            mav.addObject("books", list);
            session.setAttribute("books", list);

        } catch (SQLException e) {
            //e.printStackTrace();
        }

        return mav;
    }

    @RequestMapping("/addBook")
    public ModelAndView addBook(@RequestParam("name") String name,
                                @RequestParam("author") String author,
                                @RequestParam("isbn") int isbn,
                                @RequestParam("price") float price) throws SQLException {
        ModelAndView mav = new ModelAndView("addBook");
        name = name.trim();
        author = author.trim();
        if(name != null && name != "" && author != null && author != "" && isbn > 0 && price > 0)
        {
            BookModel book = new BookModel();
            book.setPrice(price);
            book.setISBN(isbn);
            book.setName(name);
            book.setAuthor(author);

            try {
                List<BookModel> books = BookDAO.getAllBooks();
                if(books.contains(book) == false)
                {
                    BookDAO.addNewBook(book);
                    mav.addObject("message", "Book added successfully!");
                }
            } catch (SQLException e) {
                //e.printStackTrace();
            }
        }
        else
        {
            mav.addObject("message", "Please fill the form!");
        }


        return mav;
    }

}
