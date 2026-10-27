package org.example.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Grocery {
    public static List<String> groceryList = new ArrayList<>();

    public static void startGrocery() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        while (flag) {
            System.out.println("\nLütfen bir işlem seçin (0: Çıkış, 1: Ekle, 2: Çıkar): ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Buffer'ı temizlemek için

            switch (choice) {
                case 0:
                    System.out.println("Alışveriş bitti.");
                    flag = false;
                    break;
                case 1:
                    System.out.println("Eklenmesini istediğiniz elemanları giriniz (Virgülle ayırabilirsiniz):");
                    String addInput = scanner.nextLine();
                    addItems(addInput);
                    printSorted();
                    break;
                case 2:
                    System.out.println("Çıkarılmasını istediğiniz elemanları giriniz (Virgülle ayırabilirsiniz):");
                    String removeInput = scanner.nextLine();
                    removeItems(removeInput);
                    printSorted();
                    break;
                default:
                    System.out.println("Geçersiz seçim, lütfen 0, 1 veya 2 giriniz.");
                    break;
            }
        }
    }

    public static void addItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty()) {
                if (checkItemIsInList(trimmedItem)) {
                    System.out.println(trimmedItem + " zaten listede var!");
                } else {
                    groceryList.add(trimmedItem);
                }
            }
        }
        // Her ekleme işleminden sonra liste sort edilmeli
        Collections.sort(groceryList);
    }

    public static void removeItems(String input) {
        String[] items = input.split(",");
        for (String item : items) {
            String trimmedItem = item.trim();
            if (!trimmedItem.isEmpty()) {
                if (checkItemIsInList(trimmedItem)) {
                    groceryList.remove(trimmedItem);
                } else {
                    System.out.println(trimmedItem + " listede bulunamadı!");
                }
            }
        }
        // Her çıkarma işleminden sonra liste sort edilmeli
        Collections.sort(groceryList);
    }

    public static boolean checkItemIsInList(String product) {
        return groceryList.contains(product);
    }

    public static void printSorted() {
        Collections.sort(groceryList);
        System.out.println("Güncel Pazar Arabası Listesi: " + groceryList);
    }
}
