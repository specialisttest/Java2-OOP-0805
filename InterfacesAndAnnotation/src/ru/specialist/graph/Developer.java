package ru.specialist.graph;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Developer {
	String name();
	String date();
}
