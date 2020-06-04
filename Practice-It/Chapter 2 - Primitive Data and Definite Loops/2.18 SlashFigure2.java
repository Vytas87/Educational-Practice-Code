/**********************************************************************************************
Modify the SlashFigure program from the previous exercise to produce a new program SlashFigure2
that uses a global constant for the figure's height. The previous output used a constant height
of 6. Here is the outputs for a constant height of 4 and 7 respectively:

                        size 4                 	   size 7
                    !!!!!!!!!!!!!!      !!!!!!!!!!!!!!!!!!!!!!!!!! 
                    \\!!!!!!!!!!//      \\\\!!!!!!!!!!!!!!!!!!////
                    \\\\!!!!!!////      \\\\!!!!!!!!!!!!!!!!!!////
                    \\\\\\!!//////      \\\\\\!!!!!!!!!!!!!!//////
                                        \\\\\\\\!!!!!!!!!!////////
                                        \\\\\\\\\\!!!!!!//////////
                                        \\\\\\\\\\\\!!////////////

(You must solve this problem using only ONE public static final constant, not multiple constants;
and its value must be used in the way described in this problem.)
***********************************************************************************************/

public class SlashFigure2 {
    
    public static final int HEIGHT = 7;
    
    public static void main(String[] args) {
        for (int i = 1; i <= HEIGHT; i++) {
            for (int j = 1; j <= 2 * (i - 1) ; j++) {
                System.out.print("\\");
            }
            for (int j = 1; j <= 4 * (HEIGHT - i) + 2; j++) {
                System.out.print("!");
            }
            for (int j = 1; j <= 2 * (i - 1) ; j++) {
                System.out.print("/");
            }
            System.out.println();
        }
    }
}
