package view;

import java.time.LocalDate;
import java.util.*;

import dao.AcademicUnitDao;
import dao.CourseDao;
import dao.SemesterDao;
import dao.StudentCourseDao;
import dao.StudentDao;
import dao.StudentRegistrationDao;
import dao.TeacherDao;
import model.AcademicUnit;
import model.Course;
import model.EAcademicUnit;
import model.EQualification;
import model.Semester;
import model.Student;
import model.StudentCourse;
import model.StudentRegistration;
import model.Teacher;

public class Interface {
	
	public static void main(String[] args) {
		
		String studentId;
		String name;
		LocalDate dob;
		String department;
		boolean condition = true;
		Student theStudent = new Student();
		AcademicUnit academy = new AcademicUnit();
		Semester theSemester = new Semester();
		Teacher theTeacher = new Teacher();
		Course theCourse = new Course();
		StudentRegistration theRegistration = new StudentRegistration();
		StudentCourseDao daoTheStudentCourse = new StudentCourseDao();
		StudentCourse theStudentCourse = new StudentCourse();
		String answer, searchUnit;
		String semesterId, semesterName;
		LocalDate startDate, endDate;
		String coursCode, coursName, coursDesc, coursDpt;
		String teacherCode, teacherName, qualification;
		String registrationId, studId,semId;
		LocalDate dateOfRegistration;
		
		
		while(condition) {
			System.out.println("=========================================");
			System.out.println("            AUCA Management          ");
			System.out.println("=========================================");
			System.out.println("1. Register a Student");
			System.out.println("2. Automate Academic Unit");
			System.out.println("3. Insert Semester");
			System.out.println("4. Insert a course");
			System.out.println("                                         ");
			System.out.println("=========================================");
			System.out.println("                                         ");
			System.out.println("=========================================");
			System.out.println("5. Register a Teacher");
			System.out.println("6. Insert Into Student Registration");
			System.out.println("7. Enroll Course To Semester");
			System.out.println("8. Enroll Teacher To Course");
			System.out.println("9. Enroll Student To Course");
			System.out.println("=========================================");
			System.out.println("            Listing Records          ");
			System.out.println("=========================================");
			System.out.println("10. Display Students per Semester");
			System.out.println("11. Display Students per  Department and Semester");
			System.out.println("12. Display Students per Course and Semester");
			System.out.println("13. Display Course per department and Semester");
			System.out.println("14. Display courses per student");
			System.out.println("Press 0 to exit");
			System.out.println("                                         ");
			System.out.println("                                         ");
			System.out.println("=========================================");
			System.out.print("Choose an option:\t");
			Scanner sc = new Scanner(System.in);
			int option = sc.nextInt();
			
			
			switch(option) {
			case 1:
				
				  System.out.print("Enter Student ID: "); 
				  studentId = sc.next();
				  System.out.print("Enter student's name: ");
				  name = sc.next();
				  System.out.print("Enter Birth of Date of the student: "); 
				  String dobString = sc.next();
				  dob = LocalDate.parse(dobString);
				  System.out.println("Enter the department of the student");
				  department = sc.next();
				  
	              AcademicUnitDao dao = new AcademicUnitDao();
	              AcademicUnit dep = dao.findById(department);
				  
				  
				  theStudent.setRegNo(studentId); theStudent.setName(name);
				  theStudent.setDateOfBirth(dob); 
				  theStudent.setDepartment(dep);
				  StudentDao studentSave = new StudentDao();
				  studentSave.registerStudent(theStudent);
				  System.out.println("Student Saved");
				  System.out.println("Do you wish to continue enter Yes or No"); answer =
				  sc.next(); if(answer.equalsIgnoreCase("yes")){ condition = true; }else{
				  System.out.println("Thank you for using the system"); condition = false; }
				  break;
				 
				/*System.out.print("Enter Student ID: ");
				studentId = sc.next();

				// Consume the remaining newline character
				sc.nextLine(); // Add this line

				System.out.print("Enter student's name: ");
				name = sc.nextLine(); // Change this line

				System.out.print("Enter Birth of Date of the student: ");
				//String dobString = sc.next();

				dob = LocalDate.parse(dobString);

				theStudent.setRegNo(studentId);
				theStudent.setName(name);
				theStudent.setDateOfBirth(dob);

				//StudentDao studentSave = new StudentDao();
				studentSave.registerStudent(theStudent);

				System.out.println("Student Saved");
				System.out.println("Do you wish to continue enter Yes or No");

				answer = sc.next();

				if (answer.equalsIgnoreCase("yes")) {
				    condition = true;
				} else {
				    System.out.println("Thank you for using the system");
				    condition = false;
				}

				break;
				*/
			case 2:
				/*
				 * AcademicUnit programme = new AcademicUnit();
				 * 
				 * programme.setCode("2"); programme.setAcademicUnit(EAcademicUnit.PROGRAM);
				 * programme.setName("UNDERGRADUATE PROGRAM"); programme.setFaculty(null);
				 * programme.setProgram(null); AcademicUnitDao saveProgram = new
				 * AcademicUnitDao(); saveProgram.registerAcademic(programme);
				 * System.out.println("Saved");
				 */   
				/*
				 * AcademicUnit faculties = new AcademicUnit();
				 * 
				 * faculties.setCode("3"); faculties.setAcademicUnit(EAcademicUnit.FACULTY);
				 * faculties.setName("Information Technology"); faculties.setFaculty(null);
				 * AcademicUnitDao saveFaculty = new AcademicUnitDao(); AcademicUnit facultyUnit
				 * = saveFaculty.findById("2"); faculties.setProgram(facultyUnit);
				 * 
				 * saveFaculty.registerAcademic(faculties); System.out.println("Saved");
				 */
			       
			       
				/*
				 * AcademicUnit department = new AcademicUnit(); department.setCode("4");
				 * department.setAcademicUnit(EAcademicUnit.DEPARTMENT);
				 * department.setName("Software Engineering");
				 * 
				 * AcademicUnitDao savedpt = new AcademicUnitDao();
				 * 
				 * AcademicUnit facUnit = savedpt.findById("2"); department.setFaculty(facUnit);
				 * AcademicUnit dptUnit = savedpt.findById("3"); department.setProgram(dptUnit);
				 * 
				 * savedpt.registerAcademic(department); System.out.println("Saved");
				 * System.out.println("Do you wish to continue enter Yes or No"); answer =
				 * sc.next(); if(answer.equalsIgnoreCase("yes")){ condition = true; }else{
				 * System.out.println("Thank you for using the system"); condition = false; }
				 */
			       
				break;
			case 3:
				System.out.print("Enter Semester ID: ");
				semesterId = sc.next();
                System.out.print("Enter semester's name: ");
                semesterName = sc.next();
                System.out.print("Enter the start of Date of the semester: ");
                String startString = sc.next();
                startDate = LocalDate.parse(startString);
                System.out.print("Enter the end of Date of the semester: ");
                String endString = sc.next();
                endDate = LocalDate.parse(endString);
                

                theSemester.setSemId(semesterId);
                theSemester.setSemName(semesterName);
                theSemester.setStartDate(startDate);
                theSemester.setEndDate(endDate);
                SemesterDao semesterSave = new SemesterDao();
                semesterSave.registerSemester(theSemester);
                System.out.println("Semester Saved");
                System.out.println("Do you wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
				
			case 4:
				System.out.print("Enter course code: ");
				coursCode = sc.next();
                System.out.print("Enter Course's name: ");
                coursName = sc.next();
                System.out.print("Enter the description of  the course: ");
                coursDesc = sc.next();
                
                System.out.print("Enter the department of the course: ");
                coursDpt = sc.next();
                
                

                theCourse.setCourseCode(coursCode);
                theCourse.setCourseName(coursName);
                theCourse.setDescription(coursDesc);
                CourseDao courseSave = new CourseDao();
                
                AcademicUnitDao daoOne = new AcademicUnitDao();
                AcademicUnit depart = daoOne.findById(coursDpt);
                theCourse.setDepartment(depart);
                
                courseSave.registerCourse(theCourse);
                System.out.println("Course Saved");
                System.out.println("Do you wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
				
			case 5:
				System.out.print("Enter Teacher code: ");
				teacherCode = sc.next();
                System.out.print("Enter Teacher's name: ");
                teacherName = sc.next();
                System.out.print("Enter the qualification: ");
                qualification = sc.next();
                
                theTeacher.setCode(teacherCode);
                theTeacher.setName(teacherName);
                theTeacher.setQualification(EQualification.MASTER);
                TeacherDao teacherSave = new TeacherDao();
                teacherSave.registerTeacher(theTeacher);
                
                System.out.println("Teacher Saved");
                System.out.println("Do you wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
				
			case 6:
				System.out.print("Enter Registration ID: ");
				registrationId = sc.next();
                System.out.print("Enter Registration Date");
                String date = sc.next();
                dateOfRegistration = LocalDate.parse(date);
                System.out.print("Enter Semester ID: ");
                semId = sc.next();
                System.out.print("Enter Student ID: ");
                studId = sc.next();
                theRegistration.setRegDate(dateOfRegistration);
                theRegistration.setRegId(registrationId);
                SemesterDao daoSem = new  SemesterDao();
                Semester sem = daoSem.findById(semId);
				theRegistration.setSemester(sem);
				StudentDao daoStu = new StudentDao();
				Student students = daoStu.findById(studId);
				theRegistration.setStudent(students);
				
				StudentRegistrationDao regStudDao = new StudentRegistrationDao();
				regStudDao.registerStudentRegistration(theRegistration);
                System.out.println("Student Registration Saved");
                System.out.println("Do you wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
				
			case 7:
				System.out.print("Enter course ID: ");
				coursCode = sc.next();
                System.out.print("Enter semester ID");
                semId = sc.next();
                // Here before insert it in the table we need to make sure that
                // it is already there in our database
                CourseDao daoCourse = new CourseDao();
                SemesterDao daoSemester = new SemesterDao();
                Course cours = null;
			    Semester semester = daoSemester.findById(semId);
			    if (semester != null) {
			        cours = daoCourse.findById(coursCode).get();
			        if (cours != null) {
			            daoCourse.enrollCourseToSemester(cours, semester);
			            System.out.println("Course added to semester successfully.");
			        } else { // No course matching to that input
			            System.out.println("Course not found.");
			        }
			    } else { // No semester matching to that input
			        System.out.println("Semester not found.");
			    }
                
                System.out.println("Do you wish to continue enter Yes or No");
                answer = sc.next();
                if(answer.equalsIgnoreCase("yes")){
                    condition = true;
                }else{
                    System.out.println("Thank you for using the system");
                    condition = false;
                }
				break;
				
			//case 8:
				/*
				 * System.out.print("Enter course ID: "); String courseCode = sc.next();
				 * System.out.print("Enter Teacher ID"); String teachCode = sc.next(); // Here
				 * before insert it in the table we need to make sure that // it is already
				 * there in our database CourseDao daoCourses = new CourseDao(); TeacherDao
				 * daoTeacher = new TeacherDao(); Course coursT =
				 * daoCourses.findById(courseCode).get(); Teacher teacherC =
				 * daoTeacher.findById(teachCode).get(); if(coursT != null && teacherC != null)
				 * { daoCourses.assignTeacherToCourse(teacherC, theCourse);
				 * System.out.println("Teacher has been assigned to Course"); }else {
				 * System.out.
				 * println("Information that you have entered are not in our records "); }
				 * 
				 * 
				 * System.out.println("Do you wish to continue enter Yes or No"); answer =
				 * sc.next(); if(answer.equalsIgnoreCase("yes")){ condition = true; }else{
				 * System.out.println("Thank you for using the system"); condition = false; }
				 * break;
				 */
				
				
			case 8:
			    System.out.print("Enter course ID: ");
			    String courseCode = sc.next();

			    System.out.print("Enter Teacher ID");
			    String teachCode = sc.next();

			    // Here before inserting it in the table, we need to make sure that
			    // it is already there in our database
			    CourseDao daoCourses = new CourseDao();
			    TeacherDao daoTeacher = new TeacherDao();

			    Optional<Course> optionalCourse = daoCourses.findById(courseCode);
			    Optional<Teacher> optionalTeacher = daoTeacher.findById(teachCode);

			    if (optionalCourse.isPresent() && optionalTeacher.isPresent()) {
			        Course course = optionalCourse.get();
			        Teacher teacher = optionalTeacher.get();
			        daoCourses.assignTeacherToCourse(teacher, course);
			        System.out.println("Teacher has been assigned to Course");
			    } else {
			        System.out.println("Information that you have entered is not in our records.");
			    }

			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;

			    
			case 9:
			    System.out.print("Enter student ID: ");
			    String registratioId = sc.next();

			    System.out.print("Enter course code");
			    String codecourse = sc.next();
			    System.out.print("Enter the marks of the student");
			    double marks = sc.nextDouble();
			    StudentDao daoStud = new StudentDao();
			    Student stuDao = daoStud.findById(registratioId);
			    CourseDao daoTheCourse = new CourseDao();
			    Course newCourse = new Course();
			    try {
			    	newCourse = daoTheCourse.findById(codecourse).orElseThrow(() -> new NoSuchElementException("Course not found."));
			    } catch (NoSuchElementException e) {
			        System.out.println("Course not found.");
			        return;
			    }
			    
			    
			    theStudentCourse.setCourse(newCourse);
			    theStudentCourse.setStudent(stuDao);
			    theStudentCourse.setResults(marks);
			    daoTheStudentCourse.registerStudent(theStudentCourse);
			    System.out.println("Record saved! ");

			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 10:
			    System.out.println("Enter Semester ID");
			    String idSem = sc.next();
			    SemesterDao semeDao = new SemesterDao();
			    Semester output = semeDao.findById(idSem);

			    if (output != null) {
			        StudentRegistrationDao daoStuReg = new StudentRegistrationDao();
			        List<Student> displayAllStudentsBySemester = daoStuReg.fetchStudentsBySemester(output);

			        if (!displayAllStudentsBySemester.isEmpty()) {
			            System.out.println("Students enrolled in this semester " + output.getSemName() + ":");
			            for (Student student : displayAllStudentsBySemester) {
			                System.out.println("- " + student.getName() + " (" + student.getRegNo() + ")" + " (" + student.getDateOfBirth() + ")");
			            }
			        } else {
			            System.out.println("No students enrolled in this semester.");
			        }
			    } else {
			        System.out.println("Semester not found.");
			    }

			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 11:
			    System.out.println("Enter Department Code:");
			    String departmentCode = sc.next();
			    System.out.println("Enter Semester ID:");
			    String semister = sc.next();

			   
			    AcademicUnitDao academyDao = new AcademicUnitDao();
			    AcademicUnit departments = academyDao.findById(departmentCode);
			    SemesterDao semestersDaos = new SemesterDao();
			    Semester semesters = semestersDaos.findById(semister);

			    if (departments != null && semesters != null) {
			        StudentRegistrationDao daoStudReg = new StudentRegistrationDao();
			        List<Student> etudiants = daoStudReg.fetchStudentsByDepartmentAndSemester(departments, semesters);

			        if (!etudiants.isEmpty()) {
			            System.out.println("Students enrolled in " + departments.getName() + " department for semester " + semesters.getSemName() + ":");
			            for (Student etudiant : etudiants) {
			                System.out.println("- " + etudiant.getName() + " (" + etudiant.getRegNo() + ")");
			                System.out.println("---------------------------------------------------------");
			            }
			        } else {
			            System.out.println("No students enrolled in this department and semester combination.");
			        }
			    } else {
			        System.out.println("Department or semester not found.");
			    }

			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			    
			case 12:
				System.out.println("Enter Course Code:");
				String courseCodeInput = sc.next();
				System.out.println("Enter Semester ID:");
				String semesterIDInput = sc.next();

				CourseDao courseDao = new CourseDao();
				SemesterDao semesterDao = new SemesterDao();

				Course selectedCourse = courseDao.findById(courseCodeInput).orElse(null);
				Semester selectedSemester = semesterDao.findById(semesterIDInput);

				if (selectedCourse != null && selectedSemester != null) {
				    StudentRegistrationDao studentRegistrationDao = new StudentRegistrationDao();
				    List<Student> enrolledStudents = studentRegistrationDao.fetchStudentsEnrolledInCourseAndSemester(selectedCourse, selectedSemester);

				    if (!enrolledStudents.isEmpty()) {
				        System.out.println("Students enrolled in " + selectedCourse.getCourseName() + " for semester " + selectedSemester.getSemName() + ":");
				        for (Student student : enrolledStudents) {
				            System.out.println("- " + student.getName() + " (" + student.getRegNo() + ")");
				            System.out.println("---------------------------------------------------------");
				        }
				    } else {
				        System.out.println("No students enrolled in this course and semester combination.");
				    }
				} else {
				    System.out.println("Course or semester not found.");
				}
				
			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 13:
				System.out.println("Enter Department Code:");
				String departmentInput = sc.next();
				System.out.println("Enter Semester ID:");
				String semesterInput = sc.next();

				AcademicUnitDao daoAcademy = new AcademicUnitDao();
				AcademicUnit selectedDepartment = daoAcademy.findById(departmentInput);
				SemesterDao daoSemster = new SemesterDao();
				Semester selecteSemester = daoSemster.findById(semesterInput);

				if (selectedDepartment != null && selecteSemester != null) {
				    CourseDao courseDaos = new CourseDao();
				    List<Course> courses = courseDaos.fetchCoursesByDepartmentAndSemester(selectedDepartment, selecteSemester);

				    if (!courses.isEmpty()) {
				        System.out.println("Courses offered by " + selectedDepartment.getName() + " department for semester " + selecteSemester.getSemName() + ":");
				        for (Course course : courses) {
				            System.out.println("- " + course.getCourseName() + " (" + course.getCourseCode() + ")");
				            System.out.println("---------------------------------------------------------");
				        }
				    } else {
				        System.out.println("No courses found for this department and semester combination.");
				    }
				} else {
				    System.out.println("Department or semester not found.");
				}
				
			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;
			    
			case 14:
				System.out.println("Enter Student ID: ");
				String studentIDInput = sc.next();

				StudentDao studentDao = new StudentDao();
				Student student = studentDao.findById(studentIDInput);

				if (student != null) {
				    CourseDao courseDaos = new CourseDao();
				    List<Course> coursesForStudent = courseDaos.fetchCoursesByStudent(student);

				    if (!coursesForStudent.isEmpty()) {
				        System.out.println("Courses for student " + student.getName() + " (" + student.getRegNo() + "):");
				        for (Course course : coursesForStudent) {
				            System.out.println("- " + course.getCourseName() + " (" + course.getCourseCode() + ")");
				            System.out.println("---------------------------------------------------------");
				        }
				    } else {
				        System.out.println("No courses found for the given student ID.");
				    }
				} else {
				    System.out.println("Student not found.");
				}
				
				
			    System.out.print("Do you wish to continue? Enter 'Yes' or 'No': ");
			    answer = sc.next();

			    if (answer.equalsIgnoreCase("yes")) {
			        condition = true;
			    } else {
			        System.out.println("Thank you for using the system");
			        condition = false;
			    }
			    break;





				
			
				
				
			case 0:
				System.out.println("Thank you for using the system");
            	System.exit(0);
            	break;
            default:
                System.out.println("....");
			}
			
		}
		
		
		
	}
	
	
}
