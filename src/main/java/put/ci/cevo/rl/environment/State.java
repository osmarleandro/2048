package put.ci.cevo.rl.environment;

import put.ci.cevo.games.board.RectSize;
import put.ci.cevo.games.game2048.Game2048;

public interface State {

	RectSize BOARD_SIZE = new RectSize(Game2048.SIZE);

	double[] getFeatures();
}
