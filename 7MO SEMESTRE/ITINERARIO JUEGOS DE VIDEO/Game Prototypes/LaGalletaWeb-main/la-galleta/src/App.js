import './App.css';
import * as React from 'react';
import { Routes, Route, Link } from "react-router-dom";


//Material UI
import AppBar from '@mui/material/AppBar';
import Toolbar from '@mui/material/Toolbar';
import Typography from '@mui/material/Typography';
import IconButton from '@mui/material/IconButton';

//icons
import MenuIcon from '@mui/icons-material/Menu';
import CookieIcon from '@mui/icons-material/Cookie';


//imports de los componentes
import Menu from './pages/menu/Menu';
import Game from './pages/game/Game';
export const UserContext = React.createContext()

function App() {
  const [tableroSize, setTableroSize] = React.useState(5);
  

  return (
    <div>
     
     <AppBar className='navbar' position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <CookieIcon  sx={{ fontSize: 40, color: 'white'}} />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1, fontSize: 24 }}>
            La Galleta
          </Typography>
        </Toolbar>
      </AppBar>
      <UserContext.Provider value={{tableroSize, setTableroSize}}>

      <Routes>
        <Route path="/" element={<Menu />} />
        <Route path="game" element={<Game />} />
      </Routes>
      </UserContext.Provider>

    
      
    </div>
  )
}

export default App;
