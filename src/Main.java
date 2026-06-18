import java.util.*;
public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            System.out.println("\nOPERATIONS");
            System.out.println("1. Add a student");
            System.out.println("2. View students");
            System.out.println("3. Delete student");
            System.out.println("4. Update student");
            System.out.println("5. Search student");
            System.out.println("6. Exit");
            choice = readValidInt(sc, "Enter choice: ");
            switch(choice){
                case 1:
                    sc.nextLine();
                    String name = readValidString(sc, "Enter student name: ");
                    
                    int age = readValidInt(sc, "Enter student age: ");
                    sc.nextLine();
                    String course = readValidString(sc, "Enter course name: ");
                    Student student = new Student(name, age, course);
                    dao.addStudent(student);
                    break;
                case 2:
                    if(!dao.hasStudent()){
                        System.out.println("No students found!!");
                        break;
                    }
                    dao.readStudent();
                    break;
                case 3:
                    if(!dao.hasStudent()){
                        System.out.println("No students found!!");
                        break;
                    }
                    dao.readStudent();
                    int id = readValidInt(sc, "Enter student ID: ");
                    dao.deleteStudent(id);
                    break;
                case 4:
                    if(!dao.hasStudent()){
                        System.out.println("No students found!!");
                        break;
                    }
                    dao.readStudent();
                    int id1 = readValidInt(sc, "Enter student ID: ");
                    if(!dao.studentExists(id1)){
                        System.out.println("Student not found");
                        break;
                    }
                    int ch1;
                    do{
                        System.out.println("What do you want to update? ");
                        System.out.println("1. Name");
                        System.out.println("2. Age");
                        System.out.println("3. Course");
                        System.out.println("4. Exit");
                        ch1 = readValidInt(sc, "Enter choice: ");
                        switch(ch1){
                            case 1:
                                sc.nextLine();
                                String name1 = readValidString(sc, "Enter student name: ");
                                dao.updateName(id1, name1);
                                break;
                            case 2:
                                int age1 = readValidInt(sc, "Enter student age: ");
                                if(age1 <= 0){
                                    System.out.println("Enter valid age!!");
                                    break;
                                }
                                dao.updateAge(id1, age1);
                                break;
                            case 3:
                                sc.nextLine();
                                String course1 = readValidString(sc, "Enter student course: ");
                                dao.updateCourse(id1, course1);
                                break;
                            case 4:
                                System.out.println("Exiting...");
                                break;
                            default:
                                System.out.println("Enter a valid choice!!");
                        }
                    }while(ch1 != 4);
                    break;
                case 5:
                    if(!dao.hasStudent()){
                        System.out.println("No students found!!");
                        break;
                    }
                    dao.readStudent();
                    int id2 = readValidInt(sc, "Enter student ID: ");
                    dao.searchStudentByID(id2);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Enter a valid choice!!");
            }
        }while(choice != 6);
        sc.close();
    }
    private static int readValidInt(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number!");
                sc.nextLine();
                continue;
            }
            int value = sc.nextInt();
            if (value <= 0) {
                System.out.println("Number must be greater than 0!");
                continue;
            }
            return value;
        }
    }
    private static String readValidString(Scanner sc, String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = sc.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            }
            System.out.println("Input cannot be empty!");
        }
    }
}