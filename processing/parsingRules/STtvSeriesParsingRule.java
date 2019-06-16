package processing.parsingRules;

import processing.textStructure.Block;
import processing.textStructure.WordResult;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class STtvSeriesParsingRule implements IparsingRule {

	private long pointer = 0;
	private String episodeTitle;
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
		try {
			inputFile.seek(pointer);
			Pattern blankLinePattern = Pattern.compile("^$");
			Pattern mainNamePattern = Pattern.compile("STAR TREK: THE NEXT GENERATION");
			Pattern episodeTitlePattern = Pattern.compile("\\s*");//TODO to thing about regular expression for the title 
			String line = nextLine(inputFile, blankLinePattern);
			if (!mainNamePattern.matcher(line).find()) {
				//TODO throw new WrongTVepisodException();
			}
			line = nextLine(inputFile, blankLinePattern);
			inputFile.seek(pointer);
			episodeTitle = line;



		} catch (IOException IOEx) {
			//TODO to do something
		}
	}

	private String nextLine(RandomAccessFile inputFile, Pattern blankLinePattern) {
		String line = null;
		try {
			inputFile.seek(pointer);
			line = inputFile.readLine();
			while (blankLinePattern.matcher(line).matches()) {
				line = inputFile.readLine();
			}
			pointer = inputFile.getFilePointer();
		} catch (IOException IOEx) {
			//TODO to do something
		}
		return line;
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
