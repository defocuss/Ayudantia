import javax.swing.*;

class Eventos {
    public static void main(String[] args) {
        String infoPersonas[][] = new String[10][5];
        String salaVip[][] = new String[4][5];
        String salaGeneral[][] = new String[6][5];
    }
    public static boolean agregarPersona(String [][] matriz,String nombre, String edad, String entrada, String invitados, String ingresado){
        for (int i = 0; i < matriz.length; i++ ) {
            if (matriz[i][0] == null) {
                matriz[i][0] = nombre;
                matriz[i][1] = edad;
                matriz[i][2] = entrada;
                matriz[i][3] = invitados;
                matriz[i][4] = ingresado;
                return true;
            }
        }
        return false;
    }
    public static boolean verificarEdad(String[][]matriz, int numeroDeFila){
        int edad = Integer.parseInt(matriz[numeroDeFila][1]);
        if (edad >= 18) {
            return true;
        }
        return false;
    }
    public static String verificarEntrada(String[][]matriz, int numeroDeFila){
        return matriz[numeroDeFila][2];
    }
    public static boolean verificarInvitados(String[][]matriz, int numeroDeFila){
        if (matriz[numeroDeFila][2].equals("VIP")) {
            if (Integer.parseInt(matriz[numeroDeFila][3]) > 2) {
                return false;
            } else if ( 0 <= Integer.parseInt(matriz[numeroDeFila][3]) && Integer.parseInt(matriz[numeroDeFila][3]) <= 2) {
                return true;
            }
        }
        return false;
    }
    public static String ingresarPersona(String [][] matriz, int numeroDeFila, String nuevoEstadoIngreso){
        matriz[numeroDeFila][3] = nuevoEstadoIngreso;
        if (nuevoEstadoIngreso.equals("false")) {
            return "El estado de ingreso a cambiado a false";
        }
        else return "El estado de ingreso a cambiado a true";
    }
    public static boolean permitirIngreso(String [][] infoPersonas,String [][] salaVip,String [][] salaGeneral, int numeroDeFila,int aforoSala){
        int invitadoMasAcompanante = Integer.parseInt(infoPersonas[numeroDeFila][3]) + 1;
        if (verificarEdad(infoPersonas, numeroDeFila)) {
            if (verificarEntrada(infoPersonas, numeroDeFila).equals("VIP")) {
                if (verificarInvitados(infoPersonas, numeroDeFila)) {
                    if (aforoDispobible(infoPersonas,"VIP", aforoSala) >= invitadoMasAcompanante) {
                        ingresarPersona(infoPersonas, numeroDeFila, "true");
                        return true;
                    }
                }
            } else if (verificarEntrada(infoPersonas, numeroDeFila).equals("General")) {
                if (!verificarInvitados(infoPersonas, numeroDeFila)) {
                    if (aforoDispobible(infoPersonas,"General",aforoSala) >= 1) {
                        ingresarPersona(infoPersonas, numeroDeFila, "true");
                        return true;
                    }
                }
            }
        }ingresarPersona(infoPersonas, numeroDeFila, "false");
        return false;
    }
    public static int aforoDispobible(String [][] matriz,String entrada, int aforoSala){
        int aforoSalaContador = aforoSala;
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][2] == entrada) {
                if(matriz[i][4].equals("true")){
                    aforoSalaContador--;
                }


            }
        }
        return aforoSalaContador;
    }
}