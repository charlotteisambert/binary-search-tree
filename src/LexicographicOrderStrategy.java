public class LexicographicOrderStrategy implements OrderingStrategy {

	@Override
	public int compareTo(String firstValue, String secondValue) {
		return firstValue.compareTo(secondValue);
	}

}
