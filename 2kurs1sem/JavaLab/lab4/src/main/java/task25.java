import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;



public class task25 {

    public static ArrayList<String> toAlbum(HashMap<String,Image> album , TreeSet<File> treeAlbum )throws IOException{

        Iterator i = treeAlbum.descendingIterator();
        ArrayList<String> newStr = new ArrayList<>(); // для тесту

        while(i.hasNext()){

            File f = (File) i.next();

            String picName = f.getName();

            picName = picName.replace(".jpg", "");

            boolean uniqKey = !album.containsKey(picName);

            if (uniqKey) {

                album.put(picName, ImageIO.read(f));
                System.out.println(picName + " is new in the Gallery");

            } else {
                newStr.add(picName);
                System.out.println(picName + " already is in the Gallery ");
            }

        }

        return newStr;
    }

    public static HashMap<String,Image> Gallery(HashMap<String,Image> album)throws IOException {

        BufferedImage LizaPic = ImageIO.read(new File("D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Mona_Lisa.jpg"));
        album.put("Liza", LizaPic);

        BufferedImage WalliPic = ImageIO.read(new File("D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Walli.jpg"));
        album.put("Walli", WalliPic);

        BufferedImage ElonPic = ImageIO.read(new File("D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Musk.jpg"));
        album.put("Elon", ElonPic);

        BufferedImage ScreamPic = ImageIO.read(new File("D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Screamjpg.jpg"));
        album.put("Scream", ScreamPic);

        BufferedImage DaliPic = ImageIO.read(new File( "D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Dali.jpg" ));
        album.put( "Dali", DaliPic );

        return album;
    }

    public static void FindPic(HashMap <String,Image> album) {


        System.out.println("\n(type \"out\" to quit) Check our Gallery  : ");

        for (String art : album.keySet()) System.out.print(art + " ");
        System.out.println();

        Scanner scan = new Scanner(System.in);
        String name;
        name = scan.nextLine();

        for(;;){

            if(name.equals("out")) break ;

            Image Im = album.get(name);

            JLabel picLabel = new JLabel(new ImageIcon(Im));
            JPanel jPanel = new JPanel();
            jPanel.add(picLabel);

            JFrame f = new JFrame();
            f.setSize(new Dimension(Im.getWidth(null), Im.getHeight(null)));
            f.add(jPanel);

            f.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            f.setVisible(true);
            name = scan.nextLine();

        }

    }

    public static TreeSet<File> FillTree(TreeSet<File> treeAlbum){

        treeAlbum.add( new File ( "D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Dali.jpg" ));
        treeAlbum.add( new File ("D:\\Objects\\JavaLab\\lab4\\src\\main\\25taskPicture\\Sodom.jpg" ));

        return treeAlbum ;
    }


    public static void main(String[] args)throws IOException{

        HashMap <String,Image> album = new HashMap<>(5);
        TreeSet<File> treeAlbum = new TreeSet<>();

        Gallery(album);

        FillTree(treeAlbum);

        toAlbum(album , treeAlbum);

        FindPic(album);

    }
}

