package elements;

import principal.Platja;
import java.time.LocalTime;
import java.util.Scanner;
import principal.Zona;

/**
 *
 * @author fta
 */
public class Lloguer {

    private static final double VALOR = 8.0;
    private int codi;
    private static int properCodi = 0;
    private String codiZona;
    private String dniEncarregat;
    private ElementLloguer element;
    private String dniClient;
    private LocalTime horaLloguer;
    private LocalTime tempsLloguer;
    private double totalPagar;
    private boolean pagat;

    public Lloguer(String pCodiZona, String pDniEncarregat, ElementLloguer pElement, String pDniClient, LocalTime pTempsLloguer, double pTotalPagar, boolean pPagat) {
        codi = properCodi;
        properCodi++;
        codiZona = pCodiZona;
        dniEncarregat = pDniEncarregat;
        element = pElement;
        dniClient = pDniClient;
        horaLloguer = LocalTime.now();
        tempsLloguer = pTempsLloguer;
        totalPagar = pTotalPagar;
        pagat = pPagat;
    }
    
    //Mètode constructor per crear els objectes a partir de les dades del document XML
    public Lloguer(int pCodi, String pCodiZona, String pDniEncarregat, ElementLloguer pElement, String pDniClient, LocalTime pTempsLloguer, double pTotalPagar, boolean pPagat) {
        codi = pCodi;
        codiZona = pCodiZona;
        dniEncarregat = pDniEncarregat;
        element = pElement;
        dniClient = pDniClient;
        horaLloguer = LocalTime.now();
        tempsLloguer = pTempsLloguer;
        totalPagar = pTotalPagar;
        pagat = pPagat;
    }
    

    /*
     Mètodes accessors. 
     */
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

    public String getCodiZona() {
        return codiZona;
    }

    public void setCodiZona(String pCodiZona) {
        codiZona = pCodiZona;
    }

    public String getDniEncarregat() {
        return dniEncarregat;
    }

    public void setDniEncarregat(String pDniEncarregat) {
        dniEncarregat = pDniEncarregat;
    }

    public ElementLloguer getElement() {
        return element;
    }

    public void setElement(ElementLloguer pElement) {
        element = pElement;
    }

    public String getDniClient() {
        return dniClient;
    }

    public void setDniClient(String pDniClient) {
        dniClient = pDniClient;
    }

    public LocalTime getHoraLloguer() {
        return horaLloguer;
    }

    public void setHoraLloguer(LocalTime pHoraLloguer) {
        horaLloguer = pHoraLloguer;
    }

    public LocalTime getTempsLloguer() {
        return tempsLloguer;
    }

    public void setTempsLloguer(LocalTime pTempsLloguer) {
        tempsLloguer = pTempsLloguer;
    }

    public double getTotalPagar() {
        return totalPagar;
    }

    public void setTotalPagar(double pTotalPagar) {
        totalPagar = pTotalPagar;
    }

    public boolean getPagat() {
        return pagat;
    }

    public void setPagat(boolean pPagat) {
        pagat = pPagat;
    }

    public static Lloguer nouLloguer(Platja platja, Zona zona) {
        Scanner dades = new Scanner(System.in);
        String dniEncarregatNou = null;
        ElementLloguer elementNou;
        String dniClientNou;
        LocalTime tempsLloguerNou;
        double totalPagarNou;
        boolean estatPagat = false;
        int posEncarregat;
        int hores, minuts;

        do {
            posEncarregat = zona.seleccionarEncarregat(null);
            if (posEncarregat == -1) {
                System.out.println("\nL'encarregat no existeix.");
            } else {
                dniEncarregatNou = zona.getEncarregats()[posEncarregat].getDni();
            }
        } while (posEncarregat == -1);

        elementNou = seleccionarElementLloguer(platja, zona);

        System.out.println("\nDNI del client:");
        dniClientNou = dades.next();

        System.out.println("\nHores del lloguer:");
        hores = dades.nextInt();
        System.out.println("\nNecessites mitja hora?: (1 si és si, 0 si és no)");
        minuts = 0;
        if (dades.nextInt() == 1) {
            minuts = 30;
        }
        tempsLloguerNou = LocalTime.of(hores, minuts);

        totalPagarNou = hores * VALOR + minuts * (VALOR / 2);

        System.out.println("\nEstà pagat? (1 si és si, 0 si és no)");
        if (dades.nextInt() == 1) {
            estatPagat = true;
        }

        return new Lloguer(zona.getCodi(), dniEncarregatNou, elementNou, dniClientNou, tempsLloguerNou, totalPagarNou, estatPagat);
    }

    public static ElementLloguer seleccionarElementLloguer(Platja platja, Zona zona) {
        Scanner dades = new Scanner(System.in);
        int pos;
        ElementLloguer elementSeleccionat = null;
        int tipus = 0;

        do {
            System.out.println("Selecciona un element:");
            System.out.println("1. Velomar.");
            System.out.println("2. Ombrel.la.");
            tipus = dades.nextInt();
            if (tipus != 1 && tipus != 2) {
                System.out.println("Selecciona una opció correcte");
            }
        } while (tipus != 1 && tipus != 2);

        pos = zona.seleccionarElementLloguer(-1);

        if (pos == -1) {
            System.out.println("\nL'element de lloguer no existeix.");
        } else {
            zona.getElements()[pos].setLlogat(true);
            elementSeleccionat = zona.getElements()[pos];
        }

        if (tipus == 2) {
            int hamaques = 0;
            do {
                System.out.println("Quantes hamaques vols?");
                hamaques = dades.nextInt();
                if (hamaques < 0 && hamaques > 4) {
                    System.out.println("Selecciona una opció correcte");
                }
            } while (hamaques < 0 && hamaques > 4);

            for (int i = 0; i < hamaques; i++) {
                do {
                    pos = platja.seleccionarElement(3, null);
                    if (pos == -1) {
                        System.out.println("\nL'hamaca no existeix.");
                    } else {
                        ((Ombrella) zona.getElements()[pos]).afegirHamaca((Hamaca) platja.getElements()[pos]);
                    }
                } while (pos == -1);
            }

        }
        return elementSeleccionat;
    }

    public void mostrarLloguer() {
        System.out.println("\nLes dades del lloguer amb codi " + codi + " són:");
        System.out.println("\nEncarregat: " + dniEncarregat);
        System.out.println("\nElement lloguer: ");
        element.mostrarElement();
        System.out.println("\nClient: " + dniClient);
        System.out.println("\nHora lloguer: " + horaLloguer.getHour() + ":" + horaLloguer.getMinute() + ":" + horaLloguer.getSecond());
        System.out.println("\nTemps lloguer: " + tempsLloguer.getHour() + ":" + tempsLloguer.getMinute());
        System.out.println("\nTotal pagar: " + totalPagar);
        if (pagat) {
            System.out.println("\nPagat");
        } else {
            System.out.println("\nPendent de pagar");
        }
    }
}
