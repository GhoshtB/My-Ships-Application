package com.hfad.myshipsapplication.shipslootprograminjava;

public class LootShipsinJava {
    public static int days = 0;

    public static int[] checkforLootedArrays(int[] shipsbasedOnloots) {
        boolean traverse = false;

        for (int i = 0; i < shipsbasedOnloots.length; i++) {

            if (i + 1 < shipsbasedOnloots.length && shipsbasedOnloots[i] < shipsbasedOnloots[i + 1]) {

                traverse = true;
                shipsbasedOnloots = removeTheElement(i + 1, shipsbasedOnloots);
            }
        }

        if (traverse) {
            days++;
        }
        return shipsbasedOnloots;

    }

    private static int[] removeTheElement(int index, int[] arr) {
        if (arr == null
                || index < 0
                || index >= arr.length) {

            return arr;
        }
        int[] anotherArray = new int[arr.length - 1];
        for (int i = 0, k = 0; i < arr.length; i++) {
            if (i == index) {
                continue;
            }
            anotherArray[k++] = arr[i];
        }
        return anotherArray;
    }


    public static void main(String[] args) {
        int[] shipsbasedOnloots = {3, 6, 2, 7, 5, 9, 4, 8};
int k=shipsbasedOnloots.length;
        while (k > 1) {
            shipsbasedOnloots = checkforLootedArrays(shipsbasedOnloots);
            k--;
        }

        System.out.println("After " + days + " Days Looting will Stop");
    }

}
