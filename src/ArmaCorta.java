public class ArmaCorta extends Arma {
    private boolean esAutomatica;

    //Constructor
    public ArmaCorta(String nombrePolicia, String apellidoPolicia, String legajoPolicia,
                     int cantidadMuniciones, double alcanceMetros, String marca,
                     String calibre, String estado, boolean esAutomatica) {
        super(nombrePolicia, apellidoPolicia, legajoPolicia, cantidadMuniciones,
              alcanceMetros, marca, calibre, estado);
        this.esAutomatica = esAutomatica;
    }

    public boolean esAutomatica() {
        return esAutomatica;
    }

    /**
     * Determina si el arma corta puede dispararse a más de 200m.
     * @return true si puede dispararse a más de 200m, false en caso contrario.
     */
    public boolean puedeDispararseAMasDe200m() {
        return this.alcanceMetros > 200;
    }

    //Metodo To String
    @Override
    public String toString() {
        return "ArmaCorta{" +
               super.toString() +
               ", esAutomatica=" + esAutomatica +
               '}';
    }
}