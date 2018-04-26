package BibTex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BibTex.BookTypes.*;

public class Main extends Parser{
    public static void main(String[] args){

        //String filePath = "C://Users//pawel//workspace//Library//Library.bib";
        Scanner odczyt = new Scanner(System.in);

        System.out.println("Podaj sciezke pliku wejsciowego: ");
        String filePath = odczyt.nextLine();

        System.out.println("Podaj kategorie: ");
        String category = odczyt.nextLine();

        System.out.println("Podaj autora: ");
        String author = odczyt.nextLine();

        System.out.println("Podaj znak dla obramowania: ");
        String mySign = odczyt.nextLine();
        char c = mySign.charAt(0);

        //System.out.println("Podaj rok: ");
        //int year = odczyt.nextInt();

        Parser myParser = new Parser();
        List<String> myBuffor = new ArrayList<String>();
        List<LibraryItems> listOfBooks = new ArrayList<LibraryItems>();
        myBuffor = myParser.parseFile(filePath);
        listOfBooks = myParser.parseToObject(myBuffor);

        //narysuj ca³a… kolekcje
        System.out.println("Ca³a kolekcja: ");
        System.out.print(itemVisualizer.dump(listOfBooks, c));

        //narysuj wedlug kategorii
        System.out.println("Publikacje z kategorii: "+category);
        System.out.print(itemVisualizer.dumpCategory(listOfBooks, category, c));

        //narysuj wedluug autora
        System.out.println("Publikacje autorstwa: "+author);
        System.out.print(itemVisualizer.dumpAuthor(listOfBooks, author, c));

    }
}
