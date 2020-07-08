
public class VideoGame {
private double new_price;
private double used_price;
private String string_new_price;
private String string_used_price;
private String platform;
private String title;

// video game class that stores all the info for a game
   public VideoGame() {
	  
   }
   //gets video game title
   public String getTitle() {
		return title;
	}


    //sets video game title
	public void setTitle(String title) {
		this.title = title;
	}


    //gets platform ps4,xbox one, etc
	public String getPlatform() {
		return platform;
	}


    //sets platform
	public void setPlatform(String platform) {
		this.platform = platform;
	}


    // gets used price, not used yet, saved for future functions
	public double getUsed_price() {
		return used_price;
	}


	// sets used price, not used yet, saved for future functions
	public void setUsed_price(int used_price) {
		this.used_price = used_price;
	}
    
	//displays all the games info
	public void displayGameInfo() {
		System.out.println(this.title);
		System.out.println(this.platform);	
		System.out.println(this.string_new_price);	
		
		
	}


   //gets used price as a string
	public String getString_used_price() {
		return string_used_price;
	}


    //sets string used price
	public void setString_used_price(String string_used_price) {
		this.string_used_price = string_used_price;
	}


    //gets new price but as double
	public double getNew_price() {
		return new_price;
	}


   //sets new price as int
	public void setNew_price(int new_price) {
		this.new_price = new_price;
	}
	//sets string new price
	public void setString_new_price(String price) {
		this.string_new_price = price;
	}
	// gets string new price
	public String getString_new_price() {
		
		return string_new_price;
	}
}
