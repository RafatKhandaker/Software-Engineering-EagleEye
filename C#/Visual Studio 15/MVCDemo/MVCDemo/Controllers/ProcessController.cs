using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCDemo.Controllers
{
    public class ProcessController : Controller
    {
        // GET: Process
        public ViewResult List()
        {
            var processList = from p in Process.GetProcesses() select p;
            ViewData.Model = processList.ToList();

            return View(processList);
        }

        public ActionResult Details(int id)
        {
            var process = (from p in Process.GetProcesses() where p.Id == id select p).Single();
            return View(process);
        }

        public ActionResult Create()
        {
            return View();
        }

    }
}