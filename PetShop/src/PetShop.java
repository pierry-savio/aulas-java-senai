import java.util.ArrayList;

public class PetShop {
    private ArrayList<Animal> animals = new ArrayList<>();

    public PetShop(){}

    public PetShop(ArrayList<Animal> animals){
        this.animals = animals;
    }

    public void addAnimal(Animal animal){
        this.animals.add(animal);
    }

    public void removeAnimal(int index){
        this.animals.remove(index);
    }

    @Override
    public String toString(){
        String result = "";
        for (int i = 0; i<animals.size(); i++){
            String type = animals.get(i).getClass().getSimpleName();
            String name = animals.get(i).getName();
            int age  = animals.get(i).getAge();
            String sound = animals.get(i).getSound();
            result += (i+1) + " - " + animals.get(i) + "\n";
        }
        return result;
    }
}
