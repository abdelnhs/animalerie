public class Chat extends Animal{

    private String cri;
    
    public Chat(String name, int age, boolean etat, double poids, String cri) {
        super(name, age, etat, poids);
        this.cri = "Miaouuu";
        System.out.println("Je suis un chat");
    }
    
    public String getCri(){
        return this.cri;
    }

    public String typeAnimal(){
        return "chat";
    }
}
