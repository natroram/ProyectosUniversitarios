import React, { Component, useState, useContext } from 'react'
import { useNavigate } from "react-router-dom";
import { UserContext } from '../../App';
import {Box,Button, Modal,Slider, Typography} from '@mui/material';



//Material UI


//icons
import PlayCircleFilledIcon from '@mui/icons-material/PlayCircleFilled';
import SettingsApplicationsIcon from '@mui/icons-material/SettingsApplications';


export default function Menu (){

    const style = {
        position: 'absolute',
        top: '50%',
        left: '50%',
        transform: 'translate(-50%, -50%)',
        width: 400,
        bgcolor: 'background.paper',
        border: '2px solid #000',
        boxShadow: 24,
        p: 4,
      };

    const [openModal, setOpenModal] = useState(false)
    const [size, setSize] = useState(9)
    let nav = useNavigate();
    const {setTableroSize} = useContext(UserContext)



    let setValue = (event) => {
        setSize(event.target.value)
        setTableroSize(event.target.value)
    }
    
    let handleClose = () => {
        setOpenModal(false)
    }

    let btnPlay = () => {
        nav('/game')
    }
    let btnSettings = () => {
        setOpenModal(true)
    }

    return (
      <div>
       {/*Modal*/}
        <Modal
        open={openModal}
        onClose={handleClose}
        >
        <Box sx={style}>
            <Typography id="modal-modal-title" variant="h6" component="h2">
            Tamaño del tablero
            </Typography>
            <Slider defaultValue={size} step={1} marks min={5} max={12}   valueLabelDisplay="auto" onChange={setValue}/>
            <Typography> Establecer en {size} x {size}
            </Typography>
            <Button variant="contained" color="primary" onClick={handleClose}>
                Aceptar
            </Button>
        </Box>
        </Modal>

         {/*Botones*/}
          <div class="bkground container-fluid">
        <div class="menu-container col">

          <div class="row">
          <Button class='btn-menu btn-play' variant="outlined" onClick={btnPlay} >
          <PlayCircleFilledIcon sx={{ fontSize: 40, color: 'white'}}/>
            <Typography sx={{ fontSize: 25, color: 'white'}} >Jugar</Typography>
          </Button>
          </div>


          <div class="row">
          <Button class='btn-menu btn-config' variant="outlined" onClick={btnSettings}>
          <SettingsApplicationsIcon  sx={{ fontSize: 40, color: 'white'}}/>
          <Typography sx={{ fontSize: 25, color: 'white'}} >Configurar</Typography>
          </Button>
          </div>
          

        </div>
      </div>
      </div>
    )
  
}
