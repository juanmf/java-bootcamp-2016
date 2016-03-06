package dao;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import entity.Course;
import entity.Teacher;
/**
 * DAO Class that maps a Course object.
 * 
 * @author Cadrian
 *
 */
public class CourseDAO extends BasicDAO<Course, ObjectId> {

    public CourseDAO(Morphia morphia, MongoClient mongo) {
        super(mongo, morphia, "high-school");
    }

    /**
     * Method to find the courses dictated by a given teacher.
     * 
     * @param teacher
     * @return A List of courses dictated by the given teacher.
     */
    public List<Course> findCoursesOfAGivenTeacher(Teacher teacher) {
        Datastore ds = super.getDatastore();
        Query<Course> query2 = ds.createQuery(Course.class).filter("teacher.firstName = ", teacher.getFirstName())
                .filter("teacher.lastName = ", teacher.getLastName()).order("name");
        Iterator<Course> it = query2.iterator();
        List<Course> course_set = new LinkedList<Course>();
        while (it.hasNext()) {
            course_set.add(it.next());
        }
        return course_set;
    }
}
