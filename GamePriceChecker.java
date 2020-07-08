import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;


// program searches amazon and bestbuy for a game in order to compare prices
// only pulls the top result from both bestbuy and amazon 

public class GamePriceChecker {
	
	

	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException 
{       String game_title;
		boolean isSet= false;
		System.out.println("Please Enter the video game you are looking for and we will check the prices");
		//closes resource scanner
		try(Scanner input = new Scanner(System.in)){
			
			// while nothing is entered it prompts the user to enter again
	 while(isSet==false) 
	 {
		
	
		game_title= input.nextLine();
		if(game_title.isEmpty())
		{
	      System.out.println("No video game title was entered, please try again");
	      isSet=false;
	     
	    }
	        
		
		else {
		isSet=true;
		System.out.println("BestBuy");
		checkBestBuy(game_title);
		System.out.println();
		System.out.println("Amazon");
		checkAmazon(game_title);
		}
		
	 }
	
		}
	





}
	
	//uses the bestbuy scraper to search best buy for the game title
	
	public static void checkBestBuy(String game_title) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		
	    BestBuyScraping bestbuy_scraper= new BestBuyScraping();
		bestbuy_scraper.setForm();
		bestbuy_scraper.setSearchButton();
		bestbuy_scraper.inputSearch(game_title);
		bestbuy_scraper.selectTitle();
		bestbuy_scraper.selectPrice();
		bestbuy_scraper.selectPublisher();
		
	}
	
	//uses the amazon scraper to search amazon for game title
	public static void checkAmazon(String game_title) throws FailingHttpStatusCodeException, MalformedURLException, IOException 
	{
		AmazonScraper amazon_game= new AmazonScraper();
		amazon_game.setForm();
		amazon_game.setSearchButton();
		amazon_game.inputSearch(game_title);
		amazon_game.selectTitle();
		amazon_game.selectPrice();
				
		
	}
	
	
	
	
	
}
