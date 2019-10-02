package hello;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sun.org.apache.xerces.internal.xni.XMLResourceIdentifier;


import projectResources.ThreadConfig;
import projectResources.myThread;


@Controller
public class TestController     {
	
	
	
	

	
	
	

    @GetMapping("/test")
    public String greetingForm(Model model) {
    	Test test=new Test();
    	
        model.addAttribute("test", test);
        
        
        return "greeting";
    }
    
    
    
    @PostMapping("/test")
    public String greetingSubmit(@ModelAttribute Test test){
        
       
    	
    	
    	
    System.out.println(test.toString());	
    		
   		
			
		
    	
    	
		
    	
    	
    	

return "result";
    }}


