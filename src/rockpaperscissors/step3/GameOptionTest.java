package rockpaperscissors.step3;

import org.junit.Assert;
import org.junit.Test;

public class GameOptionTest {

    @Test
    public void test1(){
        Assert.assertTrue(GameOption.ROCK.isWinBy(GameOption.PAPER));
        Assert.assertTrue(GameOption.PAPER.isWinBy(GameOption.SCISSOR));
        Assert.assertTrue(GameOption.SCISSOR.isWinBy(GameOption.ROCK));

        Assert.assertFalse(GameOption.ROCK.isWinBy(GameOption.SCISSOR));
        Assert.assertFalse(GameOption.SCISSOR.isWinBy(GameOption.PAPER));

        Assert.assertTrue(GameOption.valueOf(1).equals(GameOption.ROCK));
        Assert.assertTrue(GameOption.valueOf(2).equals(GameOption.PAPER));
        Assert.assertTrue(GameOption.valueOf(3).equals(GameOption.SCISSOR));
    }
}
