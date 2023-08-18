package sk.stuba.fei.uim.oop;

public class MazeGame {

    public static final int SIZE = 19;
    public Player player =  new Player();
    public CreateMaze maze;

    public MazeGame(){
        maze = new CreateMaze(SIZE,player);

        while (true){
           synchronized (this){
               if(player.playerReachedGoal == true){
                   this.maze.newGame();
                   player.playerReachedGoal = false;
               }
           }
        }
    }
}
