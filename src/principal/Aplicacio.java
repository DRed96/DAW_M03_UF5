package principal;

import elements.Encarregat;
import elements.Lloguer;
import elements.Ombrella;
import elements.Velomar;
import elements.Hamaca;
import java.util.Scanner;
import persistencia.GestorPersistencia;

/**
 *
 * @author fta
 */
public class Aplicacio {

    static final String FITXER="platja.xml";
    private static Platja[] platges = new Platja[4];//Platges d'illa Tortuga
    private static int indexPlatges = 0; //La propera posició buida del vector platges
    private static Platja platjaActual = null; //PlatjaSeleccionada
    private static int tipusElement = 0;
    static private GestorPersistencia gp = new GestorPersistencia();
    

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Gestió de platges");
            System.out.println("\n2. Gestió de zones");
            System.out.println("\n3. Gestió de velomars");
            System.out.println("\n4. Gestió d'ombrel.les");
            System.out.println("\n5. Gestió d'hamaques");
            System.out.println("\n6. Gestió d'encarregats");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    menuPlatges();
                    break;
                case 2:
                    if (platjaActual != null) {
                        menuZones();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 3:
                    if (platjaActual != null) {
                        tipusElement = 1;
                        menuElements();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 4:
                    if (platjaActual != null) {
                        tipusElement = 2;
                        menuElements();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 5:
                    if (platjaActual != null) {
                        tipusElement = 3;
                        menuElements();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                case 6:
                    if (platjaActual != null) {
                        tipusElement = 4;
                        menuElements();
                    } else {
                        System.out.println("\nPrimer s'ha de seleccionar la platja del menú de platges");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuPlatges() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);
        do {
            int pos = -1;
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Seleccionar");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. LListar platges");
            System.out.println("\n5. Carregar platja");
            System.out.println("\n6. Desar platja");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platges[indexPlatges] = Platja.novaPlatja();
                    indexPlatges++;
                    break;
                case 2:
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        platjaActual = platges[pos];
                    } else {
                        System.out.println("\nNo existeix aquesta platja");
                    }
                    break;
                case 3:
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        platges[pos].modificarPlatja();
                    } else {
                        System.out.println("\nNo existeix aquesta platja");
                    }
                    break;
                case 4:
                    for (int i = 0; i < indexPlatges; i++) {
                        platges[i].mostrarPlatja();
                    }
                    break;
                case 5: //Carregar Platja
                    indexPlatges = 0;
                    platges = new Platja[1];
                    platges[indexPlatges] = gp.carregarPlatja("XML", FITXER);
                    indexPlatges++;
                    break;
                case 6: //Desar Platja
                    pos = seleccionarPlatja();
                    if (pos >= 0) {
                        gp.desarPlatja("XML", FITXER, platges[pos]);
                    } else {
                        System.out.println("\nNo existeix aquest restaurant");
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuZones() {
        int opcio = 0;
        int posZona, posElement, posElementZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Modificar");
            System.out.println("\n3. Afegir encarregat");
            System.out.println("\n4. Afegir element lloguer");
            System.out.println("\n5. Treure encarregat");
            System.out.println("\n6. Treure element lloguer");
            System.out.println("\n7. Gestionar lloguers");
            System.out.println("\n8. Llistar zones");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirElement(5);
                    break;
                case 2:
                    System.out.println("\nIntrodueix el codi de la zona que vols modificar");
                    String codi = dades.next();
                    boolean trobat = false;
                    posZona = platjaActual.seleccionarElement(5, codi);
                    if (posZona != -1) {
                        ((Zona) platjaActual.getElements()[posZona]).modificarElement();
                        for (int i = 0; i < platjaActual.getElements().length && !trobat; i++) {
                            if (platjaActual.getElements()[i] instanceof Zona && i != posZona && ((Zona) platjaActual.getElements()[i]).getCodi().equals(codi)) {
                                ((Zona) platjaActual.getElements()[posZona]).setCodi(codi);
                                System.out.println("\nEl codi no s'ha pogut modificar perquè ja existeix una zona amb aquest codi");
                                trobat = true;
                            }
                        }
                    } else {
                        System.out.println("\nL'element no existeix.");
                    }
                    break;
                case 3:
                    posZona = platjaActual.seleccionarElement(5, null);
                    posElement = platjaActual.seleccionarElement(4, null);
                    if (posZona >= 0 && posElement >= 0) {
                        posElementZona = ((Zona) platjaActual.getElements()[posZona]).seleccionarEncarregat(((Encarregat) platjaActual.getElements()[posElement]).getDni());
                        if (posElementZona == -1) {
                            ((Zona) platjaActual.getElements()[posZona]).afegirEncarregat(((Encarregat) platjaActual.getElements()[posElement]));
                        } else {
                            System.out.println("\nL'encarregat ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix l'encarregat.");
                    }
                    break;
                case 4:
                    do {
                        System.out.println("\nSelecciona un element:");
                        System.out.println("\n1. Velomar.");
                        System.out.println("\n2. Ombrel.la.");
                        opcio = dades.nextInt();
                        if (opcio != 1 && opcio != 2) {
                            System.out.println("\nSelecciona una opció correcte");
                        }
                    } while (opcio != 1 && opcio != 2);

                    posZona = platjaActual.seleccionarElement(5, null);
                    posElement = platjaActual.seleccionarElement(opcio, null);

                    if (posZona >= 0 && posElement >= 0) {
                        if (opcio == 1) {
                            posElementZona = ((Zona) platjaActual.getElements()[posZona]).seleccionarElementLloguer(((Velomar) platjaActual.getElements()[posElement]).getCodi());
                        } else {
                            posElementZona = ((Zona) platjaActual.getElements()[posZona]).seleccionarElementLloguer(((Ombrella) platjaActual.getElements()[posElement]).getCodi());
                        }

                        if (posElementZona == -1) {
                            if (opcio == 1) {
                                ((Zona) platjaActual.getElements()[posZona]).afegirElementLloguer((Velomar) platjaActual.getElements()[posElement]);
                            } else {
                                ((Zona) platjaActual.getElements()[posZona]).afegirElementLloguer((Ombrella) platjaActual.getElements()[posElement]);
                            }
                        } else {
                            System.out.println("\nL'elemnt ja està afegit a la zona.");
                        }
                    } else if (posZona == -1) {
                        System.out.println("\nNo existeix la zona.");
                    } else if (posElement == -1) {
                        System.out.println("\nNo existeix l'element.");
                    }

                    break;
                case 5:
                    posZona = platjaActual.seleccionarElement(5, null);
                    if (posZona >= 0) {
                        posElementZona = ((Zona) platjaActual.getElements()[posZona]).seleccionarEncarregat(null);
                        if (posElementZona >= 0) {
                            ((Zona) platjaActual.getElements()[posZona]).treureEncarregat(((Zona) platjaActual.getElements()[posZona]).getEncarregats()[posElementZona].getDni());
                        } else {
                            System.out.println("\nL'encarregat no està assignat a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 6:

                    do {
                        System.out.println("\nSelecciona un element:");
                        System.out.println("\n1. Velomar.");
                        System.out.println("\n2. Ombrel.la.");
                        opcio = dades.nextInt();
                        if (opcio != 1 && opcio != 2) {
                            System.out.println("\nSelecciona una opció correcte");
                        }
                    } while (opcio != 1 && opcio != 2);

                    posZona = platjaActual.seleccionarElement(5, null);
                    if (posZona >= 0) {
                        posElementZona = ((Zona) platjaActual.getElements()[posZona]).seleccionarElementLloguer(-1);
                        if (posElementZona >= 0) {
                            ((Zona) platjaActual.getElements()[posZona]).treureElementLloguer(((Zona) platjaActual.getElements()[posZona]).getElements()[posElementZona].getCodi());
                        } else {
                            System.out.println("\nL'element no està assignat a la zona.");
                        }
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }

                    break;
                case 7:
                    menuLloguers();
                    break;
                case 8:
                    for (int i = 0; i < platjaActual.getElements().length; i++) {
                        if (platjaActual.getElements()[i] instanceof Zona) {
                            platjaActual.getElements()[i].mostrarElement();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuLloguers() {
        int opcio = 0;
        int posZona;
        Scanner dades = new Scanner(System.in);
        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Crear");
            System.out.println("\n2. Tancar");
            System.out.println("\n3. Llistar lloguers");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    posZona = platjaActual.seleccionarElement(5, null);
                    if (posZona >= 0) {
                        ((Zona) platjaActual.getElements()[posZona]).afegirLloguer(Lloguer.nouLloguer(platjaActual, ((Zona) platjaActual.getElements()[posZona])));
                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 2:
                    posZona = platjaActual.seleccionarElement(5, null);
                    if (posZona >= 0) {
                        int posLloguer = ((Zona) platjaActual.getElements()[posZona]).seleccionarLloguer();
                        if (posLloguer >= 0) {
                            ((Zona) platjaActual.getElements()[posZona]).tancarLloguer();
                        }

                    } else {
                        System.out.println("\nNo existeix la zona.");
                    }
                    break;
                case 3:
                    posZona = platjaActual.seleccionarElement(5, null);
                    for (int i = 0; i < ((Zona) platjaActual.getElements()[posZona]).getLloguers().length && ((Zona) platjaActual.getElements()[posZona]).getLloguers()[i] != null; i++) {
                        ((Zona) platjaActual.getElements()[posZona]).getLloguers()[i].mostrarLloguer();
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static void menuElements() {
        int opcio = 0;
        Scanner dades = new Scanner(System.in);

        do {
            System.out.println("\nSelecciona una opció");
            System.out.println("\n0. Sortir");
            System.out.println("\n1. Alta");
            System.out.println("\n2. Baixa");
            System.out.println("\n3. Modificar");
            System.out.println("\n4. Llistar");
            opcio = dades.nextInt();
            switch (opcio) {
                case 0:
                    break;
                case 1:
                    platjaActual.afegirElement(tipusElement);
                    break;
                case 2:
                    platjaActual.treureElement(tipusElement);
                    break;
                case 3:
                    int pos = platjaActual.seleccionarElement(tipusElement, null);
                    if (pos >= 0) {
                        platjaActual.getElements()[pos].modificarElement();
                    } else {
                        System.out.println("\nNo existeix aquest element");
                    }
                    break;
                case 4:
                    for (int i = 0; i < platjaActual.getElements().length; i++) {
                        if (platjaActual.getElements()[i] != null && platjaActual.getElements()[i] instanceof Velomar && tipusElement == 1) {
                            ((Velomar) platjaActual.getElements()[i]).mostrarElement();
                        } else if (platjaActual.getElements()[i] != null && platjaActual.getElements()[i] instanceof Ombrella && tipusElement == 2) {
                            platjaActual.getElements()[i].mostrarElement();
                        } else if (platjaActual.getElements()[i] != null && platjaActual.getElements()[i] instanceof Hamaca && tipusElement == 3) {
                            platjaActual.getElements()[i].mostrarElement();
                        } else if (platjaActual.getElements()[i] != null && platjaActual.getElements()[i] instanceof Encarregat && tipusElement == 4) {
                            platjaActual.getElements()[i].mostrarElement();
                        }
                    }
                    break;
                default:
                    System.out.println("\nS'ha de seleccionar una opció correcta del menú.");
                    break;
            }
        } while (opcio != 0);
    }

    public static int seleccionarPlatja() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nCoordenades de la platja?:");
        String coordenades = dades.next();
        int pos = -1;
        for (int i = 0; i < indexPlatges; i++) {
            if (platges[i].getCoordenades().equals(coordenades)) {
                pos = i;
                return pos;
            }
        }
        return pos;
    }
}
