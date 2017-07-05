
using MVCDemo.Controllers;
using NUnit.Framework;

namespace MVCDemo.test
{
    [TestFixture]
    public class HelloControllerTest
    {
        [Test]
        public void Write_To_The_Log()
        {
            var controller = new HelloController();
            controller.Execute(new FakeRequestContext());
        }
    }
}
