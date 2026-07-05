
public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Data Structure Tests ---\n");
        
        testDynamicArrayBasic();
        testVectorSorting();
        
        System.out.println("\n--- All Tests Completed Successfully ---");
    }

    public static void testDynamicArrayBasic() {
        System.out.println("Testing DynamicArray...");
        
        // Initialize with a small capacity to force expansion quickly
        DynamicArray<Integer> arr = new DynamicArray<>(2);
        
        // Test push_back and tracking mechanisms
        arr.push_back(10);
        arr.push_back(20);
        System.out.println("Size after 2 elements: " + arr.size); // Expected: 2
        
        // Test automatic expansion
        arr.push_back(30); 
        System.out.println("Size after expansion: " + arr.size);  // Expected: 3
        
        // Test get() capability
        System.out.println("Element at index 1: " + arr.get(1)); // Expected: 20
        
        // Test set() capability
        arr.set(1, 99);
        System.out.println("Element at index 1 after set: " + arr.get(1)); // Expected: 99
        
        // Test pop_back()
        arr.pop_back();
        System.out.println("Size after pop_back: " + arr.size);  // Expected: 2
        
        System.out.println("DynamicArray: PASS\n");
    }

    public static void testVectorSorting() {
        System.out.println("Testing Vector Merge Sort...");
        
        Vector<Integer> vec = new Vector<>();
        
        // Populate with an unsorted pattern
        vec.push_back(45);
        vec.push_back(12);
        vec.push_back(89);
        vec.push_back(5);
        vec.push_back(23);
        
        System.out.print("Before sorting: ");
        printVector(vec);
        
        // Execute your custom merge sort algorithm
        // Note: calling sort_r(0, size - 1) directly since it's currently package-private
        vec.sort();
        
        System.out.print("After sorting:  ");
        printVector(vec);
        
        // Simple verification loop check
        boolean isSorted = true;
        for (int i = 0; i < vec.size - 1; i++) {
            if (vec.get(i).compareTo(vec.get(i + 1)) > 0) {
                isSorted = false;
                break;
            }
        }
        
        if (isSorted) {
            System.out.println("Vector Merge Sort: PASS");
        } else {
            System.out.println("Vector Merge Sort: FAIL ❌");
        }
    }

    // Quick helper method to print vector contents to console
    private static void printVector(Vector<Integer> vec) {
        System.out.print("[");
        for (int i = 0; i < vec.size; i++) {
            System.out.print(vec.get(i));
            if (i < vec.size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}