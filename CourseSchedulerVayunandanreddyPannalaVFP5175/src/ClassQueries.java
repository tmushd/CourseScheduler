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

public class ClassQueries 
{
    private static Connection connection;
    private static PreparedStatement addClass;
    private static PreparedStatement dropClass;
    private static PreparedStatement getClasses;
    private static ResultSet resultSet;
   
    public static void addClass(ClassEntry classEntry){
        
        connection = DBConnection.getConnection();
        
        try{
            
            addClass = connection.prepareStatement("INSERT INTO java.class (semester, coursecode, seats) VALUES (?,?,?)");
            addClass.setString(1, classEntry.getSemester());
            addClass.setString(2, classEntry.getCourseCode());
            addClass.setInt(3, classEntry.getSeats());
            addClass.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getCourseCodesByClass(String semester){
        connection = DBConnection.getConnection();
        ArrayList<String> classes = new ArrayList<>();
        try{
            getClasses = connection.prepareStatement("select coursecode from java.class where semester = (?)");
            getClasses.setString(1, semester);
            resultSet = getClasses.executeQuery();
            
            while (resultSet.next()){
                classes.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
        return classes;
    }
    
    public static void dropClass(String semester, String courseCode){
        connection = DBConnection.getConnection();
        try{
            dropClass = connection.prepareStatement("delete from java.class where semester = ? and coursecode = ?");
            dropClass.setString(1, semester);
            dropClass.setString(2, courseCode);
            dropClass.executeUpdate();
        }
        catch(SQLException sqlException)
        {
            sqlException.printStackTrace();
        }
    }
}