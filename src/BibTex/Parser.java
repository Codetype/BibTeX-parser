package BibTex;

import BibTex.BookTypes.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.*;

public class Parser {

	  
    /**
     * metoda do parsowania pliku
     * Tworzy liste elementow po sparsowaniu pliku
     * 
     * @param filepath
     *               
     */

    public List<String> parseFile(String filePath){
        FileReader myfr = null;
        String linia = ""; String recentType = "";

        // OTWIERANIE PLIKU:
        try {
            myfr = new FileReader(filePath);
        } catch (FileNotFoundException e) {
            System.out.println("Wystapi³ b³ad przy otwarciu pliku.");
            System.exit(1);
        }

        boolean inItem = false;
        BufferedReader bfr = new BufferedReader(myfr);
        List<String> myBuffor = new ArrayList<String>();
        int i = 0;

        /**
         * 
         * odczytywanie danych z pliku
         *               
         */
        try {
            while((linia = bfr.readLine()) != null){

                Pattern searchingType = Pattern.compile("@.+\\{");
                Matcher matcherType = searchingType.matcher(linia);

                Pattern searchingFileds = Pattern.compile(".=.");
                Matcher matcherField = searchingFileds.matcher(linia);


                if(matcherType.find()) {
                    String items[];
                    items = linia.split("\\{.+");
                    inItem = true;
                    for (String s : items) {
                        recentType = s;
                    }
                    if(recentType.equals("@preamble") || recentType.equals("@PROCEEDINGS"))
                        continue;
                    myBuffor.add("startOfItem");
                    myBuffor.add(recentType);
                }

                else if(matcherField.find() && inItem) {
                    String keyItems[]; //String valueItems[];
                    String myKey = ""; String myValue = "";

                    String testS[] = {}; String testM = "";

                    keyItems = linia.split("=.+");

                    testS = linia.split(".+=");
                    for(String s : testS)
                        testM += s;

                    testS = testM.split("\\,"); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\{"); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\}"); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\\""); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\\'"); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\["); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\]"); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\\\"); testM = "";
                    for (String s : testS)
                        testM += s;

                    testS = testM.split("\\/"); testM = "";
                    for (String s : testS)
                        testM += s;


                    testS = testM.split("\\$"); testM = "";
                    for (String s : testS)
                        testM += s;


                    for(String s : keyItems) {
                        myKey = s.trim();
                    }

                    if("year".equals(myKey)) {
                        myValue = testM.trim();
                    }
                    else if("author".equals(myKey)){
                        keyItems = testM.split("and");
                        for(String k : keyItems)
                            myValue += k + "\n \t\t ";
                    }
                    else
                        myValue = testM;

                    myBuffor.add(myKey);
                    myBuffor.add(myValue);
                }

                else{
                    if(inItem == true){
                        i++;
                    }
                    inItem = false;
                }

            }
        } catch (IOException e) {
            System.out.println("Wystapi³ b³ad przy odczytywanie pliku.");
            System.exit(2);
        }
        // ZAMYKANIE PLIKU
        try {
            myfr.close();
        } catch (IOException e) {
            System.out.println("Wystapi³ b³ad przy zamykaniu pliku.");
            System.exit(3);
        }

        return myBuffor;
    }

    /**
     * 
     * metoda do parsowania na postacu obiektowej…
     * 
     * zwraca array liste w postaci obiektowej elementy biblioteki
     *
     * @param myBuffor lista elementów do zmiany na obiektow postac
     *               
     */
    
    public List<LibraryItems> parseToObject(List<String> myBuffor) {
        List<LibraryItems> listOfBooks = new ArrayList<LibraryItems>(); int iter = -1;

        String bookType = "";
        String fieldType = "";

        //typy literatury
        List<Article> article = new ArrayList<Article>(); int art = -1;
        List<Book> book = new ArrayList<Book>(); int bok = -1;
        List<Inproceedings> inproceedings = new ArrayList<Inproceedings>(); int inp = -1;
        List<Booklet> booklet = new ArrayList< Booklet>(); int bkl = -1;
        List<Inbook> inbook = new ArrayList<Inbook>(); int inb = -1;
        List<Incollection> incollection = new ArrayList<Incollection>(); int inc = -1;
        List<Manual> manual = new ArrayList<Manual>(); int man = -1;
        List<Masterthesis> masterthesis = new ArrayList<Masterthesis>(); int mas = -1;
        List<Phdthesis> phdthesis = new ArrayList<Phdthesis>(); int phd = -1;
        List<Techreport> techreport = new ArrayList<Techreport>(); int tech = -1;
        List<Misc> misc = new ArrayList<Misc>(); int mis = -1;
        List<Unpublished> unpublished = new ArrayList<Unpublished>(); int unp = -1;
        List<String> string = new ArrayList<String>(); int str = -1;

        //flagi
        boolean findTitle = false, findField = false, inItem = false;

        for(String s : myBuffor) {

            if("startOfItem".equals(s)) {
                inItem = false; iter++;
                findTitle = true; continue;
            }
            if(findTitle == true){
                listOfBooks.add(new LibraryItems());
                switch (s) {
                    case "@article":
                    case "@ARTICLE":
                        bookType = "article";article.add(new Article()); art++;listOfBooks.get(iter).setType("article"); break;
                    case "@book":
                    case "@BOOK":
                        bookType = "book";book.add(new Book()); bok++;listOfBooks.get(iter).setType("book");break;
                    case "@inproceedings":
                    case "@INPROCEEDINGS":
                    case "@conference":
                    case "@CONFERENCE":
                        bookType = "inproceedings";inproceedings.add(new Inproceedings()); inp++;listOfBooks.get(iter).setType("inproceedings");break;
                    case "@booklet":
                    case "@BOOKLET":
                        bookType = "booklet";booklet.add(new Booklet()); bkl++;listOfBooks.get(iter).setType("booklet");break;
                    case "@inbook":
                    case "@INBOOK":
                        bookType = "inbook";inbook.add(new Inbook()); inb++;listOfBooks.get(iter).setType("inbook");break;
                    case "@incollection":
                    case "@INCOLLECTION":
                        bookType = "incollection";incollection.add(new Incollection()); inc++;listOfBooks.get(iter).setType("incollection");break;
                    case "@manual":
                    case "@MANUAL":
                        bookType = "manual";manual.add(new Manual()); man++;listOfBooks.get(iter).setType("manual"); break;
                    case "@mastersthesis":
                    case "@MASTERSTHESIS":
                        bookType = "mastersthesis";masterthesis.add(new Masterthesis()); mas++;listOfBooks.get(iter).setType("mastersthesis");break;
                    case "@phdthesis":
                    case "@PHDTHESIS":
                        bookType = "phdthesis";phdthesis.add(new Phdthesis()); phd++;listOfBooks.get(iter).setType("phdthesis");break;
                    case "@techreport":
                    case "@TECHREPORT":
                        bookType = "techreport";techreport.add(new Techreport()); tech++;listOfBooks.get(iter).setType("techreport");break;
                    case "@misc":
                    case "@MISC":
                        bookType = "misc";misc.add(new Misc()); mis++;listOfBooks.get(iter).setType("misc"); break;
                    case "@unpublished":
                    case "@UNPUBLISHED":
                        bookType = "unpublished"; unpublished.add(new Unpublished()); unp++; listOfBooks.get(iter).setType("unpublished");break;
                    case "@string":
                    case "@STRING":
                        bookType = "string";
                        string.add(new String()); str++;
                        listOfBooks.get(iter).setType("string");
                        break;
                    default:
                        break;
                }
                findTitle = false; inItem = true; continue;
            }

            if(inItem == true) {
                if(findField == false) {
                    fieldType = s; findField = true; continue;
                }
                if ("article".equals(bookType)) {
                    switch (fieldType) {
                        case "title": article.get(art).setTitle(s);break;
                        case "author": article.get(art).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "journal": article.get(art).setJournal(s);break;
                        case "year": article.get(art).setYear(s);break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setArticle(article.get(art));
                    findField = false;
                }
                if ("book".equals(bookType)) {
                    switch (fieldType) {
                        case "title": book.get(bok).setTitle(s);break;
                        case "author":
                        case "editor": book.get(bok).setAuthor(s);listOfBooks.get(iter).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "publisher": book.get(bok).setPublisher(s);break;
                        case "year": book.get(bok).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setBook(book.get(bok));
                    findField = false;
                }

                if ("inproceedings".equals(bookType)) {
                    switch (fieldType) {
                        case "title": inproceedings.get(inp).setTitle(s);break;
                        case "author": inproceedings.get(inp).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "booktitle": inproceedings.get(inp).setBooktitle(s);break;
                        case "year": inproceedings.get(inp).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setInproceedings(inproceedings.get(inp));
                    findField = false;
                }
                if ("booklet".equals(bookType)) {
                    switch (fieldType) {
                        case "title": booklet.get(bkl).setTitle(s);break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setBooklet(booklet.get(bkl));
                    findField = false;
                }
                if ("inbook".equals(bookType)) {
                    switch (fieldType) {
                        case "title": inbook.get(inb).setTitle(s);break;
                        case "chapter":
                        case "pages": inbook.get(inb).setChapter(s);break;
                        case "author":
                        case "editor": inbook.get(inb).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "publisher": inbook.get(inb).setPublisher(s);break;
                        case "year": inbook.get(inb).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setInbook(inbook.get(inb));
                    findField = false;
                }
                if ("incollection".equals(bookType)) {
                    switch (fieldType) {
                        case "title": incollection.get(inc).setTitle(s);break;
                        case "booktitle": incollection.get(inc).setBooktitle(s);break;
                        case "author": incollection.get(inc).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "publisher": incollection.get(inc).setPublisher(s);break;
                        case "year": incollection.get(inc).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setIncollection(incollection.get(inc));
                    findField = false;
                }
                if ("manual".equals(bookType)) {
                    switch (fieldType) {
                        case "title": manual.get(man).setTitle(s);break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setManual(manual.get(man));
                    findField = false;
                }
                if ("mastersthesis".equals(bookType)) {
                    switch (fieldType) {
                        case "title": masterthesis.get(mas).setTitle(s);break;
                        case "author": masterthesis.get(mas).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "school": masterthesis.get(mas).setSchool(s);break;
                        case "year": masterthesis.get(mas).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setMasterthesis(masterthesis.get(mas));
                    findField = false;
                }
                if ("misc".equals(bookType)) {
                    listOfBooks.get(iter).putElem(fieldType);
                    listOfBooks.get(iter).putElem(s);

                    findField = false;
                }
                if ("phdthesis".equals(bookType)) {
                    switch (fieldType) {
                        case "author": phdthesis.get(phd).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "title": phdthesis.get(phd).setTitle(s);break;
                        case "school": phdthesis.get(phd).setSchool(s);break;
                        case "year": phdthesis.get(phd).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setPhdthesis(phdthesis.get(phd));
                    findField = false;
                }
                if ("techreport".equals(bookType)) {
                    switch (fieldType) {
                        case "title": techreport.get(tech).setTitle(s);break;
                        case "author": techreport.get(tech).setAuthor(s);listOfBooks.get(iter).setAuthor(s);break;
                        case "institution": techreport.get(tech).setInstitution(s);break;
                        case "year": techreport.get(tech).setYear(s); break; //listOfBooks.get(iter).setYear(Integer.parseInt(s));break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setTechreport(techreport.get(tech));
                    findField = false;
                }
                if ("unpublished".equals(bookType)) {
                    switch (fieldType) {
                        case "title": unpublished.get(unp).setTitle(s);break;
                        case "author": unpublished.get(unp).setAuthor(s); break; //listOfBooks.get(iter).setAuthor(s);break;
                        case "note": unpublished.get(unp).setNote(s);break;
                        default:
                            listOfBooks.get(iter).putElem(fieldType);
                            listOfBooks.get(iter).putElem(s);
                            break;
                    }
                    listOfBooks.get(iter).setUnpublished(unpublished.get(unp));
                    findField = false;
                }
                if ("string".equals(bookType)) {
                    listOfBooks.get(iter).putElem(fieldType);
                    listOfBooks.get(iter).putElem(s);

                    findField = false;
                }

            }


        }

        return listOfBooks;
    }
}
