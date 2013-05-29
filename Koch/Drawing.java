package Koch;

import javax.swing.*;
import java.awt.*;

public class Drawing extends JComponent{
	
	private static final long serialVersionUID = -3988787500609467817L;

	//override preferred size
	public Dimension getPreferredSize(){
        return new Dimension(1024, 768);
    }
	
	//override paint
	public void paint(Graphics g){
		
		Dimension size = getSize();
		Graphics2D g2 = (Graphics2D) g;
		
		//center snowflake, start edge length 600 pixel, 7 iterations
		g2.fill(new Snowflake(size.width/2, size.height/2, 600, 7));
	}
}
