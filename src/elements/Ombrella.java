package elements;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Ombrella extends ElementLloguer {

    private ArrayList<Hamaca> hamaques;

    public Ombrella(String pDataAlta) {
        super(pDataAlta);
        hamaques = new ArrayList<>(4);
    }
    
    public ArrayList<Hamaca> getHamaques() {
        return hamaques;
    }
    
    public static Ombrella novaOmbrella() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Data d'alta de l'ombrel.la:");
        
        System.out.println("Introdueix el dia");
        String dia = dades.next();

        System.out.println("Introdueix el mes numèric");
        String mes = dades.next();

        System.out.println("Introdueix l'any");
        String any = dades.next();

        return new Ombrella(dia+"/"+mes+"/"+any);
    }

    public void mostrarElement() {
        super.mostrarElement();
        for(Hamaca hamaca:hamaques){
            hamaca.mostrarElement();
        }
    }

    public void afegirHamaca(Hamaca afegir) { 
        
//        boolean trobat = false;
//        //Afegim l'hamaca en el primer espai buit del vector
//        for (int i = 0; i < hamaques.length && !trobat; i++) {
//            if (hamaques[i] == null) { //Espai buit
//                hamaques[i] = hamaca;
//                hamaques[i].setLlogat(true);
//                trobat = true;
//            }
//        }

        if(hamaques.size()<4){
           if(hamaques.contains(afegir)==false){
                afegir.setLlogat(true);
                hamaques.add(afegir);
            } 
        }
    }

    public void treureHamaca(Hamaca treure) {
//        boolean trobat = false;
//        //Treiem l'hamaca
//        for (int i = 0; i < hamaques.length && !trobat; i++) {
//            if (hamaques[i] !=null && hamaques[i].equals(hamaca)) { //Trobat
//                hamaques[i] = null;
//                hamaques[i].setLlogat(false);
//                trobat = true;
//            }
//        }
//        if (!trobat) {
//            System.out.println("L'hamaca no està en el llistat");
//        }
        
        if(hamaques.contains(treure)==true){
            treure.setLlogat(false);
            hamaques.remove(treure);
        } 
    }  
}
