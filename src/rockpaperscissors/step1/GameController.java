package rockpaperscissors.step1;

public interface GameController {

    String welcomeMessage();

    String pleaseEnterOptionMessage();

    void selectUserChoice(GameOption userOption);

    GameOption randomMachineChoice();

    Player calculateResult();

    Score getResults();

}
