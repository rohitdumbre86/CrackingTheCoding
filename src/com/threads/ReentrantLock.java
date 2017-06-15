package com.threads;

import java.util.concurrent.locks.Lock;

/**
 * TODO Description.
 * <p />
 * <p style="font-style:italic;font-variant;small-caps;font-size:80%">
 * Copyright &copy; Cerner Corporation 2017 All rights reserved.
 * </p>
 * 
 * @author Rohit Dumbre (RD025989)
 * @author Messaging MSVC
 * @since X.X
 */
public class ReentrantLock
{

    private boolean isLocked = false;
    private int lockCount = 0;
    private Thread myLockedThread = null;

    public synchronized void lock ()
    {
        while (this.isLocked && myLockedThread != Thread.currentThread())
        {

            try
            {
                this.wait();
                System.out.println("The thread "+Thread.currentThread().getName() + " is suspended ");
            }
            catch (InterruptedException ex)
            {
                System.out.println("Lock exception " + ex);
            }

        }

        this.isLocked = true;
        this.myLockedThread = Thread.currentThread();
        this.lockCount++;

    }

    public synchronized void unlock ()
    {
        if (Thread.currentThread() == myLockedThread)
        {
            lockCount--;
        }

        if (lockCount == 0)
        {
            this.isLocked = false;
            this.notify();
        }

    }
}
