

using Microsoft.Extensions.Configuration;

namespace OdeToFood.Services
{
    public interface IGreeter
    {
        string GetGreeting();

        string GetGreeting2();
    }

    public class Greeter : IGreeter
    {
        private string _greeting;

        public Greeter(IConfiguration configuration)
        {
            _greeting = configuration["greeting"];
        }
        public string GetGreeting()
        {
            return "     3) Hello from the greeter!";
        }

        public string GetGreeting2()
        {
            return _greeting;
        }
    }
}
