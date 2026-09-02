import java.util.Scanner;

class LinearQueue {
    private int[] queue;
    private int front, rear, capacity;

    public LinearQueue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = -1;
        rear = -1;
    }

    public boolean isFull() {
        return rear == capacity - 1;
    }

    public boolean isEmpty() {
        return front == -1 || front > rear;
    }

    public void enqueue(int id) {
        if (isFull()) {
            System.out.println("Queue is Full!");
            return;
        }
        if (front == -1) front = 0;
        queue[++rear] = id;
        System.out.println("Customer " + id + " joined the line.");
    }

    public void dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty!");
            return;
        }
        System.out.println("Customer " + queue[front] + " served.");
        front++;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }
        System.out.print("Queue: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class RailwayReservationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter queue capacity: ");
        int capacity = scanner.nextInt();
        LinearQueue q = new LinearQueue(capacity);
        
        int choice;
        do {
            System.out.println("\n1. Enqueue  2. Dequeue  3. Display  4. Exit");
            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Customer ID: ");
                    q.enqueue(scanner.nextInt());
                    break;
                case 2:
                    q.dequeue();
                    break;
                case 3:
                    q.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
