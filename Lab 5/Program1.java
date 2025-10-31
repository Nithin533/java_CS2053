// Table Printer Write a program where two threads try to print the multiplication table of a number (say 5). 
// Without synchronization, outputs may mix. Add synchronized so that one thread completes the full table before the other starts.

class Table {
   
    synchronized void printTable(int n) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " x " + i + " = " + (n * i));
            try {
                Thread.sleep(500); 
            } catch (InterruptedException e) { }
        }
        System.out.println("------ Table of " + n + " completed ------");
    }
}

class MyThread1 extends Thread {
    Table t;
    MyThread1(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}

class MyThread2 extends Thread {
    Table t;
    MyThread2(Table t) {
        this.t = t;
    }
    public void run() {
        t.printTable(5);
    }
}

public class TablePrinter {
    public static void main(String[] args) {
        Table obj = new Table();

        MyThread1 t1 = new MyThread1(obj);
        MyThread2 t2 = new MyThread2(obj);

        t1.start();
        t2.start();
    }
}
