package principal;

import elements.ElementLloguer;
import elements.Encarregat;
import elements.Hamaca;
import elements.Lloguer;
import elements.Ombrella;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author fta
 */
public class Zona implements Element {

    private String codi;
    private ArrayList<Lloguer> lloguers;
    private ArrayList<ElementLloguer> elements;
    private Encarregat [] encarregats;

    public Zona(String pCodi) {
        codi = pCodi;
        lloguers = new ArrayList<>(300);
        //elements = new ArrayList<>(28);
        //encarregats = new ArrayList<>(3);
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String pCodi) {
        codi = pCodi;
    }

    public ArrayList<Lloguer> getLloguers() {
        return lloguers;
    }

    public void setLloguers(ArrayList<Lloguer> pLloguers) {
        lloguers = pLloguers;
    }
    /*
    public ArrayList<Encarregat> getEncarregats() {
        return encarregats;
    }

    public void setEncarregats(ArrayList<Encarregat> pEncarregats) {
        encarregats = pEncarregats;
    }

    public ArrayList<ElementLloguer> getElements() {
        return elements;
    }

    public void setElements(ArrayList<ElementLloguer> pElements) {
        elements = pElements;
    }
    */

    public static Zona novaZona(String pCodi) {
        Scanner dades = new Scanner(System.in);

        if (pCodi == null) {
            System.out.println("Codi de la zona:");
            pCodi = dades.next();
        }

        return new Zona(pCodi);
    }

    @Override
    public void modificarElement() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nZona amb codi: " + codi);
        System.out.println("\nEntra el nou codi:");
        codi = dades.next();
    }

    @Override
    public void mostrarElement() {
        System.out.println("\nLes dades de la zona amb codi " + codi + " són:");

        System.out.println("\nLloguers:");
        for(Lloguer llog:lloguers){
            llog.mostrarLloguer();
        }

        System.out.println("\nElements:");
        for(Element ele:elements){
            ele.mostrarElement();
        }
    }

    /*
     LLOGUERS
     */
    public void afegirLloguer(Lloguer lloguer) {
        if(lloguers.contains(lloguer)==false){
            lloguers.add(lloguer);
        }
    }

    public void tancarLloguer() {
        boolean trobat = false;
        int pos = seleccionarLloguer();
        int codiLloguer;
//        Element ele;
        if (pos != -1) {
            codiLloguer = lloguers.get(pos).getCodi();
            
            for (ElementLloguer ele: elements){
                if(ele.getCodi() == codiLloguer){
                    ele.setLlogat(false);
                    
                    if(ele instanceof Ombrella){
                        for(Hamaca ham:((Ombrella) ele).getHamaques()){
                            ham.setLlogat(false);
                        }
                    }
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
        
        int i = 0;
        Lloguer llog;
        Iterator<Lloguer> it = lloguers.iterator();
        
        while(it.hasNext()){
            i++;
            llog = it.next();
            if(llog.getCodi() == codi){
                return i;
            }
        }

        return -1;
    }

    /*
     ELEMENTS
     */
    public void afegirElementLloguer(ElementLloguer element) {
        boolean trobat = false;
        if(elements.contains(element) == false){
            elements.add(element);
        }
    }

    public void treureElementLloguer(int codi) {
        boolean trobat = false;
        for (ElementLloguer ele: elements){
            if(ele.getCodi()==codi){
                elements.remove(ele);
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
        
        for (ElementLloguer ele: elements){
            if(ele.getCodi()==codi){
                return elements.indexOf(ele);
            }
        }
        
        return -1;
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
