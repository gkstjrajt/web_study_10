package web_study_10.exception;

@SuppressWarnings("serial")
public class CustomSQLException extends RuntimeException {

	public CustomSQLException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
	
	public CustomSQLException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
	
}
