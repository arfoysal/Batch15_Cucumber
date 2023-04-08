package pages;

import org.openqa.selenium.By;

public class DarazHelpCenterPage extends BasePage{
	public String HELP_CENTER_PAGE_URL = "https://helpcenter.daraz.com.bd/page/home?pageId=1&language=en";
	public String HELP_CENTER_PAGE_TITLE = "Help Center";
	public By TOP_QUESTIONS = By.xpath("//div[@class='title__mwhgAgec']");
}
