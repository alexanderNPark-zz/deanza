package dataStructs;

/**
 * Created by AlexP on 9/13/2017.
 */
public class Stack_A<T> {

    T[] content;
    int size;
    int pointer=0;

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

    public static void main(String[] arg){
        Stack_A<Integer> a = new Stack_A<Integer>(5);
        for(int i=0;i<10;i++){
            a.push(i);
        }
        for(int i=0;i<10;i++){
            System.out.println(a.pop());
        }
    }
}
