public class Main {
    public static void run() {
        final String[] models = {"big", "small"};
        if (!Methods.isInstalled()) {
            System.out.println("Stable-Diffusion is not installed");
            Installer.installStableDiffusion();
        } else {
            System.out.println("Stable-Diffusion is installed");
        }
        for (String model : models) {
            if (!Methods.hasModel(model)) {
                System.out.println(model + " is not installed");
                Installer.installModel(model);
            } else {
                System.out.println(model + " is installed");
            }
        }
        if (!Methods.hasStartBatch()) {
            System.out.println("start.bat is not installed");
            Installer.installStartBatch();
        } else {
            System.out.println("start.bat is installed");
            Methods.startStableDiffusion();
        }
    }

    public static void main(String[] args) {
        new UI();
    }
}
