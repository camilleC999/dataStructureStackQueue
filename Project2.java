/**
* COP 3538: Project 2 – Stacks and Priority Queues
* 
*This class creates the priority queue objects for poor, fair,
*good, very good, and excellent countries. It then reads the
*Countries2.csv file, creates the country objects, and assigns 
*each country to its priority queue. The class then prints the
*poor, fair, good, very good, and excellent. It then creates
*the stack object and loads each of the priority queues into
*the stack. 
*
* @author Camille Copeland
* @version 2/22/2020**/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Project2 {
	static Country country;
	static long x; 

	public static void main(String[] args) throws FileNotFoundException {
		Priority poor = new Priority(24);
		Priority fair = new Priority(47);
		Priority good = new Priority(46);
		Priority vGood = new Priority(23);
		Priority excellent = new Priority(15);
		
		Scanner in = new Scanner(System.in);//scanner to take input
		System.out.println("Please enter file name: ");
		String b = in.nextLine();// user input
		
		
		
		File file = new File(b);// takes the file 
		Scanner read = new Scanner(file);// allows for the file to be read 
		read.useDelimiter("\n|,");//allows parsing of each line
		read.nextLine();// skips the header
			
		for(int i = 0; i < 155; i++) {// for initializes each individual object in the array and assigns values to its attributes
			String ab = read.next();
			String ac = read.next();
			String ad = read.next();
			String ae = read.next();
			String af = read.next();
			String ag = read.next();
			country = new  Country(ab, ac, ad, ae, af, ag);
			country.setCountry(ab);
			country.setCountryCode(ac);
			country.setCapitol(ad);
			country.setPopulation(ae);
			country.setGDP(af);
			country.setHappy(ag);
			country.setperCap(ae, af);
			x = country.getperCap();
			
			if(x >= 50000)
				excellent.insert(country); 
			if (x >= 20000 && x <50000)
				vGood.insert(country);
			if (x >= 5000 && x < 20000)
				good.insert(country);
			if(x >= 1000 && x < 5000)
				fair.insert(country);
			if( x < 1000)
				poor.insert(country);
			read.nextLine();	

		}

		poor.printQueue();
		fair.printQueue();
		good.printQueue();
		vGood.printQueue();
		excellent.printQueue();
		
		Stack a = new Stack(155);
		
	for(int i =0; i < 24; i++) {
		a.push(poor.remove());
	}
	for(int i =0; i < 47; i++) {
		a.push(fair.remove());
	}
	for(int i =0; i < 46; i++) {
		a.push(good.remove());
	}
	for(int i =0; i < 23; i++) {
		a.push(vGood.remove());
	}
	for(int i =0; i < 15; i++) {
		a.push(excellent.remove());
	}
	
		a.printStack();
	}
	

}
