using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace DemoUnitTesting
{
    public class StockMarketProjection
    {

        public StockMarketProjection() { }

        public decimal CalculateShortTerm()
        {
            // simulated calculation
            return 200;
        }

        public decimal CalculateLongTerm()
        {
            Thread.Sleep(5000);

            return 50;
        }


    }
}
