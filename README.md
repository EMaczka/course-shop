# course-shop
Java spring boot project for a course shop


Course shop is a simple backend of an e-shop application with programming courses.
It is based on springboot and the built-in h2 database.

In the controller classes, there are methods such as get, post, delete, and put for the address endpoints. Possible exceptions are handled specifically and tell the cause of the error.
The course entity contains a discount calculation method for which unit tests are written.
The test suite includes, in addition to unit tests, integration tests that use test data in the CourseTestData class.
The application supports CORS.
