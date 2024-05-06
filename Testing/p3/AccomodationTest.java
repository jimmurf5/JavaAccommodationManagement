package p3;
/**
 * James Murphy 40372572
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AccomodationTest {
	
	//declare some test data
	String validShortStr, validLongerStr;
	String invalidShortStr;
	int starLow, starMid, starHigh;
	int invalStarLow, invalStarHigh;
	Type hotel, hostel, bnb;
	int nonNeg;
	int neg;
	
	Accomodation accom;
	
	@BeforeEach
	void setUp() throws Exception {
		validShortStr = "a";
		validLongerStr = "a".repeat(8);
		invalidShortStr = "";
		starLow = 1;
		starMid = 3;
		starHigh = 5;
		invalStarLow = 0;
		invalStarHigh = 6;
		hotel = Type.HOTEL;
		hostel = Type.HOSTEL;
		bnb = Type.BNB;
		nonNeg = 0;
		neg = -1;
		
		accom = new Accomodation(validLongerStr, bnb, starHigh, validLongerStr, starMid, starMid);
	}

	@Test
	void testAccomodationConstructor() {
		Accomodation ac = new Accomodation(validLongerStr, bnb, starHigh, validShortStr, nonNeg, nonNeg);
		assertEquals(validLongerStr, ac.getName());
		assertEquals(bnb, ac.getType());
		assertEquals(starHigh, ac.getStars());
		assertEquals(validShortStr, ac.getCity());
		assertEquals(nonNeg, ac.getPrice());
		assertEquals(nonNeg, ac.getRooms());
	}
	
	@Test
	void invalConstructTest(){
		assertThrows(IllegalArgumentException.class, ()->{
			new Accomodation(invalidShortStr, bnb, starHigh, validShortStr, nonNeg, nonNeg);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Accomodation(validShortStr, null, starHigh, validShortStr, nonNeg, nonNeg);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Accomodation(validShortStr, bnb, invalStarLow, validShortStr, nonNeg, nonNeg);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Accomodation(validShortStr, bnb, starHigh, invalidShortStr, nonNeg, nonNeg);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Accomodation(validShortStr, bnb, starHigh, validShortStr, neg, nonNeg);
		});
		assertThrows(IllegalArgumentException.class, ()->{
			new Accomodation(validShortStr, bnb, starHigh, validShortStr, nonNeg, neg);
		});
	}

	@Test
	void testSetName() {
		//these tests not completed as per spec but appropraited test data set up
		fail("Not yet implemented");
	}

	@Test
	void testSetType() {
		fail("Not yet implemented");
	}

	@Test
	void testSetStars() {
		accom.setStars(starLow);
		assertEquals(starLow, accom.getStars());
		accom.setStars(starMid);
		assertEquals(starMid, accom.getStars());
		accom.setStars(starHigh);
		assertEquals(starHigh, accom.getStars());
	}
	
	@Test
	void invalidTestSetStars() {
		Exception exp = assertThrows(IllegalArgumentException.class, ()->{
			accom.setStars(invalStarHigh);
		});
		assertEquals(exp.getMessage(), "Not valid, the star rating must be from 1 to 5 inclusive.");
		exp = assertThrows(IllegalArgumentException.class, ()->{
			accom.setStars(invalStarLow);
		});
		assertEquals(exp.getMessage(), "Not valid, the star rating must be from 1 to 5 inclusive.");
	}

	@Test
	void testSetCity() {
		fail("Not yet implemented");
	}

	@Test
	void testSetPrice() {
		fail("Not yet implemented");
	}

	@Test
	void testSetRooms() {
		fail("Not yet implemented");
	}

}
