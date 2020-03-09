package put.ci.cevo.games.encodings.ntuple;

import put.ci.cevo.games.board.Board;
import put.ci.cevo.games.encodings.ntuple.eval.NTupleBoardEvaluator;

public class DefaultNTupleEvaluator implements NTupleBoardEvaluator {

	@Override
	public double evaluate(NTuples tuples, Board board) {
		double result = 0;
		for (NTuple tuple : tuples.getAll()) {
			result += tuple.valueFor(board);
		}
		return result;
	}

}