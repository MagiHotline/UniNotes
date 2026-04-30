package lists;

import java.util.Arrays;
import java.io.*;
import java.util.Scanner;

public class List<T> {
    private final T head;
    private final List<T> tail;

    // crea una lista con la testa e la coda indicate
    public List(T head, List<T> tail) {
        this.head = head;
        this.tail = tail;
    }

    // crea una lista contenente la testa indicata, seguita dagli elementi indicati
    public List(T head, T... elements) {
        this.head = head;
        List<T> l = null; // creo un oggetto lista che inizialmente punta a null
        // Scorro la lista al contrario e per ogni elemetno pos diventa la testa e l la coda
        for(int pos = elements.length - 1; pos >= 0; pos--)
            l = new List<T>(elements[pos],l);
        this.tail = l;
    }

    // restituisce una descrizione di questa lista, fatta dai toString()
    // dei suoi elementi separati da virgole
    public String toString() {
        if(tail == null)
            return head.toString();
        else
            return head.toString() + ", " + tail.toString();
    }

    // restituisce il numero di elementi di questa lista
    public int length() {
        if(tail == null)
            return 1;
        else
            return 1 + tail.length();
    }

    public int length2() {
        int count = 0;
        for(List<T> cursor =  this; cursor != null; cursor = cursor.tail)
            count++;
        return count;
    }

    // scrive gli elementi di questa lista (cioè il loro toString())
    // dentro il file testuale col nome indicato (un PrintWriter vi aiuterà)
    public void dump(String fileName) throws IOException {
        try (PrintWriter out = new PrintWriter(fileName)) {
            for(List<T> cursor = this; cursor != null; cursor = cursor.tail)
                out.println(cursor.head);
        }
    }

    public T getHead() {
        return head;
    }

    public List<T> getTail() {
        return tail;
    }
}