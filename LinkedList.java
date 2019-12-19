/*        CSC3410 -Spring 2015 
          Sidney Seay -sseay5@student.gsu.edu 
          DateDue: 03-3-2015 
          Assignment: 3, Algebra Calculator Code 
          File(s): LinkedList.java 
*/ 
/*
  LinkedList class
  Node type and LinkedList type

*/

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/*
 * 
 * This program defines a Linked List class using a hash table.
 * Keys and values in the table are of type string. 
 * The Key cannot be null.
 * The default constructor creates a table 
 * that initially has 164 locations but the table increases in size if it 
 * becomes more than 3/4 full - a count of the number of items
 * in the hash table is kept in an instance variable.
 *
 */
public class LinkedList {

   /*
    * We cannot have duplicate Keys in the hash table.  
    * This private nested class is used internally to implement linked lists.  
    * The ListNode holds a (key, value) pair.
    *   
    */
   private static class ListNode {
      String key;
      String value;
      ListNode next;  // Pointer to next node in the list;
                      // A null marks the end of the list.
   }

   private ListNode[] table;  // The hash table represent a Link Node

   private int count;  // The number of (key, value) pairs in the Link Node
   
   /*
    * Create a hash table with an initial size of 164.
    * This is the constructor
    */
   public LinkedList() {
      table = new ListNode[164];

   }
   
   /*
    * Create a hash table with an initial size.
    * Check for initalSize > 0.
    */
   public LinkedList(int initialSize) {
      if (initialSize <= 0)
         throw new IllegalArgumentException("Illegal table size");
      table = new ListNode[initialSize];
   }

   /*
    * M A I N
   */
   public static void main(String[] args){
   	  Scanner scan = new Scanner( System.in ); 
   	  
      LinkedList table = new LinkedList(2);  // Initial size of table is 2.
      // string variables
      String sInput = "";
      String key = "";
      String key1 = "";
      String key2 = "";
      String value = "";
      // boolean variable
      boolean foundValue = false;
      //
      while (true) {
         System.out.println("\nMenu:");
         System.out.println("   1) Create a set");
         System.out.println("   2) Print the list of created sets");
         System.out.println("   3) Print a set");
         System.out.println("   4) Print sorted");
         System.out.println("   5) Membership check");
 		 System.out.println("    6) Subset check");
 		 System.out.println("    7) Sorted check");    		
 		 System.out.println("    8) Union");
 		 System.out.println("    9) Intersection");
 		 System.out.println("   10) Subtraction");
         System.out.println("  11) EXIT");
         //
         System.out.print("Please enter the number of the command:  ");
 		 
         scan = new Scanner(System.in);
 		 sInput = scan.nextLine();
 		 
         //case "1":  Create a Set
 		 if (sInput.trim().equals("1"))
 		 {
            System.out.println("\n   Please enter a name: ");
            key = scan.nextLine();
            System.out.println("   Please enter values separated by a space: ");
            value = scan.nextLine();
            table.put(key, value);
            
            continue;
 		 }
         //case "2":  Print the list of created Set
 		 else if (sInput.trim().equals("2"))
 		 {
 			// print entire content of the hash table 
            table.printAll();
            
            continue;
 		 }
         //case "3":  Print a Set
 		 else if (sInput.trim().equals("3"))
 		 {
 			// Print a Set content 
            System.out.println("\n   Please enter a set name: ");
            key = scan.nextLine();
            System.out.println("   Set contain " + table.get(key));
            
            continue;
 		 }
         //case "4":  Print Sorted
 		 else if (sInput.trim().equals("4"))
 		 {
            System.out.println("\n   Please enter a set name: ");
            key = scan.nextLine();
            table.sort(key);
            
            continue;
 		 } 		 
         //case "5":  Membership Check
 		 else if (sInput.trim().equals("5"))
 		 {
            System.out.println("\n   Please enter a set name: ");
            key = scan.nextLine();
            System.out.println("\n   Please enter a value to look-up: ");
            value = scan.nextLine();
            //
            foundValue = false;
            foundValue = table.memberShipCheck(key, value);
            if (foundValue)
            {
                System.out.println("   Set " + key + " contain " + value);            	
            }
            else
            {
                System.out.println("   Set " + key + " does not contain " + value);            	
            }

            continue;
 		 }
         //case "6":  Subset check
 		 else if (sInput.trim().equals("6"))
 		 {
             System.out.println("\n   Please enter first set name: ");
             key1 = scan.nextLine();
             System.out.println("   Please enter second set name: ");
             key2 = scan.nextLine();
             table.checkSubsetValue(key1, key2);
             
             continue;
 		 }
         //case "7":  Sorted check
 		 else if (sInput.trim().equals("7"))
 		 {
 			 // TODO:
 		 } 		 
         //case "8": Union
 		 else if (sInput.trim().equals("8"))
 		 {
            System.out.println("\n   Please enter first set name: ");
            key1 = scan.nextLine();
            System.out.println("   Please enter second set name: ");
            key2 = scan.nextLine();
            table.getUnionValue(key1, key2);
            
            continue;
 		 }
         //case "9":  Intersection
 		 else if (sInput.trim().equals("9"))
 		 {
             System.out.println("\n   Please enter first set name: ");
             key1 = scan.nextLine();
             System.out.println("   Please enter second set name: ");
             key2 = scan.nextLine();
             table.getIntersectionValue(key1, key2);
 		 }
         //case "10":  Subtraction
 		 else if (sInput.trim().equals("10"))
 		 {
 			 // TODO:
 		 } 		 
         //case "11":
 		 else if (sInput.trim().equals("11"))
 		 {
            return;  // End program by returning from main()
 		 }
         //default:
 		 else
 		 {
            System.out.println("Menu selection not valid.");
            
            continue;
         }
      }
   }
   
   /*
    * Print entire List.
    */
   void printAll() {
 	  System.out.println("Print all Set");
 	  //
      for (int i = 0; i < table.length; i++) {
    	  
         ListNode list = table[i]; // get value of linked list number i.
         while (list != null) {
            System.out.print("  (" + list.key + ", " + list.value + ")");
            list = list.next;
         }
         System.out.println();
      }
   } // end printAll()
   
   /*
    * Associate the specified value with the specified key.
    * Key cannot be null.
    */
   public void put(String key, String value) {
      boolean duplicateFound = false;
      
      assert key != null : "The key must be non-null";
      
      int bucket = hash(key); // Which location should this key be in?
      
      ListNode list = table[bucket]; // get value in table at this location 

      while (list != null) {
         // Search the nodes in the list, to see if the key already exists.
         if (list.key.equals(key))
            break;  // key exist
         
         list = list.next;
      }
      // At this point either list is null or list.key.equals(key) exist
      if (list != null) {
            // Since list is not null, we have found the key.
         System.out.println("Set " + list.key + " already exist with value " +  list.value);
        
      }
      else {
             // Since list == null, the key is not already in the list.
             // Add a new node at the head of the list to contain the
             // new key and its associated value.
         if (count >= 0.75*table.length) {
               // The table is becoming too full.  Increase its size
               // before adding the new node.
            resize();
            bucket = hash(key);  // Recompute hash code, since it
                                 // depends on the table size.
         }
         // determine if Set contain duplicate value
        String[] valueCheck = value.split(" ");
     	int iLen = valueCheck.length;
     	for (int a = 0; a < iLen; a++) {
             for (int b = a + 1; b < iLen; b++) {
                 if (valueCheck[b].equals(valueCheck[a])) {
                     // duplicate found
                 	duplicateFound = true;
                 	a = iLen;
                 	break;
                 }
             }
     	}
        if (duplicateFound) {
            // found duplicate value in Set
         System.out.println("Set " + key + " contain duplicate value " +  value);
        }
        else
        {
            // duplicate value not found
        	// add to ListNode
            ListNode newNode = new ListNode();
            newNode.key = key;
            newNode.value = value;
            newNode.next = table[bucket];
            table[bucket] = newNode;
            count++;  // Count the newly added key.        	
        }
      }
   }
   
   /*
    * Retrieve the value associated with the specified key in the table, 
    * if there is any.  If not, the value null will be returned.
    * @param key The key whose associated value we want to find
    * @return the associated value, or null if there is no associated value
    */
   public String get(String key) {
      
      int bucket = hash(key);  // At what location should the key be?
      
      ListNode list = table[bucket];  // For traversing the list.
      while (list != null) {
            // Check if the specified key is in the node that
            // list points to.  If so, return the associated value.
         if (list.key.equals(key))
            return list.value;
         list = list.next;  // Move on to next node in the list.
      }
      // If we get to this point then we have looked at every
      // node in the list without finding the key.  Return
      // the value null to indicate that the key is not in the table.
      System.out.println();
      System.out.print(" This Set does not exist " + key);
      
      return null;  
   }

   /*
    * Membership Check - does Set exist with a particular value
    */
   public boolean memberShipCheck(String key, String value)
   {
	      int bucket = hash(key);  // In what location should key be?
	      
	      ListNode list = table[bucket];  // For traversing the list.
	      while (list != null) {
	        // If we find the key in this node, return true.
	         if (list.key.equals(key))
	         {
	        	 if (list.value.contains(value))
	        	 {
	 	            return true;	        		 
	        	 }
	        	 else
	        	 {
	        		 return false; 
	        	 }
	         }
             list = list.next;	         
	      }
	      // If we get to this point, we know that the key does
	      // not exist in the table.
	      return false;	   
   }

 /*
   Check for Subset - first set and second set
*/
	public void checkSubsetValue(String key1, String key2) {
		String value1 = "";
		String value2 = "";
		String value3 = "";
		boolean subsetFound = false;
		
		// get first Set name value
          value1 = get(key1);
       // get second Set name value
          value2 = get(key2);
       //
       value3 = value1 + " " + value2;    
       String[] valueCheck = value3.split(" ");
       int iLen = valueCheck.length;
       // check if first set name contain same value
       // as second set name
       // sub set
       for (int a = 0; a < iLen; a++) {
          for (int b = a + 1; b < iLen; b++) {
              if (valueCheck[b].equals(valueCheck[a])) {
                 // duplicate value found
                	subsetFound = true;
                   	a = 100; // exit for loop
                   	break;
               }
          }
      }                 
      System.out.println();       
      if (subsetFound){
    	   // set name 1 is a sub set of set name 2       
          System.out.println("Set name " + key1 + " is a sub set of " + key2);
          System.out.println("first set value " + value1 + " second set value " + value2);          
      }
      else {
    	  // set name 1 is not a sub set of set name 2       
          System.out.println("Set name " + key1 + " is not a sub set of " + key2);
          System.out.println("first set value " + value1 + " second set value " + value2);          
      }
	}   
   
 /*
   Union two Set
*/
	public void getUnionValue(String key1, String key2) {
		String value1 = "";
		String value2 = "";
		String value3 = "";
		String value4 = "";
		boolean duplicateFound = false;
		
		// get first Set name value
          value1 = get(key1);
       // get second Set name value
          value2 = get(key2);         
       // determine if union Set contain duplicate value
      value3 = value1 + " " + value2;    
      String[] valueCheck = value3.split(" ");
   	  int iLen = valueCheck.length;
   	  for (int a = 0; a < iLen; a++) {
           for (int b = a + 1; b < iLen; b++) {
               if (valueCheck[b].equals(valueCheck[a])) {
                // duplicate value found
               	duplicateFound = true;
               	break;
               }
           }
           if (!duplicateFound){
        	   value4 = value4 + " " + valueCheck[a];
           }
           // reset field duplicateFound
       	   duplicateFound = false;
   	  }       
	   // blank line
      System.out.println();       
	   // Print set name       
      System.out.println("Union of set name " + key1 + " and " + key2);        
       
      //System.out.println("contain: " + value1 + " "  + value2);
      System.out.println("contain: " + value4);      
			
	}   
	/*
	   Intersection two Set
	*/
	public void getIntersectionValue(String key1, String key2) {
		String value1 = "";
		String value2 = "";
		String value3 = "";
		String value4 = "";
		boolean duplicateFound = false;
		
		// get first Set name value
          value1 = get(key1);
       // get second Set name value
          value2 = get(key2);         
       // determine if Intersection exist
      value3 = value1 + " " + value2;    
      String[] valueCheck = value3.split(" ");
   	  int iLen = valueCheck.length;
   	  //
   	  // TODO: need to update code
   	  // Intersection
   	  //
   	  for (int a = 0; a < iLen; a++) {
           for (int b = a + 1; b < iLen; b++) {
               if (valueCheck[b].equals(valueCheck[a])) {
                // duplicate value found
               	duplicateFound = true;
               	break;
               }
           }
           if (duplicateFound){
        	   value4 = value4 + " " + valueCheck[a];
           }
           // reset field duplicateFound
       	   duplicateFound = false;
   	  }       
	   // blank line
      System.out.println();       
	   // Print set name       
      System.out.println("Intersection of set name " + key1 + " and " + key2);        
       
      //System.out.println("contain: " + value1 + " "  + value2);
      System.out.println("contain: " + value4);      
			
	}	
	
   
   /*
    * Test whether the specified key has an associated value in the table.
    * @param key The key that we want to search for.
    * @return true if the key exists in the table, false if not
    */
   public boolean containsKey(String key) {
      
      int bucket = hash(key);  // In what location should key be?
      
      ListNode list = table[bucket];  // For traversing the list.
      while (list != null) {
            // If we find the key in this node, return true.
         if (list.key.equals(key))
            return true;
         list = list.next;
      }
      
      // If we get to this point, we know that the key does
      // not exist in the table.
      
      return false;
   }

   
   /*
    * Return the number of key/value pairs in the table.
    */
   public int size() {
      return count;
   }

   /*
    * 
    */
   public void sort(String key)
   {
	      String value = "";
	      boolean foundValue = false;
          TreeMap<String, String> tMap = new TreeMap<String, String>();
          //
	      int bucket = hash(key);  // In what location should key be?
	      
	      ListNode list = table[bucket];  // For traversing the list.
	      while (list != null) {
	            // If we find the key in this node, return true.
	         if (list.key.equals(key))
	         {
                 value = list.value;
                 foundValue = true;
	        	 // values
                 String[] valueCheck = value.split(" ");
                 int iLen = valueCheck.length;
	        	 // add value to Map - Map key is value
                 // Map is sorted by
                 for (int a = 0; a < iLen; a++) {
                    tMap.put(valueCheck[a], valueCheck[a]);
                 }                 
	         }
	         list = list.next;
	      }	      
          //
	      if (foundValue) {
              // Get a set of the value from the Map
	    	  Set set = (Set)tMap.entrySet();  // case TreeMap to Set
	    	  Iterator itr = set.iterator();
	    	  //
	    	  System.out.println();
              System.out.println(" set name " + key + " sorted value is");
	    	  while (itr.hasNext()){
                  Map.Entry mapE = (Map.Entry) itr.next();
                  // print sorted list                  
	              System.out.println(mapE.getKey());              	    	  	    		  
	    	  }
	      }
	      else {
              System.out.println();
              System.out.println(" set name " + key + "does not exist");              
	      }
	    	  
   }
   
   /*
    * Compute a hash code for the key; key cannot be null.
    * The hash code depends on the size of the table as
    * well as on the value returned by key.hashCode().
    */
   private int hash(Object key) {
      return (Math.abs(key.hashCode())) % table.length;
   }

   /*
    * Double the size of the table, and redistribute the
    * key/value pairs to their proper locations in the
    * new table.
    */
   private void resize() {
      ListNode[] newtable = new ListNode[table.length*2];
      for (int i = 0; i < table.length; i++) {
             // Move all the nodes in linked list number i into the new table.  
             // No new ListNodes are created.  The existing ListNode for each
             // key/value pair is moved to the new table.  This is done by 
             // changing the "next" pointer in the node and by making a pointer 
             // in the new table point to the node.
         ListNode list = table[i]; // For traversing linked list number i.
         while (list != null) {
               // Move the node pointed to by list to the new table.
            ListNode next = list.next;  // The is the next node in the list.
               // Remember it, before changing the value of list!
            int hash = (Math.abs(list.key.hashCode())) % newtable.length;
               // hash is the hash code of list.key that is 
               // appropriate for the new table size.  The
               // next two lines add the node pointed to by list
               // onto the head of the linked list in the new table
               // at position number hash.
            list.next = newtable[hash];
            newtable[hash] = list;
            list = next;  // Move on to the next node in the OLD table.
         }
      }
      table = newtable;  // Replace the table with the new table.
   } // end resize()

} // end class LinkedLists using HashTable