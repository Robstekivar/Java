package Task1;

import java.util.Scanner;

public class StudentGradeCalculator {
	
    public static void main(String[] args) {
    	// TODO Auto-generated method stub
    	
        Scanner userInput = new Scanner(System.in);

        // User must enter number of subjects
        System.out.print("Enter the number of subjects: ");
        int numberOfSubjects = userInput.nextInt();

        // Initialize total marks to zero
        int totalMarks = 0;

        //  Input: Take marks obtained (out of 100) in each subject
        for (int i = 1; i <= numberOfSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            int marks = userInput.nextInt();

            // Validate marks
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks. Please enter again (0-100): ");
                marks = userInput.nextInt();
            }
            
            //  Calculate Total Marks
            totalMarks += marks; 
        }

        // Calculate Average Percentage
        double averagePercentage = (double) totalMarks / numberOfSubjects;

        // Grade Calculation
        String grade;
        if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else if (averagePercentage >= 40) {
            grade = "E";
        } else {
            grade = "F";
        }

        // Display Results
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        userInput.close();
    }
}