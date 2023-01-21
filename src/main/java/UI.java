import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
        taOutput.setEditable(false);
        taOutput.setText("Starting Stable-Diffusion" + "\n");
        bStop.addActionListener(e -> {
            System.out.println("Stopping Stable-Diffusion");
            Methods.executeCommand("taskkill /F /IM python.exe");
            System.exit(0);
        });
        bOpenUI.addActionListener(e -> Methods.openWebpage("http://127.0.0.1:7860/"));
        startStableDiffusion();
    }
    public void startStableDiffusion() {
        try {
            Process process = Runtime.getRuntime().exec("start.bat");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                taOutput.append(line + "\n");
                if (line.equals("Running on local URL:  http://127.0.0.1:7860")) Methods.openWebpage("http://127.0.0.1:7860/");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
