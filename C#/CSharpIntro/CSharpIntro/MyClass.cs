using System;
namespace CSharpIntro
{
	class MainClass
	{
		static void Main(string[] args)
		{
			// Supposed to replace Console.WriteLine("Hello World"); for testing
			System.Diagnostics.Debug.WriteLine("Hello World");

			/** self notes* can compile .cs files into exe with csc /path/example.cs in windows computer **/

			// instantiate class into main

			Rectangle rectangle = new Rectangle();
			rectangle.Acceptdetails();
			rectangle.Display();
		}
	}

		class Rectangle 
		{
			// call variables
			double length;
			double width;
			
			//-------------method-------------
			public void Acceptdetails() 
			{
				length = 4.5;
				width = 3.5;
			}

		public double GetArea() 
		{
			return length * width;
		}

		public void Display()
		{
			System.Diagnostics.Debug.WriteLine("Length: {0}", length);
			System.Diagnostics.Debug.WriteLine("Width: {0}", width);
			System.Diagnostics.Debug.WriteLine("Area: {0}", GetArea());
		}


			
		}
	
}
