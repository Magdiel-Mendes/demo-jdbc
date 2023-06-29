package db;

public class DbIntegrityExceptioin extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public DbIntegrityExceptioin(String msg) {
		super(msg);
	}

}
