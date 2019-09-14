package com.javaLive.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Book implements InitializingBean, DisposableBean, BeanFactoryAware, BeanNameAware, BeanClassLoaderAware {
	private String bookName;
	private Book() {
		System.out.println("---inside Book constructor---");
	}
	public void setBeanClassLoader(ClassLoader classLoader) {
	       System.out.println("---BeanClassLoaderAware.setBeanClassLoader---");
	}	
	public void setBeanName(String name) {
   	       System.out.println("---BeanNameAware.setBeanName---");
	}	
	public void myPostConstruct() {
	    	 System.out.println("---custom init-method---");
	}	
	@PostConstruct
	public void springPostConstruct() {
	    	 System.out.println("---@PostConstruct---");
	}
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("---BeanFactoryAware.setBeanFactory---");
	}	
	public void afterPropertiesSet() throws Exception {
		System.out.println("---InitializingBean.afterPropertiesSet---");
	}	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
		System.out.println("setBookName: Book name has set.");		
	}
	public void myPreDestroy() {
		System.out.println("---custom destroy-method---");
	}
	@PreDestroy
	public void springPreDestroy() {
		System.out.println("---@PreDestroy---");
	}
	public void destroy() throws Exception {
		System.out.println("---DisposableBean.destroy---");
	}
	@Override
	protected void finalize() {
		System.out.println("---inside Book finalize---");
	}
}
