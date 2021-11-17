import React from "react";
import { Grid, CircularProgress } from "@material-ui/core";
import { useSelector } from "react-redux";

import Post from "./Post/Post.jsx";
import useStyle from "./styles";

const Posts = () => {
  const posts = useSelector((state) => state.posts);
  const classes = useStyle();

  console.log(posts);

  return (
    <div>
      <Grid>
        <h1>Posts</h1>
        <p>Post</p>
        <p>Post</p>
      </Grid>
    </div>
  );
};

export default Posts;
