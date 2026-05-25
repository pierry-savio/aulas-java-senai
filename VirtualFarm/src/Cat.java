public class Cat extends Animal{

    public Cat() {
        this.sound = "Meooow!";
        this.name = "Cat";
    }

    @Override
    public String throwSound() {
        return this.name + " meowed: " + this.sound;
    }
}
