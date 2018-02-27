package principal;

/**
 *
 * @author cesca
 */
public class GestorLloguersExcepcio extends Exception {

    private String codiCausa = "desconegut";
    private String missatge;
    static final String NIF = "TRWAGMYFPDXBNJZSQVHLCKE"; //Atribut amb les possibles lletres d'un NIF

    public GestorLloguersExcepcio(String pCodiCausa) {
        codiCausa = pCodiCausa;
        switch (codiCausa) {
            case "1":
                missatge = "La dada introduida no és un enter";
                break;
            case "2":
                missatge = "El DNI no és correcte";
                break;
            case "3":
                missatge = "La data no és correcte";
                break;
            case "4":
                missatge = "Les hores no són correctes";
                break;
            case "5":
                missatge = "La resposta no és correcta.";
                break;
            case "GestorXML.model":
                missatge = "No s'ha pogut crear el model XML per desar el contingut de MusicTime";
                break;
            case "GestorXML.desar":
                missatge = "No s'ha pogut desar el contingut de MusicTime a causa d'error d'entrada/sortida";
                break;
            case "GestorXML.carrega":
                missatge = "No s'ha pogut carregar el contingut de MusicTime a causa d'error d'entrada/sortida";
                break;
            default:
                missatge = "Error desconegut";
                break;
        }
    }

    public static boolean comprovarNIF(String nif) {

        String nombresNIF = null;
        String[] nombres = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
        String[] lletres = {"T", "R", "W", "A", "G", "M", "Y", "F", "P", "D", "X", "B", "N", "J", "Z", "S", "Q", "V", "H", "L", "C", "K", "E"};

        for (int i = 0; i < nif.length() - 1; i++) {

            for (int j = 0; j < nombres.length; j++) {
                if (nif.substring(i, i + 1).equals(nombres[j])) {
                    nombresNIF += nombres[j];
                } else {
                    return false;
                }
            }

        }

        return nombresNIF.length() == 8 && lletres[Integer.parseInt(nombresNIF.substring(0, 8)) % 23].equals((nif.substring(8)).toUpperCase());

    }
    
    public static boolean comprovarHores(int hores) {
        return hores >= 0;
    }

    public static boolean comprovarResposta(int resposta) {

        return resposta == 0 || resposta == 1;
    }

    public static boolean comprovarData(int dia, int mes, int any) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return (dia >= 1 && dia <= 31) && any >= 0;
            case 4:
            case 6:
            case 9:
            case 11:
                return (dia >= 1 && dia <= 30) && any >= 0;
            case 2:
                if ((any % 4 == 0 && any % 100 != 0 || any % 400 == 0) && (dia >= 1 && dia <= 29)) {
                    return true;
                } else {
                    return !(any % 4 == 0 && any % 100 != 0 || any % 400 == 0) && (dia >= 1 && dia <= 28);
                }
            default:
                return false;
        }
    }
}
