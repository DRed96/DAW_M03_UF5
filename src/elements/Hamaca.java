package elements;

import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Hamaca extends ElementLloguer {

    public Hamaca(String pDataAlta) {
        super(pDataAlta);
    }

    public static Hamaca novaHamaca() {
        Scanner dades = new Scanner(System.in);

        System.out.println("Data d'alta de l'hamaca:");

        System.out.println("Introdueix el dia");
        String dia = dades.next();

        System.out.println("Introdueix el mes numèric");
        String mes = dades.next();

        System.out.println("Introdueix l'any");
        String any = dades.next();

        return new Hamaca(dia+"/"+mes+"/"+any);
    }

}
