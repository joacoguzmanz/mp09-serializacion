import java.beans.XMLDecoder;
import java.beans.XMLEncoder;

import java.io.*;
import java.util.List;

public class OrdenadorLogica {
    public void serializeOrdenador(Ordenador ordenador, String filename) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(ordenador);
            System.out.println("Ordenador serializado a XML: " + filename);
        } catch (IOException e) {
            System.err.println("Error serializando ordenador: " + e.getMessage());
        }
    }

    public Ordenador deserializeOrdenador(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (Ordenador) decoder.readObject();
        } catch (IOException e) {
            System.err.println("Error deserializando Ordenador: " + e.getMessage());
            return null;
        }
    }

    public void serializeOrdenadores(List<Ordenador> ordenadores, String filename) {
        try (XMLEncoder encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(filename)))) {
            encoder.writeObject(ordenadores);
            System.out.println("Lista de alumnos serializada a XML: " + filename);
        } catch (IOException e) {
            System.err.println("Error al serializar la lista de Alumnos: " + e.getMessage());
        }
    }

    public List<Ordenador> deserializeOrdenadores(String filename) {
        try (XMLDecoder decoder = new XMLDecoder(new BufferedInputStream(new FileInputStream(filename)))) {
            return (List<Ordenador>) decoder.readObject();
        } catch (IOException e) {
            System.err.println("Error al deserializar la lista de ordenadores: " + e.getMessage());
            return null;
        } catch (ClassCastException e) {
            System.err.println("Error de tipo al deserializar la lista de ordenadores: " + e.getMessage());
            return null;
        }
    }
}
