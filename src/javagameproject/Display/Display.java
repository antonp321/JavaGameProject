
    package javagameproject.Display;

    import java.awt.Canvas;
    import java.awt.Dimension;
    import javax.swing.JFrame;

    public class Display extends Canvas{
      private int width;
      private int height;
      private String title;
      private JFrame frame;
      private Canvas canvas;
        private static Display instance;

      public Display(String title, int width, int height){
          this.width = width;
          this.height = height;
          this.title = title;
          this.createFrame();
      }

      public static Display getInstance(){

            if(instance == null){
                instance = new Display("MyFirstGame", 800, 600);
            }
          return instance;
      }

      public Canvas getCanvas() {
        return this.canvas;
    }

      private void createFrame(){
          this.frame = new JFrame(this.title);
          this.frame.setSize(this.width, this.height);
          this.frame.setResizable(false);
          this.frame.setVisible(true);
          this.frame.setLocationRelativeTo(null);
          this.frame.setFocusable(true);
          this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

          this.canvas = new Canvas();
          this.canvas.setPreferredSize(new Dimension(this.width, this.height));
          this.canvas.setMaximumSize(new Dimension(this.width, this.height));
          this.canvas.setMinimumSize(new Dimension(this.width, this.height));

          this.frame.add(this.canvas);
          this.frame.pack();
      }

    }
