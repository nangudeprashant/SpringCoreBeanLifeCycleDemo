package com.javaLive.SpringCoreBeanLifeCycleDemo;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("BeanPostProcessor.postProcessAfterInitialization.\n This is common to all beans of this container.");
		return bean;
	}
	public Object postProcessBeforeInitialization(Object bean, String beanName)
			throws BeansException {
		System.out.println("BeanPostProcessor.postProcessBeforeInitialization"
				+ "\nThis is common to all beans of this container.");
		return bean;
	}
}
