package principal;

import elements.ElementLloguer;
import elements.Encarregat;
import elements.Lloguer;
import elements.Ombrella;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Zona implements Element {

    private String codi;
    private Lloguer lloguers[];
    private static int indexLloguers = 0;
    private ElementLloguer[] elements;
    private Encarregat[] encarregats;

    public Zona(String pCodi) {
        codi = pCodi;
        lloguers = new Lloguer[300];
        elements = new ElementLloguer[28];
        encarregats = new Encarregat[3];
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public Lloguer[] getLloguers() {
        return lloguers;
    }

    public void setLloguers(Lloguer[] pLloguers) {
        lloguers = pLloguers;
    }

    public int getIndexLloguers() {
        return indexLloguers;
    }

    public void setIndexLloguers(int pIndexLloguers) {
        indexLloguers = pIndexLloguers;
    }

    public Encarregat[] getEncarregats() {
        return encarregats;
    }

    public void setEncarregats(Encarregat[] pEncarregats) {
        encarregats = pEncarregats;
    }

    public ElementLloguer[] getElements() {
        return elements;
    }

    public void setElements(ElementLloguer[] pElements) {
        elements = pElements;
    }

    public static Zona novaZona(String pCodi) {
        Scanner dades = new Scanner(System.in);

        if (pCodi == null) {
            System.out.println("Codi de la zona:");
            pCodi = dades.next();
        }

        return new Zona(pCodi);
    }

    public void modificarElement() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nZona amb codi: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = dades.next();
    }

    public void mostrarElement() {
        System.out.println("\nLes dades de la zona amb codi " + codi + " són:");

        System.out.println("\nLloguers:");
        for (int i = 0; i < lloguers.length; i++) {
            if (lloguers[i] != null) {
                lloguers[i].mostrarLloguer();
            }
        }

        System.out.println("\nElements:");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                elements[i].mostrarElement();
            }
        }

    }

    /*
     LLOGUERS
     */
    public void afegirLloguer(Lloguer lloguer) {
        lloguers[indexLloguers] = lloguer;
        indexLloguers++;
    }

    public void tancarLloguer() {
        boolean trobat = false;
        int pos = seleccionarLloguer();

        if (pos != -1) {
            for (int i = 0; i < elements.length && !trobat; i++) {
                if (elements[i] != null && elements[i].getCodi() == lloguers[pos].getCodi()) {

                    elements[i].setLlogat(false);

                    if (elements[i] instanceof Ombrella) {
                        for (int j = 0; j < ((Ombrella) elements[i]).getHamaques().length; j++) {
                            if (((Ombrella) elements[i]).getHamaques()[j] != null) {
                                ((Ombrella) elements[i]).getHamaques()[j].setLlogat(false);
                            }
                        }
                    }
                    trobat = true;
                }
            }
        } else {
            System.out.println("\nEl lloguer no existeix");
        }

    }

    public int seleccionarLloguer() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCodi del lloguer?:");
        int codi = dades.nextInt();

        int pos = -1;

        for (int i = 0; i < indexLloguers; i++) {
            if (lloguers[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

    /*
     ELEMENTS
     */
    public void afegirElementLloguer(ElementLloguer element) {
        boolean trobat = false;

        for (int i = 0; i < elements.length && !trobat; i++) {
            if (elements[i] == null) {
                elements[i] = element;
                trobat = true;
            }
        }

    }

    public void treureElementLloguer(int codi) {
        boolean trobat = false;

        for (int i = 0; i < elements.length && !trobat; i++) {
            if (elements[i] != null && elements[i].getCodi() == codi) {
                elements[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarElementLloguer(int codi) {

        int pos = -1;

        if (codi == -1) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nCodi de l'elemnt de lloguer?:");
            codi = dades.nextInt();
        }

        for (int i = 0; i < elements.length; i++) {

            if (elements[i] != null && elements[i].getCodi() == codi) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }

    /*
     ENCARREGAT
     */
    public void afegirEncarregat(Encarregat encarregat) {
        boolean trobat = false;

        for (int i = 0; i < encarregats.length && !trobat; i++) {
            if (encarregats[i] == null) {
                encarregats[i] = encarregat;
                trobat = true;
            }
        }

    }

    public void treureEncarregat(String dni) {
        boolean trobat = false;

        for (int i = 0; i < encarregats.length && !trobat; i++) {
            if (encarregats[i] != null && encarregats[i].getDni().equals(dni)) {
                encarregats[i] = null;
                trobat = true;
            }
        }

    }

    public int seleccionarEncarregat(String dni) {
        int pos = -1;

        if (dni == null) {
            Scanner dades = new Scanner(System.in);
            System.out.println("\nDni de l'encarregat?:");
            dni = dades.next();
        }

        for (int i = 0; i < encarregats.length; i++) {
            if (encarregats[i] != null && encarregats[i].getDni().equals(dni)) {
                pos = i;
                return pos;
            }
        }

        return pos;
    }

}
