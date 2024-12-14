package com.francesco.rubrica;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContattoTest {

    /**
     * The Contatto class represents a contact entity which includes several details
     * like name, phone numbers, emails, company, address, and birthday. The method
     * being tested, setTelefono1, is used to update the first telephone number of a contact
     * and validates the phone number to ensure it meets the required format.
     */

    @Test
    void testSetTelefono1WithValidPhoneNumber() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String validPhoneNumber = "+12345678901";

        // Act
        contatto.setTelefono1(validPhoneNumber);

        // Assert
        assertEquals(validPhoneNumber, contatto.getTelefono1(), "Telefono1 should match the valid phone number set.");
    }

    @Test
    public void testSetTelefono1WithEmptyPhoneNumber() {
        Contatto contatto = new Contatto("franco","gioia");

        // Controlla che venga lanciata un'eccezione quando il numero di telefono è vuoto
        assertThrows(IllegalArgumentException.class, () -> contatto.setTelefono1(""));
    }


    @Test
    void testSetTelefono1WithNullPhoneNumber() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String nullPhoneNumber = null;

        // Act
        contatto.setTelefono1(nullPhoneNumber);

        // Assert
        assertNull(contatto.getTelefono1(), "Telefono1 should be null when a null phone number is set.");
    }

    @Test
    void testSetTelefono1WithInvalidPhoneNumberContainingLetters() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "123ABC456";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                        contatto.setTelefono1(invalidPhoneNumber),
                "Setting an invalid phone number containing letters should throw an exception."
        );
        assertEquals("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception.getMessage());
    }

    @Test
    void testSetTelefono1WithInvalidPhoneNumberTooShort() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "12345";

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                        contatto.setTelefono1(invalidPhoneNumber),
                "Setting an invalid phone number that is too short should throw an exception."
        );
        assertEquals("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception.getMessage());
    }

    @Test
    void testSetTelefono1WithInvalidPhoneNumberTooLong() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "+12345678901234567890"; // More than 15 digits

        // Act & Assert
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                        contatto.setTelefono1(invalidPhoneNumber),
                "Setting an invalid phone number that is too long should throw an exception."
        );
        assertEquals("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception.getMessage());
    }
}