package com.isabell.theCode;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
//	create an empty Array where you can push the activities into it
	ArrayList<String> logList = new ArrayList<>();

	@RequestMapping("/")
	public String index(HttpSession session) {
//		set Sessions:
		session.setAttribute("countGold", 0); 
		return "redirect:/gold";
	}
	
	@RequestMapping("/gold")
	public String home() {
		return "index.jsp";
	}
	
//	property is the path variable and needs to math the input in the URL
//	When you have the URL you have to create a string to check if it matches the location
	@PostMapping("/gold/{property}")
	public String gold(@PathVariable("property") String location, HttpSession session ) {
		Integer countGold = (Integer) session.getAttribute("countGold");
		Integer gold = 0;
		int mode = 1;
		String temp = "";
		
		if(countGold == null) {
			countGold = 0;
		}
		if(location.equals("farm")) {
//			create random number and add amount to the Gold stored in session:
			gold = ThreadLocalRandom.current().nextInt(10, 20);
			temp = "You entered a farm and earned " + gold + " gold!";
		}
		if(location.equals("cave")) {
			gold = ThreadLocalRandom.current().nextInt(5, 10);
			temp = "You entered a cave and earned " + gold + " gold!";
		}
		if(location.equals("house")) {
			gold = ThreadLocalRandom.current().nextInt(2, 5);
			temp = "You entered a house and earned " + gold + " gold!";
		}
		if(location.equals("casino")) {
			gold = ThreadLocalRandom.current().nextInt(0, 50);
			mode = ThreadLocalRandom.current().nextInt(2);
			temp = "You entered a casino and earned " + gold + " gold!";
			if (mode == 0) {
//				Do -1 do multiple the gold -. (Plus und minus = minus) :)
				gold *= -1;
				temp = "You entered a casino and lost " + gold + " gold!";
			}
		}
		countGold += gold;
		session.setAttribute("countGold", countGold);
		Date currentDate = new Date();
//		logList is the empty ArrayList
		logList.add(temp + " - " + currentDate.toString());
		
//		session.setAttribute will add the activity to the activity box
		session.setAttribute("logList", logList);
		return "redirect:/gold";
	}
}
