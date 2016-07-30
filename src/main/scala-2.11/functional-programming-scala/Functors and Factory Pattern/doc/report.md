## Comparison with Project2a
Upon completion of this project, we compared Projects 2a and 2b. The following is the result of this comparison.

| Attribute         | Poject2a             | Project2b |
|-------------------|----------------------|-----------|
| Modifiability and extensibility    | To modify an existing shape or create a new one, you have do a lot of work. Change the shapes definition hierarchy and make necessary changes to every behavior definition | Modifying and extending the system still cascades through the same paths. However, with the approach here, the code-base is better-organized and we only need to change two files, namely the structures and behaviors |
| Integrability     | The fact that that all shapes are integrated into the same operation/behaviors is a good sign of integrability. However, the use of explicit recursion and handling each shape type differently adds extra work as the system grows in size.  | The system is very integrable. While it caters to all the advantages in project2a, it adds the implicit recursion. This allows us to treat all shapes as equivalent entities. The cata is an example that it can be easily integrated to the systems |
| Portability       | Doesn't depend on other libraries and can be run with Scala standard library  | Depends on Scalamu and Scalaz. Once the shapeF factory is established user can re-import these functions and use them |
| Performance       | For complex computations we have to make explicit recursive calls on shape tree hierarchies which is inefficient sometimes.  | Our ShapeF is a functor. The functor composition law makes complex computations more efficient by combining such computations |
| Reliability       |  It is error-prone since the implementations is not cohesive. For every type of operation and shape we have to implement behaviors recursively. | Once we have a correct implementation of the Algebra in place. More expressive code and hence less error-prone, e.g using the cata |
| Reusability       |  Here the the shape abstraction are available for reuse. We need to implement behaviors explicitly using recursion | Here the nature of our data structure (recursion) is embedded into the ShapeF functor and is available for reuse |

## FoldRight
Catamorphism (“cata”) provides a simple route to designing fold-like functions on other algebraic data structures, like various sorts of trees. It takes a simple algebraic function and creates a recursive evaluator for a nested data structure (the fix point of the functor in question). This is a generalization of list folding to arbitrary recursive data structures. As shown in [This figure](http://slid.es/davidtan/catamorphism?token=6wSLsqqBZydzxUHp1oa8utkkuUEr), cata is a generalized foldRight function.

* cata helps achieve the same goal as that by foldRigth.
* Even though we have not used cata explicitly in our implementation of size, boundingBox, etc. it may possibly be used since it presents an elementwise representation of our tree, as shown in the tests.

## Conclusion
As shown in the above table, for a simple project, the method used in Project2a is ample in functionality. However, with regards to an extensive architectured structure, Project 2b has the attributes to go on full scale. The example of cata fully demonstrates the robustness of Project2b.
