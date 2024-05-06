package p3;

import java.util.Comparator;
/**
 * sort accommodation object according to price low to high
 */
/**
 * James Murphy 40372572
 */
public class SortByPrice implements Comparator<Accomodation> {

	@Override
	public int compare(Accomodation o1, Accomodation o2) {
		
		return o1.getPrice()-o2.getPrice();
	}

	
	

}
