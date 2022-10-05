public class PersonNotFoundException extends RuntimeException{
    PersonNotFoundException(String errorDescription){
        super(errorDescription);
    }
}
