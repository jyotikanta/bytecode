package threading.atm;

public class ATMDemo{
    public static void main(String[] args) {
        ATM atm = new ATM();
        Customer c1 = new Customer("John", 100, atm);
        Customer c2 = new Customer("Cena", 200, atm);
        Thread t1 = new Thread(c1);
        Thread t2 = new Thread(c2);
        t1.start();
        t2.start();
    }
}
