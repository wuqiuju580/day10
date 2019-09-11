package com.bw.test;

import java.util.Date;

import org.junit.Test;

import utils.DateUtil;

public class DateTest {


	@Test
	public void test01(Date birthday){
		
		int age = DateUtil.getAge(birthday);
		System.out.println(age);
		
	}
}
