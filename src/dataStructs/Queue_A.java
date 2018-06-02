package dataStructs;

/**
 * Created by AlexP on 9/13/2017.
 */
public class Queue_A<T>{

    private int size=0;
    private T[] content;
    private int first,last=0;

    public Queue_A(int size){
        this.size = size;
        content = (T[]) new Object[size];
        first = 0;
        last = 0;
    }

    public void enqueue(T item){
        if(last==size-1){
            resize();
        }
        content[last] = item;
        last = (last+1)%size;
    }

    private void resize(){


    }

    public T dequeue(){
        if(first>last){
            return null;
        }
        T item = content[first];
        first = (first+1)%size;
        return item;
    }

    public void empty(){
        for(int i=0;i<content.length;i++){
            content[i]=null;
        }
        first=0;
        last=0;
    }

    public static void main(String[] args){
        Queue_A<Integer> queue = new Queue_A<Integer>(10);

    }


}
