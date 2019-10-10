package hello;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.validator.internal.util.stereotypes.ThreadSafe;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sun.org.apache.xerces.internal.xni.XMLResourceIdentifier;

import commonAPI.FetchAccess;
import commonAPI.FetchData;
import modals.AccessToken;
import modals.Games;
import modals.TopGames;
import modals.User;
import projectResources.ThreadConfig;
import projectResources.myThread;


@Controller
public class TestController     {
	
	//AccessToken object, to populate using json
	AccessToken fa = null;
	//TopGames ENDPOINT object, to populate twitch top games json
	TopGames tg = null;
	

	
	
	
	//Index Get controller, as the user enters the website
    @GetMapping("/index")
    public String greetingForm(Model model) {
    	
        
        
        return "index";
    }
    
    
    //POST controller for greeting, not doing anything for now
    @PostMapping("/greeting")
    public String greetingSubmit(@ModelAttribute Test test){
        
       
    	
    	

return "index";
    }

//GET for /greeting, fetching after-login data, like top games.
@GetMapping("/greeting")

public String getCode(@RequestParam String code,@RequestParam String scope, Model model) {
	
	
	 
	
	try {
		//Populating access token object with AcessToken JSON
		fa = FetchAccess.getToken(code);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//Insert access token to string var
	String ac = fa.getAccess_token();
	
	try {
		//Populating top games object with TopGames API JSON
		 tg =FetchData.getTopGames(ac);
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	//Populating Games array with every games.
	Games[] g= tg.getData();
	
	//Looping over all the games img URL and changing the width and height.
	for (int i = 0; i < g.length; i++) {
		
		String firstURL = g[i].getBox_art_url();
		
				
		String firstsplitURL = firstURL.replace("{width}", "250");
		
				
		String secondsplitURL = firstsplitURL.replace("{height}", "250");
		
				
	
		
		g[i].setBox_art_url(secondsplitURL);
		
		
	}
	
	Games[] ga = tg.getData();
    
	//Passing the games array to /greeting.
	model.addAttribute("ga",ga);
	
	System.out.println("token - "+ac);
	
	String userId = FetchData.getTokenDetails(ac);
	
	System.out.println("User ID -"+ userId);
	
	User user = FetchData.getUserInfo(userId);
	
	model.addAttribute("user", user);
	
    return "/greeting";
    
    
    
}

}