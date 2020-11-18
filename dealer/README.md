# Blackjack

 A simple blackjack server over WebSockets. The server is written using Java 8, so to run this locally, you'll need to have Java 8.
 
 This is build by utilising the Model-View-Controller architecture.
 ## Server Startup
 To start playing the game locally, should have java 8 installed in the current local machine.
 
 * Find the .jar file located in the `target/` folder.
 * From the terminal, run the command `java -jar {jar_name}.jar`. This command generally starts the server on an embedded Tomcat instance on port 8080. In order to change the port that is default on startup server, we can generally add `--server.port={desired port number}` at the end of java command.
 * Once the server is started , we can find the UI at localhost:8080, where we can connect to the server and manually play blackjack.
 * After the UI is displayed press Connect, Enter the name, place the bet in the increments of 10 and start the game.
 * After the hand of a player is done, you can again enter the bet amount and play until the total amount becomes zero.
 * In order to start playing with an other new player, press the disconnect button, refresh the application and start with the above procedure again.
 
 ##Rules for playing the blackjack
 
 The following are the rules for the blackjack server that is written
 
 * Blackjack with two decks
 * It generally pays blackjack in the ratio of 3:2
 * Initially, every player starts with 1000 chips
 * When the players lose all the money, then they are done with the game
 * Amounts in the bet can be done with the increments of 10 without crossing the available amount
 * No Insurance is provided with the game
 * Option Surrender is basically allowed on the First two cards
 * Generally Aces split for once
 * There are three states(WIN,LOSE,PUSH)
 * Double can also be performed on the bet to increase or double the amount
 * When the status is push, no one gets the amount.
 
 
 ##Explanation of working
 
 Web sockets are generally used for the communication of the servers and the interfaces. When the message is received by the server from the interface,it sends back the response to different destinations usually. The destinations can be as follows:
 
* /topic/game is the main destination for all the information of the game. Messages are sent to the interface from the server. Messages are sent based on the interface sending its bets and the players with the actions.
* /queue/player Messages here are to the interface to send a message to an endpoint on the server specifying the destination. This is really important to listen when the interface first registers to play blackjack. During the registration, it can be assigned with a secret playerId sent to us and we have to keep track of this playerId to perform actions and play any hands.
* /queue/errors If there is some invalid action performed, error code and error messgae will be sent in to the queue.


##API 

### /register
#### It usually registers a player in the current game

### /unregister
#### It usually unregisters a player in the current game

### /bet
#### It usually plays a bet for the next hand for a player

### /action
#### It usually sends an action to execute on the hand HIT,STAND,SURRENDER,DOUBLE,SPLIT

* 'Players' is an array of all the currently registered players
*  'Hands' is an array associated with each players with all the hands he is playing on. There is only one hand on the player until there is split.
* 'result' in each 'hand' object is null if the hand is currently in progress. If still the hand is in progress it is either WIN, PUSH or LOSE.
* 'handStatus' in each 'hand' object represents the current status of the hand. 
* 'dealer' will be null if the hand is in progress as it holds information on what cards are in the dealer's hands.
* 'gameStatus' is either 'HAND_IN_PROGRESS' or 'BETTING_ROUND'. During the betting round, we can place bets. During the hand, only actions on the current hand are accepted.


##Error Codes

* Error codes are displayed according to the status.
 

 

