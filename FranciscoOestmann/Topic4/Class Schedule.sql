SELECT concat(Teacher.LastName, ", ", Teacher.FirstName) AS Teacher, concat(DaysInWeek.Day, " ", 
classperweek.Hour, ": ", Course.CourseName) AS Class_Schedule
	FROM classperweek 
    INNER JOIN Course ON Course.idCourse = classperweek.CoursesInWeek
    INNER JOIN Teacher ON Course.AssignedTeacher = Teacher.idTeacher
    INNER JOIN daysinweek ON daysinweek.idDay = classperweek.Day
    ORDER BY Teacher.LastName, classperweek.Day; 