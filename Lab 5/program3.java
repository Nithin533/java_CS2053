class TicketBooking {
    private int ticketsAvailable = 5;  
  
    
    synchronized void bookTicket(String user) {
        if (ticketsAvailable > 0) {  
            System.out.println(user + " booked ticket number " + ticketsAvailable);
            ticketsAvailable--;  
            try {
                Thread.sleep(500);    
            } catch (InterruptedException e) {  
                System.out.println(e);
            }
        } else {
            System.out.println("Sorry " + user + ", tickets are sold out!");
        }
    }
}

class User extends Thread {
    TicketBooking bookingSystem;
    String userName;

    User(TicketBooking bookingSystem, String userName) {
        this.bookingSystem = bookingSystem;
        this.userName = userName;
    }

    public void run() {
        bookingSystem.bookTicket(userName);  
    }
}

public class TicketBookingDemo {
    public static void main(String[] args) {
        TicketBooking system = new TicketBooking();

        // creating multiple users (threads)
        User u1 = new User(system, "User1");
        User u2 = new User(system, "User2");
        User u3 = new User(system, "User3");
        User u4 = new User(system, "User4");
        User u5 = new User(system, "User5");
        User u6 = new User(system, "User6");

        // start all threads
        u1.start();
        u2.start();
        u3.start();
        u4.start();
        u5.start();
        u6.start();
    }
}
