package Other;
public class Journal extends libraryItem{
    protected int volumeNumber;
    private static int journalCount=1;
    public Journal(){
        super();
        this.volumeNumber=0;
        this.ID="J"+journalCount;
        journalCount++;
    }
    public Journal(String name, String authors, int yearOfPublication,int volumeNumber){
        super(name,authors,yearOfPublication);
        this.volumeNumber=0;
        this.ID="J"+journalCount;
        journalCount++;
    }
    public Journal(Journal anotherJournal){
        super(anotherJournal);
        this.volumeNumber= anotherJournal.volumeNumber;
        this.ID="J"+journalCount;
        journalCount++;
    }
    public void setVolumeNumber(int volumeNumber){
        this.volumeNumber=volumeNumber;
    }
    private int getVolumeNumber(){
        return this.volumeNumber;
    }
    public String toString(){
        return super.toString()+"\nVolume number: "+this.volumeNumber;
    }
    public boolean equals(Journal anotherJournal){
        return super.equals(anotherJournal)&&this.volumeNumber== anotherJournal.volumeNumber;
    }
}
