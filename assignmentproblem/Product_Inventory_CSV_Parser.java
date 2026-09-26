public class Product_Inventory_CSV_Parser {
    public static void main(String[] args) {
        String csvLine = "Wireless Mouse,WM-2201,150";
        System.out.println("Input: " + csvLine);
        parseInventoryRecord(csvLine);
    }
    static void parseInventoryRecord(String csvLine) {
        String[] fields = csvLine.split(",");
        if (fields.length != 3) {
            System.out.println("Output: Invalid Record");
        } else {
            System.out.println("Output: Product: " + fields[0] + " | SKU: " + fields[1] + " | Qty: " + fields[2]);
        }
    }
}