package vendingmachine.step2;


import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        VendingMachineInterface machineInterface = null; //TODO

        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();

        int[] enteredCoins = {};
        machineInterface.enterCoins(enteredCoins);

        machineInterface.displayChangeMessage();

    }
}
