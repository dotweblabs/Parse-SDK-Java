package org.parseplatform.custom;

import org.parseplatform.ParseClassName;
import org.parseplatform.ParseObject;

@ParseClassName("person")
public class Person extends ParseObject {

	public void setAge(int age) {
		put("age", age);
	}
	
	public int getAge() {
		return getInt("age");
	}
	
	public void setGender(String gender) {
		put("gender", gender);
	}
	
	public String getGender() {
		return getString("gender");
	}
	
}
