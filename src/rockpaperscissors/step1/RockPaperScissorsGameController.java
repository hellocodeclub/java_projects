package rockpaperscissors.step1;

public class RockPaperScissorsGameController implements GameController {

    private GameOption userChoice = GameOption.EMPTY;
    private GameOption machineChoice = GameOption.EMPTY;
    private Score totalScore = new Score();


    @Override
    public String welcomeMessage() { return null; }

    @Override
    public String pleaseEnterOptionMessage(){
        return  null;
    }

    @Override
    public void selectUserChoice(GameOption userOption) { }

    @Override
    public GameOption randomMachineChoice() {
       return null;
    }

    @Override
    public Player calculateResult() {
        return null;
    }

    @Override
    public Score getResults() {
        return null;
    }

}
