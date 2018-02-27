package principal;

import elements.Velomar;
import elements.Ombrella;
import elements.Hamaca;
import elements.Encarregat;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Platja {

    private String coordenades;
    private String nom;
    private Element[] elements;

    public Platja(String pCoordenades, String pNom) {
        coordenades = pCoordenades;
        nom = pNom;
        elements = new Element[1100];
    }

    /*
     Mètodes accessors.
     */
    public String getCoordenades() {
        return coordenades;
    }

    public void setCoordenades(String pCoordenades) {
        coordenades = pCoordenades;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public Element[] getElements() {
        return elements;
    }

    public void setElement(Element[] pElements) {
        elements = pElements;
    }

    public static Platja novaPlatja() {
        Scanner dades = new Scanner(System.in);
        String coordenadesNoves;
        String nomNou;

        System.out.println("Coordenades de la platja:");
        coordenadesNoves = dades.next();
        dades.nextLine();
        System.out.println("Nom de la platja:");
        nomNou = dades.nextLine();

        return new Platja(coordenadesNoves, nomNou);
    }

    public void modificarPlatja() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nNom de la  platja: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = dades.nextLine();
    }

    public void mostrarPlatja() {
        System.out.println("\nLes dades de la platja amb nom " + nom + " i coordenades " + coordenades + " són:");

        System.out.println("\nElements:");
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                elements[i].mostrarElement();
            }
        }
    }

    /*
     ELEMENTS
     */
    public void afegirElement(int tipus) {
        Scanner dades = new Scanner(System.in);
        int pos;
        boolean trobat = false;
        String id;

        for (int i = 0; i < elements.length && !trobat; i++) {
            if (elements[i] == null) {
                switch (tipus) {
                    case 1:
                        elements[i] = Velomar.nouVelomar();
                        break;
                    case 2:
                        elements[i] = Ombrella.novaOmbrella();
                        break;
                    case 3:
                        elements[i] = Hamaca.novaHamaca();
                        break;
                    case 4:
                        System.out.println("\nIntrodueix el DNI de l'encarregat:");
                        id = dades.next();
                        pos = seleccionarElement(tipus, id);
                        if (pos == -1) {
                            elements[i] = Encarregat.nouEncarregat(id);
                        } else {
                            System.out.println("\nNo s'ha afegit. Ja existeix.");
                        }
                        break;
                    case 5:
                        System.out.println("\nIntrodueix el codi de la zona:");
                        id = dades.next();
                        pos = seleccionarElement(tipus, id);
                        if (pos == -1) {
                            elements[i] = Zona.novaZona(id);
                        } else {
                            System.out.println("\nNo s'ha afegit. Ja existeix.");
                        }
                        break;
                }

                trobat = true;
            }
        }
    }

    public void treureElement(int tipus) {
        int pos = seleccionarElement(tipus, null);

        if (pos != -1) {
            elements[pos] = null;
        } else {
            System.out.println("L'element no és d'aquesta platja.");
        }
    }

    public int seleccionarElement(int tipus, String id) {
        Scanner dades = new Scanner(System.in);
        boolean trobat = false;
        int pos = -1;

        if (id == null) {
            switch (tipus) {
                case 1:
                    System.out.println("\nIntrodueix el codi del velomar:");
                    break;
                case 2:
                    System.out.println("\nIntrodueix el codi de l'ombrel.la:");
                    break;
                case 3:
                    System.out.println("\nIntrodueix el codi de l'hamaca:");
                    break;
                case 4:
                    System.out.println("\nIntrodueix el DNI de l'encarregat:");
                    break;
                case 5:
                    System.out.println("\nIntrodueix el codi de la zona:");
                    break;
                default:
                    System.out.println("\nEl tipus no és correcte.");
                    break;
            }

            id = dades.next();
        }

        for (int i = 0; i < elements.length && !trobat; i++) {
            if (elements[i] instanceof Velomar && tipus == 1) {
                if (((Velomar) elements[i]).getCodi() == Integer.parseInt(id)) {
                    pos = i;
                    trobat = true;
                }
            } else if (elements[i] instanceof Ombrella && tipus == 2) {
                if (((Ombrella) elements[i]).getCodi() == Integer.parseInt(id)) {
                    pos = i;
                    trobat = true;
                }
            } else if (elements[i] instanceof Hamaca && tipus == 3) {
                if (((Hamaca) elements[i]).getCodi() == Integer.parseInt(id)) {
                    pos = i;
                    trobat = true;
                }
            } else if (elements[i] instanceof Encarregat && tipus == 4) {
                if (((Encarregat) elements[i]).getDni().equals(id)) {
                    pos = i;
                    trobat = true;
                }
            } else if (elements[i] instanceof Zona && tipus == 5) {
                if (((Zona) elements[i]).getCodi().equals(id)) {
                    pos = i;
                    trobat = true;
                }
            }
        }
        return pos;
    }
}
