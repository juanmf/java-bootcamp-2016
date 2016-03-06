package entity;

import java.util.Date;
import org.mongodb.morphia.annotations.Embedded;

/**
 * Class that represents a Teacher.
 * 
 * @author Cadrian
 *
 */

@Embedded
public class Teacher implements Comparable<Teacher> {

    private String firstName;
    private String lastName;
    private Date birthday;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int compareTo(Teacher teacher) {
        if (this.firstName.compareTo(teacher.getFirstName()) == 0 && this.lastName.compareTo(teacher.getLastName()) == 0) {
            return 0;
        }
        return 1;
    }

}
