package p3;

import java.util.Comparator;
/**
 * sort accommodation object according to price  high to low
 */
/**
 * James Murphy 40372572
 */
public class SortByPriceHighDown implements Comparator<Accomodation> {

	@Override
	public int compare(Accomodation o1, Accomodation o2) {
		
		return o2.getPrice()-o1.getPrice();
	}

	

}
