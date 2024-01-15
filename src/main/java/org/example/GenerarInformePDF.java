package org.example;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenerarInformePDF {

    public static void main(String[] args) {
        try {
            // Cargar el diseño del informe desde un archivo .jrxml
            JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/ejercicio1(2).jrxml");

            // Crear una lista de Miembros de los Simpsons
            List<MiembroSimpson> miembros = new ArrayList<>();

            // Agregar datos de ejemplo para cada miembro
            miembros.add(new MiembroSimpson("Homer", "Simpson", "12/05/1956", "Springfield", "742 Evergreen Terrace",
                    "Springfield", "Springfield", "555-1234"));
            miembros.add(new MiembroSimpson("Marge", "Simpson", "19/04/1954", "Springfield", "742 Evergreen Terrace",
                    "Springfield", "Springfield", "555-4321"));
            miembros.add(new MiembroSimpson("Bart", "Simpson", "01/04/1979", "Springfield", "742 Evergreen Terrace",
                    "Springfield", "Springfield", "555-1111"));
            miembros.add(new MiembroSimpson("Lisa", "Simpson", "30/04/1981", "Springfield", "742 Evergreen Terrace",
                    "Springfield", "Springfield", "555-2222"));
            miembros.add(new MiembroSimpson("Maggie", "Simpson", "12/08/1989", "Springfield", "742 Evergreen Terrace",
                    "Springfield", "Springfield", "555-3333"));


            // Crear una fuente de datos a partir de la lista de Miembros
            JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(miembros);

            // Compilar el informe
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            // Llenar el informe con datos y parámetros
            Map<String, Object> parameters = new HashMap<>();
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);

            // Mostrar el informe en una ventana de visualización
            JasperViewer.viewReport(jasperPrint, false);
        } catch (JRException e) {
            e.printStackTrace();
        }
    }
}