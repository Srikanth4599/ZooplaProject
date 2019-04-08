package com.zoopla.test;

import static org.testng.Assert.assertEquals;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.zoopla.config.Common;
import com.zoopla.page.OR;

public class ZooplaHomePageTest extends Common {
	OR page;

	@Test
	public void filterHighToLow() throws Exception {

		// Step1:- Search Location.

		d.get(url);

		page = new OR(d);

		assertEquals("Zoopla > Search Property to Buy, Rent, House Prices, Estate Agents", d.getTitle());

		page.serchBox.sendKeys("London");
		page.serchBox_button.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		// Step2:- Filter Property Values.

		List<WebElement> list = page.all_PropertPrice_links;
		System.out.println("No OF Price : " + list.size());

		String str1 = "//li[@class='srp clearfix   '][";
		String str2 = "]/div/div[2]/a";

		ArrayList<Integer> al = new ArrayList<Integer>();

		List<Integer> amountList = new ArrayList<Integer>();

		List<WebElement> l1 = new ArrayList<WebElement>();
		for (int i = 1; i <= list.size() - 1; i++) {

			String s = d.findElement(By.xpath(str1 + i + str2)).getText();
			String[] st = s.split(" ");
			String st1 = st[0];
			String st2 = st1.substring(1).trim();

			String digamount = st2.replace(",", "");

			Integer amount = new Integer(digamount);
			amountList.add(amount);
		}

		al.addAll(amountList);

		Collections.sort(al);

		Collections.reverse(al);

		System.out.println(al);
		
		Integer req5Thvalue = al.get(4);

		NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.UK);
		String numberAsString = numberFormat.format(req5Thvalue);
		String reqamount = numberAsString.toString();
		String symbol = "£";
		String am = symbol.concat(reqamount);
		System.out.println("5th Highest Value = "+am);

		for (int i = 1; i <= list.size() - 1; i++) {
			String string1 = d.findElement(By.xpath(str1 + i + str2)).getText();
			System.out.println(string1);
			if (string1.contains(am)) {

				d.findElement(By.xpath(str1 + i + str2)).click();
				break;

			}
		}

		String agentName1 = page.agentName1.getText();
		page.agentName1.click();
		String agentName2 = page.agentName2.getText();

		assertEquals(agentName1, agentName2);
		
		System.out.println("Check *************** " + agentName1.equals(agentName2));

		System.out.println("Yes Task IS Completed.....");

		Thread.sleep(5000);
	}

}