package dao;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.mongodb.morphia.query.Query;

import com.mongodb.MongoClient;

import entity.Course;
import entity.Grade;
import entity.Student;

/**
 * DAO Class that maps a Grade object.
 * 
 * @author Cadrian
 *
 */
public class GradeDAO extends BasicDAO<Grade, ObjectId> {
    public GradeDAO(Morphia morphia, MongoClient mongo) {
        super(mongo, morphia, "high-school");
    }

    /**
     * Method to find the students with grades greater than 4 in a given course
     * 
     * @param course
     * @return A Set of students whose grades are greater than 4 in the given
     *         course
     */
    public Set<Student> findStudentsWithGradesGreaterThan4InAGivenCourse(Course course) {
        Datastore ds = super.getDatastore();
        Query<Course> query = ds.createQuery(Course.class).filter("name =", course.getName());
        Query<Grade> query2 = ds.createQuery(Grade.class).filter("grade >", 4).filter("course = ", query.get());
        Iterator<Grade> it = query2.iterator();
        Set<Student> students_set = new HashSet<Student>();
        while (it.hasNext()) {
            students_set.add(it.next().getStudent());
        }
        return students_set;
    }

}
