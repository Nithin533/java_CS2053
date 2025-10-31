 // Implement Producer, Consumer problem using Thread in Java.
class Buffer {
    private int data;
    private boolean available = false;

    
    public synchronized void produce(int value) {
        while (available) {
            try {
                wait(); // wait if data is already available
            } catch (InterruptedException e) { }
        }
        data = value;
        available = true;
        System.out.println("Produced: " + value);
        notify(); // notify consumer
    }

   
    public synchronized void consume() {
        while (!available) {
            try {
                wait(); // wait if data is not available
            } catch (InterruptedException e) { }
        }
        System.out.println("Consumed: " + data);
        available = false;
        notify(); // notify producer
    }
}

class Producer extends Thread {
    Buffer buffer;

    Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.produce(i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) { }
        }
    }
}

class Consumer extends Thread {
    Buffer buffer;

    Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    public void run() {
        for (int i = 1; i <= 5; i++) {
            buffer.consume();
            try {
                Thread.sleep(800);
            } catch (InterruptedException e) { }
        }
    }
}

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();
        Producer p = new Producer(buffer);
        Consumer c = new Consumer(buffer);
        p.start();
        c.start();
    }
}
