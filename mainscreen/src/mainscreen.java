import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class mainscreen extends JFrame {

    // panel1 : user registration   //
    JPanel subscriberpanel;
    JTextField subname ;
    JTextField sublastname ;
    JTextField submobile;
    JTextField subcity,
     subpincode;

    JLabel namelbl,
   lastlbl,
   mobilelbl,
   citylbl,
   pincodelbl;

    //panel2 : cycle
    JTextField startcyclefld; JTextField endcyclefld;JTextField numbertvfld;

    JLabel todaylbl;
    JPanel cyclepanel;
    SimpleDateFormat df;
    Date currentdate;

    JLabel startcyclelbl;
    JLabel endcyclelbl;
    JLabel numbertvlbl;

    // panel: 3=> Channel's Package
    JCheckBox sportscheckbox;
    JCheckBox moviescheckbox;
    JCheckBox kidscheckbox;
    JPanel packagespanel;

    // panel : 4 => Packages details
    JTextArea channelareaS;
    JTextArea channelareaM;
    JTextArea channelareaK;
    JPanel detailpanels;

    // panel 5 => check and payments //
    JLabel instafeelbl;
    JPanel feepanel ;
    JLabel packagefeelbl;
    JLabel totalfeelbl;

    // panel6 table (data of subscription ) => Our Customer
    JTable table ;
    DefaultTableModel tablemodel;
    JPanel p6panel;
    //   panel 7 - action panel //

    JButton savebtn ;
    JButton loadbtn;
    JButton newbtn;
    JPanel actionpanel;

      //  class and Objects  //
    subscriber subscriber;
    subscrition subscrition;
    int packagesselectedprice=0;
    int totalprice;
      // saving   //
    ArrayList<subscrition> listtosave = new ArrayList<>();
    File file;
    // constructor
    public  mainscreen(){
        //                         panel1            //
        subscriberpanel = new JPanel();
        Border panel1title = BorderFactory.createTitledBorder("Subscriber Details");
        subscriberpanel.setBorder(panel1title);
        subscriberpanel.setBounds(15,15,300,200);
        subscriberpanel.setLayout(new GridLayout(5,3));
        // Jlabel
        namelbl = new JLabel(" First Name :");
        lastlbl = new JLabel("Last Name :");
        mobilelbl = new JLabel(" mobile no :");
        citylbl = new JLabel("City :");
        pincodelbl=  new JLabel("Pincode :");
        // Jtextfield
        subname = new JTextField();
        sublastname = new JTextField();
        submobile = new JTextField();
        subcity = new JTextField();
        subpincode = new JTextField();
        // adding components to panel1
        subscriberpanel.add(namelbl);
        subscriberpanel.add(subname);
        subscriberpanel.add(lastlbl);
        subscriberpanel.add(sublastname);
        subscriberpanel.add(mobilelbl);
        subscriberpanel.add(submobile);
        subscriberpanel.add(citylbl);
        subscriberpanel.add(subcity);
        subscriberpanel.add(pincodelbl);
        subscriberpanel.add(subpincode);
        //making opacity to components
        subname.setOpaque(false);
        sublastname.setOpaque(false);
        submobile.setOpaque(false);
        subcity.setOpaque(false);
        subpincode.setOpaque(false);

         //                  panel2                  //
       cyclepanel= new JPanel();
       cyclepanel.setLayout(new GridLayout(7,1));
       cyclepanel.setBounds(15,230,300,250);
       Border cycleborder = BorderFactory.createTitledBorder("Duration Details");
       cyclepanel.setBorder(cycleborder);
       // add the components of cycle panel
        todaylbl = new JLabel();
        df = new SimpleDateFormat("dd/MM/yyyy");
        currentdate = new Date();
        todaylbl.setText("Today:"+df.format(currentdate));

        // start  date
        startcyclelbl = new JLabel("Start  Date (DD/MM/YYYY)");
        startcyclefld = new JTextField();
        //end date
        endcyclelbl= new JLabel("End  Date (DD/MM/YYYY)");
        endcyclefld= new JTextField();
        //number of tv
        numbertvlbl = new JLabel("Number Of TV:");
        numbertvfld = new JTextField();
// adding the components to panel 2 //
        cyclepanel.add(todaylbl);
        cyclepanel.add(startcyclelbl);
        cyclepanel.add(startcyclefld);
        cyclepanel.add(endcyclelbl);
        cyclepanel.add(endcyclefld);
        cyclepanel.add(numbertvlbl);
        cyclepanel.add(numbertvfld);

// making opacity for fields
startcyclefld.setOpaque(false);
endcyclefld.setOpaque(false);
numbertvfld.setOpaque(false);

    ///              panel3                          //
        packagespanel = new JPanel();
        packagespanel.setBounds(16,500,300,200);
        packagespanel.setLayout(new GridLayout(5,1));
        Border packborder = BorderFactory.createTitledBorder("Available Packages");
        packagespanel.setBorder(packborder);
        JLabel packageslbl = new JLabel("please select your Packages");
        sportscheckbox= new JCheckBox("Sport Packages");
        moviescheckbox = new JCheckBox("Movie Packages");
        kidscheckbox = new JCheckBox("Kids Packages");
        JButton subbtn = new JButton("Subscribe");
        // adding
        packagespanel.add(packageslbl);
        packagespanel.add(sportscheckbox);
        packagespanel.add(moviescheckbox);
        packagespanel.add(kidscheckbox);
        packagespanel.add(subbtn);
        // checkbox item listener
        sportscheckbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (sportscheckbox.isSelected()){
                    Displaysportschannel();
                    // make price changes
                }else {
                    channelareaS.setText("");
                }
            }
        });
        moviescheckbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if(moviescheckbox.isSelected()){
                    Displaymovieschannel();
                }else{
                    channelareaM.setText("");
                }
            }
        });
        kidscheckbox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                if (kidscheckbox.isSelected()){
                    Displaykidschannel();
                }else {
                    channelareaK.setText("");

                }
            }
        });
        subbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    getsubscriberdata();
                }catch(Exception ee){
                }
            }
        });
        /////           panel4              ///////
        detailpanels = new JPanel();
        detailpanels.setBounds(330,15, 300,687);
        detailpanels.setLayout(new GridLayout(3,1));
        Border p4border = BorderFactory.createTitledBorder("AvailableChannel");
        detailpanels.setBorder(p4border);
        channelareaS= new JTextArea(5,1);
        channelareaS.setEditable(false);
        channelareaS.setOpaque(false);
        channelareaS.setLineWrap(true);
        channelareaM= new JTextArea(5,1);
        channelareaM.setEditable(false);
        channelareaM.setOpaque(false);
        channelareaM.setLineWrap(true);
        channelareaK= new JTextArea(5,1);
        channelareaK.setEditable(false);
        channelareaK.setOpaque(false);
        channelareaK.setLineWrap(true);
        detailpanels.add(channelareaS);
        detailpanels.add(channelareaM);
        detailpanels.add(channelareaK);
     //           panel5 check and pay       //

  feepanel = new JPanel();
  feepanel.setBounds(645,15,200,200);
  feepanel.setLayout(new GridLayout(3,1));
   Border blackline5 = BorderFactory.createTitledBorder("Fee and check");
       // TitledBorder blackline5 = BorderFactory.createTitledBorder
        //      (BorderFactory.createLineBorder(Color.red,3),
        //               " fee and check ", TitledBorder.CENTER,
        //             TitledBorder.DEFAULT_POSITION);
        feepanel.setBorder(blackline5);
  instafeelbl = new JLabel("Installation Fee : ");
  packagefeelbl = new JLabel("Packages Fee : ");
  totalfeelbl = new JLabel("Total Amount to Pay : ");
  feepanel.add(instafeelbl);
  feepanel.add(packagefeelbl);
  feepanel.add(totalfeelbl);
     //        panel6   //
        p6panel= new JPanel();
        p6panel.setBounds(645, 230, 515,500);
        p6panel.setLayout(new GridLayout(3,1));
        Border border6 = BorderFactory.createTitledBorder(" Our Customer ");
        p6panel.setBorder(border6);
   //table
     tablemodel = new DefaultTableModel();
     table = new JTable(tablemodel);
     tablemodel.addColumn("First Name ");
     tablemodel.addColumn("City");
     tablemodel.addColumn("Phone Number ");
     tablemodel.addColumn("Start Cycle");
     tablemodel.addColumn("End Cycle ");
     tablemodel.addColumn("No Of TV");
     tablemodel.addColumn("Total Fee(rs)");

// scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        p6panel.add(scrollPane);
            ///               panel 7             ////
        actionpanel = new JPanel();
        actionpanel.setBounds(860,15,300,200);
        Border border7 = BorderFactory.createTitledBorder("Action Tab");
        actionpanel.setBorder(border7);
        actionpanel.setLayout(new GridLayout(3,1));
        savebtn = new JButton("Save Subscrition");
        loadbtn = new JButton("Load Subscription");
        newbtn = new JButton("New Subscrition");
        actionpanel.add(newbtn);
        actionpanel.add(savebtn);
        actionpanel.add(loadbtn);
        newbtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newsubscription();
            }
        });

        savebtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveSubscriptiontodisk();
            }
        });
loadbtn.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        ArrayList<subscrition> k= loaddatafromdisk();
    }
});
     // adding for jframe to components 
        setLayout(null) ; // null layout for jframe;
        add(subscriberpanel); //adding panel1 to jframe
        add(cyclepanel); //adding cycle panel to jframe
         add(packagespanel); // adding packagespanel to jframe
        add(detailpanels);// adding details panel to jframe
        add(feepanel);  // adding fee panel to jframe
        add(p6panel); // adding panel6 to the jframe
        add(actionpanel);  // adding panel 7 to jframe
    }
    private ArrayList<subscrition> loaddatafromdisk() {
    ArrayList<subscrition> s = new ArrayList<>();
        file = new File("D:\\tv.dat");
    try{
        InputStream is = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(is);
        s = (ArrayList) ois.readObject();
        ois.close();
        is.close();
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (ClassNotFoundException e) {
        e.printStackTrace();
    }
for (subscrition sub:s){
    Displaysubscriptionstable(sub);
}
return s;
    }

    private void Displaysubscriptionstable(subscrition mob) {
        // Displaying Data from disk into table   //
        tablemodel.addRow(new Object[]{
                mob.getSubscriber().getFname(),
                mob.getSubscriber().getCity(),
                mob.getSubscriber().getPhone(),
                 mob.getCycle().getStartdate(),
                mob.getCycle().getEnddate(),
                mob.getNbtv(),mob.getTotalfee()
        });
    }

    private void saveSubscriptiontodisk() {
        //          get Steams ip/op             //
        listtosave.add(subscrition);
        file = new File("D:\\tv.dat");
        try{
            OutputStream os = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(os);
            // saving the list of subscrition //
            oos.writeObject(listtosave);
            oos.flush();
            oos.close();
            os.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IOError e){
            e.printStackTrace();
        }

    }
    private void newsubscription() {
        // all fields are empty
        // panel1 to empty for nw subscriber to full the requirement to the get
        // customer detail to the manager or some other worker in place
        subname.setText("");
        sublastname.setText("");
        subcity.setText("");
        submobile.setText("");
        subpincode.setText("");
        // cycle requirement to the new subscriber
        startcyclefld.setText("");
        endcyclefld.setText("");
        numbertvfld.setText("");
        // panel3 for new subscription
        instafeelbl.setText("Installation fee :");
        packagefeelbl.setText("packages fee :");
        totalfeelbl.setText("Total Amount to Pay :");
        moviescheckbox.setSelected(false);
        sportscheckbox.setSelected(false);
        kidscheckbox.setSelected(false);

    }
    private void getsubscriberdata() throws ParseException {
        Date currentdate = new Date();
        subscriber = new subscriber(subname.getText(), sublastname.getText(),
                subcity.getText(),
                Integer.parseInt(submobile.getText()),Integer.parseInt(subpincode.getText()));
        //cycle
Date startcycle = df.parse(startcyclefld.getText());
Date endcycle= df.parse(endcyclefld.getText());
 subscriptioncycle subscriptioncycle= new subscriptioncycle(
         df.format(startcycle),
         df.format(endcycle)
 );
subscrition =new subscrition(
        Integer.parseInt(numbertvfld.getText()),subscriber, subscriptioncycle,
        df.format(currentdate)
);
   instafeelbl.setText("Installation Fee : "+ subscrition.getTotalfee()+" rs");
   showprice();
    }
    private void showprice(){
        packagefeelbl.setText("package Fee: " + "  rs ");

        if(kidscheckbox.isSelected())
            packagesselectedprice += Displaykidschannel();
          else if (moviescheckbox.isSelected()) {
            packagesselectedprice += Displaymovieschannel();
        } else if (sportscheckbox.isSelected()){
              packagesselectedprice += Displaysportschannel();
        }
      packagefeelbl.setText("packages fee: "+packagesselectedprice + " rs ");
          totalprice = subscrition.getTotalfee()+packagesselectedprice;
          totalfeelbl.setText("total amount to pay: " + totalprice +" rs ");
    }
    private int  Displaymovieschannel() {
        moviechannel m1 = new moviechannel("VIJAY_TV    ","TAMIL","MOVIE",20);
        moviechannel m2 = new moviechannel("SUN_TV      ","TAMIL  ","MOVIE",20);
        moviechannel  m3 = new moviechannel("ZEE_TAMIL  ","TAMIL","MOVIE",20);
        moviechannel  m4 = new moviechannel("VIJAY MUSIC","TAMIL","MUSIC",18);
        moviechannel  m5 = new moviechannel("VIJAY SUPER","TAMIL","MOVIE",18);
        moviechannel m6 = new moviechannel("SUN MUSIC   ","TAMIL","MUSIC",17);
        moviechannel m7 = new moviechannel("K_TV        ","TAMIL","MOVIE",15);
        moviechannel m8 = new moviechannel("MAA_TV      ","TELUGU","MOVIE",8);
        moviechannel m9 = new moviechannel("TAMIL_TV   ","TAMIL","MOVIE",17);
        moviechannel m10 = new moviechannel("JAYA_TV        ","TAMIL","MOVIE",15);
        moviechannel m11 = new moviechannel("COLOR_TV      ","TELUGU","MOVIE",8);
        ArrayList<moviechannel> moviechannel = new ArrayList<>();
        moviechannel.add(m1);moviechannel.add(m2);moviechannel.add(m3);
        moviechannel.add(m4);moviechannel.add(m5);
        moviechannel.add(m6);moviechannel.add(m7);moviechannel.add(m8); moviechannel.add(m9); moviechannel.add(m10); moviechannel.add(m11);
        String movieschannelstring =" ";
        int packageprice = 1;
        for (int i = 0 ; i < moviechannel.size(); i++){
            movieschannelstring +=
                    "  "+moviechannel.get(i).getChannelname()
                            +"  "+moviechannel.get(i).getLanguage()
                            +"   "+moviechannel.get(i).getPrice()
                            +"\n";
            packageprice += moviechannel.get(i).getPrice();
        }
        channelareaM.setText(movieschannelstring);
        return packageprice ;
    }
    private int  Displaysportschannel() {
        Sportschannel m1 = new Sportschannel("STARSPORTS       ","EN   ","SPORTS",15);
        Sportschannel m2 = new Sportschannel("STARSPORTS_TAMIL  ","TAMIL","SPORTS",15);
        Sportschannel  m3 = new Sportschannel("STARSPORTS_TELUGU","TELUGU","SPORTS",16);
        Sportschannel  m4 = new Sportschannel("STARSPORTS_ENGLISH","EN  ","SPORTS",12);
        Sportschannel  m5 = new  Sportschannel("IPLCHANNEL       ","TAMIL","SPORTS",10);
         Sportschannel m6 = new Sportschannel("CRICKET_LIVE       ","TAMIL","SPORTS",15);
        Sportschannel m7 = new Sportschannel("MASTER_CRICKET        ","EN ","SPORTS",17);
        Sportschannel m8 = new Sportschannel("SPORTS_LIVE          ","TAMIL","SPORTS",8);
        ArrayList<Sportschannel> Sportschannel = new ArrayList<>();
        Sportschannel.add(m1);
        Sportschannel.add(m2);
        Sportschannel.add(m3);
        Sportschannel.add(m4);
        Sportschannel.add(m5);
        Sportschannel.add(m6);Sportschannel.add(m7);Sportschannel.add(m8);
        int packageprice = 0;
        String sportschannelstring = " ";
        for (int i = 0; i < Sportschannel.size(); i++){
            sportschannelstring +=
                            "  "+Sportschannel.get(i).getChannelname()
                            +"  "+Sportschannel.get(i).getLanguage()
                            +"   "+Sportschannel.get(i).getPrice(); //+" "+Sportschannel.get(i).getPrice() +"\n";
                         //   +"\n";
           packageprice += Sportschannel.get(i).getPrice();
        }
        channelareaS.setText(sportschannelstring);
        return packageprice ;
    }
    private int Displaykidschannel() {
           kidschannel m1 = new kidschannel("Hungama    ","Tamil","kids",15);
           kidschannel m2 = new kidschannel("Pogo       ","EN  ","kids",15);
           kidschannel  m3 = new kidschannel("Disney    ","EN ","kids",16);
           kidschannel  m4 = new kidschannel("Chutti_tv ","EN  ","kids",12);
          kidschannel  m5 = new kidschannel("Sony      ","Tamil","kids",10);
          kidschannel m6 = new kidschannel("nickelodeon","Tamil","kids",15);
          kidschannel m7 = new kidschannel("CN         ","Tamil","kids",17);
          kidschannel m8 = new kidschannel("kushi_tv    ","Tamil","kids",8);
        ArrayList<kidschannel> kidschannels = new ArrayList<>();
        kidschannels.add(m1);
        kidschannels.add(m2);
        kidschannels.add(m3);
        kidschannels.add(m4);
          kidschannels.add(m5);
          kidschannels.add(m6);kidschannels.add(m7);kidschannels.add(m8);
        String kidschannelstring ="";
        int packageprice = 0;
        for (int i = 0 ; i < kidschannels.size(); i++){
            kidschannelstring +=
                    "  "+kidschannels.get(i).getChannelname()
                            +"  "+kidschannels.get(i).getLanguage()
                            +"   "+kidschannels.get(i).getPrice()
                            +"\n";
            packageprice += kidschannels.get(i).getPrice();
        }
        channelareaK.setText(kidschannelstring);
        return packageprice;
    }

    public static void main(String[] args) {
        mainscreen mainscreen = new mainscreen();
        mainscreen.setVisible(true);
        mainscreen.setBounds(20, 10, 1200, 800);
        System.out.println(" Program successfully executed ");

    }
}
