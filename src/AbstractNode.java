public interface AbstractNode {

	public boolean add(String value, AbstractNode parent, OrderingStrategy strategy);

	public String accept(Visitor visitor);

	public AbstractNode getRight();

	public AbstractNode getLeft();

	public void setLeft(AbstractNode left);

	public void setRight(AbstractNode right);

	public String getValue();

	public void setValue(String value);
}
