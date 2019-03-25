import java.util.Scanner;

public class Lab2 {



    public static void lab2(String[] args) {
        boolean debug = false;
        if (args != null) {
            boolean help = false;
            for (String i : args) {
                if (i.equals("-h") || i.equals("-help")) {
                    help = true;
                }
                if (i.equals("-d") || i.equals("-debug")) {
                    debug = true;
                }
            }
            if (help) {
                Help.help();
            }
        }
        Scanner in = new Scanner(System.in);
        String text = null;
        StringBuilder words = null;
        while (true) {
            System.out.println("///==---==\\\\\\");
            System.out.println("1 - input");
            System.out.println("2 - show input");
            System.out.println("3 - calculate");
            System.out.println("4 - show result");
            System.out.println("5 - exit");
            byte command = in.nextByte();
            switch (command) {
                case 1:
                    if (debug)
                        Debug.debug(text, words);
                    System.out.println("input your text:");
                    in.nextLine();
                    text = in.nextLine() + " ";
                    words = null;
                    if (debug)
                        Debug.debug(text, words);
                    break;
                case 2:
                    if (debug)
                        Debug.debug(text, words);
                    if (text != null)
                        System.out.println("you've entered:\n" + text);
                    else
                        System.out.println("error! input first!");
                    break;
                case 3:
                    if (debug)
                        Debug.debug(text, words);
                    if (text != null) {
                        words = new StringBuilder();
                        int counter = 0, wordStart = 0;
                        boolean word = false;
                        while (counter != text.length()) {
                            if ((Character.isAlphabetic(text.charAt(counter))) && !word) {
                                wordStart = counter;
                                word = true;
                            }
                            else if (!Character.isAlphabetic(text.charAt(counter)) && word) {
                                words.append(text, wordStart, counter);
                                words.append(" ");
                                word = false;
                            }
                            counter++;
                        }
                        System.out.println("done!");
                    }
                    else
                        System.out.println("error! input first!");
                    if (debug)
                        Debug.debug(text, words);
                    break;
                case 4:
                    if (debug)
                        Debug.debug(text, words);
                    if (words != null) {
                        System.out.println(words);
                    }
                    else
                        System.out.println("error! calculate first!");
                    if (debug)
                        Debug.debug(text, words);
                    break;
                case 5:
                    if (debug)
                        Debug.debug(text, words);
                    System.out.println("bye!");
                    System.exit(0);
                default:
                    System.out.println("unknown command.");
            }
        }


    }
}
