package bdr;

public class SingleHouse {
	
	
		// declare and initialize class constants attributes
		private final double MAX_HOME_AREA = 1400.0;

		//declare and initialize attributes
		private double bedroomSize = 0.0;
		private double bathroomSize = 0.0;
		private double kitchenSize = 0.0;
		private double livingRoomSize = 0.0;
		private double kitchenArea = 0.0;
		private double livingArea = 0.0;
		private double bedroomArea = 0.0;
		private double bathroomArea = 0.0;
		private boolean overMaxArea = false;
	   
		//SingleStoryHome constructor
		SingleHouse(double borrowedBedroomArea,double borrowedBathroomArea, double borrowedKitchenArea, double borrowedLivingArea)
		{
			bedroomSize = borrowedBedroomArea;
			bathroomSize = borrowedBathroomArea;
			kitchenSize = borrowedKitchenArea;
			livingRoomSize = borrowedLivingArea;

		}//End of SingleStoryHome constructor
		//set method to assign new value to bedroomArea
		public void setBedroomArea(double borrowedBedroomNumber)
		{
			bedroomArea = borrowedBedroomNumber * bedroomSize;

		}//end of setBedroomArea
		//set method to assign new value to bathroomArea 
		public void setBathroomArea(double borrowedBathroomNumber)
		{
			bathroomArea = borrowedBathroomNumber * bathroomSize ;
		}//end of setBathroomArea
		//set method to assign new value to kitchenArea
		public void setKitchenArea()
		{
			kitchenArea = kitchenSize;
		}//end of setKitchenArea method
		//set Method to assign new value to living area
		public void setLivingArea()
		{
			livingArea = livingRoomSize;
		}//end of setLivingArea


		//get method to return value back to main class
		public double getBedroomArea()
		{
			return bedroomArea;
		}//end of getBedroomArea
		//get method to return value to main class
		public double getBathroomArea()
		{
			return bathroomArea;
		}//end of getBathroomArea
		//get method to return value to main class
		public double getKitchenArea()
		{
			return kitchenArea;
		}//end of getKitchenArea
		//get method to return value back to main class
		public double getLivingArea()
		{
			return livingArea;
		}//end of getLivingArea
		
		//get method to return value back to main class
		public double getHomeArea()
		{
			return (bedroomArea + bathroomArea + kitchenArea + livingArea);
		}//END of getHomeArea
		

		
		//get method to return value back to main class
		 public boolean getOverMaxAreaFlag()
		 {
			 //resets flag boolean 
			 if (getHomeArea() > MAX_HOME_AREA)
			 {
				 overMaxArea = true;
				 
			 } 
			 
			 return overMaxArea;
		 }//END of getOverMaxAreaFlag" 
		 


		
}//end of class



