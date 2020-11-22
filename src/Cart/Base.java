package Cart;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		String itemsNeeded[] = { "Cucumber", "Brocolli", "Beetroot" };
		int j = 0;
		List<WebElement> products = driver.findElements(By.cssSelector("h4.product-name"));
		for (int i = 0; i <= products.size(); i++) {
			String[] name = products.get(i).getText().split("-");
			String formattedName = name[0].trim();
			// format it to get actual vegetable name
			// Convert array into arraylist for easy search
			// Check whether name you extracted is present or not
			List itemsNeededList = Arrays.asList(itemsNeeded);

			if (itemsNeededList.contains(formattedName)) {
				j++;
				// click on add to cart
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				if (j == itemsNeeded.length) {
					break;
				}
			}

		}
	}

}
