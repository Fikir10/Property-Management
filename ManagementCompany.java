/*
 *CMSC203 CRN 31569
 *Program: Assignment 4 Design
 *Instructor: Professor Tarek
 *Summary of Description: A program that lets the user create a management company and add properties managed by the company to its list 
 *Due Date: <03/28/2023>
 *Integrity Pledge: I pledge that I have completed the programming assignment independently.
 *I have not copied the code from a student or any source.
 *Student: Fikir Seifu
 */

/**
 * @author Fikir Seifu
 */
public class ManagementCompany {
	private final int MAX_PROPERTY=5;
	private double mgmFeePer;
	private String name;
	private Property[] properties;
	private String taxID;
	private final int MGMT_WIDTH=10;
	private final int MGMT_DEPTH=10;
	private Plot plot;
	//No-arg constructor
	public ManagementCompany() {
		this.mgmFeePer=0.0;
		this.name="";
		properties=new Property[MAX_PROPERTY];
		this.taxID="";
		this.plot=new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
	}
	//Parameterized constructors
	public ManagementCompany(String name, String taxID, double mgmFeePer) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFeePer;
		this.plot=new Plot(0,0,MGMT_WIDTH,MGMT_DEPTH);
		properties=new Property[MAX_PROPERTY];
	}
	public ManagementCompany(String name, String taxID, double mgmFeePer,int x, int y, int width, int depth ) {
		this.name=name;
		this.taxID=taxID;
		this.mgmFeePer=mgmFeePer;
		this.plot=new Plot(x,y,width,depth);
		properties=new Property[MAX_PROPERTY];
	}
	//Copy constructor
	public ManagementCompany(ManagementCompany otherCompany) {
		name=otherCompany.name;
		taxID=otherCompany.taxID;
		mgmFeePer=otherCompany.mgmFeePer;
		plot=otherCompany.plot;
		properties=new Property[MAX_PROPERTY];
	} 
	//Getter methods
	public Plot getPlot() {
		return plot;
	}
	public String getTaxID() {
		return taxID;
	}
	public String getName() {
		return name;
	}
	//Sets the plot with the specified parameter
	public Plot setPlot(int x, int y, int width, int depth) {
		return new Plot(x,y,width,depth);
	}
	//returns the variable MAX_PROPERTY
	public int getMAX_PROPERTY() {
		return MAX_PROPERTY;
	}
	/**
	 * Adds the property object to the properties array. 
	 * @param property
	 * @return the index in the array where the property was added successfully
	 */
	public int addProperty(Property property) {
		int numOfProp=0;
		for(int i=0;i<properties.length;i++) {
			//if properties array doesn't equal null, increments variable numOfProp
			if(properties[i]!=null) {
				numOfProp++;
			}
		}
		//if(max property is less than or equal to numOfProp, return -1
		if(MAX_PROPERTY<=numOfProp)
			return -1;
		//if property equals null, return -2
		if(property==null)
			return -2;
		//if plot encompasses property's plot, return -3
		if(!this.plot.encompasses(property.getPlot()))
			return -3;
		for(int i=0;i<numOfProp;i++) {
			//if properties array's plot overlaps property's plot, return -4
			if(properties[i].getPlot().overlaps(property.getPlot())) {
				return -4;
			}
		}
		//sets properties array and property objects equal to each other
		properties[numOfProp]=property;
		return numOfProp;
	  }
	/**
	 * Creates a property object and adds it to the properties array with default plot.
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @return the index in the array where the property was added successfully
	 */
	public int addProperty(String name, String city, double rent, String owner) {
		int numOfProp=0;
		//creates a prop object for Property class
		Property prop = new Property(name, city, rent, owner);
		//adds prop object to properties array
		properties[numOfProp]=prop;
		numOfProp++;
		for(int i=0;i<properties.length;i++) {
			if(properties[i]!=null) {
				numOfProp++;
			}
		}
		//if(max property is less than or equal to numOfProp, return -1
		if(MAX_PROPERTY<=numOfProp)
			return -1;
		//if property equals null, return -2
		if(prop.equals(null)) {
			return -2;
		}
		//if plot encompasses property's plot, return -3
		if(!this.plot.encompasses(prop.getPlot()))
			return -3;
		for(int i=0;i<numOfProp;i++) {
			//if properties array's plot overlaps property's plot, return -4
			if(properties[i].getPlot().overlaps(prop.getPlot())) {
				return -4;
			}
		}
		//sets properties array and the object prop equal to each other
		properties[numOfProp]=prop;
		return numOfProp;
	}
	/**
	 * Creates a property object and adds it to the properties array
	 * @param name
	 * @param city
	 * @param rent
	 * @param owner
	 * @param x
	 * @param y
	 * @param width
	 * @param depth
	 * @return the index in the array where the property was added successfully
	 */
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		int numOfProp=0;
		//creates a prop object that also calls Plot's constructor
		Property prop = new Property(name, city, rent, owner, x, y, width, depth);
		for(int i=0;i<properties.length;i++) {
			if(properties[i]!=null) {
				numOfProp++;
			}
		}
		if(MAX_PROPERTY<=numOfProp)
			return -1;
		if(prop.equals(null))
			return -2;
		if(!this.plot.encompasses(prop.getPlot()))
			return -3;
		for(int i=0;i<numOfProp;i++) {
			if(properties[i].getPlot().overlaps(prop.getPlot())) {
				return -4;
			}
		}
		properties[numOfProp]=prop;
		return numOfProp;
		}
	/**
	 * Access each Property object within the properties array, sums up property rent
	 * @return total rent
	 */
	public double totalRent() {
		double totRent=0;
		for(Property prop:properties) {
			if(prop!=null) {
				//adds each properties rent amount, keeps a count
				totRent+=prop.getRentAmount();
			}
		}
		return totRent;
	}
	/**
	 * Finds the property with the maximum rent
	 * @return double, the maximum rent
	 */
	public double maxRentProp() {
		double maxRent=0;
		for(int i=0;i<properties.length;i++) {
			Property prop=this.properties[i];
			//if prop doesn't equal null, skips and moves on to the next if statement
			if(prop==null) {
				continue;
			}
			//finds the largest rent amount, sets it to maxRent
			if(prop.getRentAmount()>maxRent) {
				maxRent=prop.getRentAmount();
			}
		}
		return maxRent;
	}
	/**
	 * Finds the index of the property with the maximum rent
	 * @return integer, the index of the property with the maximum rent
	 */
	public int maxRentPropertyIndex() {
		//tracks index
		int tracker=0;
		int maxIndex=0;
		for(int i=0;i<tracker;i++) {
			//if an array in properties has the highest rent, sets its index to maxRent
			if(properties[i].getRentAmount()>properties[maxIndex].getRentAmount()) {
				maxIndex=i;
			}
		}
		return maxIndex;
	}
	/**
	 * Display information of property at index i
	 * @param i
	 * @return info of property at index i
	 */
	public String displayPropertyAtIndex(int i) {
		return properties[i].toString();
	}
	/**
	 * Display information of all properties within the properties array
	 * @return information of all properties inside properties array 
	 */
	public String toString() {
		String str="";
		//prints out all the information about each property inside properties array 
		System.out.println("List of properties for "+name+", taxID: "+taxID);
		System.out.println("________________________________________________");
		//loops for each property added
		for(int i=0;i<MAX_PROPERTY;i++) {
				if(properties[i]!=null) {
					str+="\n Property Name: "+properties[i].getPropertyName()+"\n Located in: "+properties[i].getCity()+"\n Belonging to: "+properties[i].getOwner()+"\n Rent Amount: "+properties[i].getRentAmount();
				}
			}
		
		System.out.println("Total management Fee: "+totalRent()*(mgmFeePer*0.01));
		return str;
	}
}
