public class Main {
    public static void main(String[] args) {

        int id = 10;
        Person person;
        PersonDb personDb = new PersonDb();

        try{
            person = personDb.getPerson(id);
        } catch(PersonNotFoundException e) {
            System.out.println("Person with id = " + id + " is not found in the database");
            return;
        }
        System.out.println("person = " + person);
    }
}