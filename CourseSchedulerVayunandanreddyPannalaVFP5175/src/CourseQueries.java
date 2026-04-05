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
public class CourseQueries {
    private static Connection connection;
    private static PreparedStatement addCourse;
    private static PreparedStatement getCourseList;
    private static PreparedStatement getCourseByCode;
    private static ResultSet resultSet;
    
    public static ArrayList<CourseEntry> getCourses(String semester){
        
        connection = DBConnection.getConnection();
        ArrayList<CourseEntry> courses = new ArrayList<>();
        try{
            getCourseList = connection.prepareStatement("select courseCode, description from java.course order by courseCode");
            resultSet = getCourseList.executeQuery();
            
            while (resultSet.next()){
                courses.add(new CourseEntry(resultSet.getString(1), resultSet.getString(2)));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        
        return courses;
    }
    
    public static void addCourse(CourseEntry course){
        
        connection = DBConnection.getConnection();
        
        try{
            addCourse = connection.prepareStatement("INSERT INTO java.course (coursecode, description) VALUES (?,?)");
            addCourse.setString(1, course.getCourseCode());
            addCourse.setString(2, course.getDescription());
            addCourse.executeUpdate();
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<String> getCourseCodes(){
        
        connection = DBConnection.getConnection();
        ArrayList<String> codes = new ArrayList<>();
        
        try{
            getCourseList = connection.prepareStatement("select coursecode from java.course order by coursecode");
            resultSet = getCourseList.executeQuery();
            
            while (resultSet.next()){
                codes.add(resultSet.getString(1));
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return codes;
    }
    
    public static int getCourseSeats(String semester, String courseCode){
        
        connection = DBConnection.getConnection();
        int count = 0;
        
        try{
            getCourseList = connection.prepareStatement("select seats from java.class where semester = (?) and coursecode = (?)");
            getCourseList.setString(1, semester);
            getCourseList.setString(2, courseCode);
            resultSet = getCourseList.executeQuery();
            if (resultSet.next()) {
                count = resultSet.getInt(1);
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return count;
    }
    
    public static boolean exists(String courseCode) {
        connection = DBConnection.getConnection();
        try {
            getCourseByCode = connection.prepareStatement("select coursecode from java.course where coursecode = ?");
            getCourseByCode.setString(1, courseCode);
            resultSet = getCourseByCode.executeQuery();
            return resultSet.next();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return false;
        }
    }
}
