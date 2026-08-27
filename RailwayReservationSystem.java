import java.util.Scanner;

/**
 * Railway Ticket Counter Simulation using an Array-based Linear Queue.
 */
class LinearQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int capacity;

    // Constructor to initialize the queue
    public LinearQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    // Check if the queue is full
    public boolean isFull() {
        return rear == capacity - 1;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    // Enqueue: Add a customer (Ticket ID / Customer ID) to the end of the line
    public void enqueue(int customerId) {
        if (isFull()) {
            System.out.println(" Queue Full! Ticket Counter line is at capacity. Cannot add Customer " + customerId);
            return;
        }
        if (front == -1) {
            front = 0; // Initialize front on first insertion
        }
        rear++;
        queue[rear] = customerId;
        System.out.println(" Enqueued: Customer " + customerId + " joined the line.");
    }

    // Dequeue: Serve and remove the customer at the front of the line
    public int dequeue() {
        if (isEmpty()) {
            System.out.println(" Queue Empty! No customers waiting to be served.");
            return -1;
        }
        int servedCustomer = queue[front];
        front++;
        System.out.println(" Dequeued: Customer " + servedCustomer + " has been served and left the line.");
        return servedCustomer;
    }

    // Peek: View the customer currently at the front of the line
    public void peek() {
        if (isEmpty()) {
            System.out.println(" Queue Empty! No customer at the front.");
            return;
        }
        System.out.println(" Peek: Customer " + queue[front] + " is next to be served.");
    }

    // Display: View all customers currently waiting in line
    public void display() {
        if (isEmpty()) {
            System.out.println(" Current Queue: [ Empty ]");
            return;
        }
        System.out.print(" Current Queue (Front to Rear): [ ");
        for (int i = front; i <= rear; i++) {
            System.out.print("Customer " + queue[i] + (i == rear ? "" : ", "));
        }
        System.out.println(" ]");
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter maximum seating capacity for the ticket queue: ");
        int capacity = scanner.nextInt();

        LinearQueue ticketQueue = new LinearQueue(capacity);
        int choice;

        do {
            System.out.println("\n--- RAILWAY TICKET COUNTER MENU ---");
            System.out.println("1. Enqueue (Add Customer)");
            System.out.println("2. Dequeue (Serve Customer)");
            System.out.println("3. Peek (Check Front Customer)");
            System.out.println("4. Display Line");
            System.out.println("5. Exit");
            System.out.print("Enter your choice (1-5): ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer/Ticket ID to Enqueue: ");
                    int id = scanner.nextInt();
                    ticketQueue.enqueue(id);
                    break;
                case 2:
                    ticketQueue.dequeue();
                    break;
                case 3:
                    ticketQueue.peek();
                    break;
                case 4:
                    ticketQueue.display();
                    break;
                case 5:
                    System.out.println("Closing ticket counter. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Please select 1-5.");
            }
        } while (choice != 5);

        scanner.close();
    }
}