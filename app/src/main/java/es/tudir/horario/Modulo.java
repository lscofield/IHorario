package es.tudir.horario;

/**
 * POJO de un producto
 */
public class Modulo {
    /**
     * Nombre del producto
     */
    private String nModulo;
    /**
     * Especificaciones del producto
     */
    /**
     * Precio del producto
     */
    private String hora;
    /**
     * Valoraciones del producto
     */
    /**
     * Identificador de la imagen para miniatura
     */
    private int idThumbnail;

    public Modulo(String nModulo, String hora, int idThumbnail) {
        this.nModulo = nModulo;
        this.hora = hora;
        this.idThumbnail = idThumbnail;
    }

    public Modulo() {
    }

    public String getnModulo() {
        return nModulo;
    }


    public String getHora() {
        return hora;
    }


    public int getIdThumbnail() {
        return idThumbnail;
    }
}
