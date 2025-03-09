import java.util.*;

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
        int data = -1;
        if (isEmpty()) {
            System.out.println("Queue is Underflow. No elements to be deleted in Empty Queue.");
        } else {
            data = queue[front];
            if (front == rear) {
                front = rear = -1; // Reset queue when it's empty after dequeuing
            } else {
                front++; // Move the front pointer forward
            }
        }
        return data;
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
        int data, n;
        char ch;

        Scanner sc = new Scanner(System.in);
        System.out.println("DeQueue Using Array");
        System.out.print("Enter the number of elements to be inserted: ");
        n = sc.nextInt();
        ArrayDeQueue q = new ArrayDeQueue(n);   

        // Enqueue elements into the queue
        for (int i = 1; i <= n; i++) {
            q.enQueue(i);
        }

        System.out.println("Queue Using Array created with size " + n);
        q.display();

        // Ask if user wants to dequeue
        System.out.print("Do you want to Dequeue the Queue (y/n): ");
        ch = sc.next().charAt(0);
        if (ch == 'y') {
            do {
                data = q.deQueue();
                if (data != -1) {
                    System.out.println("Deleted Element is: " + data);
                    System.out.println("After Dequeue");
                    q.display();
                }
                System.out.print("Do you want to Dequeue the Queue (y/n): ");
                ch = sc.next().charAt(0);

            } while (ch != 'n');
        }

        sc.close();
    }
}
