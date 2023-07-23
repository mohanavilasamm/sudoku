package com.sudoku.core.common;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class SudokuValueAssister {
	
	public static Set<Integer> getUsedValues(int[] currentRow, int[] currentColumn, int[] currentSection) {
		Set<Integer> usedValues = new HashSet<>();
		for (int i = 0; i < currentRow.length; i++) {
			if (currentRow[i] != 0)
				usedValues.add(currentRow[i]);
			if (currentColumn[i] != 0)
				usedValues.add(currentColumn[i]);
			if (currentSection[i] != 0)
				usedValues.add(currentSection[i]);
		}
		return usedValues;
	}
	
	public static List<Integer> getAvailableValues(Set<Integer> usedValues, List<Integer> allowedValues) {
		List<Integer> availableValues = new ArrayList<>();
		for (int i = 0; i < 9; i++) {
			if (!usedValues.contains(allowedValues.get(i)))
				availableValues.add(allowedValues.get(i));
		}
		return availableValues;
	}

}
