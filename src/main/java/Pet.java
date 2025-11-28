public class Pet {

    private final static int id = 0;
    private final String name;
    private int age;

    public Pet(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void makeSound () {
        System.out.println("Grrrrr");
    }

}
