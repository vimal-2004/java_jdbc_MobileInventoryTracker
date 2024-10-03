package vimalMobile.com;
import java.sql.Connection;
import java.sql.Statement;
public class mobile {
    
    private int id;
    private String brandname;
    private String generation;
    private String model_name;
    private int price;
   

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getGeneration() {
		return generation;
	}

	public void setGeneration(String generation) {
		this.generation = generation;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	
	
	
	@Override
	public String toString() {
		return "mobile [id=" + id + ", brandname=" + brandname + ", generation=" + generation + ", model_name="
				+ model_name + ", price=" + price + "]";
	}



	public Object getId() {
		return id;
	}
}
