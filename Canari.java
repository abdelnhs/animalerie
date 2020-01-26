public class Canari extends Animal{

    private String cri;

    public Canari(String name, int age, boolean etat, double poids, String cri){
        super(name, age, etat, poids);
        this.cri = "Piou Pioou";
        System.out.println("Je suis un canari");
    }
    
    public String getCri(){
        return this.cri;
    }

    public String typeAnimal(){
        return "canari";
    }
}