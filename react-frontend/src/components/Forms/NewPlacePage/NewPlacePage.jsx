import React, { useState, useEffect } from "react";
import { TextField, Button, Typography, Paper } from "@material-ui/core";
import FileBase from "react-file-base64";
import { useDispatch, useSelector } from "react-redux";
import { createPost, updatePost } from "../../../actions/posts";

import useStyles from "./styles";

const NewPlacePage = ({ currentId, setCurrentId }) => {
  const [postData, setPostData] = useState({
    name: "",
    location: "",
    image: "",
    openingTime: "",
    tasteScore: "",
    textureScore: "",
    presentationScore: "",
  });
  const post = useSelector((state) =>
    currentId ? state.posts.find((p) => p._id === currentId) : null
  );
  const classes = useStyles();
  const dispatch = useDispatch();

  useEffect(() => {
    if (post) setPostData(post);
  }, [post]);

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (currentId) {
      dispatch(updatePost(currentId, postData));
    } else {
      dispatch(createPost(postData));
    }

    clear();
  };

  const clear = () => {
    setCurrentId(null);
    setPostData({
      name: "",
      location: "",
      image: "",
      openingTime: "",
      tasteScore: "",
      textureScore: "",
      presentationScore: "",
    });
  };

  return (
    <Paper className={classes.paper}>
      <form
        autoComplete="off"
        noValidate
        className={`${classes.root} ${classes.form}`}
        // enctype="multipart/form-data"
        onSubmit={handleSubmit}
      >
        <Typography variant="h6">Add new Place</Typography>
        <TextField
          name="name"
          variant="outlined"
          label="Name"
          fullWidth
          value={postData.name}
          onChange={(e) => setPostData({ ...postData, name: e.target.value })}
        />
        <TextField
          name="location"
          variant="outlined"
          label="Location"
          fullWidth
          value={postData.location}
          onChange={(e) =>
            setPostData({ ...postData, location: e.target.value })
          }
        />
        <TextField
          name="opening-time"
          variant="outlined"
          label="Opening Time"
          fullWidth
          value={postData.openingTime}
          onChange={(e) =>
            setPostData({ ...postData, openingTime: e.target.value })
          }
        />
        <TextField
          type="number"
          InputProps={{ inputProps: { max: 5, min: 1 } }}
          name="taste-score"
          variant="outlined"
          label="Taste Score"
          fullWidth
          value={postData.tasteScore}
          onChange={(e) =>
            setPostData({ ...postData, tasteScore: e.target.value })
          }
        />
        <TextField
          type="number"
          InputProps={{ inputProps: { max: 5, min: 1 } }}
          name="texture-score"
          variant="outlined"
          label="Texture Score"
          fullWidth
          value={postData.textureScore}
          onChange={(e) =>
            setPostData({ ...postData, textureScore: e.target.value })
          }
        />
        <TextField
          type="number"
          InputProps={{ inputProps: { max: 5, min: 1 } }}
          name="presentation-score"
          variant="outlined"
          label="Presentation Score"
          fullWidth
          value={postData.presentationScore}
          onChange={(e) =>
            setPostData({ ...postData, presentationScore: e.target.value })
          }
        />
        <div className={classes.fileInput}>
          <FileBase
            type="file"
            multiple={false}
            onDone={({ base64 }) => setPostData({ ...postData, image: base64 })}
          />
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
        <Button
          variant="contained"
          color="secondary"
          size="small"
          onClick={clear}
          fullWidth
        >
          Clear
        </Button>
      </form>
    </Paper>
  );
};

export default NewPlacePage;
