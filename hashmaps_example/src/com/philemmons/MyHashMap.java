package com.philemmons;

public class MyHashMap<K, V> {


    private class Entry<K, V> {

        private K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
            this.next = null;
        }

        public K getKey() {
            return this.key;
        }

        public void setKey(K newKey) {
            this.key = newKey;
        }

        public V getValue() {
            return this.value;
        }

        public void setValue(V newValue) {
            this.value = newValue;
        }

        @Override
        public String toString() {
            Entry<K, V> temp = this;
            StringBuilder sb = new StringBuilder();

            while (temp != null) {
                sb.append(temp.key)
                        .append(" -> ")
                        .append(temp.value)
                        .append(", ");

                temp = temp.next;
            }
            return sb.toString();
        }

    }


    private final int SIZE = 5;
    private Entry<K, V> table[];

    public MyHashMap() {
        table = new Entry[SIZE];
    }

    public void put(K newKey, V newValue) {
        
        if(newKey == null){
            return;
        }

        int hash = newKey.hashCode() % SIZE;

        Entry<K, V> entry = table[hash];

        if (entry == null) {
            table[hash] = new Entry<K, V>(newKey, newValue);

        } else {

            //keep a reference to the last pointer
            while (entry.next != null) {

                if (entry.getKey() == newKey) {
                    entry.setValue(newValue);
                    return;
                }

                entry = entry.next;
            }

            if (entry.getKey() == newKey) {
                entry.setValue(newValue);
                return;
            }

            entry.next = new Entry<>(newKey, newValue);
        }
    }

    public V get(K newKey) {

        if(newKey == null) return null;

        //init hash index
        int hash = newKey.hashCode() % SIZE;

        Entry<K, V> entry = table[hash];

        if (entry == null) {
            return null;
        }

        while (entry != null) {

            if (entry.getKey() == newKey) {
                return entry.getValue();
            }

            entry = entry.next;

        }

        return null;

    }

    public Entry<K, V> remove(K theKey) {
        int hash = theKey.hashCode() % SIZE;

        Entry<K, V> entry = table[hash];

        if (entry == null) {

            return null;
        }

        if (entry.getKey() == theKey) {

            table[hash] = entry.next;
            entry.next = null;
            return entry;
        }

        Entry<K, V> pre = entry;
        entry = entry.next;

        while (entry != null) {
            if (entry.getKey() == theKey) {

                pre.next = entry.next;
                entry.next = null;
                return entry;
            }

            pre = entry;
            entry = entry.next;
        }

        return null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {

            if (table[i] != null) {

                sb.append(i)
                        .append(" ")
                        .append(table[i])
                        .append("\n");

            } else {

                sb.append(i)
                        .append(" null\n");
            }
        }

        return sb.toString();
    }

}
