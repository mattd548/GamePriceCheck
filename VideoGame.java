
public class VideoGame {
private double new_price;
private double used_price;
private String string_new_price;
private String string_used_price;
private String platform;
private String title;

   public VideoGame() {
	   this.new_price=20.99;
	   this.title="animal crossing";
	   this.platform="switch";
   }
   public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public String getPlatform() {
		return platform;
	}



	public void setPlatform(String platform) {
		this.platform = platform;
	}



	public double getUsed_price() {
		return used_price;
	}



	public void setUsed_price(int used_price) {
		this.used_price = used_price;
	}

	public void displayGameInfo() {
		System.out.println(this.title);
		System.out.println(this.platform);	
		System.out.println(this.string_new_price);	
		
		
	}



	public String getString_used_price() {
		return string_used_price;
	}



	public void setString_used_price(String string_used_price) {
		this.string_used_price = string_used_price;
	}



	public double getNew_price() {
		return new_price;
	}



	public void setNew_price(int new_price) {
		this.new_price = new_price;
	}
	
	public void setString_new_price(String price) {
		this.string_new_price = price;
	}
	
	public String getString_new_price() {
		
		return string_new_price;
	}
}
