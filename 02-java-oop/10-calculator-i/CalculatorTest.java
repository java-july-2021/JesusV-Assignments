public class CalculatorTest {
    public static void main(String[] args){
            Calculator example = new Calculator();
            //assignment way
            example.setOperandOne(10.5);
            example.setOperandTwo(5.2);
            example.setOperation('+');
            example.performOperation();
            example.getResult();


            //For fun needs some validation and scanner class for prompts
            example.createNum(5, "+");
            example.createNum(5, "+");
            example.createNum(100,"+");
            System.out.println(example.addSub());

    }
}