package com.headfirst.ch11.protectionproxy;

import java.lang.reflect.*;

public class OwnerInvocationHandler implements InvocationHandler { 
	PersonBean person;
 
	public OwnerInvocationHandler(PersonBean person) {
		this.person = person;
	}
 
	public Object invoke(Object proxy, Method method, Object[] args) 
			throws IllegalAccessException {
  
		try {
			// TODO: Add logic here
			if (method.getName().startsWith("get")) {
				return method.invoke(person, args);
			}
			if (method.getName().equals("setHotOrNotRating")) {
				throw new IllegalAccessException();
			}
			if (method.getName().startsWith("set")) {
				return method.invoke(person, args);
			}
			
			return null;
        } catch (Exception e) {
            e.printStackTrace();
        } 
		return null;
	}
}
