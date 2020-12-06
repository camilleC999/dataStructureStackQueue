/**
* This class creates and initializes the stack object.
* 
*
* @author Camille Copeland
* @version 02/22/2020
*/
public class Stack {
	
private int maxSize;
private Country[] arr;
private int top;
static String format = "%1$-40s %2$-30s %3$-30s %4$-30s %5$-30s %6$-30s\n";
	
	public Stack(int max) {// this is the constructor
		maxSize = max; 
		arr = new Country[maxSize];
		top= -1;
	
	}
	
	public void push(Country a) {//this adds an object to the stack
	arr[++top] = a;
	}
	
	public Country pop() {//this deletes an object from the stack
		return arr[top--];
	}
	
	public void printStack() {// this prints stack
		System.out.format(format, "\nName", "Code", "Capitol", "Population", "GDP", "Happiness Rank");
		System.out.println("------------------------------------------------------------"
				+ "----------------------------------------------------------------------------------------------------------------------");
		for(int i = 154; i > -1; i--)
			arr[i].printInfo();

	}
	
	public boolean isEmpty() {// tells whether it's empty
		if(top == -1) {
			return true;
		}
		else
			return false;
	}
	
	public boolean isFull() {//tells whether it's full 
		if(top == maxSize -1) {
			return true;
		}
		else
			return false;
	}

}
