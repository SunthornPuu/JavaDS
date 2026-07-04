package JavaDS;


public class DynamicArray<T extends Comparable<T>> {
        Object[] data;
        int size;
        int capacity;
        T min(T a, T b) {
                if (a.compareTo(b) <= 0) {
                return a;
                }
                return b;
        }
        DynamicArray(int size){
                this.size = size;
                capacity = size;
                data = new Object[size];
        }
        DynamicArray(int size, T value){
                this.size = size;
                capacity = size;
                data = new Object[size];
                for(int i=0;i<size;i++)data[i] = value;
        }
        DynamicArray(){
                size = 0;
                capacity = 0;
        }
        void resize(int size){
                Object[] temp = new Object[size];
                for(int i=0;i<size&&i<this.size;i++) temp[i]=data[i];
                data = temp;
                this.size = size;
                capacity = size;
        }
        void expand(){
                int temp = size;
                resize(size*2+1);
                size = temp;
        }
        void push_back(T value){
                if(size==capacity)expand();
                data[size] = value;
                size++;
        }
        void pop_back(){
                data[size-1] = null;
                size--;
        }
}

class Vector<T> extends DynamicArray<T> {

        
}

class MyString<T> extends DynamicArray<T> {

}
