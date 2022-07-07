package com.Utilities;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementUtilities {

	private WebDriver driver;

	public ElementUtilities(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getWebElement(By locater) {
		WebElement element = driver.findElement(locater);
		return element;
	}

	// send keys
	public void sendKeys(By locater, String value) {
		getWebElement(locater).sendKeys(value);
	}

	// click
	public void doClick(By locater) {
		getWebElement(locater).click();
	}

	// send keys with action
	public void doSendKeyswithAction(By locater, String values) {
		Actions act = new Actions(driver);
		act.sendKeys(getWebElement(locater), values).perform();
	}

	// click locater with action
	public void doClickWithActions(By locaters) {
		Actions act = new Actions(driver);
		act.click(getWebElement(locaters)).perform();
	}

	// get Text
	public String getTexts(By locater) {
		return getWebElement(locater).getText();
	}

	// isDisplay fields
	public boolean isDisplay(By locater) {
		return getWebElement(locater).isDisplayed();
	}

	// select drop downs
	public void selectDropDownByVisibleText(By locater, String value) {
		Select sel = new Select(getWebElement(locater));
		sel.selectByVisibleText(value);
	}
//select drop down by index
	public void selectDropDownByIndex(By locater, int num) {
		Select sel = new Select(getWebElement(locater));
		sel.selectByIndex(num);

	}
//deselect drop downs by value
	public void deselectDropDownsByValue(By locater, String Value) {
		Select deselect = new Select(getWebElement(locater));
		deselect.deselectByValue(Value);
	}
//deselect drop down all
	public void deselectAllDropDowns(By locater) {
		Select sel = new Select(getWebElement(locater));
		sel.deselectAll();
	}
//de-select dropdowns by index
	public void deSelectDropdown(By locater, int index) {
		Select sel = new Select(getWebElement(locater));
		sel.deselectByIndex(index);

	}
//deselect drop down by visibility text
	public void deSelectDropDownByVisibletext(By locater, String value) {
		Select sel = new Select(getWebElement(locater));
		sel.deselectByValue(value);
	}
// window handle
	public void windowHandle(WebDriver driver) {
		String parent = driver.getWindowHandle();
		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				System.out.println(driver.switchTo().window(child_window).getTitle());

				driver.close();
			}
		}
		// switch to the parent window
		driver.switchTo().window(parent);

	}
	public  WebElement waitForUntilElementPresent(By locater,int time) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		 return wait .until(ExpectedConditions.presenceOfElementLocated(locater));
		
	}

}
