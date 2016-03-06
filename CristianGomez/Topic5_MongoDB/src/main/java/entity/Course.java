package entity;

import java.util.List;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;


/**
 * Class that represents a course.
 * 
 * @author Cadrian
 *
 */

@Entity
public class Course implements Comparable<Course> {
    @Id
    private ObjectId id;
    private String name;
    @Embedded
    private Teacher teacher;
    @Reference("student")
    private List<Student> students;
    @Embedded("course_schedule")
    private List<CourseSchedule> schedule;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<CourseSchedule> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<CourseSchedule> schedule) {
        this.schedule = schedule;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public int compareTo(Course course) {
        if (this.name.compareTo(course.getName()) == 0) {
            return 0;
        }
        return -1;
    }
}
