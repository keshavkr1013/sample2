package LLDQuestions.RateLimiter;


public class Bucket {
    private int maxCapacity;
    private double tokensLeft;
    private double refillRate;
    private long lastRefillTimestamp;
    Bucket(int maxCapacity, double refillRate)
    {
        this.maxCapacity = maxCapacity;
        this.refillRate = refillRate;
        this.tokensLeft = maxCapacity;
        this.lastRefillTimestamp = System.currentTimeMillis();
    }
    public synchronized boolean tryConsume()
    {
        //should use ReentrantLock(true) for fair locking to prevent starvation
        refill();
        if(tokensLeft>=1)
        {
            tokensLeft-=1;
            return true;
        }
        else
        {
            return false;
        }
    }
    public void refill()
    {
        long now = System.currentTimeMillis();
        double newTokens = ((now-lastRefillTimestamp)/1000.0)*refillRate;
        tokensLeft = Math.min(maxCapacity, tokensLeft+newTokens);
        lastRefillTimestamp = now;
    }
}
