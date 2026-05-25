public abstract class Animal {

    protected String name;
    protected String sound;

    public Animal(){}

    public String getName() {
        return this.sound;
    }

    public String getSound() {
        return this.sound;
    }

    public abstract String throwSound();

    @Override
    public String toString(){
        return name + ": ";
    }
}
