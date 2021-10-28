package br.com.supercloud.dynamic;

public class Google {

/*
Service towers:
An SMS can be received/transmitted by a service tower from/to a phone or another service tower located in its vicinity (left, right, up or down). For example:

a message can be sent from s to d:
sTTT
   T
   TTTd


a message cannot be sent from s to d:
sT T
   T
   TTTd



There is a field of size rows x cols and it is initially empty. A cell phone service provider is building service towers so that people can communicate without crossing the field. They build these towers one at a time.

We can ask the service company to build a new tower, but cannot specify where.  When the left side of the field is connected to the right side, we should stop asking then to build towers, and also return the number of towers built.

To request the service provider to build a new tower, use ServiceProvider.nextTower() which returns an integer point object (r, c) where 0 <= r < rows and 0 <= c < cols.


Example:

ServiceProvider.nextTower() returns one per call in {(0, 2), (1, 0), (1, 2), (2, 1), (1, 1)}. The numbers on the grid show what day a tower was built.
        012
       +---+
     0 |  1|
     1 |253|
     2 | 4 |
       +---+

        01234
       +-----+
     0 |  187|
     1 |25 6 |
     2 | 4   |
       +-----+

day: 5

*/

// MergeIterator
// it1: 1, 3, 5
// it2: 2, 3, 4
// output: 1, 2, 3, 3, 4, 5

// it1: 1, 2, 3, 5
// it2: 6, 7, 8


// it1: 1, 5
// it2: 2,
// output: 1, 2, 5


/*while(mergeIt.hasNext()) {
    T value = mergeIt.next();
    sout(value);
}*/




/*

    public class MergeIterator<T> implements Iterator<T> {

        private Iterator<T> it1;
        private Iterator<T> it2;
        private T valueIt1;
        private T valueIt2;

  public MergeIterator<T>(Iterator<T> it1, Iterator<T> it2) {
            this.it1 = it1;
            this.it2 = it2;
        }

        public T next() {
            if (valueIt1 == null && it1.hasNext()) {
                valueIt1 = it1.next();
            }

            if (valueIt2 == null && it2.hasNext()) {
                valueIt2 = it2.next();
            }

            if (valueIt1 == null) {
                return valueIt2;
            }

            if (valueIt2 == null) {
                return valueIt1;
            }

            T value;
            if (valueIt1.compareTo(valueIt2) < 0) {
                value = valueIt1;
                valueIt1 = null;
            } else {
                value = valueIt2;
                valueIt2 = null;
            }
            return value;
        }

        // it1: 1, 5
        // it2: 2,
        // output: 1, 2, 5


        public boolean hasNext() {
            if (valueIt1 == null && it1.hasNext()) {
                valueIt1 = it1.next();
            }
            if (valueIt2 == null && it2.hasNext()) {
                valueIt2 = it2.next();
            }

            return valueIt1 != null || valueIt2 != null;

            // return it1.hasNext() || it.hasNext() || value1 != null || value2 != null;
        }
    }
*/

}
