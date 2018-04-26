package BibTex.BookTypes;

public class Phdthesis {
    private String title;
    private String author;
    private String school;
    private String year;

    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;
        if(checkItem() == false) {
            throw new NullPointerException("Brak wymaganych pol!");
        }
        else return "\n" + myLine + "\n" + mySign +" Phdthesis\n" + myLine +
                "\n" +mySign +"  title\t\t" + mySign + ' ' + title + "\n" + myLine +
                "\n" +mySign +" author\t" + mySign + ' ' + author + "\n" + myLine +
                "\n" +mySign +" school\t" + mySign + ' '  + school + "\n" + myLine +
                "\n" +mySign +" year\t\t" + mySign + ' ' + year + "\n" + myLine;
    }

    public boolean checkItem(){
        if(this.title == null || this.author == null || this.school == null || this.year == null)
            return false;
        return true;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setSchool(String school) {

        this.school = school;
    }

    public void setAuthor(String author) {

        this.author = author;
    }

    public void setTitle(String title) {

        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public String getSchool() {

        return school;
    }

    public String getAuthor() {

        return author;
    }

    public String getTitle() {

        return title;
    }
}
