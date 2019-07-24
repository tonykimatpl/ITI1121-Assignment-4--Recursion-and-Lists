public class SinglyLinkedList<T extends Comparable<T>> implements List<T>{

	private Node<T> head;
  private Node<T> tail;

	private static class Node<T>{
		private T value;
		private Node<T> next;

		private Node(T value, Node<T> next){
			this.value = value;
			this.next = next;
		}
	}

	public int size(){
		if(head == null){
			return 0;
		}
		else{
			return size(head);
		}
	}
	private int size(Node<T> p){
		if(p == null){
			return 0;
		}
		else{
			return 1 + size(p.next);
		}
	}

	public T get(int i){
    if(i<0){
			return null;
		}
		if(head == tail && i == 0){
      return head.value;
    }
    else{
      return get(head, i, 0);
		}
	}
	private T get(Node<T> elem,int i, int currentindex){
    Node<T> temp = elem;
		if(currentindex == i){
      return temp.value;
    }
    else{
      temp = temp.next;
      currentindex++;
    }
    return get(temp,i,currentindex);
	}

	public int indexOf(Object item){
    if(head == null || item == null){
      return -1;
    }
    else{
      return indexOf(item, head);
    }
  }
  private int indexOf(Object item, Node<T> head){
    if(head.value.compareTo((T) item) == 0){
      return 0;
    }
    if(head.next == null){
      return -1;
    }
    int index = indexOf(item, head.next);
    if(index == -1){
      return -1;
    }
    else{
      return 1 + index;
    }
  }

  public void add(int i, T item){
    if(item == null){
      throw new IllegalArgumentException("You cannot add a null element to this list.");
    }
    else{
      if(i<0 || i>size()){
        throw new IllegalArgumentException("The index provided is not in the bounds of the list.");
      }
      else if(i == 0 && head == tail){
        Node<T> temp = head;
        head = new Node<T>(item,temp);
        tail = head.next;
      }
      else if(i == 0 && head != tail){
        Node<T> temp = head;
        head = new Node<T>(item, temp);
      }
      else{
        Node<T> temp = new Node<T>(item, null);
        Node<T> current = head;
        Node<T> previous = null;
        int index = 0;
        while(index < i){
          previous = current;
          current = current.next;
          if(current == null){
            break;
          }
          index++;
        }
        temp.next = current;
        previous.next = temp;
      }
    }
  }
	public T remove(int i){
    int counter = 0;
    T saved;
    if(i < 0 || i > size()){
      return null;
    }
    else{
      if(head == null){
        return null;
      }
      else if(head == tail){
        saved = head.value;
        head = tail = null;
        return saved;
      }
	  else if(i == 0){
		  saved = head.value;
		  head = head.next;
		  return saved;
	  }
      else{
        Node<T> temp = head;
     	  while(counter < i){
          temp = temp.next;
          counter++;
        }
        saved = temp.next.value;
        temp.next = temp.next.next;
      }
    }
    return saved;
  }

  public T min(){
    if(head == null){
      return null;
    }
    else if(head == tail){
      return head.value;
    }
    else{
      Node<T> temp = head;
      T currentmin = temp.value;
      temp = temp.next;
      int index = 0;
      while(index < size()){
        if(temp.value.compareTo(currentmin) < 0){
          currentmin = temp.value;
		  temp = temp.next;
          index++;
        }
        else{
          index++;
        }
      }
      return currentmin;
    }
  }

  public T minR(){
    if(head == null){
      return null;
    }
    else if(head == tail){
      return head.value;
    }
    else{
      return minR(head);
    }
  }
  private T minR(Node<T> p){
    if(p.next == null){
      return p.value;
    }
    T result = minR(p.next);
    if(result.compareTo(p.value) < 0){
      return result;
    }
    else{
      return p.value;
    }
  }

  public T max(){
    if(head == null){
      return null;
    }
    else if(head == tail){
      return head.value;
    }
    else{
      Node<T> temp = head;
      T currentmax = temp.value;
      temp = temp.next;
      int index = 0;
      while(index < size()-1){
        if(temp.value.compareTo(currentmax) > 0){
          currentmax = temp.value;
          temp = temp.next;
          index++;
        }
        else{
          index++;
        }
      }
      return currentmax;
    }
  }

  public T maxR(){
    if(head == null){
      return null;
    }
    else{
      return maxR(head);
    }
  }
  private T maxR(Node<T> p){
    if(p.next == null){
      return p.value;
    }
    T result = maxR(p.next);
    if(result.compareTo(p.value) > 0){
      return result;
    }
    else{
      return p.value;
    }
  }

  public boolean Empty(){
    if(head == null){
      return true;
    }
    else{
      return false;
    }
  }

  public void addAtHead(T item){
    if(head == null){
      tail = head = new Node<T>(item, null);
    }
    else{
      Node<T> temp = head;
      head = new Node<T>(item, temp);
    }
  }

  public void addAtEnd(T item){
    if(head == null){
      head = tail = new Node<T>(item,null);
    }
    else{
      Node<T> temp = head;
      Node<T> newtail = new Node<T>(item,null);
      while(temp.next != null){
        temp = temp.next;
      }
      temp.next = newtail;
      tail = temp;
    }
  }

  public void replace(T first, T second){
    if(first == null || second == null || head == null){
      return ;
    }
    else if(head == tail){
      if(head.value.compareTo(first) == 0){
        head.value = second;
      }
      else{
        return ;
      }
    }
    else{
      Node<T> p = head;
      while(p.next != null){
        if(p.value.compareTo(first) == 0){
          p.value = second;
        }
        p = p.next;
      }
    }
  }

  public List<T> duplicate(T item){
    if(head == null){ //if list is empty return null
      return null;
    }
    else if(head.value.compareTo(item) == 0 && head == tail){
      head.next = new Node<T>(item, null);
      tail = head.next;
      return this;
    }
    else{
      duplicate(item, head);
    }
    return duplicate(item, head);
  }
  private List<T> duplicate(T item, Node<T> p){
    if(p == null){
      return this;
    }
    if(p.value.compareTo(item) == 0){
      SinglyLinkedList<T> duplist = new SinglyLinkedList<T>();
      duplist.head = new Node<T>(item, p.next.next);
      p.next = duplist.head;
      duplicate(item, p.next.next.next);
    }
    else{
      duplicate(item, p.next);
    }
    return this;
  }

	public void reverse(){
    reverse(head);
    System.out.println();
  }
  private void reverse(Node<T> p){
    if(p == null){
      System.out.print("");
    }
    else{
      reverse(p.next);
      System.out.print(p.value);
    }
  }

  public List<T> countGreaterThan(T threshold){
	if(head == null){
      return null;
    }
    else if(head == tail){
      if(head.value.compareTo(threshold) <= 0){
        return null;
      }
      else{
        return this;
      }
    }
    else{
      return countGreaterThan(threshold,head);
	}
  }
  private List<T> countGreaterThan(T threshold, Node<T> p){
	  List<T> result;
	  if(p == null){
		  result = new SinglyLinkedList<T>();
	  }
	  else{
		  result = countGreaterThan(threshold,p.next);
		  if(p.value.compareTo(threshold) > 0){
			  result.addAtHead(p.value);
		  }
	  }
	  return result;
  }

  public boolean equals(SinglyLinkedList other){
    if(this.head == null && other.head == null){
      return true;
    }
    else if(this.head.value.compareTo((T) other.head.value) == 0 && this.head == this.tail && other.head == other.tail){
      return true;
    }
    else{
      equals(this, other);
    }
    return false;
  }
  private Boolean equals(SinglyLinkedList athis, SinglyLinkedList aother){
		/*
    if(athis.head.next == null && aother.head.next == null && athis.head.value == aother.head.value){
      return true;
    }
    if(athis.head.value == aother.head.value){
      SinglyLinkedList<T> newthis = new SinglyLinkedList<T>();
      SinglyLinkedList<T> newother = new SinglyLinkedList<T>();
      Node<T> newthishead = athis.head.next;
      Node<T> newotherhead = aother.head.next;
      newthis.head = newthishead;
      newother.head = newotherhead;
      equals(newthis, newother);
    }
    else{
      return false;
    }
    return false; */
		assert true;
		return true;
  }

  public String toString(){
    return toString(head);
  }
  private String toString(Node<T> p){
    if(p == null){
      return "";
    }
    else{
      return p.value + toString(p.next);
    }
  }

  public List<T> inorder(){
    SinglyLinkedList<T> templist = new SinglyLinkedList<T>();
    templist.head = this.head;
		SinglyLinkedList<T> sortedlist = new SinglyLinkedList<T>();
		sortedlist.head = new Node<T>(templist.head.value,null);
		sortedlist.head = sortedlist.tail;
		while(templist.head != null){
			if(sortedlist.Empty() == true){ //if the sorted list is empty, made a new head in sorted list with the value of the head in templist
				sortedlist.head = new Node<T>(templist.head.value,null);
				templist.head = templist.head.next;
			}
			else if(sortedlist.Empty() == false && templist.head.value.compareTo(sortedlist.head.value) > 0){
				sortedlist.addAtEnd(templist.head.value);
				templist.head = templist.head.next;
			}
			else if(sortedlist.Empty() == false && templist.head.value.compareTo(sortedlist.head.value) < 0){
				sortedlist.addAtHead(templist.head.value);
				templist.head = templist.head.next;
			}
		}
		return sortedlist;
  }


  public void removeEven(){
    if(head == null){
      return;
    }
    else if(head == tail){
      head = tail = null;
    }
    else{
      int index = 0;
      while(index < this.size()){
        if(index % 2 == 0){
          this.remove(index);
          index++;
        }
        if(index % 2 == 1){
          index++;
        }
      }
    }
  }
}
