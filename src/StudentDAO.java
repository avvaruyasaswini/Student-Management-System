import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StudentDAO {
    public void addStudent(Student student){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            String query =
                "INSERT INTO students(name, age, course) VALUES(?, ?, ?)";
            ps.setString(1, student.getName());
            ps.setInt(2, student.getAge());
            ps.setString(3, student.getCourse());
            ps.executeUpdate();
            System.out.println("Student added successfully");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void readStudent(){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            String query = "SELECT * FROM students";
            System.out.println("\nSTUDENT DETAILS");
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                Student student = new Student(id, name, age, course);
                System.out.println(student);
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void searchStudentByID(int id){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            String query = "SELECT * FROM students WHERE id = ?";
            ps.setInt(1, id);
            if(rs.next()){
                int studentId = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String course = rs.getString("course");
                Student student = new Student(id, name, age, course);
                System.out.println(student);
            }else{
                System.out.println("Student not found!");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void deleteStudent(int id){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            String query = "DELETE FROM students WHERE id = ?";
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if(rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student not found!");
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateName(int id, String name){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query)){
            String query = "UPDATE students SET name = ? WHERE id = ?";
            ps.setString(1, name);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Student name updated successfully");
            }else{
                System.out.println("Student not found");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateAge(int id, int age){
        try(Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(query)){
            String query = "UPDATE students SET age = ? WHERE id = ?";
            ps.setInt(1, age);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Student age updated successfully");
            }else{
                System.out.println("Student not found");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateCourse(int id, String course){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);){
            String query = "UPDATE students SET course = ? WHERE id = ?";
            ps.setString(1, course);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Student course updated successfully");
            }else{
                System.out.println("Student not found");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public boolean hasStudent(){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();){
            String query = "SELECT COUNT(*) FROM students";
            rs.next();
            boolean result = rs.getInt(1) > 0;
            return result;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean studentExists(int id){
        try(Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery()){
            String query = "SELECT * FROM students WHERE id = ?";
            ps.setInt(1, id);
            boolean exists = rs.next();
            return exists;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean isValidName(String name){
        name = name.trim();
        if(name.isEmpty()){
            System.out.println("Enter valid name!!");
            return false;
        }
        return true;
    }
    public boolean isValidAge(int age){
        if(age <= 0){
            System.out.println("Enter valid age!!");
            return false;
        }
        return true;
    }
    public boolean isValidCourse(String course){
        course = course.trim();
        if(course.isEmpty()){
            System.out.println("Enter valid course name!!");
            return false;
        }
        return true;
    }
}