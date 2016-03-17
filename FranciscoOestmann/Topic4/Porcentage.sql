select
concat("Pass: ", round((((select count(FinalNote) from CourseList where FinalNote >=7 and Course = 1)*100)/ (select count(*) from CourseList where Course = 1))), "%", ", Fail: ", 
round((((select count(FinalNote) from CourseList where FinalNote < 7 and Course = 1)*100)/ (select count(*) from CourseList where Course = 1))), "%")  as WebServices,

concat("Pass: ", round((((select count(FinalNote) from CourseList where FinalNote >=7 and Course = 2)*100)/ (select count(*) from CourseList where Course = 2))), "%", ", Fail: ", 
round((((select count(FinalNote) from CourseList where FinalNote < 7 and Course = 2)*100)/ (select count(*) from CourseList where Course = 2))), "%")  as OSDevelopment,

concat("Pass: ", round((((select count(FinalNote) from CourseList where FinalNote >=7 and Course = 3)*100)/ (select count(*) from CourseList where Course = 3))), "%", ", Fail: ", 
round((((select count(FinalNote) from CourseList where FinalNote < 7 and Course = 3)*100)/ (select count(*) from CourseList where Course = 3))), "%")  as FreeSoftware
    
    from CourseList course
    limit 1;