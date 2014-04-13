package ch.ne.ceg.hibernate.helloworld.annotation.manytomany;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * @author mchavaillaz Description: Contains useful methods
 */
public class Tools {

	/**
	 * Description: Print the result of a query of a List<Student> with his
	 * Set<Lesson>
	 * @param resultList: List<Student> to print
	 */
	public static void printResultQueryFromStudent(List<Student> resultList) {
		Iterator<Student> itRes = resultList.iterator();

		// Iterate over List<Student>
		while (itRes.hasNext()) {
			Student std = (Student) itRes.next();

			System.out.println("Student id: " + std.getId());
			System.out.println("Student first name: " + std.getFirstName());
			System.out.println("Student last name: " + std.getLastName());

			// Try to get the Set<Contenu> for the current Stock if exist
			try {
				Set<Lesson> lessons = std.getLessons();

				Iterator<Lesson> itLessons = lessons.iterator();

				while (itLessons.hasNext()) {
					Lesson lesson = (Lesson) itLessons.next();

					System.out.println("Lesson id: " + lesson.getLessonId());
					System.out.println("Lesson name: " + lesson.getLessonName());
					System.out.println("Lesson room number: " + lesson.getLessonRoomNumber());
				}

			} catch (Exception e) {
				System.err.println("Tools.java printResultQueryFromStudent() No Contenu available " + e.toString());
			}
		}
	}

	/**
	 * Description: Print the result of a query of a List<Lesson> with his
	 * Set<Student>
	 * @param resultList: List<Lesson> to print
	 */
	public static void printResultQueryFromLesson(List<Lesson> resultList) {
		Iterator<Lesson> itLes = resultList.iterator();

		// Iterate over List<Student>
		while (itLes.hasNext()) {
			Lesson lesson = (Lesson) itLes.next();

			System.out.println("Lesson id: " + lesson.getLessonId());
			System.out .println("Lesson name: " + lesson.getLessonName());
			System.out.println("Lesson room number: " + lesson.getLessonRoomNumber());

			// Try to get the Set<Contenu> for the current Stock if exist
			try {
				Set<Student> students = lesson.getStudents();

				Iterator<Student> itStudent = students.iterator();

				while (itStudent.hasNext()) {
					Student std = (Student) itStudent.next();

					System.out.println("Lesson id: " + std.getId());
					System.out.println("Student first name: " + std.getFirstName());
					System.out.println("Student last name: " + std.getLastName());
				}

			} catch (Exception e) {
				System.err.println("Tools.java printResultQueryFromLesson() No Contenu available " + e.toString());
			}
		}
	}

	/**
	 * Create and configure the SessionFactory for the DB
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSession() {
		Configuration cfg = new Configuration();
		cfg.configure();
		ServiceRegistry sr = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties()).build();
		return (cfg.buildSessionFactory(sr));
	}
}
