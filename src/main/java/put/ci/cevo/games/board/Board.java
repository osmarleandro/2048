package put.ci.cevo.games.board;

import java.util.Arrays;

public abstract class Board extends SuperType {

	public int[] buffer;

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Board other = (Board) obj;
		return Arrays.equals(buffer, other.buffer);
	}
}
