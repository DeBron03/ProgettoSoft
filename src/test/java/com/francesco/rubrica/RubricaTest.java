package com.francesco.rubrica;

import javafx.collections.ObservableList;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

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
        assertEquals(1, contatti.size(), "The contact list should contain one contact.");
        assertTrue(contatti.contains(contatto), "The added contact should be present in the list.");
    }

    @Test
    public void testAggiungiContatto_ThrowsExceptionWhenNullContact() {
        // Given
        Rubrica rubrica = new Rubrica();

        // When & Then
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> rubrica.aggiungiContatto(null),
                "Adding a null contact should throw an IllegalArgumentException."
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
        assertEquals(2, contatti.size(), "The contact list should contain two contacts.");
        assertTrue(contatti.contains(contatto1), "The first added contact should be present in the list.");
        assertTrue(contatti.contains(contatto2), "The second added contact should be present in the list.");
    }
}