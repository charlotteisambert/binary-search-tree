public abstract interface Visitor {

	public abstract String visitRealNode(AbstractNode binaryTree);

	public abstract String visitNullNode(AbstractNode binaryTree);
}
