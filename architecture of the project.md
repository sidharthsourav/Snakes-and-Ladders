# architecture of the project

calulate function working 

Approch 1:

- first add the dice point to the currect score and then check
- Check if position exist in snakes call snaked function 
- else check if position exist in ladders function 


Dilema's in approch 1: need to pass the hashsets


Approch 2: 
- in controller function itself add the position and check for the snaked or ladders



turn function will return a int arry
0th positoin the score
1st position 0 or 1 for winner flag value;

function turn headers requirements;
1. playername
2. playerScore
3. hashmap of snakes
4. hashmap of ladders

need to return playerScore & winner 