package dao;

import java.util.*;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtility;
import jakarta.persistence.Query;
import model.Course;
import model.Teacher;

public class TeacherDao {
	
	// Save Student
    public void registerTeacher(Teacher theTeacher) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(theTeacher);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Update Student Infos
    public void updateSemester(Teacher theTeacher) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(theTeacher);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    	// Delete Student's records
    public void deleteSemester(String id) {
        try (Session session = HibernateUtility.getSession().openSession()) {
            Transaction transaction = session.beginTransaction();
            Teacher theTeacher = session.get(Teacher.class, id);
            if (theTeacher != null) {
                session.delete(theTeacher);
                System.out.println(" records have been deleted");
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    // Display All Students
    public List<Teacher> getAllTeachers() {
        try (Session session = HibernateUtility.getSession().openSession()) {
            return session.createQuery("FROM Teacher", Teacher.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

	  
	  public Optional<Teacher> findById(String id) {
		    Session session = null;
		    try {
		        session = HibernateUtility.getSession().openSession();
		        Query query = session.createQuery("SELECT teacher FROM Teacher teacher WHERE teacher.code = :id");
		        query.setParameter("id", id);
		        return Optional.ofNullable((Teacher) ((org.hibernate.query.Query<Teacher>) query).uniqueResult());
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
	  
	
	 
    



}
