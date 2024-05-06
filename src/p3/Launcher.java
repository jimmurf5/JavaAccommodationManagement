package p3;
/**
 * James Murphy 40372572
 */

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Launcher {

	private static Scanner scanner = new Scanner(System.in);
	private static final int QUIT = 10;
	

	/**
	 * Entry point of program - no need to modify this method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		launchMenu();
		scanner.close();// close scanner once menu system completes
	}

	// TODO modify readData method to populate List appropriately - method partially
	// completed already
	// TODO add static methods to this class as required to achieve tasks outlined
	// in menu
	// TODO modify launchMenu method to add calls to new methods you write etc to
	// accomplish the tasks outlined in the menu

	/**
	 * Launches menu system which in turn calls appropriate methods based on user
	 * choices Partially implemented already. Requires updating to add calls to other
	 * methods written to achieve the tasks described in tasks 3-9
	 */
	public static void launchMenu() {
		List<Accomodation> mainList = readRoomData("Rooms.csv");

		System.out.println();
		int option;
		System.out.println("AccommyNation.com - Wherever you go, you'll need to stay");

		// repeat until quit chosen
		do {
			displayOptions();

			// get input
			option = getMenuChoice("Enter choice ...");
			System.out.println();

			try {
				// process choice - invoke relevant methods etc.
				switch (option) {

				case 1:
					mainList = readRoomData("Rooms.csv");
					break;
				case 2:
					System.out.println("Number of places to stay is " + mainList.size());
					break;
				case 3:
					System.out.println("Here are all the places to stay.");
					printedDetails(mainList);
					break;
				case 4:
					System.out.println("Here are the 3 least expensive place to stay in Los Angeles with a 4 star rating, ordered by price – low to high");
					List<Accomodation> cheapies = findXCheapestInX(mainList, "Los Angeles", 3, 4);
					printedDetails(cheapies);
					break;
				case 5:
					System.out.println("The number of unique cities");
					uniqueDestinations(mainList);
					break;
				case 6:
					System.out.println("the 4 most expensive BnBs in Dublin, ordered by price – high to low ");
					List<Accomodation> pricy = findXExpensiveInX(mainList, "Dublin", 4, Type.BNB);
					printedDetails(pricy);
					break;
				case 7:
					System.out.println(" the average price of a hotel in New York correct to 2 decimal places.");
					averagePriceCalc(mainList,"New York", Type.HOTEL);
					break;
				case 8:
					System.out.println("Remove all entries from the current list with fewer than 10 rooms available in Paris");
					removeAllXInX(mainList,10,"Paris");
					break;
				case 9:
					System.out.println("Task Not Yet Implemented");
					//TODO add required method calls etc
					break;
				case QUIT:
					System.out.println("Quitting");
					break;
				default:
					System.out.println("Try options again...");
				}

			} catch (Exception e) {
				System.out.println("Exception caught");
				System.out.println(e.getMessage());
				System.out.println("please try again");
			}

		} while (option != QUIT);
	}

	
	

	

	/**
	 * Read data from a given filename for a formatted csv file of accommodation
	 * data
	 * 
	 * @param filename
	 * @return list of accommodation objects for each row of the file containing
	 *         valid data
	 */
	public static List<Accomodation> readRoomData(String filename) {
		List<Accomodation> rooms = new ArrayList<Accomodation>();
		
		String line = null;//declare a string to hold the value of each line from file
		File file = new File(filename);
		//now read the file
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			br.readLine();//read and discard the header
			line = br.readLine();//read the next line
			//now lets loop through the file until line is null
			while(line!=null) {
			//surround this section in try catch so that if the business rules are violated the file reading will continue	
			try {
				//declare an array to parse the line
			String[] parsed = line.split(",");
			//declare an accomodation object to store the data in
			Accomodation accom = new Accomodation(parsed[0].trim(), Type.valueOf(parsed[1].toUpperCase()), Integer.parseInt(parsed[2]), parsed[3], Integer.parseInt(parsed[4]), Integer.parseInt(parsed[5]));
			
			//store the object in the list
			rooms.add(accom);
			}catch(IllegalArgumentException exp) {
				System.out.println("This line violated the business rules for accomodation.");
				System.out.println("Skipping this line and continuing onto the next. Have a nice day.");
			}
			line = br.readLine();//read the next line
			}
			br.close();;//close open resources
		} catch (IOException e) {
			System.out.println("There was a problem reading or finding the file.");
			e.printStackTrace();
		}
		// TODO update method to read from formatted csv
		// TODO create an Accommodation object for each line of the file and add to
		// rooms list
		// TODO skip any lines which contain data which doesnt match business rules

		System.out.println(rooms.size() + " entries read successfully");
		return rooms;
	}

	/**
	 * Display prompt and get int user input via static scanner repeat if invalid
	 * input type given - no need to modify this method
	 * 
	 * @return int value entered via scanner
	 */
	private static int getMenuChoice(String prompt) {
		try {
			System.out.println(prompt);
			int choice = scanner.nextInt();
			return choice;
		} catch (Exception e) {
			System.out.println("Invalid input try again");
			// clear buffer if required
			if (scanner.hasNext()) {
				scanner.next();// read and discard line break
			}
			return getMenuChoice(prompt);// return recursive call to method to recover
		}
	}

	/**
	 * Writes menu options to console - no need to modify this method
	 */
	private static void displayOptions() {
		System.out.println();
		System.out.println("Menu Options:");
		System.out.println("1. (Re)read Data From Original File (use to restore removed data for example)");
		System.out.println("2. Display the number of places to stay in the current list");
		System.out.println("3. Display details for all places to stay in the current list");
		System.out.println(
				"4. Display details of the 3 least expensive 4 Star places to stay in Los Angeles (low to high)");
		System.out.println("5. Display the number of cities in the current list");
		System.out.println("6. Display details of the 4 most expensive BnBs in Dublin (high to low)");
		System.out.println("7. Display the average price of a hotel in New York");
		System.out.println("8. Remove all entries with fewer than 10 rooms available for Paris from the current list");
		System.out.println("9. (Separate Thread) Write out to a formatted csv, "
				+ "\nthe name of each city and the average price of a hotel there (2 decimal places, alphabetcically by City name)");
		System.out.println("10. Quit");
	}
	
	/**
	 * Checks a list of accomodation objects
	 * @param list
	 * @throws IllegalArgumentException If the list is null or empty
	 */
	public static void listChecker(List<Accomodation> list) throws IllegalArgumentException{
		if(list==null) {
			throw new IllegalArgumentException("The list was null. That is not valid.");
		}else if(list.isEmpty()) {
			throw new IllegalArgumentException("The list was empty. That is not valid.");
		}
	}
	
	/**
	 * takes a list of accomodation objects and displays the details of each to screen
	 * @throws IllegalArgumentException If the list is null or empty
	 */
	public static void printedDetails(List<Accomodation> list)throws IllegalArgumentException {
		listChecker(list);//check list first
		int counter = 1;// a counter for the objects
		//now loop through the list
		for(Accomodation x : list) {
			System.out.println(counter+")");
			x.printDetails();
			counter++;
		}
		
	}
	
	/**
	 * Method takes a list and searches for the X number of cheaper hotels in a city X with a star rating X
	 * @param list
	 * @param string
	 * @param numb
	 * @param stars
	 * @return
	 * @throws IllegalArgumentException If the list if null or empty. if numb is less than one, the city is less than one character or is a null value, also star rating search must be 1,2,3,4 or 5
	 */
	public static List<Accomodation> findXCheapestInX(List<Accomodation> list, String city, int numb, int stars) throws IllegalArgumentException{
		listChecker(list);//check the list
		List<Accomodation> copy = new ArrayList<Accomodation>(list);//a copy list to manipulate
		List<Accomodation> results = new ArrayList<Accomodation>();//a results list to return
		//some more validation
		if(numb<1) {
			throw new IllegalArgumentException("You cannot search for less than one.");
		}else if(stars<Accomodation.MIN_STAR||stars>Accomodation.MAX_STAR){
			throw new IllegalArgumentException("The rating searched must be 1,2,3,4 or 5.");
		}else if(city==null||city.length()<Accomodation.MIN_STRING) {
			throw new IllegalArgumentException("City cannot be null or less than one character.");
		}else {
			Collections.sort(copy, new SortByPrice());//sort the copy list by price low to high
			//loop through the list and add desired objects to results list
			for(Accomodation x : copy) {
				if(x.getCity().equalsIgnoreCase(city)&&x.getStars()==4&&results.size()<numb) {
					results.add(x);
				}
			}
		}
		if(results.size()<numb) {
			System.out.println("Apologies there are only "+results.size()+" results for your search criteria.");
		}
		return results;
	}
	
	/**
	 * Takes a list of accomodation object and prints to screen the number of unique cities in the list
	 * @param mainList
	 * @throws IllegalArgumentException If input list is empty or null
	 */
	public static void uniqueDestinations(List<Accomodation> list)throws IllegalArgumentException {
		listChecker(list);//check the list
		Set<String> citySet = new TreeSet<String>();//a set to store only unique cities
//		Map<String, Integer> uniqueMap = new HashMap<String, Integer>();// a map to map out the unique destination
		//lets loop through the list and add unique cities to the set
		for(Accomodation x : list) {
			if(!citySet.contains(x.getCity())) {
				citySet.add(x.getCity());
			}
		}
		System.out.println("Number of cities: "+citySet.size());
	}
	
	/**
	 * displays the x most expensive accomodation in x ordered high to low
	 * @param list
	 * @param city
	 * @param numb
	 * @return
	 * @throws IllegalArgumentException If the list if null or empty. if numb is less than one, the city is less than one character or is a null value. also if type is null
	 */
	private static List<Accomodation> findXExpensiveInX(List<Accomodation> list, String city, int numb,Type type)throws IllegalArgumentException {
		listChecker(list);//check the list
		List<Accomodation> copy = new ArrayList<Accomodation>(list);//a copy list to manipulate
		List<Accomodation> results = new ArrayList<Accomodation>();//a results list to return
		//some more validation
		if(numb<1) {
			throw new IllegalArgumentException("You cannot search for less than one.");
		}else if(city==null||city.length()<Accomodation.MIN_STRING) {
			throw new IllegalArgumentException("City cannot be null or less than one character.");
		}else if(type==null) {
			throw new IllegalArgumentException("Type cannot be null please.");
		}else {
			Collections.sort(copy, new SortByPriceHighDown());//sort the copy list by price high to low
			//loop through the list and add desired objects to results list
			for(Accomodation x : copy) {
				if(x.getCity().equalsIgnoreCase(city)&&x.getType().equals(type)&&results.size()<numb) {
					results.add(x);
				}
			}
		}
		if(results.size()<numb) {
			System.out.println("Apologies there are only "+results.size()+" results for your search criteria.");
		}
		return results;
	}
	
	/**
	 * gets the average price of an accomodation type in a city. prints to screen
	 * @param list
	 * @param string
	 * @param type
	 * @throws IllegalArgumentException
	 */
	public static void averagePriceCalc(List<Accomodation> list, String city, Type type)throws IllegalArgumentException {
		listChecker(list);
		List<Accomodation> countList = new ArrayList<Accomodation>();
		int sum = 0;//a var to hold the sum
	if(city==null||city.length()<Accomodation.MIN_STRING) {
		throw new IllegalArgumentException("City cannot be null or less than one character.");
	}else if(type==null) {
		throw new IllegalArgumentException("Type cannot be null please.");
	}else {
		for(Accomodation x : list) {
			if(x.getType().equals(type)&&x.getCity().equals(city)) {
				sum+=x.getPrice();//sum up all the matches for price
				countList.add(x);//add to count list to keep a count
			}
		}
	}
	//display the result
	double average = (double)sum/countList.size();
	System.out.printf("Average price %s: £%.2f",city,average);
	}
	
	public static List<Accomodation> removeAllXInX(List<Accomodation> list, int numb, String city) {
		listChecker(list);
		if(city==null||city.length()<Accomodation.MIN_STRING) {
			throw new IllegalArgumentException("City cannot be null or less than one character.");
		}else {
			//loop through list and remove any entries they meet the criteria
			for(Accomodation x : list) {
			if(x.getCity().equals(city)&&x.getRooms()<numb) {
				list.remove(x);
			}
		}
		}
		
		return list;
	}

}
