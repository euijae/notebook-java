package go.there.soon.lecture.queue;

public class QueueException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public QueueException(String name) {
		super(name);
	}
	
	public QueueException() {
		super();
	}
}
