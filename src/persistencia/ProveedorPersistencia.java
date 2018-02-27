package persistencia;

import principal.GestorLloguersExcepcio;
import principal.Platja;


/**
 *
 * @author Francesca
 */
public interface ProveedorPersistencia {
    public void desarContingut(String nomFitxer, Platja platja)throws GestorLloguersExcepcio;
    public Platja carregarContingut(String nomFitxer)throws GestorLloguersExcepcio;
}
