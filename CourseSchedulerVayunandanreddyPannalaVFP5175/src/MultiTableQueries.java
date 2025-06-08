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
public class MultiTableQueries {
    private static Connection connection;
    private static PreparedStatement getCourses;
    private static PreparedStatement getStudents;
    private static PreparedStatement getWaitlisted;
    private static ResultSet resultSet;
    
    public static ArrayList<ClassDescription> getAllCourseDescriptions(String semester){
        connection = DBConnection.getConnection();
        ArrayList<ClassDescription> descriptions = new ArrayList<>();
        
        try{
            getCourses = connection.prepareStatement("select java.class.courseCode, description, seats from java.class, java.course "
                                                   + "where semester = ? and java.class.courseCode = java.course.courseCode "
                                                   + "order by java.class.courseCode");
            getCourses.setString(1, semester);
            resultSet = getCourses.executeQuery();
            
            while (resultSet.next()){
                descriptions.add(new ClassDescription(resultSet.getString(1), resultSet.getString(2), resultSet.getInt(3)));
            }
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return descriptions;
    }
    
    public static ArrayList<ScheduleEntry> getScheduledStudentsByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> courseStudents = new ArrayList<>();
        
        try{
            getStudents = connection.prepareStatement("select studentid, timestamp from java.schedule where semester = ? and courseCode = ? and status = ?");
            getStudents.setString(1, semester);
            getStudents.setString(2, courseCode);
            getStudents.setString(3, "s");
            resultSet = getStudents.executeQuery();
            
            while (resultSet.next()){
                courseStudents.add(new ScheduleEntry(semester, courseCode, resultSet.getString(1), "s", resultSet.getTimestamp(2)));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return courseStudents;
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudentsByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> courseStudents = new ArrayList<>();
        
        try{
            getStudents = connection.prepareStatement("select studentid, timestamp from java.schedule where semester = ? and courseCode = ? and status = ?");
            getStudents.setString(1, semester);
            getStudents.setString(2, courseCode);
            getStudents.setString(3, "w");
            resultSet = getStudents.executeQuery();
            
            while (resultSet.next()){
                courseStudents.add(new ScheduleEntry(semester, courseCode, resultSet.getString(1), "w", resultSet.getTimestamp(2)));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return courseStudents;
    }
}
