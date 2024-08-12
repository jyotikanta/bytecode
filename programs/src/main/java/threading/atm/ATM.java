package threading.atm;

class ATM {
    public void checkBalance(String name){
        System.out.print(name + " Checking Balance ");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//
//        }
        System.out.println(name + "'s 1000");
    }

    public void withdraw(String name, double amt){
        System.out.print(name + " Withdrawing amount ");
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//
//        }
        System.out.println(amt);
    }
}
