package Other;
public class Book extends libraryItem {
    private int numberOfPages;
    private static int bookCounter=1;
    public Book() {
        super();
        this.numberOfPages=0;
        this.ID="B"+bookCounter;
        bookCounter++;
    }
    public Book(String name, String authors, int yearOfPublication, int numberOfPages) {
        super(name,authors,yearOfPublication);
        this.numberOfPages=numberOfPages;
        this.ID="B"+bookCounter;
        bookCounter++;
    }
    public Book(Book anotherBook){
        super(anotherBook);
        this.numberOfPages=anotherBook.numberOfPages;
        this.ID="B"+bookCounter;
        bookCounter++;
    }
    public void setNumberOfPages(int numberOfPages){
        this.numberOfPages=numberOfPages;
    }
    public int getNumberOfPages(){
        return this.numberOfPages;
    }
    public String toString(){
        return super.toString()+"\nNumber of pages: "+this.numberOfPages;
    }
    public boolean equals(Book anotherBook){
        return super.equals(anotherBook)&&this.numberOfPages== anotherBook.numberOfPages;
    }
}

