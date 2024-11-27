package testing;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;

import dao.StudentRegistrationDao;
import model.Course;
import model.Semester;
import model.Student;


public class QuestionThree {

	
	@Test
	public void testFetchStudentsEnrolledInCourseAndSemester() {
	    
		StudentRegistrationDao registrationStudDao = new StudentRegistrationDao();
	    Course course = new Course(); 
	    course.setCourseCode("INSY425");
	    Semester theSemester = new Semester();
	    theSemester.setSemId("SemJanuary");

	    List<Student> etudiants = registrationStudDao.fetchStudentsEnrolledInCourseAndSemester(course, theSemester);
	    assertNotNull(etudiants);
	    
	}


}
