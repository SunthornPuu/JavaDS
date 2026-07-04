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
        @SuppressWarnings("unchecked")
        // don't warn me unchecked cast
        // @ rule will put above where it will apply
        T get(int i){
                return (T)data[i];
        }
        void set(int i,int value){
                data[i]=value;
        }
}

class Vector<T extends Comparable<T> > extends DynamicArray<T> {
        void sort_r(int l,int r){
                if (l==r) return;
                int mid = (l+r)/2;
                sort_r(l,mid);
                sort_r(mid+1,r);
                Object[] temp = new Object[r-l+1];
                for(int i=l;i<=r;i++) temp[i-l] = data[i];
                int itr_l = l,itr_r = mid+1;
                int itr = l;
                while(itr_l != mid && itr_r != r){
                        if(itr_r != r)
                                if(itr_l == mid || ((T)temp[itr_r-l]).compareTo((T)temp[itr_l-l]) <= 0) {
                                        data[itr] = temp[itr_r-l];
                                        itr_r++;
                                }
                        else{
                                data[itr] = temp[itr_l-l];
                                itr_l++;
                        }
                        itr++;
                }
        }
}

class MyString<T extends Comparable<T> > extends DynamicArray<T> {

}
