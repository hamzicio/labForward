import { Alert, Box, Button, Modal, Typography } from "@mui/material";
import { useEffect, useState } from "react";
import { getFrequencyWSimilarWord, updateNoteBook } from "../../apis";
import Form from "../../components/Form";
import { ResultTab } from "../../components/ResultTab";
import { SearchBar } from "../../components/SearchBar";
import "./searchNoteBook.css";

export const SearchPage = () => {
  const [searchQuery, setSearchQuery] = useState("");
  const [toggleModal, setToggleModal] = useState(false);
  const [searchResult, setSearchResult] = useState(null);
  const [notebookUpdated, setNotebookUpdated] = useState(false);
  const [error, setError] = useState("");

  useEffect(() => {}, [
    searchQuery,
    searchResult,
    toggleModal,
    notebookUpdated,
  ]);

  const toggleModalValue = () => {
    setToggleModal(!toggleModal);
  };

  const style = {
    position: "absolute",
    top: "50%",
    left: "50%",
    transform: "translate(-50%, -50%)",
    width: 400,
    bgcolor: "background.paper",
    border: "2px solid #000",
    boxShadow: 24,
    p: 4,
  };

  const onClear = () => {
    setSearchResult(null);
    setSearchQuery("");
  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    try {
      setNotebookUpdated(false);
      const response = await updateNoteBook(event.target[0].value);
      if (response.status === 200) {
        setNotebookUpdated(true);
      }
    } catch (err) {
      console.error(err);
      setError("An internal error occured. Please try again later");
    }

    setTimeout(() => {
      setNotebookUpdated(false);
      setToggleModal(false);
      setError("");
    }, 3000);
  };

  const getSearchResults = async (e) => {
    e.preventDefault();
    try {
      const {
        data: { frequency, similarWords },
      } = await getFrequencyWSimilarWord(searchQuery);
      setSearchResult({ frequency, similarWords });
    } catch (err) {
      console.error(err);
      setError("An internal error occured. Please try again later");
      setTimeout(() => {
        setError("");
      }, 3000);
    }
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

      <Button onClick={toggleModalValue}>Update Notebook</Button>

      {error && error.trim().length && (
        <Alert style={{ justifyContent: "center" }} severity="error">
          {error}
        </Alert>
      )}

      <Modal
        style={{
          display: "flex",
          alignItems: "center",
          justifyContent: "center",
        }}
        onClose={toggleModalValue}
        open={toggleModal}
      >
        <Box sx={style}>
          <Typography id="modal-modal-title" variant="h6" component="span">
            Update Notebook Entry
          </Typography>
          <Typography
            id="modal-modal-description"
            component="span"
            sx={{ mt: 2 }}
          >
            {<Form handleFormSubmit={handleSubmit} />}
            {notebookUpdated ? (
              <Alert style={{ justifyContent: "center" }} severity="success">
                Notebook Updated Successfully
              </Alert>
            ) : (
              ""
            )}
          </Typography>
        </Box>
      </Modal>
    </>
  );
};
