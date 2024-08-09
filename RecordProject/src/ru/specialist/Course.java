package ru.specialist;

import java.util.Objects;

// since Java 16
//public record Course(String title, int length) {
//}

public record Course(String title, int length) implements Comparable<Course>{
	public static final String DEFAULT_TITLE = "Новый курс";
	public static final int DEFAULT_LENGTH = 8;
	public static final int MAX_LENGTH = 60;
	public static final int MIN_LENGTH = 4;
	
	public Course(int length) {
		this(DEFAULT_TITLE, length);
	}
	public Course{
		if (length < MIN_LENGTH || length > MAX_LENGTH)
			length = DEFAULT_LENGTH;
	}
	@Override
	public String toString() {
		
		return String.format("%s : %d",title(), length());
	}
	
	public String titleUpper() {
		return title().toUpperCase();
	}
	@Override
	public int compareTo(Course o) {
		return this.length() - o.length();
	}

}


// DTO - Data Transfer Object
// boilerplate code
/*public final class Course {
	
	private String title;
	private int length;
	
	public int getLength() {
		return length;
	}
	
	public String getTitle() {
		return title;
	}

	// канонический конструктор
	public Course(String title, int length) {
		this.title = title;
		this.length = length;
	}
	
	@Override
	public String toString() {
		
		return String.format("%s : %d",getTitle(), getLength());
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null) return false;
		if (getClass() != o.getClass()) return false;
		
		Course c = (Course)o;
		return this.getTitle().equals(c.getTitle()) &&
				this.getLength() == c.getLength();
	}
		
		
	@Override
	public int hashCode() {
		return Objects.hash(getTitle(), getLength());
	}

}
*/