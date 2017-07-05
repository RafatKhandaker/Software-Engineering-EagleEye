using System.Collections.Generic;

namespace DemoCore.Models
{
	public interface IRepository
	{
		IEnumerable<City> Cities { get; }

		void AddCity(City newCity);
	}
}