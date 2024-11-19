import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final String ROOT = "/Users/joacoguzman/Code/prat/second-year/javaProjects/serializacion/guzman.joaquin.mp06.uf01.json.ordinadors/";
    private static final String ARCHIVO_INDIVIDUAL = ROOT + "archivos/ordenador.json";
    private static final String ARCHIVO_LISTA = ROOT + "archivos/ordenadores.json";

    public static void main(String[] args) {
        Ordenador ordenador = new Ordenador(1, "HP", "Pavilion", 8, 512, "Intel i5");
        Ordenador ordenador1 = new Ordenador(2, "Asus", "VivoBook", 16, 1024, "AMD Ryzen 7");
        Ordenador ordenador2 = new Ordenador(3, "Apple", "MacBook Pro", 16, 1024, "Apple M1");

        List<Ordenador> ordenadorList = new ArrayList<>();
        ordenadorList.add(ordenador);
        ordenadorList.add(ordenador1);
        ordenadorList.add(ordenador2);

        OrdenadorLogica logic = new OrdenadorLogica();

        String jsonOrdenador = logic.serializeOrdenador(ordenador);
        logic.WriteToFile(ARCHIVO_INDIVIDUAL, jsonOrdenador);
        
        String jsonOrdenadores = logic.serializeOrdenadores(ordenadorList);
        logic.WriteToFile(ARCHIVO_LISTA, jsonOrdenadores);

        String jsonOrdenadorDesdeArchivo = logic.readFromFile(ARCHIVO_INDIVIDUAL);
        Ordenador ordenadorDeserializado = logic.deserializeOrdenador(jsonOrdenadorDesdeArchivo);
        System.out.println("Ordenador deserializado desde archivo:");
        System.out.println(ordenadorDeserializado);

        String jsonOrdenadoresDesdeArchivo = logic.readFromFile(ARCHIVO_LISTA);
        List<Ordenador> ordenadoresDeserializados = logic.deserializeOrdenadores(jsonOrdenadoresDesdeArchivo);
        System.out.println("Lista de ordenadores deserializada desde archivo:");
        for (Ordenador ordenadorDes : ordenadoresDeserializados) {
            System.out.println(ordenadorDes);
        }
    }
}
