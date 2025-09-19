package com.solvians.showcase.certificate;

import com.solvians.showcase.isin.Isin;
import com.solvians.showcase.isin.IsinGenerator;

import java.util.concurrent.ThreadLocalRandom;


public class CertificateUpdateService {

    private final IsinGenerator isinGenerator;

    public CertificateUpdateService(IsinGenerator isinGenerator) {
        this.isinGenerator = isinGenerator;
    }

    public CertificateUpdate createCertificateUpdate() {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        long timestamp = System.currentTimeMillis();
        Isin isin = isinGenerator.generate();
        return getCertificateUpdate(rnd, timestamp, isin);
    }

    private CertificateUpdate getCertificateUpdate(ThreadLocalRandom rnd, long timestamp, Isin isin) {
        double bidPrice = round(rnd.nextDouble(100.0, 200.0));
        int bidSize = rnd.nextInt(1000, 5001);
        double askPrice = round(rnd.nextDouble(100.0, 200.0));
        int askSize = rnd.nextInt(1000, 10001);
        CertificateUpdate certificateUpdate = new CertificateUpdate(timestamp, isin.getValue(), bidPrice, bidSize, askPrice, askSize);
        return certificateUpdate;
    }


    private double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}
