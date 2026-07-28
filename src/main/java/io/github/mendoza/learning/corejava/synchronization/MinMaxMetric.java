package io.github.mendoza.learning.corejava.synchronization;

public class MinMaxMetric {
    private volatile long min;
    private volatile long max;

    public MinMaxMetric() {
        this.min = Long.MAX_VALUE;
        this.max = Long.MIN_VALUE;
    }

    public synchronized void addSample(long newSample) {
        this.min = Math.min(min, newSample);
        this.max = Math.max(max, newSample);
    }

    public long getMin()    {
        return this.min;
    }

    public long getMax() {
        return this.max;
    }
}
