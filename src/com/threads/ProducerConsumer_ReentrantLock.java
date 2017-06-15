package com.threads;

/**
 * This is uncompleted implementation of re-entrant lock.
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation 2017 All rights reserved.
 * </p>
 * 
 * @author Rohit Dumbre (RD025989)
 * @author Messaging MSVC
 * @since X.X
 */
public class ProducerConsumer_ReentrantLock
{

    private static int index = 0;
    private static ReentrantLock lock = new ReentrantLock();

    static class Producer
    {
        public void addToBuffer (int[] buffer)
        {
            if (buffer.length > index)
            {
                buffer[index++] = 1;
                System.out.println("The producer has added element " + index);
            }

        }
    }

    static class Consumer
    {
        public void removeFromBuffer (int[] buffer)
        {

            if (index > 0)
            {
                buffer[--index] = 0;
                System.out.println("The consumer has now removed element " + index);

            }
        }
    }

    public static void main (String[] args) throws InterruptedException
    {

        Producer produce = new Producer();
        Consumer consume = new Consumer();

        int[] buffer = new int[10];

        final Runnable producer = () -> {

            lock.lock();
            for (int i = 0; i < 50; i++)
            {
                produce.addToBuffer(buffer);
            }
            lock.unlock();

        };

        final Runnable consumer = () -> {
            lock.lock();
            for (int i = 0; i < 45; i++)
            {
                consume.removeFromBuffer(buffer);
            }
            lock.unlock();
        };

        Thread t1 = new Thread(producer);
        Thread t2 = new Thread(consumer);

        t1.setName("Producer Thread");
        t2.setName("Consumer Thread");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        int k = 0;
        while (k < buffer.length && buffer[k] == 1)
        {
            k++;
        }
        System.out.println("Number of elements in buffer " + k);

    }
}
