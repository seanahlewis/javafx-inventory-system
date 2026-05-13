package FinalProject;

public class InventoryList implements InventoryOperations {
	
	private Node<Item> head;
	private int size;
	
	public InventoryList() {
		head = null;
		size = 0;
	}
	
	// Add item
	@Override
	public void addItem(Item item) {
		Node<Item> newNode = new Node<>(item, null);
		
		if (head == null) {
			head = newNode;
		} else {
			Node<Item> current = head;
			while (current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
		}
		
		size++;
	}
	
	// Remove item by id
	@Override
	public boolean removeItemById(int id) {
		
		if (head == null)
			return false;
		
		if (head.getItem().getId() == id) {
			head = head.getNext();
			size--;
			return true;
		}
		
		Node<Item> current = head;
			
		while (current.getNext() != null) {
			if (current.getNext().getItem().getId() == id) {
				current.setNext(current.getNext().getNext());
				size--;
				return true;
		}
			
		current = current.getNext();
	}
		
	 return false;
}
	
	// Find item by id
	@Override
	public Item findItem(int id) {
		Node<Item> current = head;
		
		while (current != null) {
			if (current.getItem().getId() == id) {
				return current.getItem();
			}
			current = current.getNext();
		}
		
		return null;
	}
	
	// Update qty of item by id
	@Override
	public boolean updateQuantity(int id, int newQuantity) {
		Item item = findItem(id);
		
		if (item == null)
			return false;
		
		item.setQuantity(newQuantity);
		return true;
		
	}
	
	// Current size of inventory
	public int size() {
		return size;
	}
	
	// Is inventory empty
	public boolean isEmpty() {
		return size == 0;
	}
	
	// Inventory toString
	@Override
	public String toString() {
		
		if (head == null) {
			return "Inventory is empty.";
		}
		String result = "";
		Node<Item> current = head;
		
		while (current != null) {
			result += current.getItem().toString() + "\n";
			current = current.getNext();
		}
		
		return result;		
	}

}
