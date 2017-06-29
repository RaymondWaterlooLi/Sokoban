import java.lang.reflect.Array;
import java.util.*;
public class level {
	private static ArrayList<String> levelList= new ArrayList<String>();//the level list contains each level
	//private static ArrayList <String>
    static int[] times= {350,11,100,130,30,60,150,100,60};//the steps list that contains the limitions of each level
	
    /*
	 * Description: This method is used to get the limit steps of each level
	 * Parameters: int a : the level number
	 * Return: the steps limit of that level
	 */
	public static int getTime(int a){
		return times[a-1];
	}
	
	
	
	
	private static String level1=  //level 1
			  "    ######\n"
			+ "    ##   #\n"
			+ "    ##$  #\n"
			+ "  ####  $##\n"
			+ "  ##  $ $ #\n"
			+ "#### # ## #   ######\n"
			+ "##   # ## #####  ..#\n"
			+ "## $  $          ..#\n"
			+ "###### ### #a##  ..#\n"
			+ "    ##     #########\n"
			+ "    ########\n";
	

    private static String level2 =// level2
                     "###\n"
                    +"  #.#\n"
                    +"  # ####\n"
                    +"###$ $.#\n"
                    +"#. $a###\n"
                    +"####$#\n"
                    +"   #.#\n"
                    +"   ###\n"
                    ;
   
    private static String level3 =//level3
                    "#####\n"
                    +"  #a  #\n"
                    +"  # $$# ###\n"
                    +"  # $ # #.#\n"
                    +"  ### ## .#\n"
                    +"  ##     .#\n"
                    +"  #   #   #\n"
                    +"  #   #####\n"
                    +"  #####\n"
                    ;
   
    private static String level4 =//level4
                     "########\n"
                    +"  #      ###\n"
                    +"  ##$###   #\n"
                    +"  # a $  $ #\n"
                    +"  # ..# $ ##\n"
                    +"  ##..#   #\n"
                    +"  ########\n"
                    ;
   
    private static String level5 =
    		  "######\n"
                      +"  #  #.#\n"
                      +"  #a$ .#\n"
                      +"  ##$  #\n"
                      +"  ## $$#\n"
                      +"  #.$  #\n"
                      +"  #.  .#\n"
                      +"  ######\n"
                      ;
   
    private static String level6 =
                     " #####\n"
                    +"   #  ###\n"
                    +"   #a$  #\n"
                    +"  ### # ##\n"
                    +"  #.# #  #\n"
                    +"  #.$  # #\n"
                    +"  #.   $ #\n"
                    +"  ########\n"                                    
                    ;
   
    private static String level7 =
                     "   #######\n"
                    +"  ####     #\n"
                    +"  #   .### #\n"
                    +"  # # #    ##\n"
                    +"  # # $ $#. #\n"
                    +"  # #     # #\n"
                    +"  # .#$ $ # #\n"
                    +"  ##    # # ###\n"
                    +"   # ###.    a#\n"
                    +"   #     ##   #\n"
                    +"   ############\n"
                                     ;
   
    private static String level8 =
                     "   #######\n"
                    +"    ##  # a#\n"
                    +"    #   #  #\n"
                    +"    #$ $ $ #\n"
                    +"    # $##  #\n"
                    +"  ### $ # ##\n"
                    +"  #.....  #\n"
                    +"  #########\n"
                                     ;
   
    private static String level9 =
                     "   ######\n"
                    +"   ###    #\n"
                    +"  ##. $## ##\n"
                    +"  #..$ $  a#\n"
                    +"  #.. $ $ ##\n"
                    +"  ######  #\n"
                    +"       ####\n"
                    ;
	
    /*
	 * Description: This method is used to add all the levels to the list
	 * Parameters: nothing
	 * Return: nothing
	 */
	public static void addLevel(){
		levelList.add(level1);
		levelList.add(level2);
		levelList.add(level3);
		levelList.add(level4);
		levelList.add(level5);
		levelList.add(level6);
		levelList.add(level7);
		levelList.add(level8);
		levelList.add(level9);
	}
	
	/*
	 * Description: This method is used to add all the levels to the list
	 * Parameters: int a: the level number
	 * Return: the map of that level
	 */
	public static String getLevel(int a){
		return levelList.get(a-1);
	}
	


}
