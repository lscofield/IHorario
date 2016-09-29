package es.tudir.horario.tools;

/**
 * Clase que contiene los códigos usados en "I Wish" para
 * mantener la integridad en las interacciones entre actividades
 * y fragmentos
 */
public class Constantes {
    /**
     * Transición Home -> Detalle
     */
    public static final int CODIGO_DETALLE = 100;

    /**
     * Transición Detalle -> Actualización
     */
    public static final int CODIGO_ACTUALIZACION = 101;
    /**
     * Puerto que utilizas para la conexión.
     * Dejalo en blanco si no has configurado esta carácteristica.
     */
    private static final String PUERTO_HOST = ":3306";
    /**
     * Dirección IP de genymotion o AVD
     */
    private static final String IP = "";
    /**
     * URLs del Web Service
     */

    public static final String GET = "http://perfil.atwebpages.com/obtener_metas.php";
    public static final String GET_BY_ID = "http://perfil.atwebpages.com/detalle_metas.php";
    public static final String UPDATE = "http://perfil.atwebpages.com/actualizar_metas.php";
    public static final String DELETE = "http://perfil.atwebpages.com/eliminar_metas.php";
    public static final String INSERT = "http://perfil.atwebpages.com/insertar_metas.php";

    /**
     * Clave para el valor extra que representa al identificador de una meta
     */
    public static final String EXTRA_ID = "IDEXTRA";

}
