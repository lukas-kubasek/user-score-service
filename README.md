User Score Service
==================

Simple implementation of a **User Score** Recoding Service.

Get & Build
-----------

This is a standard Maven project and can be build (incl. running the unit tests) using:

```
git clone https://github.com/lukas-kubasek/user-score-service.git
cd user-score-service 
mvn clean test
```

Components
----------

`UserScoreManager` interface offering two main operations to process and serialise the user scores:

```Java
public interface UserScoreManager<T> {

    T processUserScores(List<Integer> scores);

    String serialiseUserScores(T userScores);
}
``` 

There is one single implementation of the manager interface called `UserScoreManagerBinaryTree` using a binary tree
to order and count the scores.

The simple binary tree logic is implemented within the `model` package and consists of `BinaryTree` and `Node` classes.

Finally the ability to serialise the binary tree is implemented within the `BinaryTreeSerialiser` class.

Test Coverage
-------------

The project is covered by the main top level acceptance test `UserScoreManagerTest` verifying the integration of the
binary tree building and serialisation components using the provided sample data.
 
There are also couple of other small tests verifying the
correct functionality of the cooperating components (`NodeTest` or `BinaryTreeTest`). 

External Libraries
------------------

I purposefully kept the solution as simple as possible. The only external libraries required are JUnit and AssertJ (for fluent assertions). 