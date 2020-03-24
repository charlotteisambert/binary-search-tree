class NullNode implements AbstractNode {
	String value;
	OrderingStrategy strategy;

	NullNode() {
	}

	public boolean add(String value, AbstractNode parent, OrderingStrategy strategy) {
		if (strategy.compareTo(value, parent.getValue()) < 0) {
			this.addLeftNodeToParent(value, parent, strategy);
		} else if (strategy.compareTo(value, parent.getValue()) > 0) {
			this.addRightNodeToParent(value, parent, strategy);
		}
		return true;
	}

	public boolean addLeftNodeToParent(String value, AbstractNode parent, OrderingStrategy strategy) {
		parent.setLeft(new RealNode(value, strategy));
		return true;
	}

	public boolean addRightNodeToParent(String value, AbstractNode parent, OrderingStrategy strategy) {
		parent.setRight(new RealNode(value, strategy));
		return true;
	}

	public String accept(Visitor visitor) {
		return visitor.visitNullNode(this);
	}

	public AbstractNode getLeft() {
		return null;
	}

	public AbstractNode getRight() {
		return null;
	}

	public void setLeft(AbstractNode left) {
	}

	public void setRight(AbstractNode right) {
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}