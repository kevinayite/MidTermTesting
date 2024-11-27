package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtility;
import jakarta.persistence.Query;
import model.AcademicUnit;
import model.Course;
import model.Semester;
import model.Student;
import model.StudentRegistration;

public class StudentRegistrationDao {
	
	// Save Student
    public void registerStudentRegistration(StudentRegistration registration) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(registration);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateSemester(StudentRegistration registration) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(registration);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteSemester(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            StudentRegistration registration = session.get(StudentRegistration.class, id);
            if (registration != null) {
                session.delete(registration);
                System.out.println(" records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<StudentRegistration> getAllSemesters() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM StudentRegistration", StudentRegistration.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
    public List<StudentRegistration> getAllStudentAndSemester(Semester semester) {
		Session ss = HibernateUtility.getSession().openSession();
		try {
			Query query = ss.createQuery("select reg from StudentRegistration reg where reg.semester = :semester");
			query.setParameter("semester", semester);
			return ((org.hibernate.query.Query<StudentRegistration>) query).list();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
    
    public List<Student> fetchStudentsBySemester(Semester targetSemester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = session.createQuery("select registration.student from StudentRegistration registration where registration.semester = :targetSemester");
            query.setParameter("targetSemester", targetSemester);
            return ((org.hibernate.query.Query) query).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    
    public List<Student> fetchStudentsByDepartmentAndSemester(AcademicUnit targetDepartment, Semester targetSemester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = session.createQuery(
                "select distinct student from Student student " +
                "inner join student.studentRegistration registration " +
                "inner join registration.semester semester " +
                "where student.department = :targetDepartment " +
                "and semester = :targetSemester"
            );
            query.setParameter("targetDepartment", targetDepartment);
            query.setParameter("targetSemester", targetSemester);
            return ((org.hibernate.query.Query) query).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
    
   

    
    public List<Student> fetchStudentsEnrolledInCourseAndSemester(Course targetCourse, Semester targetSemester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = session.createQuery(
                "select distinct studentCourse.student from StudentCourse studentCourse " +
                "inner join studentCourse.course course " +
                "inner join studentCourse.student student " +
                "inner join student.studentRegistration studentRegistration " +
                "where course = :targetCourse " +
                "and studentRegistration.semester = :targetSemester"
            );
            query.setParameter("targetCourse", targetCourse);
            query.setParameter("targetSemester", targetSemester);
            return ((org.hibernate.query.Query) query).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }





}
