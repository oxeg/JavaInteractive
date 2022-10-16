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
    static final int[] SAMPLE_ARRAY = new int[]{
            109, 869, 472, 597, 698,
            258, 495, 907, 494, 346,
            183, 960, 315, 413, 536,
            319, 407, 621, 91, 309,
            580, 429, 260, 525, 868,
            852, 242, 583, 491, 559,
            986, 639, 643, 283, 766,
            514, 790, 158, 544, 461,
            551, 28, 29, 867, 138,
            529, 983, 611, 195, 65,
            449, 762, 63, 672, 722,
            874, 209, 383, 389, 673,
            493, 635, 117, 257, 673,
            235, 109, 228, 118, 949,
            562, 368, 307, 857, 695,
            420, 901, 918, 124, 950,
            631, 117, 995, 767, 143,
            276, 990, 937, 60, 592,
            702, 151, 717, 471, 725,
            539, 719, 335, 761, 365
    };

    final IntSorter oxegImplementation = new OxegImplementation();

    @Benchmark
    public void oxegImplementation(Blackhole bh) {
        bh.consume(oxegImplementation.sort(SAMPLE_ARRAY));
    }

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(IntSorterBenchmark.class.getSimpleName())
                .build();

        new Runner(opt).run();
    }
}
