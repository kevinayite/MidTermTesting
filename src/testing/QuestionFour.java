package testing;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import dao.CourseDao;
import model.AcademicUnit;
import model.Course;
import model.Semester;

public class QuestionFour {

	@Test
	public void testFetchCoursesByDepartmentAndSemester() {
	    
		CourseDao courseDao = new CourseDao();
	    AcademicUnit department = new AcademicUnit(); 
	    department.setCode("4"); 
	    Semester theSemester = new Semester();
	    theSemester.setSemId("SemJanuary");
	    List<Course> courses = courseDao.fetchCoursesByDepartmentAndSemester(department, theSemester);
	    assertNotNull(courses);

	}
}	
