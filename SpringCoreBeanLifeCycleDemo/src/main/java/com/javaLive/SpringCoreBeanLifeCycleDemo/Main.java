package com.javaLive.SpringCoreBeanLifeCycleDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaLive.beans.Book;
import com.javaLive.beans.Publisher;

/**
 * @author Team JavaLive.
 *
 */
public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
//		Application context loads the beans egarly. In order to avoid this we have set 
//		attribute lazy-init of the bean to value "true"		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
//		System.out.println("=================Book objects details====================");
//		Book book = (Book) context.getBean("book");
//		System.out.println("Book Name:" + book.getBookName());
		
		
		System.out.println("=================Publisher objects details====================");
		Publisher publisher=(Publisher) context.getBean("publisher");
		context.registerShutdownHook();
	}
}
