package by.tms.lesson37_springcore.configuration_javacode_v2;

import org.springframework.beans.factory.annotation.Value;

//@Component("personBean")
public class Person {
//  @Autowired
//  @Qualifier("catBean")
    private Pet pet;
    @Value("${person.surname}")
    private String surname;
    @Value("${person.age}")
    private int age;

    public Person() {
        System.out.println("Pearson bean is created");
    }
//  @Autowired
    public Person(Pet pet) {
        System.out.println("Pearson bean is created");
        this.pet = pet;
    }

//  @Autowired
//  @Qualifier("dog")
//  public void anyMethodNameNotOnlySetPet(Pet pet)
    public void setPet(Pet pet) {
        System.out.println("Class Person: set pet");
        this.pet = pet;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        System.out.println("Class Person: set surname");
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("Class Person: set age");
        this.age = age;
    }

    public Pet getPet() {
        return pet;
    }

    public void callYourPet() {
        System.out.println("Hello, my lovely Pet!");
        pet.say();
    }

    @Override
    public String toString() {
        return "Person{" +
                "pet=" + pet +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
