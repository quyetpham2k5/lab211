/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hashtable;

import java.util.*;

public class HashTable {
    private int size;
    private ArrayList<LinkedList<Integer>> table;

    public HashTable(int size) {
        this.size = size;
        table = new ArrayList<>(size);
        // khởi tạo từng bucket là 1 linked list rỗng
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<Integer>());
        }
    }

    private int hashFunc(int key) {
        return key % size;
    }

    public void insert(int key) {
        int index = hashFunc(key);
        table.get(index).add(key);
    }

    public boolean search(int key) {
        int index = hashFunc(key);
        return table.get(index).contains(key);
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(i + ": ");
            for (int x : table.get(i)) {
                System.out.print(x + " -> ");
            }
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        HashTable h = new HashTable(5);
        h.insert(12);
        h.insert(22);
        h.insert(32);
        h.insert(42);
        h.insert(7);

        h.display();

        System.out.println("Tìm 22: " + h.search(22));
        System.out.println("Tìm 99: " + h.search(99));
    }
}
