import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Installer {
    public static void installStableDiffusion() {
        System.out.println("Installing Stable-Diffusion");
        JOptionPane.showMessageDialog(null, "Installing Stable-Diffusion");
        JOptionPane.showMessageDialog(null, "You Need an Nvidia GPU to run Stable-Diffusion");
        JOptionPane.showMessageDialog(null, "You need to install Python 3.10.6");
        Methods.openWebpage("https://www.python.org/downloads/release/python-3106/");
        JOptionPane.showMessageDialog(null, "After it has finished downloading, install python and tik the box where it says 'Add Python 3.10.6 to PATH'");
        JOptionPane.showMessageDialog(null, "This program will now try to install git");
        Methods.executeCommand("winget install --id Git.Git -e --source winget");
        JOptionPane.showMessageDialog(null, "After it has finished downloading, install git and tik the box where it says 'Use Git from the Windows Command Prompt'");
        JOptionPane.showMessageDialog(null, "If everything has been installed correctly, this program will now install Stable-Diffusion");
        Methods.executeCommand("git clone https://github.com/AUTOMATIC1111/stable-diffusion-webui.git");
        File file = new File("stable-diffusion-webui/exists");
        try {
            file.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void installModel(String model) {
        System.out.println("Installing " + model);
        if (model=="big") Methods.downloadFile("https://cdn-lfs.huggingface.co/repos/6b/20/6b201da5f0f5c60524535ebb7deac2eef68605655d3bbacfee9cce0087f3b3f5/e1441589a6f3c5a53f5f54d0975a18a7feb7cdf0b0dee276dfc3331ae376a053?response-content-disposition=attachment%3B%20filename%3D%22v1-5-pruned.ckpt%22&Expires=1674576457&Policy=eyJTdGF0ZW1lbnQiOlt7IlJlc291cmNlIjoiaHR0cHM6Ly9jZG4tbGZzLmh1Z2dpbmdmYWNlLmNvL3JlcG9zLzZiLzIwLzZiMjAxZGE1ZjBmNWM2MDUyNDUzNWViYjdkZWFjMmVlZjY4NjA1NjU1ZDNiYmFjZmVlOWNjZTAwODdmM2IzZjUvZTE0NDE1ODlhNmYzYzVhNTNmNWY1NGQwOTc1YTE4YTdmZWI3Y2RmMGIwZGVlMjc2ZGZjMzMzMWFlMzc2YTA1Mz9yZXNwb25zZS1jb250ZW50LWRpc3Bvc2l0aW9uPWF0dGFjaG1lbnQlM0IlMjBmaWxlbmFtZSUzRCUyMnYxLTUtcHJ1bmVkLmNrcHQlMjIiLCJDb25kaXRpb24iOnsiRGF0ZUxlc3NUaGFuIjp7IkFXUzpFcG9jaFRpbWUiOjE2NzQ1NzY0NTd9fX1dfQ__&Signature=ZKI8sOM50Ksqz9gGGusBuDq8KjAaTd3yZiY42lF72nu1~VegCS7HpSL2ribMZi1yjQ5AlhVKg2CK16axLSw--Hi-vDo-oc7I9FLDxn~yHB1~kyh0uvXsO7ctY-~KzQzruFJp7rwImdqpCWQ8XdQMk87KSpZGKnGEOeIs0L4XmFphGNWmWWjG9Axw5SrN7Xd5iGYn~2aVSTGyFGPBgqdANhmOlWeGUMJJUUSFLCIX11QrFdDB~uEdWCDSBo4sE~kx7xfyawYWkmARVIQuhbEhRcs4Q2PK3sNnmgjWc7k2m~89YRPnuutK5bxtnjLGlKhoQNxRhDXJ~hBk03-PRR4VEQ__&Key-Pair-Id=KVTP0A1DKRTAX", "stable-diffusion-webui/models/Stable-diffusion/big.ckpt");
        if (model=="small") Methods.downloadFile("https://cdn-lfs.huggingface.co/repos/6b/20/6b201da5f0f5c60524535ebb7deac2eef68605655d3bbacfee9cce0087f3b3f5/cc6cb27103417325ff94f52b7a5d2dde45a7515b25c255d8e396c90014281516?response-content-disposition=attachment%3B%20filename%3D%22v1-5-pruned-emaonly.ckpt%22&Expires=1674574957&Policy=eyJTdGF0ZW1lbnQiOlt7IlJlc291cmNlIjoiaHR0cHM6Ly9jZG4tbGZzLmh1Z2dpbmdmYWNlLmNvL3JlcG9zLzZiLzIwLzZiMjAxZGE1ZjBmNWM2MDUyNDUzNWViYjdkZWFjMmVlZjY4NjA1NjU1ZDNiYmFjZmVlOWNjZTAwODdmM2IzZjUvY2M2Y2IyNzEwMzQxNzMyNWZmOTRmNTJiN2E1ZDJkZGU0NWE3NTE1YjI1YzI1NWQ4ZTM5NmM5MDAxNDI4MTUxNj9yZXNwb25zZS1jb250ZW50LWRpc3Bvc2l0aW9uPWF0dGFjaG1lbnQlM0IlMjBmaWxlbmFtZSUzRCUyMnYxLTUtcHJ1bmVkLWVtYW9ubHkuY2twdCUyMiIsIkNvbmRpdGlvbiI6eyJEYXRlTGVzc1RoYW4iOnsiQVdTOkVwb2NoVGltZSI6MTY3NDU3NDk1N319fV19&Signature=Jr8V9c3Ggg6TwujxlrhMuk4DqNueIwco6pOIOFrnJrInz0QqWj1pnXLLYkqu7oEX8Ffh7oH4rR2gJVYqjNTwVRzkNLyrQ76ydD99ouxLlE95tZ2pcrwl1r8PNTS7BDUwUf5V8zASXM4xKICddFywkrDq1aws796pQxbH-SDaTz-DUgCOmEh~2KF44Y6WdlZU808IkxmyyduL1tXv5My8~-5NM96tbJDGmm6BoAM~xgsEECU1GE7RmqQv0GTSEzZQ1QztD9FHb1foYdua5VEfntCoAuich5lVfH-hb01osXRRLUpKYt0ASSLRAATxSr8n1SkgKvBl2ccxShUATuXHig__&Key-Pair-Id=KVTP0A1DKRTAX", "stable-diffusion/models/small.ckpt");
        System.out.println(model + " is installed");
    }
    public static void installStartBatch(){
        File file = new File("start.bat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(
                        "@echo off\n" +
                            "cd stable-diffusion-webui\n" +
                            "git pull\n" +
                            "set PYTHON=%localAppData%\\Programs\\Python\\Python310\\python.exe\n" +
                            "set GIT=\n" +
                            "set VENV_DIR=\n" +
                            "set COMMANDLINE_ARGS=\n" +
                            "call webui.bat");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}