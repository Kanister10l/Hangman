/**
 * Created by szymank5 on 13.05.2017.
 */
public class WordChecker {

    public static boolean checkTheWord(String word, char mark ){

        for( int i = 0 ; i < word.length() ; i++) {

            if(mark == word.charAt(i))
                return true;
        }

        return false;
    }
}
