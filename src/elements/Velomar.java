package elements;


import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Velomar extends ElementLloguer{

    private boolean tobogan;

    public Velomar(String pDataAlta, boolean pTobogan) {
        super(pDataAlta);
        tobogan = pTobogan;
    }

    public boolean getTobogan() {
        return tobogan;
    }

    public void setTobogan(boolean pTobogan) {
        tobogan = pTobogan;
    }
    
    public static Velomar nouVelomar() {
        Scanner dades = new Scanner(System.in);
        boolean toboganVelomar = false;
        int opcio;

        System.out.println("Data d'alta del velomar:");
        
        System.out.println("Introdueix el dia");
        String dia = dades.next();

        System.out.println("Introdueix el mes numèric");
        String mes = dades.next();

        System.out.println("Introdueix l'any");
        String any = dades.next();

        do {
            System.out.println("\nTé tobogan? (0 si és no o 1 si és si)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    break;
                case 1:
                    toboganVelomar = true;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);

        return new Velomar(dia+"/"+mes+"/"+any, toboganVelomar);
    }

    public void modificarElement() {
        Scanner dades = new Scanner(System.in);
        int opcio;   
        
        super.modificarElement();

        System.out.println("\nEl velomar ");
        if (tobogan) {
            System.out.print("té tobogan");
        } else {
            System.out.print("no té tobogan");
        }

        do {
            System.out.println("\nAra té tobogan? (0 si és no o 1 si és si)");
            opcio = dades.nextInt();

            switch (opcio) {
                case 0:
                    tobogan = false;
                    break;
                case 1:
                    tobogan = true;
                    break;
                default:
                    System.out.println("\nEl valor introduit no és correcte");
                    break;
            }
        } while (opcio != 0 && opcio != 1);
    }

    public void mostrarElement() {
    
        super.mostrarElement();
        
        System.out.println("\nEl velomar ");
        if (tobogan) {
            System.out.print("té tobogan");
        } else {
            System.out.print("no té tobogan");
        }

    }
    
}
