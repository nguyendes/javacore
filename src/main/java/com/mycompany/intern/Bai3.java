package com.mycompany.intern;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Bai3 {

    public static void main(String[] args) {
        try {
            List<Integer> numbers = readNumbersFromFile("C:\\Users\\maytinh\\Documents\\NetBeansProjects\\intern\\bl.txt");
            int[] array = numbers.stream().mapToInt(i -> i).toArray();
            
            quickSort(array, 0, array.length - 1);

            System.out.println("Day so sap xep:");
            printArray(array);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static List<Integer> readNumbersFromFile(String filename) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split("\\s+");
            for (String part : parts) {
                if (!part.isEmpty()) {
                    numbers.add(Integer.parseInt(part));
                }
            }
        }
        reader.close();
        return numbers;
    }

    private static void quickSort(int[] array, int sonho, int soto) {
        if (sonho < soto) {
            int moc = partition(array, sonho, soto);
            quickSort(array, sonho, moc - 1);
            quickSort(array, moc + 1, soto);
        }
    }

    private static int partition(int[] array, int sonho, int soto) {
        int moc = array[soto];
        int i = sonho - 1;

        for (int j = sonho; j < soto; j++) {
            if (array[j] <= moc) {
                i++;
                swap(array, i, j);
            }
        }

        swap(array, i + 1, soto);
        return i + 1;
    }

    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
