package com.datastructures;

/**
 * TODO Description.
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class QueueDemo
{

    public static void main (String[] args)
    {
        final Queue queue = Queue.newQueue();

        for (int i = 1; i <= 10; i++)
        {
            queue.addQueue(i);
        }
        
        queue.printQueue();
        
        for (int i = 1; i <= 9; i++)
        {
            queue.deQueue();
        }
        
        queue.printQueue();
        
        queue.addQueue(11);
        queue.addQueue(12);
        
        queue.printQueue();

    }

}
