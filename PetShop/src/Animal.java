import util.AnimalTranslator;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public abstract String getSound();

    @Override
    public String toString(){
        String type = AnimalTranslator.translate(getClass().getSimpleName(), "pt-br");
        String name = getName();
        int age  = getAge();
        String sound = getSound();
        return type + " - Nome: " + name + " | Idade: " + age + " anos | Som: " + getSound();
    }
}
