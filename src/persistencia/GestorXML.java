package persistencia;


import java.io.FileWriter;
import nu.xom.*;
import principal.GestorLloguersExcepcio;
import principal.Platja;
/**
 *
 * @author fta
 */
public class GestorXML implements ProveedorPersistencia {

    private Document doc;
    private Platja platja;

    public Platja getPlatja() {
        return platja;
    }

    public void setPlatja(Platja pPlatja) {
        platja = pPlatja;
    }

    @Override
    public void desarContingut(String nomFitxer, Platja platja)throws GestorLloguersExcepcio{
        construeixModel(platja);
        desarModel(nomFitxer);
    }

    @Override
    public Platja carregarContingut(String nomFitxer)throws GestorLloguersExcepcio{
        carregarFitxer(nomFitxer);
        fitxerContingut();
        return platja;
    }

    /*Paràmetres: Platja a partir de la qual volem construir el model
     *
     *Acció: 
     * - Llegir els atributs de l'objecte Platja passat per paràmetre 
     *   per construir un model (document XML) sobre el Document doc (atribut de GestorXML).
     *
     * - L'arrel del document XML és "platja". Aquesta arrel, l'heu d'afegir 
     *   a doc. Un cop fet això, heu de recórrer l'ArrayList elements de 
     *   Platja i per a cada element, afegir un fill a doc. Cada fill 
     *   tindrà com atributs els atributs de l'objecte (nif, nom, …).
     *
     * - Si es tracta d'una ombrel.la, a més, heu d'afegir fills addicionals amb 
     *   les hamaques de l'ombrel.la.
     *
     * - Si es tracta d'una zona, a més, heu d'afegir fills addicionals amb els 
     *   seus encarregats, lloguers, velomars i omrel.les, i per cada ombrel.la, 
     *   afegir-li els fills addicionals amb les hamaques de l'ombrel.la.
     *
     *Retorn: cap
     */
    public void construeixModel(Platja platja){
        
    }

    public void desarModel(String rutaFitxer) throws GestorLloguersExcepcio{
        try {
            FileWriter fitxer = new FileWriter(rutaFitxer, false); //Obrim fitxer per sobreescriure
            fitxer.write(doc.toXML());
            fitxer.close();
        } catch (Exception e) {
            throw new GestorLloguersExcepcio("GestorXML.desar");
        }
    }

    public void carregarFitxer(String rutaFitxer) throws GestorLloguersExcepcio {
        Builder builder = new Builder();
        try {
            doc = builder.build("/home/cesca/NetBeansProjects/GestorLloguersPlatjaV3/" + rutaFitxer);
        } catch (Exception e) {
            throw new GestorLloguersExcepcio("GestorXML.carregar");
        }
    }

    /*Paràmetres: cap
     *
     *Acció: 
     * - Llegir el fitxer del vostre sistema i carregar-lo sobre l'atribut doc.
     * - per assignar valors als atributs de Platja i la resta d'objectes 
     *   que formen els elements de Platja.
     * - Primer creeu l'objecte Platja a partir de l'arrel del document per després 
     *   recórrer el doc i per cada fill, afegir un objecte a l'atribut elements de 
     *   Platja mitjançant el mètode escaient de la classe Platja.
     * - Si el fill (del doc) que s'ha llegit és una ombrel.la o una zona, recordeu 
     *   que a més d'afegir-los a elements, també haureu d'afegir en l'ombrel.la 
     *   les seves hamaques i en la zona els seus elements, encarregats i lloguers.
     *
     *Retorn: cap
     */
    private void fitxerContingut(){
        
    }

}
