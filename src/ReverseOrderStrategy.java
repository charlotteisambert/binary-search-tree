public class ReverseOrderStrategy implements OrderingStrategy {

	@Override
	public int compareTo(String firstValue, String secondValue) {
		String firstValueReverse = new StringBuilder(firstValue).reverse().toString();
		String secondValueReverse = new StringBuilder(secondValue).reverse().toString();
		return firstValueReverse.compareTo(secondValueReverse);
	}

}
