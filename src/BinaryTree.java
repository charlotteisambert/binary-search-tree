public class BinaryTree {
	AbstractNode root;
	OrderingStrategy strategy;

	BinaryTree(AbstractNode node, OrderingStrategy strategy) {
		this.root = node;
		this.strategy = strategy;
	}

	public boolean add(String value) {
		return this.root.add(value, null, this.strategy);
	}

	public String accept(Visitor visitor) {
		return this.root.accept(visitor);
	}

	public AbstractNode getRoot() {
		return root;
	}

	public void setRoot(AbstractNode Node) {
		this.root = Node;
	}
}