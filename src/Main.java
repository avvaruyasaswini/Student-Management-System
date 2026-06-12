import java.util.*;
public class Main {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("\nOPERATIONS");
            System.out.println("1. Add a student");
            System.out.println("2. View students");
            System.out.println("3. Delete student");
            System.out.println("4. Update student");
            System.out.println("5. Search student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter student name: ");
                    sc.nextLine();
                    String name = sc.nextLine();
                    System.out.println("Enter student age: ");
                    int age = sc.nextInt();
                    System.out.println("Enter course of the student: ");
                    sc.nextLine();
                    String course = sc.nextLine();
                    dao.addStudent(name, age, course);
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
                    System.out.println("Enter student ID to delete: ");
                    int id = sc.nextInt();
                    dao.deleteStudent(id);
                    break;
                case 4:
                    if(!dao.hasStudent()){
                        System.out.println("No students found!!");
                        break;
                    }
                    dao.readStudent();
                    System.out.println("Enter student ID to update: ");
                    int id1 = sc.nextInt();
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
                        System.out.print("Enter choice: ");
                        ch1 = sc.nextInt();
                        switch(ch1){
                            case 1:
                                System.out.println("Enter name to update: ");
                                sc.nextLine();
                                String name1 = sc.nextLine();
                                dao.updateName(id1, name1);
                                break;
                            case 2:
                                System.out.println("Enter age to update: ");
                                int age1 = sc.nextInt();
                                dao.updateAge(id1, age1);
                                break;
                            case 3:
                                System.out.println("Enter course to update: ");
                                sc.nextLine();
                                String course1 = sc.nextLine();
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
                    System.out.println("Enter student ID to search: ");
                    int id2 = sc.nextInt();
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
}