package com.solvians.showcase.certificate;

import com.solvians.showcase.isin.IsinGenerator;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


class CertificateUpdateServiceTest {

    @Test
    void shouldCreateValidCertificateUpdate() {
        CertificateUpdateService service = new CertificateUpdateService(new IsinGenerator(new Random()));
        CertificateUpdate update = service.createCertificateUpdate();

        assertNotNull(update.getIsin());
        assertTrue(update.getBidPrice() >= 100.0 && update.getBidPrice() <= 200.0);
        assertTrue(update.getAskPrice() >= 100.0 && update.getAskPrice() <= 200.0);
        assertTrue(update.getBidSize() >= 1000 && update.getBidSize() <= 5000);
        assertTrue(update.getAskSize() >= 1000 && update.getAskSize() <= 10000);
    }


}
