import java.util.Scanner;

public class ArrayDeQueue {
    protected int capacity;
    protected int[] queue;
    protected int front = -1;
    protected int rear = -1;

    // Constructor to initialize the queue with a given capacity
    public ArrayDeQueue(int cap) {
        capacity = cap;
        queue = new int[capacity];
    }

    // Method to get the current size of the queue
    public int size() {
        return (rear - front + 1);
    }

    // Method to insert an element at the rear of the queue
    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Overflow. Not possible to insert in Full Queue.");
        } else {
            if (front == -1) {
                front = 0; // Set front to 0 if it's the first element
            }
            queue[++rear] = data;
        }
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (size() == capacity);
    }

    // Method to remove an element from the front of the queue
    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Underflow. No elements to dequeue.");
            return -1; // Indicate that no element was dequeued
        } else {
            int data = queue[front];
            if (front == rear) {
                front = rear = -1; // Reset queue when it's empty after dequeuing
            } else {
                front++; // Move the front pointer forward
            }
            return data;
        }
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (front == -1);
    }

    // Method to display the elements in the queue
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is Underflow. No elements to display in Empty Queue.");
        } else {
            System.out.println("Queue Elements:");
            for (int i = front; i <= rear; i++) {
                System.out.print(queue[i] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("DeQueue Using Array");

        // Asking user to input the size of the queue
        System.out.print("Enter the number of elements to be inserted: ");
        int n = sc.nextInt();

        // Creating queue with given size
        ArrayDeQueue q = new ArrayDeQueue(n);
        System.out.println("Queue Using Array created with size " + n);

        // Insert elements into the queue
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            int data = sc.nextInt();
            q.enQueue(data);
        }

        // Displaying the queue
        q.display();

        // Asking the user whether they want to dequeue
        System.out.print("Do you want to Dequeue the Queue (y/n): ");
        char ch = sc.next().charAt(0);

        // Process dequeuing based on user input
        while (ch == 'y' || ch == 'Y') {
            int dequeuedData = q.deQueue();
            if (dequeuedData != -1) {
                System.out.println("Dequeued element: " + dequeuedData);
            }
            q.display();
            System.out.print("Do you want to Dequeue again (y/n): ");
            ch = sc.next().charAt(0);
        }

        sc.close();
    }
}
