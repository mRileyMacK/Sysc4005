import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer<T>{
  public final static int MAX_BUFFER_CAPACITY = 2;
  private ArrayBlockingQueue<T> componentQueue;

  public Buffer(){
    componentQueue = new ArrayBlockingQueue<T>(MAX_BUFFER_CAPACITY);
  }

  public Queue<T> getComponentQueue() {
    return componentQueue;
  }
  public Component getNextComponent(){
    Component c;
    try{
        c = (Component)componentQueue.take();
        if(c != null){
          System.out.println("BUFFER: Component " + c.getNum() + " taken from buffer");
          return c;
        }
        else{
          System.out.println("BUFFER: Component was null");
          return c;
        }
    }
    catch(Exception e ){
      System.out.println("BUFFER: Unable to get next component err: "+ e.toString());
      return null;
    }

  }
}
