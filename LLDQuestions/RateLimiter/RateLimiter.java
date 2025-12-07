package LLDQuestions.RateLimiter;


public class RateLimiter {
    private Bucket bucket;
    RateLimiter(Bucket bucket)
    {
        this.bucket = bucket;
    }
    public void processRequest()
    {
        boolean isFullfilled = bucket.tryConsume();
        if(isFullfilled)
        {
            System.out.println("Request served");
        }
        else
        {
            System.out.println("Rate limit exceeded");
        }
    }
}
