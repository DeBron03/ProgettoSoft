package test;

import data.Contatto;
import data.Rubrica;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RubricaTest {
    private Rubrica rubrica;

    @BeforeEach
    void setUp() {
        rubrica = new Rubrica("RubricaTest");
    }

    @Test
    void testAggiungiContatto() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario@rossi.com", "", "", "Azienda", "Via Roma", LocalDate.of(1990, 1, 1));
        rubrica.aggiungiContatto(contatto);

        assertEquals(1, rubrica.ricercaContatto("Mario").size());
        assertEquals("Mario", rubrica.ricercaContatto("Mario").get(0).getNome());
    }

    @Test
    void testRicercaContatto() {
        rubrica.aggiungiContatto(new Contatto("Mario", "Rossi", "123456789", "", "", "mario@rossi.com", "", "", "Azienda", "Via Roma", LocalDate.of(1990, 1, 1)));
        rubrica.aggiungiContatto(new Contatto("Maria", "Verdi", "987654321", "", "", "maria@verdi.com", "", "", "Banca", "Via Milano", LocalDate.of(1985, 5, 15)));

        List<Contatto> risultati = rubrica.ricercaContatto("Mar");
        assertEquals(2, risultati.size());

        risultati = rubrica.ricercaContatto("Rossi");
        assertEquals(1, risultati.size());
        assertEquals("Mario", risultati.get(0).getNome());
    }

    @Test
    void testEliminaContatto() {
        Contatto contatto = new Contatto("Mario", "Rossi", "123456789", "", "", "mario@rossi.com", "", "", "Azienda", "Via Roma", LocalDate.of(1990, 1, 1));
        rubrica.aggiungiContatto(contatto);
        assertEquals(1, rubrica.ricercaContatto("Mario").size());

        rubrica.eliminaContatto(contatto);
        assertEquals(0, rubrica.ricercaContatto("Mario").size());
    }

    @Test
    void testModificaContatto() {
        Contatto originale = new Contatto("Mario", "Rossi", "123456789", "", "", "mario@rossi.com", "", "", "Azienda", "Via Roma", LocalDate.of(1990, 1, 1));
        Contatto modificato = new Contatto("Mario", "Bianchi", "123456789", "", "", "mario@rossi.com", "", "", "Azienda", "Via Roma", LocalDate.of(1990, 1, 1));

        rubrica.aggiungiContatto(originale);
        rubrica.modificaContatto(originale, modificato);

        assertEquals(1, rubrica.ricercaContatto("Bianchi").size());
        assertEquals("Bianchi", rubrica.ricercaContatto("Bianchi").get(0).getCognome());
    }

    @Test
    void testEsportaContatti() throws IOException {
        rubrica.aggiungiContatto(new Contatto("Mario", "Rossi", "123456789", "", "", "mario@rossi.com", "", "", "Azienda", "Via Roma", LocalDate.of(1990, 1, 1)));

        String filename = "rubrica_test.csv";
        rubrica.esportaContatto(filename);

        // Verifica che il file venga creato (puoi approfondire leggendo il contenuto)
        assertTrue(new java.io.File(filename).exists());
    }

    @Test
    void testImportaContatti() throws IOException {
        String filename = "rubrica_test.csv";

        // Crea un file temporaneo per l'importazione
        try (PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(filename)))) {
            writer.println("NOME;COGNOME;TELEFONO 1;TELEFONO 2;TELEFONO 3;EMAIL1;EMAIL2;EMAIL3;SOCIETA';INDIRIZZO;COMPLEANNO");
            writer.println("Mario;Rossi;123456789;;;" +
                    "mario@rossi.com;;;Azienda;Via Roma;1990-01-01");
        }

        // Importa i contatti
        Rubrica nuovaRubrica = rubrica.importaContatto(filename);

        // Verifica i risultati
        assertEquals(1, nuovaRubrica.ricercaContatto("Mario").size());
        assertEquals("Mario", nuovaRubrica.ricercaContatto("Mario").get(0).getNome());

        // Elimina il file temporaneo
       // new File(filename).delete();
    }
}