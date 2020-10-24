/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-24
 * Time:18:51
 **/
public class MyPriorityQueue {

    public int[] array = new int[100];
    public int size;

    public void offer(int x){
        array[size] = x;
        size++;
       adjustDown(array,array.length,size-1);
    }

    public void adjustDown(int[] array,int size,int index){
        while(true){
            int leftChild = index*2+1;
            if (leftChild > size){
                break;
            }
            int maxIndex = leftChild;
            int rightChild = leftChild+1;
            if (rightChild < size && array[rightChild] > array[rightChild]){
                maxIndex = rightChild;
            }
            if (array[index] > array[maxIndex]){
                break;
            }
           int tmp = array[maxIndex];
            array[maxIndex] = array[index];
            array[index] = tmp;
            index = maxIndex;
        }
    }
    public void adjustUp(int[] array,int size,int index){
        while (true){
            if (size == 0){
                break;
            }
            int parentIndex = (size-1)/2;
            if (array[parentIndex] > array[index]){
                break;
            }
            int tmp = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = tmp;
        }
    }
    public Integer poll(){
        if (size == 0){
            return null;
        }
        int tmp = array[0];
        array[0]  = array[size-1];
        adjustUp( array, size,0);
        size--;
        return tmp;
    }
    public Integer peek(){
        return array[0];
    }
}
