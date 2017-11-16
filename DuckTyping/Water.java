import greenfoot.*;

public class Water extends World
{
    // Create one field called duckPercent
    // It will be a variable to represent the small chance of a duck
    // being built - set it to 0.005
    private double duckPercent = 0.05;
    public Water()
    {    
        super(1000, 800, 1); 
        
        // Add a bunch of Gators at the bottom of the screen
        Gator abigal = new Gator();
        addObject( abigal, 114, 707 );
        Gator isabella = new Gator();
        addObject( isabella, 309, 684 );
        Gator francis = new Gator();
        addObject( francis, 505, 693 );
        Gator miranda = new Gator();
        addObject( miranda, 703, 672 );
        Gator steven = new Gator();
        addObject( steven, 906, 708 );
    }

    public void act()
    {
        // Check if a random number is less than the duckPercent
        //  -> If so, build a new duck
        //  -> Place the duck at a random x coordinate from 50-950
        //  -> and a y coordinate of 50.  ( [50-950], 50).
        //  -> Also, increase the duckPercent by a small amount (0.0005)
        
        if( Math.random() < duckPercent )
        {
            Duck robert = new Duck();
            addObject( robert, (int)( Math.random() * 900 ) + 50, 50 );
            duckPercent =+ 0.005;
        }
    }
}
