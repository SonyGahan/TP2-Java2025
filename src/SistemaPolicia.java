import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SistemaPolicia {

    public static void main(String[] args) {
        // 1. Crear Armas
        ArmaCorta armaCorta1 = new ArmaCorta("Juan", "Perez", "12345", 15, 150.0, "Glock", "9", "en uso", true);
        ArmaCorta armaCorta2 = new ArmaCorta("Ana", "Gomez", "67890", 10, 250.0, "Bersa", "45", "en mantenimiento", false);
        ArmaCorta armaCorta3 = new ArmaCorta("Carlos", "Lopez", "11223", 20, 180.0, "SmithWesson", "9", "en uso", true);

        ArmaLarga armaLarga1 = new ArmaLarga("Pedro", "Diaz", "54321", 30, 500.0, "AK-47", "7.62", "en uso", true, "Defensa perimetral", 4);
        ArmaLarga armaLarga2 = new ArmaLarga("Maria", "Rodriguez", "98765", 25, 400.0, "M4", "5.56", "nueva", true, "Operaciones especiales", 5);
        ArmaLarga armaLarga3 = new ArmaLarga("Laura", "Fernandez", "00998", 50, 600.0, "Remington", "12", "en uso", false, "Control de multitudes", 3);

        // 2. Crear Policias
        Policia policia1 = new Policia("Juan", "Perez", "12345", "Alfa", armaCorta1);
        Policia policia2 = new Policia("Ana", "Gomez", "67890", "Alfa", armaCorta2);
        Policia policia3 = new Policia("Pedro", "Diaz", "54321", "Bravo", armaLarga1);
        Policia policia4 = new Policia("Maria", "Rodriguez", "98765", "Bravo", armaLarga2);
        Policia policia5 = new Policia("Carlos", "Lopez", "11223", "Alfa", armaCorta3);
        Policia policia6 = new Policia("Laura", "Fernandez", "00998", "Bravo", armaLarga3);


        // Lista de policías para el escuadrón Alfa
        List<Policia> policiasAlfa = new ArrayList<>();
        policiasAlfa.add(policia1);
        policiasAlfa.add(policia2);
        policiasAlfa.add(policia5);

        // Armas adicionales que posee el escuadrón Alfa (no asignadas a un policía específico de este escuadrón)
        List<Arma> armasEscuadronAlfa = new ArrayList<>();
        armasEscuadronAlfa.add(new ArmaCorta(null, null, null, 10, 100.0, "Walther", "9", "en uso", false));


        // Lista de policías para el escuadrón Bravo
        List<Policia> policiasBravo = new ArrayList<>();
        policiasBravo.add(policia3);
        policiasBravo.add(policia4);
        policiasBravo.add(policia6);

        // Armas adicionales que posee el escuadrón Bravo
        List<Arma> armasEscuadronBravo = new ArrayList<>();
        armasEscuadronBravo.add(new ArmaLarga(null, null, null, 40, 700.0, "Sig Sauer", "7.62", "en uso", true, "Apoyo en campo", 5));


        // 3. Crear Escuadrones
        Escuadron escuadronAlfa = new Escuadron("Alfa", "Comisaria 1ra", policiasAlfa, armasEscuadronAlfa);
        Escuadron escuadronBravo = new Escuadron("Bravo", "Comisaria 2da", policiasBravo, armasEscuadronBravo);

        System.out.println("--- Reporte de Armas ---");
        // Saber si un arma está en condiciones para ser usada
        System.out.println(armaCorta1.getMarca() + " " + armaCorta1.getCalibre() + " en condiciones: " + armaCorta1.estaEnCondicionesParaUso()); // True
        System.out.println(armaCorta2.getMarca() + " " + armaCorta2.getCalibre() + " en condiciones: " + armaCorta2.estaEnCondicionesParaUso()); // False (en mantenimiento)
        System.out.println(armaLarga1.getMarca() + " " + armaLarga1.getCalibre() + " en condiciones: " + armaLarga1.estaEnCondicionesParaUso()); // True
        System.out.println(armaLarga2.getMarca() + " " + armaLarga2.getCalibre() + " en condiciones: " + armaLarga2.estaEnCondicionesParaUso()); // False (nueva)

        System.out.println("\n--- Comparación y Funcionalidades de Armas ---");
        // Comparar armas largas (por nivel)
        System.out.println(armaLarga1.getMarca() + " (Nivel " + armaLarga1.getNivelArma() + ") vs " + armaLarga2.getMarca() + " (Nivel " + armaLarga2.getNivelArma() + ")");
        if (armaLarga1.compareTo(armaLarga2) > 0) {
            System.out.println(armaLarga1.getMarca() + " es mayor que " + armaLarga2.getMarca());
        } else if (armaLarga1.compareTo(armaLarga2) < 0) {
            System.out.println(armaLarga2.getMarca() + " es mayor que " + armaLarga1.getMarca());
        } else {
            System.out.println("Ambas armas tienen el mismo nivel.");
        }

        // Saber si un arma corta se puede disparar a más de 200m
        System.out.println(armaCorta1.getMarca() + " " + armaCorta1.getCalibre() + " puede dispararse a más de 200m: " + armaCorta1.puedeDispararseAMasDe200m()); // False
        System.out.println(armaCorta2.getMarca() + " " + armaCorta2.getCalibre() + " puede dispararse a más de 200m: " + armaCorta2.puedeDispararseAMasDe200m()); // True

        System.out.println("\n--- Reporte del Escuadron Alfa ---");
        System.out.println("Nombre del Escuadron: " + escuadronAlfa.getNombreEscuadron());
        System.out.println("Comisaria: " + escuadronAlfa.getComisariaPertenencia());
        System.out.println("Cantidad de integrantes: " + escuadronAlfa.getCantidadIntegrantes());

        System.out.println("\nArmas y Policias Correspondientes (Escuadron Alfa):");
        Map<Arma, Policia> armasConPoliciaAlfa = escuadronAlfa.getArmasConPoliciaCorrespondiente();
        armasConPoliciaAlfa.forEach((arma, policia) -> {
            String policiaInfo = (policia != null) ? policia.getNombre() + " " + policia.getApellido() : "Sin asignar";
            System.out.println("  - Arma: " + arma.getMarca() + " " + arma.getCalibre() + " (Asignada a: " + policiaInfo + ")");
        });

        System.out.println("Cantidad de armas en condiciones de ser usadas (Escuadron Alfa): " + escuadronAlfa.getCantidadArmasEnCondiciones());

        System.out.println("\n--- Reporte del Escuadron Bravo ---");
        System.out.println("Nombre del Escuadron: " + escuadronBravo.getNombreEscuadron());
        System.out.println("Comisaria: " + escuadronBravo.getComisariaPertenencia());
        System.out.println("Cantidad de integrantes: " + escuadronBravo.getCantidadIntegrantes());

        System.out.println("\nArmas y Policias Correspondientes (Escuadron Bravo):");
        Map<Arma, Policia> armasConPoliciaBravo = escuadronBravo.getArmasConPoliciaCorrespondiente();
        armasConPoliciaBravo.forEach((arma, policia) -> {
            String policiaInfo = (policia != null) ? policia.getNombre() + " " + policia.getApellido() : "Sin asignar";
            System.out.println("  - Arma: " + arma.getMarca() + " " + arma.getCalibre() + " (Asignada a: " + policiaInfo + ")");
        });

        System.out.println("Cantidad de armas en condiciones de ser usadas (Escuadron Bravo): " + escuadronBravo.getCantidadArmasEnCondiciones());
    }
}