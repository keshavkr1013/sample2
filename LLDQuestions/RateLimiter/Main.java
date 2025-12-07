package LLDQuestions.RateLimiter;

public class Main {
    public static void main(String[] args) throws Exception{
        Bucket bucket = new Bucket(5, 2);
        RateLimiter rateLimiter = new RateLimiter(bucket);
        for(int i=1;i<=20;i++)
        {
            System.out.print("Request "+ i + " status: ");
            rateLimiter.processRequest();
            Thread.sleep(300);
        }
    }
}

