import jdk.jfr.Event;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EventosTest {
    String infoPersonas[][] = new String[10][5];
    String salaVip[][] = new String[4][5];
    String salaGeneral[][] = new String[6][5];

    @BeforeEach
    void setup(){
        Eventos.agregarPersona(infoPersonas, "david","20","VIP","1","false");
        Eventos.agregarPersona(infoPersonas, "juan","18","General","0","false");
        Eventos.agregarPersona(infoPersonas, "carlos","10","","5","true");
        Eventos.agregarPersona(infoPersonas, "joseph","10","VIP","5","false");
        Eventos.agregarPersona(infoPersonas, "michael","50","hola","5","true");
        Eventos.agregarPersona(infoPersonas, "samuel","21","VIP","1","false");
        Eventos.agregarPersona(infoPersonas, "jessica","18","VIP","0","false");
    }

    @Test
    void verificarEdad() {
        assertTrue(Eventos.verificarEdad(infoPersonas, 0));
        assertTrue(Eventos.verificarEdad(infoPersonas, 1));
        assertFalse(Eventos.verificarEdad(infoPersonas, 2));
        assertFalse(Eventos.verificarEdad(infoPersonas, 3));
        assertTrue(Eventos.verificarEdad(infoPersonas, 4));
        assertTrue(Eventos.verificarEdad(infoPersonas, 5));
        assertTrue(Eventos.verificarEdad(infoPersonas, 6));

    }

    @Test
    void verificarEntrada() {
        assertEquals("VIP", Eventos.verificarEntrada(infoPersonas, 0));
        assertEquals("General", Eventos.verificarEntrada(infoPersonas, 1));
        assertEquals("", Eventos.verificarEntrada(infoPersonas, 2));
        assertEquals("VIP", Eventos.verificarEntrada(infoPersonas, 3));
        assertEquals("hola", Eventos.verificarEntrada(infoPersonas, 4));
    }

    @Test
    void verificarInvitados() {
        assertTrue(Eventos.verificarInvitados(infoPersonas, 0));
        assertFalse(Eventos.verificarInvitados(infoPersonas, 1));
        assertFalse(Eventos.verificarInvitados(infoPersonas, 2));
        assertFalse(Eventos.verificarInvitados(infoPersonas, 3));
        assertFalse(Eventos.verificarInvitados(infoPersonas, 4));
    }

    @Test
    void ingresarPersona() {
        assertEquals("El estado de ingreso a cambiado a true", Eventos.ingresarPersona(infoPersonas,0,"true"));
        assertEquals("El estado de ingreso a cambiado a true", Eventos.ingresarPersona(infoPersonas,1,"true"));
        assertEquals("El estado de ingreso a cambiado a false", Eventos.ingresarPersona(infoPersonas,2,"false"));
    }

    @Test
    void permitirIngreso() {
        assertTrue(Eventos.permitirIngreso(infoPersonas,salaVip,salaGeneral,0,10));
        assertTrue(Eventos.permitirIngreso(infoPersonas,salaVip,salaGeneral,1,10));
        assertFalse(Eventos.permitirIngreso(infoPersonas,salaVip,salaGeneral,2,10));
        assertFalse(Eventos.permitirIngreso(infoPersonas,salaVip,salaGeneral,3,10));
        assertFalse(Eventos.permitirIngreso(infoPersonas,salaVip,salaGeneral,4,10));
    }
}