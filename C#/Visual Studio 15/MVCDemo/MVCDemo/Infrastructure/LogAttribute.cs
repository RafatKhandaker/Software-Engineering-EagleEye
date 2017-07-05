
using System;
using System.Diagnostics;
using System.Web.Mvc;
using System.Web.Routing;

namespace MVCDemo.Infrastructure
{
    public class LogAttribute : ActionFilterAttribute
    {
        // override for all the virtual methods that are invoked during certain points in Run Time, before, after, in between.
        // This class will log detail during different execution times in the HelloController class. 

        public override void OnActionExecuting(ActionExecutingContext filterContext)                          // before controller action executed
        {
            Log("Action Executing", filterContext.RouteData);
        }

        public override void OnActionExecuted(ActionExecutedContext filterContext)                            // after controller action executed 
        {
            Log("Action Executed", filterContext.RouteData);
        }

        public override void OnResultExecuting(ResultExecutingContext filterContext)                          
        {
            Log("On Result Executing", filterContext.RouteData);
        }

        public override void OnResultExecuted(ResultExecutedContext filterContext)
        {
            Log("On Result Executed", filterContext.RouteData);
        }


        private void Log(string stageName, RouteData routeData)
        {
            Debug.WriteLine(
                String.Format("{0}::{1} - {2}",
                routeData.Values["controller"],
                routeData.Values["action"],
                stageName)
                );
        }

    }
}