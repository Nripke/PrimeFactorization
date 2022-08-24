
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.*;
import java.math.BigInteger;

public class PrimePlotter extends Application
{
    private double screenSize = 1000;
    private int xBound = 1000000;
    private double yBound = 1;
    private double dotSize = 0.5;
    private Group root = new Group();
    public void start(Stage primaryStage)
    {
      PrimeFactorization pf = new PrimeFactorization();
      ArrayList<Double> times = new ArrayList<Double>();
      
      for (int i = 2; i<xBound; i++)
      {
         long start = System.nanoTime();
         pf.factor(new BigInteger(""+i));
         long end = System.nanoTime();
         times.add(Math.sqrt(end-start));
      }
      
      for (double i : times)
      {
          if (i > yBound) {yBound = i;}
      }
      
      for (int i = 0; i<times.size(); i++)
      {
         Rectangle point = new Rectangle((i+1)*screenSize/xBound, screenSize-(times.get(i)*screenSize/yBound), 1+dotSize*times.get(i)/yBound, 1+dotSize*times.get(i)/yBound);
         root.getChildren().add(point);
      }
      
      Scene scene = new Scene(root, screenSize, screenSize);
         
      primaryStage.setTitle("Prime Plotter");
      primaryStage.setScene(scene);
      primaryStage.show();
    }
}
