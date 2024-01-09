package TestSelenium;

import java.io.IOException;
import java.util.Scanner;
import DriverSetup.Driver;

public class Implementation extends Driver{
    
    private static Scanner sc;

	// main method.
    public static void main(String[] args) throws InterruptedException, IOException{
    	sc = new Scanner(System.in); 
    	
    	//Creating the objects of classes
    	
    	Implementation hrm = new Implementation();
    	urlManager url = new urlManager();
    	LoginVerification lv = new LoginVerification();
    	AdminPanel ap = new AdminPanel();
    	Logout lo = new Logout();
     
     // Taking option which browser to open
    	try {
    	while(true) {
    	System.out.println("Choose the browser :");
    	System.out.println("1. Chrome ");
		System.out.println("2. Edge ");
		System.out.println("3. Exit");
		
     int choice = sc.nextInt();
	 hrm.driverSetup(choice);
	 url.openUrl();
	 
	 lv.logIn();
	 lv.verifyURL();
	 
	 ap.adminPanel();
	 ap.getJobTitles();
	 ap.addJob();
	 
	 Thread.sleep(3000);
	 lo.logOut();
	 
	 Thread.sleep(3000);
	 hrm.closeBrowser();
	 
	 System.out.println("Success");
    	}
    }catch(Exception e) {
    	System.out.println(e);
    }
    	
    	}
	}
