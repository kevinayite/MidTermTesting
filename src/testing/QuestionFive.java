package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.CourseDao;
import model.Course;
import model.Student;

public class QuestionFive {

	@Test
	public void testFetchCoursesByStudent() {
	    
		CourseDao courseDao = new CourseDao();
		Student theStudent = new Student(); 
		theStudent.setRegNo("24448"); 
	    List<Course> courses = courseDao.fetchCoursesByStudent(theStudent);
	    assertNotNull(courses);

	}
}
