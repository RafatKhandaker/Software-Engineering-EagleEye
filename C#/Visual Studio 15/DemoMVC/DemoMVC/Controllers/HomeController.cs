using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

using DemoMVC.Models;

namespace DemoMVC.Controllers
{
    public class HomeController : Controller
    {
        // site/home/index
        public ActionResult Index()
        {
            return View();
        }

        // site/home/about
        public ActionResult About()
        {
            ViewBag.Message = "";

            return View();
        }

        [HttpPost]
        public ActionResult About(String userData)
        {
            ViewBag.Message = userData;

            return View();

        }

        // site/home/contract
        public ActionResult Contact()
        {
            ViewBag.Message = "Your contact page.";

            return View();
        }

        // site /home/list

        public ActionResult List()
        {
            return View(TechItem.GetItems());
        }
    }
}