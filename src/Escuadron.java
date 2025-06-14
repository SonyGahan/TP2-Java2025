import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Escuadron {
    private String nombreEscuadron;
    private String comisariaPertenencia;
    private List<Policia> policias;
    private List<Arma> armas; // Armas que posee el escuadrón en general, no solo las asignadas a policías.

    //Constructor
    public Escuadron(String nombreEscuadron, String comisariaPertenencia,
                     List<Policia> policias, List<Arma> armas) {
        this.nombreEscuadron = nombreEscuadron;
        this.comisariaPertenencia = comisariaPertenencia;
        this.policias = new ArrayList<>(policias); // Copia defensiva
        this.armas = new ArrayList<>(armas); // Copia defensiva
    }

    // Getters
    public String getNombreEscuadron() {
        return nombreEscuadron;
    }

    public String getComisariaPertenencia() {
        return comisariaPertenencia;
    }

    public List<Policia> getPolicias() {
        return new ArrayList<>(policias);
    }

    public List<Arma> getArmas() {
        return new ArrayList<>(armas);
    }

    /**
     * Retorna la cantidad de integrantes (policías) del escuadrón.
     * @return Cantidad de policías.
     */
    public int getCantidadIntegrantes() {
        return policias.size();
    }

    /**
     * Retorna un mapa donde la clave es el arma y el valor es el policía al que corresponde.
     * Considera tanto las armas asignadas a policías como las que el escuadrón posee en general.
     *
     * @return Un mapa de Armas a Policias. Si un arma no está asignada a un policía específico,
     * su valor en el mapa será null.
     */
    public Map<Arma, Policia> getArmasConPoliciaCorrespondiente() {
        // Mapea las armas directamente asignadas a los policías
        Map<Arma, Policia> armasAsignadas = policias.stream()
                .filter(p -> p.getArmaAsignada() != null)
                .collect(Collectors.toMap(Policia::getArmaAsignada, p -> p));

        // Agrega las armas que el escuadrón posee en general y no están asignadas a un policía
        for (Arma arma : armas) {
            if (!armasAsignadas.containsKey(arma)) {
                armasAsignadas.put(arma, null); // Si el arma del escuadrón no está asignada, su policía es null
            }
        }
        return armasAsignadas;
    }

    /**
     * Retorna la cantidad de armas que están en condiciones de ser usadas.
     * Considera todas las armas del escuadrón (las asignadas a policías y las generales).
     * @return Cantidad de armas en condiciones.
     */
    public long getCantidadArmasEnCondiciones() {
        long armasAsignadasEnCondiciones = policias.stream()
                .filter(p -> p.getArmaAsignada() != null && p.getArmaAsignada().estaEnCondicionesParaUso())
                .count();

        long armasGeneralesEnCondiciones = armas.stream()
                .filter(Arma::estaEnCondicionesParaUso)
                .count();
        
        // Sumar las armas asignadas a los policías y las armas generales del escuadrón.
        // Se debe tener cuidado de no contar dos veces la misma arma si está en ambas listas.
        // Una forma sencilla es unirlas en un Set y luego filtrar.
        List<Arma> todasLasArmasDelEscuadron = new ArrayList<>();
        policias.forEach(p -> {
            if (p.getArmaAsignada() != null) {
                todasLasArmasDelEscuadron.add(p.getArmaAsignada());
            }
        });
        todasLasArmasDelEscuadron.addAll(armas);

        return todasLasArmasDelEscuadron.stream()
                .distinct() // Evita contar armas duplicadas
                .filter(Arma::estaEnCondicionesParaUso)
                .count();
    }

    //Metodo To String
    @Override
    public String toString() {
        return "Escuadron{" +
               "nombreEscuadron='" + nombreEscuadron + '\'' +
               ", comisariaPertenencia='" + comisariaPertenencia + '\'' +
               ", cantidadPolicias=" + policias.size() +
               ", cantidadArmas=" + armas.size() +
               '}';
    }
}