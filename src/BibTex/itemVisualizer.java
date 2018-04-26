package BibTex;

import BibTex.BookTypes.LibraryItems;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class itemVisualizer {
    /**
     * zwraca tabele elementow bibliotecznych do konsoli
     *
     * @param listOfBooks lista elementow kolekcji
     *               
     * @param mySign znak ASCII do obramowania
     *               
     */
    public static String dump(List<LibraryItems> listOfBooks, char mySign) {
        StringBuilder builder = new StringBuilder();

        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;


        for(LibraryItems l : listOfBooks){
            switch (l.getType()) {
                case "article":
                    builder.append(l.getArticle().toString(mySign));
                    break;
                case "book":
                    builder.append(l.getBook().toString(mySign));
                    break;
                case "booklet":
                    builder.append(l.getBooklet().toString(mySign));
                    break;
                case "inbook":
                    builder.append(l.getInbook().toString(mySign));
                    break;
                case "incollection":
                    builder.append(l.getIncollection().toString(mySign));
                    break;
                case "inproceedings":
                    builder.append(l.getInproceedings().toString(mySign));
                    break;
                case "misc":
                    builder.append(l.getMisc().toString(mySign));
                    break;
                case "manual":
                    builder.append(l.getManual().toString(mySign));
                    break;

                case "mastersthesis":
                    builder.append(l.getMasterthesis().toString(mySign));
                    break;
                case "phdthesis":
                    builder.append(l.getPhdthesis().toString(mySign));
                    break;
                case "techreport":
                    builder.append(l.getTechreport().toString(mySign));
                    break;
                case "unpublished":
                    builder.append(l.getUnpublished().toString(mySign));
                    break;
                default:
                    break;
            }

            boolean field = true;
            for (String e : l.getOptionalFields()) {
                if (field) {
                    builder.append("\n" + mySign + " " + e);
                    field = false;
                } else {
                    builder.append("\t" + mySign + e + "\n" + myLine);
                    field = true;
                }
            }
                builder.append("\n");
            }


        return builder.toString();
    }
    /**
     * zwraca tabele elementow bibliotecznych do konsoli
     *
     * @param listOfBooks lista elementow kolekcji
     *              
     * @param myType nazwa kategorii bibliotecznej
     *               
     * @param mySign znak ASCII do obramowania
     *               
     */
    public static String dumpCategory(List<LibraryItems> listOfBooks, String myType, char mySign) {
        StringBuilder builder = new StringBuilder();

        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;

        for(LibraryItems l : listOfBooks){
            if(myType.equals(l.getType())) {
                switch (myType) {
                    case "article":
                        builder.append(l.getArticle().toString(mySign));
                        break;
                    case "book":
                        builder.append(l.getBook().toString(mySign));
                        break;
                    case "booklet":
                        builder.append(l.getBooklet().toString(mySign));
                        break;
                    case "inbook":
                        builder.append(l.getInbook().toString(mySign));
                        break;
                    case "incollection":
                        builder.append(l.getIncollection().toString(mySign));
                        break;
                    case "inproceedings":
                        builder.append(l.getInproceedings().toString(mySign));
                        break;
                    case "misc":
                        builder.append(l.getMisc().toString(mySign));
                        break;
                    case "manual":
                        builder.append(l.getManual().toString(mySign));
                        break;

                    case "mastersthesis":
                        builder.append(l.getMasterthesis().toString(mySign));
                        break;
                    case "phdthesis":
                        builder.append(l.getPhdthesis().toString(mySign));
                        break;
                    case "techreport":
                        builder.append(l.getTechreport().toString(mySign));
                        break;
                    case "unpublished":
                        builder.append(l.getUnpublished().toString(mySign));
                        break;
                    default:
                        break;
                }

                boolean field = true;
                for (String e : l.getOptionalFields()) {
                    if (field) {
                        builder.append("\n" + mySign + " " + e);
                        field = false;
                    } else {
                        builder.append("\t" + mySign + e + "\n" + myLine);
                        field = true;
                    }
                }
                builder.append("\n");
            }
        }

        return builder.toString();
    }
    /**
     * zwraca tabele elementow bibliotecznych do konsoli
     *
     * @param listOfBooks lista elementow kolekcji
     *              
     * @param myAuthor nazwa autora publikacji
     *               
     * @param mySign znak ASCII do obramowania
     *               
     */
    public static String dumpAuthor(List<LibraryItems> listOfBooks, String myAuthor, char mySign) {
        StringBuilder builder = new StringBuilder();

        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;

        for(LibraryItems l : listOfBooks){
            boolean authorFlag = false;
            if(l.getAuthor() != null) {

                Pattern searchingType = Pattern.compile(myAuthor);
                Matcher matcherType = searchingType.matcher(l.getAuthor());
                if (matcherType.find())
                    authorFlag = true;
            }
            if(authorFlag == true) {
                String myType = l.getType();
                switch (myType) {
                    case "article":
                        builder.append(l.getArticle().toString(mySign));
                        break;
                    case "book":
                        builder.append(l.getBook().toString(mySign));
                        break;
                    case "booklet":
                        builder.append(l.getBooklet().toString(mySign));
                        break;
                    case "inbook":
                        builder.append(l.getInbook().toString(mySign));
                        break;
                    case "incollection":
                        builder.append(l.getIncollection().toString(mySign));
                        break;
                    case "inproceedings":
                        builder.append(l.getInproceedings().toString(mySign));
                        break;
                    case "misc":
                        builder.append(l.getMisc().toString(mySign));
                        break;
                    case "manual":
                        builder.append(l.getManual().toString(mySign));
                        break;

                    case "mastersthesis":
                        builder.append(l.getMasterthesis().toString(mySign));
                        break;
                    case "phdthesis":
                        builder.append(l.getPhdthesis().toString(mySign));
                        break;
                    case "techreport":
                        builder.append(l.getTechreport().toString(mySign));
                        break;
                    case "unpublished":
                        builder.append(l.getUnpublished().toString(mySign));
                        break;
                    default:
                        break;
                }

                boolean field = true;
                for (String e : l.getOptionalFields()) {
                    if (field) {
                        builder.append("\n" + mySign + " " + e);
                        field = false;
                    } else {
                        builder.append("\t" + mySign + e + "\n" + myLine);
                        field = true;
                    }
                }
                builder.append("\n");
            }
        }

        return builder.toString();
    }
    public static String dumpYear(List<LibraryItems> listOfBooks, int myYear, char mySign) {
        StringBuilder builder = new StringBuilder();

        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;


        for(LibraryItems l : listOfBooks){
            if(myYear == l.getYear()) {
                String myType = l.getType();
                switch (myType) {
                    case "article":
                        builder.append(l.getArticle().toString(mySign));
                        break;
                    case "book":
                        builder.append(l.getBook().toString(mySign));
                        break;
                    case "booklet":
                        builder.append(l.getBooklet().toString(mySign));
                        break;
                    case "inbook":
                        builder.append(l.getInbook().toString(mySign));
                        break;
                    case "incollection":
                        builder.append(l.getIncollection().toString(mySign));
                        break;
                    case "inproceedings":
                        builder.append(l.getInproceedings().toString(mySign));
                        break;
                    case "misc":
                        builder.append(l.getMisc().toString(mySign));
                        break;
                    case "manual":
                        builder.append(l.getManual().toString(mySign));
                        break;

                    case "mastersthesis":
                        builder.append(l.getMasterthesis().toString(mySign));
                        break;
                    case "phdthesis":
                        builder.append(l.getPhdthesis().toString(mySign));
                        break;
                    case "techreport":
                        builder.append(l.getTechreport().toString(mySign));
                        break;
                    case "unpublished":
                        builder.append(l.getUnpublished().toString(mySign));
                        break;
                    default:
                        break;
                }

                boolean field = true;
                for (String e : l.getOptionalFields()) {
                    if (field) {
                        builder.append("\n" + mySign + " " + e);
                        field = false;
                    } else {
                        builder.append("\t" + mySign + e + "\n" + myLine);
                        field = true;
                    }
                }
                builder.append("\n");
            }
        }

        return builder.toString();
    }

}
