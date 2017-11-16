import greenfoot.*;


public class Duck extends SmoothMover
{
    // (A) Create four total fields
    
    //  1 - A score variable starting at 0, all ducks share this
    private static int score = 0;
    //  2 - A lives left variable starting at 10, all ducks share this
    private static int lives = 10;
    //  3 - A velocity variable starting at 0.0
    private double velo = 0.0;
    //  4 - A variable to represent which keyboard key the duck uses
    //      Set this variable to a random String from "A" to "Z"
    private String myKey = (char)( Math.random() * 26 + 'A' ) + "";  
    //(B) Uncomment these two lines once you have built the above fields
    //    Change the myKey variable use here to whatever you named yours
    
    private boolean plusMinus = false;
    public Duck()
    {
        getImage().setFont(new Font("VERDANA", true, false, 20));
        getImage().drawString(myKey, 50, 80 );
    }
    
    public void act() 
    {
        // Display the number of lives left at (250, 50)
        getWorld().showText( "Lives: " + lives, 250, 50 );
        // Display the current score at (750, 50)
        getWorld().showText( "Score: " + score, 750, 50 );  
        // Teleport slightly down the screen - use your velocity variable     
        setLocation( getX(), getY() + velo );
        // Increase your velocity a tiny amount (0.1)
        velo = velo + 0.1;
        
        // Check if you are hitting a Gator
        //  -> If so, remove one from the lives variable
        //  -> Play the quack.mp3 sound
        //  -> Remove yourself
        // Otherwise ask if the correct key is being pressed
        //  -> If so, increase the score
        //  -> Remove yourself
        if( isTouching( Gator.class ) )
        {
            plusMinus = true;
            lives --;
            if( lives == 0 )
            {
                Greenfoot.stop();
            }
            Greenfoot.playSound( "quack.mp3" );
            getWorld().showText( "Lives: " + lives, 250, 50 );
            getWorld().removeObject( this );
        }
        else if( Greenfoot.isKeyDown( myKey ) )
        {
            score ++;
            getWorld().showText( "Score: " + score, 750, 50 );
            getWorld().removeObject( this );
        }
    }    
}
