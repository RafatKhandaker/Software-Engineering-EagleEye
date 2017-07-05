
using MVCDemo.Infrastructure;
using System.Web.Mvc;
using System.Web.Routing;

namespace MVCDemo.Controllers
{

    [Log]            // able place filter and apply to LogAttribute
    public class HelloController : Controller
    {
        public void Execute(RequestContext requestContext)
        {
            requestContext.HttpContext.Response.Write("Hello, World");
        }

        [ActionName("SayHello")]                         // Action filter implementation
        public ActionResult Hello(int? id)                   // id in here is nullable with "?"
        {
            return View("SayHello");
        }

        public ContentResult SayHelloContext(int id)  // in here The id value for int cannot be null from the RouteConfig or else we recieve a null pointer
        {
            return Content("Hello From Content " + id.ToString());
        }
    }
}