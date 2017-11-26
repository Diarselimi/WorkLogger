import java.util.concurrent.TimeUnit;

class Promter
{
	// this will be done later
    private Panel panel;

    public void wait(int minutes)
    {
        try {
            TimeUnit.MINUTES.sleep(minutes);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void prompt(Panel panel)
    {
        if (this.panel != null) {
            this.panel.closeIt();
        }
        this.panel = panel;
    }
}
