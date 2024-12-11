package org.example.ticketingsystem.util;

import java.util.LinkedList;
import java.util.Queue;

public class ThreadSafeQueue<T> {
    private final Queue<T> queue = new LinkedList<>();  // LinkedList is used as the underlying data structure for the queue

    // Method to add an item to the queue in a thread-safe manner
    public synchronized void add(T item) {
        queue.add(item);  // Add the item to the queue
    }

    // Method to remove and return an item from the queue in a thread-safe manner
    public synchronized T remove() {
        return queue.poll();  // Remove and return the item from the front of the queue, or null if empty
    }

    // Method to get the current size of the queue in a thread-safe manner
    public synchronized int size() {
        return queue.size();  // Return the current size of the queue
    }
}
