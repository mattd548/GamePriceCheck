import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Scanner;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;

public class GamePriceChecker {
	private VideoGame game = new VideoGame();
	

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
	
	
	public static void checkBestBuy(String game_title) throws FailingHttpStatusCodeException, MalformedURLException, IOException
	{
		
	    BestBuyScraping bestbuy_scraper= new BestBuyScraping();
		//t.getPageAstext();
		bestbuy_scraper.setForm();
		bestbuy_scraper.setSearchButton();
		bestbuy_scraper.inputSearch(game_title);
		bestbuy_scraper.selectTitle();
		//t.getPageAstext();
		bestbuy_scraper.selectPrice();
		bestbuy_scraper.selectPublisher();
        //System.out.println(game.getString_new_price());
		
	}
	
	public static void checkAmazon(String game_title) throws FailingHttpStatusCodeException, MalformedURLException, IOException 
	{
		AmazonScraper amazon_game= new AmazonScraper();
		//t.getPageAstext();
		amazon_game.setForm();
		amazon_game.setSearchButton();
		amazon_game.inputSearch(game_title);
		//t.getPageAstext();
		amazon_game.selectTitle();
		
		//t.getPageAstext();
		amazon_game.selectPrice();
		//t.selectPublisher();
        //System.out.println(game.getString_new_price());
		
		
		
		
		
	}
	
	
	
	
	
}
