import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class TextEditor implements ActionListener {


    //JFfram for text editor //object create text editor
    JFrame frame;//JFrame java swing class to create a frame

    //menubar for contaniing menu
    JMenuBar menuBar;

    JMenu file,edit,format,view,help;

    //menu atom file menu
    JMenuItem newFile,openFile,saveFile;

    JMenuItem cut,copy,past,selectAll,close;

    //text area
    JTextArea textArea;


    //constructor
    TextEditor(){
//initialize frame
        frame=new JFrame();

        //initialise  text area
        textArea=new JTextArea();

        //add menubar to frame
        menuBar=new JMenuBar();

//initialise
        file = new JMenu("File");
        edit = new JMenu("Edit");
        format = new JMenu("Format");
        view = new JMenu("View");
        help = new JMenu("Help");

// initialize menu item
        newFile=new JMenuItem("New");
        openFile=new JMenuItem("Open");
        saveFile=new JMenuItem("Save");

        //add action listener to menu item
        newFile.addActionListener(this);
        openFile.addActionListener(this);
        saveFile.addActionListener(this);

        //Add menu item to file menu
        file.add(newFile);
        file.add(openFile);
        file.add(saveFile);

        //edit menu initialize
        cut=new JMenuItem("Cut");
        copy=new JMenuItem("Copy");
        past=new JMenuItem("Past");
        selectAll=new JMenuItem("select All");
        close=new JMenuItem("close Window");

        //Add action listener to edit manu item
        cut.addActionListener(this);
        copy.addActionListener(this);//this is bacicllay object of same class
        past.addActionListener(this);
        selectAll.addActionListener(this);
        close.addActionListener(this);

        //adding iteam
        edit.add(cut);
        edit.add(copy);
        edit.add(past);
        edit.add(selectAll);
        edit.add(close);


//add menu to menubar
        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(format);
        menuBar.add(view);
        menuBar.add(help);

//add menu bar to frame
        frame.setJMenuBar((menuBar));

//adding text area to frame
        frame.add(textArea);

//set page dimentions frame size
        frame.setBounds(100,100,800,500);

        frame.setVisible(true);         //make screen visible

    }
    @Override
    //action event->which action is occur when event is occur
    public void actionPerformed(ActionEvent actionEvent)
    {
        //if source is cut
        if(actionEvent.getSource()==cut){
            //perform action according to cut event
            textArea.cut();
        }
        if(actionEvent.getSource()==copy){
            //perform copy action
            textArea.copy();
        }
        if(actionEvent.getSource()==past){
            //perform paste action
            textArea.paste();
        }
        if(actionEvent.getSource()==selectAll){
            //perform selectAll action
            textArea.selectAll();
        }

        if(actionEvent.getSource()==close){
            //perform close action
            System.exit(0);
        }

        //if source is newfile
        if(actionEvent.getSource()==newFile){
            //create a new window
            TextEditor newWindow=new TextEditor();


        }

        //if source is open
        if(actionEvent.getSource()==openFile){
            //open a text file
            //initialise file chooser
            JFileChooser fileChooser=new JFileChooser("C:");
            //get choose option from file chooser
            int chooseOption=fileChooser.showOpenDialog(null);
            //if choose option is equal to approve
            if(chooseOption==JFileChooser.APPROVE_OPTION){
                //get select file
                File file=fileChooser.getSelectedFile();
                //get Selected file path
                String filepath=file.getPath();

                try{
                    BufferedReader bufferedReader=new BufferedReader(new FileReader(filepath));
                    //Create String to store content from file
                    String intermediate="",outPut="";
                    while((intermediate=bufferedReader.readLine())!=null){
                        outPut=outPut+intermediate+"\n";
                    }
                    //set out put to the text area
                    textArea.setText(outPut);
                }catch (Exception exception){
                    exception.printStackTrace();

                }
            }
        }
        //if source is save
        if(actionEvent.getSource()==saveFile){
            //save a file
            //Create a file chooser
            JFileChooser fileChooser=new JFileChooser("C:");
            //Get chooser option from file chooser
            int chooseOption= fileChooser.showOpenDialog(null);
            if(chooseOption==JFileChooser.APPROVE_OPTION)
            {
                //Create a file object with selected path
                File file =new File(fileChooser.getSelectedFile().getAbsolutePath()+".txt");

                try{
                    //Create BufferWriter to write content to file
                    BufferedWriter outfile=new BufferedWriter(new FileWriter(file));
                    //get content from text area to  outfile
                    textArea.write(outfile);
                    outfile.close();
                }catch (Exception exception){
                    exception.printStackTrace();

                }


            }
        }
    }



    public static void main(String[] args) {
        //intialize text editor
        TextEditor textEditor=new TextEditor();


    }
}