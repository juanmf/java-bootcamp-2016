select 
concat(CourseName) as Class, 
concat(Teacher.LastName, ', ', Teacher.FirstName) as Teacher, 
concat(Student.LastName, ", ",Student.FirstName) as Students
    
	from CourseList 
    inner join Course on courseList.Course = Course.idCourse
    inner join Teacher on Course.AssignedTeacher = Teacher.idTeacher
    inner join Student on CourseList.Student = Student.RegNumber
	
    order by Course.idCourse, Student.LastName asc;
