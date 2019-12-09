# INFO6205_203

# Coway's Game of Life 

## Find the infinite pattern by using the Genetic Algorithm.

- We found a pattern that could expend to 112 nodes from 13 nodes, after 1000 generation of Conway’s game of life. We thought this is a great pattern that worth to take a test like others. And we put it in a more larger canvas. We found out that after around 800 generations, it turns to follow a specific growth rule like the third picture. Based on our investigation, we thought we could think this model as the model which could infinite growth.
Although it seams like we have gave too much constrains to the scale of the pattern. But actually, we tried from 100*100 to 5*5 for a long range of times. We have run several times and took a long time to get this conclusion and tring to deducted the scale of the original canvas is the method we use to make the things easier. Before we tried the 5*5, we get some patterns more bigger and get some good values, but they didn’t show a sign of infinite. So, we try to make this more likely happened. So, we investigate some papers and found that the 5*5 also worked, that why we get this small scale of the pattern.

## Proof of Using of Generic Algorithm
- We created our own genetic algorithm, in which we implemented the fitness function. And also, we did the mutation and the crossover functions based on the fitness evaluation of each elements in the population.
Our main argument shows below:
* Number of population: 10
* The max generation of a single game : 500-1000
* The initial pattern scale: from 100*100 to 5*5
* The Monitoring range (main canvas) : set dead board to 100*100 to 1000*1000

## Fitness Function
In our Fitness Function, we calculated the growth rate (float num) of the endLiveCell and the startLiveCells.

## Genotype and Finotype
 - Genotype:
We built a 2D “matrix” ( int[ ][ ] ) to represent the genotype in the GA algorithm. (B) Phenotype:
 - Phenotype
 It’s the expression of the matrix, which is a “pattern”. In a patter, we express the matrix of genotype on a canvas and add transforming function on it.
 And also, phenotype has the method of get Fitness score of a specific genotype.

## Add the UserInterface based on JS

- Our userInterface is in the User Interface folder. Since when we do the experiment, we make the canvas to 1000*1000, so that the java swing could not show the best output since the refresh requirement is too much. So that we decided to output the matrix into a txt file and write a js program to run it in the web browser, in which way we get a better performance. 

- needs to user the cmp command to get into the Chrome web broswer.

```
open -n -a /Applications/Google\ Chrome.app/Contents/MacOS/Google\ Chrome --args --user-data-dir="/tmp/chrome_dev_test" --disable-web-security
```
