public class Property {
	private String city;
	private String owner;
	private String propertyName;
	private double rentAmount;
	private Plot plot;
	//No-arg constructor
	public Property() {
		city="";
		owner="";
		propertyName="";
		rentAmount=0.0;
		plot=new Plot(0,0,1,1);
	}
	//Copy constructor
	public Property(Property p) {
		this.city=p.city;
		this.owner=p.owner;
		this.propertyName=p.propertyName;
		this.rentAmount=p.rentAmount;
		this.plot=p.plot;
	}
	//Parameterized constructors
	public Property(String propertyName, String city, double rentAmount, String owner ) {
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
		this.propertyName=propertyName;
		this.city=city;
		this.rentAmount=rentAmount;
		this.owner=owner;
		this.plot=new Plot(x,y,width,depth);
	}
	//Getter methods
	public String getPropertyName() {
		return this.propertyName;
	}
	public String getCity() {
		return this.city;
	}
	public double getRentAmount() {
		return this.rentAmount;
	}
	public String getOwner() {
		return this.owner;
	}
	public Plot getPlot() {
		return plot;
	}
	//Setter methods
	public void setPropertyName(String propertyName) {
		this.propertyName=propertyName;
	}
	public Plot setPlot(int x, int y, int width, int depth) {
		return this.plot=new Plot(x,y,width,depth);
	}
	public void setCity(String city) {
		this.city=city;
	}
	public void setRentAmound(double rentAmount) {
		this.rentAmount=rentAmount;
	}
	public void setOwner(String owner) {
		this.owner=owner;
	}
	//return a string format of all the properties and their information
	public String toString() {
		String str="Property Name: "+getPropertyName()+"\nLocated In city: "+getCity()+"\nBelonging to: "+getOwner()+"\nRent Amount: "+getRentAmount();
		return str;
	}
	
}
