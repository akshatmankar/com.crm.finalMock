package com.crm.javautility;

import java.util.Random;

public class GenerateRandomNum {

	public static int random() {
		Random rd= new Random();
		int value=rd.nextInt(1000);
		return value;
	}
}
