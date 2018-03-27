import java.util.*;
import java.io.*;

public class EvaluatePostfix {
    public static float evaluatePostfixExpression (String postfixExpr)
    {
        Stack<Float> operands = new Stack<Float>();
        float result = 0;
        String operand = "";
   
   
        for(int i = 0; i<postfixExpr.length();i++)
        {
            
            if(Character.isDigit(postfixExpr.charAt(i)) == true)
            {
                operand = operand + postfixExpr.charAt(i); // Concatenate digits in string
                if (i+1 >= postfixExpr.length())
                {
                    // Handle situation where there are no operators
                    return (Float.parseFloat(operand));
                }
                else if (Character.isDigit(postfixExpr.charAt(i+1)) == false)    {
                    operands.push(Float.parseFloat(operand));
                    operand = "";
                }
            }
            
            if(postfixExpr.charAt(i) == '+')
            {
                float x = operands.pop() + operands.pop();
                result = result + x;
                operands.push(x);
            }
            if(postfixExpr.charAt(i) == '-')
            {
                float op2 = operands.pop();
                float x = operands.pop() - op2;
                result = result + x;
                operands.push(x);
            }
            if(postfixExpr.charAt(i) == '*')
            {
                float x = operands.pop() * operands.pop();
                result = result + x;
                operands.push(x);
            }
            if(postfixExpr.charAt(i) == '/')
            {
                float op2 = operands.pop();
                float x = operands.pop() / op2;
                // System.out.println(result);
                // System.out.println(x);
                result = result + x;
                operands.push(x);
            }
   
        }
   
       return result;
    } 

    public static void writeOutputCells(List<List<String>> cells) {
        PrintWriter pw = null;
        StringBuilder sb = new StringBuilder();
        // the following code lets you iterate through the 2-dimensional array
        int rowNo = 1; /* TODO: Convert to letter */
        for(List<String> line: cells) {
            int columnNo = 1;
            for (String value: line) {
                float postFixResult = evaluatePostfixExpression(value);
                // System.out.println("csv [" + lineNo + "][" + columnNo + "] = " + postFixResult);
                sb.append(postFixResult + ",");
                columnNo++;
            }
            sb.append("\n");
            rowNo++;
        }
        try {
            pw = new PrintWriter(new File("output.csv"));
            pw.print(sb.toString());
            pw.close();
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* In the main function, read the CSV file */
    public static void main(String[] args) {

        // this gives you a 2-dimensional array of strings
        List<List<String>> cells = new ArrayList<>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(args[0]));
            String line = "";

            while ((line = br.readLine()) != null) {
                // System.out.println("line: " + line);
                String[] values = line.trim().split(",");                

                // this adds the currently parsed line to the 2-dimensional string array
                cells.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                    writeOutputCells(cells);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

} 