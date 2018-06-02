import foothill.DoubleUp;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by AlexP on 5/31/2018.
 */
public class MSListingView extends JFrame {

    private final int widthL,heightL,columnN,rowN;
    private JTextArea area;

    private JButton go;
    private JComboBox<String> searchLengths;
    private JLabel nameSearchProp;

    private JButton show;
    private JButton showSHF;
    private JButton clear;
    private JButton condos;
    private String defaultHeader;

    private PropertyList listOfProperties;


    public MSListingView(){
        widthL = 720;
        heightL=450;
        columnN = 60;
        rowN = 20;
        defaultHeader = String.format("%-47s %-13s %-8sOther Info","Address","Price","Year");
        activate();
    }

    public void activate(){
        setTitle("MSListing");
        setSize(widthL,heightL);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel top = new JPanel();
        JPanel center = new JPanel();
        JPanel bottom = new JPanel();

        add(top, BorderLayout.NORTH);
        add(center,BorderLayout.CENTER);
        add(bottom,BorderLayout.SOUTH);

        nameSearchProp = new JLabel("Search Property:");

        searchLengths = new JComboBox<>(new String[]{"Under 400K",
                                                     "401K-600K", "601K-800K", "800K-1M", "Over 1M"});



        go = new JButton("Go");
        go.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int type = searchLengths.getSelectedIndex();
                double start=0,end=0;
                switch(type){
                    case 0: start = 0;
                            end = 400000;
                            break;
                    case 1: start = 400001;
                            end = 600000;
                            break;
                    case 2: start = 600001;
                            end = 800000;
                            break;
                    case 3: start = 800001;
                            end = 1000000;
                            break;
                    case 4: start = 1000001;
                            end = Double.POSITIVE_INFINITY;
                            break;

                }
                area.setText(defaultHeader+"\n"+listOfProperties.searchbyPriceRange(start,end));
            }
        });
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        top.add(nameSearchProp);
        top.add(searchLengths);
        top.add(go);



        area = new JTextArea(rowN,columnN);
        area.setEditable(false);

        area.setFont(new Font("Courier New", Font.PLAIN, 12));
        area.setText(defaultHeader);
        area.setBorder(BorderFactory.createEtchedBorder());


        JScrollPane scrollbar = new JScrollPane(area);
        scrollbar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollbar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        center.add(scrollbar);

        show = new JButton("Show All");
        condos = new JButton("Show Condo");
        showSHF = new JButton("Show SFH");
        clear = new JButton("Clear");

        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(defaultHeader+"\n"+listOfProperties.getAllProperties());
            }
        });

        condos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(defaultHeader+"\n"+listOfProperties.getCondo());
            }
        });

        showSHF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(defaultHeader+"\n"+listOfProperties.getSingleFamilyHouse());
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                area.setText(defaultHeader);
            }
        });

        bottom.add(show);
        bottom.add(condos);
        bottom.add(showSHF);
        bottom.add(clear);


    }

    public void setProperty(PropertyList properties){
        listOfProperties = properties;
    }


}
