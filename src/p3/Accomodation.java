/**
 * 
 */
package p3;
/**
 * James Murphy 40372572
 */

/**
 * @author james
 *This class represents a type of accomodation
 */
public class Accomodation {
	
	//declare some set values
	public static final int MIN_STRING = 1;
	public static final int MIN_STAR = 1;
	public static final int MAX_STAR = 5;
	public static final int NON_NEG = 0;
	
	
	/**
	 * The name of the accomodation
	 */
	private String name;
	
	/**
	 * The type of the accomodation
	 */
	private Type type;
	
	/**
	 * The star rating of the accomodation
	 */
	private int stars;
	
	/**
	 * The city of the accomodation
	 */
	private String city;
	
	/**
	 * The price of the accomodation
	 */
	private int price;
	
	/**
	 * The number of rooms of the accomodation
	 */
	private int rooms;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	
	
	

	/**
	 * Constructor with args for the accomodation class
	 * @param name
	 * @param type
	 * @param stars
	 * @param city
	 * @param price
	 * @param rooms
	 * @throws IllegalArgumentException
	 */
	public Accomodation(String name, Type type, int stars, String city, int price, int rooms)throws IllegalArgumentException {
		this.setName(name);
		this.setType(type);
		this.setStars(stars);
		this.setCity(city);
		this.setPrice(price);
		this.setRooms(rooms);
	}

	



	/**
	 * sets the name of the accomodation
	 * @param name
	 * @throws IllegalArgumentException If the name is null or less than on character in length
	 */
	public void setName(String name) throws IllegalArgumentException{
		if(name==null) {
			throw new IllegalArgumentException("The name cannot be null.");
		}else if(name.length()<MIN_STRING) {
			throw new IllegalArgumentException("The name must be at least one character long.");
		}else {
			this.name = name;
		}
		
	}

	/**
	 * @return the type
	 */
	public Type getType() {
		return type;
	}

	/**
	 * Sets the type of accomodation
	 * @param type
	 * @throws IllegalArgumentException If the type is null
	 */
	public void setType(Type type)throws IllegalArgumentException {
		if(type==null) {
			throw new IllegalArgumentException("The type cannot be null. Not valid.");
		}else {
			this.type = type;
		}
		
	}

	/**
	 * @return the stars
	 */
	public int getStars() {
		return stars;
	}

	/**
	 * sets the star rating of the accomodation
	 * @param stars
	 * @throws IllegalArgumentException If the star are less than 1 or more than 5
	 */
	public void setStars(int stars)throws IllegalArgumentException {
		if(stars<MIN_STAR||stars>MAX_STAR) {
			throw new IllegalArgumentException("Not valid, the star rating must be from 1 to 5 inclusive.");
		}else {
			this.stars = stars;
		}
		
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * 
	 * @param city
	 * @throws IllegalArgumentException If the city is null or less than one character in length
	 */
	public void setCity(String city)throws IllegalArgumentException {
		if(city==null) {
			throw new IllegalArgumentException("The city cannot be null.");
		}else if(city.length()<MIN_STRING) {
			throw new IllegalArgumentException("The city must be at least one character long.");
		}else {
			this.city= city;
		}
	}

	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * sets the price of the accomodation
	 * @param price
	 * @throws IllegalArgumentException If the price is a negative number
	 */
	public void setPrice(int price)throws IllegalArgumentException {
		if(price<NON_NEG) {
			throw new IllegalArgumentException();
		}else {
			this.price = price;
		}
		
	}

	/**
	 * @return the rooms
	 */
	public int getRooms() {
		return rooms;
	}

	/**
	 * sets the rooms in the accomodation
	 * @param rooms
	 * @throws IllegalArgumentException If the number of rooms is negative
	 */
	public void setRooms(int rooms)throws IllegalArgumentException {
		if(rooms<NON_NEG) {
			throw new IllegalArgumentException();
		}else {
			this.rooms = rooms;
		}
		
	}
	
	/**
	 * prints all the details of accomodation
	 */
	public void printDetails() {
		System.out.printf("Name: %s\n",this.name);
		System.out.printf("City: %s\n",this.city);
		System.out.printf("Type: %s\n",this.type);
		System.out.printf("Capacity:%d @ £%d\n",this.rooms,this.price);
		switch(getStars()) {
		case 1:System.out.println("*");
			break;
		case 2:System.out.println("**");
			break;
		case 3:System.out.println("***");
			break;
		case 4:System.out.println("****");
			break;
		case 5:System.out.println("*****");
			break;
		default:System.out.println("An error has occured.");
			break;
		
		}
		
	}
	

}
