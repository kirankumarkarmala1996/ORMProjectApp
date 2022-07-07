package com.pages;

import org.openqa.selenium.By;

public class AdminPageOHRM {
	
	public static void selectRow(String rowNumber) {
		//driver.findElement(By.xpath("//tbody/tr["+rowNumber+"]/td")).click();
		//driver.findElement(By.xpath("//tbody/tr[2]/td")).click();
		//tbody/tr[8]/td
		
		System.out.println("//tbody/tr["+rowNumber+"]/td");
	}
	
	public static void main(String[] args) {
		selectRow("2");
	}

}
