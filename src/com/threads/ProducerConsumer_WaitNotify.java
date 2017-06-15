package com.threads;

/**
 * Solving the classic consumer/producer problem using wait/notify().
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation 2017 All rights reserved.
 * </p>
 * 
 * @author Rohit Dumbre
 * @since X.X
 */
public class ProducerConsumer_WaitNotify
{

    private static int count = 0;
    private Object key = new Object();

    public class Producer
    {
        public void addToBuffer (int[] buffer) throws InterruptedException
        {
            synchronized (key)
            {

                if (count == buffer.length)
                {
                    key.wait();
                }
                buffer[count++] = 1;
                key.notify();
            }
        }
    }

    public class Consumer
    {
        public void removeFromBuffer (int[] buffer) throws InterruptedException
        {
            synchronized (key)
            {

                if (count == 0)
                {
                    key.wait();
                }
                buffer[--count] = 0;
                key.notify();
            }
        }
    }

    public static void main (String[] args) throws InterruptedException
    {

        final ProducerConsumer_WaitNotify classicConsumerProducer = new ProducerConsumer_WaitNotify();
        final Producer producer = classicConsumerProducer.new Producer();
        final Consumer consumer = classicConsumerProducer.new Consumer();
        final int[] buffer = new int[10];
        

        final Runnable producerRunner = new Runnable()
        {

            @Override
            public void run ()
            {
                for (int i = 0; i < 45; i++)
                {
                    try
                    {
                        producer.addToBuffer(buffer);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e);
                    }
                }

            }
        };

        final Runnable consumerRunner = new Runnable()
        {

            @Override
            public void run ()
            {
                for (int i = 0; i < 50; i++)
                {
                    try
                    {
                        consumer.removeFromBuffer(buffer);
                    }
                    catch (InterruptedException e)
                    {
                        System.out.println(e);
                    }
                }

            }
        };

        final Thread t1 = new Thread(producerRunner);
        final Thread t2 = new Thread(consumerRunner);

        t1.start();
        t2.start();

        t1.join();
        t1.join();

        int k = 0;
        while (k < buffer.length && buffer[k] == 1)
        {
            k++;
        }
        System.out.println("Number of elements in buffer " + k);
    }
}
