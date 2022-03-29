// Some import statements
// By the way fis and ois are used to read files
// fos and oos are used to write files

import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;

public class Main {

    public static Scanner sc = new Scanner(System.in); // You don't have to make it as public static

    public static void main(String[] args) {

        ArrayList<String> bookCodes = new ArrayList<>();

        System.out.println("New Book Registration"); // It works as soon as the program starts because there may be an exception in 84th statement
        boolean flag = true;
        System.out.print("Book code: "); // Getting informations
        String bookCode = sc.nextLine();
        System.out.print("Book Name: ");
        String bookName = sc.nextLine();
        System.out.print("Author Name: ");
        String authorName = sc.nextLine();
        System.out.print("Pages: ");
        int pages = sc.nextInt();
        bookCodes.add(bookCode);
        System.out.println("*************************");

        Books book = new Books();
        book.setValues(authorName, pages, bookCode, bookName); // I made another function instead of constructor beacuse I will use it
        // like a bridge. It stores the books temporarily. Values -> book object -> file
        
        // Java suggested all the try-catch files
        try {
            FileOutputStream fos = new FileOutputStream(bookCode + ".dat");
            try {

                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(book);
                oos.flush();
                oos.close();
                fos.close();

            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } 

        while (flag) {
            // Instructions
            System.out.println("To add new book -> 1");
            System.out.println("To change properties -> 2");
            System.out.println("To delete a book -> 3");
            System.out.println("To display -> 4");
            System.out.println("To finish the program -> 5");
            System.out.print("Your answer: ");

            int request = sc.nextInt();
            System.out.println("*************************");

            // Book coode is important because we use it to identify them
            // And the files' names are book codes
            
            switch (request) {

                case 1:
                    System.out.print("Book code: ");
                    sc.nextLine();
                    bookCode = sc.nextLine();
                    System.out.print("Book Name: ");
                    bookName = sc.nextLine();
                    System.out.print("Author Name: ");
                    authorName = sc.nextLine();
                    System.out.print("Pages: ");
                    pages = sc.nextInt();
                    sc.nextLine();
                    bookCodes.add(bookCode);

                    book.setValues(authorName, pages, bookCode, bookName); // I made my own function instead of constructor becasue 
                    // we can use it again and again
                    System.out.println("*************************");

                    try (FileOutputStream fos = new FileOutputStream(bookCode + ".dat"); // This is used to write the object to the file
                            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

                        oos.writeObject(book); // It writes the object to the adress which we defined in 92nd statement
                        oos.flush();
                        oos.close();
                        fos.close();

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;

                case 2:
                    System.out.print("Book code: ");
                    sc.nextLine();
                    String codeToChange = sc.nextLine();
                    System.out.println("*************************");

                    try {
                        FileInputStream fis = new FileInputStream(codeToChange + ".dat"); // It is used to read files
                        try {
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            try {
                                book = (Books) ois.readObject(); // We read the file before. And now we are writing the values to book.
                                // After that we will write the book, whose values are changed, to the file again, user will decide
                                // the value that they want to change according to the instructions.
                                // e.g. types 1 to change the author
                                fis.close();
                                ois.close();
                                System.out.println("To change the author -> 1");
                                System.out.println("To change the name -> 2");
                                System.out.println("To change the code -> 3");
                                System.out.println("To change the number of the pages -> 4");

                                FileOutputStream fos = new FileOutputStream(codeToChange + ".dat"); // file name is our book code
                                ObjectOutputStream oos = new ObjectOutputStream(fos);
                                System.out.print("Your answer: ");
                                int request1 = sc.nextInt();
                                System.out.println("*************************");

                                switch (request1) {

                                    case 1:
                                        System.out.print("New value: ");
                                        sc.nextLine();
                                        String newValue = sc.nextLine();
                                        book.setAuthorName(newValue);
                                        System.out.println("Value has changed.");
                                        oos.writeObject(book); // writes the object to the adress in 112
                                        oos.flush(); 
                                        oos.close(); // closes tahe oos
                                        fis.close();
                                        fos.close();
                                        System.out.println("*************************");
                                        break;

                                    case 2:
                                        System.out.print("New value: ");
                                        sc.nextLine();
                                        String newValue1 = sc.nextLine();
                                        book.setBookName(newValue1);
                                        System.out.println("Value has changed.");
                                        oos.writeObject(book); // writes the object to the adress in 112
                                        oos.flush();
                                        oos.close(); // closes the oos
                                        fis.close();
                                        fos.close();
                                        ois.close();
                                        System.out.println("*************************");
                                        break;

                                    case 3:
                                        System.out.print("New value: ");
                                        sc.nextLine();
                                        String newValue2 = sc.nextLine();
                                        book.setBookCode(newValue2);
                                        System.out.println("Value has changed.");
                                        oos.writeObject(book); // writes the object to the adress in 113
                                        oos.flush();
                                        oos.close();// closes the oos
                                        fis.close();
                                        fos.close();
                                        ois.close();
                                        System.out.println("*************************");
                                        break;

                                    case 4:
                                        System.out.print("New value: ");
                                        int newValue3 = sc.nextInt();
                                        book.setPages(newValue3);
                                        System.out.println("Value has changed.");
                                        oos.writeObject(book); // writes the object to the adress in 113
                                        oos.flush();
                                        oos.close(); // closes the oos
                                        fos.close();
                                        ois.close();
                                        fis.close();
                                        System.out.println("*************************");
                                        break;

                                    default:
                                        System.out.println("Something went wrong.");
                                        fis.close();
                                        ois.close();
                                        fos.close();
                                        oos.close();
                                        System.out.println("*************************");
                                        break;

                                }

                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                
                
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;

                case 3:
                    System.out.print("Book Code: ");
                    sc.nextLine();
                    String codeToDelete = sc.nextLine();
                    // Don't forget to change the adress, because the following adress is mine
                    File deletedFile = new File("C:\\Users\\utkut\\Documents\\NetBeansProjects\\Adding-Books\\" + codeToDelete + ".dat");
                    
                    
                    
                    if (deletedFile.delete()) {
                        System.out.println("File deleted.");
                    } else {
                        System.out.println("Failed to delete the file."); // delete() function returns true or false
                    }
                    System.out.println("*************************");
                    break;

                case 4:
                    System.out.print("Book Code: ");
                    sc.nextLine();
                    String codeToDisplay = sc.nextLine();
                    System.out.println("*************************");

                    try {
                        FileInputStream fis = new FileInputStream(codeToDisplay + ".dat");
                        try {
                            ObjectInputStream ois = new ObjectInputStream(fis);
                            try {
                                book = (Books) ois.readObject();
                                book.display();
                                ois.close();
                            } catch (ClassNotFoundException ex) {
                                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                try {
                    fis.close();
                } catch (IOException ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                }
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("*************************");
                    break;
                case 5:
                    flag = false;
                    break;

            }
        }
    }
}
