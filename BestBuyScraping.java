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
// had to develop a bestbuyscraper since i cant use the api provided by best buy :(
public class BestBuyScraping {
	 private final WebClient webclient = new WebClient(BrowserVersion.INTERNET_EXPLORER);
     private HtmlPage page;
     private HtmlForm form;
     private DomElement button;
     private DomElement element;
     private static VideoGame game = new VideoGame();
     private String text;
     HtmlTextInput textField;
     // sets environment and page as bestbuy the moment constructor is called 
    public BestBuyScraping() throws FailingHttpStatusCodeException, MalformedURLException, IOException {
    	
    	this.setEnvironment();
    	this.setPage("https://www.bestbuy.com/");
    		
    }
     
	/*public static void main(String[] args) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
		game = new VideoGame();
		BestBuyScraping t= new BestBuyScraping();
		
		t.setEnvironment();
		t.setPage("https://www.bestbuy.com/");
		//t.getPageAstext();
		t.setForm();
		t.setSearchButton();
		t.inputSearch();
		t.selectTitle();
		//t.getPageAstext();
		t.selectPrice();
		t.selectPublisher();
        //System.out.println(game.getString_new_price());
	}*/
	
	
     public void setPage(String page) throws FailingHttpStatusCodeException, MalformedURLException, IOException {
	this.page = webclient.getPage(page);
     }

    public void getPageAstext() {
    	System.out.print(this.page.asText()); 
    }
    
    
    
    private void setEnvironment() {
    	//makes sure to turn javascript off since the website im scraping uses javascript
    	//turns warnings off 
    	java.util.logging.Logger.getLogger("com.gargoylesoftware").setLevel(Level.OFF); 
    	webclient.getOptions().setJavaScriptEnabled(false);
    	webclient.getOptions().setThrowExceptionOnFailingStatusCode(false);
    	
    }

	public HtmlForm getForm() {
		return form;
	}

	public void setForm() {
		this.form = page.getFormByName("frmSearch");
		
	}

	public DomElement getButton() {
		return button;
	}

	// sets the search button based on website layout, will have to be updated
	// inspect page element in your browser to get new xpath
	public void setSearchButton() {
		this.button = form.getFirstByXPath("//button[@type='submit'and @title='submit search']");
		
	}
    
	// submits search to bestbuy homepage based on game title
	// MUST USE first before getting any info about price, esrb, etc
	public void inputSearch(String game) {
		 // textfield is based on 
		 this.textField = form.getInputByName("st");
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
	
     //selects price and saves it to string text 
	public void selectPrice() {
		// price is based on page layout which is constantly updated 
		//check div of website using inspect element
	   this.element = page.getFirstByXPath("//div[@class='priceView-hero-price priceView-customer-price']");
	   this.text = element.getTextContent();
	   // remove any non numbers using regular expression and replace with space, from the div class
	   text = text.replaceAll("[^0-9.$]", " ");   
	   
	   //assumes that game will be at max triple digit price
	   text=text.substring(0,6);
	   System.out.println(text);
	   game.setString_new_price(text);
	}
	//selects title based on web page layout should only have to change getfirst byxpath parameter as website gets updated
	public void selectPublisher() 
	{
		this.element = page.getFirstByXPath("//span[@class='sku-value']");
		this.text = element.getTextContent();
		System.out.println(text);
		game.setPlatform(text);
		
		
		
	}
	//selects title based on web page layout should only have to change getfirst byxpath parameter as website gets updated
	public void selectTitle() 
	{   
		this.element = page.getFirstByXPath("//h4[@class='sku-header']");
		String text = element.getTextContent();
		System.out.println(text);
	}
	/*
	public void output() {
		 System.out.printf("%10s %30s", "BestBuy", "Amazon");
	}
	*/
   
    

}
