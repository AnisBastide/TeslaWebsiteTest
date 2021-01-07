cd src/ &&

javac -d ../bin/ test/functional/*.java &&

cd ../bin &&
java org.junit.runner.JUnitCore test.functional.HomePageTest
