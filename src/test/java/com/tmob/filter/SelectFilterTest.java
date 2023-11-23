package com.tmob.filter;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelectFilterTest {
	static WebDriver driver;
	
	public static void selectFilter(String... args) {
		String filterType = args[0];
		WebElement filter;
		
		// Perform action as per filter type
		switch(filterType) {
			case "Deals":
				filter = driver.findElement(By.xpath("//legend[text()=' Deals ']"));
				filter.click();
				selectSubFilter(filter, args);
				break;
			case "Brands":
				filter = driver.findElement(By.xpath("//legend[text()=' Brands ']"));
				filter.click();
				selectSubFilter(filter, args);
				break;
			case "Operating System":
				filter = driver.findElement(By.xpath("//legend[text()=' Operating System ']"));
				filter.click();
				selectSubFilter(filter, args);
				break;
			default:
				System.out.println("Message..");
		}
		
	}
	
	// Perform action as per sub filter type
	public static void selectSubFilter(WebElement filter, String[] args) {
		String subFilterType;
		if(args[1] == "all") {
			List<WebElement> subFilters = filter.findElements(By.xpath("//span[@class='filter-display-name']"));

			// Click on each sub-filter type
			for (WebElement subFilter : subFilters) {
			    subFilter.click();
			}
		}else {
			for(int i = 1; i < args.length; i++) {
				subFilterType = args[i];
				driver.findElement(By.xpath("//span[text()=' " + subFilterType + " ']")).click();
			}
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.t-mobile.com/tablets");
		
		Thread.sleep(5000);
		
		selectFilter("Brands", "Apple", "Samsung");
		
//		selectFilter("Deals", "New", "Special offer");
		
//		selectFilter("Operating System", "iPadOS", "Android");
		
//		selectFilter("Operating System", "all");
		
	}

}
