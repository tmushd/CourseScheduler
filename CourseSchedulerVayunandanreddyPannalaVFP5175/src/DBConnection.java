/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Vayunandanreddy Pannala
 */
public class DBConnection {
    private static Connection connection;
    private static final String defaultUser = "java";
    private static final String defaultPassword = "java";
    private static final String defaultHost = "localhost";
    private static final String defaultPort = "1527";
    private static final String defaultDatabaseName = "CourseSchedulerDBVayunandanreddyPannalaVFP5175";

    public static Connection getConnection()
    {
        if (connection == null)
        {
            try
            {
                connection = DriverManager.getConnection(getDatabaseUrl(), getDatabaseUser(), getDatabasePassword());
            } catch (SQLException e)
            {
                e.printStackTrace();
                System.out.println("Could not open database.");
                System.exit(1);

            }
        }
        return connection;
    }

    private static String getDatabaseUrl() {
        String explicitUrl = System.getenv("COURSE_SCHEDULER_DB_URL");
        if (explicitUrl != null && !explicitUrl.isBlank()) {
            return explicitUrl;
        }

        String host = getEnv("COURSE_SCHEDULER_DB_HOST", defaultHost);
        String port = getEnv("COURSE_SCHEDULER_DB_PORT", defaultPort);
        String databaseName = getEnv("COURSE_SCHEDULER_DB_NAME", defaultDatabaseName);
        return "jdbc:derby://" + host + ":" + port + "/" + databaseName;
    }

    private static String getDatabaseUser() {
        return getEnv("COURSE_SCHEDULER_DB_USER", defaultUser);
    }

    private static String getDatabasePassword() {
        return getEnv("COURSE_SCHEDULER_DB_PASSWORD", defaultPassword);
    }

    private static String getEnv(String key, String fallback) {
        String value = System.getenv(key);
        if (value == null || value.isBlank()) {
            return fallback;
        }
        return value;
    }

    
}
