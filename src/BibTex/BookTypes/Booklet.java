package BibTex.BookTypes;
import java.util.List;

public class Booklet{
    private String title;

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += mySign;
        if(checkItem() == false) {
            throw new NullPointerException("Brak wymaganych poll!");
        }
        else return "\n" + myLine + "\n" + mySign +" Booklet\n" + myLine +
                "\n" +mySign +"  title\t\t" + mySign + ' ' + title + "\n" + myLine;

    }

    public boolean checkItem(){
        if(this.title == null)
            return false;
        return true;
    }
}
