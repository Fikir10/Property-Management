import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
public class ManagementCompanyTestsSTUDENT {
	Property p1, p2, p3,p4,p5,p6;
	ManagementCompany mgmt;
	@Before
	public void setUp() throws Exception {
		//student create a management company
		p1=new Property("New Hilton","Beltsville",2300,"John Smith",1,1,2,2);
		p2=new Property("Bluebell","Alexandria",2500,"Samson Joseph",3,1,2,2 );
		p3=new Property("Beacon Homes","Silver Spring",1950,"Lilian Morono",6,1,2,2);
		
		mgmt=new ManagementCompany("Kaley","5670",6);
		//student add three properties, with plots, to mgmt co
		mgmt.addProperty(p1);
		mgmt.addProperty(p2);
		mgmt.addProperty(p3);
	}

	@After
	public void tearDown() {
		//student set mgmt co to null 
		p1=p2=p3=p4=p5=p6=null;
		mgmt=null;
	}

	@Test
	public void testAddPropertyDefaultPlot() {
		//student should add property with 4 args & default plot (0,0,1,1)
		p4=new Property("Estate", "Las Vegas", 3400, "James Cordon",0,0,1,1);
		//student should add property with 8 args
		p5=new Property("The Agency", "New York City", 3900,"Felicity Smoak",1,1,2,1);
		//student should add property that exceeds the size of the mgmt co array and can not be added, add property should return -1
		p6=new Property("Zephier","Anapolis",1950,"Ed Jacob",6,5,2,2);
	
		assertEquals(mgmt.addProperty(p4),3,0);
		assertEquals(mgmt.addProperty(p5),-4,0);
		assertEquals(mgmt.addProperty(p6),4,0);
	}
 
	@Test
	public void testMaxRentProp() {
		//student should test if maxRentProp contains the maximum rent of properties
		assertEquals(mgmt.maxRentProp(),2500.0,0);
	}

	@Test
	public void testTotalRent() {
		//student should test if totalRent returns the total rent of properties
		assertEquals(mgmt.totalRent(),6750.0,0);
	}
}
