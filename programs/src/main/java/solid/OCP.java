package solid;

interface PaymentProcessor{
    public void processPayment(double amount);
}

class CreditCardProcessor implements PaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Credit card debited.");
    }
}

class PayPalProcessor implements PaymentProcessor{

    @Override
    public void processPayment(double amount) {
        System.out.println("Debited from paypal ID.");
    }
}

class ProcessPayment{
    PaymentProcessor paymentProcessor;

    public ProcessPayment(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void processPayment(double amt){
        paymentProcessor.processPayment(amt);
    }
}

public class OCP {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new CreditCardProcessor();
        ProcessPayment processPayment = new ProcessPayment(paymentProcessor);
        processPayment.processPayment(100);

        paymentProcessor = new PayPalProcessor();
        processPayment = new ProcessPayment(paymentProcessor);
        processPayment.processPayment(150);
    }


}
