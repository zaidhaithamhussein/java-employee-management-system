package EMS;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EmployeeManagementSystem {

    private static void menu(){
        System.out.println("\nWelcome to *** Employee Management System ***");
        System.out.println("1. Enter new employee data");
        System.out.println("2. Delete employee data");
        System.out.println("3. Show shortest distance");
        System.out.println("4. Exit");
        System.out.print("\nEnter your choice -> ");
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        EmployeeQueue q = new EmployeeQueue();

        while(true){
            menu();

            int choice;
            try{
                choice = sc.nextInt();
                sc.nextLine();
            } catch(InputMismatchException e){
                System.out.println("Invalid input. Please enter a number 1-4.");
                sc.nextLine();
                continue;
            }

            switch(choice){

                case 1:
                    try{
                        System.out.print("Enter employee ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Enter employee name: ");
                        String name = sc.nextLine().trim();

                        System.out.print("Enter employee salary: ");
                        double salary = sc.nextDouble();
                        sc.nextLine();

                        if(id <= 0){
                            System.out.println("Error: ID must be positive.");
                            break;
                        }
                        if(name.length() == 0){
                            System.out.println("Error: Name cannot be empty.");
                            break;
                        }
                        if(salary < 0){
                            System.out.println("Error: Salary cannot be negative.");
                            break;
                        }

                        q.enqueue(new Employee(id, name, salary));
                        System.out.println("Employee added successfully.");
                        q.printQueue(); //print after add

                    } catch(InputMismatchException e){
                        System.out.println("Invalid type entered.");
                        sc.nextLine();
                    }
                    break;

                case 2:
                    try{
                        Employee removed = q.dequeue();
                        System.out.println("Removed employee (first entered): " + removed);
                        q.printQueue(); //print after delete
                    } catch(IllegalStateException e){
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    Graph g = new Graph(4);

                    g.addEdge(0, 1, 5);
                    g.addEdge(0, 2, 9);
                    g.addEdge(1, 2, 1);
                    g.addEdge(1, 3, 4);
                    g.addEdge(2, 3, 2);

                    g.Bellman(0, 3);
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please choose 1-4.");
            }
        }
    }
}