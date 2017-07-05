using MVCViewsDemo.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace MVCViewsDemo.Controllers
{
    public class MovieController : Controller
    {
        // GET: Movie
        public ActionResult Index()
        {
            var ctx = new MovieContext();
            var movies = ctx.Movies
            return View();
        }
    }
}