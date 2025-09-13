package stdgrademanagementsystem;
import java.util.Scanner;

public class StdGradeManagementSystem 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);    
        
        final int maxStudents = 50;        
        int n = 0;
        
        int[] rollNumbers = new int[maxStudents];
        String[] names = new String[maxStudents];
        int[][] marks = new int[maxStudents][3];       //3 subjects 
        
        // Loop continuously to show menu until the user chooses to exit
        while(true)
        {
            System.out.println("\nWelcome to Student Grade Management System\n");
            System.out.println("1. Add Student");
            System.out.println("2. Update Marks");
            System.out.println("3. Remove Student");
            System.out.println("4. View All Students");
            System.out.println("5. Search Student");
            System.out.println("6. Highest Scorer");
            System.out.println("7. Class Average");
            System.out.println("8. Exit");
            
            System.out.print("\nChoose an option: ");
            
            int option = sc.nextInt();
            
            // Choose a menu option to perform actions in Student Grade Management System
            switch(option)
            {
                // Add a new student to the system
                case 1:
                    if(n >= maxStudents){
                        System.out.println("Cannot add more students. Maximum limit reached");
                        break;
                    }
                    System.out.print("Enter Roll No: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    boolean exists =  false;
                
                   for(int i=0; i<n;  i++)
                   {
                      if(rollNumbers[i] == roll)
                      {
                        exists = true;
                        break;  
                      }
                    }
                   if (exists) {
                        System.out.println("Roll number already exists! Cannot add student.");
                        break;  //Go  to menu again
                    }
                   
                   rollNumbers[n] = roll;
                    
                   System.out.print("Enter Name: ");
                   String name = sc.nextLine();
                   names[n] = name;
                   
                   for(int i=0; i<3; i++)
                   {
                       //this loop will iterate until user enter valid marks of any student's subject
                       while(true){
                           System.out.print("Enter Marks in Subject " + (i + 1) + ": ");
                           int m = sc.nextInt();
                           
                           //check validation of marks
                           if(m>=0 && m<=100)
                           {
                               marks[n][i] = m;
                               break;    // exit while loop
                           }
                           else{
                               System.out.println("Invalid marks! Enter between 0 and 100");
                           }
                       }
                   }
                   
                   n++;
                   System.out.print("Student added successfully!\n");
                   break;
                   
                   
                // Update marks of an existing student
                case 2:
                    System.out.print("Enter Roll No to update marks: ");
                    int r = sc.nextInt();
                    int idx = -1;
                    
                    for (int i = 0; i < n; i++) 
                    {
                        if (rollNumbers[i] == r)
                        {
                            idx = i;
                            break;
                        }
                    }
                    if (idx == -1) {
                        System.out.println("Roll number not found!");
                        break;  //Go  to menu again
                    }
                    
                    for (int i = 0; i < 3; i++) 
                    {
                        //this loop will iterate until user enter valid marks
                        while (true) {
                            System.out.print("Enter new marks for Subject " + (i + 1) + ": ");
                            int m = sc.nextInt();
                            
                            //check validation of marks
                            if (m >= 0 && m <= 100) 
                            {
                                marks[idx][i] = m;
                                break;   // exit while loop
                            } 
                            else {
                                System.out.println("Invalid marks! Enter between 0 and 100.");
                            }
                        }
                    }
                    System.out.println("Marks updated successfully!\n");
                    break;
                    
                    
                // Remove a student from the system
                case 3:
                    System.out.print("Enter Roll No to remove: ");
                    int rr = sc.nextInt();
                    int removeIdx = -1;
                    
                    for (int i = 0; i < n; i++) 
                    {
                        if (rollNumbers[i] == rr) 
                        {
                            removeIdx = i;
                            break;
                        }
                    }
                    if (removeIdx == -1) {
                        System.out.println("Roll number not found!");
                        break;  //Go  to menu again
                    } 
                    
                    // Shift all elements after removed student one position to left
                    for (int i = removeIdx; i < n - 1; i++) {
                        rollNumbers[i] = rollNumbers[i + 1];
                        names[i] = names[i + 1];
                        marks[i][0] = marks[i + 1][0];
                        marks[i][1] = marks[i + 1][1];
                        marks[i][2] = marks[i + 1][2];
                    }
                    
                    n--;
                    System.out.println("Student removed successfully!\n");
                    break;
                    
                
                // Display details of all students
                case 4:
                    if (n == 0) 
                    {
                        System.out.println("No students to display.");
                        break;   //Go  to menu again
                    }
                    
                    // Print table header with aligned columns 
                    System.out.printf("%-10s %-15s %-10s %-10s %-10s %-10s %-10s\n", 
                        "Roll No", "Name", "Sub1", "Sub2", "Sub3", "Total", "Average");
                    
                    for (int i = 0; i < n; i++) 
                    {
                        int total = marks[i][0] + marks[i][1] + marks[i][2];
                        double avg = total / 3.0;
                        
                        // Print each student's details in aligned columns
                        System.out.printf("%-10d %-15s %-10d %-10d %-10d %-10d %-10.2f\n",
                            rollNumbers[i], names[i], marks[i][0], marks[i][1], marks[i][2], total, avg);
                    }
                    break;
                    
                    
                // Search and display a student by roll number
                case 5:
                    System.out.print("Enter Roll No to search: ");
                    int sr = sc.nextInt();
                    int sIdx = -1;
                    
                    for (int i = 0; i < n; i++) 
                    {
                        if (rollNumbers[i] == sr) {
                            sIdx = i;
                            break;
                        }
                    }
                    if (sIdx == -1) {
                        System.out.println("Roll number not found!");
                        break;   //Go  to menu again
                    }
                    
                    int total = marks[sIdx][0] + marks[sIdx][1] + marks[sIdx][2];
                    double avg = total / 3.0;
                    
                    System.out.printf("Roll No: %d \nName: %s \nMarks: %d, %d, %d \nTotal: %d \nAverage: %.2f \n",
                        rollNumbers[sIdx], names[sIdx], marks[sIdx][0], marks[sIdx][1], marks[sIdx][2], total, avg);
                    break;
                    
                    
                // Show the student with highest total marks
                case 6:
                    if (n == 0) {
                        System.out.println("No students in the class.");
                        break;
                    }
                    int highestIdx = 0;
                    int highestTotal = marks[0][0] + marks[0][1] + marks[0][2];
                    
                    for (int i = 1; i < n; i++) 
                    {
                        int t = marks[i][0] + marks[i][1] + marks[i][2];
                        if (t > highestTotal) {
                            highestTotal = t;
                            highestIdx = i;
                        }
                    }
                    
                    System.out.println("Highest Scorer:");
                    System.out.printf("Roll No: %d \nName: %s \nTotal: %d \n", 
                        rollNumbers[highestIdx], names[highestIdx], highestTotal);
                    break;
                    
                
                // Calculate and display the class average
                case 7:
                    if (n == 0) {
                        System.out.println("No students to calculate average.");
                        break;
                    }
                    
                    double sumAvg = 0;
                    for (int i = 0; i < n; i++) 
                    {
                        double studentAvg = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;
                        sumAvg += studentAvg;
                    }
                    
                    double classAvg = sumAvg /n;
                    System.out.printf("Class Average: %.2f\n", classAvg);
                    break;
                    
                    
                // Exit the program and display final class summary
                case 8:
                    double finalTotal = 0;
                    for (int i = 0; i < n; i++) 
                    {
                        finalTotal += marks[i][0] + marks[i][1] + marks[i][2];
                    }
                    
                    
                    double finalAvg;
                    if (n == 0) 
                    {
                        finalAvg = 0;    //if no students
                    } 
                    else {
                       finalAvg = finalTotal / (n * 3); // Otherwise, calculate average
                    }
                    
                    System.out.println("Class Summary:");
                    System.out.println("Total students: " + n);
                    System.out.printf("Class average: %.2f\n", finalAvg);
                    sc.close();
                    
                    return;  // Stop while loop and Exit the program 

                default:
                    System.out.println("Invalid option! Choose between 1-8.");
            }
        }
    }
}