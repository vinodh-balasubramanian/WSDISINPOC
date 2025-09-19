package com.solvians.showcase.certificate;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class CertificateUpdateGenerator {
    private final int threads;
    private final int quotes;
    private final CertificateUpdateService service;

    public CertificateUpdateGenerator(int threads, int quotes, CertificateUpdateService service) {
        this.threads = threads;
        this.quotes = quotes;
        this.service = service;
    }

    // TODO: Optimize thread pool sizing.
    // have a validation to verify For cPu bound tasks and io bound to avoid limit the size of thraeds

    public Stream<CertificateUpdate> generateQuotes() {
        ExecutorService executor = Executors.newFixedThreadPool(threads);
        try {
            List<Future<CertificateUpdate>> futures = IntStream.range(0, quotes)
                    .mapToObj(i -> executor.submit(service::createCertificateUpdate))
                    .collect(Collectors.toList());

            return futures.stream().map(f -> {
                try {
                    return f.get();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        } finally {
            executor.shutdown();
        }
    }

}
