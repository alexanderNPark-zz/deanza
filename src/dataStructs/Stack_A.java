package dataStructs;

/**
 * Created by AlexP on 9/13/2017.
 */
public class Stack_A<T> {

    T[] content;
    int size;
    int pointer=-1;

    public Stack_A(int size){
        this.size = size;
        content = (T[]) new Object[size];

    }

    public void push(T element){
        if(pointer==size-1){
            resize();
        }
        content[++pointer]=element;
    }

    public boolean isEmpty(){
        return pointer<0;
    }

    public void empty(){
        for(int i=0;i<content.length;i++){
            content[i] = null;
        }
        pointer=0;
    }

    public T pop(){
        if(pointer<0){
            return null;
        }
        return content[pointer--];
    }

    public T peek(){
        return content[pointer];
    }

    private void resize(){
        T[] temp = content;
        size*=2;
        content = (T[])new Object[size*2];
        for(int i=0;i<temp.length;i++){
            content[i] = temp[i];
        }

    }


}
