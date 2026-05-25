public class Cow extends Animal{

    public Cow() {
        this.sound = "Muuuuuh!";
        this.name = "Cow";
    }

    @Override
    public String throwSound() {
        return this.name + " muhed: " + this.sound;
    }
}
