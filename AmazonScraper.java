import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.DomElement;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
// class pulls the first item it finds passed on user's search
// only searches the video game section of amazon 
// highly dependent on amazon search results 
//highly dependent on amazon web page layout
public class AmazonScraper 
{
	private final WebClient webclient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
    private HtmlPage page;
    private HtmlForm form;
    private DomElement button;
    private DomElement element;
    private static VideoGame game = new VideoGame();
    HtmlTextInput textField;
    
    
    public AmazonScraper() throws FailingHttpStatusCodeException, MalformedURLException, IOException 
    {    this.setEnvironment();
    	 this.setPage("https://www.amazon.com/gp/browse.html?node=468642&ref_=nav_em__cvg_0_2_13_10");
    	
    }
    
/*	public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException 
	{
		game = new VideoGame();
		AmazonScraper t= new AmazonScraper();
		
		t.setEnvironment();
		t.setPage("https://www.amazon.com/gp/browse.html?node=468642&ref_=nav_em__cvg_0_2_13_10");
		//t.getPageAstext();
		t.setForm();
		t.setSearchButton();
		t.inputSearch();
		//t.getPageAstext();
		t.selectTitle();
		
		//t.getPageAstext();
		t.selectPrice();
		//t.selectPublisher();
        //System.out.println(game.getString_new_price());
	}*/
	
    
    
    
    
    
	  private void setEnvironment() 
	  {
	    	//makes sure to turn javascript on since the website im scraping uses javascript
	    	//turns warnings off 
	    	java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
	    	webclient.getOptions().setJavaScriptEnabled(true);
	    	webclient.getOptions().setThrowExceptionOnFailingStatusCode(false);
	    	
	   }
    
	  public void setPage(String page) throws FailingHttpStatusCodeException, MalformedURLException, IOException 
	  {
			this.page = webclient.getPage(page);
			
			
	  }
    
      // sets the search form
	  public void setForm() 
	  {
			this.form = page.getFormByName("site-search");
			
	  }
    
    
	  public void getPageAstext() 
	  {
	    	System.out.print(this.page.asText()); 
	  }
	    
	  public void setSearchButton() 
	  {
			this.button = form.getFirstByXPath("//input[@type='submit'and @class='nav-input']");
			
	  }
    // inputs seach based on user's string
	  public void inputSearch(String game) 
	  {
			 // textfield is based on web layout
		     // form name is field keywords
			 this.textField = form.getInputByName("field-keywords");
			 try {
				textField.type(game);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				this.page = button.click();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
    
	  public void selectTitle() 
		{   
			this.element = page.getFirstByXPath("//span[@class='a-size-medium a-color-base a-text-normal']");
			String text = element.getTextContent();
			System.out.println(text);
		}
	  
	  public void selectPrice() {
			// price is based on page layout which is constantly updated 
			//check div of website using inspect element
		   // highlight price and inspect will give u xpath parameter
		   this.element = page.getFirstByXPath("//span[@class='a-offscreen']");
		   String text = element.getTextContent();
		   System.out.println(text);
		   game.setString_new_price(text);
		}
    
    

}
