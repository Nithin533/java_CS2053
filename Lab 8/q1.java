import java.util.ArrayList;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();

        while (true) {
            System.out.println("\n1. Add Student");
            System.out.println("2. Insert Student at Index");
            System.out.println("3. Update Student Name");
            System.out.println("4. Remove Student by Name");
            System.out.println("5. Remove Student by Index");
            System.out.println("6. Display Students");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine(); 
            
            if (choice == 1) {
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                students.add(new Student(name, age, email));
                System.out.println("Student added!");
            } 
            else if (choice == 2) {
                System.out.print("Enter index: ");
                int index = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter age: ");
                int age = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter email: ");
                String email = sc.nextLine();
                if (index >= 0 && index <= students.size()) {
                    students.add(index, new Student(name, age, email));
                    System.out.println("Student inserted!");
                } else {
                    System.out.println("Invalid index!");
                }
            } 
            else if (choice == 3) {
                System.out.print("Enter old name: ");
                String oldName = sc.nextLine();
                System.out.print("Enter new name: ");
                String newName = sc.nextLine();
                boolean found = false;
                for (Student s : students) {
                    if (s.name.equalsIgnoreCase(oldName)) {
                        s.name = newName;
                        found = true;
                        System.out.println("Name updated!");
                        break;
                    }
                }
                if (!found) System.out.println("Student not found!");
            } 
            else if (choice == 4) {
                System.out.print("Enter name to remove: ");
                String name = sc.nextLine();
                boolean removed = students.removeIf(s -> s.name.equalsIgnoreCase(name));
                if (removed) System.out.println("Student removed!");
                else System.out.println("Student not found!");
            } 
            else if (choice == 5) {
                System.out.print("Enter index to remove: ");
                int index = sc.nextInt();
                if (index >= 0 && index < students.size()) {
                    students.remove(index);
                    System.out.println("Student removed!");
                } else {
                    System.out.println("Invalid index!");
                }
            } 
            else if (choice == 6) {
                if (students.isEmpty()) {
                    System.out.println("No students in list.");
                } else {
                    System.out.println("\n--- Student List ---");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + ": " + students.get(i));
                    }
                }
            } 
            else if (choice == 7) {
                System.out.println("Goodbye!");
                break;
            } 
            else {
                System.out.println("Invalid choice!");
            }
        }
        sc.close();
    }
}

class Student {
    String name;
    int age;
    String email;

    Student(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public String toString() {
        return name + " | Age: " + age + " | Email: " + email;
    }
}
