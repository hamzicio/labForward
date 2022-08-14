//packages
import React, { useState } from "react";
import Grid from "@material-ui/core/Grid";
import Button from "@material-ui/core/Button";
import { TextareaAutosize } from "@mui/material";

const defaultValues = {
  word: "",
};

//form component to update notebook entry
export const Form = ({ handleFormSubmit }) => {
  const [formValues, setFormValues] = useState(defaultValues);
  const handleInputChange = (e) => {
    const { name, value } = e.target;
    setFormValues({
      ...formValues,
      [name]: value,
    });
  };

  return (
    <form onSubmit={handleFormSubmit}>
      <Grid
        container
        alignItems="center"
        justifyContent="center"
        direction="column"
      >
        <Grid item>
          <TextareaAutosize
            placeholder="Enter entry"
            id="word"
            name="word"
            multiline="true"
            label="Enter entry"
            type="text"
            minRows={5}
            minLength={5}
            cols={"40"}
            value={formValues.word}
            onChange={handleInputChange}
          />
        </Grid>

        <br />
        <Button variant="contained" color="primary" type="submit">
          Update
        </Button>
      </Grid>
    </form>
  );
};
export default Form;
