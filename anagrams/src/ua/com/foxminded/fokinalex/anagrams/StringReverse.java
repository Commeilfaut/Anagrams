package ua.com.foxminded.fokinalex.anagrams;

public class StringReverse {

    public String reverseAlphabeticCharsOnly(String str) {

        StringBuilder resultStrings = new StringBuilder();
        String[] splitWords = str.split("[\\s]");
        for (String words : splitWords) {
            resultStrings.append(reversesWord(words));
        }

        //the text contains spaces in the main class
        for (int i = 0; i < str.length(); i++) {
            if (Character.isWhitespace(str.charAt(i))) {
                resultStrings.insert(i, str.charAt(i));
            }
        }
        return resultStrings.toString();

    }

    public String reversesWord(String word) {

        String alphabetic = word.replaceAll("[\\W\\d]", "");
        StringBuilder result = new StringBuilder(alphabetic);
        result.reverse();

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isLetter(word.charAt(i))) {

                result.insert(i, word.charAt(i));
            }
        }
        return result.toString();
    }


}