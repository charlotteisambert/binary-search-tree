import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestBinaryTree {
	OrderingStrategy lexicographicOrderStrategy = new LexicographicOrderStrategy();
	OrderingStrategy reverseOrderStrategy = new ReverseOrderStrategy();
	AbstractNode myFirstNode = new RealNode("ca", lexicographicOrderStrategy);
	AbstractNode mySecondNode = new RealNode("ca", reverseOrderStrategy);
	BinaryTree lexicographicBinaryTree;
	BinaryTree reverseBinaryTree;
	Visitor lineVisitor = new LinePrintVisitor();

	@BeforeEach
	void beforeEach() {
		lexicographicBinaryTree = new BinaryTree(myFirstNode, lexicographicOrderStrategy);
		reverseBinaryTree = new BinaryTree(mySecondNode, reverseOrderStrategy);
	}

	@Test
	void testVisitorRepresentation() {
		lexicographicBinaryTree.add("bz");
		lexicographicBinaryTree.add("ze");
		String visitTree = lexicographicBinaryTree.accept(lineVisitor);
		assert (visitTree.compareTo("(ca(bz()())(ze()()))") == 0);
	}

	@Test
	void testLexicographicOrder() {
		lexicographicBinaryTree.add("bz");
		lexicographicBinaryTree.add("ae");
		lexicographicBinaryTree.add("da");
		lexicographicBinaryTree.add("fz");
		lexicographicBinaryTree.add("er");
		String visitTree = lexicographicBinaryTree.accept(lineVisitor);
		assert (visitTree.compareTo("(ca(bz(ae()())())(da()(fz(er()())())))") == 0);
	}

	@Test
	void testReverseOrder() {
		reverseBinaryTree.add("bz");
		reverseBinaryTree.add("ae");
		reverseBinaryTree.add("da");
		reverseBinaryTree.add("fz");
		reverseBinaryTree.add("er");
		String visitTree = reverseBinaryTree.accept(lineVisitor);
		assert (visitTree.compareTo("(ca()(bz(ae(da()())(er()()))(fz()())))") == 0);
	}

	@Test
	void testAddBiggerLexicographic() {
		boolean returned = lexicographicBinaryTree.add("aa");
		assert (lexicographicBinaryTree.getRoot().getLeft().getValue() == "aa");
		assert (returned == true);
	}

}
