import java.util.* ;

class snakesLadders {

    //function to check for edge cases when user is on 94+ position and dice value can't be used //out of bounds expecption case
    public static int winning(int position,int dicevalue) { return dicevalue+position<=100? dicevalue+position : position; }

    //function to load the hashmaps with data for each smakes & ladders entry & exit points.
    public static void populateData(HashMap<Integer,Integer> map,int[][] data){
        for(int i=0;i<data.length;i++)
        {
            map.put(data[i][0], data[i][1]);
        }
    }

    //function to run the main game logic
    public static int[] turn(String playerName,int playerPosition,HashMap<Integer,Integer> snakes,HashMap<Integer,Integer> ladders){
        
        //Intialize the return data set
        int[] result = new int[2];
        int winner=0;

        //run the game for player
        System.out.println(playerName+"'s Turn!");

        //generation of dice value
        int playerturn=(int)(Math.random()*6)+1; 
        System.out.println("The Dice Value is : "+playerturn);
    
        //check the edge case of 94+ Position dice value
        playerPosition= (playerPosition>=95)? winning(playerPosition,playerturn):playerPosition+playerturn;

        //Check if player landed on snake or ladder
        if(snakes.containsKey(playerPosition)){
            playerPosition=snakes.get(playerPosition);
            System.out.println("Opps! you are bitten by the snake you are back to : "+playerPosition);
        }
        else if(ladders.containsKey(playerPosition)){
            playerPosition=ladders.get(playerPosition);
            System.out.println("Hurraayy!! you reached a ladder your new Position is : "+playerPosition); 
        }

        //Print the Position and check if player won.
        System.out.println(playerName+ " Position is "+ playerPosition);
        if(playerPosition==100){
            winner=1;
            System.out.println("\n********** "+playerName+" is the winner!!!!"+" **********"+"\nThanks for playing the game!");
        }

        //populating the result 
        result[0]=playerPosition; result[1]=winner;

        return result;
    }

    public static void main(String[] args) throws InterruptedException
    {
        //Initializing player scores and winner state
        int player1Position=1;
        int player2Position=1;
        boolean winner=false;

        //initializing hashmaps for positional data
        HashMap<Integer,Integer> snakes = new HashMap<>();
        HashMap<Integer,Integer> ladders= new HashMap<>();

        //generating datasets and pooulating the hashmaps
        int[][] snakeCordinates={{99,54},{91,76},{77,5},{45,37},{56,9},{27,3},{93,50},{88,33},{75,20},{65,10},{55,5}};
        int[][] ladderCordinates={{24,50},{56,80},{17,59},{15,77},{20,98},{30,92}};
        populateData(snakes,snakeCordinates);
        populateData(ladders, ladderCordinates);

        //Get player names for the output
        String Player1Name= "Sourav";
        String Player2Name= "Achintya";


        //controller function for the game
        while(!winner){

            //player 1 turn
            int[] result=turn(Player1Name, player1Position,snakes,ladders);
            player1Position=result[0];
            winner=(result[1]==1)?true:false;
            if(winner) break;
            System.out.println("\n");
            Thread.sleep(500);

            //player 2 turn
            result=turn(Player2Name, player2Position,snakes,ladders);
            player2Position=result[0];
            winner=(result[1]==1)?true:false;
            Thread.sleep(500);

            System.out.print("\n\n");
        }
    
    }
}
