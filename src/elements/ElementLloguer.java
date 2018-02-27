package elements;

import java.util.Scanner;
import principal.Element;

/**
 *
 * @author fta
 */
public abstract class ElementLloguer implements Element {
    private int codi;
    private static int properCodi = 0;
    private String dataAlta;
    private boolean llogat;
    
    public ElementLloguer(String pDataAlta) {
        codi = properCodi;
        properCodi++;
        dataAlta = pDataAlta;
        llogat = false;
    }

    //Mètode constructor per crear els objectes a partir de les dades del document XML
    public ElementLloguer(int pCodi, String pDataAlta, boolean pLlogat) {
        codi=pCodi;
        dataAlta = pDataAlta;
        llogat = pLlogat;
    }
    
    public int getCodi() {
        return codi;
    }

    public void setCodi() {
        codi++;
    }

    public static int getProperCodi() {
        return properCodi;
    }

    public static void setProperCodi() {
        properCodi++;
    }

    public String getDataAlta() {
        return dataAlta;
    }

    public void setDataAlta(String pDataAlta) {
        dataAlta = pDataAlta;
    }

    public boolean getLLogat() {
        return llogat;
    }

    public void setLlogat(boolean pLlogat) {
        llogat = pLlogat;
    }


    public void modificarElement() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nData d'alta de l'element: " + dataAlta);
        
        System.out.println("Introdueix el dia");
        String dia = dades.next();

        System.out.println("Introdueix el mes numèric");
        String mes = dades.next();

        System.out.println("Introdueix l'any");
        String any = dades.next();
        
        dataAlta = dia+"/"+mes+"/"+any;
        
        modificarEstatLloguer();
    }

    public void mostrarElement() {
        System.out.println("\nLes dades de l'element amb codi " + codi + " són:");
        System.out.println("\nData d'alta:" + dataAlta);
        System.out.println("\nEstat de lloguer:");
        if (llogat) {
            System.out.print("Llogat");
        } else {
            System.out.print("No llogat");
        }
    }

    public void modificarEstatLloguer() {
        Scanner dades = new Scanner(System.in);
        int opcio;

        System.out.println("\nL'estat actual de lloguer és: ");
        if (llogat) {
            System.out.print("Llogada");
        } else {
            System.out.print("No llogada");
        }

        do {
            System.out.println("\nEntra el nou estat de lloguer: (0 si no està llogada o 1 si està llogada)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    llogat = false;
                    break;
                case 1:
                    llogat = true;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);
    }
}
