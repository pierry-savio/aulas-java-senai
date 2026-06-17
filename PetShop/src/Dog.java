public class Dog extends Animal{

    private final String SOUND = "Auuu auuuu";

    public Dog(String name, int age) { super(name, age); }

    @Override
    public String getSound() {
        return SOUND;
    }
}
