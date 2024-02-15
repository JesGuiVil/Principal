package encuestaxml;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;

public class CsvToXmlConverter {

    public static void main(String[] args) {
        convertCsvToXml("Gaming.csv", "Gamingxml.xml");
    }

    public static void convertCsvToXml(String csvFileName, String xmlFileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFileName));
             FileWriter fw = new FileWriter(xmlFileName)) {

            // Crear el escritor XML
            XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newInstance();
            XMLStreamWriter xmlStreamWriter = xmlOutputFactory.createXMLStreamWriter(fw);

            // Escribir la estructura XML
            xmlStreamWriter.writeStartDocument();
            xmlStreamWriter.writeStartElement("data");

            // Leer el archivo CSV
            String line;
            List<String> headers = null;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                if (headers == null) {
                    // Si es la primera línea, guarda los encabezados
                    headers = new ArrayList<>();
                    for (String field : fields) {
                        headers.add(field.trim());
                    }
                } else {
                    // Escribir una entrada para cada línea de datos
                    xmlStreamWriter.writeStartElement("entry");
                    for (int i = 0; i < headers.size(); i++) {
                        xmlStreamWriter.writeStartElement(headers.get(i));
                        
                        // Verificar el índice antes de acceder a fields
                        if (i < fields.length) {
                            xmlStreamWriter.writeCharacters(fields[i].trim());
                        } else {
                            // Manejar el caso en el que fields no tiene suficientes elementos
                            System.out.println("Advertencia: La línea tiene menos campos de los esperados.");
                        }
                        
                        xmlStreamWriter.writeEndElement();
                    }
                    xmlStreamWriter.writeEndElement(); // Cerrar la etiqueta de entrada
                }
            }

            // Cerrar la estructura XML
            xmlStreamWriter.writeEndElement();
            xmlStreamWriter.writeEndDocument();

            // Cerrar el escritor XML
            xmlStreamWriter.close();

            System.out.println("Conversión exitosa de CSV a XML.");

        } catch (IOException | XMLStreamException e) {
            e.printStackTrace();
        }
    }
}

