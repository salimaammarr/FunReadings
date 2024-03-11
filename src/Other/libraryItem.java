package Other;
public class libraryItem {
    protected String ID;
    private String name;
    private String author;
    private int yearOfPublication;
    public libraryItem(){
        this.ID="";
        this.name="";
        this.author="";
        this.yearOfPublication=0;
    }
    public libraryItem(String name, String author, int yearOfPublication){
        this.author=author;
        this.name=name;
        this.yearOfPublication=yearOfPublication;
    }
    public libraryItem(libraryItem otherLibraryItem){
        this.name= otherLibraryItem.name;
        this.author= otherLibraryItem.author;;
        this.yearOfPublication=otherLibraryItem.yearOfPublication;
    }
    public String getID(){
        return this.ID;
    }
    public void setName(String name){
        this.name=name;
    }
    protected String getName(){
        return this.name;
    }
    //check if authors should be arraylist/array
    public void setAuthor(String authors){
        this.author=author;
    }
    protected String getAuthor(){
        return this.author;
    }
    public void setYearOfPublication(int yearOfPublication){
        this.yearOfPublication=yearOfPublication;
    }
    protected int getYearOfPublication(){
        return this.yearOfPublication;
    }
    public String toString() {
        return "ID: " + this.ID + "\nName: " + this.name + "\nAuthors: " + this.author + "" +
                "\nYear of publication: " + this.yearOfPublication;
    }
    public boolean equals(libraryItem anotherItem){
        if(this.getClass()!=anotherItem.getClass()){
            return false;
        }
        else{
        return this.name == anotherItem.name && this.author == anotherItem.author && this.yearOfPublication == anotherItem.yearOfPublication;
        }
    }

}
