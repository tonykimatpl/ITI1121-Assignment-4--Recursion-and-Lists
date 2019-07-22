public class SinglyLinkedList< T extends Comparable <T>> implements List<T>{

  private static class Node<T>{

    private T value;
    private Node <T> next;

    private Node(T value, Node<T> next){
      this.value = value;
      this.next = next;
    }
  }
  private Node<T> head;


  public int size(){
    return size(head);
  }
  private int size(Node<T> p){
    if (p == null) {
			return 0;
		} else
			return 1 + size(p.next);
  }


  public T get(int i){
    if (i< 0){
      throw new IllegalArgumentException("the argument implemented is smaller then 0 and does not exist in this list");
    }
    else{
			return get(head, i);
    }
  }
  private T get(Node<T> p, int index) {
		if (index == 0) {
			return p.value;
		} else {
			index = index - 1;
			return get(p.next, index);
		}
	}


  public int indexOf(Object item){

    Node<T> current = head;

    if (item == null){
      throw new IllegalArgumentException("the argument implemented null");
    }
    else{
      return indexOf(item,current);
    }
  }

  private int indexOf(Object item, Node<T> node){
    Node<T> tmp = new Node<T>( (T) item,null);
    if((node.equals(tmp)) == true){
      return;
    }
    else{
      return 1 + indexOf(item, node.next);
    }
  }


  public void add(int i, T item){
    if (i< 0){
      throw new IllegalArgumentException("the argument implemented is smaller then 0 and does not exist in this list");
    }
    if (item == null){
      throw new IllegalArgumentException("the argument implemented null");
    }
    Node<T> tmp = new Node<T>(item,null);
    if(head == null){
      if(i != 0){
        return;
      }
      else{
        head = tmp;
      }
    }
    if(head != null && i == 0){
      tmp.next = head;
      head = tmp;
      return;
    }
    Node<T> current = head;
    Node<T> previous = null;

    int j = 0;

    while (j < i){
      previous = current;
      current = current.next;

      if(current == null){
        break;
      }
      j++;
    }
    tmp.next = current;
    previous.next = tmp;
  }


  public T remove(int i){
    if (i< 0){
      throw new IllegalArgumentException("the argument implemented is smaller then 0 and does not exist in this list");
    }
    if (i> list.size()){
      throw new IllegalArgumentException("the argument implemented is larger then the size of the list");
    }
    if (head != null) {
      if (head.value.compareTo(get(i)) == 0) {
        Node<T> temp = head;
        temp.value = null;
        temp.next = null;
        head = head.next;
      }
      else{
        remove(head, get(i));
      }
    }
  }

  private void remove(Node<T> p, T o) {
    if (p.next == null) {
      return; // we could not find o in the list
    }
    if (p.next.value.compareTo(o) == 0) {
      p.next = p.next.next;
      return;
    } else {
      remove(p.next, o);
    }
    ;
  }


  public T min(){

    //needs to be implemented

    return head.value;
  }

  public T minR() {

		if (head == null) {
			return null;
		} else {
			return MinR(head);

		}
	}

	private T MinR(Node<T> p) {
		if (p == null) {
			return null;
		}
		T min = p.value;

		while (p != null) {
			if (p.value.compareTo(min) < 0) {
				min = p.value;
			}
			p = p.next;
		}
		return min;
	}

  public T max(){

    //needs to be implemented

    return head.value;
  }


  public T maxR() {

		if (head == null) {
			return null;
		} else {
			return MaxR(head);

		}
	}

	private T MaxR(Node<T> p) {
		if (p == null) {
			return null;
		}
		T max = p.value;

		while (p != null) {
			if (p.value.compareTo(max) > 0) {
				max = p.value;
			}
			p = p.next;
		}
		return max;
	}


  public boolean Empty(){
    return head==null;
  }


  public void addAtHead(T item){
		if (item == null) {
			throw new NullPointerException("Illegal argument");
		}

		head = new Node<T>(item, head);
	}

  public void addAtEnd(T item){
    if (item == null) {
			throw new NullPointerException("Illegal argument");
		}
    Node <T>  tmp = head;
    while(tmp.value != null){
      tmp = tmp.next;
    }
    Node<T> last;
		last = new Node<T>(item, tmp);
  }


  public void replace(T first, T second){
    System.out.println(first);

    //needs to be implemented
  }


  public List<T> duplicate(T item) {
		return duplicate(item, head);
	}

	private List<T> duplicate(T item, Node<T> node) {
		if (node == null)
			return new SinglyLinkedList<T>();
		else {
			SinglyLinkedList<T> result = new SinglyLinkedList<>();
			result = (SinglyLinkedList<T>) duplicate(item, node.next);

			if (node.value.compareTo(item) == 0) {
				result.addAtHead(item);
			} else {
				result.addAtHead(node.value);
			}

			return result;
		}
	}


  public void reverse(){
    System.out.println("lol");
  }


  public List<T> countGreaterThan(T threshold){
		return storeGreaterThan(threshold, head);
	}

	private List<T> storeGreaterThan(T threshold, Node<T> node) {
		if (node == null)
			return new SinglyLinkedList<T>();
		else {
			SinglyLinkedList<T> result = new SinglyLinkedList<>();
			result = (SinglyLinkedList<T>) storeGreaterThan(threshold, node.next);
			if (node.value.compareTo(threshold) > 0) {
				result.addAtHead(node.value);
			}
			return result;
		}

	}


  public boolean equals(Object other){
		if (!(other instanceof List<?>)) {
			return false;
		}
		if (other == this) {
			return true;
		} else
			return equals((List<?>) other);
	}

	public boolean equals(List<T> other) {
		return equals(this.head, other.head);
	}

	private boolean equals(Node<T> p, Node<T> q) {
		if (p == null) {
			if (q == null) {
				return true;
			} else {
				return false;
			}
		} else {
			if (p.value.compareTo(q.value) == 0)
				return equals(p.next, q.next);
			else{
        return false;
      }
		}
	}

  public String toString(){
		return "{" + (mytoString(head)) + "}";
	}

	private String mytoString(Node<T> p) {
		String result = "";
		if (p != null) {
			if (p.next != null) {
				result = p.value + "," + mytoString(p.next);
			} else {
				result = "" + p.value;

			}

		}

		return result;
	}

  public List<T> inorder(){
    return null;
  }

  public void removeEven(){
    for(int i; i < size(head);i++){
      if(get(i)%2 != 1){
        remove(i);
      }
    }
  }
}
