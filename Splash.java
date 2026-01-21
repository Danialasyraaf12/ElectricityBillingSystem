package electricity.billing.system;

import javax.swing.*;

public class Splash extends JFrame {

    public Splash() {
        // Setup UI
        UISetup uiSetup = new UISetup();
        uiSetup.setupUI(this);

        // Run the splash screen animation
        SplashScreenThread splashThread = new SplashScreenThread(this);
        splashThread.start();

        // Transition to the Login screen
        UserAuth userAuth = new UserAuth();
        userAuth.transitionToLogin();
    }

    public static void main(String[] args) {
        new Splash();
    }
}

public class SplashScreenThread extends Thread{
    private JFrame frame;

    public SplashScreenThread(JFrame frame){
        this.frame = frame;
    }

    public void run (){
        int x=1;
        for(int i =2; i<600; i+=4, x+=1){
            frame.setSize(i + x, i);
            frame.setLocation(700-((i + x)/2), 400 - 1 (i/2));
            try{
                Thread.sleep(10);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class UserAuth {
    public void transitionToLogin() {
        try {
            Thread.sleep(5000);  // Wait for 5 seconds (simulating splash screen duration)
            new Login();         // Transition to the Login screen
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public class UISetup {
    public void setupUI(JFrame frame) {
        // Load and scale the image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/elect.jpg"));
        Image i2 = i1.getImage().getScaledInstance(730, 550, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        
        // Create JLabel and add the image to the frame
        JLabel image = new JLabel(i3);
        frame.add(image);
        
        // Set frame visibility to true
        frame.setVisible(true);
    }
}
