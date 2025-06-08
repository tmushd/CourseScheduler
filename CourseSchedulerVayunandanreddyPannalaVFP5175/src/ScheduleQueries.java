import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Vayunandanreddy Pannala
 */
public class ScheduleQueries {
    private static Connection connection;
    private static PreparedStatement addSchedule;
    private static PreparedStatement dropStudentCourse;
    private static PreparedStatement dropStudentClass;
    private static PreparedStatement getWaitlisted;
    private static PreparedStatement getCourseStudents;
    private static PreparedStatement updateSchedule;
    private static PreparedStatement getNumScheduled;
    private static PreparedStatement getSchedule;
    private static ResultSet resultSet;
    
    public static void addSchedule(ScheduleEntry schedule){
        
        connection = DBConnection.getConnection();
        
        try{
            addSchedule = connection.prepareStatement("INSERT INTO java.schedule (semester, coursecode, studentid, status, timestamp) VALUES (?,?,?,?,?)");
            addSchedule.setString(1, schedule.getSemester());
            addSchedule.setString(2, schedule.getCourseCode());
            addSchedule.setString(3, schedule.getStudentID());
            addSchedule.setString(4, schedule.getStatus());
            addSchedule.setTimestamp(5, schedule.getTimestamp());
            addSchedule.executeUpdate();
        }
        
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static void dropStudentByCourse(String semester, String id, String courseCode){
        connection = DBConnection.getConnection();
        try{
            dropStudentCourse = connection.prepareStatement("delete from java.schedule where semester = ? and studentid = ? and coursecode = ?");
            dropStudentCourse.setString(1, semester);
            dropStudentCourse.setString(2, id);
            dropStudentCourse.setString(3, courseCode);
            dropStudentCourse.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static void dropStudentsByCourse(String semester, String courseCode){
        connection = DBConnection.getConnection();
        try{
            dropStudentCourse = connection.prepareStatement("delete from java.schedule where semester = ? and coursecode = ?");
            dropStudentCourse.setString(1, semester);
            dropStudentCourse.setString(2, courseCode);
            dropStudentCourse.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    
    public static ArrayList<ScheduleEntry> getWaitlistedStudents(String semester, String courseCode){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> waitlisted = new ArrayList<>();
        try{
            getWaitlisted = connection.prepareStatement("select studentid, timestamp from java.schedule where semester = ? and coursecode = ? and status = ?");
            getWaitlisted.setString(1, semester);
            getWaitlisted.setString(2, courseCode);
            getWaitlisted.setString(3, "w");
            resultSet = getWaitlisted.executeQuery();
            
            while (resultSet.next()){
                waitlisted.add(new ScheduleEntry(semester, courseCode, resultSet.getString(1), "w", resultSet.getTimestamp(2)));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return waitlisted;
    }
    
    public static void updateStatus(String semester, ScheduleEntry schedule){
        connection = DBConnection.getConnection();
        try{
            updateSchedule = connection.prepareStatement("update java.schedule set status = 's' where semester = ? and coursecode = ? and studentid = ?");
            updateSchedule.setString(1, semester);
            updateSchedule.setString(2, schedule.getCourseCode());
            updateSchedule.setString(3, schedule.getStudentID());
            updateSchedule.executeUpdate();
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
    }
    public static int getScheduledStudentsCount(String semester, String courseCode){
        connection = DBConnection.getConnection();
        int count = 0;
        try{
            getNumScheduled = connection.prepareStatement("select studentid from java.schedule where semester = (?) and coursecode = (?)");
            getNumScheduled.setString(1, semester);
            getNumScheduled.setString(2, courseCode);
            resultSet = getNumScheduled.executeQuery();
            
            while (resultSet.next()){
                count++;
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return count;
    }
    
    public static ArrayList<ScheduleEntry> getStudentSchedule(String semester, String id){
        connection = DBConnection.getConnection();
        ArrayList<ScheduleEntry> schedule = new ArrayList<>();
        try{
            getSchedule = connection.prepareStatement("select * from java.schedule where semester = (?) and studentid = (?)");
            getSchedule.setString(1, semester);
            getSchedule.setString(2, id);
            resultSet = getSchedule.executeQuery();
            
            while (resultSet.next()){
                schedule.add(new ScheduleEntry(semester, resultSet.getString(2), resultSet.getString(3), resultSet.getString(4), resultSet.getTimestamp(5)));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return schedule;
    }
    
    public static ArrayList<String> getCourseCodesByStudent(String semester, String id){
        connection = DBConnection.getConnection();
        ArrayList<String> schedule = new ArrayList<>();
        try{
            getSchedule = connection.prepareStatement("select coursecode from java.schedule where semester = (?) and studentid = (?)");
            getSchedule.setString(1, semester);
            getSchedule.setString(2, id);
            resultSet = getSchedule.executeQuery();
            
            while (resultSet.next()){
                schedule.add(resultSet.getString(1));
            }
        }
        catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return schedule;
    }
}
