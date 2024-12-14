package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

    private final Map<Pair<Integer, Integer>, String> asterisks;
    private final int size;

    public LogicsImpl(int size) {
        this.size = size;
        this.asterisks = new HashMap<>();
    }

    @Override
    public String hit(Pair<Integer, Integer> position) {
        return this.asterisks.merge(position, "*", (k, v) -> null);
    }

    @Override
    public boolean toQuit() {
        return isAxisFull(Pair::getX) || isAxisFull(Pair::getY);
    }

    private boolean isAxisFull(Function<Pair<Integer, Integer>, Integer> axis) {
        return this.asterisks.keySet().stream()
            .collect(Collectors.groupingBy(axis, Collectors.counting()))
            .containsValue((long) size);
    }

}
