public class Souris extends Animal{

    private String cri;

    public Souris(String name, int age, boolean etat, double poids, String cri){
        super(name, age, etat, poids);
        this.cri = "Crrrr Crrrr";
        System.out.println("Je suis une souris");
    }
    
    public String getCri(){
        return this.cri;
    }

    public String typeAnimal(){
        return "souris";
    }
}