import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;

public class OrdenadorLogica {
    private Gson gson = null;

    public OrdenadorLogica() {
        this.gson = new GsonBuilder()
                .excludeFieldsWithModifiers(Modifier.TRANSIENT)
                .setPrettyPrinting()
                .create();
    }

    public String serializeOrdenador(Ordenador ordenador) {
        return gson.toJson(ordenador);
    }

    public String serializeOrdenadores(List<Ordenador> ordenadoresList) {
        return gson.toJson(ordenadoresList);
    }

    public Ordenador deserializeOrdenador(String json)  {
        return gson.fromJson(json, Ordenador.class);
    }

    public List<Ordenador> deserializeOrdenadores(String json) {
        return gson.fromJson(json, new TypeToken<ArrayList<Ordenador>>() {}.getType());
    }

    public void WriteToFile(String filename, String json) {
        try {
            File file = new File(filename);
            if (!file.exists()) {
                file.createNewFile();
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
                writer.write(json);
                System.out.println("Se ha escrito correctamente: " + filename);
            }
        } catch (IOException e) {
            System.err.println("Error al crear o escribir el archivo: " + e.getMessage());
        }
    }

    public String readFromFile(String filename) {
        StringBuilder json = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                json.append(line);
            }

        } catch (IOException e) {
            System.err.println("Error en llegir del fitxer: " + e.getMessage());
        }
        return json.toString();
    }
}
