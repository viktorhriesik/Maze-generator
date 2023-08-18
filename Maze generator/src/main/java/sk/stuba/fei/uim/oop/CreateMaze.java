package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Random;

public class CreateMaze {

    private Tile[][] table;
    private MazeGraphic mazeGraphic;
    private int size;
    private Player player;

    public CreateMaze(int size,Player player){
        this.size = size;
        this.table = new Tile[size][size];
        this.player = player;
        Controls controls = new Controls(table, player, size);
        this.mazeGraphic = new MazeGraphic(size, controls);

        this.mazeGraphic.addTilesToGrid(getTable());
        this.mazeGraphic.addKeyListener(new KeyCommands(controls));

        newGame();
    }

    public void newGame(){
        this.mazeGraphic.resetTilesAndScore(this.table,this.player);
        setGoalPlayerStartingPositions();
        randomizedDFS(this.table[0][0]);
    }

    public Tile[][] getTable() {
        return table;
    }

    public void randomizedDFS(Tile vertex){

        vertex.passed = true;
        Tile nextVertex = randomUnvisitedNeighbour(vertex);
         while (nextVertex != null){
            connectCells(vertex,nextVertex);
            randomizedDFS(nextVertex);
            nextVertex = randomUnvisitedNeighbour(vertex);
        }
    }

    public Tile randomUnvisitedNeighbour(Tile tile){

    ArrayList<Tile> notPassedNeighbourTiles = new ArrayList<>();

        for(int i = 0;i<2;i++){
            if(outOfBoundaries(tile.cordX + i, tile.cordY - 1 + i)){
                if(!table[tile.cordX + i][tile.cordY - 1 + i].passed){
                    notPassedNeighbourTiles.add(table[tile.cordX+i][tile.cordY-1+i]);
                }
            }
        }
        for(int i = 0;i<2;i++){
            if(outOfBoundaries(tile.cordX - 1 + i, tile.cordY + i)){
                if(!table[tile.cordX - 1 + i][tile.cordY + i].passed){
                   notPassedNeighbourTiles.add(table[tile.cordX-1+i][tile.cordY+ i]);
                }
            }
        }

        if(notPassedNeighbourTiles.size() == 0)
            return null;
        return notPassedNeighbourTiles.get(getRandomNumber(0, notPassedNeighbourTiles.size()));
    }

    public boolean outOfBoundaries(int cordX,int cordY){
        return (cordX >= 0 && cordX < size) && (cordY >= 0 && cordY < size);
    }

    public void connectCells(Tile vertex,Tile nextVertex){

         if(nextVertex.cordY>vertex.cordY){
             nextVertex.disableTopWall();
             vertex.disableBottomWall();
        }else if(nextVertex.cordY<vertex.cordY){
             nextVertex.disableBottomWall();
             vertex.disableTopWall();
        }else if(nextVertex.cordX > vertex.cordX){
            nextVertex.disableLeftWall();
            vertex.disableRightWall();
        }else if(nextVertex.cordX < vertex.cordX){
            nextVertex.disableRightWall();
            vertex.disableLeftWall();
        }

    }

    public int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min) + min;
    }

    public void setGoalPlayerStartingPositions(){
        table[this.player.cordX][this.player.cordY].removePlayerFromTile();
        table[0][0].setPlayerOnTile();
        table[this.size-1][this.size-1].setGoal();
        this.player.resetCord();
    }

}
