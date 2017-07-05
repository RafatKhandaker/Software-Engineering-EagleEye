using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace DemoTestApplication.Tests
{
    [TestClass]
    public class MemoryCalculatorTests
    {
     
        [TestMethod]
        public void ShouldAdd()
        {
            MemoryCalculator memCalA = new MemoryCalculator();

            Assert.AreEqual(memCalA.add(2.7, 3.3), 6);
        }

        [TestMethod]
        public void ShouldSubtract()
        {
            MemoryCalculator memCalS = new MemoryCalculator();

            Assert.AreEqual(memCalS.subtract(2.3, 3.3), -1.0);
            Assert.AreEqual(memCalS.subtract(3.3, 2.3), 1.0);

            //    Assert.AreEqual(memCalS.subtract(3.3, 2.3), 0.6);
        }

        [TestMethod]
        public void TestAdd(int x, int y)
        {
            x = 5; y = -5;
            MemoryCalculator memCalAdd = new MemoryCalculator();

            Assert.AreEqual(memCalAdd.add(x, y), 0);
        }
    }
}