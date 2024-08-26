/*
Ryan Bolt
05/01/2024
Comp-167
This program is a Java GUI calculator that utilizes the Swing library and JavaFX library. THis calculator comes
with basic math functions, trigonometric functions, and Data functions. This calculator has an exit button as well to
help close the function whenever the user is finished using it.
To help the user have ease of function, there are two text boxes, one for input and one for output.
 */




//Imports Swing libraries and button event functions/libraries
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.ButtonGroup;

public class Calculating {

    private JFrame frame;
    private JTextField inputTextField;
    private JTextField outTextField;

    double first;
    double second;
    double result;
    String operation;
    String answer;
    private final ButtonGroup buttonGroup = new ButtonGroup();

    //Public void method that creates the launch of the application and evokes it
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {                                       //Try/Catch block that reads for Calculatiing class
                    // and if true, will make calculator visible to user
                    Calculating window = new Calculating();
                    window.frame.setVisible(true);


                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }


    //This public method initializes Calculating class

    public Calculating() {
        initialize();
    }

    //Lines 64- 84 initialize the parameters of the frame like background color,length, text font, and text color

    private void initialize() {
        frame = new JFrame();
        frame.setForeground(Color.WHITE);
        frame.getContentPane().setForeground(Color.BLACK);
        frame.setBounds(100, 100, 357, 660);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        //Input text box
        inputTextField = new JTextField();
        inputTextField.setFont(new Font("Tahoma", Font.BOLD, 15));
        inputTextField.setBounds(10, 29, 320, 43);
        frame.getContentPane().add(inputTextField);
        inputTextField.setColumns(10);

        //Output text box
        outTextField = new JTextField();
        outTextField.setFont(new Font("Tahoma", Font.BOLD, 15));
        outTextField.setBounds(10, 75, 320, 53);
        frame.getContentPane().add(outTextField);
        outTextField.setColumns(10);



        //Starting here at line 90, is the individual buttons for the calculator like, numberpad and function keys

        JButton btn2 = new JButton("2");
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn2.getText();
                inputTextField.setText(number);
            }
        });
        btn2.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn2.setBounds(139, 448, 64, 50);
        frame.getContentPane().add(btn2);

        JButton btn5 = new JButton("5");
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn5.getText();
                inputTextField.setText(number);
            }
        });
        btn5.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn5.setBounds(139, 397, 64, 50);
        frame.getContentPane().add(btn5);

        JButton btn8 = new JButton("8");
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn8.getText();
                inputTextField.setText(number);
            }
        });
        btn8.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn8.setBounds(139, 345, 64, 50);
        frame.getContentPane().add(btn8);

        JButton btnC = new JButton("C");
        btnC.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnC.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                inputTextField.setText(null);
            }
        });
        btnC.setBounds(74, 139, 64, 50);
        frame.getContentPane().add(btnC);

        JButton btnSinh = new JButton("sinh");
        btnSinh.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.sinh(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnSinh.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSinh.setBounds(139, 191, 64, 50);
        frame.getContentPane().add(btnSinh);

        JButton btn0 = new JButton("0");
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn0.getText();
                inputTextField.setText(number);
            }
        });
        btn0.setFont(new Font("Tahoma", Font.BOLD, 21));
        btn0.setBounds(74, 499, 129, 50);
        frame.getContentPane().add(btn0);

        JButton btnSin = new JButton("sin");
        btnSin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.sin(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnSin.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnSin.setBounds(139, 139, 64, 50);
        frame.getContentPane().add(btnSin);

        JButton btnSina = new JButton("sin(a)");
        btnSina.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.asin(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);
            }
        });
        btnSina.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnSina.setBounds(74, 295, 64, 50);
        frame.getContentPane().add(btnSina);

        JButton btnDot = new JButton(".");
        btnDot.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btnDot.getText();
                inputTextField.setText(number);
            }
        });
        btnDot.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnDot.setBounds(202, 499, 64, 50);
        frame.getContentPane().add(btnDot);


        /*The equal sign button is written as follows:
        IF the equal(=) sign is pressed, the statements are executed on the basis that one of the
        basic PEMDAS functions are pressed and executes the desired function and returned as type double values
        */
        JButton btnEqual = new JButton("=");
        btnEqual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String answer;
                second = Double.parseDouble(inputTextField.getText());
                if (operation == "+") {
                    result = first + second;
                    answer = String.format("%.2f", result);
                    outTextField.setText(answer);
                } else if (operation == "-") {
                    result = first - second;
                    answer = String.format("%.2f", result);
                    outTextField.setText(answer);
                } else if (operation == "*") {
                    result = first * second;
                    answer = String.format("%.2f", result);
                    outTextField.setText(answer);
                } else if (operation == "/") {
                    result = first / second;
                    answer = String.format("%.2f", result);
                    outTextField.setText(answer);
                } else if (operation == "%") {
                    result = first % second;
                    answer = String.format("%.2f", result);
                    outTextField.setText(answer);
                } else if (operation == "X^Y") {
                    double result2 = 1;
                    for (int i = 0; i < second; i++) {
                        result2 = first * result2;
                        answer = String.format("%.2f", result2);
                        outTextField.setText(answer);
                    }
                }

            }
        });
        btnEqual.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnEqual.setBounds(266, 449, 64, 50);
        frame.getContentPane().add(btnEqual);

        JButton btnXrx = new JButton("X^Y");
        btnXrx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first = Double.parseDouble(inputTextField.getText());
                inputTextField.setText("");
                operation = "xrx";


            }
        });
        btnXrx.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnXrx.setBounds(10, 243, 64, 50);
        frame.getContentPane().add(btnXrx);

        JButton btnLog = new JButton("log");
        btnLog.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.log(Double.parseDouble(inputTextField.getText()));

                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnLog.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnLog.setBounds(74, 192, 64, 50);
        frame.getContentPane().add(btnLog);

        //Clear text field button and related functions. Clears BOTH input and output text boxes
        JButton btnCe = new JButton("CE");
        btnCe.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                inputTextField.setText(null);
                outTextField.setText(null);
            }
        });
        btnCe.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnCe.setBounds(10, 139, 64, 50);
        frame.getContentPane().add(btnCe);

        JButton btn7 = new JButton("7");
        btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn7.getText();
                inputTextField.setText(number);
            }
        });
        btn7.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn7.setBounds(74, 345, 64, 50);
        frame.getContentPane().add(btn7);

        JButton btn4 = new JButton("4");
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn4.getText();
                inputTextField.setText(number);
            }
        });
        btn4.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn4.setBounds(74, 397, 64, 50);
        frame.getContentPane().add(btn4);

        JButton btn1 = new JButton("1");
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn1.getText();
                inputTextField.setText(number);
            }
        });
        btn1.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn1.setBounds(74, 448, 64, 50);
        frame.getContentPane().add(btn1);

        JButton btnX = new JButton("x3");
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = (Double.parseDouble(inputTextField.getText()));
                a = a * a * a;
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnX.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnX.setBounds(10, 295, 64, 50);
        frame.getContentPane().add(btnX);

        JButton btnEx = new JButton("Mod");
        btnEx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first = Double.parseDouble(inputTextField.getText());
                inputTextField.setText("");
                operation = "%";

            }
        });
        btnEx.setFont(new Font("Tahoma", Font.PLAIN, 12));
        btnEx.setBounds(139, 243, 64, 50);
        frame.getContentPane().add(btnEx);

        JButton btnx = new JButton("1/x");
        btnx.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = 1 / Math.sqrt(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnx.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnx.setBounds(9, 191, 64, 50);
        frame.getContentPane().add(btnx);

        JButton btnSqrt = new JButton("\u221A");
        btnSqrt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.sqrt(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);


            }
        });
        btnSqrt.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnSqrt.setBounds(74, 243, 64, 50);
        frame.getContentPane().add(btnSqrt);

        JButton btnCos = new JButton("cos");
        btnCos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.cos(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnCos.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnCos.setBounds(202, 139, 64, 50);
        frame.getContentPane().add(btnCos);

        JButton btnCos_1 = new JButton("cosh");
        btnCos_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.cosh(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnCos_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnCos_1.setBounds(202, 191, 64, 50);
        frame.getContentPane().add(btnCos_1);

        JButton btnCosa = new JButton("cos(a)");
        btnCosa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.acos(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);
            }
        });
        btnCosa.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnCosa.setBounds(139, 295, 64, 50);
        frame.getContentPane().add(btnCosa);

        JButton btnLn = new JButton("ln");
        btnLn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                {
                    double a = (Double.parseDouble(inputTextField.getText()));
                    a = (-Math.log(1 - a)) / a;
                    inputTextField.setText("");
                    outTextField.setText(outTextField.getText() + a);
                }
            }
        });
        btnLn.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnLn.setBounds(202, 243, 64, 50);
        frame.getContentPane().add(btnLn);

        JButton btn9 = new JButton("9");
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn9.getText();
                inputTextField.setText(number);
            }
        });
        btn9.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn9.setBounds(202, 345, 64, 50);
        frame.getContentPane().add(btn9);

        JButton btn6 = new JButton("6");
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn6.getText();
                inputTextField.setText(number);
            }
        });
        btn6.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn6.setBounds(202, 397, 64, 50);
        frame.getContentPane().add(btn6);

        JButton btn3 = new JButton("3");
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                String number = inputTextField.getText() + btn3.getText();
                inputTextField.setText(number);
            }
        });
        btn3.setFont(new Font("Tahoma", Font.BOLD, 23));
        btn3.setBounds(202, 448, 64, 50);
        frame.getContentPane().add(btn3);

        JButton btnTan = new JButton("tan");
        btnTan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.tan(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnTan.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnTan.setBounds(266, 139, 64, 50);
        frame.getContentPane().add(btnTan);

        JButton btnTan_1 = new JButton("tanh");
        btnTan_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.tanh(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);

            }
        });
        btnTan_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnTan_1.setBounds(266, 191, 64, 50);
        frame.getContentPane().add(btnTan_1);

        JButton btnTana = new JButton("tan(a)");
        btnTana.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Math.atan(Double.parseDouble(inputTextField.getText()));
                inputTextField.setText("");
                outTextField.setText(outTextField.getText() + a);
            }
        });
        btnTana.setFont(new Font("Tahoma", Font.PLAIN, 11));
        btnTana.setBounds(202, 295, 64, 50);
        frame.getContentPane().add(btnTana);

        JButton btnPlus = new JButton("+");
        btnPlus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first = Double.parseDouble(inputTextField.getText());

                inputTextField.setText("");


                operation = "+";
            }
        });
        btnPlus.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnPlus.setBounds(266, 243, 64, 50);
        frame.getContentPane().add(btnPlus);

        JButton btnSub = new JButton("-");
        btnSub.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first = Double.parseDouble(inputTextField.getText());
                inputTextField.setText("");
                operation = "-";
            }
        });
        btnSub.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnSub.setBounds(266, 295, 64, 50);
        frame.getContentPane().add(btnSub);

        JButton btnMul = new JButton("*");
        btnMul.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first = Double.parseDouble(inputTextField.getText());
                inputTextField.setText("");
                operation = "*";
            }
        });
        btnMul.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnMul.setBounds(266, 347, 64, 50);
        frame.getContentPane().add(btnMul);

        JButton btnDivide = new JButton("/");
        btnDivide.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                first = Double.parseDouble(inputTextField.getText());
                inputTextField.setText("");
                operation = "/";
            }
        });
        btnDivide.setFont(new Font("Tahoma", Font.PLAIN, 21));
        btnDivide.setBounds(266, 398, 64, 50);
        frame.getContentPane().add(btnDivide);

        JButton btnP_1 = new JButton("x2");
        btnP_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = (Double.parseDouble(inputTextField.getText()));
                a = a * a;
                inputTextField.setText("");
                inputTextField.setText(inputTextField.getText() + a);

            }
        });
        btnP_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        btnP_1.setBounds(10, 347, 64, 50);
        frame.getContentPane().add(btnP_1);

        JSeparator separator = new JSeparator();
        separator.setBounds(72, 291, 1, 2);
        frame.getContentPane().add(separator);

        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(19, 191, 1, 2);
        frame.getContentPane().add(separator_1);

        JSeparator separator_2 = new JSeparator();
        separator_2.setBounds(10, 191, 320, 2);
        frame.getContentPane().add(separator_2);

        JButton button = new JButton("+/-");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                double a = Double.parseDouble(String.valueOf(inputTextField.getText()));
                a = a * (-1);
                inputTextField.setText(String.valueOf(a));

            }
        });
        button.setFont(new Font("Tahoma", Font.PLAIN, 18));
        button.setBounds(10, 398, 64, 50);
        frame.getContentPane().add(button);

        ///Exit button that closes calculator object with an override for actionPerformed
        // to close with the System.exit function
        JButton btnExit = new JButton("Exit");
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Exits/ends Calculating program
                System.exit(0);
            }
        });
        btnExit.setFont(new Font("Tahoma", Font.BOLD, 23));
        btnExit.setBounds(10, 555, 320, 50);
        frame.getContentPane().add(btnExit);

    }
}
