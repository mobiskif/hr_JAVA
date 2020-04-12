import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;
import com.github.sarxos.webcam.WebcamResolution;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Sphere extends mComponent {
    boolean already = false;
    mComponent npanel=null;

    public Sphere(int x, int y) {
        super(x, y, "res/sphere.png");
        conf.put("title", "");
        conf.put("showLed", false);

        Sphere sphere = this;
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println(e);
                if (!already) {
                    if (e.getY()>30) {
                        npanel = new mComponent(30, 50, "res/vd6.jpg");
                        npanel.conf.put("title", "Газпром");
                    }else if (e.getX()>30) {
                        npanel = new mComponent(30, 50, "res/vd7.jpg");
                        npanel.conf.put("title", "РЖД");
                    }
                    else {
                        npanel = new mComponent(30, 50, "res/vd8.jpg");
                        npanel.conf.put("title", "Сбербанк");
                    }

                    npanel.setLocation(getX() + getWidth() + 4, getY());
                    getParent().add(npanel);
                } else {
                    npanel.offCam();
                    getParent().remove(npanel);
                }
                getParent().repaint();
                already=!already;
            }
        });
    }
}
