<h1>Automation tests</h1>

To run test on local env you can just run RunnerTest.
By default, tests start on Chrome browser but you can easily change to Firefox
browser in Hooks.

If you want to run tests using Maven:

`mvn test -Dtest=RunnerTest -Dbrowser=firefox`

If you want to run tests on different env(prod is default):

`mvn test -Dtest=RunnerTest -Denv=test -Dbrowser=firefox`