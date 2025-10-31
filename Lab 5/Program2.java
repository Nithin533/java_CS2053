class MessageSender  {

    
    synchronized void sendMessage(String msg) {
        System.out.print("[ " + msg);  
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {  
            System.out.println(e);
        }
        System.out.println(" ]");
    }
}

class MyThread1 extends Thread {
    MessageSender sender;

    MyThread1(MessageSender sender) {
        this.sender = sender;
    }

    public void run() {
        sender.sendMessage("Hello Harsha");
    }
}

class MyThread2 extends Thread {
    MessageSender sender;

    MyThread2(MessageSender sender) {
        this.sender = sender;
    }

    public void run() {
        sender.sendMessage("Welcome to Java Threads"); 
    }
}

public class MessageDemo {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        MyThread1 t1 = new MyThread1(sender);
        MyThread2 t2 = new MyThread2(sender);

        t1.start();
        t2.start();  
    }
}
