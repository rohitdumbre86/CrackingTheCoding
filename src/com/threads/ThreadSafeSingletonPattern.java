package com.threads;

public class ThreadSafeSingletonPattern
{

    private volatile static ThreadSafeSingletonPattern INSTANCE;

    private ThreadSafeSingletonPattern ()
    {
    }

    public static ThreadSafeSingletonPattern getInstance ()
    {
        if (INSTANCE != null)
        {
            return INSTANCE;
        }
        synchronized (ThreadSafeSingletonPattern.class)
        {
            if (INSTANCE == null)
            {
                INSTANCE = new ThreadSafeSingletonPattern();
            }
        }
        return INSTANCE;
    }

    public static void main (String[] args) throws InterruptedException
    {

        final Runnable runnableSingleton = () -> {
            {
                ThreadSafeSingletonPattern pattern = ThreadSafeSingletonPattern.getInstance();
                System.out.println("Object id " + pattern.hashCode());
            }

        };

        final Thread[] threads = new Thread[100];
        for (int i = 0; i < 100; i++)
        {
            threads[i] = new Thread(runnableSingleton);
        }

        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++)
        {
            threads[i].join();
        }
    }

}
