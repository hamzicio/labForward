import IconButton from "@mui/material/IconButton";
import SearchIcon from "@mui/icons-material/Search";
import TextField from "@mui/material/TextField";
import ClearIcon from "@mui/icons-material/Clear";

export const SearchBar = ({
  searchQuery,
  setSearchQuery,
  onSearch,
  onClear,
}) => (
  <>
    <form>
      <TextField
        id="search-bar"
        className="text"
        value={searchQuery}
        onInput={(e) => {
          setSearchQuery(e.target.value);
        }}
        label="Enter an entry to search in notebook"
        variant="outlined"
        placeholder="Search..."
        size="small"
      />
      <IconButton onClick={onSearch} aria-label="search">
        <SearchIcon style={{ fill: "blue" }} />
      </IconButton>
      <IconButton onClick={onClear} aria-label="search">
        <ClearIcon style={{ fill: "blue" }} />
      </IconButton>
    </form>
  </>
);
