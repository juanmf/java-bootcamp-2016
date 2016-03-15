package dao;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

import entity.Student;
/**
 * DAO Class that maps a Student object.
 * 
 * @author Cadrian
 *
 */
public class StudentDAO extends BasicDAO<Student, ObjectId> {

    public StudentDAO(Morphia morphia, MongoClient mongo) {
        super(mongo, morphia, "high-school");
    }
}
