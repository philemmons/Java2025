# Threads

## Threads in Java are lightweight subprocesses that enable concurrent execution within a program. They allow multiple tasks to run seemingly simultaneously, improving application performance and responsiveness. Each Java program starts with a main thread, and additional threads can be created to handle specific tasks concurrently.

### Threads are important for several reasons:

- Concurrency:

##### Threads enable programs to perform multiple tasks concurrently, leading to better resource utilization and faster execution times, especially in applications with I/O operations or computationally intensive tasks.
    
- Responsiveness:
    
##### By using threads, applications can remain responsive to user input even while performing long-running operations in the background.
    
- Efficiency:

##### Threads share the same memory space, making communication and data sharing between them more efficient compared to separate processes.
    
- Multitasking:

##### Threads facilitate multitasking within a single application, allowing it to handle multiple requests or operations simultaneously. 

##### However, it's crucial to manage threads carefully to avoid concurrency issues such as race conditions and deadlocks. Synchronization mechanisms like locks and semaphores are used to coordinate access to shared resources and ensure data consistency.

- Source: Generative ai

## Another factor: Concurrency and parallelism

####  Concurrency and parallelism, which sound the same in English but aren't the same to computer scientists and programmers. Parallelism is actually running multiple things at the same time (or intended to be) and concurrency could be at the same time, but is better considered a design feature and not an execution feature.

- Parallelism lets you speed up your program, taking advantage of the additional CPU cores or GPU shader units available to it.

- Concurrency lets you simplify your program (usually, if it doesn't it should be reconsidered or cleaned up, or you just have a complex program). 

## In object-oriented programming, the singleton pattern is a software design pattern that restricts the instantiation of a class to a singular instance

##### More specifically, the singleton pattern allows classes to:

- Ensure they only have one instance

- Provide easy access to that instance

- Control their instantiation (for example, hiding the constructors of a class)

##### The term comes from the mathematical concept of a singleton. 

- Source: [en.wikipedia.org/wiki/Singleton_pattern](https://en.wikipedia.org/wiki/Singleton_pattern)