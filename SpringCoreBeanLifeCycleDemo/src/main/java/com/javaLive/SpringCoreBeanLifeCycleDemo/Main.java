package com.javaLive.SpringCoreBeanLifeCycleDemo;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.javaLive.beans.Book;
import com.javaLive.beans.Publisher;

/**
 * @author Team JavaLive. 
 *         This project is less important from interviews and actual use 
 *         purpose. Hence only go through it.
 *         
 *         Please read following link:
 *         https://stackoverflow.com/questions/39164058/what-is-the-real-world-use-of-beanpostprocessor-in-spring
 *         
 *         Quite often you will find yourself in a situation
 *         where you would need to perform some processing pre and post
 *         instantiation of the bean by Spring framework. Spring has provided
 *         BeanPostProcessor interface which defines a callback methods to
 *         achieve this functionality.
 * 
 *         Classes that implements BeanPostProcessor interface needs to be
 *         defined in an ApplicationContext(spring bean configuration file) and
 *         will be applied on all the beans defined in an application context.
 * 
 *         In case there are multiple BeanPostProcessor implementations
 *         configured in beans configuration files and they are dependent on
 *         each other ( processed object of one implementation can be an input
 *         to another) then the order in which post processors is important .To
 *         control the order in which post processor will be executed, bean post
 *         processor classes need to implement Ordered interface and implement
 *         its getOrder methodto define the order.
 * 
 *         BeanPostProcessor interface provides us two extension points –
 * 
 *         a)To perform custom processing after the object is instantiated by
 *         Spring Container 
 *         b)after the initialization. 
 *         The BeanPostProcessors operate on bean (or object) instances. This means
 *         Spring IoC container instantiates a bean instance and then
 *         BeanPostProcessor interfaces do their work.
 * 
 *         Note: Notice that the init and destroy methods related to bean are
 *         different from bean post processors. BeanPostProcessors are common
 *         for all beans and gets executed before custom init methods .
 */
public class Main {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		// Application context loads the beans egarly. In order to avoid this we have
		// set
		// attribute lazy-init of the bean to value "true"
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		System.out.println("=================Book objects details====================");
		Book book = (Book) context.getBean("book");
		System.out.println("Book Name:" + book.getBookName());

		System.out.println("=================Publisher objects details====================");
		Publisher publisher = (Publisher) context.getBean("publisher");
		context.registerShutdownHook();
	}
}
