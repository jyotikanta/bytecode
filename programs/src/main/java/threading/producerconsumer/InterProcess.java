package threading.producerconsumer;

class Data {
    int val;

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }
}

class Producer implements Runnable{
    Data data;
    public Producer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {

    }
}

class Consumer implements Runnable{
    Data data;

    public Consumer(Data data) {
        this.data = data;
    }

    @Override
    public void run() {

    }
}

public class InterProcess{

}
