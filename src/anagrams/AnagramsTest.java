package anagrams;

import org.junit.Assert;
import org.junit.Test;

public class AnagramsTest {

    @Test
    public void testSentencesThatAreAnagrams(){
        boolean isAnagram1 = Anagrams.checkIfAnagrams1("New York Times","monkeys write");
        Assert.assertTrue(isAnagram1);

        boolean isAnagram2 =  Anagrams.checkIfAnagrams1("McDonald's restaurants",  "Uncle Sam's standard rot");
        Assert.assertTrue(isAnagram2);

        boolean isAnagram3 =  Anagrams.checkIfAnagrams1("Rocket Boys",  "October Sky");
        Assert.assertTrue(isAnagram3);
    }

    @Test
    public void testSentencesThatAreNotAnagrams(){
        boolean isAnagram1 = Anagrams.checkIfAnagrams1("Hey there","How are you?");
        Assert.assertFalse(isAnagram1);
    }
}
