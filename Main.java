/*
Разработайте HashMap без использования каких-либо встроенных библиотек хеш-таблиц.
Чтобы быть конкретным, ваш дизайн должен включать эти функции:
put (Key, Value): вставить пару (ключ, значение) в HashMap. Если значение уже существует в HashMap, обновите значение.
get (key): возвращает значение, которому сопоставлен указанный ключ, или -1, если эта карта не содержит значение для ключа.
remove (Key): удалить сопоставление для ключа значения, если эта карта содержит сопоставление для ключа.

Все ключи и значения будут в диапазоне [0, 1000000].
Количество операций будет в диапазоне [1, 10000].
Не используйте встроенную библиотеку HashMap.
Пример :
MyHashMap hashMap = new MyHashMap();
hashMap.put(1, 1);          
hashMap.put(2, 2);         
hashMap.get(1);            // returns 1
hashMap.get(3);            // returns -1 (not found)
hashMap.put(2, 1);         // update the existing value
hashMap.get(2);            // returns 1 
hashMap.remove(2);         // remove the mapping for 2
hashMap.get(2);            // returns -1 (not found) 
*/

import java.util.ArrayList;

class MyHashMap {

	private static final int MAX_KEY_VALUE = 1000000;
	private static final int MAX_ITERATIONS = 1000;
	private int countIter;
	int nums[];

	/** Initialize your data structure here. */
	MyHashMap() {
		nums = new int[MAX_KEY_VALUE+1];
		countIter = 0;
		for (int i = 0; i < nums.length; i++){
			nums[i] = -1;
		}

    	}
    
	/** value will always be non-negative. */
	void put(int key, int value) {
		if ((0 <= key) && (key <= MAX_KEY_VALUE)){
			if ((0 <= value) && (value <= MAX_KEY_VALUE)){
				if(nums[key] != -1){
					if(countIter < MAX_ITERATIONS){
			        		nums[key] = value;
						countIter = countIter + 1;
					}
				}
				else{
			        	nums[key] = value;
				}

			}

		}
	}
    
	/** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
	int get(int key) {
		System.out.printf(" [%d] = %d\n", key, nums[key]);
		return nums[key];        
	}
    
	/** Removes the mapping of the specified value key if this map contains a mapping for the key */
	void remove(int key) {
        	nums[key] = -1;
		countIter = countIter - 1;
	}
    
	void list() {
        
        System.out.printf("nums:");
	for (int i = 0; i < nums.length; i++){
		if(nums[i] != -1){
			System.out.printf(" [%d] = %d", i, nums[i]);
		}
	}
    }

};

public class Main {

    public static void main(String[] args) {

	MyHashMap hashMap = new MyHashMap();
	hashMap.put(1, 1);          
	hashMap.put(2, 2);         
	hashMap.get(1);            // returns 1
	hashMap.get(3);            // returns -1 (not found)
	hashMap.put(2, 1);         // update the existing value
	hashMap.get(2);            // returns 1 
	hashMap.remove(2);         // remove the mapping for 2
	hashMap.get(2);            // returns -1 (not found) 
	hashMap.put(5, 100);          
	hashMap.put(123, 12357);
	hashMap.list();

    }

}
