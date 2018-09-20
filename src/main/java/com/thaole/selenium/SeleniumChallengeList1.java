package com.thaole.selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;


public class SeleniumChallengeList1 {
	private static WebDriver driver = new ChromeDriver();
	public static void main(String[] args) {
		

	}
	public static void selectOptionsFromDropdownList(){
/*		
* 		Drop-Down Box	
*		selectByVisibleText()/ deselectByVisibleText()	- selects/deselects an option by its displayed text
*		selectByValue()/ deselectByValue() - selects/deselects an option by the value of its "value" attribute
*		selectByIndex()/ deselectByIndex() - selects/deselects an option by its index
*		isMultiple()	- returns TRUE if the drop-down element allows multiple selection at a time; FALSE if otherwise
*		deselectAll()	- deselects all previously selected options
*/
		// Select 1 options from dropdown list
		new Select(driver.findElement(By.name("country"))).selectByVisibleText("Canada");;
		// Select mutiple options from List
		Select favouriteOptions = new Select(driver.findElement(By.name("Favourite")));
		favouriteOptions.selectByVisibleText("cooking");
		favouriteOptions.selectByVisibleText("reading");
		favouriteOptions.selectByVisibleText("learning");

	}
	public static void accessLinksAndTables(){
		//-------- Link -------------
		//link: <a href="http://www.google.com">click here</a>
		driver.findElement(By.linkText("click here")).click();
		//partial match
		driver.findElement(By.partialLinkText("click")).click();
		//Get all links on the page:
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		String[] linkTexts = new String[linkElements.size()];
		int i =0;
		for (WebElement e : linkElements) {							
			linkTexts[i] = e.getText();
			i++;
		}
		//-------- Web Table -------------
		String cellValue = null;		
			WebElement table = driver.findElement(By.xpath("//table"));
			List<WebElement> rowCollection = table.findElements(By.xpath("tr|tbody/tr"));				
			int j = 0;			
			int rowIndex = 2;
			int colIndex = 2;
			WebElement rowValue = rowCollection.get(rowIndex);
		    List<WebElement> columnCollection = rowValue.findElements(By.xpath("th|td"));
		    for(WebElement col:columnCollection){
		        j++;
		        if(colIndex==j){
		        	cellValue = col.getText();
		             break;
		        }
		    }
		    System.out.println("Cell value of table at ["+colIndex+","+rowIndex+"] ="+ cellValue);
		
	}
	
	public static void keyboardAndMouseAction(){
		/*
		* Method	                    Description
		* clickAndHold()	            Clicks (without releasing) at the current mouse location.
		* contextClick()	            Performs a context-click at the current mouse location.
		* doubleClick()	            Performs a double-click at the current mouse location.
		* dragAndDrop(source, target)	Performs click-and-hold at the location of the source element, moves to the location of the target element, then releases the mouse.
		*                             Parameters:
		*                             source- element to emulate button down at.
		*                             target- element to move to and release the mouse at.
		* dragAndDropBy(source, x-offset, y-offset)	Performs click-and-hold at the location of the source element, moves by a given offset, then releases the mouse.
		*                             Parameters:
		*                             source- element to emulate button down at.
		*                             xOffset- horizontal move offset.
		*                             yOffset- vertical move offset.
		* keyDown(modifier_key)	    Performs a modifier key press. Does not release the modifier key - subsequent interactions may assume it's kept pressed.
		*                             Parameters:
		*                             modifier_key - any of the modifier keys (Keys.ALT, Keys.SHIFT, or Keys.CONTROL)
		* keyUp(modifier _key)	    Performs a key release.
		*                             Parameters:
		*                             modifier_key - any of the modifier keys (Keys.ALT, Keys.SHIFT, or Keys.CONTROL)
		* moveByOffset(x-offset, y-offset)	Moves the mouse from its current position (or 0,0) by the given offset.
		*                                     Parameters:
		*                                     x-offset- horizontal offset. A negative value means moving the mouse left.
		*                                     y-offset- vertical offset. A negative value means moving the mouse down.
		* moveToElement(toElement)	Moves the mouse to the middle of the element. 
		*                             Parameters:
		*                             toElement- element to move to.
		* release()	                Releases the depressed left mouse button at the current mouse location
		* sendKeys(onElement, charsequence)	Sends a series of keystrokes onto the element. 
		*                             Parameters:
		*                             onElement - element that will receive the keystrokes, usually a text field
		*                             charsequence - any string value representing the sequence of keystrokes to be sent
		*/    
		
		// Sample Get color of web table which is changed when moving the mouse to that table
		String baseUrl = "http://demo.guru99.com/test/newtours/";
        System.setProperty("webdriver.firefox.marionette","C:\\geckodriver.exe");
            driver.get(baseUrl);           
            WebElement link_Home = driver.findElement(By.linkText("Home"));
            WebElement td_Home = driver
                    .findElement(By
                    .xpath("//html/body/div"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr/td"
                    + "/table/tbody/tr"));    
             
            Actions builder = new Actions(driver);
            Action mouseOverHome = builder
                    .moveToElement(link_Home)
                    .build();
             
            String bgColor = td_Home.getCssValue("background-color");
            System.out.println("Before hover: " + bgColor);        
            mouseOverHome.perform();        
            bgColor = td_Home.getCssValue("background-color");
            System.out.println("After hover: " + bgColor);
            driver.close();
		}
}
