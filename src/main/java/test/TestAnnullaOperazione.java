package test;

import annullaoperazione.AnnullaOperazione;
import data.Contatto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnnullaOperazioneTest {
    private AnnullaOperazione annullaOperazione;
    private List<Contatto> statoCorrente;

    @BeforeEach
    void setUp() {
        // Inizializzazione degli oggetti prima di ogni test
        annullaOperazione = new AnnullaOperazione();
        statoCorrente = new ArrayList<>();
        statoCorrente.add(new Contatto("Mario", "Rossi", null, null , null, "mario.rossi@example.com", null , null , null , null , null));
        statoCorrente.add(new Contatto("Luigi", "Bianchi", null, null , null, "gigi.bianchi@example.com", null , null , null , null , null));
    }

    @Test
    void testSalvaStato() {
        // Salva lo stato corrente
        annullaOperazione.salvaStato(statoCorrente);

        // Verifica che lo stato salvato sia corretto e indipendente
        List<Contatto> statoSalvato = annullaOperazione.annulla();
        assertNotNull(statoSalvato);
        assertEquals(statoCorrente.size(), statoSalvato.size());
        assertEquals(statoCorrente.get(0), statoSalvato.get(0));
        assertEquals(statoCorrente.get(1), statoSalvato.get(1));

        // Modifica lo stato corrente e verifica che lo stato salvato non cambi
        statoCorrente.get(0).setEmail1("nuova.email@example.com");
        statoCorrente.get(1).setEmail2("peppe.email@example.com");
        assertNotEquals(statoCorrente.get(0).getEmail1(), statoSalvato.get(1).getEmail2());
    }

    @Test
    void testAnnullaSenzaSalvataggio() {
        // Annulla senza aver salvato alcuno stato
        List<Contatto> statoAnnullato = annullaOperazione.annulla();
        assertNotNull(statoAnnullato);
        assertTrue(statoAnnullato.isEmpty());
    }

    @Test
    void testAnnullaDopoSalvataggio() {
        // Salva lo stato corrente
        annullaOperazione.salvaStato(statoCorrente);

        // Ripristina lo stato
        List<Contatto> statoRipristinato = annullaOperazione.annulla();
        assertNotNull(statoRipristinato);
        assertEquals(2, statoRipristinato.size());
        assertEquals("Mario", statoRipristinato.get(0).getNome());
        assertEquals("Luigi", statoRipristinato.get(1).getNome()); 
    }
}