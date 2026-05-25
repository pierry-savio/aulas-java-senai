public class Dog extends Animal{

    public Dog() {
        this.sound = "Au au";
        this.name = "Dog";
    }

    @Override
    public String throwSound() {
        return this.name + " barked: " + this.sound;
    }
}
