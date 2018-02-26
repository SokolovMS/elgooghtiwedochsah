package com.eight.zero.three.output;

import com.eight.zero.three.Slice;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Output {
    private final int s;
    private final List<Slice> slices;

    public Output(final int s, final List<Slice> slices) {
        this.s = s;
        this.slices = slices;
    }

    public Output(final int s, final Slice... slices) {
        this.s = s;
        this.slices = Arrays.asList(slices);
    }

    public int getS() {
        return s;
    }

    public List<Slice> getSlices() {
        return slices;
    }

    @Override
    public String toString() {
        String slicesStr = slices.stream().map(Slice::toString).collect(Collectors.joining("\n"));
        return s + "\n" + slicesStr;
    }
}
