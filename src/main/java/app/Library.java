package app;

import io.DataReader;
import model.Book;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {
        final String appName = "Biblioteka v0.8";
        Scanner sc = new Scanner(System.in);

        Book[] books = new Book[1000];
        DataReader dataReader = new DataReader();
        books[0] = dataReader.readAndCreateBook();
        books[1] = dataReader.readAndCreateBook();

        System.out.print(appName);
        System.out.println("Książki dostępne w bibliotece:");
        books[0].printInfo();
        books[1].printInfo();

    }
}
