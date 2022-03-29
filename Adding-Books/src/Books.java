
import java.io.Serializable;


public class Books implements Serializable{ // We implement Serializable because we use oos, fis and oos, fos
    
    private String authorName;
    private int pages;
    private String bookCode;
    private String bookName;
    
    public Books(String authorName, int pages, String bookCode, String bookName) {
        this.authorName = authorName;
        this.pages = pages;
        this.bookCode = bookCode;
        this.bookName = bookName;
    
    }

    public Books() {
    }

    
    public String getAuthorName() {
        return authorName;
    }

    
    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    
    public int getPages() {
        return pages;
    }

    
    public void setPages(int pages) {
        this.pages = pages;
    }

    
    public String getBookCode() {
        return bookCode;
    }

    
    public void setBookCode(String bookCode) {
        this.bookCode = bookCode;
    }

    
    public String getBookName() {
        return bookName;
    }

   
    public void setBookName(String bookCode) {
        this.bookName = bookCode;
    }
    
    public void display() {
        System.out.println("Author Name: " + this.getAuthorName());
        System.out.println("Book Name: " + this.getBookName());
        System.out.println("Pages: " + this.getPages());
        System.out.println("Book Code: " + this.getBookCode());
    }
    
    public void setValues(String authorName, int pages, String bookCode, String bookName){
        this.authorName = authorName;
        this.pages = pages;
        this.bookCode = bookCode;
        this.bookName = bookName;
    }
    
}
    

