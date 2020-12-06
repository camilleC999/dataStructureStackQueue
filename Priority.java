/**
* This class creates and initializes the priority queue object.
* 
*
* @author Camille Copeland
* @version 02/22/2020
*/
public class Priority {
	
	Country[] someCountry;
	int maxSize;
	int nItems; 
	int count = 0;
	static String format = "%1$-40s %2$-30s %3$-30s %4$-30s %5$-30s %6$-30s\n";
	public Priority(int max) {// constructor
		maxSize = max; 
		someCountry = new Country[maxSize];
		nItems = 0;
	}
	
	public void insert(Country a) {	//inserts country object into queue
		int j;
		
		if(isEmpty())
			someCountry[nItems++] = a; 
		else {
			for(j=nItems-1; j>=0; j--) {
				if(a.getperCap() > someCountry[j].getperCap())
					someCountry[j+1] = someCountry[j];
				else
					break;
			}//end for
			someCountry[j+1] = a;
			nItems++;
		}
	}// end method
	
	public Country remove() {// removes from queue
		return someCountry[count++];
	}
	
	public boolean isEmpty() {// tells whether it's empty
		if(nItems == 0)
			return true;
		else
			return false;
	}
	
	public boolean isFull() { // tells whether it's full
		if(nItems == maxSize)
			return true;
		else
			return false;
	}
	public void printQueue() {// prints queue
		System.out.format(format, "\nName", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
		System.out.println("------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------------------------------------");
		for(int i=0; i < nItems; i++ ) { 
			if(someCountry[i] != null) 
				someCountry[i].printInfo();
		}
	}
	
	
	
}
