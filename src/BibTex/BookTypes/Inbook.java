package BibTex.BookTypes;

public class Inbook {
    private String title;
    private String author;
    private String chapter;
    private String publisher;
    private String year;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setChapter(String chapter) {

        this.chapter = chapter;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getYear() {
        return year;
    }

    public String getPublisher() {

        return publisher;
    }

    public String getChapter() {

        return chapter;
    }

    public String getAuthor() {

        return author;
    }

    public String getTitle() {

        return title;
    }

    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;
        if(checkItem() == false) {
            throw new NullPointerException("Brak wymaganych pol!");
        }
        else return "\n" + myLine + "\n" + mySign +" Inbook\n" + myLine +
                "\n" +mySign +"  title\t\t" + mySign + ' ' + title + "\n" + myLine +
                "\n" +mySign +" author\t" + mySign + ' ' + author + "\n" + myLine +
                "\n" +mySign +" chapter\t" + mySign + ' '  + chapter + "\n" + myLine +
                "\n" +mySign +" year\t\t" + mySign + ' ' + year + "\n" + myLine;
    }

    public boolean checkItem(){
        if(this.title == null || this.author == null || this.chapter == null || this.year == null)
            return false;
        return true;
    }
}
