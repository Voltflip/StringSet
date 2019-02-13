// CS 272 Intro to Data Structures
// Program Name: StringSet.java
// Author: VoltFlip
// Date: 02/07/2019
// Purpose: The purpose of this program is to create many methods in order to manipulate various instance variables, mostly an array of strings

import java.util.Arrays;

public class StringSet {

   private int capacity;
   private int numRealStrings;
   private String[] StringArray;

   public StringSet() {
      StringArray = new String[2];
      int capacity = 2;
      int numRealStrings = 0;
   } // end StringSet default constructor method
   
   // @precondition - _capacity must be a positive integer
   public StringSet(int _capacity) {
      StringArray = new String[_capacity];
      capacity = _capacity;
   } // end StringSet method that accepts an int for capacity
   
   // @precondition - obj must NOT be a null object and should be an instance of StringSet
   public StringSet(StringSet obj) {
      StringSet copy = new StringSet(obj.capacity);
      for(int i = 0; i < obj.capacity; i++) {
         copy.StringArray[i] = obj.StringArray[i];
      } // end for
   } // end StringSet copy method that accepts a StringSet instance as an argument
   
   public int size() {
      int numRealStrings = 0;
      for (int i = 0; i < this.StringArray.length; i++) {
         if (this.StringArray[i] != null) {
            numRealStrings += 1;
         }// end if statement
      } // end for loop
      return numRealStrings;
   } // end size method. Returns the number of non-null elements in the array
   
   public int capacity() {
      return this.StringArray.length;
   } // end capacity method. Returns length of array
   
   // @precondition - String value 'a' should NOT be null
   public void add(String a) {
      if (size() < capacity()) {
         StringArray[capacity() - 1] = a;
      } // end if statement
      else {
         ensureCapacity(capacity + 5);
      } // end else statement
   } // end add method
   
   public boolean contains(String a) {
      for (int i = 0; i < capacity; i++) {
         if (this == null) {
            return false;
         } // end if statement
         else if (this != null) {
            for (int j = 0; j < capacity; j++) {
               if (StringArray[j] == a) {
                  return true;
               } // end if statement
            } // end for loop 
         } // end if statement
      } // end for loop
      return false;
   } // end contains method
   
   public boolean remove(String a) {
      if (a == null) {
         return false;
      } // end if statement
      if (a != null) {
         for (int i = 0; i < capacity; i++) {
            if (StringArray[i] == a) {
               StringArray[i] = StringArray[capacity - 1];
               capacity --;
               return true;
            } // end if statement
         } // end for loop
      } // end if statement
      return false;
   } // end remove method
   
   // @precondition - input parameter minimumCapacity must be positive
   private void ensureCapacity(int minimumCapacity) {
      if(capacity < minimumCapacity) {
         String[] temp = new String[capacity * 2];
         for (int i = 0; i < capacity; i++) {
            temp[i] = StringArray[i];
         } // end for loop
         StringArray = temp;
      } // end if statement
   } // end ensureCapacity method. Creates temporary array with double capacity then copies over all 
     // values from original array to it. Then assigns the temporary array to the original StringArray variable
   
   // @precondition - the String value 'a' should NOT be null
   // @precondition - the values in the collection's string array are already ordered ascendingly
   public void addOrdered(String a) {
      add(a);
      Arrays.sort(StringArray);
   } // end addOrdered method
   
   public String toString() {
        return String.format("Capacity: %d\nNumber of real Strings: %d\nArray: %s\n", capacity, numRealStrings, java.util.Arrays.deepToString(StringArray));
    } // end toString method
   
   
   // the below tests the above methods
   
   public static void main(String[] args) {
      StringSet mySet = new StringSet();
      System.out.println(mySet.toString());
      // create and print a new StringSet object named myStringSet using the defualt constructor method
      
      StringSet mySet2 = new StringSet(4);
      System.out.println(mySet2.toString());
      // create a new StringSet using the constructor that sets the capacity to whatever the argument is
      
      //mySet2.StringSet(mySet2);
      //System.out.println(copy.toString());
      // copy mySet2 using the StringSet method that creates a copy of the object you pass it. Print the copied object
      
      //System.out.println(customSet.size());
      
      
   } // end main method
   
} // end StringSet class