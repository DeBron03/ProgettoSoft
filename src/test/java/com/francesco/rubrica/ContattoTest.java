package com.francesco.rubrica;

import com.francesco.rubrica.Data.Contatto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContattoTest {

    @Test
    void testIsValidEmailWithValidEmail() {
        assertTrue(Contatto.isValidEmail("test@example.com"), "L'email 'test@example.com' dovrebbe essere valida.");
        assertTrue(Contatto.isValidEmail("user.name+tag+sorting@example.com"), "L'email 'user.name+tag+sorting@example.com' dovrebbe essere valida.");
        assertTrue(Contatto.isValidEmail("email@subdomain.example.com"), "L'email 'email@subdomain.example.com' dovrebbe essere valida.");
    }

    @Test
    void testIsValidEmailWithInvalidEmailMissingDomain() {
        assertFalse(Contatto.isValidEmail("test@"), "L'email 'test@' dovrebbe essere invalida.");
    }

    @Test
    void testIsValidEmailWithInvalidEmailMissingAtSymbol() {
        assertFalse(Contatto.isValidEmail("testexample.com"), "L'email 'testexample.com' dovrebbe essere invalida.");
    }

    @Test
    void testIsValidEmailWithNullEmail() {
        assertTrue(Contatto.isValidEmail(null), "Un'email nulla dovrebbe essere valida.");
    }

    @Test
    void testIsValidEmailWithEmptyEmail() {
        assertTrue(Contatto.isValidEmail(""), "Un'email vuota dovrebbe essere valida.");
        assertTrue(Contatto.isValidEmail("   "), "Un'email con solo spazi vuoti dovrebbe essere valida.");
    }

    @Test
    void testIsValidEmailWithInvalidEmailContainsSpace() {
        assertFalse(Contatto.isValidEmail("test @example.com"), "L'email 'test @example.com' dovrebbe essere invalida.");
        assertFalse(Contatto.isValidEmail("test@ example.com"), "L'email 'test@ example.com' dovrebbe essere invalida.");
    }

    /**
     * The Contatto class represents a contact entity which includes several details
     * like name, phone numbers, emails, company, address, and birthday. The method
     * being tested, setTelefono1, is used to update the first telephone number of a contact
     * and validates the phone number to ensure it meets the required format.
     */

    @Test
    void testSetTelefonoWithValidPhoneNumber() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String validPhoneNumber = "+12345678901";

        // Act
        contatto.setTelefono1(validPhoneNumber);
        contatto.setTelefono2(validPhoneNumber);
        contatto.setTelefono3(validPhoneNumber);

        // Assert
        assertEquals(validPhoneNumber, contatto.getTelefono1(), "Telefono1 dovrebbe corrispondere al numero di telefono inserito.");
        assertEquals(validPhoneNumber, contatto.getTelefono2(), "Telefono2 dovrebbe corrispondere al numero di telefono inserito.");
        assertEquals(validPhoneNumber, contatto.getTelefono3(), "Telefono3 dovrebbe corrispondere al numero di telefono inserito.");
    }

    @Test
    public void testSetTelefono1WithEmptyPhoneNumber() {
        Contatto contatto = new Contatto("franco","gioia");

        // Controlla che venga lanciata un'eccezione quando il numero di telefono è vuoto
        assertTrue(Contatto.isValidPhoneNumber(""));
        assertTrue(Contatto.isValidPhoneNumber("  "));
    }


    @Test
    void testSetTelefonoWithNullPhoneNumber() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String nullPhoneNumber = null;

        // Act
        contatto.setTelefono1(nullPhoneNumber);
        contatto.setTelefono2(nullPhoneNumber);
        contatto.setTelefono3(nullPhoneNumber);

        // Assert
        assertNull(contatto.getTelefono1(), "Telefono1 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getTelefono2(), "Telefono2 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getTelefono3(), "Telefono3 dovrebbe essere null dopo l'impostazione su null.");
    }

    @Test
    void testSetTelefonoWithInvalidPhoneNumberContainingLetters() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "123ABC456";

        // Act & Assert
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono1(invalidPhoneNumber), "Inserire un numero con lettere dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono2(invalidPhoneNumber), "Inserire un numero con lettere dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono2 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono3(invalidPhoneNumber), "Inserire un numero con lettere dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono3 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception3.getMessage());
    }

    @Test
    void testSetTelefonoWithInvalidPhoneNumberTooShort() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "12345";

        // Act & Assert
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono1(invalidPhoneNumber), "Inserire un numero troppo breve dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono2(invalidPhoneNumber), "Inserire un numero troppo breve dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono2 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono3(invalidPhoneNumber), "Inserire un numero troppo breve dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono3 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception3.getMessage());
    }

    @Test
    void testSetTelefonoWithInvalidPhoneNumberTooLong() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "+12345678901234567890"; // More than 15 digits

        // Act & Assert
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono1(invalidPhoneNumber), "Inserire un numero troppo lungo dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono1 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono2(invalidPhoneNumber), "Inserire un numero troppo lungo dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono2 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setTelefono3(invalidPhoneNumber), "Inserire un numero troppo lungo dovrebbe lanciare un'eccezione.");
        assertEquals("Telefono3 non valido. Deve contenere solo numeri e può includere un prefisso +.", exception3.getMessage());
    }
    @Test
    void testSetEmailWithInvalidEmail() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidEmail = "test@";

        // Act & Assert
        IllegalArgumentException exception1 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setEmail1(invalidEmail), "Inserire un'email senza dominio dovrebbe lanciare un'eccezione.");
        assertEquals("Email1 non valida.", exception1.getMessage());

        IllegalArgumentException exception2 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setEmail2(invalidEmail), "Inserire un'email senza dominio dovrebbe lanciare un'eccezione.");
        assertEquals("Email2 non valida.", exception2.getMessage());

        IllegalArgumentException exception3 = assertThrows(IllegalArgumentException.class, () ->
                contatto.setEmail3(invalidEmail), "Inserire un'email senza dominio dovrebbe lanciare un'eccezione.");
        assertEquals("Email3 non valida.", exception3.getMessage());
    }
    @Test
    void testSetEmailWithNullEmail() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String nullEmail = null;

        // Act
        contatto.setEmail1(nullEmail);
        contatto.setEmail2(nullEmail);
        contatto.setEmail3(nullEmail);

        // Assert
        assertNull(contatto.getEmail1(), "Email1 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getEmail2(), "Email2 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getEmail3(), "Email3 dovrebbe essere null dopo l'impostazione su null.");
    }
    @Test
    void testSetEmailWithValidEmail() {
        // Arrange
        Contatto contatto = new Contatto("Francesco", "Rossi");
        String validEmail = "test@example.com";

        // Act
        contatto.setEmail1(validEmail);
        contatto.setEmail2(validEmail);
        contatto.setEmail3(validEmail);

        // Assert
        assertEquals(validEmail, contatto.getEmail1(), "Email1 dovrebbe corrispondere all'email inserita.");
        assertEquals(validEmail, contatto.getEmail2(), "Email2 dovrebbe corrispondere all'email inserita.");
        assertEquals(validEmail, contatto.getEmail3(), "Email3 dovrebbe corrispondere all'email inserita.");
    }
}