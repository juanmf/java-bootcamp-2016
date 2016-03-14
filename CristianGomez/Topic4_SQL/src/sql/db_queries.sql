USE highschool;
    
-- 3. List students and teachers for a given course.
-- Course: <course-name>
-- Teacher: <last-name>, <first-name>
-- Students:
--   <last-name>, <first-name> (ordered by alphabetically by last name)

SET @courseName = 'Math';
SELECT HIGH_PRIORITY c.name  AS 'Course Name',
        CONCAT_WS(', ',t.lastname, t.firstname) AS 'Teacher',
        CONCAT_WS(', ',s.lastname, s.firstname) AS 'Student'
    FROM teacher t
        INNER JOIN course c USING (teacher_id)
        INNER JOIN course_inscription ci USING (course_id)
        INNER JOIN student s USING (student_id)
    WHERE c.name = @courseName
    ORDER BY s.lastname;

-- 4. Percentage of students that passed/failed a given course.

SET @approvingNote = 7;
SELECT HIGH_PRIORITY (SELECT COUNT(*)
            FROM course c INNER JOIN course_inscription ci USING (course_id)
            WHERE c.name = @courseName and ci.finalnote >= @approvingNote)
        / COUNT(*) * 100 AS 'Passed %'
        FROM course co INNER JOIN course_inscription USING (course_id)
        WHERE co.name = @courseName;

-- 5. For a given teacher, list the timeline for each course that he is assigned to (ordered by date), and the course name.
-- The format should be:
-- Teacher: <last-name>, <first-name>
-- Schedule:
--   Monday 09:00 - 11:00: <course-name>
--   Monday 15:00 - 17:30: <course-name>
--   Friday 08:45 - 10:40: <course-name>

SET @teacherId = 1;
SELECT HIGH_PRIORITY CONCAT(t.firstname, ' ',t.lastname) AS 'Teacher',
        s.dayofweek AS 'Day', TIME_FORMAT(s.starttime, '%H:%i') AS 'From', TIME_FORMAT(s.endtime, '%H:%i') AS 'To',
        c.name AS 'Course Name'
    FROM teacher t
        INNER JOIN course c USING (teacher_id)
        INNER JOIN schedule s USING (course_id)
    WHERE t.teacher_id = @teacherId
    ORDER BY FIELD(s.dayofweek, 'monday', 'tuesday', 'wednesday', 'thursday', 'friday', 'saturday', 'sunday');

