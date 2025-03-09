import java.util.*;

public class ArrayDeQueue {
    protected int capacity;
    protected int[] queue;
    protected int front = -1;
    protected int rear = -1;

    // Constructor to initialize the queue
    public ArrayDeQueue(int cap) {
        capacity = cap;
        queue = new int[capacity];
    }

    // Method to return the current size of the queue
    public int size() {
        if (isEmpty()) {
            return 0;
        }
        return (rear - front + 1);
    }

    // Method to insert an element into the queue (enqueue)
    public void enQueue(int data) {
        if (isFull()) {
            System.out.println("Queue is Overflow. Not possible to insert in Full Queue.");
        } else {
            if (front == -1) { // If the queue is empty, initialize front and rear
                front = 0;
            }
            queue[++rear] = data;
        }
    }

    // Method to check if the queue is full
    public boolean isFull() {
        return (rear == capacity - 1);
    }

    // Method to remove an element from the queue (dequeue)
    public int deQueue() {
        int data = -1;
        if (isEmpty()) {
            System.out.println("Queue is Underflow. No elements to be deleted in Empty Queue.");
        } else {
            data = queue[front++];
            // Reset front and rear to -1 when the queue is empty
            if (front > rear) {
                front = rear = -1;
            }
        }
        return data;
    }

    // Method to check if the queue is empty
    public boolean isEmpty() {
        return (front == -1);
    }

    // Method to display the elements of the queue
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

    // Main method to test the queue functionality
    public static void main(String[] args) {
        int data, n;
        char ch;
        Scanner sc = new Scanner(System.in);

        System.out.println("DeQueue Using Array");
        System.out.println("Enter the number of elements to be inserted:");
        n = sc.nextInt();

        ArrayDeQueue q = new ArrayDeQueue(n);
        
        // Enqueue elements from 1 to n
        for (int i = 1; i <= n; i++) {
            q.enQueue(i);
        }

        System.out.println("Queue Using Array created with size " + n);
        q.display();

        // Dequeue elements if the user wants
        System.out.println("Do you want to Dequeue the Queue(y/n):");
        ch = sc.next().charAt(0);

        if (ch == 'y') {
            do {
                data = q.deQueue();
                if (data != -1) {
                    System.out.println("Deleted Element is: " + data);
                    System.out.println("After Dequeue:");
                    q.display();
                }
                System.out.println("Do you want to Dequeue the Queue(y/n):");
                ch = sc.next().charAt(0);
            } while (ch != 'n');
        }
        sc.close();
    }
}
