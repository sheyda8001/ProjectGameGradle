package graphic.entrancePages.components.error;

import javax.swing.*;
import java.awt.*;

public class ErrorFrame extends JFrame {
    public ErrorFrame(Error job) {
        super(job.toString() + " ERROR");
        setSize(new Dimension(400, 200));
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        job.setErrors();
        setContentPane(makeRegisterError(job));
        invalidate();
        validate();
        setVisible(true);
    }

    private JPanel makeRegisterError(Error error) {

        JPanel panel = new JPanel();
        panel.setSize(400, 200);
        JLabel lable = new JLabel(error.getError(error));
        System.out.print(error.getError(error));
        lable.setFont(new Font("Arial", Font.PLAIN, 20));
        lable.setLocation((400 - lable.getWidth()) / 2, (200 - lable.getHeight()) / 2);
        panel.add(lable);
        return panel;
    }

}

