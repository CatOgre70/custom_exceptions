import java.util.ArrayList;
import java.util.List;

public class PersonDb {

    private List<Person> personDb;

    public PersonDb() {
        this.personDb = new ArrayList<>(List.of(
                new Person(1, "Ivan", "Ivanov"),
                new Person(2, "Petr", "Petrov"),
                new Person(3, "Sidor", "Sidorov"),
                new Person(4, "Mikhail", "Mikhailov"),
                new Person(5, "Sergey", "Sergeev")));
    }

    public Person addPerson(Person person){
        boolean isFound = false;
        for (Person p : personDb) {
            if(p.getId() == person.getId()) {
                isFound = true;
                break;
            }
        }
        if(!isFound){
            personDb.add(person);
            return person;
        } else {
            throw new PersonAlreadyExistsException("Person " + person + "is already in the database");
        }
    }

    public Person getPerson(int id){
        for (Person p : personDb) {
            if(p.getId() == id) {
                return p;
            }
        }
        throw new PersonNotFoundException("Person with id = " + id + "  is not found in the database");
    }

    public Person updatePerson(Person person){
        for(int i = 0; i < personDb.size(); i++) {
            if(person.getId() == personDb.get(i).getId()){
                personDb.set(i, person);
                return person;
            }
        }
        throw new PersonNotFoundException("Person with id = " + person.getId() + "  is not found in the database");
    }

    public List<Person> getAllPersons(){
        return personDb;
    }

}
