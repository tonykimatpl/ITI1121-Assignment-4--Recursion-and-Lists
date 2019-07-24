/*Mytestclass.java
Noël Khalaf, Tony Kim
300079144, 300087407
ITI1121
*/
/*Mytestclass class contains a main class which tests the methods in the SinglyLinkedList class*/
public class Mytestclass{
  /*Main method executes the method calls to test each method in the SinglyLinkedList class*/
  public static void main(String args[]){
    List<Integer> list1 = new SinglyLinkedList<Integer>();
	  List<Integer> list2 = new SinglyLinkedList<Integer>();			//Creates two SinglyLinkedLists of integers
    for(int i=0; i<10; i++){
		    list1.add(i,i);				//Adds integers from 0 to 9 to each list
        list2.add(i,i);
      }

    System.out.println("List 1 after add():"+list1);		//Displays lists after add() is called
	  System.out.println("List 2 after add():"+list2);

	  System.out.println("Size of list 1: "+ list1.size());		//Displays results after size() is called
	  System.out.println("Size of list 2: "+ list2.size());
	  System.out.println("List 1 after size():"+list1);			//Displays lists after size() is called
	  System.out.println("List 2 after size():"+list2);

	  System.out.println("Element at index 0 in list 1: " + list1.get(0));		//Displays results after get() is called
	  System.out.println("Element at index 4 in list 2: " + list2.get(4));
	  System.out.println("List 1 after get():"+list1);							//Displays lists after get() is called
	  System.out.println("List 2 after get():"+list2);

	  System.out.println("Index of element 1 in list 1: " + list1.indexOf(0));		//Displays results after indexOf() is called
	  System.out.println("Index of element 4 in list 2: " + list2.indexOf(4));
	  System.out.println("List 1 after indexOf():"+list1);							//Displays lists after indexOf() is called
	  System.out.println("List 2 after indexOf():"+list2);

	  list1.remove(0);										//Removes first element in each list
	  list2.remove(0);
	  System.out.println("List 1 after remove():"+list1);		//
	  System.out.println("List 2 after remove():"+list2);

	  System.out.println("Minimum of List 1: " + list1.min());
	  System.out.println("Minimum of List 2: " + list2.min());
	  System.out.println("List 1 after min():"+list1);
	  System.out.println("List 2 after min():"+list2);

	  System.out.println("Minimum of List 1 using recursive min function: " + list1.minR());
	  System.out.println("Minimum of List 2 using recursive min function: " + list2.minR());
	  System.out.println("List 1 after minR():"+list1);
	  System.out.println("List 2 after minR():"+list2);

	  System.out.println("Maximum of List 1: " + list1.max());
	  System.out.println("Maximum of List 2: " + list2.max());
	  System.out.println("List 1 after max():"+list1);
	  System.out.println("List 2 after max():"+list2);

	  System.out.println("Maximum of List 1 using recursive max function: " + list1.maxR());
	  System.out.println("Maximum of List 2 using recursive max function: " + list2.maxR());
	  System.out.println("List 1 after maxR():"+list1);
	  System.out.println("List 2 after maxR():"+list2);

    List<Integer> list3 = new SinglyLinkedList<Integer>();
	  System.out.println("List 1 is empty: " + list1.Empty());
	  System.out.println("List 2 is empty: " + list2.Empty());
    System.out.println("List 3 is empty (Should be true): "+ list3.Empty());
	  System.out.println("List 1 after Empty():"+list1);
	  System.out.println("List 2 after Empty():"+list2);

    System.out.println("Adding 2 to head of list1...");
    System.out.println("Adding 2 to head of list2...");
	  list1.addAtHead(2);
	  list2.addAtHead(2);
	  System.out.println("List 1 after addAtHead():"+list1);
	  System.out.println("List 2 after addAtHead():"+list2);

    System.out.println("Adding 6 to end of list 1...");
    System.out.println("Adding 6 to end of list 2...");
	  list1.addAtEnd(6);
	  list2.addAtEnd(6);
	  System.out.println("List 1 after addAtEnd():"+list1);
	  System.out.println("List 2 after addAtEnd():"+list2);

    System.out.println("Replacing 0s with 8s in list1...");
    System.out.println("Replacing 0s with 8s in list2...");
	  list1.replace(0,8);
	  list2.replace(0,8);
	  System.out.println("List 1 after replace():"+list1);
	  System.out.println("List 2 after replace():"+list2);

	  list1.duplicate(5);
	  list2.duplicate(5);
	  System.out.println("List 1 after duplicate():"+list1);
	  System.out.println("List 2 after duplicate():"+list2);
    list1.reverse();
    list2.reverse();
	  System.out.println("List 1 after reverse():"+list1);
	  System.out.println("List 2 after reverse():"+list2);

    System.out.println("Elements greater than 5 in list 1: " + list1.countGreaterThan(5));
    System.out.println("Elements greater than 2 in list 2: " + list2.countGreaterThan(2));
	  System.out.println("List 1 after countGreaterThan():"+list1);
	  System.out.println("List 2 after countGreaterThan():"+list2);

	  System.out.println("Both lists equal each other: "+list1.equals(list2));
	  System.out.println("List 1 after equals():"+list1);
	  System.out.println("List 2 after equals():"+list2);

	  list1.inorder();
	  list2.inorder();
	  System.out.println("List 1 after inorder():"+list1);
	  System.out.println("List 2 after inorder():"+list2);

    list1.removeEven();
	  list2.removeEven();
	  System.out.println("List 1 after removeEven():"+list1);
	  System.out.println("List 2 after removeEven():"+list2);
  }
}
