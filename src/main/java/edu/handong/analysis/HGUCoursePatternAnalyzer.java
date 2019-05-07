package edu.handong.analysis;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	private String[] lines = {	
						"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};
	private  int numOfStudents;
	private  int numOfCourses;
	private  Student[] students;
	private  Course[] courses;
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			if(student!=null)
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			if(course!=null) {
			System.out.println(course.getCourseName());
		}
		}
	}
	
	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		Student [] array1 = new Student[20];
		for(int i=0;i<lines.length;i++) {
			
			String oneline = lines[i];
			String name1 = oneline.split("\\s*,\\s*")[1];
			Student stu1;
			stu1 = new Student(name1);		
			if (studentExist(array1, stu1)!=true) {
			
				array1[i] = stu1;
			
		}
		}		
		return array1;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) 
	{
		
		for (Student stu : students )
		{
			if (stu!=null) {
			if (stu.getName().equals(student.getName()))
			{
		return true;
			}
		}
		}
		// TODO: implement this method
		return false;
	}
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		Course[] array2 =new Course[12];
		for(int i=0;i<lines.length;i++) {
			String oneline = lines[i];
			String tmp = oneline.split("\\s*,\\s*")[2];
			Course courcour ;
			courcour = new Course(tmp);
			if(courseExist(array2, courcour)!=true) {
			array2[i]= new Course(tmp);
			
		}
		}
		// TODO: implement this method
		return array2;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		for (Course cour : courses)
		{
			if(cour!=null) {
			if(cour.getCourseName().contentEquals(course.getCourseName()))
			{
				return true;
			}
		}
		}
			return false;
		}
}
		
	
