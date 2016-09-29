package es.tudir.horario.modelo;

/**
 * Reflejo de la tabla 'meta' en la base de datos
 */
public class Meta {

    private static final String TAG = Meta.class.getSimpleName();
    /*
        Atributos
         */
    private String id_evento;
    private String evento;
    private String descripcion;
    private String fecha;
    private String modulo;

    public Meta(String id_evento,
                String evento,
                String descripcion,
                String fecha,
                String modulo) {
        this.id_evento = id_evento;
        this.evento = evento;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.modulo = modulo;
    }

    public String getId_evento() {
        return id_evento;
    }

    public String getEvento() {
        return evento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public String getModulo() {
        return modulo;
    }

    /**
     * Compara los atributos de dos metas
     *
     * @param examenes Meta externa
     * @return true si son iguales, false si hay cambios
     */
    public boolean compararCon(Meta examenes) {
        return this.evento.compareTo(examenes.evento) == 0 &&
                this.descripcion.compareTo(examenes.descripcion) == 0 &&
                this.fecha.compareTo(examenes.fecha) == 0 &&
                this.modulo.compareTo(examenes.modulo) == 0;
    }
}
