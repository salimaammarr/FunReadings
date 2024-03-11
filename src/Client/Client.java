package Client;
public class Client {
    private String ID;
    private String name;
    private long phoneNumber;
    private String emailAddress;
    public String[] items;
    private int clientCounter=1;
    public Client(){
        this.name="";
        this.phoneNumber=0;
        this.emailAddress="";
        this.items=new String[0];
        this.ID="C"+clientCounter;
        clientCounter++;
    }
    public Client(String name,long phoneNumber,String emailAddress,int maxSize){
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.emailAddress=emailAddress;
        this.items=new String[maxSize];
        this.ID="C"+clientCounter;
        clientCounter++;
    }
    public Client(Client anotherClient){
        this.name=anotherClient.name;
        this.phoneNumber=anotherClient.phoneNumber;
        this.emailAddress=anotherClient.emailAddress;
        this.items=anotherClient.items;
        this.ID="C"+clientCounter;
        clientCounter++;
    }
    public String getClientID(){
        return this.ID;
    }
    private String getClientName(){
        return this.name;
    }
    private long getPhoneNumber(){
        return this.phoneNumber;
    }
    private String[] getItems(){
        return items;
    }
    private String getEmailAddress(){
        return this.emailAddress;
    }
    public void setName(String name){
        this.name=name;
    }
    public void setPhoneNumber(long phoneNumber){
        this.phoneNumber=phoneNumber;
    }
    public void setEmailAddress(String emailAddress){
        this.emailAddress=emailAddress;
    }
    public void setMaxSize(int maxSize){
        String[] itemsCopy=new String[maxSize];
        for(int i=0;i< items.length;i++){
            itemsCopy[i]=items[i];
        }
        items=itemsCopy;
    }
    public String toString(){
        return ("ID: "+this.ID+"\nName: "+this.name+"\nPhone number:"+
                this.phoneNumber+"\nEmail address: "+this.emailAddress);
    }
    public boolean equals(Client anotherClient){
        if(this.getClass()!=anotherClient.getClass()){
            return false;
        }
        else{
            return this.name == anotherClient.name && this.phoneNumber == anotherClient.phoneNumber && this.emailAddress == anotherClient.emailAddress;
        }
    }

}
