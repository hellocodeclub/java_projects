package vendingmachine.step2;

public interface VendingMachineController {

    CoinBundle calculateChange(VendingMachineRequest request);
}
