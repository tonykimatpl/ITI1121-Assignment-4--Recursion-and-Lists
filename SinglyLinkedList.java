public class SinglyLinkedList<T extends Comparable<T>> implements List<T>{
	
	private Node<T> head;
	
	private static class Node<E>{
		private E value;
		private Node<E> next;
		
		private Node(E value, Node<E> next){
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
			return 1 +size(p.next);
		}
	}
	
	public T get(int i){
		if(i<0){
			return null;
		}
		else{
			return get(head,i);
		}
	}
	private T get(Node<T> p,int i){
		if(p == null){
			return null;
		}
		i -= 1;
		else if(i == 0){
			return p.value;
		}
		else{
			get(p.next, i);
		}
	}
	
	public int indexOf(Object item){
		return indexOf(Object item, head);
	}
	private int indexOf(Object item, p){
		Node<T> p = new Node((T) item, null);
		if(){
			
		}
		else{
			return 1 + indexOf(item, p.next);
		}
	}
}