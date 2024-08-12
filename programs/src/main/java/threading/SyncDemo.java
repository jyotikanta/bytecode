package threading;

class MyData
{
    /*synchronized*/ public void display(int i)
    {
        System.out.println(i);
        /*for(int i=0;i<str.length();i++)
        {
            System.out.print(str.charAt(i));
           // try{Thread.sleep(100);}catch(Exception e){}
        }*/

    }
}

class MyThread1 extends Thread
{
    MyData d;
    public MyThread1(MyData d)
    {
        this.d=d;
    }

    public void run()
    {
        //d.display("Hello World");
        //synchronized (d){
            for(int i=1;i<100;i+=2)
                d.display(i);
        //}
    }


}

class MyThread2 extends Thread
{
    MyData d;
    public MyThread2(MyData d)
    {
        this.d=d;
    }

    public void run()
    {
        //synchronized (d){
            for(int i=2;i<100;i+=2)
                d.display(i);
        //}
        //d.display("Welcome All");
    }


}

public class SyncDemo
{
    public static void main(String[] args)
    {
        MyData data=new MyData();
        Thread thread = new Thread(()->{
            System.out.println("Hello World!");
        });

        MyThread1 t1=new MyThread1(data);
        MyThread2 t2=new MyThread2(data);

        t1.start();
        t2.start();
        thread.start();



    }
}