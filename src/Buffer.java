import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class Buffer<T>{
  public final static int MAX_BUFFER_CAPACITY = 2;
  private Queue<T> componentQueue;

  public Buffer(){
    componentQueue = new ArrayBlockingQueue<T>(MAX_BUFFER_CAPACITY);
  }
}
