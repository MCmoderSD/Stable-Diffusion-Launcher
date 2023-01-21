import java.io.*;

public class Main {
    public Main() {
        final String[] models = {"big", "small"};
        if (!Methods.isInstalled()) {
            System.out.println("Stable-Diffusion is not installed");
            Installer.installStableDiffusion();
        } else {
            System.out.println("Stable-Diffusion is installed");
        }
        for (int i = 0; i < models.length; i++) {
            if (!Methods.hasModel(models[i])) {
                System.out.println(models[i] + " is not installed");
                Installer.installModel(models[i]);
            } else {
                System.out.println(models[i] + " is installed");
            }
        }
        if (!Methods.hasStartBatch()) {
            System.out.println("start.bat is not installed");
            Installer.installStartBatch();
        } else {
            System.out.println("start.bat is installed");
            new UI();
        }

    }
    public static void main(String[] args) {
        new Main();
    }
}
