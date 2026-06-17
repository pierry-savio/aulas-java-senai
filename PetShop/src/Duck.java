public class Duck extends Animal{

    private final String SOUND = "Quaaa quaaa";

    public Duck (String name, int age){ super(name, age); }

    @Override
    public String getSound(){
        return SOUND;
    }
}
