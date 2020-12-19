package vendingmachine.step3;

public class VendingMachineRequest {
    public Product product;
    public CoinBundle enteredCoins;

    public VendingMachineRequest(int selectedProduct,int... enteredCoins){
        this.product = Product.valueOf(selectedProduct);
        this.enteredCoins = new CoinBundle(enteredCoins);
    }
}
