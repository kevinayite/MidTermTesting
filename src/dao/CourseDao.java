package dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtility;
import jakarta.persistence.Query;
import model.AcademicUnit;
import model.Course;
import model.Semester;
import model.Student;
import model.Teacher;

import org.hibernate.boot.jaxb.cfg.spi.JaxbCfgEventTypeEnum;


public class CourseDao {
	
	// Save Student
    public void registerCourse(Course theCourse) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateCourse(Course theCourse) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theCourse);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteCourse(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            Course theCourse = session.get(Course.class, id);
            if (theCourse != null) {
                session.delete(theCourse);
                System.out.println("Student's records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<Course> getAllCourses() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM Course", Course.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    // Find Student By Id
	/*
	 * public Optional<Course> findById(String id) { try (Session session =
	 * HibernateUtility.getSession().openSession()) { Query query = session.
	 * createQuery("SELECT course FROM Course course WHERE course.courseCode = :id"
	 * ); query.setParameter("id", id); return Optional.ofNullable((Course)
	 * ((org.hibernate.query.Query) query).uniqueResult()); } catch (Exception e) {
	 * e.printStackTrace(); return null; } finally { session.close(); } return
	 * Optional.empty(); }
	 */
	/*
	 * public Optional<Course> findById(String id) { try (Session session =
	 * HibernateUtility.getSession().openSession()) { Query query = session.
	 * createQuery("SELECT course FROM Course course WHERE course.courseCode = :id"
	 * ); query.setParameter("id", id); return Optional.ofNullable((Course)
	 * ((org.hibernate.query.Query) query).uniqueResult()); } catch (Exception e) {
	 * e.printStackTrace(); // Return empty Optional in case of exception } finally
	 * { session.close(); // Close session in the finally block } return
	 * Optional.empty(); }
	 */
    public Optional<Course> findById(String id) {
        Session session = null;
        try {
            session = HibernateUtility.getSession().openSession();
            Query query = session.createQuery("SELECT course FROM Course course WHERE course.courseCode = :id");
            query.setParameter("id", id);
            return Optional.ofNullable((Course) ((org.hibernate.query.Query) query).uniqueResult());
        } catch (Exception e) {
            e.printStackTrace();
            // Return empty Optional in case of exception
        } finally {
            if (session != null) {
                session.close(); // Close session in the finally block
            }
        }
        return Optional.empty();
    }

    
    // This function is here that the table is not populating manually
    public void enrollCourseToSemester(Course course, Semester targetSemester) {
        Session session = HibernateUtility.getSession().openSession();
        System.out.println("Course object: " + course);
        System.out.println("Course code: " + course.getCourseCode());
        System.out.println("Target Semester object: " + targetSemester);
        System.out.println("Target Semester ID: " + targetSemester.getSemId());

        try {
            Transaction transaction = session.beginTransaction();

            System.out.println("Course object: " + course);
            System.out.println("Course code: " + course.getCourseCode());
            if (course.getCourseCode() == null) {
                System.out.println("Course code is null!");
            }

            System.out.println("Retrieving Course object...");
            course = session.get(Course.class, course.getCourseCode());
            System.out.println("Course object retrieved: " + course);

            System.out.println("Merging Target Semester object...");
            targetSemester = (Semester) session.merge(targetSemester);
            System.out.println("Target Semester object merged: " + targetSemester);

            System.out.println("Target Semester ID: " + targetSemester.getSemId());
            if (targetSemester.getSemId() == null) {
                System.out.println("Target Semester ID is null!");
            }

            course.getSemesters().add(targetSemester);
            targetSemester.getCourses().add(course);

            System.out.println("Saving Course and Target Semester objects...");
            session.saveOrUpdate(course);
            session.saveOrUpdate(targetSemester);

            transaction.commit();
            System.out.println("Course enrolled to semester successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
    
	
	/*
	 * public void assignTeacherToCourse(Teacher targetTeacher, Course targetCourse)
	 * { Transaction transaction = null; Session session =
	 * HibernateUtility.getSession().openSession(); try { transaction =
	 * session.beginTransaction(); targetTeacher = session.get(Teacher.class,
	 * targetTeacher.getCode()); targetCourse = session.get(Course.class,
	 * targetCourse.getCourseCode()); targetTeacher.getCourses().add(targetCourse);
	 * targetCourse.getTeachers().add(targetTeacher);
	 * session.saveOrUpdate(targetTeacher); session.saveOrUpdate(targetCourse);
	 * transaction.commit(); } catch (Exception e) { e.printStackTrace(); if
	 * (transaction != null) { transaction.rollback(); } } finally {
	 * session.close(); } }
	 */
	 
    
	/*
	 * public void assignTeacherToCourse(String teacherCode, String courseCode) {
	 * Transaction transaction = null; Session session =
	 * HibernateUtility.getSession().openSession();
	 * 
	 * try { transaction = session.beginTransaction();
	 * 
	 * Teacher targetTeacher = session.get(Teacher.class, teacherCode); Course
	 * targetCourse = session.get(Course.class, courseCode);
	 * 
	 * if (targetTeacher != null && targetCourse != null) {
	 * targetTeacher.getCourses().add(targetCourse);
	 * targetCourse.getTeachers().add(targetTeacher);
	 * 
	 * session.saveOrUpdate(targetTeacher); session.saveOrUpdate(targetCourse); }
	 * else { System.out.println("Invalid teacher or course code provided."); }
	 * 
	 * transaction.commit(); } catch (Exception e) { e.printStackTrace(); if
	 * (transaction != null) { transaction.rollback(); } } finally {
	 * session.close(); } }
	 */
    
	
	  public void assignTeacherToCourse(Teacher targetTeacher, Course targetCourse)
	  { Transaction transaction = null; Session session =
	  HibernateUtility.getSession().openSession();
	  
	  try { transaction = session.beginTransaction();
	  
	  targetCourse.getTeachers().add(targetTeacher);
	  targetTeacher.getCourses().add(targetCourse);
	  
	  session.saveOrUpdate(targetTeacher); session.saveOrUpdate(targetCourse);
	  
	  transaction.commit(); } catch (Exception e) { e.printStackTrace(); if
	  (transaction != null) { transaction.rollback(); } } finally {
	  session.close(); } }
	 
    
    
    
    public List<Course> fetchCoursesByStudent(Student targetStudent) {
        Session session = HibernateUtility.getSession().openSession();
        try {
            Query query = session.createQuery(
                "select studentCourse.course from StudentCourse studentCourse " +
                "where studentCourse.student = :targetStudent"
            );
            query.setParameter("targetStudent", targetStudent);
            return ((org.hibernate.query.Query) query).list();
        } catch (Exception exception) {
            exception.printStackTrace();
        } finally {
            session.close();
        }
        return null;
    }

    
    
    
    public List<Course> fetchCoursesByDepartmentAndSemester(AcademicUnit targetDepartment, Semester targetSemester) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Query query = session.createQuery(
                "select distinct course from Course course " +
                "join course.department department " +
                "join course.semesters semester " +
                "where department = :targetDepartment " +
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





}
