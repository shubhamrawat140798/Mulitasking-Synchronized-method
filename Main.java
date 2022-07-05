/*Synchronized method*/
class Work
{
    synchronized public void getLine()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println(i);
            try
            {
                Thread.sleep(4);
            }
            catch (Exception e)
            {
                System.out.println(e);
            }
        }
    }
}
  
class Train extends Thread
{
    Work work;
    Train(Work work)
    {
        this.work = work;
    }
  
    @Override
    public void run()
    {
        work.getLine();
    }
}
  
public class Main
{
    public static void main(String[] args)
    {
        Work obj = new Work();
        Train train1 = new Train(obj);
        Train train2 = new Train(obj);
        train1.start();
        train2.start();
    }
}

