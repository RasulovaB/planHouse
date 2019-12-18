package bdr;
import java.util.Scanner;


public class MySweetProject {

	
		//CLASS CONSTANTS - GLOBAL VALUES
		public static final String DESIGN_MAIN_MENU = "MAIN MENU";
		public static final String ERROR_MESSAGE = "Invalid Selection.";
		public static final double COUNTY_CODE = 1400.0;
		//Main method
		public static void main(String[] args) 
		{
			final double BEDROOM_SIZE = 231.0;
			final double BATHROOM_SIZE = 115.0;
			final double KITCHEN_SIZE = 192.0;
			final double LIVING_ROOM_SIZE = 256.0;

			//declare and initialize all local variables and constants
			Scanner input = new Scanner (System.in);
			int currentBedroomNumber = 0;
			int currentBathroomNumber = 0;
			boolean currentLimitFlag = false;
			boolean overLimitFlag = true;
			char menuSelection = ' ';
			String userName = "";
			double currentBedroomArea = 0.0;
			double currentBathroomArea = 0.0;
			double currentKitchenArea = 0.0;
			double currentLivingArea = 0.0;
			double currentHomeArea = 0.0;
			//Create one Class Object
			SingleHouse myHome = new SingleHouse(BEDROOM_SIZE, BATHROOM_SIZE,KITCHEN_SIZE, LIVING_ROOM_SIZE);

			//call welcome banner
			displayWelcomeBanner();
			//assign userName

			/*User Input*/
			userName = getUserName(input);

			//Prime read of menuSelection
			menuSelection = validateMainMenu(input,DESIGN_MAIN_MENU,ERROR_MESSAGE );

			//run while not quit loop
			while (menuSelection != 'Q')
			{
				//call validateBedroomNumber
				currentBedroomNumber = validateBedroomNumber(input, ERROR_MESSAGE);

				//call validateBathroomNumber
				currentBathroomNumber = validateBathroomNumber(input, ERROR_MESSAGE);

				//invoke setBedroomArea in the SingleStoryHome class
				myHome.setBedroomArea(currentBedroomNumber);

				//invoke setBathroomArea in the SingleStoryHome class
				myHome.setBathroomArea(currentBathroomNumber);

				//invoke setKitchenArea in the SingleStoryHome class
				myHome.setKitchenArea();

				//invoke setLivingArea
				myHome.setLivingArea();

				//get the bedroom area results from SingleStoryHome class
				currentBedroomArea = myHome.getBedroomArea();
				//get the bathroom area results from SingleStoryHome class
				currentBathroomArea = myHome.getBathroomArea();
				//get the kitchen area results
				currentKitchenArea = myHome.getKitchenArea();
				//get the living area results
				currentLivingArea = myHome.getLivingArea();
				//get the home area results
				currentHomeArea = myHome.getHomeArea();

				//get current limit flag results
				currentLimitFlag = myHome.getOverMaxAreaFlag();
				//test if over limit flag is true
				if (currentLimitFlag == overLimitFlag)
				{
					displayOverMaxArea(currentLimitFlag);
				}//end of test
				else //no test condition
				{
					displayDesignDetails(userName,currentBedroomNumber, currentBathroomNumber, currentBedroomArea, 
							currentBathroomArea,currentKitchenArea, currentLivingArea,currentHomeArea);
				}//end of test

				//Call validateMainMenu 
				menuSelection = validateMainMenu(input,DESIGN_MAIN_MENU,ERROR_MESSAGE );


			}//end of run-while not quit loop
			//call display farewell message
			displayFarewellMessage(userName);

		}//end of main method


		//Welcome Banner
		public static void displayWelcomeBanner()
		{
			System.out.println("Welcome to our program DesignDreamHome!");
			System.out.println("This program will calculate and design");
			System.out.println("the area of your dream home.");
			System.out.printf("%-10s\n","Let's begin!");
			System.out.println("______________________________________________________________");
			System.out.println();

		}//end of welcome banner
		//Get user name
		public static String getUserName(Scanner borrowedInput)
		{
			String localUserName = "";
			System.out.print("Provide user first name: ");
			localUserName = borrowedInput.nextLine();
			System.out.println("\n***** ***** ***** ***** ***** *****");
			System.out.println("Welcome " + localUserName + "!");
			System.out.println("***** ***** ***** ***** ***** *****");
			return localUserName;
		}//end of get user name
		//validate main menu input
		public static char validateMainMenu(Scanner borrowedInput, String BORROWED_DESIGN_MAIN_MENU,
				String BORROWED_ERROR_MESSAGE)
		{
			char localMenuSelection = ' ';
			//call display main menu
			displayMainMenu(BORROWED_DESIGN_MAIN_MENU);

			//Prime read selection
			borrowedInput.nextLine();
			localMenuSelection = borrowedInput.nextLine().toUpperCase().charAt(0);
			//must validate input
			while (localMenuSelection != 'A' && localMenuSelection != 'Q')
			{
				System.out.println("*************************************************************");	
				System.out.printf("%-20s", BORROWED_ERROR_MESSAGE);	
				System.out.println("\nPlease try again. ");
				System.out.println("*************************************************************");
				//call displayMainMenu
				displayMainMenu(BORROWED_DESIGN_MAIN_MENU);
				//Modify LCV
				localMenuSelection = borrowedInput.nextLine().toUpperCase().charAt(0);
			}//end of validate input
			return localMenuSelection;
		}//end of validateMainMenu

		//display main menu
		public static void displayMainMenu( String BORROWED_BORROWED_DESIGN_MAIN_MENU)
		{
			System.out.println();	
			System.out.println("\nNOTE: the maximum area of the dream home  ");
			System.out.println("allowed by county code is "+ COUNTY_CODE +" square feet.  ");
			System.out.println("\nNow select from our menu: ");
			System.out.println("_____________________________________________________________\n");
			System.out.print(BORROWED_BORROWED_DESIGN_MAIN_MENU +":\n");
			System.out.printf("\n%-1s%14s\n","[A]", "PLAN A HOME ");
			System.out.printf("\n%-1s%17s\n","[Q]", " TO QUIT PROGRAM");
			System.out.println("_____________________________________________________________\n");
			System.out.print("\nPlease enter your selection here: ");

		}//END OF displayMainMenu

		//validate bedroom number input
		public static int validateBedroomNumber(Scanner borrowedInput, String BORROWED_ERROR_MESSAGE)
		{
			int localBedroomNumber = 0;


			System.out.print("\nHow many bedrooms whould you like?");
			System.out.print("\nEnter a number here: ");
			localBedroomNumber = borrowedInput.nextInt();
			//must validate input
			while (localBedroomNumber <= 0 )
			{
				System.out.println("*************************************************************");	
				System.out.printf("%-20s", BORROWED_ERROR_MESSAGE);	
				System.out.println("\nPlease try again. ");
				System.out.println("*************************************************************");
				System.out.print("\nHow many bedrooms whould you like?");
				System.out.print("\nEnter a number here: ");
				localBedroomNumber = borrowedInput.nextInt();
			}//end of validate
			return localBedroomNumber;
		}//end of validateBedroomNumber
		//validate bathroom number
		public static int validateBathroomNumber(Scanner borrowedInput, String BORROWED_ERROR_MESSAGE)
		{
			int localBathroomNumber = 0;
			System.out.print("How many bathrooms whould you like?");
			System.out.print("\nEnter a number here: ");
			localBathroomNumber = borrowedInput.nextInt();
			//MUST VALIDATE INPUT
			while (localBathroomNumber <= 0 )
			{
				System.out.println("*************************************************************");	
				System.out.printf("%-20s", BORROWED_ERROR_MESSAGE);	
				System.out.println("\nPlease try again. ");
				System.out.println("*************************************************************");
				System.out.print("How many bedrooms whould you like?");
				System.out.print("\nEnter a number here: ");
				//MODIFY LCV
				localBathroomNumber = borrowedInput.nextInt();
			}
			return localBathroomNumber;
		}//end of validateBathroomNumber
		//DISPLAY WARNING OVER LIMIT FLAG
		public static void displayOverMaxArea(boolean borrowedLimitFlag)
		{
			System.out.println();
			System.out.println("******************* WARNING **********************************");	
			System.out.println("The over limit test came back with the result of " + borrowedLimitFlag + ".");
			System.out.println("We appologise, the home cannot be created ");
			System.out.println("with the current dimensions.");
			System.out.println("**************************************************************");	
		}//end of displayOverMaxArea
		//DISPLAY REPORT
		public static void displayDesignDetails(String borrowedUserName,int borrowedBedroomNumber, int borrowedBathroomNumber, 
				double borrowedBedroomArea,double borrowedBathroomArea,double borrowedKitchenArea, double borrowedLivingArea,
				double borrowedHomeArea)
		{
			System.out.printf("\n%-5s%s%s\n","Congratulations ",borrowedUserName,"!");

			System.out.printf("\n%40s\n", "             * HOME DESIGN REPORT *" );
			System.out.println("______________________________________________________________");
			System.out.printf("\n%-2s%38s%9s\n","*DESCRIPTION*","*VALUE/NUMBER*","*UNIT*");
			System.out.println();
			System.out.printf("\n%-2s%20d\n","NUMBER OF BEDROOM:           ",  borrowedBedroomNumber);
			System.out.printf("\n%-2s%,30.1f%8s\n","BEDROOM AREA:        ", borrowedBedroomArea, "sqft");
			System.out.printf("\n%-2s%19d\n","NUMBER OF BATHROOM:           ", borrowedBathroomNumber);
			System.out.printf("\n%-2s%,31.1f%8s\n","BATHROOM AREA:      ", borrowedBathroomArea, "sqft");
			System.out.printf("\n%-2s%,30.1f%8s\n","KITCHEN AREA*:       ", borrowedKitchenArea, "sqft");
			System.out.printf("\n%-2s%,26.1f%8s\n","LIVING ROOM AREA*:       ", borrowedLivingArea, "sqft");
			System.out.printf("\n%-2s%,28.1f%8s\n","HOME AREA:             ", borrowedHomeArea, "sqft");
			System.out.println("______________________________________________________________");
			System.out.println("* This planning program allows for a single ");
			System.out.println("  kitchen and living space only.");
		}//END OF DISPLAY REPORT

		//displayFarewellMessage
		public static void displayFarewellMessage(String borrowedUserName)
		{
			System.out.printf("\n%-10s%s%s\n","Thank you, ",borrowedUserName,", for using our program.");
			System.out.printf("%-10s","It was our pleasure to assist you!");
		}//end of displayFarewellMessage

}//END OF MAIN CLASS



