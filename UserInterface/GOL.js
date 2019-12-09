

function GOL() {
  var board = [];
  var next = [];
  var columns = 0;
  var rows = 0;
  var w = 8;
  var oneCounter = 0;
  var generation = 0;
  var isStop = false;

  // read init from file, need to run in chrome unsafe mode to bypass CORS issue
  // run this command to start a unsafe mode chrome:
  this.readInputAndInit = function(file) {
    var rawFile = new XMLHttpRequest();
    rawFile.open("GET", file, true);
    rawFile.onreadystatechange = function () {
        if(rawFile.readyState === 4)
        {
            if(rawFile.status === 200 || rawFile.status == 0)
            {
              var content = rawFile.responseText;
              var initArray = [];
              var rowsArray = content.split('\n');
              rowsArray.forEach(function(row) {
                initArray.push(row.split(' '));
              });

              rows = initArray.length;
              columns = initArray[0].length;

              board = new Array(columns);
              for (var i = 0; i < columns; i++) {
                board[i] = new Array(rows);
              }
              // Going to use multiple 2D arrays and swap them
              next = new Array(columns);
              for (var i = 0; i < columns; i++) {
                next[i] = new Array(rows);
              }

              for (var i =0;i < columns;i++) {
                for (var j =0;j < rows;j++) {
                  if (i === 0 || j === 0 || i == columns-1 || j == rows-1) board[i][j] = 0;
                  else board[i][j] = parseInt(initArray[i][j]);
                  next[i][j] = 0;
                  if (parseInt(initArray[i][j]) == 1) {
                    oneCounter++;
                  }
                }
              }

              document.getElementById("aoo").innerHTML = 'Live cells: ' + oneCounter;
              document.getElementById("gen").innerHTML = 'Generation: ' + generation;
            }
        }
    }
    rawFile.send(null);
  }

  this.init = function() {
    board = [];
    next = [];
    columns = 0;
    rows = 0;
    oneCounter = 0;
    generation = 0;
    isStop = false;
    this.readInputAndInit("file:init.txt");
  };

  this.init();

  // The process of creating the new generation
  this.generate = function() {
      // Loop through every spot in our 2D array and check spots neighbors
      for (var x = 1; x < columns-1; x++) {
        for (var y = 1; y < rows-1; y++) {
          // Add up all the states in a 3x3 surrounding grid
          var neighbors = 0;

          for (var i = -1; i <= 1; i++) {
            for (var j = -1; j <= 1; j++) {
              neighbors += board[x+i][y+j];
            }
          }

          // A little trick to subtract the current cell's state since
          // we added it in the above loop
          neighbors -= board[x][y];

          // Rules of Life
          if ((board[x][y] == 1) && (neighbors <  2)) {
            next[x][y] = 0;           // Loneliness
            oneCounter--;
            document.getElementById("aoo").innerHTML = 'Live cells: ' + oneCounter;
          } else if ((board[x][y] == 1) && (neighbors >  3)) {
            next[x][y] = 0;           // Overpopulation
            oneCounter--;
            document.getElementById("aoo").innerHTML = 'Live cells: ' + oneCounter;
          } else if ((board[x][y] === 0) && (neighbors == 3)) {
            next[x][y] = 1;           // Reproduction
            oneCounter++;
            document.getElementById("aoo").innerHTML = 'Live cells: ' + oneCounter;
          } else {
            next[x][y] = board[x][y];  // Stasis
          }
        }
      }

      // Swap!
      var temp = board;
      board = next;
      next = temp;
      generation++;
      document.getElementById("gen").innerHTML = 'Generation: ' + generation;
  };

  // This is the easy part, just draw the cells, fill 255 for '1', fill 0 for '0'
  this.display = function() {
    for ( var i = 0; i < columns;i++) {
      for ( var j = 0; j < rows;j++) {
        if ((board[i][j] == 1)) fill(0);
        else fill(255);
        stroke(0);
        rect(i*w, j*w, w, w);
      }
    }
  };
}
