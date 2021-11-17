import React from "react";
import { TextField, Button, Typography, Paper } from "@material-ui/core";
import FileBase from "react-file-base64";

import useStyles from "./styles";

const NewPlacePage = () => {
  const classes = useStyles();

  return (
    <Paper className={classes.paper}>
      <form
        autoComplete="off"
        noValidate
        className={`${classes.root} ${classes.form}`}
      >
        <Typography variant="h6">Add new Place</Typography>
        <TextField name="name" variant="outlined" label="Name" fullWidth />
        <TextField
          name="location"
          variant="outlined"
          label="Location"
          fullWidth
        />
        <TextField
          name="opening-time"
          variant="outlined"
          label="Opening Time"
          fullWidth
        />
        <TextField
          type="number"
          InputProps={{ inputProps: { max: 5, min: 1 } }}
          name="taste-score"
          variant="outlined"
          label="Taste Score"
          fullWidth
        />
        <TextField
          type="number"
          InputProps={{ inputProps: { max: 5, min: 1 } }}
          name="texture-score"
          variant="outlined"
          label="Texture Score"
          fullWidth
        />
        <TextField
          type="number"
          InputProps={{ inputProps: { max: 5, min: 1 } }}
          name="presentation-score"
          variant="outlined"
          label="Presentation Score"
          fullWidth
        />
        <div className={classes.fileInput}>
          <FileBase type="file" multiple={false} />
        </div>
        <Button
          className={classes.buttonSubmit}
          variant="contained"
          color="primary"
          size="large"
          type="submit"
          fullWidth
        >
          Submit
        </Button>
        <Button variant="contained" color="secondary" size="small" fullWidth>
          Clear
        </Button>
      </form>
    </Paper>
  );
};

export default NewPlacePage;
