package com.capgemini.chess.comparator;

import java.util.Comparator;

import com.capgemini.chess.service.to.UserTO;

public class PointsComparator implements Comparator<UserTO> {

	@Override
	public int compare(UserTO o1, UserTO o2) {
		int points1 = o1.getStatistics().getPoints();
		int points2 = o2.getStatistics().getPoints();
		if (points1 > points2) return -1;
		else if (points1 < points2) return 1;
		else return 0;
	}

}
