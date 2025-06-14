public class ArmaLarga extends Arma implements Comparable<ArmaLarga> {
    private boolean selloRENAR;
    private String descripcionJustificacionUso;
    private int nivelArma; // 1 a 5

    //Constructor
    public ArmaLarga(String nombrePolicia, String apellidoPolicia, String legajoPolicia,
                     int cantidadMuniciones, double alcanceMetros, String marca,
                     String calibre, String estado, boolean selloRENAR,
                     String descripcionJustificacionUso, int nivelArma) {
        super(nombrePolicia, apellidoPolicia, legajoPolicia, cantidadMuniciones,
              alcanceMetros, marca, calibre, estado);
        this.selloRENAR = selloRENAR;
        this.descripcionJustificacionUso = descripcionJustificacionUso;
        this.nivelArma = nivelArma;
    }

    public boolean tieneSelloRENAR() {
        return selloRENAR;
    }

    public String getDescripcionJustificacionUso() {
        return descripcionJustificacionUso;
    }

    public int getNivelArma() {
        return nivelArma;
    }

    /**
     * Compara esta ArmaLarga con otra basándose en su nivel.
     * Retorna un valor negativo si esta arma es de menor nivel,
     * cero si tienen el mismo nivel, o un valor positivo si esta arma es de mayor nivel.
     */
    @Override
    public int compareTo(ArmaLarga otraArmaLarga) {
        return Integer.compare(this.nivelArma, otraArmaLarga.nivelArma);
    }

    //Metodo To String
    @Override
    public String toString() {
        return "ArmaLarga{" +
               super.toString() +
               ", selloRENAR=" + selloRENAR +
               ", descripcionJustificacionUso='" + descripcionJustificacionUso + '\'' +
               ", nivelArma=" + nivelArma +
               '}';
    }
}