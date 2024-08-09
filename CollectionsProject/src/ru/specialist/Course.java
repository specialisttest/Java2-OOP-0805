package ru.specialist;

import java.util.Objects;

public class Course {
	public static final String DEFAULT_TITLE = "Новый курс";
	public static final int DEFAULT_LENGTH = 8;
	public static final int MAX_LENGTH = 60;
	public static final int MIN_LENGTH = 4;
	
	private String title;
	private int length;
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		if (length >= MIN_LENGTH && length <= MAX_LENGTH) // length in [min, max]
			this.length = length;
		else
			throw new IllegalArgumentException("length out of ["+MIN_LENGTH+", "+MAX_LENGTH+"]");
	}
	
	
	public String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}
	
	public Course() {
		this(DEFAULT_TITLE);
	}
	
	public Course(String title) {
		this(title, DEFAULT_LENGTH); // первый оператор
	}
	
	public Course(String title, int length) {
		this.title = title;
		setLength(length);
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
