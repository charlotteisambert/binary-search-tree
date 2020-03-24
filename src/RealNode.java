class RealNode implements AbstractNode {
	String value;
	AbstractNode left;
	AbstractNode right;
	OrderingStrategy strategy;

	RealNode(String value, OrderingStrategy strategy) {
		this.value = value;
		this.left = new NullNode();
		this.right = new NullNode();
		this.strategy = strategy;
	}

	// This method recursively traverses the tree doing nothing until it hits a null
	// node, to finally be able to add the node at the right place
	public boolean add(String value, AbstractNode parent, OrderingStrategy strategy) {
		// The strategy is passed as argument in ordered to be passed to the end node,
		// which can then add the strategy to the new node it creates
		if (strategy.compareTo(value, this.getValue()) < 0) {
			this.getLeft().add(value, this, strategy);
		} else if (strategy.compareTo(value, this.getValue()) > 0) {
			this.getRight().add(value, this, strategy);
		}
		return true;
	}

	public String accept(Visitor visitor) {
		return visitor.visitRealNode(this);
	}

	public AbstractNode getRight() {
		return right;
	}

	@Override
	public AbstractNode getLeft() {
		return left;
	}

	public void setLeft(AbstractNode left) {
		this.left = left;
	}

	public void setRight(AbstractNode right) {
		this.right = right;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
