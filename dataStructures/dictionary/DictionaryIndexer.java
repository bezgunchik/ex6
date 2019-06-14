package dataStructures.dictionary;

import dataStructures.Aindexer;
import processing.parsingRules.IparsingRule;
import processing.searchStrategies.DictionarySearch;
import processing.textStructure.Block;
import processing.textStructure.Corpus;
import processing.textStructure.Entry;
import processing.textStructure.Word;
import utils.Stemmer;
import utils.WrongMD5ChecksumException;

import java.io.*;
import java.util.HashMap;
import java.util.List;

/**
 * An implementation of the abstract Aindexer class, backed by a simple hashmap to store words and their
 * locations within the files.
 */
public class DictionaryIndexer extends Aindexer<DictionarySearch> {

	private HashMap<String, List<Word>> dict;

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
		Stemmer stemmer = new Stemmer();
		for (Entry entry : this.getCorpus()) {
			for (Block block : entry) {
				try {
					block.getRAF().seek(block.getStartIndex());
					String line;
					String[] words;
					while ((line = block.getRAF().readLine()) != null)  {
						words = line.split("\\W");
						for (String word : words) {
							String base = stemmer.stem(word);
							long strIndex = block.getRAF().getFilePointer();
							// TODO now the end index is the start index + length of the original word (may be it should be length of the base)
							dict.get(base).add(new Word(block, strIndex, strIndex + word.length()));
						}
					}

				} catch (IOException IOEx) {
					// TODO to do something
				}
			}
//			getParseRule().parseFile(entry)
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
		String parserName = "???"; //TODO to understand how to extract this name and replace it in lower lines (also to check is it ok to use getCorpus().toString() for corpus name
		try {
			OutputStream fos = new FileOutputStream(getIndexType().name() + "_" + parserName +
					"_" + getCorpus().toString() + ".cache");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dict);

		} catch (FileNotFoundException FNFexp) {
			// TODO to do something
		} catch (IOException IOExp) {
			// TODO to do something
		}
	}

	@Override
	public IparsingRule getParseRule() {
		return getCorpus().getParsingRule();
	}

	@Override
	protected IndexTypes getIndexType() {
		return IndexTypes.DICT;
	}


}
