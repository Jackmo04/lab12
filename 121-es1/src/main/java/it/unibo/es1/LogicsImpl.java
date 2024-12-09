package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogicsImpl implements Logics {

	private final int size;
	private final List<Integer> values;
	private final List<Boolean> enablings;

	public LogicsImpl(final int size) {
		this.size = size;
		this.values = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			this.values.add(0);
		}
		this.enablings = new ArrayList<>(size);
		for (int i = 0; i < size; i++) {
			this.enablings.add(true);
		}
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public List<Integer> values() {
		return this.values;
	}

	@Override
	public List<Boolean> enablings() {
		return this.enablings;
	}

	@Override
	public int hit(int elem) {
		final var value = this.values.get(elem);
		if (value == this.size) {
			return value;
		}
		if (value == this.size - 1) {
			this.enablings.set(elem, false);
		}
		this.values.set(elem, value + 1);
		return value + 1;
	}

	@Override
	public String result() {
		return this.values.stream()
				.map(String::valueOf)
				.collect(Collectors.joining("|", "<<", ">>"));
	}

	@Override
	public boolean toQuit() {
		return this.enablings.stream().allMatch(e -> e == false);
	}
}
