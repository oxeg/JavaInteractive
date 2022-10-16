package dev.oxeg.intsorter;

import dev.oxeg.intsorter.oxeg.OxegImplementation;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 1)
@Measurement(iterations = 5, time = 1)
@Fork(1)
@State(Scope.Benchmark)
public class IntSorterBenchmark {
    private final int[] sampleArray = new int[]{
            40, 58, 72, 73, 73,
            67, 86, 25, 65, 50,
            79, 32, 19, 27, 79,
            96, 24, 7, 23, 13,
            86, 38, 14, 21, 67,
            64, 10, 69, 67, 2,
            19, 28, 8, 88, 74,
            90, 43, 10, 33, 27,
            88, 20, 4, 25, 48,
            37, 20, 70, 5, 61,
            72, 58, 53, 31, 21,
            73, 84, 8, 30, 78,
            94, 45, 71, 15, 88,
            95, 66, 97, 39, 68,
            55, 72, 55, 77, 53,
            16, 45, 12, 47, 74,
            22, 89, 20, 41, 62,
            36, 44, 11, 34, 77,
            20, 81, 46, 100, 60,
            96, 35, 46, 55, 96
    };

    private final IntSorter oxegImplementation = new OxegImplementation();

    @Benchmark
    public void oxegImplementation(Blackhole bh) {
        bh.consume(oxegImplementation.sort(sampleArray));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntSorterBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
