using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace DemoTestApplication
{
    public class MemoryCalculator
    {
        public MemoryCalculator(){ }

        public double add(double x, double y)
        {
            return x + y;
        }

        public double subtract(double x, double y)
        {
            return x - y;
        }
    }
}