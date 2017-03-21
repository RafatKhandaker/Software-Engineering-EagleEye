using System;
using Gtk;
using Forms = System.Windows.Forms;

namespace testGUIApp
{
	class MainClass
	{
		public static void Main(string[] args)
		{
			Application.Init();

			Forms.MessageBox.Show("Hello, Press OK to Start Application");
			MainWindow win = new MainWindow();
			win.Show();
			Application.Run();
		}
	}
}
