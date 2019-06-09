package processing.searchStrategies;

import processing.textStructure.Block;
import processing.textStructure.Corpus;
import processing.textStructure.Entry;
import processing.textStructure.WordResult;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.ArrayList;
import java.util.List;

public class NaiveSearch implements IsearchStrategy {
	private Corpus origin;
	public NaiveSearch(Corpus origin) {
		this.origin = origin;
	}


	/**
	 * The main search method to comply with the IsearchStrategy interface
	 * @param query The query string to search for.
	 * @return  A list of wordResults
	 */
	@Override
	public List<WordResult> search(String query) {
		List<WordResult> results = new ArrayList<>();
		Matcher matcher;
		Pattern pattern = Pattern.compile(query);
		for (Entry entry : origin) {
			for (Block block : entry) {
				matcher = pattern.matcher(block.toString());
				while (matcher.find()) {
					results.add(new WordResult(block, query, matcher.start()));
				}
			}
		}
		return results;
	}

}
