public class LinePrintVisitor implements Visitor {

	@Override
	public String visitRealNode(AbstractNode node) {
		String ls = node.getLeft().accept(this);
		String rs = node.getRight().accept(this);
		return ("(" + node.getValue() + ls + rs + ")");
	}

	@Override
	public String visitNullNode(AbstractNode binaryTree) {
		return ("()");
	}

}
