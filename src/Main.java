public class Main {
	public static void main(String[] args) {
		OrderingStrategy strategy = new LexicographicOrderStrategy();
		AbstractNode myNode = new RealNode("ca", strategy);
		BinaryTree myTree = new BinaryTree(myNode, strategy);
		myTree.add("bz");
		myTree.add("ze");

		Visitor lineVisitor = new LinePrintVisitor();
		System.out.println(myTree.accept(lineVisitor));
	}
}
