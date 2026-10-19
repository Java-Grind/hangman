import static java.util.Arrays.*;
public final Scanner scanner = new Scanner(System.in);

void main() {
    IO.println(String.format("Hello and welcome!"));

    String original = "Hangman";
    String[] askedWordUnderlines = new String[original.length()];


    for(int i = 0; i < original.length(); i++) {
        askedWordUnderlines[i] = "_ ";
    }

    boolean isGame = game(original, askedWordUnderlines);
    while(isGame) {
        // System.out.println(original);
        printUnderlinesAsked(askedWordUnderlines);

        isGame = game(original, askedWordUnderlines);
        printUnderlinesAsked(askedWordUnderlines);
    }

}

private boolean game(String original, String[] askedWordUnderlines) {

    int guessed = 0;
    int shouldBeGuessed = original.length();
    char attempt = ' ';

    while (guessed < shouldBeGuessed) {

        System.out.print("Enter char: ");
        attempt = scanner.next().charAt(0);

        if(original.contains(String.valueOf(attempt))) {
            for (int i = 0; i < original.length(); i++) {
                if (original.charAt(i) == attempt) {
                    askedWordUnderlines[i] = String.valueOf(attempt);
                    guessed++;
                    printUnderlinesAsked(askedWordUnderlines);
                }
            }
        }
    }
    if (guessed == shouldBeGuessed) {
        System.out.print("Finish, thanks for playing!");
        return false;
    }
    else {
        return true;
    }
}

void printUnderlinesAsked(String[] askedWordUnderlines)
{
    for (String letter : askedWordUnderlines) {
        System.out.print(letter + " ");
    }
    System.out.println();
}