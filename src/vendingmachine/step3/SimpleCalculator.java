package vendingmachine.step3;

public class SimpleCalculator implements Calculator{

    @Override
    public int calculateTotal(CoinBundle enteredCoins) {
        return enteredCoins.getTotal();
    }

    @Override
    public CoinBundle calculateChange(int amountMoneyToReturn) {
        CoinBundle change = new CoinBundle(new int[5]);
        int remainingAmount = amountMoneyToReturn;
        change.number100CentsCoins = remainingAmount / Coin.HUNDRED_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.HUNDRED_CENTS.getValue();

        change.number50CentsCoins = remainingAmount / Coin.FIFTY_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.FIFTY_CENTS.getValue();

        change.number20CentsCoins = remainingAmount / Coin.TWENTY_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.TWENTY_CENTS.getValue();

        change.number10CentsCoins = remainingAmount / Coin.TEN_CENTS.getValue();
        remainingAmount = remainingAmount % Coin.TEN_CENTS.getValue();

        change.number5CentsCoins = remainingAmount / Coin.FIVE_CENTS.getValue();


        return change;
    }
}
