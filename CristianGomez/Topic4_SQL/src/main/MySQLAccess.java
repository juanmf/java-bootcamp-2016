package main;
/**
 * @author Cadrian
 * 
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MySQLAccess {

    private Connection connect = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;

    public void readDataBase() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            // Setup the connection with the DB
            connect = DriverManager.getConnection("jdbc:mysql://localhost/highschool?" + "user=root&password=Cadrian123794");

            String queryText = "SELECT HIGH_PRIORITY CONCAT(t.lastname, ', ',t.firstname) AS 'Teacher',"
                    + " s.dayofweek AS 'Day', TIME_FORMAT(s.starttime, '%H:%i') AS 'From', TIME_FORMAT(s.endtime, '%H:%i') AS 'To',"
                    + " c.name AS 'Course Name'" + " FROM teacher t" + " INNER JOIN course c USING (teacher_id)"
                    + " INNER JOIN schedule s USING (course_id)" + " WHERE t.teacher_id = ?"
                    + " ORDER BY FIELD(s.dayofweek, 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday');";

            statement = connect.prepareStatement(queryText);
            statement.setString(1, "1");
            resultSet = statement.executeQuery();

            writeResultSet(resultSet);

            // writeMetaData(resultSet);

        } catch (Exception e) {
            throw e;
        } finally {
            close();
        }

    }

    private void writeMetaData(ResultSet resultSet) throws SQLException {
        // Now get some metadata from the database
        // Result set get the result of the SQL query

        System.out.println("The columns in the table are: ");

        System.out.println("Table: " + resultSet.getMetaData().getTableName(1));
        for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
            System.out.println("Column " + i + " " + resultSet.getMetaData().getColumnName(i));
        }
    }

    private void writeResultSet(ResultSet resultSet) throws SQLException {
        // ResultSet is initially before the first data set

        // Teacher: <last-name>, <first-name>
        // Schedule:
        // Monday 09:00 - 11:00: <course-name>
        // Monday 15:00 - 17:30: <course-name>
        // Friday 08:45 - 10:40: <course-name>

        if (resultSet.next()) {
            String teacher = resultSet.getString(1);
            System.out.println("Teacher: " + teacher);
            System.out.println("Schedule:");
        }

        resultSet.beforeFirst();

        while (resultSet.next()) {
            String day = resultSet.getString(2);
            String from = resultSet.getString(3);
            String to = resultSet.getString(4);
            String coursename = resultSet.getString(5);

            System.out.println(day + " " + from + " - " + to + ": " + coursename);
        }
    }

    // You need to close the resultSet
    private void close() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }

            if (connect != null) {
                connect.close();
            }
        } catch (Exception e) {

        }
    }

}