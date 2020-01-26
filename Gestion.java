import java.io.*;
import java.util.ArrayList;


public class Gestion{
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
                afficheInfosIndividu(stock);
            }
            else if(saisie == 4){
                changePoids(stock);
            }
            else if(saisie == 5){
                saisirMort(stock);
            }
            else if(saisie == 6){
                agingAnimal(stock);
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
        System.out.println("2: Afficher les informations de tous les animaux");
        System.out.println("3: Afficher les informations d'un individu");
        System.out.println("4: Changer poids");
        System.out.println("5: Saisir une mort d'un animal");
        System.out.println("6: Saisir le vieillissement d'un ou tous les animaux");
        System.out.println("0: Quitter");
        System.out.println("");
    }

    public static ArrayList<Animal> saisieInfos(ArrayList<Animal> list){
        System.out.println("Nombre de saisie à effectuer : ");
        int nbrSaisie = saisie_entier();
        for(int i = 0; i < nbrSaisie; i++){
            System.out.println("Type d'animal à enregistrer ?");
            System.out.println("Chat, souris ou canari ? : ");
            String type = saisie_chaine();
            if(type.equals("Chat") || type.equals("chat")){
                saisieInfosChat(list);
            }
            else if(type.equals("Souris") || type.equals("souris")){
                saisieInfosSouris(list);
            }
            else if(type.equals("Canari") || type.equals("canari")){
                saisieInfosCanari(list);
            }
            System.out.println("");
        }
        return list;
    }


    public static ArrayList<Animal> saisieInfosChat(ArrayList<Animal> list){
        System.out.println("Saisir le nom : ");
        String nom = saisie_chaine();
        System.out.println("Saisir l'age : ");
        int age = saisie_entier();
        System.out.println("Saisir le poids : ");
        double poids = saisie_float();
        boolean etat = true;
        String cri = "Miaouuu";
        Chat a = new Chat(nom, age, etat, poids, cri);
        list.add(a);
        return list;
    }

    public static ArrayList<Animal> saisieInfosSouris(ArrayList<Animal> list){
        System.out.println("Saisir le nom : ");
        String nom = saisie_chaine();
        System.out.println("Saisir l'age : ");
        int age = saisie_entier();
        System.out.println("Saisir le poids : ");
        double poids = saisie_float();
        boolean etat = true;
        String cri = "Crrrr Crrrr";
        Souris a = new Souris(nom, age, etat, poids, cri);
        list.add(a);
        return list;
    }

    public static ArrayList<Animal> saisieInfosCanari(ArrayList<Animal> list){
        System.out.println("Saisir le nom : ");
        String nom = saisie_chaine();
        System.out.println("Saisir l'age : ");
        int age = saisie_entier();
        System.out.println("Saisir le poids : ");
        double poids = saisie_float();
        boolean etat = true;
        String cri = "Piouu Piouu";
        Canari a = new Canari(nom, age, etat, poids, cri);
        list.add(a);
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
                double new_poids = saisie_float();
                list.get(i).changePoids(new_poids);
                }
            }
        }
        return list;
    }


    public static void afficheInfos(ArrayList<Animal> list){
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).getEtat()){
                System.out.println("L'animal nommé " + list.get(i).seeName() + " est vivant, a " + list.get(i).getAge() + " ans et pèse " + list.get(i).getPoids() + " kg. Pour rappel, il s'agit d'un animal de type " + list.get(i).typeAnimal());
            }
            else{
                System.out.println("L'animal nommé " + list.get(i).seeName() + " est mort, il avait " + list.get(i).getAge() + " ans et pesait " + list.get(i).getPoids() + " kg. Pour rappel, c'était un animal de type " + list.get(i).typeAnimal());
            }
        }
    }

    public static void afficheInfosIndividu(ArrayList<Animal> list){
        System.out.println("Quel animal consulter ?");
        String nom = saisie_chaine();
        for(int i = 0; i < list.size(); i++){
            if(nom.equals(list.get(i).seeName()) && a == list.get(i).getEtat()){
                System.out.println("Informations concernant l'animal");
                System.out.println("");
                System.out.println("Nom : " + list.get(i).seeName());
                System.out.println("Age : " + list.get(i).getAge() + " ans");
                System.out.println("Poids : " + list.get(i).getPoids() + " kg");
                System.out.println("Etat : " + list.get(i).getEtat());
                System.out.println("Espèce : " + list.get(i).typeAnimal());
                System.out.println("Cri : " + list.get(i).getCri());
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


    public static ArrayList<Animal> agingAnimal(ArrayList<Animal> list){
        System.out.println("Combien d'animal voulez-vous vieillir ?");
        System.out.println("Pour rappel, il y'a " + list.size() + " animal/animaux dans l'animalerie.");
        int nombre = saisie_entier();
        if(nombre == 0){
            System.out.println("Aucun changement réalisé");
        }
        else if(nombre > list.size()){
            System.out.println("Impossible, il n'y a pas autant d'animal !");
        }
        else if(nombre == list.size()){
            for(int i = 0; i < list.size(); i++){
                list.get(i).vieillir();;
            }
        }
        else{
            for(int i = 0; i < nombre; i++){
                System.out.println("Quel animal voulez-vous vieillir d'un an ? ");
                String name = saisie_chaine();
                for(int j = 0; j < list.size(); j++){
                    if(name.equals(list.get(j).seeName())){
                        list.get(j).vieillir();;
                    }
                }
            }
        }
        return list;
    }




    // SAISIE ENTIER ET SAISIE CHAINE
    public static int saisie_entier(){
        try{
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
            String chaine = buff.readLine();
            int num = Integer.parseInt(chaine);
            return num;
        }
        catch(IOException e){return 0;}
   }

   public static double saisie_float(){
    try{
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        String chaine = buff.readLine();
        double num = Double.parseDouble(chaine);
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