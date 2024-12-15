package com.francesco.rubrica;

import com.francesco.rubrica.Data.Contatto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContattoTest {

    @Test
    void testemailValidaEmailWithValidEmail() {
        assertTrue(Contatto.emailValida("test@example.com"), "L'email 'test@example.com' dovrebbe essere valida.");
        assertTrue(Contatto.emailValida("user.name+tag+sorting@example.com"), "L'email 'user.name+tag+sorting@example.com' dovrebbe essere valida.");
        assertTrue(Contatto.emailValida("email@subdomain.example.com"), "L'email 'email@subdomain.example.com' dovrebbe essere valida.");
    }

    @Test
    void testemailValidaWithInvalidEmailMissingDomain() {
        assertFalse(Contatto.emailValida("test@"), "L'email 'test@' dovrebbe essere invalida.");
    }

    @Test
    void testemailValidaWithInvalidEmailMissingAtSymbol() {
        assertFalse(Contatto.emailValida("testexample.com"), "L'email 'testexample.com' dovrebbe essere invalida.");
    }

    @Test
    void testemailValidalWithNullEmail() {
        assertTrue(Contatto.emailValida(null), "Un'email nulla dovrebbe essere valida.");
    }

    @Test
    void testemailValidalWithEmptyEmail() {
        assertTrue(Contatto.emailValida(""), "Un'email vuota dovrebbe essere valida.");
        assertTrue(Contatto.emailValida("   "), "Un'email con solo spazi vuoti dovrebbe essere valida.");
    }

    @Test
    void testemailValidalWithInvalidEmailContainsSpace() {
        assertFalse(Contatto.emailValida("test @example.com"), "L'email 'test @example.com' dovrebbe essere invalida.");
        assertFalse(Contatto.emailValida("test@ example.com"), "L'email 'test@ example.com' dovrebbe essere invalida.");
    }

    /**
     * The Contatto class represents a contact entity which includes several details
     * like name, phone numbers, emails, company, address, and birthday. The method
     * being tested, setTelefono1, is used to update the first telephone number of a contact
     * and validates the phone number to ensure it meets the required format.
     */

    @Test
    void testSetTelefonoWithValidPhoneNumber() {

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String validPhoneNumber = "+12345678901";


        contatto.setTelefono1(validPhoneNumber);
        contatto.setTelefono2(validPhoneNumber);
        contatto.setTelefono3(validPhoneNumber);


        assertEquals(validPhoneNumber, contatto.getTelefono1(), "Telefono1 dovrebbe corrispondere al numero di telefono inserito.");
        assertEquals(validPhoneNumber, contatto.getTelefono2(), "Telefono2 dovrebbe corrispondere al numero di telefono inserito.");
        assertEquals(validPhoneNumber, contatto.getTelefono3(), "Telefono3 dovrebbe corrispondere al numero di telefono inserito.");
    }

    @Test
    public void testSetTelefono1WithEmptyPhoneNumber() {
        Contatto contatto = new Contatto("franco","gioia");


        assertTrue(Contatto.numeroValido(""));
        assertTrue(Contatto.numeroValido("  "));
    }


    @Test
    void testSetTelefonoWithNullPhoneNumber() {

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String nullPhoneNumber = null;


        contatto.setTelefono1(nullPhoneNumber);
        contatto.setTelefono2(nullPhoneNumber);
        contatto.setTelefono3(nullPhoneNumber);


        assertNull(contatto.getTelefono1(), "Telefono1 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getTelefono2(), "Telefono2 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getTelefono3(), "Telefono3 dovrebbe essere null dopo l'impostazione su null.");
    }

    @Test
    void testSetTelefonoWithInvalidPhoneNumberContainingLetters() {

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "123ABC456";


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

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "12345";


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

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidPhoneNumber = "+12345678901234567890";


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

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String invalidEmail = "test@";


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

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String nullEmail = null;


        contatto.setEmail1(nullEmail);
        contatto.setEmail2(nullEmail);
        contatto.setEmail3(nullEmail);


        assertNull(contatto.getEmail1(), "Email1 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getEmail2(), "Email2 dovrebbe essere null dopo l'impostazione su null.");
        assertNull(contatto.getEmail3(), "Email3 dovrebbe essere null dopo l'impostazione su null.");
    }
    @Test
    void testSetEmailWithValidEmail() {

        Contatto contatto = new Contatto("Francesco", "Rossi");
        String validEmail = "test@example.com";


        contatto.setEmail1(validEmail);
        contatto.setEmail2(validEmail);
        contatto.setEmail3(validEmail);


        assertEquals(validEmail, contatto.getEmail1(), "Email1 dovrebbe corrispondere all'email inserita.");
        assertEquals(validEmail, contatto.getEmail2(), "Email2 dovrebbe corrispondere all'email inserita.");
        assertEquals(validEmail, contatto.getEmail3(), "Email3 dovrebbe corrispondere all'email inserita.");
    }
}