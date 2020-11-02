package anagrams;

import java.util.Arrays;
import java.util.Collections;

public class Anagrams {
    // Things to consider before starting
    //    - Ignore whitespaces
    //    -
    //
    // T
    // Approach #1: By Sorting
    public static boolean checkIfAnagrams1(String text1, String text2){

        // Remove whitespaces and uppercase
        String cleanText1 = text1.replace(" ","").toLowerCase();
        String cleanText2 = text2.replace(" ","").toLowerCase();
        if(cleanText1.length()!=cleanText2.length()) return false;

        // Sort characters
        char[] text1Chars = cleanText1.toCharArray();
        char[] text2Chars = cleanText2.toCharArray();
        Arrays.sort(text1Chars);
        Arrays.sort(text2Chars);
        System.out.println(new String(text1Chars));
        System.out.println(new String(text2Chars));

        // Compare
        boolean isAnagram = Arrays.equals(text1Chars,text2Chars);
        return isAnagram;
    }
    // "eeikmnorstwy","eeikmnorstwy"

    // Approach #2: Counting
    // Time efficiency: O(n)
    public static boolean checkIfAnagrams2(String text1, String text2){

        // Remove whitespaces and uppercase
        String cleanText1 = text1.replace(" ","").toLowerCase();
        String cleanText2 = text2.replace(" ","").toLowerCase();
        if(cleanText1.length()!=cleanText2.length()) return false;

        // Array to keep track of counting
        int ALL_POSSIBLE_ASCII_CHARACTER = 256;
        int[] count = new int[ALL_POSSIBLE_ASCII_CHARACTER];
        for(int i=0;i<cleanText1.length();i++){
            count[cleanText1.charAt(i)]++;
            count[cleanText2.charAt(i)]--;
        }

        // If any count is not 0, the sentences are not an anagram
        for(int countForOneCharacter:count){
            if (countForOneCharacter!=0){
                return false;
            }
        }
        return true;
    }
    // Approach #3: Using checksum
    public static boolean checkIfAnagrams3(String text1,String text2){

        // Remove whitespaces and uppercase
        String cleanText1 = text1.replace(" ","").toLowerCase();
        String cleanText2 = text2.replace(" ","").toLowerCase();
        if(cleanText1.length()!=cleanText2.length()) return false;

        // Sum up the value of all characters
        int sum1 = 0;
        int sum2 = 0;
        for(int i=0;i<cleanText1.length();i++){
            sum1=sum1+(int)cleanText1.charAt(i);
            sum2=sum2+(int)cleanText2.charAt(i);
        }
        return sum1==sum2;
    }

    public static final void main(String[] args){
        boolean isAnagram1 = checkIfAnagrams1("New York Times","monkeys write");
        System.out.println("New York Times, monkeys write : Anagrams? => "+isAnagram1);

        boolean isAnagram2 = checkIfAnagrams1("McDonald's restaurants",  "Uncle Sam's standard rot");
        System.out.println("McDonald's restaurants, Uncle Sam's standard rot : Anagrams? => "+isAnagram2);

        boolean isAnagram3 = checkIfAnagrams1("Rocket Boys",  "October Sky");
        System.out.println("Rocket Boys,  October Sky : Anagrams? => "+isAnagram3);

    }
}
