package com.datastructures;

/**
 * TODO Description.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class Queue
{

    private final int capacity;
    private final int[] queue;
    private static int queueIndex = 0;
    private static int dequeueIndex = 0;

    private Queue (int capacity)
    {
        if (capacity == 0)
        {
            this.capacity = 10;
            this.queue = new int[10];
            return;
        }
        this.capacity = capacity;
        this.queue = new int[capacity];
    }

    public static Queue newQueue ()
    {
        return new Queue(10);
    }

    public static Queue newQueueWithCapacity (int capacity)
    {
        return new Queue(capacity);
    }

    public void addQueue (int element)
    {
        if (queueIndex == capacity)
        {
            System.out.println("Queue is out of capacity ");
            
            return;
        }

        queue[queueIndex++] = element;
    }

    public int deQueue ()
    {
        if (queueIndex < dequeueIndex)
        {
            System.out.println("Cannot deQueue further");
            return -1;
        }

        int queueValue = queue[dequeueIndex];
        queue[dequeueIndex++] = -1;
        return queueValue;
    }

    public int getHeadValue ()
    {
        if (dequeueIndex >= capacity)
            return -1;
        return queue[dequeueIndex];
    }

    public int getTailQueue ()
    {
        if (queueIndex < 0)
            return -1;
        return queue[queueIndex];
    }

    public void printQueue ()
    {
        for (int i = capacity - 1; i > 0; i--)
        {
            if (queue[i] >= 0)
            {
                System.out.print(queue[i]+ " ");
            }
        }
        if (queue[0] >= 0)
        {
            System.out.print(queue[0] + " ");
        }
       

        System.out.println();
    }

}