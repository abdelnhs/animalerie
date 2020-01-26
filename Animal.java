public class Animal{

    // Initialisation des attributs de l'animal
    private String name;
    private int age;
    private boolean etat;
    private double poids;

    public Animal(){
        this.name = "unknown";
        this.age = 0;
        this.etat = true;
        this.poids = 0;
    }

    // Constructeur
    public Animal(String name, int age, boolean etat, double poids){
        this.name = name;
        this.age = age;
        this.etat = true;
        this.poids = poids;
    }

    // Methodes
    public void killAnimal(){
        this.etat = !this.etat;
    }

    public void changePoids(double new_poids){
        this.poids = new_poids;
    }

    public void changeAge(int new_age){
        this.age = new_age;
    }

    public void changeName(String new_name){
        this.name = new_name;
    }

    public String seeName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public double getPoids(){
        return this.poids;
    }

    public boolean getEtat(){
        if(this.etat == true){
            return true;
        }
        else{
            return false;
        }
    }

    public void afficheType{}
}