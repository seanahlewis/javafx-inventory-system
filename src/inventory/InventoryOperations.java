package inventory;

public interface InventoryOperations {

	void addItem(Item item);
	boolean removeItemById(int id);
	Item findItem(int id);
	boolean updateQuantity(int id, int newQuantity);
}
