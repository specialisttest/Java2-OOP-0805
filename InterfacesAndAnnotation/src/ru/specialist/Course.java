package ru.specialist;

public class Course implements Comparable<Course> {
	
	
	
	// константы - значения определены на этапе компиляции
	public static final String DEFAULT_TITLE = "Новый курс";
	public static final int DEFAULT_LENGTH = 8;
	public static final int MAX_LENGTH = 60;
	public static final int MIN_LENGTH = 4;
	
	public static final String DEFAULT_ORGANIZTION = "Specialist.ru";
	
	
	// поле класса (статическое)
	private static int counter = 0;
	
	// статический блок инициализации
	static {
		//counter = 0;
	}
	
	
	// поля описывают данные (состояние) объекта (нестатические)
	
	// финализированное поле - значение определяется в runtime, но только при создании объекта
	public final String organization; 
	
	private String title = "New Course"; // 1. выражение инициализации
	
	private int length;
	
	// 2. блок инициализации (редко встречается)
	{
		length = 16;
	}
	
	// статические методы (просто функции)
	
	public static void printCounter() {
		// this недоступна!!!
		// доступны статические поля и параметры (если есть)
		System.out.printf("Всего курсов: %d\n", Course.counter);		
	}
	
	// методы описывают операции (поведение) объектов
	
	// boolean getChecked()
	// boolean hasChecked()
	// boolean isChecked()
	
	
	// Инкапсуляция с помощью геттера и сеттера
	// Свойство (property) - Length
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		if (length >= MIN_LENGTH && length <= MAX_LENGTH) // length in [min, max]
			this.length = length;
		else
			throw new IllegalArgumentException("length out of ["+MIN_LENGTH+", "+MAX_LENGTH+"]");
	}
	
	
	// Свойство (property) readonly - Title

	public String getTitle() {
		return title;
	}

	protected void setTitle(String title) {
		this.title = title;
	}
	
	// Свойство (property) readonly - Teacher
	public String getTeacher() {
		return "Неизвестно";
	}

	// Свойство только для чтения - readonly property - Code
	public String getCode() {
		return String.format("%c%c%c%c", 
				title.charAt(0), title.charAt(2),
				title.charAt(4), title.charAt(6));
	}

	// 3. конструкторы
	public Course() {
		this(DEFAULT_TITLE);
	}
	
	public Course(String title) {
		//this.title = title;
		//this.length = 8;
		this(title, DEFAULT_LENGTH); // первый оператор
	}
	
	public Course(String title, int length) {
		this(title, length, DEFAULT_ORGANIZTION);
	}
	
	public Course(String title, int length, String organization) {
		this.organization = organization;
		this.title = title;
		//this.length = length;
		setLength(length);
		// любый другие действия (почти ))
		
		//Course.counter++;
		counter++;
	}
	
	public void print() {
		
		int length = -1;
		// this - автоматическая переменная содержит ссылку на объект для которого вызван данный метод
		System.out.printf("%s. %s : %d\n", 
				getCode(), getTitle(), getLength()/*this.length*/);
	}
	
	
	@Override
	public String toString() {
		return String.format("%-21s : %-3d", getTitle(), getLength());
	}

	@Override
	public int compareTo(Course c) {
		// 1  this > c
		// 0  this == c
		// -1 this < c
//		if (this.getLength() > c.getLength()) return 1;
//		if (this.getLength() < c.getLength()) return -1;
//		return 0;
		
		return c.getLength() - this.getLength(); // DESC
		
		//return this.getTitle().compareTo(c.getTitle());
	}

}
