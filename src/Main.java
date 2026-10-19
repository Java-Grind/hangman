void main() {
    IO.println(String.format("Hello and welcome!"));

    var scanner = new Scanner(System.in);

    String original = "Hangman";
    List<String> askedWordByChars = new ArrayList<>();
    String[] askedWordUnderlines = original.split(" ");

    for(int i = 0; i < original.length() * 2; i++) {
        System.out.print("Original: " + original);
        System.out.println("\tUnderlines: " + askedWordUnderlines.toString());
        System.out.print("Orginial.length()" + original.length());

        if(askedWordUnderlines[i] == " " || askedWordUnderlines[i] == "_") {
            askedWordUnderlines[i] = "_";
        }
    }

    System.out.println(original);
    System.out.println(askedWordUnderlines);

    int letterUnclocked = 0;
    char guessLetter = ' ';

    fillAskedWordList(original, askedWordByChars);

    while(isGame(letterUnclocked, original.length()))
    {
        System.out.print("Guess the word: ");
        String termInput = scanner.next();

        if(termInput.length() > 1 || termInput.isEmpty()) {
            System.out.print("\nPlease enter a LETTER again: ");
            termInput = scanner.next();
        }
        else {
            if (original.contains(termInput)) {
                int n =  original.indexOf(termInput);
                askedWordUnderlines[n] = termInput;
            }

        }

        guessLetter = (termInput).charAt(0);


    }
}

boolean isGame(int letterUnclocked, int askedWordLength) {

    if (letterUnclocked <= askedWordLength) {
        return true;
    }
    return false;
}

void fillAskedWordList(String askedWord, List<String> askedWordByChars) {
    for(int i = 0; i < askedWord.length(); i++) {
        askedWordByChars.add(askedWord.charAt(i) + "");
    }
}