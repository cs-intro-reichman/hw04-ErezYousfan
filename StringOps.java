public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        
    }

    public static String capVowelsLowRest (String string) {
        // Write your code here:
        String vowels = "aeiouAEIOU";
        String newString = "";
        for (int i = 0; i < string.length(); i++) {
            boolean foundVowel = false;
            for (int j = 0; j < vowels.length(); j++) {
                if (vowels.charAt(j) == string.charAt(i)) {
                    foundVowel = true;
                    break;
                }
            }
            if (foundVowel && string.charAt(i) > 96)
                newString += (char) (string.charAt(i) - 32);

            else if (!foundVowel && string.charAt(i) < 91 && string.charAt(i) != ' ')
                    newString += (char) (string.charAt(i) + 32);
            
            else
                newString += (char) (string.charAt(i));
        }
        return newString;
    }

    /* Gets a string, returns the string with no spaces at its start*/
    public static String noSpacesAtStart(String string) {
        if (string.length() > 0) {
            int index = 0;
            while (string.charAt(index) == 32) {
                index++;
                if (index >= string.length())
                    break;
            }
            if (index < string.length())
                return string.substring(index);
        }
        return "";
    }

    /* Gets a string, returns the string with a lower case version of the first word in the string*/
    public static String doLowerCaseUnitilSpace(String string) {
        String newString = "";
        int i = 0;
        while (i < string.length() && string.charAt(i) != ' ') {
            if(string.charAt(i) < 91)
                newString += (char) (string.charAt(i) + 32);
            
            else
                newString += string.charAt(i);
            i++;
        }
        return newString;
    }

    /* Gets a string, returns the string without the first word in it */
    public static String jumpToNewWord(String string) {
        String newString = "";
        int i = 0;
        while (i < string.length() && string.charAt(i) != ' '){
            i++;
        }
        if (i < string.length())
            newString = string.substring(i);
        newString = noSpacesAtStart(newString);
        return newString;
    }

    public static String camelCase (String string) {
        String newString = "";
        String newSubString = noSpacesAtStart(string);
        if(newSubString.charAt(0) < ('Z' + 1))
            newString += (char) (newSubString.charAt(0) + 32);
        else
            newString += newSubString.charAt(0);
        newString += doLowerCaseUnitilSpace(newSubString.substring(1));
        newSubString = jumpToNewWord(newSubString);
        while(newSubString.length() > 1) {
            if(newSubString.charAt(0) > 96)
                newString += (char) (newSubString.charAt(0) - 32);
            
            else
                newString += newSubString.charAt(0);
            newString += doLowerCaseUnitilSpace(newSubString.substring(1));
            newSubString = jumpToNewWord(newSubString);
        }
        return newString;
    }

    public static int[] allIndexOf (String string, char chr) {
        int counter = 0;
        for(int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr)
                counter++;
        }
        int[] allIndexOf = new int[counter];
        int foundCounter = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == chr) {
                allIndexOf[foundCounter] = i;
                foundCounter++;
            }
        }
        return allIndexOf;
    }
}
