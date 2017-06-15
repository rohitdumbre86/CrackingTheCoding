package com.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Solving the classic consumer/producer problem using BlockingQueues.
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation 2017 All rights reserved.
 * </p>
 * 
 * @author Rohit Dumbre (RD025989)
 * @since X.X
 */
public class ProducerConsumer_BlockingQueues
{
    private static int value = 0;

    static class Producer
    {

        public void addToBuffer (BlockingQueue<Integer> bufferList)
        {
            try
            {
                bufferList.put(++value);
            }
            catch (InterruptedException e)
            {
                System.err.println(e);
            }
            System.out.println("Producer adding element " + value + " by thread " + Thread.currentThread().getName());
        }
    }

    static class Consumer
    {
        public void removeFromBuffer (BlockingQueue<Integer> bufferList)
        {
             try
            {
                int val = bufferList.take();
                System.out.println("Consumer removing element " + val + " by thread " + Thread.currentThread().getName());

            }
            catch (InterruptedException e)
            {
                System.err.println(e);
            }

        }
    }

    public static void main (String[] args) throws InterruptedException
    {
        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        final BlockingQueue<Integer> buffers = new ArrayBlockingQueue<Integer>(10);

        final Runnable producerRunnable = () -> {
            for (int i = 0; i < 50; i++)
            {
                producer.addToBuffer(buffers);
            }
        };

        final Runnable consumerRunnable = () -> {
            for (int i = 0; i < 45; i++)
            {
                consumer.removeFromBuffer(buffers);
            }
        };

        final Thread t1 = new Thread(producerRunnable);
        final Thread t2 = new Thread(consumerRunnable);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println("==============================================");
        System.out.println("Number of elements in buffer " + buffers.size());

    }
}
