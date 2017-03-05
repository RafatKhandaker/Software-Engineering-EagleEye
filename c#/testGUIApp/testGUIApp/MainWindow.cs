using System;
using Gtk;

public partial class MainWindow : Gtk.Window
{
	public MainWindow() : base(Gtk.WindowType.Toplevel)
	{
		Build();
	}

	protected void OnDeleteEvent(object sender, DeleteEventArgs a)
	{
		Application.Quit();
		a.RetVal = true;
	}

	protected void OnAddClicked(object sender, EventArgs e)
	{
		var textOne = entry1.Text;
		var textTwo = entry2.Text;

		//------------------ check if the inputs are integers-------------------------------
		double textOneResult;
		double textTwoResult;

		if (!double.TryParse(textOne, out textOneResult))
		{
			// import from packages folder
			System.Windows.Forms.MessageBox.Show($"'{textOne}' is not an integer");
			return;
		}

		if (!double.TryParse(textTwo, out textTwoResult))
		{
			System.Windows.Forms.MessageBox.Show($"'{textTwo}' is not an integer");
			return;
		}
		//-------------------------Show Result-------------------------------------------

		double sum = textOneResult + textTwoResult; 
		System.Windows.Forms.MessageBox.Show(Convert.ToString(sum));

		return;
	}

	protected void OnSubtractClicked(object sender, EventArgs e)
	{
		var subTxtOne = sub_ent_one.Text;
		var subTxtTwo = sub_ent_two.Text;

		double textOneResult;
		double textTwoResult;

		if (!double.TryParse(subTxtOne, out textOneResult))
		{
			// import from packages folder
			System.Windows.Forms.MessageBox.Show($"'{subTxtOne}' is not an integer");
			return;
		}

		if (!double.TryParse(subTxtTwo, out textTwoResult))
		{
			System.Windows.Forms.MessageBox.Show($"'{subTxtTwo}' is not an integer");
			return;
		}
		//-------------------------Show Result-------------------------------------------

		double sum = textOneResult - textTwoResult;
		System.Windows.Forms.MessageBox.Show(Convert.ToString(sum));

		return;
	}

	protected void OnMultiplyClicked(object sender, EventArgs e)
	{
		var multTxtOne = mult_ent_one.Text;
		var multTxtTwo = mult_ent_two.Text;

		double textOneResult;
		double textTwoResult;

		if (!double.TryParse(multTxtOne, out textOneResult))
		{
			// import from packages folder
			System.Windows.Forms.MessageBox.Show($"'{multTxtOne}' is not an integer");
			return;
		}

		if (!double.TryParse(multTxtTwo, out textTwoResult))
		{
			System.Windows.Forms.MessageBox.Show($"'{multTxtTwo}' is not an integer");
			return;
		}
		//-------------------------Show Result-------------------------------------------

		double sum = textOneResult * textTwoResult;
		System.Windows.Forms.MessageBox.Show(Convert.ToString(sum));

		return;
	}

	protected void OnDivideClicked(object sender, EventArgs e)
	{
		var divTxtOne = div_ent_one.Text;
		var divTxtTwo = div_ent_two.Text;

		double textOneResult;
		double textTwoResult;

		if (!double.TryParse(divTxtOne, out textOneResult))
		{
			// import from packages folder
			System.Windows.Forms.MessageBox.Show($"'{divTxtOne}' is not an integer");
			return;
		}

		if (!double.TryParse(divTxtTwo, out textTwoResult))
		{
			System.Windows.Forms.MessageBox.Show($"'{divTxtTwo}' is not an integer");
			return;
		}
		//-------------------------Show Result-------------------------------------------

		double sum = textOneResult - textTwoResult;
		System.Windows.Forms.MessageBox.Show(Convert.ToString(sum));

		return;
	}
}
