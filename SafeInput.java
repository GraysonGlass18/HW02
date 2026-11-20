
import java.util.Scanner;

public class SafeInput
{
    public static String getNonZeroLenString(Scanner pipe, String prompt)
    {
        String retString = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        }
        while(retString.length() == 0);

        return retString;
    }

    public static int getInt(Scanner pipe, String prompt)
    {
        int retVal = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextInt())
            {
                retVal = pipe.nextInt();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("Invalid input! Please enter an integer.");
                pipe.nextLine();
            }

        } while(!done);

        return retVal;
    }

    public static double getDouble(Scanner pipe, String prompt)
    {
        double retVal = 0;
        boolean done = false;

        do
        {
            System.out.print("\n" + prompt + ": ");

            if(pipe.hasNextDouble())
            {
                retVal = pipe.nextDouble();
                pipe.nextLine();
                done = true;
            }
            else
            {
                System.out.println("Invalid input! Please enter a number.");
                pipe.nextLine();
            }

        } while(!done);

        return retVal;
    }

    public static int getRangedInt(Scanner pipe, String prompt, int low, int high)
    {
        int retVal = 0;
        boolean done = false;

        do
        {
            retVal = getInt(pipe, prompt + " [" + low + " - " + high + "]");

            if(retVal >= low && retVal <= high)
            {
                done = true;
            }
            else
            {
                System.out.println("Please enter a number between " + low + " and " + high);
            }

        } while(!done);

        return retVal;
    }

    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high)
    {
        double retVal = 0;
        boolean done = false;

        do
        {
            retVal = getDouble(pipe, prompt + " [" + low + " - " + high + "]");

            if(retVal >= low && retVal <= high)
            {
                done = true;
            }
            else
            {
                System.out.println("Please enter a number between " + low + " and " + high);
            }

        } while(!done);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt)
    {
        String response = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();

            if(response.equalsIgnoreCase("Y") || response.equalsIgnoreCase("YES"))
            {
                return true;
            }
            else if(response.equalsIgnoreCase("N") || response.equalsIgnoreCase("NO"))
            {
                return false;
            }
            else
            {
                System.out.println("Please enter Y or N.");
            }

        } while(true);
    }

    public static String getRegExString(Scanner pipe, String prompt, String regEx)
    {
        String response = "";

        do
        {
            System.out.print("\n" + prompt + ": ");
            response = pipe.nextLine();

            if(!response.matches(regEx))
            {
                System.out.println("Invalid format. Please try again.");
            }

        } while(!response.matches(regEx));

        return response;
    }
}
