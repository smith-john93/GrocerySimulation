package grocery;

public class GroceryData {

		private String brand;
		private String name;
		private String weight;
		private float cost;
		private String UPC;
		
		public GroceryData(String brand, String name, String weight, float cost, String uPC) {
			super();
			this.brand = brand;
			this.name = name;
			this.weight = weight;
			this.cost = cost;
			UPC = uPC;
		}//ends constructor

		@Override
		public String toString() {
			return "Item: " + brand + " " + name +": "
					+"Weight: "+ weight + "\nPrice: $" + cost
					+"\nUPC: " + UPC;
		}//end to string

		public float getCost() {
			return cost;
		}//returns cost

		public void setCost(float cost) {
			this.cost = cost;
		}//sets cost

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			GroceryData other = (GroceryData) obj;
			if (UPC == null) {
				if (other.UPC != null)
					return false;
			} else if (!UPC.equals(other.UPC))
				return false;
			return true;
		}//ends equals to method.
		
		public String getName() {
			return name;
		}
		//Checks to see if UPC's match user input and one in the arrayList. 	
}
