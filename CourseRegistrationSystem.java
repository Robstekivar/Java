package First;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

class Course {
    String courseCode;
    String title;
    String description;
    int capacity;
    int enrolled;

    public Course(String courseCode, String title, String description, int capacity) {
        this.courseCode = courseCode;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.enrolled = 0;
    }

    public boolean register() {
        if (enrolled < capacity) {
            enrolled++;
            return true;
        }
        return false;
    }

    public boolean drop() {
        if (enrolled > 0) {
            enrolled--;
            return true;
        }
        return false;
    }

    public String getDetails() {
        return String.format("%s: %s (Enrolled: %d/%d) - %s", 
                courseCode, title, enrolled, capacity, description);
    }
}

class Student {
    String studentId;
    String name;
    List<Course> registeredCourses;

    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public boolean registerForCourse(Course course) {
        if (course.register()) {
            registeredCourses.add(course);
            return true;
        }
        return false;
    }

    public boolean dropCourse(Course course) {
        if (registeredCourses.remove(course) && course.drop()) {
            return true;
        }
        return false;
    }

    public void displayRegisteredCourses() {
        if (registeredCourses.isEmpty()) {
            System.out.println(name + " is not registered for any courses.");
        } else {
            System.out.println(name + "'s Registered Courses:");
            for (Course course : registeredCourses) {
                System.out.println(course.getDetails());
            }
        }
    }
}

public class CourseRegistrationSystem {
    static HashMap<String, Course> courseDatabase = new HashMap<>();
    static HashMap<String, Student> studentDatabase = new HashMap<>();
    
    public static void addCourse(String courseCode, String title, String description, int capacity) {
        courseDatabase.put(courseCode, new Course(courseCode, title, description, capacity));
    }

    public static void displayCourses() {
        System.out.println("Available Courses:");
        for (Course course : courseDatabase.values()) {
            System.out.println(course.getDetails());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample data
        addCourse("CS101", "Introduction to Computer Science", "Basic concepts of programming.", 30);
        addCourse("MATH101", "Calculus I", "Introduction to differential calculus.", 25);
        addCourse("ENG101", "English Literature", "Study of classic literature.", 20);

        // Registration loop
        while (true) {
            System.out.println("\n1. Display Courses");
            System.out.println("2. Register for Course");
            System.out.println("3. Drop Course");
            System.out.println("4. Show Registered Courses");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    displayCourses();
                    break;
                case 2:
                    System.out.print("Enter Student ID: ");
                    String studentId = scanner.nextLine();
                    System.out.print("Enter Student Name: ");
                    String studentName = scanner.nextLine();
                    Student student = studentDatabase.computeIfAbsent(studentId, id -> new Student(id, studentName));
                    displayCourses();
                    System.out.print("Enter Course Code to register: ");
                    String courseCodeToRegister = scanner.nextLine();
                    Course courseToRegister = courseDatabase.get(courseCodeToRegister);
                    if (courseToRegister != null && student.registerForCourse(courseToRegister)) {
                        System.out.println("Successfully registered for " + courseToRegister.title);
                    } else {
                        System.out.println("Registration failed. Course may be full.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = studentDatabase.get(studentId);
                    if (student != null) {
                        student.displayRegisteredCourses();
                        System.out.print("Enter Course Code to drop: ");
                        String courseCodeToDrop = scanner.nextLine();
                        Course courseToDrop = courseDatabase.get(courseCodeToDrop);
                        if (courseToDrop != null && student.dropCourse(courseToDrop)) {
                            System.out.println("Successfully dropped " + courseToDrop.title);
                        } else {
                            System.out.println("Course not found in registered courses.");
                        }
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Student ID: ");
                    studentId = scanner.nextLine();
                    student = studentDatabase.get(studentId);
                    if (student != null) {
                        student.displayRegisteredCourses();
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
