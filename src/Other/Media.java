package Other;
public class Media extends libraryItem {
    private String type;
    private static int mediaCounter=1;
    public Media() {
        super();
        this.type="";
        this.ID="M"+mediaCounter;
        mediaCounter++;
    }

    public Media(String name, String authors, int yearOfPublication, String type) {
        super(name,authors,yearOfPublication);
        this.type=type;
        this.ID="M"+mediaCounter;
        mediaCounter++;
    }
    public Media(Media anotherMedia){
        super(anotherMedia);
        this.type=anotherMedia.type;
        this.ID="M"+mediaCounter;
        mediaCounter++;

    }
    public void setType(String type){
        this.type=type;
    }
    private String getType(){
        return this.type;
    }
    public String toString(){
        return super.toString()+"\nType: "+this.type;
    }
    public boolean equals(Media anotherMedia){
        return super.equals(anotherMedia)&&this.type== anotherMedia.type;
    }
}
