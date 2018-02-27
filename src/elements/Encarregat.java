package elements;

import java.util.Scanner;
import principal.Element;

/**
 *
 * @author fta
 */
public class Encarregat implements Element {

    private String dni;
    private String nom;
    private String adreca;

    public Encarregat(String pDni, String pNom, String pAdreca) {
        dni = pDni;
        nom = pNom;
        adreca = pAdreca;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String pDni) {
        dni = pDni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String pNom) {
        nom = pNom;
    }

    public String getAdreca() {
        return adreca;
    }

    public void setAdreca(String pAdreca) {
        adreca = pAdreca;
    }

    public static Encarregat nouEncarregat(String pDni) {
        Scanner dades = new Scanner(System.in);
        String nomEncarregat;
        String adrecaEncarregat;

        if (pDni == null) {
            System.out.println("DNI de l'encarregat:");
            pDni = dades.next();
            dades.nextLine(); //Neteja buffer
        }

        System.out.println("Nom de l'encarregat:");
        nomEncarregat = dades.nextLine();
        System.out.println("Adreca de l'encarregat:");
        adrecaEncarregat = dades.nextLine();

        return new Encarregat(pDni, nomEncarregat, adrecaEncarregat);
    }

    public void modificarElement() {
        Scanner dades = new Scanner(System.in);
        System.out.println("\nDNI de l'encarregat: " + dni);
        System.out.println("\nEntra el nou DNI:");
        dni = dades.next();
        System.out.println("\nNom de l'encarregat: " + nom);
        System.out.println("\nEntra el nou nom:");
        nom = dades.nextLine();
        dades.nextLine(); //Neteja de buffer
        System.out.println("\nAdreça de l'encarregat: " + adreca);
        System.out.println("\nEntra la nova adreça:");
        adreca = dades.nextLine();
    }

    public void mostrarElement() {
        System.out.println("\nLes dades de l'encarregat amb dni " + dni + " són:");
        System.out.println("\nNom:" + nom);
        System.out.println("\nAdreça:" + adreca);
    }
}
