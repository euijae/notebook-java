package go.there.soon.lecture.stack;

public class StackException extends RuntimeException{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StackException(String name) {
		super(name);
	}
	
	public StackException() {
		super();
	}
}
