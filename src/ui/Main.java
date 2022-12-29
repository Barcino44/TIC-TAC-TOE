package ui; 

import java.util.Scanner; 
import model.*; 

public class Main{
	
	private Scanner reader; 

	private GameController controller; 

	public Main(){
		reader = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Main main = new Main(); 
		main.initGame();

		int option = -1; 
		do{

			option = main.getOptionShowMenu(); 
			main.executeOption(option);

		}while(option != 0);

	}


	public int getOptionShowMenu(){
		int option = 0; 
		System.out.println(printMenu());

		option = validateIntegerOption(); 

		return option; 
	}

	public String printMenu(){
		return "<<-<< <<-<< Welcome >>->> >>->>\n" +
			"1.Init game\n"+
			"2.Play game";
		}

	public void executeOption(int option){
		String namePlayerOne="";
		String namePlayerTwo="";
		int positionX=-1;
		int positionY=-1;
		String msj2="";
		String msj="";
		String msj1="";
		switch(option){
			case 1:
				if(controller.validateIfGameIsInicializated()!=false){
					System.out.println("Dude, the game has already been inicializated");
				}
				else{
					System.out.println("Enter the name of the player One");
					namePlayerOne=reader.next();
					System.out.println(controller.addPlayerOne(namePlayerOne));

					System.out.println("Enter the name of the player Two");
					namePlayerTwo=reader.next();
					if(controller.validateIfPlayerExist(namePlayerTwo)==true){
						System.out.println("You cannot have the same name of the player One!!");
					}
					else{
					System.out.println(controller.addPlayerTwo(namePlayerTwo));
					msj=controller.initMatriz();
					System.out.println(msj);
					}
				}
			break;
			case 2:
				if(controller.validateIfGameIsInicializated()==false){
					System.out.println("Sorry dude the game is not inicializated");
				}
				else{
					while(controller.gameFinished()==false){
						controller.changeTurn();
						System.out.println(controller.theTurn());
						System.out.println("Position X (ROWS) ");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an Integer");
							System.out.println("Position X (ROWS)");
						}
						positionX=reader.nextInt();

						while (positionX!=0&&positionX!=1&&positionX!=2) {
							System.out.println("Thats not a valid position");
							positionX=reader.nextInt();
						}

						System.out.println("Position Y (COLUMNS)");
						while(!reader.hasNextInt()){
							reader.next();
							System.out.println("Invalid, enter an Integer");
							System.out.println("Position Y (COLUMNS)");
						}
						positionY=reader.nextInt();

						while (positionY!=0&&positionY!=1&&positionY!=2) {
							System.out.println("Thats not a valid position");
							positionY=reader.nextInt();
						}
						if(controller.validateIfPositionIsEmpty(positionX, positionY)==false){
							System.out.println("The position is not Empty\n"+
												"You lost the turn :c"							);
							System.out.println("\n"+controller.showMatriz(positionX, positionY));
						}
						else{
							controller.count();
						 	controller.fillMatriz(positionX, positionY);
						 	msj="\n"+controller.showMatriz(positionX, positionY);
						 	System.out.println(msj);
							if (!controller.winGame().equals("")) {
								msj1=controller.winGame();
						 		System.out.println(msj1);
							}
							else if (!controller.drawGame().equals("")){
							 	msj2=controller.drawGame();
							 	System.out.println(msj2);
							}
						}
					}
					controller.cleanMatriz();
				}
			break;
			case 0:
				System.out.println("Exit program.");
			break; 

			default: 
				System.out.println("Invalid Option");
			break; 

		}
				
	}
	public void initGame(){
		System.out.println("Welcome to Triqui enter a letter to start");
		String name = reader.nextLine(); 
		this.controller = new GameController(name);

	}

	public int validateIntegerOption(){
		int option = 0; 

		if(reader.hasNextInt()){
			option = reader.nextInt(); 
		}
		else{
			// clear reader. 
			reader.nextLine(); 
			option = -1; 
		}

		return option; 
	}

}
