public abstract class Vehicle {
    protected Model model;
    protected String horn;
    protected final Double maxPeed;
    protected Type type;

    public Vehicle(Model model, String horn, Double maxPeed){
        this.model = model;
        this.horn = horn;
        this.maxPeed = maxPeed;
    }

    public Model getType() {
        return model;
    }

    public String getHorn() {
        return horn;
    }

    public Double getMaxPeed() {
        return maxPeed;
    }

    public void setType(Model model) {
        this.model = model;
    }

    public void setHorn(String horn) {
        this.horn = horn;
    }

    @Override
    public String toString(){
        return type.toString() + " " + model + " - Max Speed: " + maxPeed;
    }
}
