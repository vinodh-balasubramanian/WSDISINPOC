package com.solvians.showcase.certificate;

import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.solvians.showcase.isin.IsinGenerator;

import java.util.Random;


public class CertificateUpdateGeneratorTest {

    @Test
    void generateQuotesShouldReturnExpectedNumber() {
        IsinGenerator isinGenerator = new IsinGenerator(new Random());
        CertificateUpdateService service = new CertificateUpdateService(isinGenerator);
        CertificateUpdateGenerator generator = new CertificateUpdateGenerator(10, 100, service);

        Stream<String> quotes = generator.generateQuotes();

        assertNotNull(quotes);
        assertEquals(100, quotes.count());
    }
}