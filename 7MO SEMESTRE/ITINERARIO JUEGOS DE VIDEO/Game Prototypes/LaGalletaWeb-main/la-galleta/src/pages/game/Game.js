import React, { Component, useEffect, useContext, useState } from 'react'
import { UserContext } from '../../App';
import './Game.css'

export default function Game() {

const context = useContext(UserContext)
console.log('Game');
const dic = {
'1': '1',
'2': '2',
'3':'5',
'4':'8',
'5':'13',
'6':'18',
'7':'25',
'8':'32',
'9':'41',
'10':'50',
'11':'61',
'12':'72',
'13':'85',
'14':'98',
'15':'113',
'16':'128'
}       
// game parameters
const DELAY_END = 2; // seconds until a new game starts
const FPS = 30; // frames per second
const GRID_SIZE = context.tableroSize; // number of rows (and columns)
const HEIGHT = 550; // pixels
const [TOTAL_SQUARES, setTotalSquares] = useState(dic[context.tableroSize]); // number of squares
// derived dimensions
const WIDTH = HEIGHT * 0.9;
const CELL = WIDTH / (GRID_SIZE + 2); // size of cells (as well as left and right margin)
const STROKE = CELL / 12; // stroke width
const DOT = STROKE; // dot radius
const MARGIN = HEIGHT - (GRID_SIZE + 1) * CELL; // top margin for score, names, etc.

// colours
const COLOR_BOARD = "rgb(255, 248, 220)";
const COLOR_BORDER = "wheat";
const COLOR_COMP = "crimson";
const COLOR_COMP_LIT = "lightpink";
const COLOR_DOT = "sienna";
const COLOR_PLAY = "royalblue";
const COLOR_PLAY_LIT = "lightsteelblue";
const COLOR_TIE = "black";

// text
const TEXT_PLAY2 = "Player 2";
const TEXT_PLAY2_SML = "Play2";
const TEXT_PLAY = "Player 1";
const TEXT_PLAY_SML = "Play1";
const TEXT_SIZE_CELL = CELL / 3;
const TEXT_SIZE_TOP = MARGIN / 6;
const TEXT_TIE = "DRAW!";
const TEXT_WIN = "WINS!";

// definitions
const Side = {
    BOT: 0,
    LEFT: 1,
    RIGHT: 2,
    TOP: 3
}
let canv = document.createElement("canvas");
canv.height = HEIGHT;
canv.width = WIDTH;
let canvRect = canv.getBoundingClientRect();
// set up the context
let ctx = canv.getContext("2d");
ctx.lineWidth = STROKE;
ctx.textAlign = "center";
ctx.textBaseline = "middle";
// game variables
var squares = []; // array of squares
var currentCells, playersTurn;
var scoreComp, scorePlay;
var gridComp, gridPlay;
var timeEnd;
// set up the game canvas
useEffect(() => {
    document.getElementById("game").appendChild(canv);
}, [canv])

// start a new game
newGame();

// event handlers
canv.addEventListener("mousemove", highlightGrid);
canv.addEventListener("click", click);

// set up the game loop
setInterval(loop, 1000 / FPS);

function loop() {
    drawBoard();
    drawSquares();
    drawGrid();
    drawScores();
}

function click(/** @type {MouseEvent} */ ev) {
    console.log("click");
    if (/*TODO !playersTurn ||*/ timeEnd > 0) {
        return;
    }
    selectSide();
}

function drawBoard() {
    ctx.fillStyle = COLOR_BOARD;
    ctx.strokeStyle = COLOR_BORDER;
    ctx.fillRect(0, 0, WIDTH, HEIGHT);
    ctx.strokeRect(STROKE / 2, STROKE / 2, WIDTH - STROKE, HEIGHT - STROKE);
}

function drawDot(x, y) {
    ctx.fillStyle = COLOR_DOT;
    ctx.beginPath();
    ctx.arc(x, y, DOT, 0, Math.PI * 2);
    ctx.fill();
}

function drawGrid() {
   

    
    for (let i = 0; i < GRID_SIZE + 1; i++) {
        for (let j = 0; j < GRID_SIZE + 1; j++) {
            drawDot(getGridX(j), getGridY(i));
        }
    }
}

function drawLine(x0, y0, x1, y1, color) {
    ctx.strokeStyle = color;
    ctx.beginPath();
    ctx.moveTo(x0, y0);
    ctx.lineTo(x1, y1);
    ctx.stroke();
}

function drawScores() {
    let colComp = playersTurn ? COLOR_COMP_LIT : COLOR_COMP;
    let colPlay = playersTurn ? COLOR_PLAY : COLOR_PLAY_LIT;
    drawText(TEXT_PLAY, WIDTH * 0.25, MARGIN * 0.25, colPlay, TEXT_SIZE_TOP);
    drawText(scorePlay, WIDTH * 0.25, MARGIN * 0.6, colPlay, TEXT_SIZE_TOP * 2);
    drawText(TEXT_PLAY2, WIDTH * 0.75, MARGIN * 0.25, colComp, TEXT_SIZE_TOP);
    drawText(scoreComp, WIDTH * 0.75, MARGIN * 0.6, colComp, TEXT_SIZE_TOP * 2);

    // game over text
    if (timeEnd > 0) {
        timeEnd--;

        // handle a tie
        if (scoreComp == scorePlay) {
            drawText(TEXT_TIE, WIDTH * 0.5, MARGIN * 0.6, COLOR_TIE, TEXT_SIZE_TOP);
        } else {
            let playerWins = scorePlay > scoreComp;
            let color = playerWins ? COLOR_PLAY : COLOR_COMP;
            let text = playerWins ? TEXT_PLAY : TEXT_PLAY2;
            drawText(text, WIDTH * 0.5, MARGIN * 0.5, color, TEXT_SIZE_TOP);
            drawText(TEXT_WIN, WIDTH * 0.5, MARGIN * 0.7, color, TEXT_SIZE_TOP);
           
        }

        // new game
        if (timeEnd == 0) {
            newGame();
        }
    }
}

function drawSquares() {
    for (let row of squares) {
        for (let square of row) {
            if(square.bot!=undefined){
                square.drawSides();
                square.showValor();
                square.drawFill();
            }
            
        }
    }
}

function drawText(text, x, y, color, size) {
    ctx.fillStyle = color;
    ctx.font = size + "px dejavu sans mono";
    ctx.fillText(text, x, y);
}

function getColor(player, light) {
    if (player) {
        return light ? COLOR_PLAY_LIT : COLOR_PLAY;
    } else {
        return light ? COLOR_COMP_LIT : COLOR_COMP;
    }
}

function getText(player, small) {
    if (player) {
        return small ? TEXT_PLAY_SML : TEXT_PLAY;
    } else {
        return small ? TEXT_PLAY2_SML : TEXT_PLAY2;
    }
}

function getGridX(col) {
    return CELL * (col + 1);
}

function getGridY(row) {
    return MARGIN + CELL * row;
}

function highlightGrid(/** @type {MouseEvent} */ ev) {
    if (/*TODO !playersTurn ||*/ timeEnd > 0) {
        return;
    }
    var ClientRect = canv.getBoundingClientRect();
	
    // get mouse position relative to the canvas
    let x = ev.clientX - ClientRect.left;
    let y = ev.clientY - ClientRect.top;
    console.log('ev.clientX: ' + ev.clientX + ' ev.clientY: ' + ev.clientY);
    console.log('x: ' + x + ' y: ' + y);

    // highlight the square's side
    highlightSide(x, y);
}

function highlightSide(x, y) {

    // clear previous highlighting
    for (let row of squares) {
        for (let square of row) {
            if( square.bot!=undefined){
                square.highlight = null;

            }
        }
    }

    // check each cell
    let rows = squares.length;
    let cols = squares[0].length;
    currentCells = [];
    OUTER: for (let i = 0; i < rows; i++) {
        for (let j = 0; j < cols; j++) {
            if(squares[i][j].bot!=undefined){
                if (squares[i][j].contains(x, y)) {

                    // highlight current
                    let side = squares[i][j].highlightSide(x, y);
                    if (side != null) {
                        currentCells.push({row: i, col: j});
                    }

                    // determine neighbour
                    let row = i, col = j, highlight, neighbour = true;
                    if (side == Side.LEFT && j > 0) {
                        col = j - 1;
                        highlight = Side.RIGHT;
                    } else if (side == Side.RIGHT && j < cols - 1) {
                        col = j + 1;
                        highlight = Side.LEFT;
                    } else if (side == Side.TOP && i > 0) {
                        row = i - 1;
                        highlight = Side.BOT;
                    } else if (side == Side.BOT && i < rows - 1) {
                        row = i + 1;
                        highlight = Side.TOP;
                    } else {
                        neighbour = false;
                    }

                    // highlight neighbour
                    if (neighbour) {
                        squares[row][col].highlight = highlight;
                        currentCells.push({row: row, col: col});
                    }

                    // no need to continue
                    break OUTER;
                    }  


            }
                
        }
    }
}

function newGame() {
    
    
    currentCells = [];
    playersTurn = Math.random() >= 0.5;
    scoreComp = 0;
    scorePlay = 0;
    gridPlay = 0;
    gridComp=0;
    timeEnd = 0;

    // set up the squares
    
    var mitad = Math.floor(GRID_SIZE / 2);
    for (let i = 0; i < GRID_SIZE; i++) {
        squares[i] = [];
        for (let j = 0; j < GRID_SIZE; j++) {
           
            if(i < mitad){
                var not_draw = mitad - i;
                if(j<not_draw || j>= (GRID_SIZE-not_draw)){
                    console.log('not_draw',i,j);
                    squares[i][j]=[];
                }else{
                    console.log('draw',i,j);
                    squares[i][j] = new Square(getGridX(j), getGridY(i), CELL, CELL);
                    squares[i][j].showValor();
                }
            }else if(i > mitad){
                not_draw = i - mitad;
                console.log('resta', GRID_SIZE - not_draw)
                if(j<not_draw || j>= (GRID_SIZE-not_draw)){
                    console.log('not_draw',i,j);
                    squares[i][j]=[];
                }else{
                    console.log('draw',i,j);
                    squares[i][j] = new Square(getGridX(j), getGridY(i), CELL, CELL);
                    squares[i][j].showValor();
                }

                
            }else{
                console.log('draw',i,j);
                squares[i][j] = new Square(getGridX(j), getGridY(i), CELL, CELL);
                squares[i][j].showValor();
            }
            
        }
    }
    console.log(squares);
}

function selectSide() {
    if (currentCells == null || currentCells.length == 0) {
        console.log("No cells selected");
        return;
    }

    // select the side(s)
    let filledSquare = false;
    for (let cell of currentCells) {
        if(squares[cell.row][cell.col].bot!=undefined){
            if (squares[cell.row][cell.col].selectSide()) {
            filledSquare = true;
        }
        }
        
    }
    currentCells = [];

    // check for winner
    if (filledSquare) {
        if (gridPlay + gridComp ==TOTAL_SQUARES) {
            // game over
            timeEnd = Math.ceil(DELAY_END * FPS);
        }
    } else {
        // next player's turn
        playersTurn = !playersTurn;
    }
}

// create the Square object constructor
function Square(x, y, w, h) {
    this.w = w;
    this.h = h;
    this.bot = y + h;
    this.left = x;
    this.right = x + w;
    this.top = y;
    this.valor = Math.floor(Math.random()*(Math.floor(6)-Math.ceil(1)+1)+Math.ceil(1));
    this.highlight = null;
    this.numSelected = 0;
    this.owner = null;
    this.sideBot = {owner: null, selected: false};
    this.sideLeft = {owner: null, selected: false};
    this.sideRight = {owner: null, selected: false};
    this.sideTop = {owner: null, selected: false};

    this.contains = function(x, y) {
        return x >= this.left && x < this.right && y >= this.top && y < this.bot;
    }

    //dibuja el valor dentro de el cuadrado
    this.showValor = function(){
        ctx.fillStyle = "rgb(160, 82, 45,0.7)";
        ctx.font = "28px dejavu sans mono";
        ctx.fillText(this.valor, this.left + this.w/2, this.top + this.h/2);
    }

    this.drawFill = function() {
        if (this.owner == null) {
            return;
        }

        // light background
        ctx.fillStyle = getColor(this.owner, true);
        ctx.fillRect(
            this.left + STROKE, this.top + STROKE,
            this.w - STROKE * 2, this.h - STROKE * 2
        );

        // owner text
        drawText(
            this.valor,
            this.left + this.w / 2,
            this.top + this.h / 2,
            getColor(this.owner, false),
            28
        );
    }

    this.drawSide = function(side, color) {
        switch(side) {
            case Side.BOT:
                drawLine(this.left, this.bot, this.right, this.bot, color);
                break;
            case Side.LEFT:
                drawLine(this.left, this.top, this.left, this.bot, color);
                break;
            case Side.RIGHT:
                drawLine(this.right, this.top, this.right, this.bot, color);
                break;
            case Side.TOP:
                drawLine(this.left, this.top, this.right, this.top, color);
                break;
        }
    }

    this.drawSides = function() {

        // highlighting
        if (this.highlight != null) {
            this.drawSide(this.highlight, getColor(playersTurn, true));
        }

        // selected sides
        if (this.sideBot.selected) {
            this.drawSide(Side.BOT, getColor(this.sideBot.owner, false));
        }
        if (this.sideLeft.selected) {
            this.drawSide(Side.LEFT, getColor(this.sideLeft.owner, false));
        }
        if (this.sideRight.selected) {
            this.drawSide(Side.RIGHT, getColor(this.sideRight.owner, false));
        }
        if (this.sideTop.selected) {
            this.drawSide(Side.TOP, getColor(this.sideTop.owner, false));
        }
    }

    this.highlightSide = function(x, y) {

        // calculate the distances to each side
        let dBot = this.bot - y;
        let dLeft = x - this.left;
        let dRight = this.right - x;
        let dTop = y - this.top;

        // determine closest value
        let dClosest = Math.min(dBot, dLeft, dRight, dTop);

        // highlight the closest if not already selected
        if (dClosest == dBot && !this.sideBot.selected) {
            this.highlight = Side.BOT;
        } else if (dClosest == dLeft && !this.sideLeft.selected) {
            this.highlight = Side.LEFT;
        } else if (dClosest == dRight && !this.sideRight.selected) {
            this.highlight = Side.RIGHT;
        } else if (dClosest == dTop && !this.sideTop.selected) {
            this.highlight = Side.TOP;
        }

        // return the highlighted side
        return this.highlight;
    }

    this.selectSide = function() {
        if (this.highlight == null) {
            return;
        }

        // select the highlighted side
        switch (this.highlight) {
            case Side.BOT:
                this.sideBot.owner = playersTurn;
                this.sideBot.selected = true;
                break;
            case Side.LEFT:
                this.sideLeft.owner = playersTurn;
                this.sideLeft.selected = true;
                break;
            case Side.RIGHT:
                this.sideRight.owner = playersTurn;
                this.sideRight.selected = true;
                break;
            case Side.TOP:
                this.sideTop.owner = playersTurn;
                this.sideTop.selected = true;
                break;
        }
        this.highlight = null;

        // increase the number of selected
        this.numSelected++;
        if (this.numSelected == 4) {
            this.owner = playersTurn;

            // increment score
            if (playersTurn) {
                //scorePlay++;
                gridPlay++;
                scorePlay+=this.valor;
                console.log('gridPlay: '+gridPlay);
                
            } else {
                //scoreComp++;
                gridComp++;
                scoreComp+=this.valor;
                console.log('gridComp: '+gridComp);
                
            }

            // filled
            return true;
        }

        // not filled
        return false;
    }
}


    return (
      <div id='game' className='container'>
        
      </div>
    )
  
}
