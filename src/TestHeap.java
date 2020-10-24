/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-24
 * Time:18:45
 **/
public class TestHeap {
    public int[] array;
    public int size;

    public void adjustDown(int[] array,int size,int index){
        while(true){
            int leftChild = index*2+1;
            if (leftChild > size){
                break;
            }
            int minIndex = leftChild;
            int rightIndex = leftChild+1;
            if (rightIndex < size && array[rightIndex] < array[leftChild]){
                minIndex = rightIndex;
            }
            if (array[index] < array[minIndex]){
                break;
            }
            int tmp = array[minIndex];
            array[minIndex] = array[index];
            array[index] = tmp;

            index = minIndex;
        }

    }

    public void adjustUp(int[] array,int size,int index){
        while (true){
            if (index == 0){
                break;
            }
            int parentIndex = (index-1)/2;
            if (array[parentIndex] < array[index]){
                break;
            }
            int tmp = array[parentIndex];
            array[parentIndex] = array[index];
            array[index] = tmp;
            index = parentIndex;
        }

    }
}
