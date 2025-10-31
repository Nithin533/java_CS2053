
CHARAN M
Attachments
10:03 AM (0 minutes ago)
to me

package arraylist;



import java.util.ArrayList;

import java.util.Scanner;



public class StudentList {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<String> students = new ArrayList<>();

        int choice;



        do {

            System.out.println("\n--- Student List Menu ---");

            System.out.println("1. Add Student");

            System.out.println("2. Insert Student at Specific Index");

            System.out.println("3. Update Student Name");

            System.out.println("4. Remove Student by Name");

            System.out.println("5. Remove Student by Index");

            System.out.println("6. Display Student List");

            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");

            choice = sc.nextInt();

            sc.nextLine();



            switch (choice) {

                case 1:

                    System.out.print("Enter student name to add: ");

                    String name = sc.nextLine();

                    students.add(name);

                    System.out.println("✅ Student added successfully!");

                    break;



                case 2:

                    System.out.print("Enter index to insert at: ");

                    int index = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter student name: ");

                    String newName = sc.nextLine();

                    if (index >= 0 && index <= students.size()) {

                        students.add(index, newName);

                        System.out.println("✅ Student inserted successfully!");

                    } else {

                        System.out.println("❌ Invalid index!");

                    }

                    break;



                case 3:

                    System.out.print("Enter index to update: ");

                    int updateIndex = sc.nextInt();

                    sc.nextLine();

                    if (updateIndex >= 0 && updateIndex < students.size()) {

                        System.out.print("Enter new name: ");

                        String updatedName = sc.nextLine();

                        students.set(updateIndex, updatedName);

                        System.out.println("✅ Student updated successfully!");

                    } else {

                        System.out.println("❌ Invalid index!");

                    }

                    break;



                case 4:

                    System.out.print("Enter student name to remove: ");

                    String removeName = sc.nextLine();

                    if (students.remove(removeName)) {

                        System.out.println("✅ Student removed successfully!");

                    } else {

                        System.out.println("❌ Student not found!");

                    }

                    break;



                case 5:

                    System.out.print("Enter index to remove: ");

                    int removeIndex = sc.nextInt();

                    if (removeIndex >= 0 && removeIndex < students.size()) {

                        students.remove(removeIndex);

                        System.out.println("✅ Student removed successfully!");

                    } else {

                        System.out.println("❌ Invalid index!");

                    }

                    break;



                case 6:

                    System.out.println("\n📋 Student List:");

                    if (students.isEmpty()) {

                        System.out.println("No students found.");

                    } else {

                        for (int i = 0; i < students.size(); i++) {

                            System.out.println(i + ". " + students.get(i));

                        }

                    }

                    break;



                case 0:

                    System.out.println("Exiting program...");

                    break;



                default:

                    System.out.println("❌ Invalid choice!");

            }



        } while (choice != 0);



        sc.close();

    }

}--- Student List Menu ---

1. Add Student

2. Insert Student at Specific Index

3. Update Student Name

4. Remove Student by Name

5. Remove Student by Index

6. Display Student List

0. Exit

Enter your choice: 4

Enter student name to remove: balamurugan devru adarsh

✅ Student removed successfully!



--- Student List Menu ---

1. Add Student

2. Insert Student at Specific Index

3. Update Student Name

4. Remove Student by Name

5. Remove Student by Index

6. Display Student List

0. Exit

Enter your choice: 
