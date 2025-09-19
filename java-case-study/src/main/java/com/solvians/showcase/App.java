package com.solvians.showcase;

import com.solvians.showcase.certificate.CertificateUpdateGenerator;
import com.solvians.showcase.certificate.CertificateUpdateService;
import com.solvians.showcase.isin.IsinGenerator;

import java.util.Random;

/**
 * Hello world!
 */
public class App {
    public App(String threads, String quotes) {

    }

    public static void main(String[] args) {
        if (args.length >= 2) {
            int threads = Integer.parseInt(args[0]);
            int quotes = Integer.parseInt(args[1]);
            IsinGenerator isinGenerator = new IsinGenerator(new Random());
            CertificateUpdateService service = new CertificateUpdateService(isinGenerator);

            CertificateUpdateGenerator generator = new CertificateUpdateGenerator(threads, quotes, service);

            generator.generateQuotes()
                    .forEach(System.out::println);

        } else {
            throw new RuntimeException("Expect at least number of threads and number of quotes. But got: " + args);
        }
    }
}
