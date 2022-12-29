package model;

public class GameController {
	public static final int ROWS_SIZE=3;
	public static final int COLUMNS_SIZE=3;
	public static final int PLAYERS_SIZE=3;
	private String[][] matriz;
	private Player[] players;
	private int turn;
	private int counter;

 	public GameController(String name){
 		matriz= new String[ROWS_SIZE][COLUMNS_SIZE];
 		players=new Player[PLAYERS_SIZE];
 		this.turn=2;
 		this.counter=0;

 	}
 	public int getTurn(){
 		return turn;
 	}
 	public void setTurn(int turn){
 		this.turn=turn;
 	}
 	public int getCounter(){
 		return counter;
 	}
 	public void setCounter(int counter){
 		this.counter=counter;
 	}
 	public String initMatriz(){
 		String msj="";
 		for (int i=0;i<ROWS_SIZE ;i++ ) {
			for (int j =0;j<COLUMNS_SIZE;j++ ) {
				matriz[i][j]=" ";
        	}
        }
        msj="Game Inicializated";
        return msj;
 	}
 	public String addPlayerOne(String namePlayer){
   		String msj="";
 		int emptyPos = searchEmptyposPlayer();
 		int idPlayer=1;
 		Player newPlayer= new Player(idPlayer,namePlayer);
 		if(emptyPos!=-1){
 			players[emptyPos]=newPlayer;
 			msj="Welcome to the game, player "+namePlayer;
 		}
 		return msj;
 	}
 	public String addPlayerTwo(String namePlayer){
 		String msj="";
 		int emptyPos = searchEmptyposPlayer();
 		int idPlayer=2;
 		Player newPlayer= new Player(idPlayer,namePlayer);
 		if(emptyPos!=-1){
 			players[emptyPos]=newPlayer;
 			msj="Welcome to the game, player "+namePlayer;
 		}
 		return msj;
 	}
 	public boolean validateIfPlayerExist(String namePlayer){
 		boolean playerExist=false;
 		for (int i=0;i<PLAYERS_SIZE&&!playerExist;i++ ) {
 			if(players[i]!=null){
 				if(players[i].getName().equals(namePlayer)){
 					players[i]=null;	
					playerExist=true;	
 				}
 			}
 		}
 		return playerExist;
 	}
 	public int searchEmptyposPlayer(){
		int pos= -1;
		boolean isEmpty=false;
		for(int i = 1; i < 	PLAYERS_SIZE && !isEmpty; i++){
			if(players[i] == null){
				pos=i;
				isEmpty = true; 
			}
		}
		return pos; 
	}
	public String theTurn(){
		int turn=getTurn();
		String msj="";
		if(turn==1){
			msj="<<-<< <<-<< -- >>->> >>->>\n" +
			"Player "+ players[1].getName()+ " it's your turn";
		}
		else{
			msj="<<-<< <<-<< -- >>->> >>->\n" +
			"Player "+ players[2].getName()+ " it's your turn";
		}
		return msj;
	}
 	public String[][] fillMatriz(int positionX, int positionY){
		if(getTurn()==1){
			for (int i=0;i<ROWS_SIZE ;i++ ) {
				for (int j =0;j<COLUMNS_SIZE;j++ ) {
					if(i==positionX&&j==positionY){
						matriz[i][j]="X";	
					}
				}
			}
		}
		else{
			for (int i=0;i<ROWS_SIZE ;i++ ) {
				for (int j =0;j<COLUMNS_SIZE;j++ ) {
					if(i==positionX&&j==positionY){
						matriz[i][j]="O";		
					}
				}
			}	
		}
		return matriz;
	}
	public void count(){
		int counter=getCounter();
		setCounter(counter+1);
	}
 	public String showMatriz(int positionX, int positionY){
		//Print matriz
		String msj="";
		 for (int i=0;i<ROWS_SIZE ;i++ ) {
			for (int j =0;j<COLUMNS_SIZE;j++ ) {
		 		msj=msj+"|"+matriz[i][j];		 
		 		if(j==2){
		 			msj=msj+"\n";
		 		}
			}
		}
		return msj;
	}
	public boolean validateIfPositionIsEmpty(int positionX, int positionY){
		boolean isEmpty=false;
		if(matriz[positionX][positionY]==" "){
			isEmpty=true;
		}
		return isEmpty;
	}
	
	public boolean validateIfGameIsInicializated(){
		boolean isInicializated=false;
		for(int i=0; i<ROWS_SIZE; i++){
			for(int j=0; j<COLUMNS_SIZE;j++){
				if(matriz[i][j]==" "){
					isInicializated=true;
				}
			}
		}
		return isInicializated;
	}	
	public String winGame(){
		String msj="";
		for (int i=0;i<ROWS_SIZE ;i++ ) {
			for (int j =0;j<COLUMNS_SIZE;j++ ) {
				if(matriz[i][j]!=" "){
					if(matriz[0][0]!=" "&&matriz[0][0].equals(matriz[0][1])&&matriz[0][0].equals(matriz[0][2])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
					else if(matriz[1][0]!=" "&&matriz[1][0].equals(matriz[1][1])&&matriz[1][0].equals(matriz[1][2])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
					else if(matriz[2][0]!=" "&&matriz[2][0].equals(matriz[2][1])&&matriz[2][0].equals(matriz[2][2])){
						msj="Congratulations player " + players[getTurn()] + " you have won, you're the best!!!";
					}
					else if(matriz[0][0]!=" "&&matriz[0][0].equals(matriz[1][0])&&matriz[0][0].equals(matriz[2][0])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
					else if(matriz[0][1]!=" "&&matriz[0][1].equals(matriz[1][1])&&matriz[0][1].equals(matriz[2][1])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
					else if(matriz[0][2]!=" "&&matriz[0][2].equals(matriz[1][2])&&matriz[0][2].equals(matriz[2][2])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
					else if(matriz[0][0]!=" "&&matriz[0][0].equals(matriz[1][1])&&matriz[0][0].equals(matriz[2][2])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
					else if(matriz[0][2]!=" "&&matriz[0][2].equals(matriz[1][1])&&matriz[0][2].equals(matriz[2][0])){
						msj="Congratulations player " + players[getTurn()].getName() + " you have won, you're the best!!!";
					}
				}
			}
		}		
		return msj;	
	}
	public String drawGame(){
		String msj="";
		if(getCounter()==9){
			msj="Wow, it's a draw!! :O";
		}
		return msj;
	}
	public boolean gameFinished(){
		boolean gamefinished=false;
		if(!winGame().equals("")||!drawGame().equals("")){
			gamefinished=true;
			setCounter(0);
		}
		return gamefinished;
	}
	public void changeTurn(){
		int changeTurn=getTurn();
		if(changeTurn==1){
			setTurn(changeTurn+1);
		}
		else{
			setTurn(changeTurn-1);
		}
	}
	public void cleanMatriz(){
 		String msj="";
 		for (int i=0;i<ROWS_SIZE ;i++ ) {
			for (int j =0;j<COLUMNS_SIZE;j++ ) {
				matriz[i][j]=" ";
        	}
        }
 	}
}	