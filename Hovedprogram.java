import java.awt.event.*;

public class Hovedprogram
{
	public static void main( String[] args )
	{
		final Hovedvindu hv = new Hovedvindu();

		hv.addWindowListener(
			new WindowAdapter()
			{
				public void windowClosing( WindowEvent e )
				{
					//hv.skrivTilFil();
					System.exit( 0 );
				}
			} );
	}
}
