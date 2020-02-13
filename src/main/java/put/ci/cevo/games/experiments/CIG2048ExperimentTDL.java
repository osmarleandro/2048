package put.ci.cevo.games.experiments;

import org.apache.commons.math3.random.MersenneTwister;
import org.apache.commons.math3.random.RandomDataGenerator;
import put.ci.cevo.games.board.RectSize;
import put.ci.cevo.games.encodings.ntuple.NTuples;
import put.ci.cevo.games.encodings.ntuple.expanders.IdentitySymmetryExpander;
import put.ci.cevo.games.encodings.ntuple.factories.NTuplesAllRectanglesFactory;
import put.ci.cevo.games.encodings.ntuple.factories.NTuplesAllStraightFactory;
import put.ci.cevo.games.game2048.State2048;
import put.ci.cevo.games.game2048.TDLGame2048;
import put.ci.cevo.games.game2048.TDLGame2048.Game2048Outcome;

public class CIG2048ExperimentTDL {

	public static void main(String[] args) {
		RandomDataGenerator random = new RandomDataGenerator(new MersenneTwister(123));

		TDLGame2048 tdlGame2048 = new TDLGame2048();

		NTuples lines = new NTuplesAllStraightFactory(4, State2048.BOARD_SIZE, 15, 0, 0, new IdentitySymmetryExpander())
			.createRandomIndividual(random);
		NTuples squares = new NTuplesAllRectanglesFactory(new RectSize(2), State2048.BOARD_SIZE, 15, 0, 0, new IdentitySymmetryExpander())
			.createRandomIndividual(random);
		NTuples vFunction = lines.add(squares);

		System.out.println(vFunction);
		System.out.println(vFunction.totalWeights());

		for (int i = 0; i <= 100000; i++) {
			tdlGame2048.TDAfterstateLearn(vFunction, 0.001, 0.01, random);
			if (i % 5000 == 0) {
				double performance = 0;
				double ratio = 0;
				int maxTile = 0;
				for (int i1 = 0; i1 < 1000; i1++) {
					Game2048Outcome res = tdlGame2048.playByAfterstates(vFunction, random);

					performance += res.score();
					ratio += (res.maxTile() >= 2048) ? 1 : 0;
					maxTile = Math.max(maxTile, res.maxTile());
				}

				System.out.println(String.format("After %5d games: avg score = %8.2f, avg ratio = %4.2f, maxTile = %5d", i,
					performance / 1000, ratio / 1000, maxTile));
			}
		}
	}

}
