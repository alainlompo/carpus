<h3>Using the fitnesse standalone luncher</h3>
<br/>
<p>
	We first illustrated how to lunch fitnesse using the standalone version. You can use the FitnessStandaloneLuncher class and call it with
	two parameters which are the path where to find the standalone fitnesse jar and the port to use. Default values are provided as example.
	Since we are lunching it from a standalone version you can place the .jar anywhere that suits you. The ArithmeticServiceTest serves as a kind of proof of concept, or as a reference test. If you run it and it's green then you have everything set correctly.
</p>

ArithmeticServiceTest lunch result<br/>
<img src='https://github.com/alainlompo/carpus/blob/master/carpus-home/fitness-for-carpus/src/main/resources/arithmetic_service_test.png' alt='sample test' /><br/>

Here is what the corresponding test looks like:<br/>
<pre>
!path ./src/main/resources/fitnesse-standalone.jar
!path C:\Hypernovae\Technical\repositories\carpus\carpus-home\code-provider-for-fitness\target\classes
!path ./target/classes
!define TEST_SYSTEM {slim}
!contents -R2 -g -p -f -h

!|import|
|com.hypernovae.maths.services|
|com.hypernovae.fixtures.reference|

Testing the arithmetic service
------------------------------?|
This Test is intended to serve as a reference. execute the Test and if you have everything green you are ready!

Story N1: Performing sums with a variable list of arguments

!|com.hypernovae.fixtures.reference.ArithmeticServiceFixture|
|number1|number2|number3|number4|sum?|
|1      |2      |3      |4      |10  |
|11     |7      |3      |       |21  |
|19     |14     |       |       |33  |


Story N2: Performing modulo operations

!|com.hypernovae.fixtures.reference.ArithmeticServiceFixture|
|numToDivide|divider|modulo?|
|125        |4      |1      |
|19         |8      |3      |
|29         |6      |5      |
</pre>

<h4>Cumbersome class path referencing</h4>
Since we are using the standalone version we need to manually tell it where to find the classes it needs (including the fitnesse jar at runtime and the fixtures dependencies). We do it using the <b>!path</b> instruction, and as you noticed, it can become very cumbersome. Fortunately there is a better way to do this using the fitnesse maven dependencies. Similar approaches exists also for other build and dependencies management tools such as Gradle or Ivy. We will only illustrate the use of maven for now, other illustrations will follow later.<br/>

<h4>Using the SLIM test system instead of FIT</h4>
We use the Simple List Invocation Method (SLIM) instead of FIT to run our tests. With SLIM all the major processing behind fitnesse testing are kept in fitnesse rather than in the System Under Test (SUT). To learn more about SLIM testing system see <a href='http://www.fitnesse.org/FitNesse.UserGuide.WritingAcceptanceTests.SliM'>here</a>. We define SLIM using the following instruction:<br/>
<pre>!define TEST_SYSTEM {slim}</pre>
