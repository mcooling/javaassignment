package myPackage;

public class Calculate2 

/*
 * PSEUDOCODE. WHAT DO I WANT THE CLASS TO DO?!?
 * 
 * Going to need to keep this simple, initially
 * 
 * Read in the string, either from the text or file inputs
 * Calculate the frequency of each character
 * 
 * Pass results to Display class
 * 
 * LAB 7, ARRAYS (LETTER FREQUENCIES, TEXT PROCESSING)
 * LABS 5/6, METHODS
 */

{
    //variables to store the string passed in
    private String stringIn;
    private static char[] alphabetArray = new char[]
		{'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q',
		'r','s','t','u','v','w','x','y','z'};
    
    //create main constructor. requires a string
    //takes string values passed in from test calc class
    
    public Calculate2(String reqString) {
    	stringIn = reqString;
    }
    
    public void xCalculate2()
    {
    	//create int array
		//call charFrequency method, passing the string value

		int[] intArray;
		intArray = charFrequency(stringIn); //nested method call

		/*for(int i = 0; i < 26; i++) //loops through every character of the string passed in
			{
				if(intArray[i] > 0)
				{
					System.out.print("Char " + alphabetArray[i] + ": ");
					String stars = "";
					int counter = 0;

					for (int j = 0; j < intArray[i]; j++)
					{
						stars = stars + "*";
						counter++;
					}
					System.out.println(stars + " (" + counter + ")");
				}
			}*/

		//create a variable to store the largest number
		//create a loop to loop through the intArray to find the largest number
		//update the largest number variable

		int largestNumber = 0;
		for(int i = 0; i < intArray.length; i++)
		{
			if (intArray[i] > largestNumber)
			{
				largestNumber = intArray[i];
			}
		}

		//create a loop to cycle back through the array, checking the largest number
		//create an inner loop to print each time each letter features
		for(int i = largestNumber; i > 0; i--)
		{
			if (i < 10)
			{
				System.out.print(" "); //column spacing
			}

			System.out.print(i);
			System.out.print(" "); //column spacing
			for(int j = 0; j < intArray.length; j++)
			{
				if (intArray[j] >= i)
				{
					System.out.print("*");
				}
        		else
        			System.out.print(" ");
				System.out.print(" "); //column spacing
			}
			System.out.println();
		}

		//create a loop to print the character under each column
		System.out.print("   "); //column spacing
		for(int i = 0; i < alphabetArray.length; i++) {
			System.out.print(alphabetArray[i]);
			System.out.print(" "); //column spacing
		}

		System.out.println();

	}
	
    public static int [] charFrequency(String input) //takes string input from method call above
	{
		int[] intArray = new int[26]; //stores output from intArray for loop

		for(int i = 0; i < alphabetArray.length; i++) //loops through the alphabet array above
			{
				intArray[i] = timesCharOccurs(alphabetArray[i], input);
				//calls timesCharOccurs method below, passing letter of alphabet and the full string
			}
		return intArray; //passes value back to main method print line
	}
    
    public static int timesCharOccurs(char searchCharacter, String input) 
    //called by charFrequency method above
    //takes 'alphabetArray[i]' from each loop and full string
	{
	//transform the string into an array
	//use the .toCharArray() library method
		char [] stringArray = input.toCharArray(); //transform full string into an array
		int counter = 0; //counter for how many times the 'alphabetArray' char matches each array index value
		//create loop counter for each array index
		for (int i = 0; i < stringArray.length; i++) //test condition is the string array length
			{
				if(stringArray[i] == searchCharacter || stringArray[i] == Character.toUpperCase(searchCharacter))
				{
					counter ++; //increases counter value by 1 if there's a character match
				}
			}

		return counter; //returns counter to charFrequency method
    }
}
