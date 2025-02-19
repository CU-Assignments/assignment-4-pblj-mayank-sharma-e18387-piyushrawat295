package Hard;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class TicketBookingSystem {
    private static int availableSeats = 5;
    private static final Lock lock = new ReentrantLock();

    static class BookingThread extends Thread {
        private String customerName;
        private boolean isVIP;

        public BookingThread(String customerName, boolean isVIP) {
            this.customerName = customerName;
            this.isVIP = isVIP;
            if (isVIP) {
                setPriority(MAX_PRIORITY);
            }
        }

        @Override
        public void run() {
            bookTicket();
        }

        private void bookTicket() {
            lock.lock();
            try {
                if (availableSeats > 0) {
                    System.out.println(customerName + " successfully booked a seat.");
                    availableSeats--;
                } else {
                    System.out.println("Sorry, " + customerName + ", no seats available.");
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new BookingThread("Alice", false);
        Thread t2 = new BookingThread("Bob", true);  // VIP
        Thread t3 = new BookingThread("Charlie", false);
        Thread t4 = new BookingThread("David", true); // VIP
        Thread t5 = new BookingThread("Eve", false);
        Thread t6 = new BookingThread("Frank", true); // VIP

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}
