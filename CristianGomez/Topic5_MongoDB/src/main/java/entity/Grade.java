package entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.*;

/**
 * Class that represents a grade a student got in a course.
 * 
 * @author Cadrian
 *
 */

@Entity
public class Grade {

    @Id
    private ObjectId id;
    @Reference
    private Course course;
    @Reference
    private Student student;
    private int grade;
    private String gradeType;

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getGradeType() {
        return gradeType;
    }

    public void setGradeType(String gradeType) {
        this.gradeType = gradeType;
    }
}
