# HashIntSet Java 

## Overview
The `HashIntSet` project is a Java-based implementation of a hash set that stores integer values. This implementation offers the basic functionality of a set, such as adding, removing, and checking for the presence of integers. The underlying structure uses hash buckets to efficiently store and retrieve elements, optimizing performance for large datasets.

## Features
- **Add Elements**: Allows users to add integers to the set.
- **Remove Elements**: Allows users to remove integers from the set.
- **Contains Check**: Quickly checks if a specific integer exists in the set.
- **Unique Storage**: Ensures that all elements in the set are unique, with no duplicates allowed.
- **Efficient Lookups**: Implements hash buckets for fast retrieval and storage.

## Methods Overview
- **`add(int value)`**: Adds an integer to the set. If the value already exists, it will not be added again.
- **`remove(int value)`**: Removes a specified integer from the set, if it exists.
- **`contains(int value)`**: Returns `true` if the set contains the specified value, otherwise `false`.
- **`size()`**: Returns the total number of elements in the set.
- **`toString()`**: Returns a string representation of the set, displaying all elements.

## Example Usage
```java
HashIntSet set = new HashIntSet();
set.add(10);         // Adds 10 to the set
set.add(20);         // Adds 20 to the set
set.add(30);         // Adds 30 to the set
System.out.println(set.contains(20));  // Outputs: true
set.remove(20);      // Removes 20 from the set
System.out.println(set);  // Outputs the remaining elements
```
## Requirements
Java 8 or higher.
Installation
Clone or download the repository.
Compile the Java files using any Java-compatible IDE or from the terminal.
Run the HashIntSet.java file to start using the hash set functionality.

## Contact
For any questions or suggestions, feel free to reach out to me at [ashakirov@stetson.edu]
