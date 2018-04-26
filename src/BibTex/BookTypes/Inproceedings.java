package BibTex.BookTypes;

public class Inproceedings{
    private String title;
    private String author;
    private String booktitle;
    private String year;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public String getBooktitle() {
        return booktitle;
    }
    public void setBooktitle(String booktitle) {
        this.booktitle = booktitle;
    }

    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }

    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;
        if(checkItem() == false) {
            throw new NullPointerException("Brak wymaganych pol!");
        }
        else return "\n" + myLine + "\n" + mySign +" Inproceedings\n" + myLine +
                "\n" +mySign +"  title\t\t" + mySign + ' ' + title + "\n" + myLine +
                "\n" +mySign +" author\t" + mySign + ' ' + author + "\n" + myLine +
                "\n" +mySign +" booktitle\t" + mySign + ' '  + booktitle + "\n" + myLine +
                "\n" +mySign +" year\t\t" + mySign + ' ' + year + "\n" + myLine;
    }

    public boolean checkItem(){
        if(this.title == null || this.author == null || this.booktitle == null || this.year == null)
            return false;
        return true;
    }
}
