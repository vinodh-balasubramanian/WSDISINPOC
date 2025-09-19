package com.solvians.showcase.isin;


import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import java.util.Random;
import java.util.Set;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;


public class IsinGeneratorTest {

    @Test
    void generatedIsinShouldBeValid() {
        IsinGenerator generator = new IsinGenerator(new Random());
        Isin isin = generator.generate();
        assertTrue(IsinValidator.isValid(isin.getValue()));
    }

    @Test
    void generatedIsinShouldHave12Characters() {
        IsinGenerator generator = new IsinGenerator(new Random());
        Isin isin = generator.generate();
        assertEquals(12, isin.getValue().length());
    }

    @Test
    void multipleGenerationsShouldProduceDifferentValues() {
        IsinGenerator generator = new IsinGenerator(new Random());
        Isin first = generator.generate();
        Isin second = generator.generate();
        assertNotEquals(first.getValue(), second.getValue());
    }

    @Test
    void deterministicWithFixedSeed() {
        Random seeded = new Random(42);
        IsinGenerator generator1 = new IsinGenerator(seeded);
        Random seeded2 = new Random(42);
        IsinGenerator generator2 = new IsinGenerator(seeded2);

        Isin i1 = generator1.generate();
        Isin i2 = generator2.generate();

        assertEquals(i1.getValue(), i2.getValue());
    }

    @RepeatedTest(10)
    void repeatedGenerationsShouldAlwaysBeValid() {
        IsinGenerator generator = new IsinGenerator(new Random());
        Isin isin = generator.generate();
        assertTrue(IsinValidator.isValid(isin.getValue()));
    }

    @Test
    void stressTestManyGenerations() {
        IsinGenerator generator = new IsinGenerator(new Random());
        Set<String> values = new HashSet<>();

        IntStream.range(0, 10000).forEach(i -> {
            Isin isin = generator.generate();
            assertTrue(IsinValidator.isValid(isin.getValue()));
            values.add(isin.getValue());
        });

        assertTrue(values.size() > 9000);
    }
}
