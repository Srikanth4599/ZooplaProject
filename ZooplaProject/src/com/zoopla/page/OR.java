package com.zoopla.page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OR {
	WebDriver d;

	public OR(WebDriver d) {
		PageFactory.initElements(d, this);
	}
	
	//Zoopla Home Page.
	@FindBy(name="q")public WebElement serchBox;
	@FindBy(name="q")public WebElement serchBox_button;
	
	@FindBy(css=".srp.clearfix")public List<WebElement> all_PropertPrice_links;

	
	@FindBy(xpath="//div[@class='ui-agent']/a/div[2]/h4[1]")public WebElement agentName1;
	
	
	@FindBy(xpath="//div[@id='listings-agent']/div/p/strong")public WebElement agentName2;
	
	
	

	
	
	

}
