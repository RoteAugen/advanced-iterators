#Advanced Iterators

A collection of Java iterators that extends the basic linear behavior. It adheres to the Decorator Pattern to ensure loose coupling and a high flexibility.

### PeekIterator
add a ```.peek()``` function to allow obtaining value without advancing the iterator.

** This iterator should be used as the OUTERMOST layer of decoration.**

### EvenIterator
returns 0th, 2nd, 4th... element of a container.
