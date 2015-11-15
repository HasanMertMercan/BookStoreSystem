/**
 * Created by HasanMert on 14.11.2015.
 */
public class BookModel {
    private int Id;
    private String Name;
    private String Author;
    private int ISBN;
    private float Price;

    public void setId(int id) {
        this.Id = id;
    }

    public int getId() {
        return Id;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return Name;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        this.Author = author;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        this.Price = price;
    }
}
