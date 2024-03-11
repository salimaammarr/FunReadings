package Driver;

import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;
import Other.* ;
import Client.Client;
//--------------------------------------------------------
// Assignment 1
// Written by: Salima Ammar 40283429
//--------------------------------------------------------

/*this program manages the items in the library (journals, books, media) and the leases and returns from clients. It also manages the clients. It has a predefined scenario and a menu to interact with the user. It also has a method to get the biggest book and to copy the books array.*/

public class Driver {
    public static void main(String args[]){
        System.out.println("Welcome to FunReadings Library Management System!");
        System.out.println("Do you want to run a predefined scenario? (yes/no)");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine().toLowerCase();
        if (choice.equals("yes")) {
            runPredefinedScenario();
        } else if (choice.equals("no")) {
            runMenu();
        } else {
            System.out.println("Invalid choice. Exiting.");
        }
        scanner.close();
    }
    private static void runPredefinedScenario() {
        Journal[] journals=new Journal[3];
        Book[] books=new Book[3];
        Media[] medias=new Media[3];
        Client[] clients=new Client[3];
        journals[0]=new Journal();
        journals[1]=new Journal("Nyt","autor1",2003,13);
        journals[2]=new Journal("Nyt","autor1",2003,13);
        books[0]=new Book("Deep work","Cal Newport",2016,228);
        books[1]=new Book("Germinal","Zola",1885,591);
        books[2]=new Book("L'Étranger","Camus",1949,159);
        medias[0]=new Media("Questions on My Mind","Faraj Suleiman",2020,"Song");
        medias[1]=new Media("My Neighbor Totoro","Hayao Miyazaki",1988,"animated film");
        medias[2]=new Media("The Scream","Edvard Munch",1893,"painting");
        clients[0]=new Client();
        clients[1]=new Client("Alex",1111111111,"noemail@noemail.com",34);
        clients[2]=new Client("Alex",1111111111,"noemail@noemail.com",34);
        System.out.println(books[0].toString());
        System.out.println(books[1].toString());
        System.out.println(books[2].toString());
        System.out.println(journals[0].toString());
        System.out.println(journals[1].toString());
        System.out.println(journals[2].toString());
        System.out.println(medias[0].toString());
        System.out.println(medias[1].toString());
        System.out.println(medias[2].toString());
        System.out.println(clients[0].toString());
        System.out.println(clients[1].toString());
        System.out.println(clients[2].toString());
        System.out.println(clients[1].equals(clients[2]));
        System.out.println(medias[1].equals(clients[2]));
        System.out.println(medias[1].equals(medias[2]));
        libraryItem[] library=new libraryItem[3];
        library[0]=books[0];
        library[1]=journals[0];
        library[2]=medias[0];
        getBiggestBook(books);
        copyBooks(books);
    }
    private static void runMenu(){
        String IDletter;
        int IDnumber;
        String clientID;
        int clientPos;
        boolean foundClient;
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        Book[] books=new Book[10];
        Journal[] journals=new Journal[10];
        Media[] medias=new Media[10];
        Client[] clients=new Client[10];
        while (!exit) {
            System.out.print("Welcome to FunrRadings Library! Please select an option:" +
                    "\n1. Add an item" +
                    "\n2. Delete an item" +
                    "\n3. Change information of an item" +
                    "\n4. List all items in a specific category" +
                    "\n5. Print all items" +
                    "\n6. Add a client" +
                    "\n7. Edit a client" +
                    "\n8. Delete a client" +
                    "\n9. Lease an item to a client" +
                    "\n10. Return an item from a client" +
                    "\n11. Show all items leased by a client" +
                    "\n12. Show all leased items" +
                    "\n13. Display the biggest book" +
                    "\n14. Make a copy of the books array");
            int menuChoice = scanner.nextInt();
            scanner.nextLine();
            switch (menuChoice) {
                case 1:
                    System.out.print("Would you like to enter:" +
                            "\n1. A book" +
                            "\n2. A journal" +
                            "\n3. Media");
                    int itemTypeChoice = scanner.nextInt();
                    if (itemTypeChoice == 1) {
                        System.out.println("Please enter the information of the book in the following order (leave spaces between the attributes): Name Authors Year of Publication Number of Pages");
                        String name = scanner.next();
                        String authors = scanner.next();
                        int yearOfPublication = scanner.nextInt();
                        int numberOfPages = scanner.nextInt();
                        for (int i = 0; i < books.length; i++) {
                            if (books[i] == null) {
                                books[i] = new Book(name, authors, yearOfPublication, numberOfPages);
                                break;
                            }
                        }
                    } else if (itemTypeChoice == 2) {
                        System.out.println("Please enter the information of the journal in the following order (leave spaces between the attributes): Name Authors Year of Publication Volume number");
                        String name = scanner.next();
                        String authors = scanner.next();
                        int yearOfPublication = scanner.nextInt();
                        int volumeNumber = scanner.nextInt();
                        for (int i = 0; i < journals.length; i++) {
                            if (journals[i] == null) {
                                journals[i] = new Journal(name, authors, yearOfPublication, volumeNumber);
                                break;
                            }
                        }
                    } else if (itemTypeChoice == 3) {
                        System.out.println("Please enter the information of the media in the following order (leave spaces between the attributes): Name Authors Year of Publication Type");
                        String name = scanner.next();
                        String authors = scanner.next();
                        int yearOfPublication = scanner.nextInt();
                        String type = scanner.next();
                        for (int i = 0; i < medias.length; i++) {
                            if (medias[i] == null) {
                                medias[i] = new Media(name, authors, yearOfPublication, type);
                                break;
                            }
                        }
                    }
                    break;
                case 2:
                    System.out.println("Enter item ID to delete: ");
                    IDletter = scanner.next();
                    IDnumber = scanner.nextInt();
                    if (IDletter.equalsIgnoreCase("B")) {
                        Book[] copy = new Book[books.length];
                        if(books[IDnumber]!=null){
                            for (int i = 0; i < books.length; i++) {
                                if (books[i]!=null&&i!= IDnumber) {
                                    copy[i] = books[i];
                                }
                            }
                            books = copy;
                            System.out.println("The book has been deleted successfully!");
                        }
                        else{
                            System.out.println("The book does not exist!");
                        }
                        break;
                    }
                    if (IDletter.equalsIgnoreCase("J")) {
                        Journal[] copy = new Journal[journals.length];
                        if(books[IDnumber]!=null){
                            for (int i = 0; i < journals.length; i++) {
                                if (journals[i]!=null&&i != IDnumber) {
                                    copy[i] = journals[i];
                                }
                            }
                            journals = copy;
                            System.out.println("The journal has been deleted successfully!");
                        }
                        else{
                            System.out.println("The journal does not exist!");
                        }
                        break;
                    }
                    if (IDletter.equalsIgnoreCase("M")) {
                        if(medias[IDnumber]!=null){
                            Media[] copy = new Media[medias.length];
                            for (int i = 0; i < medias.length; i++) {
                                if (medias[i]!=null&&i != IDnumber) {
                                    copy[i] = medias[i];
                                }
                            }
                            medias = copy;
                            System.out.println("The media has been deleted successfully!");
                        }
                        else{
                            System.out.println("The media does not exist!");
                        }
                        break;
                    }
                case 3:
                    System.out.println("Enter item ID to change: ");
                    IDletter = scanner.next();
                    IDnumber = scanner.nextInt();
                    if (IDletter.equals("B")) {
                        System.out.print("Do you want to change:" +
                                "\n1. The name" +
                                "\n2. The authors" +
                                "\n3. The year of publication" +
                                "\n4. The number of pages");
                        int changeBChoice = scanner.nextInt();
                        switch (changeBChoice) {
                            case 1:
                                System.out.print("Enter the new info: ");
                                String newName = scanner.next();
                                books[IDnumber].setName(newName);
                                break;
                            case 2:
                                System.out.print("Enter the new info: ");
                                String newAuthor = scanner.next();
                                books[IDnumber].setAuthor(newAuthor);
                                break;
                            case 3:
                                System.out.print("Enter the new info: ");
                                int newYear = scanner.nextInt();
                                books[IDnumber].setYearOfPublication(newYear);
                                break;
                            case 4:
                                System.out.print("Enter the new info: ");
                                int newNumberOfPages = scanner.nextInt();
                                books[IDnumber].setNumberOfPages(newNumberOfPages);
                                break;
                        }
                    } else if (IDletter.equals("J")) {
                        System.out.print("Do you want to change:" +
                                "\n1. The name" +
                                "\n2. The authors" +
                                "\n3. The year of publication" +
                                "\n4. The volume number");
                        int changeJChoice = scanner.nextInt();
                        switch (changeJChoice) {
                            case 1:
                                System.out.print("Enter the new info: ");
                                String newName = scanner.next();
                                journals[IDnumber].setName(newName);
                                break;
                            case 2:
                                System.out.print("Enter the new info: ");
                                String newAuthor = scanner.next();
                                journals[IDnumber].setAuthor(newAuthor);
                                break;
                            case 3:
                                System.out.print("Enter the new info: ");
                                int newYear = scanner.nextInt();
                                journals[IDnumber].setYearOfPublication(newYear);
                                break;
                            case 4:
                                System.out.print("Enter the new info: ");
                                int newVolumeNumber = scanner.nextInt();
                                journals[IDnumber].setVolumeNumber(newVolumeNumber);
                                break;
                        }
                    } else if (IDletter.equals("M")) {
                        System.out.print("Do you want to change:" +
                                "\n1. The name" +
                                "\n2. The authors" +
                                "\n3. The year of publication" +
                                "\n4. The volume number");
                        int changeMChoice = scanner.nextInt();
                        switch (changeMChoice) {
                            case 1:
                                System.out.print("Enter the new info: ");
                                String newName = scanner.next();
                                medias[IDnumber].setName(newName);
                                break;
                            case 2:
                                System.out.print("Enter the new info: ");
                                String newAuthor = scanner.next();
                                medias[IDnumber].setAuthor(newAuthor);
                                break;
                            case 3:
                                System.out.print("Enter the new info: ");
                                int newYear = scanner.nextInt();
                                medias[IDnumber].setYearOfPublication(newYear);
                                break;
                            case 4:
                                System.out.print("Enter the new info: ");
                                String newType = scanner.next();
                                medias[IDnumber].setType(newType);
                                break;
                        }
                    }
                    break;
                case 4:
                    System.out.print("Select the category: " +
                            "\n1. Book" +
                            "\n2. Journal" +
                            "\n3. Media");
                    int listChoice = scanner.nextInt();
                    switch (listChoice) {
                        case 1:
                            for(int i = 0; i < books.length; i++) {
                                System.out.println(books[i].toString());
                            }
                            break;
                        case 2:
                            for(int i = 0; i < journals.length; i++) {
                                System.out.println(journals[i].toString());
                            }
                            break;
                        case 3:
                            for(int i = 0; i < medias.length; i++) {
                                System.out.println(medias[i].toString());
                            }
                            break;
                    }
                    break;
                case 5:
                    System.out.println("Books:");
                    for(int i = 0; i < books.length; i++) {
                        System.out.println(books[i].toString());
                    }
                    System.out.println("Journals:");
                    for (int i = 0; i < journals.length; i++) {
                        System.out.println(journals[i].toString());
                    }
                    System.out.println("Medias:");
                    for (int i = 0; i < medias.length; i++) {
                        System.out.println(medias[i].toString());
                    }
                    break;
                case 6:
                    System.out.println("Please enter the information of the client in the following order (leave spaces between the attributes): Name Phone number Email Address Maximum items");
                    String name = scanner.next();
                    long phoneNumber = scanner.nextLong();
                    String emailAddress = scanner.next();
                    int max_size=scanner.nextInt();
                    for (int i = 0; i < books.length; i++) {
                        if (clients[i] == null) {
                            clients[i] = new Client(name, phoneNumber, emailAddress,max_size);
                            break;
                        }
                    }
                    break;
                case 7:
                    System.out.println("Enter client ID to change: ");
                    IDnumber = scanner.nextInt();
                    System.out.print("Do you want to change:" +
                            "\n1. The name" +
                            "\n2. The phone number" +
                            "\n3. The email address" +
                            "\n4. Maximum items");
                    int changeCChoice = scanner.nextInt();
                    switch (changeCChoice) {
                        case 1:
                            System.out.print("Enter the new info: ");
                            String newName = scanner.next();
                            clients[IDnumber].setName(newName);
                            break;
                        case 2:
                            System.out.print("Enter the new info: ");
                            long newPhoneNumber = scanner.nextLong();
                            clients[IDnumber].setPhoneNumber(newPhoneNumber);
                            break;
                        case 3:
                            System.out.print("Enter the new info: ");
                            String newEmailAddress=scanner.next();
                            clients[IDnumber].setEmailAddress(newEmailAddress);
                            break;
                        case 4:
                            System.out.print("Enter the new info: ");
                            int newMaxSize=scanner.nextInt();
                            clients[IDnumber].setMaxSize(newMaxSize);
                            break;

                    }
                case 8:
                    System.out.println("Enter client ID to delete: ");
                    IDnumber = scanner.nextInt();
                    Client[] copy = new Client[clients.length];
                    for (int i = 0; i < clients.length; i++) {
                        if (i != IDnumber) {
                            copy[i] = clients[i];
                        }
                    }
                    clients = copy;
                    break;
                case 9:
                    System.out.print("Enter the clientID");
                    clientID=scanner.next();
                    clientPos=-1;
                    foundClient=false;
                    while(!foundClient) {
                        for (int i = 0; i < clients.length; i++) {
                            if (clients[i].getClientID().equals(clientID)) {
                                clientPos = i;
                                foundClient=true;
                                break;
                            } else {
                                continue;
                            }
                        }
                        if (clientPos == -1) {
                            System.out.print("Invalid ID!");
                        }
                    }
                    System.out.print("Enter the ID of the item to lease");
                    String itemToLease=scanner.next();
                    for(int i=0;i<clients[clientPos].items.length;i++)
                        if(clients[clientPos].items[i]==null){
                            clients[clientPos].items[i]=itemToLease;
                            break;
                        }
                        else{
                            continue;
                        }
                    break;
                case 10:
                    System.out.print("Enter the clientID");
                    clientID=scanner.next();
                    clientPos=-1;
                    foundClient=false;
                    while(!foundClient) {
                        for (int i = 0; i < clients.length; i++) {
                            if (clients[i].getClientID().equals(clientID)) {
                                clientPos = i;
                                foundClient=true;
                                break;
                            } else {
                                continue;
                            }
                        }
                        if (clientPos == -1) {
                            System.out.print("Invalid ID!");
                        }
                    }
                    System.out.print("Enter the ID of the item to return");
                    String itemToReturn=scanner.next();
                    String[] copyOfItems=new String[clients[clientPos].items.length-1];
                    for(int i=0;i<clients[clientPos].items.length;i++)
                        if(Objects.equals(clients[clientPos].items[i], itemToReturn)){
                            for(int j=0;j< copyOfItems.length;j++){
                                if(clients[clientPos].items[j]!=null&& !Objects.equals(clients[clientPos].items[j], itemToReturn)){
                                    copyOfItems[j]=clients[clientPos].items[j];
                                }
                                else{
                                    continue;
                                }
                            }
                            break;
                        }
                        else{
                            continue;
                        }
                    clients[clientPos].items=copyOfItems;
                    break;
                case 11:
                    System.out.print("Enter the clientID");
                    clientID=scanner.next();
                    clientPos=-1;
                    foundClient=false;
                    while(!foundClient) {
                        for (int i = 0; i < clients.length; i++) {
                            if (clients[i].getClientID().equals(clientID)) {
                                clientPos = i;
                                foundClient=true;
                                break;
                            } else {
                                continue;
                            }
                        }
                        if (clientPos == -1) {
                            System.out.print("Invalid ID!");
                        }
                    }
                    for(int i=0;i<clients[clientPos].items.length;i++){
                        if(clients[clientPos].items[i]!=null) {
                            System.out.println(clients[clientPos].items[i]);
                        }
                    }
                    break;
                case 12:
                    for(int i=0;i<clients.length;i++){
                        for(int j=0;j<clients[i].items.length;j++){
                            if(clients[i].items[j]!=null) {
                                System.out.println(clients[i].items[j]);
                            }
                            else{
                                continue;
                            }
                        }
                    }
                    break;
                case 13:
                    getBiggestBook(books);
                    break;
                case 14:
                    copyBooks(books);
                    break;
                case 15:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }

        scanner.close();
    }

    protected static void getBiggestBook(Book[] booksArray) {
        Book biggestBook = booksArray[0];
        for (int i = 1; i < booksArray.length; i++) {
            if (booksArray[i] != null && booksArray[i].getNumberOfPages() > biggestBook.getNumberOfPages()) {
                biggestBook = booksArray[i];
            }
        }
        System.out.println("The biggest book is:\n" + biggestBook.toString());
    }
    protected static void copyBooks(Book[] booksArray) {
        if (booksArray == null || booksArray.length == 0) {
            System.out.println("No books available to copy.");
            return;
        }
        Book[] copy = new Book[booksArray.length];
        for (int i = 0; i < booksArray.length; i++) {
            if (booksArray[i] != null) {
                copy[i] = new Book(booksArray[i]);
            }
        }
        System.out.println("Copied books array:");
        for (Book copiedBook : copy) {
            if (copiedBook != null) {
                System.out.println(copiedBook);
            }
        }
    }

}
