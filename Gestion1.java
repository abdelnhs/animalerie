import java.io.*;
import java.util.ArrayList;


public class Gestion1{
    public static void main(String[] args) {
        ArrayList<Animal> stock = new ArrayList<Animal>();
        while(true){
            menu();
            int saisie = saisie_entier();
            if(saisie == 1){   
                saisieInfos(stock);
            }
            else if(saisie == 2){
                afficheInfos(stock);
            }
            else if(saisie == 3){
                changePoids(stock);
            }
            else if(saisie == 4){
                saisirMort(stock);
            }
            else{
                System.exit(0);
            }
        }
    }

    public static void menu(){
        System.out.println("");
        System.out.println("Menu \n");
        System.out.println("1: Saisir/Ajouter des animaux");
        System.out.println("2: Afficher les informations");
        System.out.println("3: Changer poids");
        System.out.println("4: Saisir une mort d'un animal");
        System.out.println("0: Quitter");
        System.out.println("");
    }

    public static ArrayList<Animal> saisieInfos(ArrayList<Animal> list){
        System.out.println("Nombre de saisie à effectuer : ");
        int nbrSaisie = saisie_entier();
        for(int i = 0; i < nbrSaisie; i++){
            System.out.println("Saisir le nom : ");
            String nom = saisie_chaine();
            System.out.println("Saisir l'age : ");
            int age = saisie_entier();
            System.out.println("Saisir le poids : ");
            double poids = saisie_entier();
            boolean etat = true;
            Animal a = new Animal(nom, age, etat, poids);
            System.out.println("");
            list.add(a);
        }
        return list;
    }

    public static ArrayList<Animal> changePoids(ArrayList<Animal> list){
        System.out.println("Saisir le nom de l'animal : ");
        String animalName = saisie_chaine();
        for(int i = 0; i < list.size(); i++){
            if(animalName.equals(list.get(i).seeName())){
                if(list.get(i).getEtat() == false){
                    System.out.println("Impossible, l'animal est mort");
                }
                else{
                System.out.println("Saisir le nouveau poids : ");
                double new_poids = saisie_entier();
                list.get(i).changePoids(new_poids);
                }
            }
        }
        return list;
    }


    public static void afficheInfos(ArrayList<Animal> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEtat()){
                System.out.println("L'animal nommé " + list.get(i).seeName() + " est vivant, a " + list.get(i).getAge() + " ans et pèse " + list.get(i).getPoids() + " kg.");
            }
            else{
                System.out.println("L'animal nommé " + list.get(i).seeName() + " est mort, il avait " + list.get(i).getAge() + " ans et pesait " + list.get(i).getPoids() + " kg.");
            }
        }
    }


    public static ArrayList<Animal> saisirMort(ArrayList<Animal> list){
        System.out.println("Saisir le nom de l'animal mort: ");
        String animalName = saisie_chaine();
        for(int i = 0; i < list.size(); i++){
            if(animalName.equals(list.get(i).seeName())){
                if(list.get(i).getEtat() == false){
                    System.out.println("Impossible, l'animal est déjà mort");
                }
                else{
                list.get(i).killAnimal();
                System.out.println("Changement d'état réalisé");
                }
            }
        }
        return list;
    }


    public static int saisie_entier(){
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        }
        catch(IOException e){return 0;}
   }

   public static String saisie_chaine(){
       try {
           BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
           String chaine = buff.readLine();
           return chaine;
       }
       catch(IOException e){
           System.out.println("impossible de travailler " + e);
           return null;
       }
   }

}