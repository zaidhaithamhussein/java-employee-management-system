# Employee Management System — Java Data Structures & Algorithms

A console-based university project demonstrating an employee queue implemented with a singly linked list, alongside a graph shortest-path example using Bellman–Ford relaxation.

## Features

- Add employees with an ID, name, and salary to a queue.
- Remove the earliest-added employee using **FIFO** (first in, first out) ordering.
- Display the queue after adding or removing an employee.
- Run a shortest-path demonstration on a **predefined four-vertex weighted graph** and display its distance and path.
- Handle invalid menu input and basic employee-field validation.

## Data structures and algorithms

- **Singly linked list:** each `Node` stores an `Employee` and a reference to the next node.
- **Queue:** `EmployeeQueue` adds at the head and removes at the tail, following FIFO order. Because removing from the tail requires traversal, dequeue takes **O(n)** time; enqueue is **O(1)**.
- **Graph:** `Graph` uses an adjacency matrix and applies Bellman–Ford-style edge relaxation to find and reconstruct a shortest path in a fixed example.

## Project structure

```text
src/EMS/
├── Employee.java                 # Employee data model
├── Node.java                     # Linked-list node
├── EmployeeQueue.java            # FIFO queue implementation
├── Graph.java                    # Weighted graph and shortest-path demonstration
└── EmployeeManagementSystem.java # Console menu and program entry point
```

## Run in Eclipse

1. Open Eclipse and choose **File → Import → General → Existing Projects into Workspace**.
2. Select the extracted repository folder and import the project.
3. Open `src/EMS/EmployeeManagementSystem.java`.
4. Right-click the file and choose **Run As → Java Application**.

## Run from a terminal

With a Java Development Kit installed, from the repository root:

```bash
javac -d out src/EMS/*.java
java -cp out EMS.EmployeeManagementSystem
```

On Windows PowerShell, the same commands can be used if `javac` and `java` are on your PATH.

## Menu

```text
1. Enter new employee data
2. Delete employee data
3. Show shortest distance
4. Exit
```

**Note:** The shortest-path feature uses a fixed example graph; it does not calculate distances between employees or allow graph editing. Employee data is stored in memory for the current run, not saved to a database.

## Academic context

Developed as a university Data Structures & Algorithms exercise in Java. Source code is preserved from the original Eclipse project.
