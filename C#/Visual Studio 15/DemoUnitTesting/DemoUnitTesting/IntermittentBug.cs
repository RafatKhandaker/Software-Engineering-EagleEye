using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DemoUnitTesting
{
    public class IntermittentBug
    {
        public void DoWork()
        {
            // simulated intermittent bug
            if (DateTime.Now.Ticks % 2 == 0)
            {
                throw new ApplicationException("Simulated Bug");
            }
        }
    }
}
