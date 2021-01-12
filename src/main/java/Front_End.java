import javax.swing.*;
import java.awt.*;

public class Front_End {
    private JPanel panel1;
    private JTextField nameTextField;
    private JTextField classTextField;
    private JTextField rollTextField;
    private JButton submit;

    Front_End() {
        JFrame window = new JFrame("Class Database");
        window.add(panel1);
        window.setSize(475, 215);
        window.setResizable(false);
        window.setVisible(true);

        submit.addActionListener(e -> {
//              System.out.println(window.getWidth() + "," + window.getHeight());
            new Back_End(getData());
            clearFields();
        });

    }

    private void clearFields() {
        nameTextField.setText("");
        classTextField.setText("");
        rollTextField.setText("");
        new Thread(() -> {
            var t = submit.getText();
            var c = submit.getBackground();
            submit.setBackground(Color.GREEN);
            submit.setText("Added to Database");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.err.println(e.getMessage());
            }
            submit.setBackground(c);
            submit.setText(t);
        }).start();
    }

    public String[] getData() {
        String name = nameTextField.getText();
        String classname = classTextField.getText();
        String roll = rollTextField.getText();
        return new String[]{name, classname, roll};
    }

//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                new Front_End();
//            }
//        });
//    }
}
