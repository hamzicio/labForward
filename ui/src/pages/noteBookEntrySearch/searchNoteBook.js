import { useEffect, useState } from "react";
import { getFrequencyWSimilarWord } from "../../apis";
import { ResultTab } from "../../components/ResultTab";
import { SearchBar } from "../../components/SearchBar";
import "./searchNoteBook.css";

export const SearchPage = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [searchResult, setSearchResult] = useState(null);

  useEffect(() => {}, [searchQuery, searchResult]);

  const onClear = () => {
    setSearchResult(null);
    setSearchQuery("");
  };

  const getSearchResults = async (e) => {
    e.preventDefault();
    try {
      const {
        data: { frequency, similarWords },
      } = await getFrequencyWSimilarWord(searchQuery);
      setSearchResult({ frequency, similarWords });
    } catch (err) {}
  };

  return (
    <>
      <div className="search-container">
        <h1>NoteBook Entry Finder</h1>
        <SearchBar
          searchQuery={searchQuery}
          setSearchQuery={setSearchQuery}
          onSearch={getSearchResults}
          onClear={onClear}
        />
      </div>

      {searchQuery && searchResult && (
        <ResultTab
          searchQuery={searchQuery}
          frequency={searchResult.frequency}
          similarWords={searchResult.similarWords}
        />
      )}
    </>
  );
};
