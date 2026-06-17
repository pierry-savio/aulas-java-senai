public class Cat extends Animal{

    private final String SOUND = "Miau miauuuu";

    public Cat(String name, int age){
        super(name, age);
    }

    @Override
    public String getSound(){
        return SOUND;
    }
}
