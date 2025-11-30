public class CreditCardPayment implements Payment {

    @Override
    public boolean pay(double amount) {
        System.out.println("Paying amount " + amount + " using credit card");
        // Simulate success/failure as needed
        return true;
    }

    @Override
    public boolean refund(double amount) {
        System.out.println("Refunded amount " + amount);
        return true;
    }
}
