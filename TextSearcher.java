import javax.imageio.IIOException;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The main program - A text searching module that indexes and queries large corpuses for strings or word groups
 */
public class TextSearcher {
    private enum INDEXER {DICT, NAIVE, NAIVE_RK, SUFFIX_TREE}
    private enum PARSE_RULE {SIMPLE, ST_MOVIE, ST_TV}

    /**
     * Main method. Reads and parses a command file and if a query exists, prints the results.
     *
     * @param args
     */
    public static void main(String[] args) throws IIOException {
        File file = new File(args[0]);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String readLine = reader.readLine();
            if (!readLine.equals("CORPUS")) {
                    /**exception*/
            }
            readLine = reader.readLine(); //link

            readLine = reader.readLine();
            if (!readLine.equals("INDEXER")) {
                    /**exception*/
            }
            readLine = reader.readLine();
            switch(INDEXER.valueOf(readLine)){
                case DICT:
                    /**TODO*/
                    break;
                case NAIVE:
                    /**TODO*/
                    break;
                case NAIVE_RK:
                    break;
                case SUFFIX_TREE:
                    break;
                default:
                    /**exception*/
                }
            readLine = reader.readLine();
            if (readLine.equals("PARSE_RULE")) {
                /**exception*/
                }
            switch(PARSE_RULE.valueOf(readLine)){
                case ST_TV:
                    /**TODO*/
                    break;
                case SIMPLE:
                    /**TODO*/
                    break;
                case ST_MOVIE:
                    break;
                default:
                    /**exception*/
            }
            readLine = reader.readLine();
            if (readLine.equals("QUERY")) {
                /**exception*/
            }
            String S = "";
            String S2 = "";
            String testString = "fghj#QUICK#CASE";
            Pattern p = Pattern.compile("[\\w]+[\\w|\\s]*((#QUICK|#CASE)|#QUICK#CASE|$)");//" n#QUICK" to ask
            Matcher m = p.matcher(testString);
            System.out.println(m.matches());
            Pattern p1 = Pattern.compile("((#QUICK|#CASE)|#QUICK#CASE)|$");
            Matcher m1 = p1.matcher(testString);
            while (m1.find()) {
                int start = m1.start();
                int end=m1.end();
                S += testString.substring(start,end);

                S2 = testString.substring(0,start);
                System.out.println(start);
            }
            System.out.println(S);
            System.out.println(S2);

            if (S.equals("#QUICK")){
                System.out.println("1");
            }
            if (S.equals("#CASE")){
                System.out.println("2");
            }
            if (S.equals("#QUICK#CASE")){
                System.out.println("3");
            }
            if (S == ""){
                System.out.println("4");
            }

        }
            } catch (IOException e1) {
            e1.printStackTrace();
        }


    }
}
