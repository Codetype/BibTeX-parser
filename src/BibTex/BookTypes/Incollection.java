package BibTex.BookTypes;

public class Incollection {
    private String title;
    private String author;
    private String booktitle;
    private String publisher;
    private String year;

    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;
        if(checkItem() == false) {
            throw new NullPointerException("Brak wymaganych pol!");
        }
        else return "\n" + myLine + "\n" + mySign +" Incollection\n" + myLine +
                "\n" +mySign +"  title\t\t" + mySign + ' ' + title + "\n" + myLine +
                "\n" +mySign +" author\t" + mySign + ' ' + author + "\n" + myLine +
                "\n" +mySign +" publisher\t" + mySign + ' '  + publisher + "\n" + myLine +
                "\n" +mySign +" booktitle\t" + mySign + ' '  + booktitle + "\n" + myLine +
                "\n" +mySign +" year\t\t" + mySign + ' ' + year + "\n" + myLine;
    }

    public boolean checkItem(){
        if(this.title == null || this.author == null || this.publisher == null || this.booktitle == null || this.year == null)
            return false;
        return true;
    }

    public String getYear() {
        return year;
    }

    public String getPublisher() {

        return publisher;
    }

    public String getBooktitle() {

        return booktitle;
    }

    public String getAuthor() {

        return author;
    }

    public String getTitle() {

        return title;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setPublisher(String publisher) {

        this.publisher = publisher;
    }

    public void setBooktitle(String booktitle) {

        this.booktitle = booktitle;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setTitle(String title) {

        this.title = title;
    }
}
