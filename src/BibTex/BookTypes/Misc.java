package BibTex.BookTypes;
import java.util.List;

public class Misc {
    public String toString(char mySign) {
        String myLine = "";
        for(int i=0; i<64; i++)
            myLine += '-';

        return "\n" + myLine + "\n" + mySign +" Misc\n" + myLine;
    }
}
