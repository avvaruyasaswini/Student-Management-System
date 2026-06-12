import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class StudentDAO {
    public void addStudent(String name, int age, String course){
        try{
            Connection con = DBConnection.getConnection();
            String query =
                "INSERT INTO students(name, age, course) VALUES(?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, age);
            ps.setString(3, course);
            ps.executeUpdate();
            System.out.println("Student added successfully");
            ps.close();
            con.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    public void readStudent(){
        try{
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            System.out.println("STUDENT DETAILS");
            while(rs.next()){
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getString("course")
                );
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void searchStudentByID(int id){
        try{
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println(
                    rs.getInt("id") + " " +
                    rs.getString("name") + " " +
                    rs.getInt("age") + " " +
                    rs.getString("course")
                );
            }else{
                System.out.println("Student not found!");
            }
            rs.close();
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void deleteStudent(int id){
        try{
            Connection con = DBConnection.getConnection();
            String query = "DELETE FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if(rows > 0)
                System.out.println("Student deleted successfully!");
            else
                System.out.println("Student not found!");
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateName(int id, String name){
        try{
            Connection con = DBConnection.getConnection();
            String query = "UPDATE students SET name = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, name);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Student name updated successfully");
            }else{
                System.out.println("Student not found");
            }
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateAge(int id, int age){
        try{
            Connection con = DBConnection.getConnection();
            String query = "UPDATE students SET age = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, age);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Student age updated successfully");
            }else{
                System.out.println("Student not found");
            }
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public void updateCourse(int id, String course){
        try{
            Connection con = DBConnection.getConnection();
            String query = "UPDATE students SET course = ? WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, course);
            ps.setInt(2, id);
            int rows = ps.executeUpdate();
            if(rows > 0){
                System.out.println("Student course updated successfully");
            }else{
                System.out.println("Student not found");
            }
            ps.close();
            con.close();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public boolean hasStudent(){
        try{
            Connection con = DBConnection.getConnection();
            String query = "SELECT COUNT(*) FROM students";
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            boolean result = rs.getInt(1) > 0;
            rs.close();
            ps.close();
            con.close();
            return result;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
    public boolean studentExists(int id){
        try{
            Connection con = DBConnection.getConnection();
            String query = "SELECT * FROM students WHERE id = ?";
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            boolean exists = rs.next();
            rs.close();
            ps.close();
            con.close();
            return exists;
        }catch(Exception e){
            System.out.println(e);
            return false;
        }
    }
}