import React from "react";
import AppBar from "@mui/material/AppBar";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";

import useStyles from "./styles";

const Navbar = () => {
  const classes = useStyles();

  return (
    <div>
      <AppBar className={classes.appBar} position="static" margin>
        <Toolbar>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            Burger Rating App
          </Typography>
        </Toolbar>
      </AppBar>
    </div>
  );
};

export default Navbar;
