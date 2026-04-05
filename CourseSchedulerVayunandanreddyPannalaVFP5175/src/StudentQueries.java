import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vayunandanreddy Pannala
 */
public class StudentQueries {
    private static Connection connection;
    private static PreparedStatement addStudent;
    private static PreparedStatement dropStudent;
    private static PreparedStatement getStudents;
    private static PreparedStatement getStudent;
    private static PreparedStatement getID;
    private static PreparedStatement getNameByID;
    private static PreparedStatement studentExists;
    private static ResultSet resultSet;
   
    public static void addStudent(StudentEntry student){
        
        connection = DBConnection.getConnection();
        
        try{
            addStudent = connection.prepareStatement("INSERT INTO java.student (studentid, firstname, lastname) VALUES (?,?,?)");
            addStudent.setString(1, student.getStudentID());
            addStudent.setString(2, student.getFirstName());
            addStudent.setString(3, student.getLastName());
            addStudent.executeUpdate();
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static void dropStudent(String id){
        connection = DBConnection.getConnection();
        try{
            dropStudent = connection.prepareStatement("delete from java.student where studentid = ?");
            dropStudent.setString(1, id);
            dropStudent.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getStudents(){
        connection = DBConnection.getConnection();
        ArrayList<String> students = new ArrayList<>();
        try{
            getStudents = connection.prepareStatement("select firstname, lastname from java.student order by lastname, firstname");
            resultSet = getStudents.executeQuery();
            
            while (resultSet.next()){
                students.add(resultSet.getString(2) + "," + resultSet.getString(1));
            }
            
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return students;
    }
    
    public static ArrayList<StudentEntry> getStudentObjects(){
        connection = DBConnection.getConnection();
        ArrayList<StudentEntry> students = new ArrayList<>();
        try{
            getStudents = connection.prepareStatement("select firstname, lastname, studentid from java.student order by lastname, firstname");
            resultSet = getStudents.executeQuery();
            
            while (resultSet.next()){
                students.add(new StudentEntry(resultSet.getString(3), resultSet.getString(1), resultSet.getString(2)));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return students;
    }
    
    public static String getStudentID(String name){
        connection = DBConnection.getConnection();
        String[] parts = name.split(",");
        if (parts.length < 2) {
            return "";
        }
        String first = parts[1].trim();
        String last = parts[0].trim();
        String id = "";
        try{
            getID = connection.prepareStatement("select studentid from java.student where firstname = (?) and lastname = (?)");
            getID.setString(1, first);
            getID.setString(2, last);
            resultSet = getID.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getString(1);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return id;
    }
    
    public static String[] getStudentName(String id){
        connection = DBConnection.getConnection();
        String[] parts = new String[2];
        try{
            getNameByID = connection.prepareStatement("select firstname, lastname from java.student where studentid = ?");
            getNameByID.setString(1, id);
            resultSet = getNameByID.executeQuery();
            if (resultSet.next()) {
                parts[0] = resultSet.getString(1);
                parts[1] = resultSet.getString(2);
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return parts;
    }
    
    public static StudentEntry getStudent(String id){
        connection = DBConnection.getConnection();
        try{
            getStudent = connection.prepareStatement("select firstname, lastname from java.student where studentid = ?");
            getStudent.setString(1, id);
            resultSet = getStudent.executeQuery();
            if (resultSet.next()) {
                return new StudentEntry(id, resultSet.getString(1), resultSet.getString(2));
            }
            return null;
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
            return null;
        }
    }
    
    public static boolean exists(String id) {
        connection = DBConnection.getConnection();
        try {
            studentExists = connection.prepareStatement("select studentid from java.student where studentid = ?");
            studentExists.setString(1, id);
            resultSet = studentExists.executeQuery();
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }
}
