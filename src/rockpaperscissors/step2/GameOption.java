package rockpaperscissors.step2;

public enum GameOption {
    ROCK(1,2), PAPER(2,3), SCISSOR(3,1),EMPTY(-1,-1);
    
    private int id;
    private int winBy;

    GameOption(int id, int winBy){

        this.id = id;
        this.winBy = winBy;
    }

    public static GameOption valueOf(int userEnteredOption){
        for(GameOption option: GameOption.values()){
            if(userEnteredOption ==option.id){
                return option;
            }
        }
        return EMPTY;
    }

    public boolean isWinBy(GameOption option){
        return this.winBy == option.id;
    }
}
