package processing.parsingRules;

import processing.textStructure.Block;
import processing.textStructure.WordResult;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;

public class STtvSeriesParsingRule implements IparsingRule {


//    @Override
//    public int getWordDistance(WordResult first, WordResult second, String[] queryWords) {
//	    //TODO implement me!!!
//    }

	@Override
	public Block parseRawBlock(RandomAccessFile inputFile, long startPos, long endPos) {
		//TODO implement me!!!
	}

	@Override
	public List<Block> parseFile(RandomAccessFile inputFile) {
		//TODO implement me!!!
	}


	@Override
	public void printResult(WordResult wordResult)  {
		//TODO implement me!!!
	}

	@Override
	public String toString() {
		return ParserTypes.ST_TV.name();
	}
}
