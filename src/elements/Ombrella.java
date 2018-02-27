package elements;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Ombrella extends ElementLloguer {

    private Hamaca[] hamaques;

    public Ombrella(String pDataAlta) {
        super(pDataAlta);
        hamaques = new Hamaca[4];

    }

    public Hamaca[] getHamaques() {
        return hamaques;
    }

    public void setHamaques(Hamaca[] pHamaques) {
        hamaques = pHamaques;
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
        for (int i = 0; i < hamaques.length; i++) {
            if (hamaques[i] != null) {
                hamaques[i].mostrarElement();
            }
        }
    }

    public void afegirHamaca(Hamaca hamaca) {
        boolean trobat = false;
        //Afegim l'hamaca en el primer espai buit del vector
        for (int i = 0; i < hamaques.length && !trobat; i++) {
            if (hamaques[i] == null) { //Espai buit
                hamaques[i] = hamaca;
                hamaques[i].setLlogat(true);
                trobat = true;
            }
        }
    }

    public void treureHamaca(Hamaca hamaca) {
        boolean trobat = false;

        //Treiem l'hamaca
        for (int i = 0; i < hamaques.length && !trobat; i++) {
            if (hamaques[i] !=null && hamaques[i].equals(hamaca)) { //Trobat
                hamaques[i] = null;
                hamaques[i].setLlogat(false);
                trobat = true;
            }
        }

        if (!trobat) {
            System.out.println("L'hamaca no està en el llistat");
        }

    }

}
