using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Data.Entity;

namespace MVCViewsDemo.Models
{
    public class MovieContext : DbContext
    {
        // GET: MovieContext
        public MovieContext() { }

        public DbSet<> getID { get; set; }
    }

}
