package test;

import static org.junit.jupiter.api.Assertions.*;

import data.Contatto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class ContattoTest {

    private Contatto contatto;

    @BeforeEach
    void setUp() {
        contatto = new Contatto("Mario", "Rossi");
    }

    @Test
    void testCostruttoreEssenzialeValido() {
        Contatto c = new Contatto("Luigi", "Verdi");
        assertEquals("Luigi", c.getNome());
        assertEquals("Verdi", c.getCognome());
    }

    @Test
    void testCostruttoreEssenzialeInvalido() {
        assertThrows(IllegalArgumentException.class, () -> new Contatto(null, null));
        assertThrows(IllegalArgumentException.class, () -> new Contatto("", ""));
    }

    @Test
    void testSetTelefono1Valido() {
        contatto.setTelefono1("+1234567890");
        assertEquals("+1234567890", contatto.getTelefono1());
    }

    @Test
    void testSetTelefono1Invalido() {
        assertThrows(IllegalArgumentException.class, () -> contatto.setTelefono1("12345abc"));
    }

    @Test
    void testSetEmailValida() {
        contatto.setEmail1("test@example.com");
        assertEquals("test@example.com", contatto.getEmail1());
    }

    @Test
    void testSetEmailInvalida() {
        assertThrows(IllegalArgumentException.class, () -> contatto.setEmail1("email_non_valida"));
    }

    @Test
    void testSetCompleannoValido() {
        LocalDate compleanno = LocalDate.of(1990, 1, 1);
        contatto.setCompleanno(compleanno);
        assertEquals(compleanno, contatto.getCompleanno());
    }

    @Test
    void testSetNome() {
        contatto.setNome("Giuseppe");
        assertEquals("Giuseppe", contatto.getNome());
    }

    @Test
    void testSetSocietà() {
        contatto.setSocietà("PeppeBrescia S.r.l.");
        assertEquals("PeppeBrescia S.r.l.", contatto.getSocietà());
    }

    @Test
    void testCostruttoreCompletoValido() {
        LocalDate compleanno = LocalDate.of(1985, 5, 20);
        Contatto c = new Contatto(
                "Anna", "Bianchi",
                "+1234567890","+0987654321", "+1122334455",
                "anna.bianchi@example.com", "contact@work.com", null,
                "Azienda S.p.A.", "Via Roma, 1", compleanno
        );
        assertEquals("Anna", c.getNome());
        assertEquals("Bianchi", c.getCognome());
        assertEquals("+1234567890", c.getTelefono1());
        assertEquals("anna.bianchi@example.com", c.getEmail1());
        assertEquals("Azienda S.p.A.", c.getSocietà());
        assertEquals(compleanno, c.getCompleanno());
    }
}