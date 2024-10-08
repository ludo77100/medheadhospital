package com.medhead.hospitalmicroservice.services;

import com.medhead.hospitalmicroservice.entities.Bed;
import com.medhead.hospitalmicroservice.entities.Speciality;
import com.medhead.hospitalmicroservice.repositories.BedRepository;
import com.medhead.hospitalmicroservice.services.impls.BedServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class BedServiceTest {

    @Mock
    private BedRepository bedRepository;

    @InjectMocks
    private BedServiceImpl bedServiceImpl;

    @Test
    void testExtractIntAfterLastB_ValidInput() {
        String input = "1-22-B01";
        int expected = 1;
        assertEquals(expected, bedServiceImpl.extractInt(input));
    }

    @Test
    void testExtractIntAfterLastB_ValidInputDifferentNumber() {
        String input = "1-22-B12";
        int expected = 12;
        assertEquals(expected, bedServiceImpl.extractInt(input));
    }

    @Test
    void testExtractIntAfterLastB_NoBCharacter() {
        String input = "1-22-C12";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bedServiceImpl.extractInt(input);
        });
        assertTrue(exception.getMessage().contains("Le format de chaîne n'est pas valide ou il n'y a pas de caractère après 'B'"));
    }

    @Test
    void testExtractIntAfterLastB_InvalidNumberFormat() {
        String input = "1-22-BXYZ";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bedServiceImpl.extractInt(input);
        });
        assertTrue(exception.getMessage().contains("Les caractères après 'B' ne sont pas un nombre valide"));
    }

    @Test
    void testExtractIntAfterLastB_EmptyString() {
        String input = "";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bedServiceImpl.extractInt(input);
        });
        assertTrue(exception.getMessage().contains("Le format de chaîne n'est pas valide ou il n'y a pas de caractère après 'B'"));
    }

    @Test
    void testExtractIntAfterLastB_BAtEndWithoutNumber() {
        String input = "1-22-B";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            bedServiceImpl.extractInt(input);
        });
        assertTrue(exception.getMessage().contains("Le format de chaîne n'est pas valide ou il n'y a pas de caractère après 'B'"));
    }

}
