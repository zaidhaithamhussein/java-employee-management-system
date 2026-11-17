package EMS;

public class EmployeeQueue {

    private Node head; // last entered
    private Node tail; // first entered 
    private int size;

    public EmployeeQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // Enqueue: insert at head
    public void enqueue(Employee e) {
        Node newNode = new Node(e);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    // Dequeue: remove from tail (FIFO)
    public Employee dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty. No employee to remove.");
        }

        Employee removed;

        // Only one node
        if (head == tail) {
            removed = tail.data;
            head = tail = null;
            size = 0;
            return removed;
        }

        // Traverse to node before tail
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }

        removed = tail.data;
        tail = current;
        tail.next = null;
        size--;

        return removed;
    }

    // Print queue from head to tail
    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }

        Node current = head;
        while (current != null) {
            System.out.print("[" + current.data + "]");
            if (current.next != null) System.out.print(" -> ");
            current = current.next;
        }
        System.out.println();
        System.out.println("Left = last entered | Right = first entered (removed)");
    }
}