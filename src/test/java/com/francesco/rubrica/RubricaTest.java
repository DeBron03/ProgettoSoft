package com.francesco.rubrica;

import com.francesco.rubrica.Data.Contatto;
import com.francesco.rubrica.Data.Rubrica;
import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class RubricaTest {

    @Test
    public void testAggiungiContatto_SuccessfullyAddsContact() {
        // Given
        Rubrica rubrica = new Rubrica();
        Contatto contatto = new Contatto("Mario", "Rossi");

        // When
        rubrica.aggiungiContatto(contatto);

        // Then
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(1, contatti.size(), "La lista di contatti dovrebbe contenere un solo contatto.");
        assertTrue(contatti.contains(contatto), "Il contatto aggiunto dovrebbe essere presente nella lista.");
    }

    @Test
    public void testEsportaContatto_CreatesValidFile() throws IOException {
        // Given
        Rubrica rubrica = new Rubrica();
        rubrica.aggiungiContatto(new Contatto("Mario", "Rossi", "1234567890", null, null, "mario.rossi@example.com", null, null, null, "Via Roma", null));
        String filePath = "test_export.txt";

        // When
        rubrica.esportaContatto(filePath);

        // Then
        File file = new File(filePath);
        assertTrue(file.exists(), "Il file esportato dovrebbe essere creato.");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String header = reader.readLine();
            assertEquals("NOME; COGNOME; TELEFONO 1; TELEFONO 2; TELEFONO 3; EMAIL1; EMAIL2; EMAIL3; SOCIETA'; INDIRIZZO; COMPLEANNO", header, "L'intestazione non è corretta.");
            String dataLine = reader.readLine();
            assertEquals("Mario;Rossi;1234567890;null;null;mario.rossi@example.com;null;null;null;Via Roma; ;", dataLine, "I dati del contatto esportato non sono corretti.");
        } finally {
            // Cleanup
            file.delete();
        }
    }

    @Test
    public void testEsportaContatto_ThrowsExceptionForInvalidPath() {
        // Given
        Rubrica rubrica = new Rubrica();
        String invalidPath = "/invalid/path/export.txt";

        // When & Then
        IOException exception = assertThrows(IOException.class, () -> rubrica.esportaContatto(invalidPath), "Esportare un contatto su un percorso non valido dovrebbe sollevare un'eccezione.");
        assertEquals("Errore durante l'esportazione dei contatti.", exception.getMessage());
    }

    @Test
    public void testAggiungiContatto_AllowsDuplicateContacts() {
        // Given
        Rubrica rubrica = new Rubrica();
        Contatto contatto = new Contatto("Mario", "Rossi");

        // When
        rubrica.aggiungiContatto(contatto);
        rubrica.aggiungiContatto(contatto);

        // Then
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size(), "La lista di contatti dovrebbe contenere due contatti e permettere contatti duplicati.");
    }

    @Test
    public void testAggiungiContatto_ThrowsExceptionWhenNameAndSurnameEmpty() {
        // Given
        Rubrica rubrica = new Rubrica();

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rubrica.aggiungiContatto(new Contatto("", "")),
                "Aggiungere un contatto senza nome e/o cognome dovrebbe sollevare una IllegalArgumentException."
        );

        assertEquals("Almeno uno tra nome e cognome deve essere fornito.", exception.getMessage());
    }

    @Test
    public void testAggiungiContatto_SingleNullProperty() {
        // Given
        Rubrica rubrica = new Rubrica();
        Contatto contatto = new Contatto("Mario", null);

        // When
        rubrica.aggiungiContatto(contatto);

        // Then
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(1, contatti.size(), "La lista di contatti dovrebbe contenere un contatto con un cognome null");
        assertTrue(contatti.contains(contatto), "Il contatto aggiunto con cognome null dovrebbe essere presente nella lista.");
    }

    @Test
    public void testAggiungiContatto_ThrowsExceptionWhenNullContact() {
        // Given
        Rubrica rubrica = new Rubrica();

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rubrica.aggiungiContatto(null),
                "Aggiungere un contatto null dovrebbe sollevare una IllegalArgumentException."
        );

        assertEquals("Il contatto non può essere null.", exception.getMessage());
    }

    @Test
    public void testAggiungiContatto_MultipleContacts() {
        // Given
        Rubrica rubrica = new Rubrica();
        Contatto contatto1 = new Contatto("Mario", "Rossi");
        Contatto contatto2 = new Contatto("Luigi", "Verdi");

        // When
        rubrica.aggiungiContatto(contatto1);
        rubrica.aggiungiContatto(contatto2);

        // Then
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size(), "La rubrica dovrebbe contenere due contatti.");
        assertTrue(contatti.contains(contatto1), "Il primo contatto aggiunto dovrebbe essere presente nella lista.");
        assertTrue(contatti.contains(contatto2), "Il secondo contatto aggiunto dovrebbe essere presente nella lista.");
    }

    @Test
    public void testImportaContatto_ImportsContactsFromValidFile() throws IOException {
        // Given
        Rubrica rubrica = new Rubrica();
        String filePath = "test_import_valid.txt";
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println("NOME; COGNOME; TELEFONO 1; TELEFONO 2; TELEFONO 3; EMAIL1; EMAIL2; EMAIL3; SOCIETA'; INDIRIZZO; COMPLEANNO");
            writer.println("Mario;Rossi;1234567890;;;mario.rossi@example.com;;;;Via Roma;;2023-01-01");
            writer.println("Luigi;Bianchi;0987654321;;;;;;SocietaABC;Via Milano;;");
        }

        // When
        rubrica.importaContatto(filePath);

        // Then
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size(), "Dovrebbero essere stati importati due contatti.");
        assertEquals("Mario", contatti.get(0).getNome(), "Il primo contatto importato non è corretto.");
        assertEquals("Rossi", contatti.get(0).getCognome(), "Il primo contatto importato non è corretto.");
        assertEquals("Luigi", contatti.get(1).getNome(), "Il secondo contatto importato non è corretto.");
        assertEquals("Bianchi", contatti.get(1).getCognome(), "Il secondo contatto importato non è corretto.");

        // Cleanup
        new File(filePath).delete();
    }

    @Test
    public void testImportaContatto_IgnoresInvalidData() throws IOException {
        // Given
        Rubrica rubrica = new Rubrica();
        String filePath = "test_import_invalid.txt";
        try (PrintWriter writer = new PrintWriter(filePath)) {
            writer.println("NOME; COGNOME; TELEFONO 1; TELEFONO 2; TELEFONO 3; EMAIL1; EMAIL2; EMAIL3; SOCIETA'; INDIRIZZO; COMPLEANNO");
            writer.println("Mario;Rossi;1234567890;;;mario.rossi@example.com;;;;Via Roma;;2023-01-01");
            writer.println(";;;InvalidData;;;"); // Invalid line
            writer.println(";;;;;;;ValidLine;;"); // Will be ignored due to missing required fields
            writer.println("Luigi;Bianchi;0987654321;;;;;;SocietaABC;Via Milano;;");
        }

        // When
        rubrica.importaContatto(filePath);

        // Then
        ObservableList<Contatto> contatti = rubrica.getContatti();
        assertEquals(2, contatti.size(), "Solo due contatti validi dovrebbero essere stati importati.");
        assertEquals("Mario", contatti.get(0).getNome(), "Il primo contatto importato non è corretto.");
        assertEquals("Luigi", contatti.get(1).getNome(), "Il secondo contatto importato non è corretto.");

        // Cleanup
        new File(filePath).delete();
    }
}
