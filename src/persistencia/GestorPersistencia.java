package persistencia;

import principal.GestorLloguersExcepcio;
import principal.Platja;



/**
 *
 * @author Francesca
 */
public class GestorPersistencia {
    private GestorXML gestor;

    public GestorXML getGestor() {
        return gestor;
    }

    public void setGestor(GestorXML pGestor) {
        gestor = pGestor;
    }

    public void desarPlatja(String tipusPersistencia, String nomFitxer, Platja platja) throws GestorLloguersExcepcio{
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            gestor.desarContingut(nomFitxer, platja);
        }
    }

    public Platja carregarPlatja(String tipusPersistencia, String nomFitxer) throws GestorLloguersExcepcio{
        ProveedorPersistencia gestor;
        Platja platja = null;
        
        if (tipusPersistencia.equals("XML")) {
            gestor = new GestorXML();
            platja=gestor.carregarContingut(nomFitxer);
        }
        
        return platja;
    }
}
