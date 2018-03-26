import java.util.*;
import java.io.*;

public class EvaluatePostfix {
    public static float EvaluatePostfixExpression (String postfixExpr)
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

    public static void main(String[] args) {

        // this gives you a 2-dimensional array of strings
        List<List<String>> lines = new ArrayList<>();
        BufferedReader br = null;

        try{
            br = new BufferedReader(new FileReader(args[0]));
            String line = "";

            while ((line = br.readLine()) != null) {
                System.out.println("line: " + line);
                String[] values = line.trim().split(",");                

                // this adds the currently parsed line to the 2-dimensional string array
                lines.add(Arrays.asList(values));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        // the following code lets you iterate through the 2-dimensional array
        int lineNo = 1;
        for(List<String> line: lines) {
            int columnNo = 1;
            for (String value: line) {
                float postFixResult = EvaluatePostfixExpression(value);
                System.out.println("csv [" + lineNo + "][" + columnNo + "]: " + value + " = " + postFixResult);
                columnNo++;
            }
            lineNo++;
        }
    }

} 