using NUnit.Framework;
using System.Collections;

namespace DemoUnitTesting.Tests
{

    [TestFixture]
    public class MethodTests
    {
        Methods methodsClass = new Methods();

        [Test]
        public void ShouldAppendString()
        {

            Assert.AreEqual(methodsClass.appendString("foo", "bar"), "foobar");
        }

        [Test]
        public void ShouldAdd()
        {
            Assert.AreEqual(methodsClass.add(2.3, 3.7), 6.0);
        }

        // Data driven tests

        [TestCase(-5, 5)]
        public void DefaultAddProperty(int x, int y)
        {
            var addNum = new Methods();

            Assert.AreEqual(addNum.add(x, y), 0);
        }

        // re-using Data for tests, will check all cases

        [TestCase(-4, 4)]
        [TestCase(5, -5)]
        [TestCase(-6, 6)]
        [TestCase(15, 15)]
        [Ignore("Test Fails")]   // temporarily ignore tests
        public void multiDataTestingFailed(int x, int y)
        {
            methodsClass = new Methods();

            Assert.AreEqual(methodsClass.add(x, y), 0);
        }

        [TestCase(-4, 4)]
        [TestCase(5, -5)]
        [TestCase(-6, 6)]
        [TestCase(15, -15)]
        public void multiDataTestingPass(int x, int y)
        {
            methodsClass = new Methods();

            Assert.AreEqual(methodsClass.add(x, y), 0);
        }

        [Test]
        public void ShouldAddAndDivide(
            [Values(10, 20)] double numToAdd,
            [Values(2, 1)] double numToDivideBy)
        {


            methodsClass.add(numToAdd, 0);
            methodsClass.divide(numToDivideBy, 1);
        }

        // Large variations of generated input data
        public class ExampleTestCaseSource : IEnumerable
        {
            public IEnumerator GetEnumerator()
            {
                yield return new[] { -5, -10 };
                yield return new[] { -5, -5 };
                yield return new[] { -5, 0 };
                yield return new[] { 0, 0 };
            }
        }

        [Test]
        public void ShouldProjectShortTerm()
        {
            var stockProject = new StockMarketProjection();

            var marketValue = stockProject.CalculateShortTerm();

            Assert.That(marketValue, Is.EqualTo(200));
        }

        [Test]
        [Category("long")]  // categorize the tests into the module 
        public void ShouldProjectLongTerm()
        {
            var stockProject = new StockMarketProjection();

            var marketValue = stockProject.CalculateLongTerm();

            Assert.That(marketValue, Is.EqualTo(50));
        }

        [Test]
        [Category("long")]  // categorize the tests into the module 
        [MaxTime(4000)]     // test will fail because thread in method is sleeping for 5 seconds
        public void ShouldProjectLongTermFail()
        {
            var stockProject = new StockMarketProjection();

            var marketValue = stockProject.CalculateLongTerm();

            Assert.That(marketValue, Is.EqualTo(50));
        }

        [Test]
        [Category("Simulated Bug")]
        [Repeat(10000)]           // will repeat the test atleast 10000 before passing / failing
        public void ShouldDoWork()
        {
            var interBug = new IntermittentBug();

            interBug.DoWork();

        }
    }

   

}
