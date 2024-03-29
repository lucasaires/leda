package adt.linkedList;

@SuppressWarnings("unchecked")
public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	
	@Override
	public void insert(T element) {
		
		DoubleLinkedListNode<T> node = new DoubleLinkedListNode<T>();
		
		if (element != null) {
			if (isEmpty()) {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, node, null);
				super.head = newNode;
				this.last = newNode;
			} else {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, node, this.last);
				this.last.next = newNode;
				this.last = newNode;
			}
			super.size += 1;
		}
	}
	
	@Override
	public void insertFirst(T element) {
		if (element != null) {
			if (!isEmpty()) {
				DoubleLinkedListNode<T> newNode = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) this.head, null);
				super.head = newNode;
			} else {
				this.insert(element);
			}
			super.size += 1;
		}		
	}

	@Override
	public void removeFirst() {
		if (!isEmpty()) {
			super.head = head.next;
			super.size -= 1;
		}
	}

	@Override
	public void removeLast() {
		if (!isEmpty()) {
			this.last = last.previous;
			super.size -= 1;
		}
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

	@Override
	public T[] toArray(){
		T[] array = (T[]) new Object[super.size()];
		
		if (!isEmpty()) {
			DoubleLinkedListNode<T> tmp = (DoubleLinkedListNode<T>) super.head;
			int indice = 0;
			while(!tmp.isNIL() & indice < super.size()) {
				array[indice++] = tmp.getData();
				tmp = (DoubleLinkedListNode<T>) tmp.getNext();
			}
		}	
		return array;
	}	
}