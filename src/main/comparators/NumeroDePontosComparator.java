package main.comparators;

import java.util.Comparator;

import main.entities.Time;

public class NumeroDePontosComparator implements Comparator<Time>{
	
	@Override
	public int compare(Time time1, Time time2) {
		if (time1.getPontuacao() > time2.getPontuacao()) {
			return -1;
		}
		if (time1.getPontuacao() < time2.getPontuacao()) {
			return 1;
		}
		return 0;
	}
}