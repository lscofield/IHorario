package es.tudir.horario;

import android.support.v7.app.AppCompatActivity;

/**
 * Datos de prueba para las pestañas
 */

public class Dias extends AppCompatActivity {

    private static Modulo[] lunes = {
            new Modulo(
                    "\nEMPRESA E\nI.E\n",
                    "16:00 - 16:55",
                    R.drawable.eie),
            new Modulo(
                    "\nSEGURIDAD\nINFORMÁTICA\n",
                    "19:00 - 19:55",
                    R.drawable.si),
            new Modulo(
                    "\nSERVICIOS\nDE RED\n",
                    "16:55 - 17:50",
                    R.drawable.sr),
            new Modulo(
                    "\nSEGURIDAD\nINFORMÁTICA\n",
                    "19:55 - 20:50",
                    R.drawable.si),
            new Modulo(
                    "\nSERVICIOS\nDE RED\n",
                    "17:50 - 18:45",
                    R.drawable.sr),

            new Modulo(
                    "\nADMINISTRACIÓN\nDE SGBD\n",
                    "20:50 - 21:45",
                    R.drawable.sgbd),


            new Modulo(
                    "HORARIO ESCOLAR 2016/2017 (LUNES)",
                    " IZQUIERDA - primeras 3 horas\n DERECHA - últimas 3 horas.",
                    R.drawable.hor)

    };

    private static Modulo[] martes = {
            new Modulo(
                    "\nSERVICIOS\nDE RED\n",
                    "16:00 - 16:55",
                    R.drawable.sr),
            new Modulo(
                    "\nADMINISTRACIÓN\nDE S.O\n",
                    "19:00 - 19:55",
                    R.drawable.aso),
            new Modulo(
                    "\nSERVICIOS\nDE RED\n",
                    "16:55 - 17:50",
                    R.drawable.sr),
            new Modulo(
                    "\nADMINISTRACIÓN\nDE S.O\n",
                    "19:55 - 20:50",
                    R.drawable.aso),
            new Modulo(
                    "\nSERVICIOS\nDE RED\n",
                    "17:50 - 18:45",
                    R.drawable.sr),

            new Modulo(
                    "\nADMINISTRACIÓN\nDE S.O\n",
                    "20:50 - 21:45",
                    R.drawable.aso),


            new Modulo(
                    "HORARIO ESCOLAR 2016/2017 (MARTES)",
                    " IZQUIERDA - primeras 3 horas\n DERECHA - últimas 3 horas.",
                    R.drawable.hor)
    };

    private static Modulo[] jueves = {
            new Modulo(
                    "\nADMINISTRACIÓN\nDE S.O\n",
                    "16:00 - 16:55",
                    R.drawable.aso),
            new Modulo(
                    "\nADMINISTRACIÓN\nDE SGBD\n",
                    "19:00 - 19:55",
                    R.drawable.sgbd),
            new Modulo(
                    "\nADMINISTRACIÓN\nDE S.O\n",
                    "16:55 - 17:50",
                    R.drawable.aso),
            new Modulo(
                    "\nEMPRESA E\nI.E\n",
                    "19:55 - 20:50",
                    R.drawable.eie),
            new Modulo(
                    "\nADMINISTRACIÓN\n DE SGBD\n",
                    "17:50 - 18:45",
                    R.drawable.sgbd),

            new Modulo(
                    "\nSEGURIDAD\nINFORMÁTICA\n",
                    "20:50 - 21:45",
                    R.drawable.si),

            new Modulo(
                    "HORARIO ESCOLAR 2016/2017 (JUEVES)",
                    " IZQUIERDA - primeras 3 horas\n DERECHA - últimas 3 horas.",
                    R.drawable.hor)
    };

        private static Modulo[] viernes = {
                new Modulo(
                        "\nAPLICACIONES\nWEB\n",
                        "16:00 - 16:55",
                        R.drawable.aw),
                new Modulo(
                        "\nADMINISTRACIÓN\nDE S.O\n",
                        "19:00 - 19:55",
                        R.drawable.aso),
                new Modulo(
                        "\nAPLICACIONES\nWEB\n",
                        "16:55 - 17:50",
                        R.drawable.aw),
                new Modulo(
                        "\nSERVICIOS\nDE RED\n",
                        "19:55 - 20:50",
                        R.drawable.sr),
                new Modulo(
                        "\nADMINISTRACIÓN\nDE S.O\n",
                        "17:50 - 18:45",
                        R.drawable.aso),

                new Modulo(
                        "\nSERVICIOS\nDE RED\n",
                        "20:50 - 21:45",
                        R.drawable.sr),

                new Modulo(
                        "HORARIO ESCOLAR 2016/2017 (VIERNES)",
                        " IZQUIERDA - primeras 3 horas\n DERECHA - últimas 3 horas.",
                        R.drawable.hor)
        };

        private static Modulo[] miercoles = {
                new Modulo(
                        "\nEMPRESA E\nI.E\n",
                        "16:00 - 16:55",
                        R.drawable.eie),
                new Modulo(
                        "\nAPLICACIONES\nWEB\n",
                        "19:00 - 19:55",
                        R.drawable.aw),
                new Modulo(
                        "\nSEGURIDAD\nINFORMÁTICA\n",
                        "16:55 - 17:50",
                        R.drawable.si),
                new Modulo(
                        "\nAPLICACIONES\nWEB\n",
                        "19:55 - 20:50",
                        R.drawable.aw),
                new Modulo(
                        "\nSEGURIDAD\nINFORMÁTICA\n",
                        "17:50 - 18:45",
                        R.drawable.si),

                new Modulo(
                        "\nAPLICACIONES\nWEB\n",
                        "20:50 - 21:45",
                        R.drawable.aw),


                new Modulo(
                        "HORARIO ESCOLAR 2016/2017 (MIÉRCOLES)",
                        " IZQUIERDA - primeras 3 horas\n DERECHA - últimas 3 horas.",
                        R.drawable.hor)
        };

    public static Modulo[] getLunes() {
        return lunes;
    }

    public static Modulo[] getMartes() {
        return martes;
    }

    public static Modulo[] getMiercoles() {
        return miercoles;
    }
        public static Modulo[] getJueves() {
                return jueves;
        }

        public static Modulo[] getViernes() {
                return viernes;
        }
}
