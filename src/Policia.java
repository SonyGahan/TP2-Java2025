public class Policia {
    private String nombre;
    private String apellido;
    private String legajo;
    private String escuadronPertenencia;
    private Arma armaAsignada; // Se asume que un policía tiene una única arma asignada.

    //Constructor
    public Policia(String nombre, String apellido, String legajo,
                   String escuadronPertenencia, Arma armaAsignada) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.legajo = legajo;
        this.escuadronPertenencia = escuadronPertenencia;
        this.armaAsignada = armaAsignada;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getLegajo() {
        return legajo;
    }

    public String getEscuadronPertenencia() {
        return escuadronPertenencia;
    }

    public Arma getArmaAsignada() {
        return armaAsignada;
    }

    //Metodo To String
    @Override
    public String toString() {
        return "Policia{" +
               "nombre='" + nombre + '\'' +
               ", apellido='" + apellido + '\'' +
               ", legajo='" + legajo + '\'' +
               ", escuadronPertenencia='" + escuadronPertenencia + '\'' +
               ", armaAsignada=" + (armaAsignada != null ? armaAsignada.getMarca() + " " + armaAsignada.getCalibre() : "N/A") +
               '}';
    }
}