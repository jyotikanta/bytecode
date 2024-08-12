package threading.atm;

class Customer implements Runnable {
    String name;
    double amount;
    ATM atm;

    public Customer(String name, double amount, ATM atm) {
        this.name = name;
        this.amount = amount;
        this.atm = atm;
    }

    @Override
    public void run(){
        useATM();
    }

    public void useATM(){
        synchronized(atm){
            atm.checkBalance(this.name);
            atm.withdraw(this.name,this.amount);
        }

    }
}
