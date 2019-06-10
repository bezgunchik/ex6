package dataStructures.dictionary;

import dataStructures.Aindexer;
import processing.parsingRules.IparsingRule;
import processing.searchStrategies.DictionarySearch;
import processing.textStructure.Corpus;
import processing.textStructure.Entry;
import processing.textStructure.Word;
import utils.WrongMD5ChecksumException;

import java.io.FileNotFoundException;
import java.util.HashMap;

/**
 * An implementation of the abstract Aindexer class, backed by a simple hashmap to store words and their
 * locations within the files.
 */
public class DictionaryIndexer extends Aindexer<DictionarySearch> {

	private HashMap<String, Word> dict;

	/**
	 * Basic constructor, sets origin Corpus and initializes backing hashmap
	 * @param origin    the Corpus to be indexed by this DS.
	 */
	public DictionaryIndexer(Corpus origin) {
		super(origin);
		this.dict = new HashMap<>();
	}

	@Override
	public DictionarySearch asSearchInterface() {
		return null;
	}

	@Override
	protected void indexCorpus() {
		for (Entry entry : this.getCorpus()) {
			getParseRule().parseFile(entry)
		}

	}

	@Override
	protected void readIndexedFile() throws FileNotFoundException, WrongMD5ChecksumException {

	}

//	@Override
//	protected void castRawData(Object readObject) {
//
//	}

	@Override
	protected void writeIndexFile() {

	}

	@Override
	public IparsingRule getParseRule() {
		return null;
	}

	@Override
	protected IndexTypes getIndexType() {
		return null;
	}


}
