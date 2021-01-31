package rockpaperscissors.step2;

public class Score {
    private int gamesWonByUser;
    private int totalNumberGames;

    public void incrementGamesWonByUser(){
        gamesWonByUser++;
    }

    public void incrementTotalNumberGames(){
        totalNumberGames++;
    }

    public int totalNumberOfGames(){
        return totalNumberGames;
    }

    public int getGamesWonByUser(){
        return gamesWonByUser;
    }
}
