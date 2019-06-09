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
		return pick(query);
	}

	/**
	 * Searches query string in corpus
	 * @param query The query string to search for.
	 * @return  A list of wordResults
	 */
	private List<WordResult> pick(String query) {
		List<WordResult> results = new ArrayList<>();
		for (Entry entry : this.getCorpus()) {
			for (Block block : entry) {
				results.addAll(this.applyAlgorithm(query, block));
			}
		}
		return results;
	}

	/**
	 * Applies the search algorithm to the block
	 * @param query The query string to search for.
	 * @param block The block to search in
	 * @return A list of wordResults
	 */
	protected List<WordResult> applyAlgorithm(String query, Block block) {
		List<WordResult> results = new ArrayList<>();
		Pattern pattern = Pattern.compile(query);
		Matcher matcher = pattern.matcher(block.toString());
		while (matcher.find()) {
			results.add(new WordResult(block, query, matcher.start()));
		}
		return results;
	}

	/**
	 * Returns the corpus searcher works with
	 * @return The corpus searcher works with
	 */
	protected Corpus getCorpus() {
		return this.origin;
	}

}
