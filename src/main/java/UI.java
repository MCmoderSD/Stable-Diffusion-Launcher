import javax.swing.*;
import java.io.PrintStream;

public class UI extends JFrame {
    private JPanel mainPanel;
    private JButton bStop;
    private JTextArea taOutput;
    private JButton bOpenUI;

    public UI() {
        super("Stable-Diffusion-Launcher");
        setContentPane(mainPanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
        setSize(1280, 720);
        taOutput.setCaretPosition(taOutput.getDocument().getLength());
        taOutput.setEditable(false);
        bStop.addActionListener(e -> {
            System.out.println("Stopping Stable-Diffusion");
            Methods.executeCommand("taskkill /F /IM python.exe");
            System.exit(0);
        });
//        bOpenUI.setVisible(false);
        bOpenUI.addActionListener(e -> Methods.openWebpage("http://127.0.0.1:7860/"));
        PrintStream printStream = new PrintStream(new CustomOutputStream(taOutput));
        System.setOut(printStream);
        System.setErr(printStream);
        Main.run();
    }

}
