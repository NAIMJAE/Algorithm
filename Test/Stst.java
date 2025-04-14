package Test;

public class Stst {
    public static void main(String[] args) {
        
        PersonMoving p1 = new PersonMoving();
        p1.setPerson(new Jin());
        p1.movingCook();

        p1.setPerson(new Nemo());
        p1.movingCook();
    }
}

interface Person11 {
    void cook();
}

class Jin implements Person11 {
    public void cook(){
        System.out.println("Jin is cooking 마라탕.");
    }
}

class Nemo implements Person11 {
    public void cook(){
        System.out.println("Nemo is cooking 간계밥.");
    }
}

class PersonMoving {

    private Person11 person;

    public PersonMoving() { }

    public void setPerson(Person11 person) {
        this.person = person;
    }

    public void movingCook() {
        if (person != null) {
            person.cook();
        } else {
            System.out.println("No person assigned to cook.");
        }
    }
}
