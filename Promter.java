import java.util.concurrent.TimeUnit;

class Promter
{
	// this will be done later

    public void wait(int minutes)
    {
        try {
            TimeUnit.MINUTES.sleep(minutes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
