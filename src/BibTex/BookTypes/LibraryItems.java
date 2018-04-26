package BibTex.BookTypes;
import java.util.ArrayList;
import java.util.List;

public class LibraryItems {
    private String type;
    private String author;
    //rozszerzam o pole year
    private int year;
    
    //bookTypes
    private Book book;
    private Article article;
    private Booklet booklet;
    private Inbook inbook;
    private Incollection incollection;
    private Inproceedings inproceedings;
    private Manual manual;
    private Masterthesis masterthesis;
    private Misc misc;
    private Phdthesis phdthesis;
    private Techreport techreport;
    private Unpublished unpublished;

    //list to optional informations
    private List<String> optionalFields = new ArrayList<String>();

    //methods of LibraryItems
    public void setOptionalFields(List<String> optionalFields) {
        this.optionalFields = optionalFields;
    }
    public List<String> getOptionalFields() { return optionalFields; }
    public void putElem(String elem){ this.optionalFields.add(elem); }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getType() {
        return type;
    }

    public void setBook(Book book) { this.book = book; }
    public Book getBook() { return book; }

    public Article getArticle() {
        return article;
    }
    public void setArticle(Article article) {
        this.article = article;
    }

    public Booklet getBooklet() {
        return booklet;
    }
    public void setBooklet(Booklet booklet) {
        this.booklet = booklet;
    }

    public Inbook getInbook() {
        return inbook;
    }
    public void setInbook(Inbook inbook) {
        this.inbook = inbook;
    }

    public Incollection getIncollection() {
        return incollection;
    }
    public void setIncollection(Incollection incollection) {
        this.incollection = incollection;
    }

    public Inproceedings getInproceedings() {
        return inproceedings;
    }
    public void setInproceedings(Inproceedings inproceedings) {
        this.inproceedings = inproceedings;
    }

    public Manual getManual() {
        return manual;
    }
    public void setManual(Manual manual) {
        this.manual = manual;
    }

    public Masterthesis getMasterthesis() {
        return masterthesis;
    }
    public void setMasterthesis(Masterthesis masterthesis) {
        this.masterthesis = masterthesis;
    }

    public Misc getMisc() {
        return misc;
    }
    public void setMisc(Misc misc) {
        this.misc = misc;
    }

    public Phdthesis getPhdthesis() {
        return phdthesis;
    }
    public void setPhdthesis(Phdthesis phdthesis) {
        this.phdthesis = phdthesis;
    }

    public Techreport getTechreport() {
        return techreport;
    }
    public void setTechreport(Techreport techreport) {
        this.techreport = techreport;
    }

    public Unpublished getUnpublished() {
        return unpublished;
    }
    public void setUnpublished(Unpublished unpublished) {
        this.unpublished = unpublished;
    }
}
