package excepciones;

public class PersonaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PersonaException() {
		
	}

    public PersonaException(String mensaje) {
		super(mensaje);
	}
}
