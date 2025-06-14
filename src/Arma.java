/** Se utiliza una clase abstracta Arma para agrupar los atributos y
 * comportamientos comunes a todas las armas
 */


public abstract class Arma {
    protected String nombrePolicia;
    protected String apellidoPolicia;
    protected String legajoPolicia;
    protected int cantidadMuniciones;
    protected double alcanceMetros;
    protected String marca;
    protected String calibre; // Se parsea a double para comparaciones
    protected String estado; // "nueva", "en mantenimiento", "en uso"

    //Constructor
    public Arma(String nombrePolicia, String apellidoPolicia, String legajoPolicia,
                int cantidadMuniciones, double alcanceMetros, String marca,
                String calibre, String estado) {
        this.nombrePolicia = nombrePolicia;
        this.apellidoPolicia = apellidoPolicia;
        this.legajoPolicia = legajoPolicia;
        this.cantidadMuniciones = cantidadMuniciones;
        this.alcanceMetros = alcanceMetros;
        this.marca = marca;
        this.calibre = calibre;
        this.estado = estado;
    }

    // Getters para respetar el encapsulamiento
    public String getNombrePolicia() {
        return nombrePolicia;
    }

    public String getApellidoPolicia() {
        return apellidoPolicia;
    }

    public String getLegajoPolicia() {
        return legajoPolicia;
    }

    public int getCantidadMuniciones() {
        return cantidadMuniciones;
    }

    public double getAlcanceMetros() {
        return alcanceMetros;
    }

    public String getMarca() {
        return marca;
    }

    public String getCalibre() {
        return calibre;
    }

    public String getEstado() {
        return estado;
    }

    /**
     * Verifica si el arma está en condiciones de ser usada en un enfrentamiento.
     * Para esto, debe estar en estado "en uso" y su calibre debe ser >= 9.
     * Se utiliza Double.parseDouble para manejar calibres con decimales.
     *
     * @return true si el arma está en condiciones, false en caso contrario.
     */
    public boolean estaEnCondicionesParaUso() {
        try {
            // Se asume que el calibre siempre será un número válido (entero o decimal)
            return "en uso".equalsIgnoreCase(this.estado) && Double.parseDouble(this.calibre) >= 9.0; //Se parsea a double
        } catch (NumberFormatException e) {
            System.err.println("Error al parsear el calibre '" + this.calibre + "' a número en el arma " + this.marca + ". " + e.getMessage());
            return false; // Si hay un error de formato, el arma no está en condiciones
        }
    }

    //Metodo To String
    @Override
    public String toString() {
        return "Arma{" +
                "nombrePolicia='" + nombrePolicia + '\'' +
                ", apellidoPolicia='" + apellidoPolicia + '\'' +
                ", legajoPolicia='" + legajoPolicia + '\'' +
                ", cantidadMuniciones=" + cantidadMuniciones +
                ", alcanceMetros=" + alcanceMetros +
                ", marca='" + marca + '\'' +
                ", calibre='" + calibre + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}