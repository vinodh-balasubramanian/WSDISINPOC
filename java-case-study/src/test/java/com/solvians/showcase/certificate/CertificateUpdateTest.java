package com.solvians.showcase.certificate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class CertificateUpdateTest {

    @Test
    void shouldFormatToCsvCorrectly() {
        CertificateUpdate update = new CertificateUpdate(
                1726829374567L, "US1234567892", 123.45, 2000, 150.67, 5000);

        String line = update.toString();

        assertEquals("1726829374567,US1234567892,123.45,2000,150.67,5000", line);
    }
}
