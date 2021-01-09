package duplicatedcharacters;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class RepeatedCharacters {

    public static void main(String[] args){

        // Generate a long string
        StringBuilder stringBuilder = new StringBuilder();
        for(int i=0;i<1000;i++){
            stringBuilder.append("abcde12345");

        }
        String exampleString = stringBuilder.toString();

        // Measure each approach
        long startTime = System.currentTimeMillis();
        int count = countRepeatedCharactersHashMap(exampleString).get('d');
        System.out.println("Time Using HashMap: "+(System.currentTimeMillis()-startTime)+ " millisec");

        startTime = System.currentTimeMillis();
        count = countRepeatedCharacters(exampleString,'d');
        System.out.println("Time Using Length: "+(System.currentTimeMillis()-startTime)+ " millisec");

        startTime = System.currentTimeMillis();
        count = countRepeatedCharactersWithJava8(exampleString,'d');
        System.out.println("Time Using Java 8: "+(System.currentTimeMillis()-startTime)+ " millisec");


        startTime = System.currentTimeMillis();
        count = countRepeatedCharactersUsingRecursion(exampleString,'d');
        System.out.println("Time Using Recursion: "+(System.currentTimeMillis()-startTime));
    }

    public static Map<Character, Integer> countRepeatedCharactersHashMap(String text){
        Map<Character, Integer> count = new HashMap<>();
        for(Character character: text.toCharArray()){
            if(count.get(character)!=null){
                int currentCount = count.get(character)+1;
                count.put(character,currentCount);
            }else{
                count.put(character,1);
            }
        }

        return count;
    }

    public static int countRepeatedCharacters(String text, char character){
        String removedRepeated = text.replace(String.valueOf(character),"");
        int count = text.length() - removedRepeated.length();
        return count;
    }

    public static int countRepeatedCharactersUsingRecursion(String text,char character){
        if(text.length()==1){
            if(character == text.charAt(0)){
                return 1;
            }else{
                return 0;
            }
        }else{
            String part1= text.substring(0,text.length()-1);
            String part2 = text.substring(text.length()-1);
            return countRepeatedCharactersUsingRecursion(part1,character)+
                    countRepeatedCharactersUsingRecursion(part2,character);
        }
    }

    public static int countRepeatedCharactersWithJava8(String text, char character){
        return (int) text.chars().filter(c-> c==character).count();

    }
}
