// The Nature of Code
// Daniel Shiffman
// http://natureofcode.com

// A basic implementation of John Conway's Game of Life CA
// how could this be improved to use object oriented programming?
// think of it as similar to our particle system, with a "cell" class
// to describe each individual cell and a "cellular automata" class
// to describe a collection of cells

var gol;

function setup() {
    createCanvas(1000, 1000);
    gol = new GOL();
}

function draw() {
    if (!gol.isStop) {
        background(255);
        gol.generate();
        gol.display();
    }
}

// reset board when mouse is pressed
function mousePressed() {
    //gol.init();
}

document.getElementById("start").onclick = function() {
    start()
};

document.getElementById("stop").onclick = function() {
    stop()
};

document.getElementById("reset").onclick = function() {
    reset()
};

function start() {
    gol.isStop = false;
}

function stop() {
    gol.isStop = true;
}

function reset() {
    gol.init();
    start();
}