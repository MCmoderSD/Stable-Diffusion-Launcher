import java.awt.*;
import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class Methods {
    public static void openWebpage(String urlString) {
        try {
            Desktop.getDesktop().browse(new URL(urlString).toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void executeCommand(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Command executed: " + command);
    }
    public static boolean isInstalled() {
        File file = new File("stable-diffusion-webui/exists");
        return file.exists();
    }
    public static boolean hasModel(String model) {
        File file = new File("stable-diffusion-webui/models/Stable-diffusion/" + model + ".ckpt");
        return file.exists();
    }
    public static void downloadFile(String fileURL, String filePath) {
        try {
            URL url = new URL(fileURL);
            ReadableByteChannel rbc = Channels.newChannel(url.openStream());
            FileOutputStream fos = new FileOutputStream(filePath);
            fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
            fos.close();
            rbc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static boolean hasStartBatch(){
        File file = new File("start.bat");
        return file.exists();
    }
    public static void startStableDiffusion() {
        System.out.println("Starting Stable-Diffusion");
        try {
            Process process = Runtime.getRuntime().exec("start.bat");
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
//                if (line.equals("Running on local URL:  http://127.0.0.1:7860")) Methods.openWebpage("http://127.0.0.1:7860/");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}