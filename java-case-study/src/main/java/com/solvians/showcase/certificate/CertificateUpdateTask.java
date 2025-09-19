package com.solvians.showcase.certificate;

import java.util.concurrent.Callable;

public class CertificateUpdateTask implements Callable<String> {

    private final CertificateUpdateService service;

    public CertificateUpdateTask(CertificateUpdateService service) {
        this.service = service;
    }

    @Override
    public String call() {
        CertificateUpdate update = service.createCertificateUpdate();
        return update.toString();
    }
}
