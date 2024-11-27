import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ROOT = "/Users/joacoguzman/Code/prat/second-year/javaProjects/serializacion/guzman.joaquin.mp06.uf01.xml.ordenadores/";
    private static final String ARCHIVO_INDIVIDUAL = ROOT + "archivos/ordenador.xml";
    private static final String ARCHIVO_LISTA = ROOT + "archivos/ordenadores.xml";

    public static void main(String[] args) {
        Ordenador ordenador1 = new Ordenador("123456", "Apple", "MacBook Pro", 16, 512, "Intel Core i7");
        Ordenador ordenador2 = new Ordenador("654321", "Asus", "ZenBook", 8, 256, "Intel Core i5");

        List<Ordenador> ordenadores = new ArrayList<>();
        ordenadores.add(ordenador1);
        ordenadores.add(ordenador2);

        OrdenadorLogica logic = new OrdenadorLogica();

        logic.serializeOrdenador(ordenador1, ARCHIVO_INDIVIDUAL);

        logic.serializeOrdenadores(ordenadores, ARCHIVO_LISTA);

        Ordenador deserializedOrdenador = logic.deserializeOrdenador(ARCHIVO_INDIVIDUAL);
        System.out.println("\nAlumno deserializado desde archivo: ");
        System.out.println(deserializedOrdenador);

        List<Ordenador> deserializedOrdenadores = logic.deserializeOrdenadores(ARCHIVO_LISTA);
        System.out.println("\nLista de alumnos deserializada desde archivo: ");
        for (Ordenador ordenador : deserializedOrdenadores) {
            System.out.println(ordenador);
        }
    }
}
