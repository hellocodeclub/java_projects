package vendingmachine.step2;


public class VendingMachineRequest {
    public Product product;
    public CoinBundle enteredCoins;

    public VendingMachineRequest(int selectedProduct, int... enteredCoins){
        // TODO Complete in step 3
        this.product = null;
        this.enteredCoins = new CoinBundle(enteredCoins);
    }
}
