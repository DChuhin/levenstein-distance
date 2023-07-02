package com.example.jmh;

import com.example.MinimalDistance;
import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.infra.Blackhole;

public class MinimalDistanceBenchMark {

    private static final String text1 = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus eu nisi id mi tristique iaculis.";
    private static final String text2 = "Lorem ipsum dolor st amet, consecteur adipiscingelit. Vivamus eu nisi id mi tristique iaculit non nunc.";

    @Benchmark
    @Fork(value = 1, warmups = 1)
    @BenchmarkMode(Mode.Throughput)
    public void measureThroughput(Blackhole blackHole) {
        blackHole.consume(MinimalDistance.minimalDistance(text1, text2));
    }

}
