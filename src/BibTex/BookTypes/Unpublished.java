package BibTex.BookTypes;

public class Unpublished {
    private String title;
    private String author;
    private String note;

    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;
        if(checkItem() == false) {
            throw new NullPointerException("Brak wymaganych pol!");
        }
        else return "\n" + myLine + "\n" + mySign +" Unpublished\n" + myLine +
                "\n" +mySign +"  title\t\t" + mySign + ' ' + title + "\n" + myLine +
                "\n" +mySign +" author\t" + mySign + ' ' + author + "\n" + myLine +
                "\n" +mySign +" note\t" + mySign + ' '  + note + "\n" + myLine;
    }

    public boolean checkItem(){
        if(this.title == null || this.author == null || this.note == null)
            return false;
        return true;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getNote() {
        return note;
    }

    public String getAuthor() {

        return author;
    }

    public String getTitle() {

        return title;
    }
}
