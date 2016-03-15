package main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import dao.CourseDAO;
import dao.GradeDAO;
import dao.StudentDAO;
import entity.Course;
import entity.CourseSchedule;
import entity.Grade;
import entity.Student;
import entity.Teacher;

public class Main {
    private static StudentDAO studentDao;
    private static CourseDAO courseDao;
    private static GradeDAO gradeDao;

    public static void main(String[] args) throws Exception {
        /*
         * Connection to Mongo Database
         */
        MongoClient mongo = new MongoClient("localhost", 27017);
        Morphia morphia = new Morphia();
        morphia.mapPackage("entity");
        morphia.createDatastore(mongo, "high-school");

        /*
         * Initializing DAOs
         */
        studentDao = new StudentDAO(morphia, mongo);
        courseDao = new CourseDAO(morphia, mongo);
        gradeDao = new GradeDAO(morphia, mongo);
        /*
         * Call to the method that loads the data in the database. Only to be
         * called when the database is empty.
         */
        // loadData();
        /*
         * Practice 2.
         * Fetch all students whose notes in a specific course were greater than 4.
         */
        System.out.println("practica2");
        Course course = new Course();
        course.setName("English");
        Set<Student> gradesGreaterThan4 = gradeDao.findStudentsWithGradesGreaterThan4InAGivenCourse(course);
        Iterator<Student> it = gradesGreaterThan4.iterator();
        while (it.hasNext()) {
            Student aux = it.next();
            System.out.println("Student: " + aux.getLastName() + ", " + aux.getFirstName());
        }
        /*
         * Practice 3.
         * Fetch all courses ordered by name for a given teacher.
         */
        System.out.println("Practica 3");
        Teacher teacher = new Teacher();
        teacher.setFirstName("Willie");
        teacher.setLastName("McDougal");
        List<Course> teachersCourse = courseDao.findCoursesOfAGivenTeacher(teacher);
        Iterator<Course> it2 = teachersCourse.iterator();
        while (it2.hasNext()) {
            Course aux = it2.next();
            System.out.println(
                    "Course: " + aux.getName() + "\nTeacher: " + aux.getTeacher().getLastName() + ", " + aux.getTeacher().getFirstName());
        }

    }

    public static void loadData() throws Exception {
        /*
         * Loading initial data in Database. Six students, three teachers, four
         * courses and grades for one course.
         */

        /*
         * Loading students
         */
        Student student1 = new Student();
        student1.setFirstName("Bruce");
        student1.setLastName("Wayne");
        student1.setRegistrationNumber(1);
        student1.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("25-05-1604").getTime()));
        studentDao.save(student1);

        Student student2 = new Student();
        student2.setFirstName("Clark");
        student2.setLastName("Kent");
        student2.setRegistrationNumber(2);
        student2.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("21-03-1990").getTime()));
        studentDao.save(student2);

        Student student3 = new Student();
        student3.setFirstName("Wade");
        student3.setLastName("Wilson");
        student3.setRegistrationNumber(3);
        student3.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("19-06-1990").getTime()));
        studentDao.save(student3);

        Student student4 = new Student();
        student4.setFirstName("Peter");
        student4.setLastName("Parker");
        student4.setRegistrationNumber(4);
        student4.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("31-10-1990").getTime()));
        studentDao.save(student4);

        Student student5 = new Student();
        student5.setFirstName("Gohan");
        student5.setLastName("Son");
        student5.setRegistrationNumber(5);
        student5.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("04-05-1980").getTime()));
        studentDao.save(student5);

        Student student6 = new Student();
        student6.setFirstName("Scarlet");
        student6.setLastName("Jahansen");
        student6.setRegistrationNumber(6);
        student6.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("28-01-1980").getTime()));
        studentDao.save(student6);

        /*
         * Loading teachers.
         */
        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Cosme");
        teacher1.setLastName("Fulanito");
        teacher1.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("04-11-1970").getTime()));

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Armando");
        teacher2.setLastName("Barreda");
        teacher2.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("03-08-1975").getTime()));

        Teacher teacher3 = new Teacher();
        teacher3.setFirstName("Willie");
        teacher3.setLastName("McDougal");
        teacher3.setBirthday(new Date(new SimpleDateFormat("dd-MM-yyyy").parse("01-01-1980").getTime()));

        /*
         * Loading courses.
         */
        Course course = new Course();
        course.setName("English");
        course.setTeacher(teacher1);
        List<Student> students_course = new LinkedList<Student>();
        students_course.add(student2);
        students_course.add(student3);
        students_course.add(student4);
        course.setStudents(students_course);
        List<CourseSchedule> schedule_course = new LinkedList<CourseSchedule>();
        CourseSchedule schedule = new CourseSchedule();
        schedule.setDay("Monday");
        schedule.setStartHour(new Date(new SimpleDateFormat("HH:mm").parse("17:00").getTime()));
        schedule.setEndHour(new Date(new SimpleDateFormat("HH:mm").parse("19:00").getTime()));
        schedule_course.add(schedule);
        schedule = new CourseSchedule();
        schedule.setDay("Tuesday");
        schedule.setStartHour(new Date(new SimpleDateFormat("HH:mm").parse("17:00").getTime()));
        schedule.setEndHour(new Date(new SimpleDateFormat("HH:mm").parse("19:00").getTime()));
        schedule_course.add(schedule);
        schedule = new CourseSchedule();
        schedule.setDay("Wednesday");
        schedule.setStartHour(new Date(new SimpleDateFormat("HH:mm").parse("17:00").getTime()));
        schedule.setEndHour(new Date(new SimpleDateFormat("HH:mm").parse("19:00").getTime()));
        schedule_course.add(schedule);
        course.setSchedule(schedule_course);
        courseDao.save(course);

        /*
         * Loading grades to course 1.
         */

        Grade grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student2);
        grade1.setGrade(10);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student2);
        grade1.setGrade(8);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student2);
        grade1.setGrade(6);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student2);
        grade1.setGrade(9);
        grade1.setGradeType("Final");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student3);
        grade1.setGrade(10);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student3);
        grade1.setGrade(10);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student3);
        grade1.setGrade(10);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student3);
        grade1.setGrade(10);
        grade1.setGradeType("Final");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student4);
        grade1.setGrade(2);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student4);
        grade1.setGrade(3);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student4);
        grade1.setGrade(0);
        grade1.setGradeType("Partial");
        gradeDao.save(grade1);

        grade1 = new Grade();
        grade1.setCourse(course);
        grade1.setStudent(student4);
        grade1.setGrade(0);
        grade1.setGradeType("Final");
        gradeDao.save(grade1);

        /*
         * Loading the rest of the courses.
         */
        course = new Course();
        course.setName("Japanese");
        course.setTeacher(teacher1);
        students_course = new LinkedList<Student>();
        students_course.add(student5);
        students_course.add(student6);
        course.setStudents(students_course);
        schedule_course = new LinkedList<CourseSchedule>();
        schedule = new CourseSchedule();
        schedule.setDay("Friday");
        schedule.setStartHour(new Date(new SimpleDateFormat("HH:mm").parse("08:00").getTime()));
        schedule.setEndHour(new Date(new SimpleDateFormat("HH:mm").parse("12:00").getTime()));
        schedule_course.add(schedule);
        course.setSchedule(schedule_course);
        courseDao.save(course);

        course = new Course();
        course.setName("French");
        course.setTeacher(teacher2);
        students_course = new LinkedList<Student>();
        students_course.add(student1);
        course.setStudents(students_course);
        schedule_course = new LinkedList<CourseSchedule>();
        schedule = new CourseSchedule();
        schedule.setDay("Saturday");
        schedule.setStartHour(new Date(new SimpleDateFormat("HH:mm").parse("10:00").getTime()));
        schedule.setEndHour(new Date(new SimpleDateFormat("HH:mm").parse("14:00").getTime()));
        schedule_course.add(schedule);
        course.setSchedule(schedule_course);
        courseDao.save(course);

        course = new Course();
        course.setName("Italian");
        course.setTeacher(teacher1);
        students_course = new LinkedList<Student>();
        students_course.add(student1);
        students_course.add(student5);
        students_course.add(student6);
        course.setStudents(students_course);
        schedule_course = new LinkedList<CourseSchedule>();
        schedule = new CourseSchedule();
        schedule.setDay("Sunday");
        schedule.setStartHour(new Date(new SimpleDateFormat("HH:mm").parse("18:00").getTime()));
        schedule.setEndHour(new Date(new SimpleDateFormat("HH:mm").parse("22:00").getTime()));
        schedule_course.add(schedule);
        course.setSchedule(schedule_course);
        courseDao.save(course);

    }
}
