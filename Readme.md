## How to Run
TDD approach is followed, hence there is no Main provided. The only way to test the functionality is running the tests. Make sure that you have already installed sbt. 

Once you are in the project root directory, you should run the following on the command line:

```sbt test```

## Technical Spec
TDD approach is followed while writing the code. The code is based on the principle of writing the simplest solution to make the test pass. The code consists of a Service Level class, CheckoutService, 
responsible for calculating the price for the items in the Shopping Cart. 

## Possible Future Improvements
Since the minimal solution approach is followed and the document is taken as the source of truth,
the possible scenarios have not been implemented. 

#### Failure Scenarios
One of these scenarios are failure scenarios. In case of possible additions like getting
the items from a repository or a microservice downstream, there are always failure scenarios,
which should be handled by Either. In case of asynchronous calls the errors should be handled using
it should be covering the asynchronous context of the response, a usage like

```Future[Either[Error, Price]]```

or even better using the Cats Monad Transformer 

```EitherT[Future, Error, Price]```
 
 would make more sense. In such a case the signature would be as 
 
```def calculateTotalPrice(items: List[Item]): EitherT[Future, ServiceError, Price]```
 
#### Dependency Injection
In case of future possible additions, like Repository or Downstream Endpoints as mentioned above, these interfaces might be injected into the
constructor of the service class CheckoutService. As said, since heavily TDD approach is followed,
the assignment documentation is taken as the source of truth, and the simplest solution to pass the tests that fulfill the requirements 
were implemented.   

 

