package ch.ne.ceg.hibernate.helloworld.annotation.manytomany;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LESSON")
public class Lesson {
	@Id
	@Column(name="LESSON_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="ROOM_NUMBER")
	private int roomNumber;
	
	@Column(name="NAME")
	private String name;
	
	private Set<Student> students = new HashSet<Student>();

	public Lesson(){
		// Empty
	}
	
	public int getLessonId() {
		return id;
	}
	public void setLessonId(int lessonId) {
		this.id = lessonId;
	}
	public int getLessonRoomNumber() {
		return roomNumber;
	}
	public void setLessonRoomNumber(int lessonRoomNumber) {
		this.roomNumber = lessonRoomNumber;
	}
	public String getLessonName() {
		return name;
	}
	public void setLessonName(String lessonName) {
		this.name = lessonName;
	}
	
	public Set<Student> getStudents() {
		return students;
	}

	public void setStudents(Set<Student> students) {
		this.students = students;
	}
}
